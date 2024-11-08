package br.com.sjautocenter.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	private static final String USER = "root";
	private static final String SENHA = "root";

	// biblioteca -> java.sql
	public static Connection conectar() {
		// java database connection
		try {
			// invocando a biblioteca de conexão ao banco de dados
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexao = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/pedido", USER,
					SENHA);
			return conexao;

		} catch (Exception e) {
			// throw -> jogar para cima
			// RuntimeException -> erro que aconteceu enquanto o codigo rodava
			throw new RuntimeException();

		}
	}
}
