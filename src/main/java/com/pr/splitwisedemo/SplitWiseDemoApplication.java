package com.pr.splitwisedemo;

import com.pr.splitwisedemo.command.CommandExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Scanner;

@SpringBootApplication
@EnableJpaAuditing
public class SplitWiseDemoApplication implements CommandLineRunner {
	private Scanner scanner = new Scanner(System.in);

	@Autowired
	private CommandExecutor commandExecutor; // = new CommandExecutor();

	@Override
	public void run(String... args) throws Exception {
		while(true) {
			System.out.print("Enter command: ");
			String command = scanner.nextLine();
			// commandExecutor.execute(scanner.nextLine());
			commandExecutor.execute(command);
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(SplitWiseDemoApplication.class, args);
	}

}
