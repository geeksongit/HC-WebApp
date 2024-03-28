package com.geeksongit.HCWebApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.FlushMode;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@EnableRedisHttpSession(
		flushMode = FlushMode.IMMEDIATE, 
		redisNamespace = "REDIS_SESSION"
		,maxInactiveIntervalInSeconds = 1800
		)
public class HcWebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(HcWebAppApplication.class, args);
	}

}
