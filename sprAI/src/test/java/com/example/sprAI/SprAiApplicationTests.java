package com.example.sprAI;

import com.example.sprAI.payload.CricketResponse;
import com.example.sprAI.service.ChatService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SprAiApplicationTests {


    @Autowired
    private ChatService chatService;

	@Test
	void contextLoads() throws JsonProcessingException {
        CricketResponse cricketResponse= chatService.generateCricketResponse("Who is Sachin Tendulkar");
        System.out.print(cricketResponse);
	}

}
