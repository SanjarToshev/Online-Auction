package uz.pdp.onlineauctiondemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.onlineauctiondemo.entity.UserCardInfo;

import java.util.UUID;

public interface UserCardInfoRepository extends JpaRepository<UserCardInfo, UUID> {
}
