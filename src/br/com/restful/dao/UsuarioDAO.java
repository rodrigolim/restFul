package br.com.restful.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.restful.factory.ConnectionFactory;
import br.com.restful.model.Usuario;

/**
 * 
 * Classe responsável por conter os metodos do CRUD
 *
 * @author Douglas Costa <douglas.cst90@gmail.com>
 * @since 17/02/2013 01:55:13
 * @version 1.0
 */
public class UsuarioDAO extends ConnectionFactory {

	private static UsuarioDAO instance;
	
	
	/**
	 * 
	 * Método responsável por criar uma instancia da classe UsuarioDAO (Singleton)
	 *
	 * @return
	 * @author Douglas Costa <douglas.cst90@gmail.com.br>
	 * @since 17/02/2013 02:03:47
	 * @version 1.0
	 */
	public static UsuarioDAO getInstance(){
		if(instance == null)
			instance = new UsuarioDAO();
		return instance;
	}
	
	/**
	 * 
	 * Método responsável por listar todos os usuarios do banco
	 *
	 * @return ArrayList<Usuario> usuarios
	 * @author Douglas Costa <douglas.cst90@gmail.com.br>
	 * @since 17/02/2013 02:01:35
	 * @version 1.0
	 */
	public ArrayList<Usuario> listarTodos(){
		Connection conexao = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Usuario> usuarios = null;
		
		conexao = criarConexao();
		usuarios = new ArrayList<Usuario>();
		try {
			pstmt = conexao.prepareStatement("select * from usuario order by usu_nome");
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Usuario usuario = new Usuario();
				
				usuario.setId(rs.getInt("usu_id"));
				usuario.setNome(rs.getString("usu_nome"));
				usuario.setSenha(rs.getString("usu_senha"));
				
				usuarios.add(usuario);
			}
			
		} catch (Exception e) {
			System.out.println("Erro ao listar todos os usuario: " + e);
			e.printStackTrace();
		} finally {
			fecharConexao(conexao, pstmt, rs);
		}
		return usuarios;
	}
	
}
