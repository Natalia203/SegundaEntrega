package principal.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import principal.Conexao;
import principal.Reserva;

public class ReservaDAO {

	private Connection conexao;
	ClienteDAO clienteDAO = new ClienteDAO();
	ViagemDAO viagemDAO = new ViagemDAO();

	public ReservaDAO() {
		try {
			conexao = Conexao.conectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void criarReserva(Reserva reserva) {
		String sql = "INSERT INTO reserva(data_reserva, id_cliente, id_viagem) VALUES (?, ?, ?)";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setTimestamp(1, new java.sql.Timestamp(reserva.getData_reserva().getTime()));
			stmt.setInt(2, reserva.getCliente().getId_cliente());
			stmt.setInt(3, reserva.getViagem().getId_viagem());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Reserva> listarReservas() {
		List<Reserva> reservas = new ArrayList<>();
		String sql = "SELECT * FROM reserva";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			ResultSet resultado = stmt.executeQuery();
			while (resultado.next()) {
				Reserva reserva = new Reserva();
				reserva.setId_reserva(resultado.getInt("id_reserva"));
				reserva.setData_reserva(resultado.getTimestamp("data_reserva"));
				reserva.setCliente(clienteDAO.buscarCliente(resultado.getInt("id_cliente")));
				reserva.setViagem(viagemDAO.buscarViagem(resultado.getInt("id_viagem")));
				reservas.add(reserva);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reservas;
	}

	public Reserva buscarReserva(int id_reserva) {
		Reserva reserva = null;
		String sql = "SELECT * FROM reserva WHERE id_reserva = ?";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setInt(1, id_reserva);
			ResultSet resultado = stmt.executeQuery();
			if (resultado.next()) {
				reserva = new Reserva();
				reserva.setId_reserva(resultado.getInt("id_reserva"));
				reserva.setData_reserva(resultado.getTimestamp("data_reserva"));
				reserva.setCliente(clienteDAO.buscarCliente(resultado.getInt("id_cliente")));
				reserva.setViagem(viagemDAO.buscarViagem(resultado.getInt("id_viagem")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reserva;
	}

	public void atualizarReserva(Reserva reserva) {
		String sql = "UPDATE reserva SET data_reserva = ?, id_cliente = ?, id_viagem = ? WHERE id_reserva = ?";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setTimestamp(1, new java.sql.Timestamp(reserva.getData_reserva().getTime()));
			stmt.setInt(2, reserva.getCliente().getId_cliente());
			stmt.setInt(3, reserva.getViagem().getId_viagem());
			stmt.setInt(4, reserva.getId_reserva());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

    public void excluirReserva(int id_reserva) {
        String sql = "DELETE FROM reserva WHERE id_reserva = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id_reserva);
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
