/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;

import static javaproject.JavaProject.users;
import static javaproject.JavaProject.events;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class JavaProjectTest {
    
    public JavaProjectTest() {
        users.add(new Coach("coach1", "pass"));
        users.add(new Coach("coach2", "pass"));
        users.add(new Swimmer("swimmer1", "pass"));
        users.add(new Swimmer("swimmer2", "pass"));
        events.add(new Event("event1"));
        events.add(new Event("event2"));
    }
    

    /**
     * Test of getEventFromName method of the JavaProject class.
     */
    @Test
    public void testGetEventFromName() {
        System.out.println("getEventFromName");
        String name = "event1";
        Event result = JavaProject.getEventFromName(name);
        assertEquals(result.getName(), name);
    }
    
    /**
     * Test of getUserFromName method of the JavaProject class.
     */
    
    @Test
    public void testGetUserFromName() {
        System.out.println("getUserFromName");
        String name = "swimmer1";
        User result = JavaProject.getUserFromName(name);
        assertEquals(result.getUserName(), name);
    }
    
}
