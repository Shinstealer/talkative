package com.shinstealler.talkative;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class TalkativeSpringBoot {

	public static void main(String[] args) {
		SpringApplication.run(TalkativeSpringBoot.class, args);
	}

}
