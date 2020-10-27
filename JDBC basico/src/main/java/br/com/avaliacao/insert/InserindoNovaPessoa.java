package br.com.avaliacao.insert;

import br.com.avaliacao.conexao.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class InserindoNovaPessoa {
	public static void main(String[] args) throws SQLException {
		Connection conexao = Conexao.getConnection();
		String nome = "Rodrigo";
		String sql = "INSERT INTO pessoas (nome) VALUES (?) ";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, nome);
		stmt.execute();
		System.out.println("Usuario cadastrado com sucesso!!");
		System.out.println(sql);
		stmt.close();
	}
}
