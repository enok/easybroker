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
public class VendaTO {
    private int idvenda;
    private UsuarioTO vendedor;
    private AcaoTO acao_vd;
    private double valor_vd;
    private int nr_vd;
    private Date data_vd;

    /**
     * @return the codvenda
     */
    public int getIdvenda() {
        return idvenda;
    }
    public void setCodvenda(int idvenda) {
        this.idvenda = idvenda;
    }


    public UsuarioTO getVendedor() {
        return vendedor;
    }
    public void setVendedor(UsuarioTO vendedor) {
        this.vendedor = vendedor;
    }


    public AcaoTO getAcao_vd() {
        return acao_vd;
    }
    public void setAcao_vd(AcaoTO acao_vd) {
        this.acao_vd = acao_vd;
    }


    public double getValor_vd() {
        return valor_vd;
    }
    public void setValor_vd(double valor_vd) {
        this.valor_vd = valor_vd;
    }


    public int getNr_vd() {
        return nr_vd;
    }
    public void setNr_vd(int nr_vd) {
        this.nr_vd = nr_vd;
    }


    public Date getData_vd() {
        return data_vd;
    }
    public void setData_vd(Date data_vd) {
        this.data_vd = data_vd;
    }

}