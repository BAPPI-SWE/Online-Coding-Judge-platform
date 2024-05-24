package main;

import models.Problem;
import models.User;
import services.UserService;
import services.ProblemService;

import java.util.Scanner;

public class App {
    private static UserService userService = new UserService();
    private static ProblemService problemService = new ProblemService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("...........WELCOME TO WORLD OF CODING PROBLEM........");
        System.out.println("------ THIS SYSTEM IS DEVELOPED BY BAPPI  -----");
        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Add Problem");
            System.out.println("4. View Problems");
            System.out.println("5. Rate Problem");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    if (userService.register(username, password, email)) {
                        System.out.println("User registered successfully!");
                    } else {
                        System.out.println("Username already exists.");
                    }
                    break;
                case 2:
                    System.out.print("Enter username: ");
                    String loginUsername = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String loginPassword = scanner.nextLine();
                    User user = userService.login(loginUsername, loginPassword);
                    if (user != null) {
                        System.out.println("Login successful!");
                    } else {
                        System.out.println("Invalid username or password.");
                    }
                    break;
                case 3:
                    System.out.print("Enter problem title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter problem description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter problem difficulty (Easy, Medium, Hard): ");
                    String difficulty = scanner.nextLine();
                    problemService.addProblem(title, description, difficulty);
                    System.out.println("Problem added successfully!");
                    break;
                case 4:
                    System.out.println("Problems:");
                    for (Problem problem : problemService.getProblems()) {
                        System.out.println("Title: " + problem.getTitle() + ", Difficulty: " + problem.getDifficulty() + ", Rating: " + problem.getRating());
                    }
                    break;
                case 5:
                    System.out.print("Enter problem title: ");
                    String rateTitle = scanner.nextLine();
                    System.out.print("Enter rating (0.0 - 5.0): ");
                    double rating = scanner.nextDouble();
                    problemService.rateProblem(rateTitle, rating);
                    System.out.println("Problem rated successfully!");
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
