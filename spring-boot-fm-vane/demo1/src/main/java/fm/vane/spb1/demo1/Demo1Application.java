package fm.vane.spb1.demo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import fm.vane.spb1.demo1.controllers.RootController;

@SpringBootApplication
// @ComponentScan(basePackageClasses = RootController.class)
public class Demo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
		System.out.println("hello im spring boot, im running!!!");
	}

}
