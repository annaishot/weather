package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class DemoApplicationTests {

	@Autowired WeatherService service;

	@Test
	public void getTest(){
		Assert.notNull(service.getData("Sydney"));
	}
}
