/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;
import java.util.ArrayList;
import java.util.Scanner;
public class JavaProject {
    static ArrayList<User> users = new ArrayList<>(); 
    static ArrayList<Event> events = new ArrayList<>();
    
     // @param args the command line arguments
     
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); // Scans command line entries
        User user = null;
        
        // Default users and events
        users.add(Admin.getInstance());
        users.add(new Coach("coach1", "pass"));
        users.add(new Coach("coach2", "pass"));
        users.add(new Swimmer("swimmer1", "pass"));
        users.add(new Swimmer("swimmer2", "pass"));
        events.add(new Event("event1"));
        events.add(new Event("event2"));
        
        // Main title screen
        System.out.println("Welcome to the Swim Club Enrollment System. Please login to continue. \nFor help, type \"help\" and press enter." );
        
        while (true)
        {
            if(scan.hasNextLine())
            {
                String line = scan.nextLine();
                String[] tokens = line.split(" ");
                
                if("exit".equals(tokens[0].toLowerCase())) {
                    break;
                } else if("help".equals(tokens[0].toLowerCase())) {
                    System.out.println("\nThe Basic Commands Include:");
                    System.out.println("-----------------------------");
                    System.out.println("exit: Exit the application.");
                    System.out.println("help: Print available commands.");
                    System.out.println("login: Login to an account.");
                    System.out.println("logout: Logout from an account.");

                    if(user != null) {
                        System.out.println("\nUser specific menu options:");
                        user.printHelp();
                    } else {
                        System.out.println("Authenticated users have access to additional commands.\n");
                    }
                } else if("login".equals(tokens[0].toLowerCase())) {
                    if (user == null) {
                        System.out.println("\nEnter Username:");
                        String userName = scan.nextLine();

                        User potenUser = JavaProject.getUserFromName(userName);

                        if(potenUser != null) {
                            System.out.println("Enter Password:");
                            String password = scan.nextLine();

                            if(potenUser.checkPassword(password)) {
                                user = potenUser;
                                System.out.println("Welcome " + user.getUserName() + "!");
                            } else {
                                System.out.println("Password Incorrect. Please enter the \"login\" command or \"help\"" );
                            }
                        } else {
                            System.out.println("User not found. Please enter the \"login\" command or \"help\"");
                        }
                    } else {
                        System.out.println("You are already logged in. Please logout to access another account.");
                    }
                } else if("logout".equals(tokens[0].toLowerCase())) {
                    if (user != null) {
                        System.out.println("Are you sure you want to logout? (\"Yes\" to log out)");
                        String response = scan.nextLine();
                        
                        if(response.compareTo("Yes") == 0 || response.compareTo("yes") == 0){
                            user.logout();
                            user = null;
                            System.out.println("You have been logged out.");
                        } else {
                            System.out.println("You must enter \"Yes\" to log out. Please enter the \"logout\" command or \"help\"");
                        }
                    } else {
                        System.out.println("You are not logged in as an authenticated user.");
                    }
                } else if(user != null)
                    user.newCommand(line);
                else
                    System.out.println("Unknown Command \"" + line + "\". Try \"help\"");                  
            }
        }
    }
    
    static User getUserFromName(String name) {
        User temp = null;
        
        for (User use : JavaProject.users) {
            if (use.getUserName().compareTo(name) == 0)
                temp = use;
        }
        
        return temp;
    }
    
    static Event getEventFromName(String name) {
        Event temp = null;
        
        for (Event event : JavaProject.events) {
            if (event.getName().compareTo(name) == 0)
                temp = event;
        }
        
        return temp;
    }
}
