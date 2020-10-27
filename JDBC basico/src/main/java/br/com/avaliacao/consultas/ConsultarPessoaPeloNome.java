package br.com.avaliacao.consultas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.avaliacao.conexao.Conexao;
import br.com.avaliacao.entidade.Pessoa;

public class ConsultarPessoaPeloNome {
	public static void main(String[] args) throws SQLException {
		Connection conexao = Conexao.getConnection();
		String sql= "SELECT *FROM pessoas WHERE nome like ?";
		
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, "Larissa");
		ResultSet resultado = stmt.executeQuery();
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		while(resultado.next()) {
			int codigo = resultado.getInt("codigo");
			String nome = resultado.getString("nome");
			pessoas.add(new Pessoa(codigo, nome));
		}
		for(Pessoa p: pessoas) {
			System.out.println(p.getNome() + " --> " + p.getCodigo());
		}
	}
}
