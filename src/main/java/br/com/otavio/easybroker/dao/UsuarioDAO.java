package br.com.otavio.easybroker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.otavio.easybroker.to.UsuarioTO;

public class UsuarioDAO {

	private Conexao conexao = new Conexao();

	public List<UsuarioTO> selecionar() throws Exception{
		Connection conn = conexao.getConnection();
		ArrayList arl = new ArrayList<UsuarioTO>();
		Statement stmt = null;

		try{

			stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery("select id_usuario, "+"nm_usuario, "+"cpf_usuario, "+
					"sexo_usuario, "+"email, "+"senha, "+"admin from tb_usuario");
			while(rs.next()){
				UsuarioTO usr = new UsuarioTO();
				usr.setCodigo(rs.getInt(1));
				usr.setNome(rs.getString("nm_usuario"));
				usr.setSexo(rs.getString("sexo_usuario"));
				usr.setCpf(rs.getString("cpf_usuario"));
				usr.setEmail(rs.getString("email"));
				usr.setSenha(rs.getString("senha"));
				usr.setAdmin(rs.getString("admin"));

				arl.add(usr);
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

	public String insere(UsuarioTO usr) throws Exception{
		usr.setCodigo(getNextPk());
		Connection con = conexao.getConnection();
		PreparedStatement pmst = null;
		try{
			con.setAutoCommit(false);

			pmst =  con.prepareStatement("insert into tb_usuario (id_usuario,"+
					"nm_usuario, "+"cpf_usuario, "+
					"sexo_usuario, "+"email, "+"senha) "+
			"values (?,?,?,?,?,?)");
			pmst.setInt(1, usr.getCodigo());
			pmst.setString(2, usr.getNome());
			pmst.setString(3, usr.getCpf());
			pmst.setString(4, usr.getSexo());
			pmst.setString(5, usr.getEmail());
			pmst.setString(6, usr.getSenha());


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
				return "CPF ou Email j� existem";
			}
			return "Algum erro inesperado ocorreu";
		} finally{
			conexao.closeConnection();
		}
	}
	public int alterar(UsuarioTO usr) throws Exception{
		Connection con = conexao.getConnection();
		PreparedStatement pmst = null;
		try{
			con.setAutoCommit(false);

			pmst =  con.prepareStatement("update tb_usuario set nm_usuario = ?,cpf_usuario = ?,"+
					"sexo = ?,email = ?,senha = ? "+
			" where  id_usuario = ? ");
			pmst.setInt(7, usr.getCodigo());
			pmst.setString(1, usr.getNome());
			pmst.setString(2, usr.getCpf());
			pmst.setString(3, usr.getSexo());
			pmst.setString(5, usr.getEmail());
			pmst.setString(6, usr.getSenha());



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

	public int excluir(UsuarioTO usr) throws Exception{
		Connection con = conexao.getConnection();
		PreparedStatement pmst = null;
		try{
			con.setAutoCommit(false);
			pmst =  con.prepareStatement("delete from tb_usuario where id_usuario = ?");
			pmst.setInt(1, usr.getCodigo());
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
			ResultSet rs = stmt.executeQuery(" select max(id_usuario) from tb_usuario ");
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

	public UsuarioTO load() throws Exception {
		return null;
	}

	/*       public static void main(String[]args){
            UsuarioTO usr = new UsuarioTO();
            UsuarioDAO dao = new UsuarioDAO();

            usr.setCodigo(dao.getNextPk());
            usr.setNome("Octavio");
            usr.setCpf("09878443698");
            usr.setSexo("masculino");
            usr.setEmail("octavio.braga@gmail.com");
            usr.setSenha("sgaga");


        try {
            dao.insere(usr);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        }*/

	public UsuarioTO logar(String email, String senha) throws Exception {   

		Connection con = conexao.getConnection();
		Statement stmt = null;
		UsuarioTO usuarioTO = new UsuarioTO();
		try{
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select id_usuario, nm_usuario, email, senha from tb_usuario where email = '" + email + "'");

			while(rs.next()){
				usuarioTO.setCodigo(rs.getInt("id_usuario"));
				usuarioTO.setNome(rs.getString("nm_usuario"));
				usuarioTO.setEmail(rs.getString("email"));
				usuarioTO.setSenha(rs.getString("senha"));
			}

			if(usuarioTO.getSenha() != null && !usuarioTO.getSenha().isEmpty() && senha.equals(usuarioTO.getSenha())){
				return usuarioTO;
			}
			return null;

		}catch (Exception e)
		{
			try{
				con.rollback();
				stmt.close();
			}catch (Exception ex) 
			{
				ex.printStackTrace();
			}
			e.printStackTrace();
			return null;
		} finally
		{
			con.close();   
			stmt.close();                
			conexao.closeConnection();
		}
	}


}    
