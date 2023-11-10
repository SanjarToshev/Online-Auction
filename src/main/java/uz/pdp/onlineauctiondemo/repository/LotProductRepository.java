package uz.pdp.onlineauctiondemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.onlineauctiondemo.entity.LotProduct;

import java.util.UUID;

public interface LotProductRepository extends JpaRepository<LotProduct, UUID> {
}
