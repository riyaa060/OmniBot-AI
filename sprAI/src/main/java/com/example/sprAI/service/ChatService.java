package com.example.sprAI.service;

import com.example.sprAI.payload.CricketResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ChatService {

    @Autowired
    private ChatModel chatModel;

    public String generateResponse(String inputText) {
        String response = chatModel.call(inputText);
        return response;
    }

    public Flux<String> streamResponse(String inputText){
        Flux<String> response= chatModel.stream(inputText);
        return response;
    }

    public CricketResponse generateCricketResponse(String inputText) throws JsonProcessingException {
        String promptString="As a cricket expert.Answer this question: "+inputText+".If the above question is not related to cricket."+
                "generate one joke saying this question is out of context"+
                "Give a plain JSON response that must contain content as key and your response as value.Only return valid JSON without code blocks or additional formatting";

        ChatResponse cricketResponse = chatModel.call(
                new Prompt(promptString)
        );

        //------------get content as string
        String responseString=cricketResponse.getResult().getOutput().getText();
        ObjectMapper mapper = new ObjectMapper();
        CricketResponse cricketResponse1=mapper.readValue(responseString,CricketResponse.class);

        return cricketResponse1 ;
    }
}

