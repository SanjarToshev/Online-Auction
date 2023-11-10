package uz.pdp.onlineauctiondemo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.onlineauctiondemo.entity.enums.PayStatus;
import uz.pdp.onlineauctiondemo.entity.enums.PayType;
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
public class Payment extends AbsUUIDEntity {
    @ManyToOne
    User user;
    @Column(precision = 2)
    @DecimalMin(value = "10000.00")
    BigDecimal paySum;
    @Enumerated(EnumType.STRING)
    PayStatus payStatus;
    @Enumerated(EnumType.STRING)
    PayType payType;
    @ManyToOne
    LotWarranty lotWarranty;
    @ManyToOne
    LotWinner paidForLot;
    @Column(nullable = false)
    LocalDateTime paymentDate;

}
