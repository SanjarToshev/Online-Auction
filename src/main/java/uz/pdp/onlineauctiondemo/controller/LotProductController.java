package uz.pdp.onlineauctiondemo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uz.pdp.onlineauctiondemo.entity.AttachmentContent;
import uz.pdp.onlineauctiondemo.entity.LotProduct;
import uz.pdp.onlineauctiondemo.payload.LotInput;
import uz.pdp.onlineauctiondemo.service.ImageService;
import uz.pdp.onlineauctiondemo.service.LotProductService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/lotProduct")
@RequiredArgsConstructor
public class LotProductController {
    private final LotProductService lotProductService;
    private final ImageService imageService;

    @GetMapping("/")
    HttpEntity<LotProduct> getById(@PathVariable UUID id){
        LotProduct lotProduct = lotProductService.getById(id);
        return ResponseEntity.status(lotProduct != null ? 200 : 401).body(lotProduct);
    }

    @GetMapping("/getAll")
    HttpEntity<List<LotProduct>> getAll(){
        List<LotProduct> lotProducts = lotProductService.getAll();
        return ResponseEntity.status(!lotProducts.isEmpty() ? 200 : 401).body(lotProducts);
    }

    @PostMapping("/addLotProduct/{id}")
    HttpEntity<?> addLotProduct(@RequestBody LotInput lotInput, UUID userId) throws IOException {
        LotProduct lotProduct = lotProductService.creatLotProdact(lotInput, userId);
        return ResponseEntity.status(HttpStatus.OK).body(lotProduct);
    }

    @PostMapping("/addImage")
    HttpEntity<?> addImage(@RequestParam("image") MultipartFile file) throws IOException {
        AttachmentContent uploadImage = imageService.addImage(file);
        return ResponseEntity.status(uploadImage != null ? 200 : 404).body(uploadImage);
    }


    @GetMapping("/getImage/{id}")
    HttpEntity<?> getImage(@PathVariable UUID id){
        byte[] imageData = imageService.getImage(id);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf(MediaType.IMAGE_PNG_VALUE))
                .body(imageData);
    }

    @DeleteMapping("/deleteImage/{id}")
    HttpEntity<?> deleteImage(@PathVariable UUID id) {
        String deleted = imageService.deletaImage(id);
        return ResponseEntity.status(HttpStatus.OK).body(deleted);
    }

    @DeleteMapping("/deleteLotProduct/{productId}")
    HttpEntity<?> deleteLotProduct(@PathVariable UUID productId){
        String s = lotProductService.deleteLotProduct(productId);
        return ResponseEntity.status(s != null ? 200 : 500).body(s);
    }

}
