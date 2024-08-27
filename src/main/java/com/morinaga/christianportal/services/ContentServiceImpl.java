package com.morinaga.christianportal.services;

import com.morinaga.christianportal.config.ResourceNotFoundException;
import com.morinaga.christianportal.model.Content;
import com.morinaga.christianportal.repositories.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentServiceImpl implements ContentService{

    private final ContentRepository contentRepository;
    private final PasswordEncoder passwordEncoder;



    @Autowired
    public ContentServiceImpl(ContentRepository contentRepository, PasswordEncoder passwordEncoder){
        this.contentRepository = contentRepository;
        this.passwordEncoder =passwordEncoder;

    }
    @Override
    public Content saveContent(Content content){
        return contentRepository.save(content);
    }

    @Override
    public boolean checkPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }



    @Override
    public Content getContentById(Long id) {
        return contentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Content not found with id: " + id));
    }

    @Override
    public List<Content> getAllContents() {
        return contentRepository.findAll();
    }

    @Override
    public Content updateContent(Long id, Content contentDetails) {
        Content content = getContentById(id);

        content.setTitle(contentDetails.getTitle());
        content.setDescription(contentDetails.getDescription());
        content.setContentType(contentDetails.getContentType());
        content.setUploadDate(contentDetails.getUploadDate());
        content.setAuthor(contentDetails.getAuthor());
        content.setCategory(contentDetails.getCategory());
        content.setComments(contentDetails.getComments());

        return contentRepository.save(content);
    }

    @Override
    public void deleteContent(Long id) {
        contentRepository.deleteById(id);
    }



}
