package uz.pdp.onlineauctiondemo.controller;

import lombok.RequiredArgsConstructor;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.onlineauctiondemo.entity.User;
import uz.pdp.onlineauctiondemo.service.AuctionService;
import uz.pdp.onlineauctiondemo.service.CurrentUser;

import java.util.UUID;

@RestController
@RequestMapping("/api/auction")
@RequiredArgsConstructor
public class AuctionController {
    private final AuctionService auctionService;

    @GetMapping("/stavka/{lotId}")
    HttpEntity<?> stavkaLot(@CurrentUser User user, @PathVariable UUID lotId) throws AuthenticationException {
        return auctionService.stavkaLotService(user, lotId);
    }

}
