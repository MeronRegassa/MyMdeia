package com.morinaga.christianportal.controllers;

import com.morinaga.christianportal.model.Content;
import com.morinaga.christianportal.model.Member;
import com.morinaga.christianportal.repositories.ContentDTO;
import com.morinaga.christianportal.services.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/contents")
public class ContentController {

    private final ContentService contentService;

    @Autowired
    public ContentController(ContentService contentService) {
        this.contentService = contentService;
    }

//    @PostMapping("/add")
//    public ResponseEntity<Content> addContent(@RequestBody Content content) {
//        return new ResponseEntity<>(contentService.saveContent(content), HttpStatus.CREATED);
//    }
@PostMapping("/add")
public ResponseEntity<ContentDTO> addContent(@RequestBody Content content) {
    Content savedContent = contentService.saveContent(content);
    ContentDTO contentDTO = new ContentDTO(savedContent);
    return ResponseEntity.ok(contentDTO);
}


//    @PostMapping("/add")
//    public Content addMember(@RequestBody Content content) {
//        return   contentService.saveContent(content);
//    }
    @PostMapping("/create")
    public ResponseEntity<Content> createContent(@RequestBody Content content) {
        // Save the content to the database
        Content savedContent = contentService.saveContent(content);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedContent);
    }



    @GetMapping("/{contentId}")
    public ResponseEntity<Content> getContentById(@PathVariable Long contentId) {
        Content content = contentService.getContentById(contentId);
        return new ResponseEntity<>(content, HttpStatus.OK);
    }

//    @GetMapping
//    public ResponseEntity<List<Content>> getAllContents() {
//        List<Content> contents = contentService.getAllContents();
//        return new ResponseEntity<>(contents, HttpStatus.OK);
//    }


@GetMapping
    public List<ContentDTO> getAllContents() {
        return contentService.getAllContents().stream()
                .map(content -> new ContentDTO(content.getContentId(), content.getTitle(), content.getDescription(), content.getContentType(), content.getUploadDate()))
                .collect(Collectors.toList());
    }

    @PutMapping("/update/content/{contentId}")
    public ResponseEntity<Content> updateContent(@PathVariable Long contentId, @RequestBody Content contentDetails) {
        Content updatedContent = contentService.updateContent(contentId, contentDetails);
        return new ResponseEntity<>(updatedContent, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{contentId}")
    public ResponseEntity<Void> deleteContent(@PathVariable Long contentId) {
        contentService.deleteContent(contentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
