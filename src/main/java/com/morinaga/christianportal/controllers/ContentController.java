package com.morinaga.christianportal.controllers;

import com.morinaga.christianportal.model.Content;
import com.morinaga.christianportal.services.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contents")
public class ContentController {

    private final ContentService contentService;

    @Autowired
    public ContentController(ContentService contentService) {
        this.contentService = contentService;
    }

    @PostMapping("/add")
    public ResponseEntity<Content> addContent(@RequestBody Content content) {
        return new ResponseEntity<>(contentService.saveContent(content), HttpStatus.CREATED);
    }
}
