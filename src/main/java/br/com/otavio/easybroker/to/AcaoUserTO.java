/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.otavio.easybroker.to;

/**
 *
 * @author Octavio Braga
 */
public class AcaoUserTO {
    private int id_carteira;
    private UsuarioTO usuario;
    private AcaoTO acao;
    private int nr_acoes;




    
    

    public UsuarioTO getUsuario(){
        return usuario;
    }
    public void setUsuario(UsuarioTO usuario){
        this.usuario = usuario;
    }

    public int getNumero(){
        return nr_acoes;
    }
    public void setNumero(int nr_acoes){
        this.nr_acoes = nr_acoes;
    }

    /**
     * @return the acao
     */
    public AcaoTO getAcaoCart() {
        return acao;
    }

    /**
     * @param acao the acao to set
     */
    public void setAcaoCart(AcaoTO acao) {
        this.acao = acao;
    }

    /**
     * @return the id_carteira
     */
    public int getId_carteira() {
        return id_carteira;
    }

    /**
     * @param id_carteira the id_carteira to set
     */
    public void setId_carteira(int id_carteira) {
        this.id_carteira = id_carteira;
    }
}
