package principal.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import principal.Conexao;
import principal.Viagem;

public class ViagemDAO {

	private Connection conexao;
	DestinoDAO destinoDAO = new DestinoDAO();

	public ViagemDAO() {
		try {
			conexao = Conexao.conectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void criarViagem(Viagem viagem) {
		String sql = "INSERT INTO viagem (data_saida, data_volta, preco, id_destino) VALUES (?, ?, ?, ?)";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setTimestamp(1, new java.sql.Timestamp(viagem.getData_saida().getTime()));
			stmt.setTimestamp(2, new java.sql.Timestamp(viagem.getData_volta().getTime()));
			stmt.setFloat(3, viagem.getPreco());
			stmt.setInt(4, viagem.getDestino().getId_destino());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Viagem buscarViagem(int id_viagem) {
		Viagem viagem = null;
		String sql = "SELECT * FROM viagem WHERE id_viagem = ?";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setInt(1, id_viagem);
			ResultSet resultado = stmt.executeQuery();
			if (resultado.next()) {
				viagem = new Viagem();
				viagem.setId_viagem(resultado.getInt("id_viagem"));
				viagem.setData_saida(resultado.getTimestamp("data_saida"));
				viagem.setData_volta(resultado.getTimestamp("data_volta"));
				viagem.setPreco(resultado.getFloat("preco"));
				viagem.setDestino(destinoDAO.buscarDestino(resultado.getInt("id_destino")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return viagem;
	}

	public List<Viagem> listarViagens() {
		List<Viagem> viagens = new ArrayList<>();
		String sql = "SELECT * FROM viagem";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			ResultSet resultado = stmt.executeQuery();
			while (resultado.next()) {
				Viagem viagem = new Viagem();
				viagem.setId_viagem(resultado.getInt("id_viagem"));
				viagem.setData_saida(resultado.getTimestamp("data_saida"));
				viagem.setData_volta(resultado.getTimestamp("data_volta"));
				viagem.setPreco(resultado.getFloat("preco"));
				viagem.setDestino(destinoDAO.buscarDestino(resultado.getInt("id_destino")));
				viagens.add(viagem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return viagens;
	}

	public void atualizarViagem(Viagem viagem) {
		String sql = "UPDATE viagem SET data_saida = ?, data_volta = ?, preco = ?, id_destino = ? WHERE id_viagem = ?";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setTimestamp(1, new java.sql.Timestamp(viagem.getData_saida().getTime()));
			stmt.setTimestamp(2, new java.sql.Timestamp(viagem.getData_volta().getTime()));
			stmt.setFloat(3, viagem.getPreco());
			stmt.setInt(4, viagem.getDestino().getId_destino());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void excluirViagem(int id_viagem) {
		String sql = "DELETE FROM viagem WHERE id_viagem = ?";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setInt(1, id_viagem);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void fecharConexao() {
		try {
			if (conexao != null && !conexao.isClosed()) {
				conexao.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
