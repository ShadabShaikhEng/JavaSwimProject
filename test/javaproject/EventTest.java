/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class EventTest {
    
    public EventTest() {
    }
    
    /**
     * Test of getName method of the Event class.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Event instance = new Event("event");
        String expResult = "event";
        String result = instance.getName();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setName method of the Event class.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "event";
        Event instance = new Event("event");
        instance.setName(name);
        assertEquals(name, instance.getName());
    }


    
}
