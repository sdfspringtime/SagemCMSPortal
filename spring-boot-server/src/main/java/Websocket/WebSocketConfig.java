package Websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
@Component
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) { 
	    config.setApplicationDestinationPrefixes("/app")
		  .enableSimpleBroker("/topic","/start");
	}
	
	@Override public void registerStompEndpoints(StompEndpointRegistry registry) { 
		registry.addEndpoint("/websocket","/testchat") 
		
			.setAllowedOrigins("*")  
			.withSockJS();
	}
}