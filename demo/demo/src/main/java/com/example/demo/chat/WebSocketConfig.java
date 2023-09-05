package com.example.demo.chat;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
//스프링은 socket.xml사용함. 부트에서는 EnableWeb 어노테이션이 웹소켓 사용할 수 있도록 설정 다 해줌
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer{
	@Override
	  public void configureMessageBroker(MessageBrokerRegistry config) {
	    config.enableSimpleBroker("/topic");	//구독신청(받는 거)
	    config.setApplicationDestinationPrefixes("/app");	//소켓 메시지 전송(보내는 거)
	  }

	  @Override
	  public void registerStompEndpoints(StompEndpointRegistry registry) {
	    registry.addEndpoint("/chatserver");	//소켓 서버 연결할 url
	  }
}
