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
public class AttachmentContent {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(nullable = false)
    private byte[] bytes;
    @OneToOne(optional = false)
    private Attachment attachment;
}
