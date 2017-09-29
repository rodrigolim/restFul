package br.com.restful.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 * 
 * Classe responsável por conter os metodos criar e fechar o banco de dados.
 *
 * @author Rodrigo de Lima Cunha
 * @since 29/09/2017 01:54:02
 * @version 1.0
 */
public class ConnectionFactory {

	// Caminho do banco de dados.
	private static final String DRIVER = "org.postgresql.Driver";
	private static final String URL = "jdbc:postgresql://cafi-aws.cqztijtdwnpu.sa-east-1.rds.amazonaws.com:5432/cafi";
	private static final String USUARIO = "rodrigo";
	private static final String SENHA = "libera00";
	

	/**
	 * 
	 * Método responsável por criar uma conexao com o banco 
	 */
	public Connection criarConexao(){
		
		Connection conexao = null;
		
		try {
			
			Class.forName(DRIVER);
			conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
			
		} catch (Exception e) {
			System.out.println("Erro ao criar conexão com o banco: " + URL);
			e.printStackTrace();
		}
		return conexao;
	}
	
	
	public void fecharConexao(Connection conexao, PreparedStatement pstmt, ResultSet rs){
		
		try {
			
			if(conexao != null){
				conexao.close();
			}
			if(pstmt != null){
				pstmt.close();
			}
			if(rs != null){
				rs.close();
			}
					
		} catch (Exception e) {
			System.out.println("Erro ao fechar conexão com o banco: " + URL);
		}
	}
}

