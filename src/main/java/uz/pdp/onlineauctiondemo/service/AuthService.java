package uz.pdp.onlineauctiondemo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.onlineauctiondemo.entity.Roles;
import uz.pdp.onlineauctiondemo.entity.User;
import uz.pdp.onlineauctiondemo.entity.enums.RoleName;
import uz.pdp.onlineauctiondemo.payload.SignIn;
import uz.pdp.onlineauctiondemo.payload.SignUp;
import uz.pdp.onlineauctiondemo.repository.UserRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class AuthService {


    private final UserRepository userRepository;



    public User login(SignIn signIn) {
        User byEmailOrPhoneNumber = userRepository.findByEmailOrPhoneNumber(signIn.getUsername(), signIn.getUsername());
        if (byEmailOrPhoneNumber.getPassword().equals(signIn.getPassword())) {
            return byEmailOrPhoneNumber;
        }
        return null;
    }

    public User register(SignUp signUp) {
        User user = new User();
        user.setName(signUp.getName());
        user.setEmail(signUp.getEmail());
        user.setPhoneNumber(signUp.getPhoneNumber());
        user.setPassword(signUp.getPassword());
        user.setBalance(BigDecimal.valueOf(0));
        user.setActive(true);
        user.setRoles(RoleName.USER);
        return userRepository.saveAndFlush(user);
    }
}
