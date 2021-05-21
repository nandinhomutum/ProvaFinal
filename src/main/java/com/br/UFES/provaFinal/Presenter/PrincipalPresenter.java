/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.UFES.provaFinal.Presenter;

import com.br.UFES.provaFinal.Business.CriadorDeBoxListern;
import com.br.UFES.provaFinal.Business.ListaPalavrasProibida;
import com.br.UFES.provaFinal.Business.UtilitarioString;
import com.br.UFES.provaFinal.View.PrincipalView;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author nandi
 */
public class PrincipalPresenter {
    private PrincipalView tela;

    public PrincipalPresenter() {
        
        this.tela = new PrincipalView(this);
        addPalavrasProibidas("facebook");
        addPalavrasProibidas("google");
        this.adicionarListend();
        this.tela.setVisible(true);
    }
    
    public void abrirCaixaTexto(){
        new CaixaTextoPresenter(this);
    }
    
    public void atualizarPalavrasProibidas(ArrayList<String> palavras){
        DefaultListModel<String> model = new DefaultListModel<>();
        for ( int i = 0; i < palavras.size(); i++ ){
            model.addElement( palavras.get(i));
        }
        this.tela.getLstPalavras().setModel(model);
    }
    
    public void addPalavrasProibidas(String palavra){
         ListaPalavrasProibida listaPalavras = ListaPalavrasProibida.getInstance();
         listaPalavras.addPalavra(palavra);
         this.atualizarPalavrasProibidas(listaPalavras.pegarTodas());
    }
    
    public void removePalavrasProibidas(){
         String palavra = tela.getLstPalavras().getSelectedValue();
         ListaPalavrasProibida listaPalavras = ListaPalavrasProibida.getInstance();
         listaPalavras.removePalavra(palavra);
         this.atualizarPalavrasProibidas(listaPalavras.pegarTodas());
    }
    
    public void processarTexto(){
       
        String textoOriginal = tela.getTxtOriginal().getText();
        ArrayList<String> listaPalavras = ListaPalavrasProibida.getInstance().pegarTodas();
        
        for (String palavraProibida : listaPalavras){
            textoOriginal = UtilitarioString.getInstance().substitui(textoOriginal, palavraProibida, "*");  
        }
        tela.getTxtAlterado().setText(textoOriginal);
    }
    
    
    public void adicionarListend(){
        CriadorDeBoxListern.getInstance().adicionarListend(tela.getTxtOriginal(), tela.getTxtAlterado());
    }
    
    
}
