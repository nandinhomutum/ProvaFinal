/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.UFES.provaFinal.Business;

import javax.swing.JTextPane;

/**
 *
 * @author nandi
 */
public class LimpadorDeTexto {
    
    private LimpadorDeTexto() {
    }
    
    public static LimpadorDeTexto getInstance() {
        return LimparTextoHolder.INSTANCE;
    }
    
    private static class LimparTextoHolder {

        private static final LimpadorDeTexto INSTANCE = new LimpadorDeTexto();
    }
    
     public void limparTextoProcessado(JTextPane caixaTexto){
        caixaTexto.setText("");
    }
}
