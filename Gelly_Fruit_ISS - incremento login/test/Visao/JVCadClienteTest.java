/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Visao;

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
public class JVCadClienteTest {
    
    public JVCadClienteTest() {
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
     * Test of validaCamposTeste method, of class JVCadCliente.
     */
    @Test
    public void testValidaCamposTeste() {
        System.out.println("validaCamposTeste");
        String nome = "Larissa";
        String end = "Rua Rio Iguaçu";
        String bairro = "Zona 6";
        String municipio = "Maringá";
        String cep = "87020220";
        String estado = "PR";
        String tel = "4432222220";
        String frete = "10";
        JVCadCliente instance = new JVCadCliente();
        boolean expResult = false;
        boolean result = instance.validaCamposTeste(nome, end, bairro, municipio, cep, estado, tel, frete);
        assertEquals(expResult, result);
        
    }
    
    
//    
//    /**
//     * Test of RetornoConsulta method, of class JVCadCliente.
//     */
//    @Test
//    public void testRetornoConsulta() {
//        System.out.println("RetornoConsulta");
//        int codigo = 0;
//        JVCadCliente instance = new JVCadCliente();
//        instance.RetornoConsulta(codigo);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of LimpaCampos method, of class JVCadCliente.
//     */
//    @Test
//    public void testLimpaCampos() {
//        System.out.println("LimpaCampos");
//        JVCadCliente instance = new JVCadCliente();
//        instance.LimpaCampos();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of PreencheCampos method, of class JVCadCliente.
//     */
//    @Test
//    public void testPreencheCampos() {
//        System.out.println("PreencheCampos");
//        int codigo = 0;
//        JVCadCliente instance = new JVCadCliente();
//        instance.PreencheCampos(codigo);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setPosicao method, of class JVCadCliente.
//     */
//    @Test
//    public void testSetPosicao() {
//        System.out.println("setPosicao");
//        JVCadCliente instance = new JVCadCliente();
//        instance.setPosicao();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of validaCampos method, of class JVCadCliente.
//     */
//    @Test
//    public void testValidaCampos() {
//        System.out.println("validaCampos");
//        JVCadCliente instance = new JVCadCliente();
//        boolean expResult = false;
//        boolean result = instance.validaCampos();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    
}
