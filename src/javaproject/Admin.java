/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;

public class Admin extends User{
    // OVERVIEW
    // This class is a child class of User,
    // it provides the "admin" interface for managing events, swimmers, and coaches
    
    // AF(s) = { s.getUserName() == this.userName && s.checkPassword == true }
    
    // rep invariant
    // s.getRole.equals("Admin") &&
    // s.getUserName() == this.userName &&
    // s.checkPassword('admin') == true
    
    
    private static final Admin oneTimeInstance = new Admin("Admin", "Admin");

    private Admin(String userName, String password) {
        super(userName, password);
    }
    
    public static Admin getInstance(){
        return oneTimeInstance;
    }
    
    /* Tokens are arguments presented in user command. The tookens array contains each argument seperated as words
    tokens[0] is the first word, tokens[1] is the second word etc,
    This is used to parse commands using if statements as well as checking if arguments are valid
    both as a general argument and valid in context of its role (swimmer privileges, coach priveleges etc.)
    */

    
    @Override
    public void newCommand(String line) {
        String[] tokens = line.split(" ");
        if("create".equals(tokens[0].toLowerCase())) {
            if(tokens.length < 2) { //check that a type was specified
                System.out.println("Creation must be specified. Please re-enter command with required parameters, type \"help\" for more information");
            } else {
                if("swimmer".equals(tokens[1].toLowerCase())) { //check if it was a swimmer
                    if(tokens.length < 4) { //make sure a username and password were specified
                        System.out.println("Please specify a username and password.");
                    } else {
                        if(tokens[2].length() == 0 || tokens[3].length() == 0){ // make sure username an password are non-zero
                            System.out.println("Please specify a username and password.");
                        } else {
                            if(JavaProject.getUserFromName(tokens[2]) == null) { // make sure user doesn't already exist
                                JavaProject.users.add(new Swimmer(tokens[2], tokens[3]));
                            } else {
                                System.out.println("User \"" + tokens[2] + "\" already exists.");
                            }
                        }
                    }
                } else if("coach".equals(tokens[1].toLowerCase())) { //check if it was a coach
                    if(tokens.length < 4) { //make sure a username and password were specified
                        System.out.println("Please specify a username and password.");
                    } else {
                        if(tokens[2].length() == 0 || tokens[3].length() == 0){ // make sure username an password are nonzero
                            System.out.println("Please specify a username and password.");
                        } else {
                            if(JavaProject.getUserFromName(tokens[2]) == null) { // make sure user doesn't already exist
                                JavaProject.users.add(new Coach(tokens[2], tokens[3]));
                            } else {
                                System.out.println("User \"" + tokens[2] + "\" already exists.");
                            }
                        }
                    }
                } else if("event".equals(tokens[1].toLowerCase())) { //check if it was an event
                    if(tokens.length < 3) { //make sure name was specified
                        System.out.println("Please specify a name for the event.");
                    } else {
                        if(tokens[2].length() == 0){ // make sure name is nonzero
                            System.out.println("Please specify a name for the event.");
                        } else {
                            if(JavaProject.getEventFromName(tokens[2]) == null) { // make sure event doesn't already exist
                                JavaProject.events.add(new Event(tokens[2]));
                            } else {
                                System.out.println("Event \"" + tokens[2] + "\" already exists.");
                            }
                        }
                    }
                } else {
                    System.out.println("Unknown type \"" + tokens[1] +"\".");
                }
            } 
        } else if("show_events".equals(tokens[0].toLowerCase())) {
            System.out.println("Events:");
            for(Event core : JavaProject.events) {
                System.out.println(core.getName());
            }
        } else if("show_users".equals(tokens[0].toLowerCase())) {
            System.out.println("Users:");
            for(User use : JavaProject.users) {
                System.out.println("Username: " + use.getUserName() + " Type: " + use.getRole());
            }
        } else {
            System.out.println("Unknown Command \"" + line + "\". Try \"help\"");
        }
    }
    
    //Help menu for admin actions related to create
    @Override
    public void printHelp() {
        System.out.println("\nCreate");
        System.out.println("-----------------------------------------");
        System.out.println("  Creates various objects. Usage:");
        System.out.println("    create swimmer <username> <password>");
        System.out.println("    create coach <username> <password>");
        System.out.println("    create event <name>");
        System.out.println("-----------------------------------------");
        System.out.println("show_events");
        System.out.println("    (Shows all events)");
        System.out.println("show_users");
        System.out.println("    (Shows all users)");
    }

    @Override
    public void logout() {
    }

    @Override
    public String getRole() {
        return "Admin";
    }
    
    @Override
    public String toString(){
        return "Username: " + this.getUserName() + ", Type of user:" + this.getRole();
    }
    
    public boolean repOk() {
        String un = this.getUserName();
        if(!(this.getRole().equals("Admin"))) {
            return false;
        }
        if(!(un instanceof String)){
            return false;
        }
        return true;
    }
}
