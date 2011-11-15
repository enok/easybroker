
package br.com.otavio.easybroker.bo;

import java.util.ArrayList;
import java.util.List;

import br.com.otavio.easybroker.dao.EmpresaDAO;
import br.com.otavio.easybroker.to.EmpresaTO;
import br.com.otavio.easybroker.to.UsuarioTO;

/**
 *
 * @author
 */
public class EmpresaBO implements BO{
    private EmpresaDAO dao;
    public EmpresaBO(){
    	this.dao = new EmpresaDAO();
    }

    public Object inserir(Object to) throws Exception {
    	  validateTO((EmpresaTO)to);
          
  	    try {
  	    	   String retorno = dao.insere((EmpresaTO)to);
  	    	   throw new Exception(retorno);
  	           
  		} catch (Exception e) {
  			throw new Exception(e.getMessage());
  		} 
      }

        public void setDAO(Object dao) {
        this.dao = (EmpresaDAO)dao;
    }

    public void validateTO(EmpresaTO to) throws Exception{
        if(to.getNomeemp() == null || to.getNomeemp().isEmpty()){
            throw new Exception("E necessario definir o nome da empresa");
        }
        if(to.getCnpj() == null || to.getCnpj().isEmpty()){
            throw new Exception("E necessario definir o cnpj da empresa");
        }
        if(to.getRamo() == null || to.getRamo().isEmpty()){
            throw new Exception("E necessario definir o ramo da empresa");
        }
    }

    public void validatePKTO(EmpresaTO to) throws Exception{
        if(to.getCodigoemp() == 0){
            throw new Exception("E necessario definir o codigo da empresa");
        }
    }


    public Object alterar(Object to)  throws Exception{
        validatePKTO((EmpresaTO) to);
        validateTO((EmpresaTO)to);
        dao.alterar((EmpresaTO)to);
        return to;
    }

    public void excluir(Object to) throws Exception{
        validatePKTO((EmpresaTO) to);
        dao.excluir((EmpresaTO)to);
    }

    public List listar(Object to) throws Exception{
        return dao.selecionar();
    }

    public static List<EmpresaTO> lista() throws Exception{
    	return new ArrayList<EmpresaTO>();
    }
    
     public Object load() throws Exception{
        return dao.load();
    }
     /*public static void main(String[]args){
    	 EmpresaTO to = new EmpresaTO();
    	 EmpresaBO bo = new EmpresaBO();
    	 
    	 try {
			bo.listar(to);
			for (int i = 0; i < bo.listar(to).size(); i++){
				System.out.print(bo.listar(to).get(i));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
     }*/
}
