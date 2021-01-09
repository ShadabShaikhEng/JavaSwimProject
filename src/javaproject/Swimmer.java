/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;
public class Swimmer extends User {
    // OVERVIEW
    // This class is a child class of user,
    // It provides the commands which a swimmer would have access to
    // such as viewing times and showing enrolled events
    
    // AF(s) = { s.getUserName() == this.userName && s.checkPassword == true }
    
    // rep invariant
    // s.getRole.equals("Swimmer") &&
    // s.getUserName() == this.userName &&
    // s.checkPassword == true
    
    public Swimmer(String userName, String password) {
        super(userName, password);
    }

    @Override
    public void newCommand(String line) {
        
        // REQUIRES
        // String from command line
        // EFFECTS
        // Returns output depending on command
        // if the command is print_times,
        // will print the swimmer's times
        // if the commands is show_events,
        // will print list of swimmer's enrolled events
        
        String[] tokens = line.split(" ");
        if("print_times".equals(tokens[0].toLowerCase())) {
            for(Event core : JavaProject.events) {
                if(core.checkSwimmer(this.getUserName())){
                    System.out.println("For event: " + core.getName());
                }
                core.printTimes(this.getUserName());
            }
        } else if("show_events".equals(tokens[0].toLowerCase())) {
            System.out.println("Events:");
            for(Event core : JavaProject.events) {
                if(core.checkSwimmer(this.getUserName())) {
                    System.out.println(core.getName());
                }
            }
        } else {
            System.out.println("Unknown Command \"" + line + "\". Try \"help\"");
        }
    }

    @Override
    public void printHelp() {
        // EFFECTS 
        // if user enters the help command, will print list of available user specific functions
        System.out.println("show_events");
        System.out.println("    (Shows all enrolled events)");
        System.out.println("print_times");
        System.out.println("    (Shows all times on all distances in all events)");
    }

    @Override
    public void logout() {
    }

    @Override
    public String getRole() {
        // EFFECTS
        // returns the role of the user (swimmer)
        return "Swimmer";
    }
    
    @Override
    public String toString(){
        return "Username: " + this.getUserName() + ", Type of user:" + this.getRole();
    }
    
    public boolean repOk() {
        String un = this.getUserName();
        if(!(this.getRole().equals("Swimmer"))) {
            return false;
        }
        if(!(un instanceof String)){
            return false;
        }
        return true;
    }
}
