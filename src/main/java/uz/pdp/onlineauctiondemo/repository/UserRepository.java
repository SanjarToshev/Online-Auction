package uz.pdp.onlineauctiondemo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.onlineauctiondemo.entity.User;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    User findByEmailOrPhoneNumber(String email, String phoneNumber);

}
