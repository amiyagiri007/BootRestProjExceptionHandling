package com.nt;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class BootRestProj0MiniProjectCurdOperationApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx=SpringApplication.run(
				BootRestProj0MiniProjectCurdOperationApplication.class, args);
		String [] listOfBeans = ctx.getBeanDefinitionNames();
		int beanCount=ctx.getBeanDefinitionCount();
		Arrays.sort(listOfBeans);
		
		for(String bean : listOfBeans) {
			System.out.println(bean);
		}
		System.out.println("Total Bean count:::::"+beanCount);
	}
	

}
