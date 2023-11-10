package uz.pdp.onlineauctiondemo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.onlineauctiondemo.entity.UserCardInfo;
import uz.pdp.onlineauctiondemo.payload.CardInfoInput;
import uz.pdp.onlineauctiondemo.service.UserCardInfoServive;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/card")
public class UserCardInfoController {
    private final UserCardInfoServive userCardInfoServive;

    @PostMapping("/addCard/{userId}")
    HttpEntity<?> addCard(@RequestBody CardInfoInput cardInfoInput, @PathVariable UUID userId){
        UserCardInfo userCardInfo = userCardInfoServive.addCard(cardInfoInput, userId);
        if (userCardInfo != null) {
            System.out.println(userCardInfo);
        }

        return ResponseEntity.status(HttpStatus.OK).body(userCardInfo);
    }

    @GetMapping("/getCard/{cardId}")
    HttpEntity<?> getCard(@PathVariable UUID cardId) {
        UserCardInfo userCardInfo = userCardInfoServive.getCard(cardId);
        return ResponseEntity.status(HttpStatus.OK).body(userCardInfo);
    }

    @GetMapping("getAllCard")
    HttpEntity<?> getAllCard() {
        List<UserCardInfo> userCardInfos = userCardInfoServive.getAllCard();
        return ResponseEntity.status(!userCardInfos.isEmpty() ? 200 : 500).body(userCardInfos);
    }

    @DeleteMapping("/deleteCard/{cardId}")
    HttpEntity<?> deleteCard(@PathVariable UUID cardId) {
        String s = userCardInfoServive.deleteCard(cardId);
        return ResponseEntity.status(HttpStatus.OK).body(s);
    }



}
