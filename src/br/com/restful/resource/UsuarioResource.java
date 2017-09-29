package br.com.restful.resource;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.com.restful.controller.UsuarioController;
import br.com.restful.model.Usuario;

import com.google.gson.Gson;

/**
 * 
 * Classe responsável por conter os metodos REST de acesso ao webservice
 *
 * @author Douglas Costa <douglas.cst90@gmail.com>
 * @since 17/02/2013 02:05:23
 * @version 1.0
 */
@Path("/usuario")
public class UsuarioResource {

	/**
	 * 
	 * Método responsável por fazer chamada ao controller
	 *
	 * @return ArrayList<Usuario> 
	 * @author Douglas Costa <douglas.cst90@gmail.com.br>
	 * @since 17/02/2013 02:07:08
	 * @version 1.0
	 */
	@GET
	@Path("/listarTodos")
	@Produces("application/json")
	public ArrayList<Usuario> listarTodos(){
		return new UsuarioController().listarTodos();
	}
}
