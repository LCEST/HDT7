/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gustavo
 */
public class DiccionarioTest {
    
    public DiccionarioTest() {
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
     * Test of llenDic method, of class Diccionario.
     */
    @Test
    public void testLlenDic() {
        System.out.println("llenDic");
        Diccionario instance = new Diccionario();
        instance.llenDic();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of insertarNodo method, of class Diccionario.
     */
    @Test
    public void testInsertarNodo() {
        System.out.println("insertarNodo");
        BinaryTree<Association<String, String>> padre = null;
        Association<String, String> dato = null;
        Diccionario instance = new Diccionario();
        instance.insertarNodo(padre, dato);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of tradPal method, of class Diccionario.
     */
    @Test
    public void testTradPal() {
        System.out.println("tradPal");
        BinaryTree<Association<String, String>> padre = null;
        String palabra = "tree";
        Diccionario instance = new Diccionario();
        String expResult = "arbol";
        String result = instance.tradPal(padre, palabra);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

   
    
}
