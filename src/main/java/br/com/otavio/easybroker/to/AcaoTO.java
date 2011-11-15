/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.otavio.easybroker.to;

/**
 *
 * @author Octavio Braga
 */
public class AcaoTO {
    private int id_acao;
    private EmpresaTO empresa;
    private String cod_acao;

    public int getAcao(){
        return id_acao;
    }
    public void setAcao(int id_acao){
        this.id_acao = id_acao;
    }

    public EmpresaTO getEmpresa(){
        return empresa;
    }
    public void setEmpresa(EmpresaTO empresa){
        this.empresa = empresa;
    }

    public String getCodigo(){
        return cod_acao;
    }
    public void setCodigo(String cod_acao){
        this.cod_acao = cod_acao;
    }
}
