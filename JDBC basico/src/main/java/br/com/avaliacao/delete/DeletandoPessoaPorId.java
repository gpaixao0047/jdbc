package br.com.avaliacao.delete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.avaliacao.conexao.Conexao;

public class DeletandoPessoaPorId {
	public static void main(String[] args) throws SQLException {

		Connection conexao = Conexao.getConnection();
		int codigo = 4;
		String sql = "DELETE FROM pessoas WHERE codigo = ?";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setInt(1, codigo);

		if (stmt.executeUpdate() > 0) {
			System.out.println("Pessoa excluida com sucesso");
		}else {
			System.out.println("Problema ao excluir");
		}
		stmt.executeQuery();
		conexao.close();
	}

}
