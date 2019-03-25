/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.swing.JOptionPane;
import javax.swing.JRootPane;

/**
 *
 * @author Rodrigo
 * @version 1.0.2 Phil Collins
 * @since 22/03/2019 21:39
 */
public class Numero {
    
    /*
    Atributos
    a = coeficiente quadrático
    b =coeficiente linear
    c = coeficiente constante
    exibicao = forma  como sera exibida a saida
    */
    private int a;
    private int b;
    private int c;

    public Numero() {
    }

    /**
     * 
     * @param a entrada do coeficiente quadratico
     * @param b entrada do coeficiente linear
     * @param c entrada do coeficiente constante
     */
    public Numero(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }
    
    /**
     * 
     * @return retorna o valor de delta
     */
    public int calcularDelta(){
        return (int) (Math.pow(b, 2) -4 * a * c);
    }
    
    /**
     * 
     * @return retorna o resultado da bhaskara
     */
    public String calcularBhaskara(){
        if(calcularDelta() > 0){
            return
                "x¹=" + (b * -1 + Math.sqrt(calcularDelta())) / 2 * a +
                ", x²=" + (b * -1 - Math.sqrt(calcularDelta())) / 2 * a;
        }
        else if(calcularDelta() == 0){
            return
                "x = " + (b * -1) / 2 * a;
        }
        else {
            return "cálculo inválido!";
        }
    }
    
    /**
     * 
     * @param exibicao opcao seleciona pelo radioButton
     * @param janela janela pai
     * @return retorna para o jtResposta e/ou o JOPtionPane
     */
    public String selecionarSaida(String exibicao, JRootPane janela){
        //seleciona a exibicao e executa a saida conforme
        switch(exibicao){
            case "joptionpane":
                JOptionPane.showMessageDialog(janela, toString(), "Resposta", JOptionPane.PLAIN_MESSAGE);
                return null;
            case "jlabel":
                return toString();
            case "ambos":
                JOptionPane.showMessageDialog(janela, toString(), "Resposta", JOptionPane.PLAIN_MESSAGE);
                return toString();
            default:
                return null;
        }
    }

    /**
     * 
     * @return retorna uma string diferente conforme o delta
     */
    @Override
    public String toString() {
        if(calcularDelta() < 0){//delta negativo
            return String.valueOf( calcularBhaskara());
        }
        else if(b >= 0 && c >= 0){
            return a + "x²+" + b + "x+" + c + "= " + calcularBhaskara();
        }
        else if(b > 0 && c < 0){//b positivo e c negativo
            return a + "x²+" + b + "x" + c + "= " + calcularBhaskara();
        }
        else if(c < 0 && c < 0){//b e c negativos
            return a + "x²" + b + "x" + c + "= " + calcularBhaskara();
        }
        else{//b negativo e c positivo
            return a + "x²" + b + "x+" + c + "= " + calcularBhaskara();
        }
    }
    
    
}
