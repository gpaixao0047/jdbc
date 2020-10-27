package br.com.avaliacao.update;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.avaliacao.conexao.Conexao;
import br.com.avaliacao.entidade.Pessoa;

public class AlterarNomePessoa {
	public static void main(String[] args) throws SQLException {
		Connection conexao = Conexao.getConnection();
		String novoNome = "Rodriguinho";
		int codigo = 1;
		String select = "SELECT codigo,nome FROM pessoas WHERE codigo = ?";
		String update = "UPDATE pessoas SET nome = ? WHERE codigo = ?";
		PreparedStatement stmt = conexao.prepareStatement(select);
		stmt.setInt(1, codigo);
		ResultSet resultado = stmt.executeQuery();
		
		if(resultado.next()) {
			Pessoa p = new Pessoa(resultado.getInt("codigo"), resultado.getString("nome"));
			System.out.println("O nome atual é " + p.getNome());
			
			stmt.close();
			stmt = conexao.prepareStatement(update);
			stmt.setString(1, novoNome);
			stmt.setInt(2, codigo);
			System.out.println("Pesosa alterada com sucesso!!");
			System.out.println(" O novo nome é : novoNome");
			
		}
		stmt.executeQuery();
		conexao.close();
	}
}
