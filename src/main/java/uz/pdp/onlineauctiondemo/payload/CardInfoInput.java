package uz.pdp.onlineauctiondemo.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardInfoInput {
    String name;
    String cardNumber;
    String expire;

}
