/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.otavio.easybroker.bo;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.List;

import br.com.otavio.easybroker.dao.UsuarioDAO;
import br.com.otavio.easybroker.to.UsuarioTO;

/**
 *
 * @author
 */
public class UsuarioBO implements BO{
    UsuarioDAO dao = new UsuarioDAO();

    public Object inserir(Object usr) throws Exception {
    validateTO((UsuarioTO)usr);
             
	    try {
	    	   String retorno = dao.insere((UsuarioTO)usr);
	    	   throw new Exception(retorno);
	           
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} 
    }

    public void setDAO(Object dao) {
        this.dao = (UsuarioDAO)dao;
    }

        
    public void validateTO(UsuarioTO to) throws Exception{
        if(to.getNome() == null || to.getNome().isEmpty()){
            throw new Exception("E necessario definir o nome do usuario");
        }
        if(to.getCpf() == null || to.getCpf().isEmpty()){
            throw new Exception("E necessario definir o cpf do usuario");
        }
        if(to.getSexo() == null || to.getSexo().isEmpty()){
            throw new Exception("E necessario definir o sexo do usuario");
        }
        if(to.getEmail() == null || to.getEmail().isEmpty()){
            throw new Exception("E necessario definir o email do usuario");
        }
        if(to.getSenha() == null || to.getSenha().isEmpty()){
            throw new Exception("E necessario definir a senha do usuario");
        }
    }

    public void validatePKTO(UsuarioTO to) throws Exception{
        if(to.getCodigo() == 0){
            throw new Exception("E necessario definir o codigo do usuario");
        }
    }


    public Object alterar(Object to)  throws Exception{
        validatePKTO((UsuarioTO) to);
        validateTO((UsuarioTO)to);
        dao.alterar((UsuarioTO)to);
        return to;
    }

    public void excluir(Object to) throws Exception{
        validatePKTO((UsuarioTO) to);
        dao.excluir((UsuarioTO)to);
    }

    public List listar(Object to) throws Exception{
        return dao.selecionar();
    }

    
     public Object load() throws Exception{
        return dao.load();
    }
     
  /*  public static void main(String[]args){
   	UsuarioBO bo = new UsuarioBO();
    	List<UsuarioTO> listato = new ArrayList<UsuarioTO>();
    	
		try {
			listato = bo.listar();
			for (UsuarioTO usuarioTO : listato) {
				System.out.println(usuarioTO.getEmail());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }*/

	

}

