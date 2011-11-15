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
import br.com.otavio.easybroker.to.ValoresTO;


public class ValoresDAO {
    private Conexao conexao = new Conexao();

    public List<ValoresTO> selecionar(int id_acao) throws Exception{
        Connection conn = conexao.getConnection();
        ArrayList arl = new ArrayList<AcaoUserTO>();
        Statement stmt = null;

        try{
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id_acao, usuario_cp, data_hora, valor_unitario, unidades "+
                    						 "from tb_valores");

            while(rs.next()){
                ValoresTO vt = new ValoresTO();
                vt.getAcao().setAcao(getNextPk());
                
                vt.setUsuario(new UsuarioTO());
                vt.getUsuario().setCodigo(rs.getInt("usuario_cp"));
                
                vt.setData(rs.getDate("data_hora"));
                vt.setValorunit(rs.getDouble("valor_unitario"));
                vt.setUnidades(rs.getInt("unidades"));
               
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
    	public int insere(ValoresTO v) throws Exception{
                v.getAcao().setAcao(getNextPk());
                Connection con = conexao.getConnection();
		PreparedStatement pmst = null;
		try{
			con.setAutoCommit(false);
			pmst =  con.prepareStatement("insert into TB_Valores (id_acao"+
								"usuario_cp, "+
                                "data_hora, "+
								"valor_unitario, "+
                                "unidades"+
                                "values (?,?,?,?)");
			pmst.setInt(1, v.getAcao().getAcao());
			pmst.setInt(2, v.getUsuario().getCodigo());
			pmst.setDate(3,(java.sql.Date)v.getData());
			pmst.setDouble(4, v.getValorunit());
			pmst.setInt(5, v.getUnidades());
			
			
			
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

        public int alterar(ValoresTO v) throws Exception{
                Connection con = conexao.getConnection();
		PreparedStatement pmst = null;
		try{
			con.setAutoCommit(false);
			pmst =  con.prepareStatement("update TB_Valores set "+
                                "usuario_cp = ?, "+"data_hora = ?, "+" valor_unitario = ?"+
                                "unidades = ? "+
                                " where  id_acao = ? ");
								
								pmst.setInt(5, v.getAcao().getAcao());
								pmst.setInt(1, (v.getUsuario().getCodigo()));
								pmst.setDate(2, (java.sql.Date)v.getData());
								pmst.setDouble(3, v.getValorunit());
								pmst.setInt(4, v.getUnidades());
								
								
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


        public int excluir(ValoresTO v) throws Exception{
                Connection con = conexao.getConnection();
		PreparedStatement pmst = null;
		try{
			con.setAutoCommit(false);
			pmst =  con.prepareStatement("delete from TB_Valores where id_acao = ?");
			
			
			pmst.setInt(1, v.getAcao().getAcao());
			
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
		    ResultSet rs = stmt.executeQuery(" select max(id_acao) from tb_valores ");
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