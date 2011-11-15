package br.com.otavio.easybroker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.otavio.easybroker.to.AcaoTO;
import br.com.otavio.easybroker.to.AcaoUserTO;
import br.com.otavio.easybroker.to.EmpresaTO;
import br.com.otavio.easybroker.to.UsuarioTO;


public class AcaoDAO {
	private Conexao conexao = new Conexao();
	
    public List<AcaoTO> selecionar(int id_acao) throws Exception{
        Connection conn = conexao.getConnection();
        ArrayList arl = new ArrayList<AcaoUserTO>();
        Statement stmt = null;
		
		try{
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select id_acao, empresa, cod_acao from tb_acao");
			
			while(rs.next()){
				AcaoTO at = new AcaoTO();
				at.setAcao(rs.getInt("id_acao"));
				
				at.setEmpresa(new EmpresaTO());
                at.getEmpresa().setCodigoemp(rs.getInt("empresa"));
                
                at.setCodigo(rs.getString("cod_acao"));
				
			    arl.add(at);
            }
            rs.close();
			stmt.close();
		}catch (Exception e) {
			try{
			stmt.close();
			}catch (Exception ex) {}
			e.printStackTrace();
			throw e;
		} finally{
                    conexao.closeConnection();
                }
        return arl;
    }
    
    public String insere(AcaoTO acao) throws Exception{
		acao.setAcao(getNextPk());
		Connection con = conexao.getConnection();
		PreparedStatement pmst = null;
		try{
			con.setAutoCommit(false);

			pmst =  con.prepareStatement("insert into TB_Empresa (id_acao,"+
					"empresa, " +
					"cod_acao) "+
					"values (?,?,?)");
			pmst.setInt(1, acao.getAcao());
			pmst.setInt(2, acao.getEmpresa().getCodigoemp());
			pmst.setString(3, acao.getCodigo());
			
			pmst.executeUpdate();

			con.commit();
			pmst.close();
			return "Cadastrado com sucesso!";
		}catch (Exception e) {
			try{
				con.rollback();
				pmst.close();
			}catch (Exception ex) {
				ex.printStackTrace();
			}
			String erro = e.getMessage();
			if(erro.contains("ORA-00001")){
				return "CPNPJ ja existem";
			}
			return "Algum erro inesperado ocorreu";
		} finally{
			conexao.closeConnection();
		}
	}
    
    
   /* public int insere(AcaoTO a) throws Exception{
    	a.setAcao(getNextPk());
    	Connection con = conexao.getConnection();
    	PreparedStatement pmst = null;
    	
    	try{
    		con.setAutoCommit(false);
    		pmst = con.prepareStatement("insert into tb_acao (id_acao,"+
    									"empresa, "+
    									"cod_acao)"+
            							"values (?,?,?)");
    		
    		pmst.setInt(1, a.getAcao());
    		pmst.setInt(2, a.getEmpresa().getCodigoemp());
    		pmst.setString(3, a.getCodigo());
    		
    		int resultado = pmst.executeUpdate();
			con.commit();
			pmst.close();
			return resultado;
		}catch (Exception e) {
			try{
				con.rollback();
				pmst.close();
			}catch (Exception ex) {
				ex.printStackTrace();
			}
			e.printStackTrace();
			return 0;
		} finally{
                    conexao.closeConnection();	
    		
    	}
    }*/
    
    public int excluir(AcaoTO a) throws Exception{
        Connection con = conexao.getConnection();
PreparedStatement pmst = null;
try{
	con.setAutoCommit(false);
	pmst =  con.prepareStatement("delete from tb_acao where id_acao = ?");
	pmst.setInt(1, a.getAcao());
	int resultado = pmst.executeUpdate();
	con.commit();
	pmst.close();
	return resultado;
}catch (Exception e) {
	try{
		con.rollback();
		pmst.close();
	}catch (Exception ex) {
		ex.printStackTrace();
	}
	e.printStackTrace();
	return 0;
} finally{
            conexao.closeConnection();
        }
}
 
    public int alterar(AcaoTO a) throws Exception{
        Connection con = conexao.getConnection();
PreparedStatement pmst = null;
try{
	con.setAutoCommit(false);
	pmst =  con.prepareStatement("update TB_Acao set "+
                        "empresa = ?"+
                        "cod_acao = ? "+
                        " where  id_acao = ? ");
                pmst.setInt(3, a.getAcao());
                pmst.setInt(1, a.getEmpresa().getCodigoemp());
                pmst.setString(2, a.getCodigo());
               
	int resultado = pmst.executeUpdate();
	con.commit();
	pmst.close();
	return resultado;
}catch (Exception e) {
	try{
		con.rollback();
		pmst.close();
	}catch (Exception ex) {
		ex.printStackTrace();
	}
	e.printStackTrace();
	return 0;
} finally{
            conexao.closeConnection();
        }
}
    
    public int getNextPk(){
        Connection con = conexao.getConnection();
    Statement stmt = null;
	try{
	    stmt = con.createStatement();
	    ResultSet rs = stmt.executeQuery(" select max(id_acao) from tb_acao ");
                rs.next();
                int chave = rs.getInt(1) +1;
                stmt.close();
                return chave;
	}catch (Exception e) {
		try{
		stmt.close();
		}catch (Exception ex) {}
		return 1;
	} finally{
                conexao.closeConnection();
            }
    }
      
    public static void main(String[]args){
    	AcaoDAO adao = new AcaoDAO();
    	AcaoTO ato = new AcaoTO();
        EmpresaTO eto = new EmpresaTO();
        eto.setCodigoemp(1);
        
        
        //ato.setAcao(adao.getNextPk());
    	//ato.setEmpresa(eto);
    	//ato.setCodigo("cod_acao");
        
    try {
        adao.insere(ato);
    } catch (Exception ex) {
        Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
    }

    }
}