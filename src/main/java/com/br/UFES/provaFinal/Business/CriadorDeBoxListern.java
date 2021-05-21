/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.UFES.provaFinal.Business;

import javax.swing.JTextPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author nandi
 */
public class CriadorDeBoxListern {
    
    private CriadorDeBoxListern() {
    }
    
    public static CriadorDeBoxListern getInstance() {
        return CriadorDeBoxListernHolder.INSTANCE;
    }
    
    private static class CriadorDeBoxListernHolder {

        private static final CriadorDeBoxListern INSTANCE = new CriadorDeBoxListern();
    }
    
    public void adicionarListend(JTextPane txtOriginal, JTextPane txtAlterado){
        txtOriginal.getDocument().addDocumentListener(new DocumentListener() {
    
            @Override
            public void insertUpdate(DocumentEvent e) {
                LimpadorDeTexto.getInstance().limparTextoProcessado(txtAlterado);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                LimpadorDeTexto.getInstance().limparTextoProcessado(txtAlterado);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
               LimpadorDeTexto.getInstance().limparTextoProcessado(txtAlterado);
            }
        });
        
    }
}
