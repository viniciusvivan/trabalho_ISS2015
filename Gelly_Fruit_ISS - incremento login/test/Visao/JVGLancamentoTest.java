package Visao;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * TESTE JUnit G. Lancamento
 * @author Gustavo H. G. Matsushita RA 79194
 */

public class JVGLancamentoTest {
    public JVGLancamentoTest() {
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
     * Test of validaCamposTeste method, of class JVGLancamento.
     */
    @Test
    public void testValidaCamposTeste() {
        System.out.println("validaCamposTeste");
        String campodata = "10/10/2014";
        String campoqnt = "10";
        String campocod = "1";
        String campoverifica = "0";
        int status = 0;
        JVGLancamentoProduto instance = new JVGLancamentoProduto();
        boolean expResult = true;
        boolean result = instance.validaCamposTeste(campodata, campoqnt, campocod, campoverifica, status);
        assertEquals(expResult, result);
    }

    /**
     * Test of validaQntTeste method, of class JVGLancamento.
     */
    @Test
    public void testValidaQntTeste() {
        System.out.println("validaQntTeste");
        int tipo = 2;
        int qntlan = 1;
        int qntprod = 0;
        JVGLancamentoProduto instance = new JVGLancamentoProduto();
        boolean expResult = true;
        boolean result = instance.validaQntTeste(tipo, qntlan, qntprod);
        assertEquals(expResult, result);
    }
    
    
//    /**
//     * Test of Pesquisa method, of class JVGLancamento.
//     */
//    @Test
//    public void testPesquisa() {
//        System.out.println("Pesquisa");
//        int i = 0;
//        JVGLancamento instance = new JVGLancamento();
//        instance.Pesquisa(i);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    /**
//     * Test of LimpaCampos method, of class JVGLancamento.
//     */
//    @Test
//    public void testLimpaCampos() {
//        System.out.println("LimpaCampos");
//        JVGLancamento instance = new JVGLancamento();
//        instance.LimpaCampos();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    /**
//     * Test of validaQnt method, of class JVGLancamento.
//     */
//    @Test
//    public void testValidaQnt() {
//        System.out.println("validaQnt");
//        JVGLancamento instance = new JVGLancamento();
//        boolean expResult = false;
//        boolean result = instance.validaQnt();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    /**
//     * Test of validaCampos method, of class JVGLancamento.
//     */
//    @Test
//    public void testValidaCampos() {
//        System.out.println("validaCampos");
//        JVGLancamento instance = new JVGLancamento();
//        boolean expResult = false;
//        boolean result = instance.validaCampos();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    /**
//     * Test of setPosicao method, of class JVGLancamento.
//     */
//    @Test
//    public void testSetPosicao() {
//        System.out.println("setPosicao");
//        JVGLancamento instance = new JVGLancamento();
//        instance.setPosicao();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }


}
