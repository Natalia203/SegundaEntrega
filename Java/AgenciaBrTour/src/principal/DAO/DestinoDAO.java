package principal.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import principal.Conexao;
import principal.Destino;

public class DestinoDAO {

	private Connection conexao;

	public DestinoDAO() {
		try {
			conexao = Conexao.conectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void criarDestino(Destino Destino) {
		String sql = "INSERT INTO Destino(cidade, estado, descricao) VALUES (?, ?, ?)";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setString(1, Destino.getCidade());
			stmt.setString(2, Destino.getEstado());
			stmt.setString(3, Destino.getDescricao());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Destino> listarDestino() {

		List<Destino> Destinos = new ArrayList<>();
		String sql = "SELECT * FROM Destino";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			ResultSet resultado = stmt.executeQuery();
			while (resultado.next()) {
				Destino Destino = new Destino();
				Destino.setId_destino(resultado.getInt("id_destino"));
				Destino.setCidade(resultado.getString("cidade"));
				Destino.setEstado(resultado.getString("estado"));
				Destino.setDescricao(resultado.getString("descricao"));
				Destinos.add(Destino);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Destinos;
	}

	public Destino buscarDestino(int id_destino) {
		Destino Destino = null;
		String sql = "SELECT * FROM destino WHERE id_destino = ?";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setInt(1, id_destino);
			ResultSet resultado = stmt.executeQuery();
			if (resultado.next()) {
				Destino = new Destino();
				Destino.setId_destino(resultado.getInt("id_destino"));
				Destino.setCidade(resultado.getString("cidade"));
				Destino.setEstado(resultado.getString("estado"));
				Destino.setEstado(resultado.getString("descricao"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Destino;
	}

	public void excluirDestino(int id) {
		String sql = "DELETE FROM Destino WHERE id_destino = ?";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setInt(1, id);
			stmt.executeUpdate();
			System.out.println("Destino excluído.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualizarDestino(Destino Destino) {
		String sql = "UPDATE Destino SET cidade = ?, estado = ?, descricao = ? WHERE id_destino = ?";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setString(1, Destino.getCidade());
			stmt.setString(2, Destino.getEstado());
			stmt.setString(3, Destino.getDescricao());
			stmt.setInt(4, Destino.getId_destino());
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
