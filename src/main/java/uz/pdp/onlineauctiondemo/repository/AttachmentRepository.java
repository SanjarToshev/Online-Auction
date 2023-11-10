package uz.pdp.onlineauctiondemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.onlineauctiondemo.entity.Attachment;

import java.util.UUID;

public interface AttachmentRepository extends JpaRepository<Attachment, UUID> {


}
