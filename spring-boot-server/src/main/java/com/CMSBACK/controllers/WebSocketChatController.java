package com.CMSBACK.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;

import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin(origins = "*", maxAge = 3600)

@Controller
public class WebSocketChatController {
	  @MessageMapping("/resume")
	    @SendTo("/start/initial")
	    public String chat(String msg) {
	        System.out.println(msg);
	        return msg;
	    }
}
