package uz.pdp.onlineauctiondemo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.onlineauctiondemo.entity.User;
import uz.pdp.onlineauctiondemo.payload.SignIn;
import uz.pdp.onlineauctiondemo.payload.SignUp;
import uz.pdp.onlineauctiondemo.service.AuthService;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @GetMapping("/")
    public String getHello(){
        return "Hello Online Auction";
    }


    @PostMapping("/login")
    HttpEntity<User> login(SignIn signIn) {
        User user = authService.login(signIn);
        return ResponseEntity.status(user != null ? 200 : 401).body(user);
    }

    @PostMapping("/register")
    HttpEntity<User> register(@RequestBody SignUp signUp){
        User register = authService.register(signUp);
        return ResponseEntity.status(register != null ? 200 : 401).body(register);
    }


}
