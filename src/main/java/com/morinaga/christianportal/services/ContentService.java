package com.morinaga.christianportal.services;

import com.morinaga.christianportal.model.Content;

public interface ContentService {
    Content saveContent(Content content);

    boolean checkPassword(String rawPassword, String encodedPassword);
}
