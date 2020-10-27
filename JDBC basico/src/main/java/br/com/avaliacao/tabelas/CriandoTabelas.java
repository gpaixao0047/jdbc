package br.com.avaliacao.tabelas;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.avaliacao.conexao.Conexao;

public class CriandoTabelas {

	public static void main(String[] args) throws SQLException {
		Connection conexao = Conexao.getConnection();
		
		String sql = "CREATE TABLE pessoas ("
				+ "codigo SERIAL PRIMARY KEY, "
				+ "nome varchar NOT NULL"
				+ ")";
		
		Statement stmt = conexao.createStatement();
		stmt.execute(sql);
		
		System.out.println("Tabela Criada");
		conexao.close();

	}

}
