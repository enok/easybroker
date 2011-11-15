
package br.com.otavio.easybroker.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.otavio.easybroker.to.AcaoTO;
import br.com.otavio.easybroker.to.AcaoUserTO;
import br.com.otavio.easybroker.to.UsuarioTO;



public class AcaoUserDAO {
    private Conexao conexao = new Conexao();

    public List<AcaoUserTO> selecionar(int id_usuario) throws Exception{
        Connection conn = conexao.getConnection();
        ArrayList arl = new ArrayList<AcaoUserTO>();
        Statement stmt = null;

        try{
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id_usuario, "+"id_acao, "+
                    						 "nr_acoes"+"from tb_acoes_user");

            while(rs.next()){
                AcaoUserTO ct = new AcaoUserTO();
                ct.setUsuario(new UsuarioTO());
                ct.getUsuario().setCodigo(rs.getInt("id_usuario"));
                
                ct.setAcaoCart(new AcaoTO());
                ct.getAcaoCart().setAcao(rs.getInt("id_acao"));
                
                
                ct.setNumero(rs.getInt("nr_acoes"));
                
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
    	public int insere(AcaoUserTO c) throws Exception{
                c.setId_carteira(getNextPk());
                Connection con = conexao.getConnection();
		PreparedStatement pmst = null;
		try{
			con.setAutoCommit(false);
			pmst =  con.prepareStatement("insert into TB_Carteira (id_usuario,"+
                                "id_acao, "+
                                "nr_acoes "+
                                "values (?,?,?)");
			pmst.setInt(1, c.getUsuario().getCodigo());
			pmst.setInt(2, c.getAcaoCart().getAcao());
            pmst.setInt(3, c.getNumero());
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

        public int alterar(AcaoUserTO c) throws Exception{
                Connection con = conexao.getConnection();
		PreparedStatement pmst = null;
		try{
			con.setAutoCommit(false);
			pmst =  con.prepareStatement("update TB_Acoes_user set "+
                                "id_acao = ?"+
                                "nr_acoes = ? "+
                                "where  id_usuario = ? ");
                        pmst.setInt(1, c.getUsuario().getCodigo());
                        pmst.setInt(2, c.getAcaoCart().getAcao());
                        pmst.setInt(3, c.getNumero());

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


        public int excluir(AcaoUserTO c) throws Exception{
                Connection con = conexao.getConnection();
		PreparedStatement pmst = null;
		try{
			con.setAutoCommit(false);
			pmst =  con.prepareStatement("delete from tb_acoes_user where id_usuario = ?");
			
			
			pmst.setInt(1, c.getUsuario().getCodigo());
			
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
		    ResultSet rs = stmt.executeQuery(" select max(id_usuario) from tb_acoes_user ");
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


        public AcaoUserTO load() throws Exception {
            return null;
        }

}