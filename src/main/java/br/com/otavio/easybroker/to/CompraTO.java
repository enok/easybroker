/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.otavio.easybroker.to;

import java.util.Date;

/**
 *
 * @author Octavio Braga
 */
public class CompraTO {
    private int idcompra;
    private UsuarioTO comprador;
    private AcaoTO acao_cp;
    private double valor_cp;
    private int nr_cp;
    private Date data_cp;


    public int getIDcompra() {
        return idcompra;
    }
    public void setIDcompra(int idcompra) {
        this.idcompra = idcompra;
    }


    public UsuarioTO getComprador() {
        return comprador;
    }
    public void setComprador(UsuarioTO comprador) {
        this.comprador = comprador;
    }


    public AcaoTO getAcao_cp() {
        return acao_cp;
    }
    public void setAcao_cp(AcaoTO acao_cp) {
        this.acao_cp = acao_cp;
    }


    public double getValor_cp() {
        return valor_cp;
    }
    public void setValor_cp(double valor_cp) {
        this.valor_cp = valor_cp;
    }


    public int getNr_cp() {
        return nr_cp;
    }
    public void setNr_cp(int nr_cp) {
        this.nr_cp = nr_cp;
    }


    public Date getData_cp() {
        return data_cp;
    }
    public void setData_cp(Date data_cp) {
        this.data_cp = data_cp;
    }
}
