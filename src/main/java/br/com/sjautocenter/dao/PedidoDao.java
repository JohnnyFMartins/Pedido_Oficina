package br.com.sjautocenter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.sjautocenter.model.Pedido;

public class PedidoDao {
	private Connection conexao;

	// PedidoDao = new PedidoDao();
	public PedidoDao() {
		conexao = ConnectionFactory.conectar();
	}

	public void inserir(Pedido pedido) {
		String sql = "INSERT INTO pedidos (nome, modelo, placa, descricao, data_pedido, status_pedido)"
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		// java.sql
		PreparedStatement smtp; // Executar a consulta sql
		try {

			smtp = conexao.prepareStatement(sql);
			// Preencher a posição 1 com o nome
			smtp.setString(1, pedido.getNome());
			smtp.setString(2, pedido.getModelo());
			smtp.setString(3, pedido.getPlaca());
			smtp.setString(4, pedido.getDescricao());
			smtp.setDate(5, pedido.getData());
			smtp.setString(6, pedido.getStatus());

			smtp.execute(); // Executar
			smtp.close();
			conexao.close();
		} catch (Exception e) {
			System.out.println("Deu erro: " + e.getMessage());
		}
	}

	public List<Pedido> listar() {
		String sql = "SELECT * FROM pedidos";

		PreparedStatement smtp;
		List<Pedido> pedidos = new ArrayList<Pedido>();
		try {
			smtp = conexao.prepareStatement(sql);
			// resultado = Listadepizza[], [ {}, {} ]
			// java.sql
			ResultSet resultado = smtp.executeQuery();
			// resultado (Lista de Pedidos <ResultSet>)
			while (resultado.next()) {
				Pedido pe = new Pedido();
				// pegando o nome da coluna
				pe.setId(resultado.getLong("id"));
				pe.setNome(resultado.getString("nome"));
				pe.setModelo(resultado.getString("modelo"));
				pe.setPlaca(resultado.getString("placa"));
				pe.setDescricao(resultado.getString("descricao"));
				pe.setData(resultado.getDate("data_pedido"));
				pe.setStatus(resultado.getString("status_pedido"));
				pedidos.add(pe);
			}
			resultado.close();
			smtp.close();
			conexao.close();
			return pedidos;
			
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
	public Pedido buscar(Long id) {
		String sql = "SELECT * FROM pedidos WHERE id = ?";
		
		PreparedStatement smtp;
		
		try {
			smtp = conexao.prepareStatement(sql);
			smtp.setLong(1, id);
			ResultSet resultado = smtp.executeQuery();
			Pedido p = null; // não instanciando
			
			while (resultado.next()) {
				p = new Pedido();
				p.setId(resultado.getLong("id"));
				p.setNome(resultado.getString("nome"));
				p.setModelo(resultado.getString("modelo"));
				p.setPlaca(resultado.getString("placa"));
				p.setDescricao(resultado.getString("descricao"));
				p.setData(resultado.getDate("data_pedido"));
				p.setStatus(resultado.getString("status_pedido"));
			}
			
			smtp.close();
			resultado.close();
			conexao.close();
			return p;
			
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
	public void excluir(Long id) {
		String sql = "DELETE FROM pedidos WHERE id = ?";
		
		PreparedStatement smtp;
		
		try {
			smtp = conexao.prepareStatement(sql);
			smtp.setLong(1, id); // id = ?
			
			smtp.execute();
			smtp.close();
			conexao.close();
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
	public void atualizar(Long id, Pedido p) {
		String sql = "UPDATE pedidos SET nome=?, modelo=?, placa=?, descricao=?, data_pedido=?, status_pedido=? WHERE id = ?";
		
		PreparedStatement smtp;
		
		try {
			// 1 => nome, 2 => modelo, 3 => placa, 4 => descrição, 5 => data_pedido, 6 => status_pedido, 7 => id
			smtp = conexao.prepareStatement(sql);
			smtp.setString(1, p.getNome());
			smtp.setString(2, p.getModelo());
			smtp.setString(3, p.getPlaca());
			smtp.setString(4, p.getDescricao());
			smtp.setDate(5, p.getData());
			smtp.setString(6, p.getStatus());
			smtp.setLong(7, id); // id = ?
			
			smtp.execute();
			smtp.close();
			conexao.close();
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
}
