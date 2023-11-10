package uz.pdp.onlineauctiondemo.service;

import lombok.RequiredArgsConstructor;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.pdp.onlineauctiondemo.entity.Lot;
import uz.pdp.onlineauctiondemo.entity.LotWarranty;
import uz.pdp.onlineauctiondemo.entity.User;
import uz.pdp.onlineauctiondemo.exceptions.AuctionTimeException;
import uz.pdp.onlineauctiondemo.repository.LotRepsitory;
import uz.pdp.onlineauctiondemo.repository.LotWarrantyRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuctionService {
    private final LotWarrantyRepository lotWarrantyRepository;
    private final LotRepsitory lotRepsitory;


    public HttpEntity<?> stavkaLotService(User user, UUID lotId) throws AuthenticationException {
        Lot lotById = lotRepsitory.getById(lotId);

        if (lotById.getExpireDate().isAfter(LocalDateTime.now())) {
            throw new AuctionTimeException(); //Auction vaqti tugagan
        } else {
            BigDecimal price = lotById.getPrice();
            double grossPercent = lotById.getGrossPercent();
            double commission = lotById.getCommission();
            BigDecimal newPrice = BigDecimal.valueOf(1 + (commission + grossPercent) / 100).multiply(price);
            BigDecimal newCommission = newPrice.multiply(BigDecimal.valueOf(commission / 100));
            BigDecimal newWarrantySum = newPrice.multiply(BigDecimal.valueOf(grossPercent / 100));
            BigDecimal newTotalWaranty = newCommission.add(newWarrantySum);
            int compareTo = newCommission.compareTo(user.getBalance());

            if (compareTo >= 0) {
                Optional<LotWarranty> lotWarranty = lotWarrantyRepository.findAllByLotAndActiveTrue(lotById);
                if (lotWarranty.isPresent()) {
                    if (!lotWarranty.get().getUser().getId().equals(user.getId())) {
                        if (lotById.getExpireDate().isBefore(LocalDateTime.now().plusMinutes(10))) {
                            lotById.setExpireDate(lotById.getExpireDate().plusMinutes(10));
                            lotRepsitory.save(lotById);
                        }
                        LotWarranty lotWarranty1 = lotWarranty.get();
                        lotWarranty1.getUser().setBalance(lotWarranty1.getUser().getBalance().add(lotWarranty1.getTotalWarranty()));
                        lotWarranty1.setActive(false);

                        LotWarranty newLotWarranty = new LotWarranty();
                        newLotWarranty.setLot(lotById);
                        user.setBalance(user.getBalance().subtract(newCommission));
                        newLotWarranty.setUser(user);
                        newLotWarranty.setWarrantySum(newWarrantySum);
                        newLotWarranty.setCommission(newCommission);
                        newLotWarranty.setTotalWarranty(newTotalWaranty);
                        lotWarrantyRepository.save(newLotWarranty);
                    } else {
                        throw new AuthenticationException("Bundan oldin ham uzinggiz narxni oshirgansiz");
                    }
                } else {
                    LotWarranty lotWarrantyy = new LotWarranty();
                    lotWarrantyy.setLot(lotById);
                    lotWarrantyy.setUser(user);
                    lotWarrantyy.setWarrantySum(newWarrantySum);
                    lotWarrantyy.setCommission(newCommission);
                    lotWarrantyy.setTotalWarranty(newTotalWaranty);
                    lotWarrantyRepository.save(lotWarrantyy);
                }
            } else {
                throw new AuctionTimeException();

            }
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Hammasi Yaxshi Buladi Sen O'ylama Butaloq");
    }
}
