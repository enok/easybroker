/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.otavio.easybroker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.otavio.easybroker.to.EmpresaTO;
import br.com.otavio.easybroker.to.UsuarioTO;

public class EmpresaDAO {
	private Conexao conexao ;
	
	public EmpresaDAO(){
		
		conexao = new Conexao();
	}

	public List<EmpresaTO> selecionar() throws Exception{

		Connection con = conexao.getConnection();
		List<EmpresaTO> arl = new ArrayList<EmpresaTO>();
		Statement stmt = null;
		try{
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select id_empresa,"+
											 "cnpj_empresa, "+"ramo_empresa, "+
											 "nm_empresa from tb_Empresa");
			while (rs.next()) {
				EmpresaTO emp = new EmpresaTO();
				emp.setCodigoemp(rs.getInt("id_empresa"));
				emp.setNomeemp(rs.getString("nm_empresa"));
				emp.setCnpj(rs.getString("cnpj_empresa"));
				emp.setRamo(rs.getString("ramo_empresa"));
				
				arl.add(emp);
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

	/*	public int insere(EmpresaTO p) throws Exception{
                p.setCodigoemp(getNextPk());
                Connection con = conexao.getConnection();
		PreparedStatement pmst = null;
		try{
			con.setAutoCommit(false);
			pmst =  con.prepareStatement("insert into TB_Empresa (id_empresa,"+
                                "nm_empresa, "+"cnpj_empresa, "+
                                "ramo_empresa) "+
                                "values (?,?,?,?)");
			pmst.setInt(1, p.getCodigoemp());
			pmst.setString(2, p.getNomeemp());
			pmst.setString(3, p.getCnpj());
            pmst.setString(4, p.getRamo());

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
	 */

	public String insere(EmpresaTO emp) throws Exception{
		emp.setCodigoemp(getNextPk());
		Connection con = conexao.getConnection();
		PreparedStatement pmst = null;
		try{
			con.setAutoCommit(false);

			pmst =  con.prepareStatement("insert into TB_Empresa (id_empresa,"+
					"nm_empresa, "+"cnpj_empresa, "+
					"ramo_empresa) "+
			"values (?,?,?,?)");
			pmst.setInt(1, emp.getCodigoemp());
			pmst.setString(2, emp.getNomeemp());
			pmst.setString(3, emp.getCnpj());
			pmst.setString(4, emp.getRamo());

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





	public int alterar(EmpresaTO p) throws Exception{
		Connection con = conexao.getConnection();
		PreparedStatement pmst = null;
		try{
			con.setAutoCommit(false);
			pmst =  con.prepareStatement("update TB_Empresa set "+
					"cnpj_empresa = ?, "+" ramo_empresa = ?"+
					"nm_empresa = ? "+
			" where  id_empresa = ? ");
			pmst.setString(1, p.getCnpj());
			pmst.setString(2, p.getRamo());
			pmst.setString(3, p.getNomeemp());
			pmst.setInt(4, p.getCodigoemp());

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


	public int excluir(EmpresaTO p) throws Exception{
		Connection con = conexao.getConnection();
		PreparedStatement pmst = null;
		try{
			con.setAutoCommit(false);
			pmst =  con.prepareStatement("delete from TB_Empresa where cnpj_empresa = ?");
			pmst.setString(1, p.getCnpj());
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
			ResultSet rs = stmt.executeQuery(" select max(id_empresa) from tb_empresa ");
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


	public EmpresaTO load() throws Exception {
		return null;
	}




	/*public static void main(String[]args){
		EmpresaDAO emp = new EmpresaDAO();
		EmpresaTO eto = new EmpresaTO();

		eto.setCodigoemp(emp.getNextPk());
		eto.setNomeemp("joao");
		eto.setCnpj("65241");
		eto.setRamo("Secretaria");

		try {
			emp.insere(eto);
		} catch (Exception ex) {
			Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
		}

	}*/
}