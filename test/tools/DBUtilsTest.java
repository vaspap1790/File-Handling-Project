/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.sql.Connection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vaspa
 */
public class DBUtilsTest {
    
    public DBUtilsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getConnection method, of class DBUtils.
     */
    @Test
    public void testGetConnection() {
        
        Connection result = DBUtils.getConnection();
        assertNull(result);
        
    }

    /**
     * Test of close method, of class DBUtils.
     */
//    @Test
//    public void testClose() {
//        System.out.println("close");
//        Connection conn = null;
//        DBUtils.close(conn);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
