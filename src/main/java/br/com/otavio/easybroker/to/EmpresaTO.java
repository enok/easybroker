/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.otavio.easybroker.to;

/**
 *
 * @author Octavio Braga
 */
public class EmpresaTO {
    private int codigo_emp;
    private String nome_emp;
    private String ramo;
    private String cnpj;

    public int getCodigoemp(){
        return codigo_emp;
    }
    public void setCodigoemp(int codigo_emp){
        this.codigo_emp = codigo_emp;
    }

    public String getNomeemp(){
        return nome_emp;
    }
    public void setNomeemp(String nome_emp){
        this.nome_emp = nome_emp;
    }

    public String getRamo(){
        return ramo;
    }
    public void setRamo(String ramo){
        this.ramo = ramo;
    }

    public String getCnpj(){
        return cnpj;
    }
    public void setCnpj(String cnpj){
        this.cnpj = cnpj;
    }
}
