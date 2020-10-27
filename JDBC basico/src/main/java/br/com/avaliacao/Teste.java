package br.com.avaliacao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.avaliacao.conexao.Conexao;

public class Teste {
	public static void main(String[] args) throws SQLException {
		Connection conexao = Conexao.getConnection();
		Statement stmt = conexao.createStatement();
		
	}
}
