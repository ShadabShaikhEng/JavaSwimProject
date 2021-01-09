/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;
class Distance {
    // OVERVIEW
    // The distance class belongs to a swimmer
    // and has an event name
    // as well as a grade (time) associated with it
    
    // AF(s) = { s.getSwimmerName() | this.swimmer instanceof String
    //           s.getName() | this.name instanceof String
    //           s.getTime() | this.time instanceof Double   }
    
    // rep invariant
    // s.getName() != null && s.getTime() != null && s.getSwimmerName() != null
    
    private Swimmer swimmer;
    private String name;
    private Double time;
    
    //Creating the distance constructor
    
    Distance(Swimmer swimmer, String name, Double time) {
        this.swimmer = swimmer;
        this.name = name;
        this.time = time;
    }
    
   
     // @return the swimmer's name
     
    public String getSwimmerName() {
        return swimmer.getUserName();
    }
    

    
     // @return the name
     
    public String getName() {
        return name;
    }

    // @return the time
    
    public Double getTime() {
        return time;
    }
    
        
    @Override
    public String toString(){
        return "Distance " + this.getName() + " belongs to " + this.getSwimmerName() + " with time of " + this.getTime();
    }
    
    public boolean repOk() {
        if(!(this.getName() instanceof String && this.getSwimmerName() instanceof String)){
            return false;
        }
        if(this.getTime() == null){
            return false;
        }
        return true;
    }
}
