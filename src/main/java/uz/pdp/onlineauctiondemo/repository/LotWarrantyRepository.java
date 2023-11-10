package uz.pdp.onlineauctiondemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.onlineauctiondemo.entity.Lot;
import uz.pdp.onlineauctiondemo.entity.LotWarranty;

import java.util.Optional;
import java.util.UUID;

public interface LotWarrantyRepository extends JpaRepository<LotWarranty, UUID> {

    Optional<LotWarranty> findAllByLotAndActiveTrue(Lot lotById);
}
