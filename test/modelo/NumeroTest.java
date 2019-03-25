/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.swing.JRootPane;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rodrigo
 * @version 1.0.2 Phil Collins
 * @since 22/03/2019 22:19
 */
public class NumeroTest {
    
    private static final Numero n = new Numero();
    
    public NumeroTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        //inicializacao
        n.setA(1);
        n.setB(4);
        n.setC(-5);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * testa a metodo de calcular o delta
     */
    @Test
    public void testCalcularDelta(){
        //testando com configuracao inicial
        assertEquals(36, n.calcularDelta());
        
        //trocando c para 4
        n.setC(4);
        assertEquals(0, n.calcularDelta());
    }
    
    /**
     * testa o metodo calcularBhaskara
     */
    public void testCalcularBhaskara(){
        //testando com o delta positivo
        assertEquals("x¹=1, x²=-5", n.calcularBhaskara());
        
        //testando com o delta igual a 0
        n.setC(4);
        assertEquals("x = -2", n.calcularBhaskara());
        
        //testando com delta negativo
        n.setA(2);
        assertEquals("cálculo inválido!", n.calcularBhaskara());
        
        //testando com três valores negativos
        n.setA(-1);
        n.setB(-4);
        n.setC(-4);
        assertEquals("x =  -2", n.calcularBhaskara());
    }
    
    /**
     * testa o retorno do jtResposta conforme a selecao no bgOpcao
     * @param rootPane janela-pai
     */
    public void testSelecionarSaida(JRootPane rootPane){
        //testando com joptionpane selecionado
        assertEquals(null, n.selecionarSaida("joptionpane", rootPane));
        
        //testando com jlabel selecionado
        assertEquals(n.toString(), n.selecionarSaida("jlabel", rootPane));
        
        //testando com ambos selecionado
        assertEquals(n.toString(), n.selecionarSaida("ambos", rootPane));
    }
    
    /**
     * testa o toString conforme suas possibilidades
     */
    public void testToString(){
        //testando com b positivo e c negativo
        assertEquals("1x²+4-4= x¹=1, x²=-5", n.toString());
        
        //testando com b e c positivos
        n.setC(4);
        assertEquals("1x²+4+4= x = -4", n.toString());
        
        //testando com b negativo e c positivo
        n.setA(-1);
        n.setB(-1);
        n.setC(4);
        assertEquals("-1x²-1x+4= x¹-2, x²=2", n.toString());
        
        //testando com b e c negativos
        n.setA(-1);
        n.setB(-4);
        n.setC(-4);
        assertEquals("-1x²-4x-4= x = - 2", n.toString());
    }
}
