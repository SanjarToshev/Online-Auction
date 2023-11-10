package uz.pdp.onlineauctiondemo.entity;



import lombok.Data;
import lombok.EqualsAndHashCode;
import uz.pdp.onlineauctiondemo.entity.template.AbsUUIDEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Category extends AbsUUIDEntity {
    @ManyToOne
    Category category;

}
