package uz.pdp.onlineauctiondemo.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LotInput {
    List<MultipartFile> files;
    String categoryName;
    String header;
    String description;
    BigDecimal price;
}
