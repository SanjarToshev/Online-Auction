package uz.pdp.onlineauctiondemo.entity.template;

import lombok.Data;
import org.springframework.data.annotation.*;
import javax.persistence.MappedSuperclass;
import java.security.Timestamp;
import java.util.UUID;

@Data
@MappedSuperclass
public class AbsTimeAndUser {
    @CreatedBy
    private UUID createdId;
    @LastModifiedBy
    private UUID lastModifiedId;
    @CreatedDate
    private Timestamp createdAt;

}
