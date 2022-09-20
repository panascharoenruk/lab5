package com.example.lab5;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class SentenceConsumer {
    public Sentence sentences = new Sentence();

    @RabbitListener(queues = "BadWordQueue")
    public void addBadSentence(String s){
        sentences.badSentences.add(s);
        System.out.println("In addBadSentence Method : " + sentences.badSentences);
    }

    @RabbitListener(queues = "GoodWordQueue")
    public void addGoodSentence(String s){
        sentences.goodSentences.add(s);
        System.out.println("In addGoodSentence Method : " + sentences.goodSentences);
    }
}