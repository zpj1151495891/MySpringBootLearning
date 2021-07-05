package com.didispace.chapter34;

import com.didispace.chapter34.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Chapter34Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter34Application.class, args);
	}

	@RestController
	static class TextController {

		@Autowired
		private TestService testService;


		@GetMapping("/hello")
		public String hello() {

			testService.list();

			return "hello world";
		}


		@GetMapping("/test1")
		public String test1(){
			testService.test1();
			return "success";
		}
		@GetMapping("/test2")
		public String test2(){
			testService.test2();
			return "success";
		}

		@GetMapping("/test3")
		public String test3(){
			testService.test3();
			return "success";
		}

		@GetMapping("/test4")
		public String test4(){
			testService.test4();
			return "success";
		}

		@GetMapping("/test5")
		public String test5(){
			testService.test5();
			return "success";
		}

	}

}
