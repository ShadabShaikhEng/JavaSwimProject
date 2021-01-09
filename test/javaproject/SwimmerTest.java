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

public class SwimmerTest {

    /**
     * Test of getRole method of the Swimmer class.
     */
    @Test
    public void testGetRole() {
        System.out.println("getRole");
        Swimmer instance = new Swimmer("swimmer","pass");
        String expResult = "Swimmer";
        String result = instance.getRole();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method of the Swimmer class.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Swimmer instance = new Swimmer("swimmer","pass");
        String expResult = "Username: swimmer, Type of user:Swimmer";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of repOk method of the Swimmer class.
     */
    @Test
    public void testRepOk() {
        System.out.println("repOk");
        Swimmer instance = new Swimmer("swimmer", "pass");
        boolean expResult = true;
        boolean result = instance.repOk();
        assertEquals(expResult, result);
    }
    
}
