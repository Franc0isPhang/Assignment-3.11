package sg.ntu.edu.demo;

import java.util.Scanner;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NotificationApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationApplication.class, args);
	}

	/*
		TODO:		
		- Create a @PostConstruct method to be executed after spring container has completed configuration.
		- Invite input using Scanner and System.in for value "to" and "message".
		- Set the input to setup(string, string) method in NotificationService.java.
		- Invoke send() method in Notification.java.
	*/
	@Autowired
    private NotificationService notificationService;
	
	@PostConstruct //a method should be invoked immediately after a bean (an instance of a Spring-managed class) has been created and configured by the Spring container
    public void init() {
        Scanner scanner = new Scanner(System.in); //creation of a new scanner object that allows u to read user input
        System.out.println("Enter 'to' value:"); 
        String to = scanner.nextLine();
        System.out.println("Enter 'message' value:");
        String message = scanner.nextLine();
        
        notificationService.setup(to, message);
        notificationService.send();
    }
}
