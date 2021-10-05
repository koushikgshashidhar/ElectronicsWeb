package Spring.course.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

// to tell its a spring application
@SpringBootApplication
public class CourseApiApplication {

	public static void main(String[] args) {
		//static method to run with arguments as class name and arg to the main method
		SpringApplication.run(CourseApiApplication.class, args);
	}

}
