package uz.pdp.onlineauctiondemo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.onlineauctiondemo.entity.template.AbsUUIDEntity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class LotWarranty extends AbsUUIDEntity {
    @ManyToOne
    Lot lot;
    @ManyToOne
    User user;
    @Column
    BigDecimal warrantySum;
    @Column
    BigDecimal commission;
    @Column
    BigDecimal totalWarranty;
}
