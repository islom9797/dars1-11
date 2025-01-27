package org.islom.dars111.service;

import org.islom.dars111.entity.Attachment;
import org.islom.dars111.entity.AttachmentContent;
import org.islom.dars111.payload.Result;
import org.islom.dars111.repository.AttachmentContentRepo;
import org.islom.dars111.repository.AttachmentRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;
import java.util.Iterator;

@Service
public class AttachmentService {
    AttachmentRepo attachmentRepo;

    AttachmentContentRepo attachmentContentRepo;

    public Result uploadFile(MultipartHttpServletRequest request) throws IOException {
        Iterator<String> iterator = request.getFileNames();
        MultipartFile file = request.getFile(iterator.next());
        Attachment attachment = new Attachment();
        attachment.setName(file.getOriginalFilename());
        attachment.setSize(file.getSize());
        attachment.setContentType(file.getContentType());
        Attachment savedAttachment = attachmentRepo.save(attachment);

        AttachmentContent attachmentContent = new AttachmentContent();
        attachmentContent.setBytes(file.getBytes());
        attachmentContent.setAttachment(savedAttachment);
        attachmentContentRepo.save(attachmentContent);
        return new Result("fayl saqlandi", true, savedAttachment.getId());


    }
}
