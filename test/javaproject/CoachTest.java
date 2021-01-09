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


public class CoachTest {
    
   
    /**
     * Test of getRole method of the Coach class.
     */
    @Test
    public void testGetRole() {
        System.out.println("getRole");
        Coach instance = new Coach("coach","pass");
        String expResult = "Coach";
        String result = instance.getRole();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method of the Coach class.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Coach instance = new Coach("coach","pass");
        String expResult = "Username: coach, Type of user:Coach";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of repOk method of the Coach class.
     */
    @Test
    public void testRepOk() {
        System.out.println("repOk");
        Coach instance = new Coach("coach", "pass");
        boolean expResult = true;
        boolean result = instance.repOk();
        assertEquals(expResult, result);
    }
    
}
