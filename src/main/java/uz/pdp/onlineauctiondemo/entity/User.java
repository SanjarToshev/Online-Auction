package uz.pdp.onlineauctiondemo.entity;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.onlineauctiondemo.entity.enums.RoleName;
import uz.pdp.onlineauctiondemo.entity.template.AbsUUIDEntity;


import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User extends AbsUUIDEntity {
    @Column(nullable = false, unique = true)
    String email;
    @Column(nullable = false, unique = true)
    String phoneNumber;
    @Column(nullable = false)
    @Size(min = 6)
    String password;
    @Column(precision = 2)
    @DecimalMin(value = "0.00")
    BigDecimal balance;
    @Enumerated(EnumType.STRING)
    RoleName roles;

}
