package uz.pdp.onlineauctiondemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.onlineauctiondemo.entity.Lot;

import java.util.UUID;

public interface LotRepsitory extends JpaRepository<Lot, UUID> {

}
