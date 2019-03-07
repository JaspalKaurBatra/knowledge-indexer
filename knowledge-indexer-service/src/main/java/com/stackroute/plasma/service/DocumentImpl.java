package com.stackroute.plasma.service;

import com.stackroute.plasma.model.Document;
import com.stackroute.plasma.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentImpl implements DocumentService {

    @Autowired
    DocumentRepository documentRepository;

    @Override
    public void create(Document document) {
        String timestamp = document.getTimestamp().toString();
        String concept = document.getConcept();
        String domain = document.getDomain();
        String descript = document.getDescription();
        String title = document.getTitle();
        String url = document.getUrl();
        String keywords = document.getKeywords();
        String level = document.getLevel();
        float confidenceScore= document.getConfidenceScore();
        documentRepository.create(timestamp,domain,concept,title,descript,keywords,url,level,confidenceScore);
    }
}
