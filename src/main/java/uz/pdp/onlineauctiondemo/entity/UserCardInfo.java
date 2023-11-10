package uz.pdp.onlineauctiondemo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.onlineauctiondemo.entity.template.AbsUUIDEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Pattern;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCardInfo extends AbsUUIDEntity {
    @ManyToOne
    User user;
    @Column(nullable = false)
    @Pattern(regexp = "[0-9]{16}")
    String cardNumber;
    @Column
    @Pattern(regexp = "[0-9]{2}/[0-9]{2}")
    String expire;


}
