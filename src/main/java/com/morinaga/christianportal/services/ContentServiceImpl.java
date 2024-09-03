package com.morinaga.christianportal.services;

import com.morinaga.christianportal.config.ResourceNotFoundException;
import com.morinaga.christianportal.model.Category;
import com.morinaga.christianportal.model.Comment;
import com.morinaga.christianportal.model.Content;
import com.morinaga.christianportal.repositories.CategoryRepository;
import com.morinaga.christianportal.repositories.CommentRepository;
import com.morinaga.christianportal.repositories.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentServiceImpl implements ContentService{

    private final ContentRepository contentRepository;
    private final PasswordEncoder passwordEncoder;
    private final CommentRepository commentRepository;
    private final CategoryRepository categoryRepository;
//


    @Autowired
    public ContentServiceImpl(ContentRepository contentRepository, PasswordEncoder passwordEncoder, CommentRepository commentRepository, CategoryRepository categoryRepository){
        this.contentRepository = contentRepository;
        this.passwordEncoder =passwordEncoder;
        this.commentRepository = commentRepository;
        this.categoryRepository = categoryRepository;
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
    public Comment addCommentToContent(Long id, Comment comment) {
        return commentRepository.save(comment);

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

//    public Content saveAllContentDetails(Content content, List<Comment> comments, Category category) {
//        // Save the category first
//        Category savedCategory = categoryRepository.save(category);
//        content.setCategory(savedCategory);
//
//        // Save the content
//        Content savedContent = contentRepository.save(content);
//
//        // Save all comments related to the content
//        for (Comment comment : comments) {
//            comment.setContent(savedContent);
//            commentRepository.save(comment);
//        }
//
//        return savedContent;
//    }

}
