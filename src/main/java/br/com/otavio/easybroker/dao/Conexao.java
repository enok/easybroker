package br.com.otavio.easybroker.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.otavio.easybroker.to.EmpresaTO;

public class Conexao {

	private static Connection conn = null;

	public Connection getConnection(){

		try{
			if(conn == null ){
				Class.forName("org.postgresql.Driver");
				conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Easybroker","postgres","434901");



				//String url = "jdbc:postgresql://THE_HOST/THE_DATABASE";

				// get the postgresql database connection
				//connection = DriverManager.getConnection(url,"THE_USER", "THE_PASSWORD");

				//"jdbc:oracle:thin:@localhost:1521:Easybroker","sysman","octavio");
			}
			return conn;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void closeConnection(){
		try {
			conn.close();
			conn = null;
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	/*public static void main(String args[]){
		try{
			Conexao.getConnection();
			System.out.println("Conectado com sucesso");
			
			ArrayList arl = new ArrayList<EmpresaTO>();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select id_empresa,"+
						"cnpj_empresa,"+"ramo_empresa, "+
				"nm_empresa from tb_Empresa");
			while (rs.next()) {
					EmpresaTO emp = new EmpresaTO();
					emp.setCodigoemp(rs.getInt(1));
					emp.setNomeemp(rs.getString("nm_empresa"));
					emp.setCnpj(rs.getString("cnpj_empresa"));
					emp.setRamo(rs.getString("ramo_empresa"));
					arl.add(emp);
			}
			rs.close();
			stmt.close();
			
		}catch(Exception e){
			System.out.println("Erro conexao"+ e.getMessage());
		}
	}*/
}
