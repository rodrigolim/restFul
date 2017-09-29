package br.com.restful.controller;

import java.util.ArrayList;

import br.com.restful.dao.UsuarioDAO;
import br.com.restful.model.Usuario;

/**
 * 
 * Classe responsável por ser o controlador entre o resource e a camada DAO
 *
 * @author Douglas Costa <douglas.cst90@gmail.com>
 * @since 17/02/2013 02:04:21
 * @version 1.0
 */
public class UsuarioController {
	
	public ArrayList<Usuario> listarTodos(){
		System.out.println("Enviando para o GIT");
		return UsuarioDAO.getInstance().listarTodos();
	}
	
}
