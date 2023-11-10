package uz.pdp.onlineauctiondemo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.onlineauctiondemo.entity.enums.LotStatus;
import uz.pdp.onlineauctiondemo.entity.template.AbsUUIDEntity;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lot extends AbsUUIDEntity {
    @Enumerated(EnumType.STRING)
    LotStatus lotStatus;
    @ManyToOne(optional = false)
    User productOwner;
    @Column(nullable = false)
    LocalDateTime expireDate;
    @Column(nullable = false, precision = 2)
    @DecimalMin(value = "10000.00")
    BigDecimal price;
    @Column(nullable = false, precision = 2)
    @DecimalMin(value = "10000.00")
    BigDecimal startPrice;
    @Column(precision = 2)
    double commission;
    @Column(precision = 2)
    double grossPercent;
}
