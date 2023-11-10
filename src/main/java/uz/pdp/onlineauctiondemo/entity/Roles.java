package uz.pdp.onlineauctiondemo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.onlineauctiondemo.entity.enums.RoleName;
import uz.pdp.onlineauctiondemo.entity.template.AbsUUIDEntity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Roles extends AbsUUIDEntity {
    @Enumerated(EnumType.STRING)
    RoleName roleName;
}
