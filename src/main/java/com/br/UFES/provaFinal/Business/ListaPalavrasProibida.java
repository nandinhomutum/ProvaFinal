/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.UFES.provaFinal.Business;

import java.util.ArrayList;

/**
 *
 * @author nandi
 */
public class ListaPalavrasProibida {
    
    private static ArrayList<String> palavras = new ArrayList<>();
    
    
    private ListaPalavrasProibida() {
    }
    
    public static ListaPalavrasProibida getInstance() {
        return ListaPalavrasProibidaHolder.INSTANCE;
    }
    
    private static class ListaPalavrasProibidaHolder {

        private static final ListaPalavrasProibida INSTANCE = new ListaPalavrasProibida();
    }
    
    public ArrayList<String> pegarTodas(){
        return this.palavras;
    }
    
    public void addPalavra(String palavra){
        this.palavras.add(palavra);
    }
    
    public void removePalavra(String palavra){
        ArrayList<String> palavraRemove;
        palavraRemove = this.palavras;
        for (int i = 0; i<palavras.size(); i++){
            if(palavra.toLowerCase().equals(palavras.get(i).toLowerCase())){
                palavras.remove(i);
            }
        }
    }
    
    
}
