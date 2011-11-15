package br.com.otavio.easybroker.bo;

import java.util.List;

public interface BO {
    public Object inserir(Object to) throws Exception;
    public Object alterar(Object to) throws Exception;
    public void excluir(Object to) throws Exception;
    public List listar(Object to) throws Exception;
    public Object load() throws Exception;
    public void setDAO(Object dao);
}
