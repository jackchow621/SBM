package com.ghost;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
//@Configuration
//@ComponentScan
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

	
	@RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(getClass());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		SpringApplication.run(Application.class, args);
	}

}
