package uz.pdp.onlineauctiondemo.entity;


import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.onlineauctiondemo.entity.enums.LotStatus;
import uz.pdp.onlineauctiondemo.entity.template.AbsUUIDEntity;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LotWinner extends AbsUUIDEntity {
    @ManyToOne
    Lot lot;
    @ManyToOne
    User user;
    @Column(nullable = false)
    BigDecimal winPrice;
    @Column
    BigDecimal totalPaid;
    @Column
    LocalDateTime expirePayment;
    @Enumerated(EnumType.STRING)
    LotStatus status;
}
