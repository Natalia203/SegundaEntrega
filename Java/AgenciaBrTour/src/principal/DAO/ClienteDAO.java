package principal.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import principal.Cliente;
import principal.Conexao;

public class ClienteDAO {

	private Connection conexao;

	public ClienteDAO() {
		try {
			conexao = Conexao.conectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void criarCliente(Cliente Cliente) {
		String sql = "INSERT INTO Cliente(nome, cpf, telefone, email, endereco) VALUES (?, ?, ?, ?, ?)";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setString(1, Cliente.getNome());
			stmt.setString(2, Cliente.getCpf());
			stmt.setString(3, Cliente.getTelefone());
			stmt.setString(4, Cliente.getEmail());
			stmt.setString(5, Cliente.getEndereco());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Cliente> listarClientes() {

		List<Cliente> Clientes = new ArrayList<>();
		String sql = "SELECT * FROM Cliente";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			ResultSet resultado = stmt.executeQuery();
			while (resultado.next()) {
				Cliente Cliente = new Cliente();
				Cliente.setId_cliente(resultado.getInt("id_cliente"));
				Cliente.setNome(resultado.getString("nome"));
				Cliente.setCpf(resultado.getString("cpf"));
				Cliente.setTelefone(resultado.getString("telefone"));
				Cliente.setEmail(resultado.getString("email"));
				Cliente.setEndereco(resultado.getString("endereco"));
				Clientes.add(Cliente);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Clientes;
	}

	public Cliente buscarCliente(int id_cliente) {
		Cliente Cliente = null;
		String sql = "SELECT * FROM cliente WHERE id_cliente = ?";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setInt(1, id_cliente);
			ResultSet resultado = stmt.executeQuery();
			if (resultado.next()) {
				Cliente = new Cliente();
				Cliente.setId_cliente(resultado.getInt("id_cliente"));
				Cliente.setNome(resultado.getString("nome"));
				Cliente.setCpf(resultado.getString("cpf"));
				Cliente.setTelefone(resultado.getString("telefone"));
				Cliente.setEmail(resultado.getString("email"));
				Cliente.setEndereco(resultado.getString("endereco"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Cliente;
	}

	public void excluirCliente(int id) {
		String sql = "DELETE FROM Cliente WHERE id_cliente = ?";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setInt(1, id);
			stmt.executeUpdate();
			System.out.println("Cliente excluído.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualizarCliente(Cliente Cliente) {
		String sql = "UPDATE Cliente SET nome = ?, cpf = ?, telefone = ?, email = ?, endereco = ? WHERE id_cliente = ?";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setString(1, Cliente.getNome());
			stmt.setString(2, Cliente.getCpf());
			stmt.setString(3, Cliente.getTelefone());
			stmt.setString(4, Cliente.getEmail());
			stmt.setString(5, Cliente.getEndereco());
			stmt.setInt(6, Cliente.getId_cliente());
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
