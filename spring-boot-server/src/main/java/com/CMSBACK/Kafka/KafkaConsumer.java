package com.CMSBACK.Kafka;

import java.io.IOException;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.core.MessageSendingOperations;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.sockjs.client.SockJsClient;

import com.CMSBACK.models.Model;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Websocket.Constants;
import lombok.var;

@Component
public class KafkaConsumer {
	@Autowired
	private final SimpMessagingTemplate webSocket;
	
public KafkaConsumer(SimpMessagingTemplate msgTemplate) {
this.webSocket=msgTemplate;}
/*	private static final Logger LOG = LoggerFactory.getLogger(KafkaConsumer.class);
    
	private SimpMessagingTemplate webSocket;

	@KafkaListener(id="foo",topics = Constants.KAFKA_TOPIC)
	public void processMessage(ConsumerRecord<String, Model> cr, @Payload Model content) {
		LOG.info("Received content from Kafka: {}", content);

		this.webSocket.convertAndSend(Constants.WEBSOCKET_DESTINATION, content.getMessage());
	}*/
	
	private static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);
	  @KafkaListener(id="foo",topics = "testdb.testdb.lines_p")
      public void listen(String payload) throws JsonParseException, JsonMappingException, IOException  {

          logger.info("Message Received from Kafka topic: {}", payload);

          ObjectMapper objectMapper = new ObjectMapper();
          objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

          dtoObject dtoObject = objectMapper.readValue(payload,dtoObject.class);

             String msg=objectMapper.writeValueAsString(dtoObject);
             
           this.webSocket.convertAndSend("/topic/messages",msg);
}
	  }

