package cn.tedu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import cn.tedu.client.EurekaServiceFeign;

@RestController
public class HelloController {

	@Autowired
	private EurekaServiceFeign feign;
	
	@RequestMapping("/hello/{name}")
	@HystrixCommand(fallbackMethod="helloHystrix")
	public String hello(@PathVariable String name){
		
		return feign.hello(name);
		
	}
	
	public String helloHystrix(String name){
		return "tony";
	}
	
}







