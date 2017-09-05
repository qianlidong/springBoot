package com.qian;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootapiApplicationTests {

	Logger logger= LoggerFactory.getLogger(getClass());
	@Test
	public void contextLoads() {
		//可以开始测试了
		Integer a=3;
		logger.info(String.format("this result is {}"),String.valueOf(a));



	}





}
