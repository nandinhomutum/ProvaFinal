/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.UFES.provaFinal.Business;

/**
 *
 * @author nandi
 */
public class UtilitarioString {
    
    private UtilitarioString() {
    }
    
    public static UtilitarioString getInstance() {
        return UtilitarioStringHolder.INSTANCE;
    }
    
    private static class UtilitarioStringHolder {

        private static final UtilitarioString INSTANCE = new UtilitarioString();
    }
    
    public String substitui(String texto, String palavra, CharSequence simbolo){
        String textoTratado = texto;
        String primeiraMetade;
        String segundaMetade;
        String asteriscos = "";
        int primeiroIndexMinisculo;
        int primeiroIndexMaiusculo;
        
        if (texto.toLowerCase().contains(palavra.toLowerCase())){
        for(int i = 0; i < palavra.length();i++){
            asteriscos = asteriscos+simbolo;
        }
        textoTratado = texto.replace(palavra, asteriscos);
        //boolean flag = true;
        //while(flag) {
        textoTratado = textoTratado.replace(palavra, asteriscos);
        primeiroIndexMinisculo = textoTratado.toLowerCase().indexOf(palavra.toLowerCase());
        
        primeiroIndexMaiusculo = textoTratado.toUpperCase().indexOf(palavra.toUpperCase());
        
        //if (!texto.contains(palavra)){
        if(textoTratado.toLowerCase().contains(palavra.toLowerCase())){
            String palavraMinuscula;
            palavraMinuscula = textoTratado.substring(primeiroIndexMinisculo, (primeiroIndexMinisculo+palavra.length()));
            textoTratado = textoTratado.replace(palavraMinuscula, asteriscos);
        }
        
        if(textoTratado.toUpperCase().contains(palavra.toUpperCase())){
          String palavraMaiuscula;
            palavraMaiuscula = textoTratado.substring(primeiroIndexMaiusculo, (primeiroIndexMaiusculo+palavra.length()));
            textoTratado = textoTratado.replace(palavraMaiuscula, asteriscos);  
        }
            
                
        //}
        //if (!texto.toLowerCase().contains(palavra.toLowerCase())){  
        //    flag = false;
       
        //}
        }
        return textoTratado;
    }
}
