package uz.pdp.onlineauctiondemo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.onlineauctiondemo.entity.template.AbsUUIDEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LotProduct extends AbsUUIDEntity {
    @ManyToOne
    Lot lot;
    @ManyToOne
    Category category;
    @OneToMany
    List<AttachmentContent> photos;
    @Column
    String header;
    @Column
    String description;
    @Column
    BigDecimal price;

}
