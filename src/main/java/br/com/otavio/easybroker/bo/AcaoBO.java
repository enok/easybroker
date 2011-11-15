package br.com.otavio.easybroker.bo;

import java.util.ArrayList;
import java.util.List;

import br.com.otavio.easybroker.dao.AcaoDAO;
import br.com.otavio.easybroker.dao.EmpresaDAO;
import br.com.otavio.easybroker.to.AcaoTO;
import br.com.otavio.easybroker.to.EmpresaTO;

public class AcaoBO {
	private AcaoDAO dao;
    
	public AcaoBO(){
    	this.dao = new AcaoDAO();
    }

    public Object inserir(Object to) throws Exception {
    	  validateTO((AcaoTO)to);
          
  	    try {
  	    	   String retorno = dao.insere((AcaoTO)to);
  	    	   throw new Exception(retorno);
  	           
  		} catch (Exception e) {
  			throw new Exception(e.getMessage());
  		} 
      }

        public void setDAO(Object dao) {
        this.dao = (AcaoDAO)dao;
    }

    public void validateTO(AcaoTO to) throws Exception{
        if(to.getCodigo() == null || to.getCodigo().isEmpty()){
            throw new Exception("E necessario definir o codigo da a��o");
        }
        if(to.getEmpresa() == null || to.getEmpresa().getCodigoemp() == 0){
            throw new Exception("E necessario definir a empresa");
        }
    }
	
    public List listar(Object to) throws Exception{
        return dao.selecionar(1);
    }

    public static List<EmpresaTO> lista() throws Exception{
        return new ArrayList<EmpresaTO>();// dao.selecionar();
    }
	
}
