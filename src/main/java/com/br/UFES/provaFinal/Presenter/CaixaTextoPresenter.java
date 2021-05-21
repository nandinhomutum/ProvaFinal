/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.UFES.provaFinal.Presenter;

import com.br.UFES.provaFinal.View.CaixaTextoView;

/**
 *
 * @author nandi
 */
public class CaixaTextoPresenter {
    private CaixaTextoView tela;
    private PrincipalPresenter principal;

    public CaixaTextoPresenter(PrincipalPresenter principal) {
        this.tela = new CaixaTextoView(this);
        this.principal = principal;
        tela.setVisible(true);
    }
    
    public void cadastrarPalavra(){
        String palavra = tela.getTxtPalavra().getText();
        if (null != palavra && !palavra.equals("")){
            principal.addPalavrasProibidas(palavra);
        }
    }
    
    
    
}
