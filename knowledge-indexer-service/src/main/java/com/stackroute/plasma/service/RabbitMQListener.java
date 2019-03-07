package com.stackroute.plasma.service;

import com.stackroute.plasma.model.Document;
import com.stackroute.plasma.model.Evaluator;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;

@Service
public class RabbitMQListener {

    @Autowired
    DocumentService documentService;

    @RabbitListener(queues = "${javainuse1.rabbitmq.queue}", containerFactory = "jsaFactory")
    public void consume(Evaluator evaluator){
        System.out.println("Recieved Message From RabbitMQ: " + evaluator.toString());
        Document document = new Document();
        document.setDomain(evaluator.getDomain());
        document.setConcept(evaluator.getConcept());
        document.setDescription(evaluator.getDescription());
        document.setKeywords(evaluator.getKeywords());
        document.setLevel(evaluator.getLevel());
        document.setUrl(evaluator.getUrl());
        document.setConfidenceScore(evaluator.getConfidenceScore());
        document.setTitle(evaluator.getTitle());
        document.setTimestamp(evaluator.getTimestamp().toString());
        System.out.println("sending:"+document);
        documentService.create(document);
    }
}
