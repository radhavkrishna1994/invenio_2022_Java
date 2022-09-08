package com.training.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguraion {
	
	@Value("${queue}")
	private String queue;
	
	@Value("${queue1}")
	private String queue1;
	
	@Bean(name="queue")
	public ActiveMQQueue getActiveMQ1()
	{
		return new ActiveMQQueue(queue);
	}
	
	@Bean(name="queue1")
	public ActiveMQQueue getActiveMQ()
	{
		return new ActiveMQQueue(queue1);
	}
	

	

}
