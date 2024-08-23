package com.morinaga.christianportal.services;

import com.morinaga.christianportal.model.Content;
import com.morinaga.christianportal.repositories.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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

}
