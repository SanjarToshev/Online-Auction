package uz.pdp.onlineauctiondemo.entity.template;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AbsUUIDEntity extends AbsTimeAndUser {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(nullable = false)
    private String name;
    private boolean active;

}
