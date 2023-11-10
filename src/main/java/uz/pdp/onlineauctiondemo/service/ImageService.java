package uz.pdp.onlineauctiondemo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uz.pdp.onlineauctiondemo.entity.Attachment;
import uz.pdp.onlineauctiondemo.entity.AttachmentContent;
import uz.pdp.onlineauctiondemo.repository.AttachmentContentRepository;
import uz.pdp.onlineauctiondemo.repository.AttachmentRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ImageService {
    private final AttachmentRepository attachmentRepository;
    private final AttachmentContentRepository attachmentContentRepository;

    public AttachmentContent addImage(MultipartFile file) throws IOException {
        Attachment attachment = new Attachment();
        AttachmentContent attachmentContent = new AttachmentContent();

        attachment.setFileName(file.getName());
        attachment.setFileOriginName(file.getOriginalFilename());
        attachment.setSize(file.getSize());
        attachment.setContentType(file.getContentType());

        attachmentContent.setBytes(file.getBytes());
        attachmentContent.setAttachment(attachment);
        Attachment attachment1 = attachmentRepository.save(attachment);
        AttachmentContent attachmentContent1 = attachmentContentRepository.save(attachmentContent);
        if (attachment1 != null && attachmentContent1 != null) {
            return attachmentContent1;
        }
        return null;
    }

    public byte[] getImage(UUID id) {
        AttachmentContent byId = attachmentContentRepository.getById(id);
        return byId.getBytes();
    }

    public String deletaImage(UUID id) {
        AttachmentContent byId = attachmentContentRepository.getById(id);
        attachmentContentRepository.deleteById(id);
        attachmentRepository.deleteById(byId.getAttachment().getId());

        return "Delete Succses";
    }

    public List<AttachmentContent> addAllPhoto(List<MultipartFile> files) throws IOException {
        List<AttachmentContent> attachmentContents = new ArrayList<>();
        for (MultipartFile file : files){
           attachmentContents.add(addImage(file));
        }
        return attachmentContents;
    }
}
