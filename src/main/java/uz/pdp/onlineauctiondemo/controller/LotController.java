package uz.pdp.onlineauctiondemo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.onlineauctiondemo.entity.Lot;
import uz.pdp.onlineauctiondemo.service.LotService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/lot")
@RequiredArgsConstructor
public class LotController {

    private final LotService lotService;

    @GetMapping("/{id}")
    HttpEntity<?> getById(@PathVariable UUID id) {
        Lot lot = lotService.getLot(id);
        return ResponseEntity.status(lot != null ? 200 : 401).body(lot);
    }

    @GetMapping("/getAll")
    HttpEntity<List<Lot>> getAll(){
        List<Lot> lots = lotService.getAll();
        return ResponseEntity.status(lots.size() == 0 ? 200 : 401).body(lots);
    }



}
