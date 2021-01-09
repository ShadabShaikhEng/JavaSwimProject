/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;
public class Coach extends User{
    // OVERVIEW
    // This class is a child class of user,
    // It provides the commands which a coach would have access to
    // such as managing times, events, and distances
    
    // AF(s) = { s.getUserName() == this.userName && s.checkPassword == true }
    
    // rep invariant
    // s.getRole.equals("Coach") &&
    // s.getUserName() == this.userName &&
    // s.checkPassword == true
    
    Event selectedEvent = null;

    public Coach(String userName, String password) {
        super(userName, password);
    }

    @Override
    public void newCommand(String line) {      
        // REQUIRES
        // String from command line
        // EFFECTS
        // Returns output depending on command
        // commands available are:
        // select event - change "selected" event
        // show event - shows a single event
        // show events - lists all events
        // show users - lists all users
        // show enrolled swimmers - lists swimmers currently enrolled in selected event
        // add swimmer - adds a swimmer to selected event
        
        //Tokens signifies an array with the arguments.

        String[] tokens = line.split(" ");
        if("select_event".equals(tokens[0].toLowerCase())) {
            if(tokens.length != 2) { // check that a event was specified
                System.out.println("Please specify a event");
            } else {
                if(JavaProject.getEventFromName(tokens[1]) == null) { // Check if event exists
                    System.out.println("The Event does not exist.");
                } else {
                    selectedEvent = JavaProject.getEventFromName(tokens[1]);
                    System.out.println(selectedEvent.getName() + " selected.");
                }    
            }
        } else if("show_event".equals(tokens[0].toLowerCase())) {
            if(selectedEvent == null) { // Check if a event is selected
                System.out.println("No event has been selected.");
            } else {
                System.out.println(selectedEvent.getName() + " selected.");
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
        } else if("show_enrolled_swimmers".equals(tokens[0].toLowerCase())) {
            if(selectedEvent != null) {
                System.out.println("Swimmers:");
                for(User use : JavaProject.users) {
                    if(use instanceof Swimmer){
                        if(selectedEvent.checkSwimmer(use.getUserName())) {
                            System.out.println(use.getUserName());
                        }
                    }
                }
            } else {
                System.out.println("You must select a event.");
            }
        } else if("add_swimmer".equals(tokens[0].toLowerCase())) {
            if (selectedEvent != null) {
                if(tokens.length < 2) { // Check that a swimmer was specified
                    System.out.println("Please specify a swimmer");
                } else {
                    if(JavaProject.getUserFromName(tokens[1]) == null) { // Check if swimmer exists
                        System.out.println("Swimmer must exist.");
                    } else {
                        if(JavaProject.getUserFromName(tokens[1]) instanceof Swimmer) { // Check if specified user is indeed a swimmer
                            if(!selectedEvent.checkSwimmer(tokens[1])) {
                                selectedEvent.addSwimmer(tokens[1]);
                            } else {
                                System.out.println("Swimmer is already enrolled in selected event.");
                            }
                        } else {
                            System.out.println("Please specify a swimmer.");
                        }
                    }    
                }
            } else {
                System.out.println("You must have a event selected.");
            }
        } else if("time".equals(tokens[0].toLowerCase())) {
            if (selectedEvent != null) {
                if(tokens.length < 4) {
                    System.out.println("You must specify a swimmer name, distance name, and time.");
                } else {
                    if(JavaProject.getUserFromName(tokens[1]) == null || tokens[2].length() == 0 || tokens[3].length() == 0 || !isDouble(tokens[3])) { //check that parameters are valid
                        System.out.println("Swimmer must exist, and distance name and time must be valid.");
                    } else {
                        if(JavaProject.getUserFromName(tokens[1]) instanceof Swimmer) { // Check that a swimmer was specified
                            if(selectedEvent.checkSwimmer(tokens[1])) { // Check that the swimmer is in the selected event
                                if(!selectedEvent.checkDistanceIsDuplicate(tokens[1], tokens[2])) {
                                    selectedEvent.addDistance(tokens[1], tokens[2], Double.parseDouble(tokens[3]));
                                } else {
                                    System.out.println("Selected event already contains an distance with that name for that swimmer.");
                                }
                            } else {
                                System.out.println("Swimmer must be in selected event.");
                            }
                        } else {
                            System.out.println("Swimmer must be valid.");
                        }
                    }
                }
            } else {
                System.out.println("You must have a event selected.");
            }
        } else {
            System.out.println("Unknown Command \"" + line + "\". Try \"help\"");
        }
    }

    @Override
    public void printHelp() {
        System.out.println("\nselect_event <event>");
        System.out.println("show_event");
        System.out.println("    (Shows currently selected event)");
        System.out.println("show_events");
        System.out.println("    (Shows all events)");
        System.out.println("show_users");
        System.out.println("    (Shows all users)");
        System.out.println("show_enrolled_swimmers");
        System.out.println("    (Shows all swimmers in a selected event)");
        System.out.println("add_swimmer <username>");
        System.out.println("time <swimmer username> <distance name> <time>");
        System.out.println("    (Adds a time for an distance for the specified swimmer with the specified time)");
    }

    @Override
    public void logout() {
        selectedEvent = null;
    }
    
    static private boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public String getRole() {
        // EFFECTS
        // returns the role of the user (Coach)
        return "Coach";
    }
    
    @Override
    public String toString(){
        return "Username: " + this.getUserName() + ", Type of user:" + this.getRole();
    }
    
    public boolean repOk() {
        String un = this.getUserName();
        if(!(this.getRole().equals("Coach"))) {
            return false;
        }
        if(!(un instanceof String)){
            return false;
        }
        return true;
    }
}
