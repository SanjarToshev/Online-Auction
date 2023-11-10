package uz.pdp.onlineauctiondemo.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Attachment {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(nullable = false)
    private String fileName;
    @Column(nullable = false)
    private String fileOriginName;
    private long size;
    @Column(nullable = false)
    private String contentType;

}
