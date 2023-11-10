package uz.pdp.onlineauctiondemo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.onlineauctiondemo.entity.*;
import uz.pdp.onlineauctiondemo.entity.enums.LotStatus;
import uz.pdp.onlineauctiondemo.payload.LotInput;
import uz.pdp.onlineauctiondemo.repository.LotProductRepository;
import uz.pdp.onlineauctiondemo.repository.LotRepsitory;
import uz.pdp.onlineauctiondemo.repository.UserRepository;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LotProductService {
    private final LotProductRepository lotProductRepository;
    private final UserRepository userRepository;
    private final LotRepsitory lotRepsitory;
    private final ImageService imageService;

    public LotProduct getById(UUID id) {
        return lotProductRepository.getById(id);
    }

    public List<LotProduct> getAll() {
        return lotProductRepository.findAll();
    }

    public LotProduct creatLotProdact(LotInput lotInput, UUID userId) throws IOException {
        User user = userRepository.getById(userId);
        Lot lot = new Lot();
        lot.setLotStatus(LotStatus.NEW);
        lot.setProductOwner(user);
        lot.setExpireDate(LocalDateTime.now().plusDays(7));
        lot.setPrice(lotInput.getPrice());
        lot.setStartPrice(lotInput.getPrice());
        lot.setCommission(1.5d);
        lot.setGrossPercent(1.0d);
        lotRepsitory.saveAndFlush(lot);

        List<AttachmentContent> attachmentContents = imageService.addAllPhoto(lotInput.getFiles());

        Category category = new Category();
        category.setName(lotInput.getCategoryName());

        LotProduct lotProduct = new LotProduct();
        lotProduct.setLot(lot);
        lotProduct.setCategory(category);
        lotProduct.setPhotos(attachmentContents);
        lotProduct.setHeader(lotInput.getHeader());
        lotProduct.setDescription(lotInput.getDescription());
        lotProduct.setPrice(lotInput.getPrice());

        return lotProductRepository.saveAndFlush(lotProduct);
    }

    public String deleteLotProduct(UUID productId) {
        LotProduct byId = lotProductRepository.getById(productId);
        if (byId != null) {
            lotProductRepository.delete(byId);
            return "Succses";
        }
        return null;
    }



}
