package uz.pdp.onlineauctiondemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.onlineauctiondemo.entity.AttachmentContent;

import java.util.UUID;

public interface AttachmentContentRepository extends JpaRepository<AttachmentContent, UUID> {

}
