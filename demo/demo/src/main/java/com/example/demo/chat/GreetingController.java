package com.example.demo.chat;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {
	
	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public Greeting greeting(HelloMessage message) throws Exception {
		Thread.sleep(1000); // simulated delay
	    return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
	    //Greeting 객체로 만든 후 넘김
	    //서버와 데이터 주고받기 위해 HelloMessage, Greeting 사용하고 있음. 데이터 형태는 json임
	}
}
