/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;
import java.util.ArrayList;

class Event {
    
    // OVERVIEW
    // The event class can be assigned to swimmers
    // It contains a list of distances belonging to the event
    
    // AF(c) = { c.getName() == this.name && this.swimmers != null && this.distances != null }
    
    // rep invariant
    // c.addSwimmer("Taeyeon");
    // c.checkSwimmer("Taeyeon") == true;
    // c.addDistance("Taeyeon", "event1", 12.34);
    // c.checkDistanceIsDuplicate("Taeyeon", "event11") == true;
    // c.setName("ele504");
    // c.getName().equals("ele504");
    
    private String name;
    private ArrayList<Swimmer> swimmers = new ArrayList<>();
    private ArrayList<Distance> distances = new ArrayList<>();
    
    Event(String name) {
        this.name  = name;
    }
    
    public void addSwimmer(String name) {
        this.swimmers.add((Swimmer) JavaProject.getUserFromName(name));
    }
    
    public boolean checkSwimmer(String name) {
        for (Swimmer swi : swimmers) {
            if(name.compareTo(swi.getUserName()) == 0) {
                return true;
            }
        }
        
        return false;
    }
    
    // Makes sure there is only one instance of a distance
    public boolean checkDistanceIsDuplicate(String userName, String name) {
        for (Distance assign : distances) {
            if(name.compareTo(assign.getName()) == 0 && userName.compareTo(assign.getSwimmerName()) == 0) {
                return true;
            }
        }
        
        return false;
    }
    
    public void addDistance(String swimmerName, String name, Double time) {
        this.distances.add(new Distance((Swimmer) JavaProject.getUserFromName(swimmerName), name, time));
    }
    
    public void printTimes(String name) {
        Swimmer swimmer = (Swimmer) JavaProject.getUserFromName(name);
        
        if (swimmer != null) { // If swimmer is unspecified, print all swimmers
            for (Distance assign : distances) {
                if(assign.getSwimmerName().compareTo(swimmer.getUserName()) == 0) {
                    System.out.println("Distance: " + assign.getName() + "\tTime: " + assign.getTime());
                }
            }
        } else {
            for (Distance assign : distances) {
                System.out.println("Swimmer: " + assign.getSwimmerName() + "\tDistance: " + assign.getName() + "\tTime: " + assign.getTime());
            }
        }
    }

    // @return the name
   
    public String getName() {
        return name;
    }

    
    // @param name the name to set
    
    public void setName(String name) {
        this.name = name;
    }
    
        
    @Override
    public String toString(){
        return "Event name: " + this.getName();
    }
    
    public boolean repOk() {
        this.addSwimmer("Taeyeon");
        if(this.checkSwimmer("Taeyeon") == false){
            return false;
        }
        if(this.getName() == null){
            return false;
        }
        return true;
    }
}
