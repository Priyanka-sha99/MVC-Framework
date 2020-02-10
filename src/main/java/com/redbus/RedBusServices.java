package com.redbus;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;


@SpringBootApplication
@EnableCaching(proxyTargetClass = true)

public class RedBusServices {

	   @PostConstruct
       void setUTCTimezone(){
           TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
       }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(RedBusServices.class, args);
	}

}
