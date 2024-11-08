package br.com.sjautocenter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.sjautocenter.dao.ConnectionFactory;
import br.com.sjautocenter.dao.PedidoDao;
import br.com.sjautocenter.model.Pedido;

// Anotação
@Controller
public class IndexController {

	@RequestMapping("/")
	public String inicio() {
		// Conectar ao banco de dados
		ConnectionFactory.conectar();
		// Redirecionar para rota /home
		return "redirect:home";

	}

	@RequestMapping("/home") // http://localhost:8080 /
	// String -> Retorno de uma pagina
	public String index(Model model) { // org.springframework
		PedidoDao dao = new PedidoDao();
		
		// items="${pedidos}"
		model.addAttribute("pedidos", dao.listar());
		
		return "index"; // home.html

	}

	@RequestMapping("/form")
	public String form(Long idPedido, Model model) {
		PedidoDao dao = new PedidoDao();
		
		Pedido p = new Pedido();
		
		if (idPedido != null) {
			p = dao.buscar(idPedido);
		}
		
		model.addAttribute("pedido", p);
		
		return "form"; // form.html

	}

	@RequestMapping("/pedido")
	public String pedido(Long idPedido, Model model) {
		PedidoDao dao = new PedidoDao();
		model.addAttribute("pedido", dao.buscar(idPedido));
		return "pedido";

	}
	
	@RequestMapping(value = "adicionarPedido", method = RequestMethod.POST)
	public String adicionarPedido(Pedido pedido) {
		PedidoDao dao = new PedidoDao();
		dao.inserir(pedido);
		return "redirect:home";	// Volta para home e atualiza	
	}
	
	// /atualizarPedido (nome do value) / GET | POST | PUT | DELETE (tipos de method)
	/**
	 * GET - Buscar informações
	 * POST - Criar informaçoões
	 * PUT - Atualizar informações
	 * DELETE - Deleta informações
	 */
	
	@RequestMapping(value = "atualizarPedido", method = RequestMethod.POST)
	public String atualizarPedido(Long idPedido, Pedido p) {
		
		PedidoDao dao = new PedidoDao();
		dao.atualizar(idPedido, p);
		
		return "redirect:home"; 
	}
	
	
	@RequestMapping("deletarPedido")
	public String deletarPedido(Long idPedido) {
		
		PedidoDao dao = new PedidoDao();
		dao.excluir(idPedido);
		
		return "redirect:home";
	}

}
