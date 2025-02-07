package com.nt.commons;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@Data
@ConfigurationProperties(prefix = "actor.module")
public class ActorConfiProperties {

	private Map<String, String> messages;
}
