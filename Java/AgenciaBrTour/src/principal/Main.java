package principal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import principal.DAO.ClienteDAO;
import principal.DAO.DestinoDAO;
import principal.DAO.ReservaDAO;
import principal.DAO.ViagemDAO;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ClienteDAO clienteDAO = new ClienteDAO();
		DestinoDAO destinoDAO = new DestinoDAO();
		ViagemDAO viagemDAO = new ViagemDAO();
		ReservaDAO reservaDAO = new ReservaDAO();

		while (true) {
			System.out.println(" Sistema de Gestão de Viagens");
			System.out.println("1. Cadastrar Cliente");
			System.out.println("2. Listar Cliente");
			System.out.println("3. Atualizar Cliente");
			System.out.println("4. Excluir Cliente");
			System.out.println("5. Cadastrar Destino");
			System.out.println("6. Listar Destino");
			System.out.println("7. Atualizar Destino");
			System.out.println("8. Excluir Destino");
			System.out.println("9. Cadastrar Viagem");
			System.out.println("10. Listar Viagens");
			System.out.println("11. Atualizar Viagem");
			System.out.println("12. Excluir Viagem");
			System.out.println("13. Cadastrar Reserva");
			System.out.println("14. Listar Reserva");
			System.out.println("15. Atualizar Reserva");
			System.out.println("16. Excluir Reserva");
			System.out.println("17. Sair");
			System.out.print("Escolha uma opção: ");

			int opcao = scanner.nextInt();

			Date dataAtual;
			switch (opcao) {
			case 1:
				// Cadastrar Cliente
				Cliente cliente = new Cliente();
				System.out.print("Nome: ");
				scanner.nextLine();
				cliente.setNome(scanner.nextLine());
				System.out.print("CPF: ");
				cliente.setCpf(scanner.nextLine());
				System.out.print("Telefone: ");
				cliente.setTelefone(scanner.nextLine());
				System.out.print("E-mail: ");
				cliente.setEmail(scanner.nextLine());
				System.out.print("Endereço: ");
				cliente.setEndereco(scanner.nextLine());
				clienteDAO.criarCliente(cliente);
				System.out.println("Cadastro feito com sucesso!");
				break;

			case 2:
				// Listar Clientes
				List<Cliente> clientes = clienteDAO.listarClientes();
				System.out.println("Lista de Clientes:");
				for (Cliente c : clientes) {
					System.out.println("ID: " + c.getId_cliente() + ", Nome: " + c.getNome() + ", CPF: " + c.getCpf()
							+ ", Telefone: " + c.getTelefone() + ", E-mail: " + c.getEmail() + ", Endereço: "
							+ c.getEndereco());
				}
				break;

			case 3:
				// Atualizar Cliente
				System.out.print("ID do Cliente para atualização: ");
				int clienteIdAtualizar = scanner.nextInt();
				Cliente clienteAtualizar = clienteDAO.buscarCliente(clienteIdAtualizar);
				if (clienteAtualizar != null) {
					System.out.print("Atualizar Nome do Cliente: ");
					scanner.nextLine(); // Limpar o buffer do teclado
					clienteAtualizar.setNome(scanner.nextLine());
					System.out.print("Atualizar CPF: ");
					clienteAtualizar.setCpf(scanner.nextLine());
					System.out.print("Atualizar Telefone: ");
					clienteAtualizar.setTelefone(scanner.nextLine());
					System.out.print("Atualizar E-mail: ");
					clienteAtualizar.setEmail(scanner.nextLine());
					System.out.print("Atualizar Endereço: ");
					clienteAtualizar.setEndereco(scanner.nextLine());
					clienteDAO.atualizarCliente(clienteAtualizar);
					System.out.println("Dados atualizados com sucesso!");
				} else {
					System.out.println("ID do Cliente não encontrado.");
				}
				break;

			case 4:
				// Excluir Cliente
				System.out.print("ID do Cliente para exclusão: ");
				int clienteIdExcluir = scanner.nextInt();
				Cliente clienteExcluir = clienteDAO.buscarCliente(clienteIdExcluir);
				if (clienteExcluir != null) {
					clienteDAO.excluirCliente(clienteIdExcluir);
					System.out.println("Cliente excluído com sucesso!");
				} else {
					System.out.println("ID do Cliente não encontrado.");
				}
				break;

			case 5:
				// Cadastrar Destino
				Destino destino = new Destino();
				System.out.print("Cidade: ");
				scanner.nextLine();
				destino.setCidade(scanner.nextLine());
				System.out.print("Estado: ");
				destino.setEstado(scanner.nextLine());
				System.out.print("Descrição: ");
				destino.setDescricao(scanner.nextLine());
				destinoDAO.criarDestino(destino);
				System.out.println("Cadastro feito com sucesso!");
				break;
			case 6:
				// Listar Destinos
				List<Destino> destinos = destinoDAO.listarDestino();
				System.out.println("Lista de Destinos:");
				for (Destino d : destinos) {
					System.out.println("ID: " + d.getId_destino() + ", Cidade: " + d.getCidade() + ", Estado: "
							+ d.getEstado() + ", Descrição: " + d.getDescricao());
				}
				break;
			case 7:
				// Atualizar Destino
				System.out.print("ID do Destino para atualização: ");
				int destinoIdAtualizar = scanner.nextInt();
				Destino destinoAtualizar = destinoDAO.buscarDestino(destinoIdAtualizar);
				if (destinoAtualizar != null) {
					System.out.print("Atualizar Cidade: ");
					scanner.nextLine(); // Limpar o buffer do teclado
					destinoAtualizar.setCidade(scanner.nextLine());
					System.out.print("Atualizar Estado: ");
					destinoAtualizar.setEstado(scanner.nextLine());
					System.out.print("Atualizar Descrição: ");
					destinoAtualizar.setDescricao(scanner.nextLine());
					destinoDAO.atualizarDestino(destinoAtualizar);
					System.out.println("Destino atualizado com sucesso!");
				} else {
					System.out.println("ID do Destino não encontrado.");
				}
				break;
			case 8:
				// Excluir Destino
				System.out.print("ID do Destino para exclusão: ");
				int destinoIdExcluir = scanner.nextInt();
				Destino destinoExcluir = destinoDAO.buscarDestino(destinoIdExcluir);
				if (destinoExcluir != null) {
					destinoDAO.excluirDestino(destinoIdExcluir);
					System.out.println("Destino excluído com sucesso!");
				} else {
					System.out.println("ID do Destino não encontrado.");
				}
				break;
			case 9:
				// Cadastrar Viagem
				Viagem viagem = new Viagem();
				System.out.print("Data da Saída (dd/mm/yyyy): ");
				String dataSaida = scanner.next();
				try {
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					Date data_saida = sdf.parse(dataSaida);
					viagem.setData_saida(data_saida);
				} catch (ParseException e) {
					System.out.println("Formato de data inválido. Use dd/mm/yyyy.");
				}
				System.out.print("Data da Volta (dd/mm/yyyy): ");
				String dataVolta = scanner.next();
				try {
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					Date data_volta = sdf.parse(dataVolta);
					viagem.setData_volta(data_volta);
				} catch (ParseException p) {
					System.out.println("Formato de data inválido. Use dd/mm/yyyy.");
				}
				System.out.print("Preço da Viagem: ");
				viagem.setPreco(scanner.nextFloat());
				System.out.print("ID do Destino: ");
				int destinoId = scanner.nextInt();
				Destino destinoViagem = destinoDAO.buscarDestino(destinoId);
				if (destinoViagem != null) {
					viagem.setDestino(destinoViagem);
					viagemDAO.criarViagem(viagem);
					System.out.println("Viagem cadastrada com sucesso!");
				} else {
					System.out.println("Destino não encontrado.");
				}
				break;
			case 10:
				// Listar Viagens
				List<Viagem> viagens = viagemDAO.listarViagens();
				System.out.println("Lista de Viagens:");
				for (Viagem v : viagens) {
					System.out.println("ID: " + v.getId_viagem() + ", Data da Saída: " + v.getData_saida()
							+ ", Data da Volta: " + v.getData_volta() + ", Preço: " + v.getPreco() + ", Destino: " + v.getDestino().getId_destino());
				}
				break;
			case 11:
				// Atualizar Viagem
				System.out.print("ID da Viagem para atualização: ");
				int viagemId = scanner.nextInt();
				Viagem viagemAtualizar = viagemDAO.buscarViagem(viagemId);
				if (viagemAtualizar != null) {
					System.out.print("Atualizar Data de Saída (dd/mm/yyyy): ");
					String novaData_saidaString = scanner.next();
					try {
						SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
						Date novaData_saida = sdf.parse(novaData_saidaString);
						viagemAtualizar.setData_saida(novaData_saida);
					} catch (ParseException e) {
						System.out.println("Formato de data inválido. Use dd/mm/yyyy.");
					}
					System.out.print("Atualizar Data da Volta (dd/mm/yyyy): ");
					String novaData_voltaString = scanner.next();
					try {
						SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
						Date novaData_volta = sdf.parse(novaData_voltaString);
						viagemAtualizar.setData_volta(novaData_volta);
					} catch (ParseException p) {
						System.out.println("Formato de data inválido. Use dd/mm/yyyy.");
					}
					System.out.print("Atualizar Preço: ");
					viagemAtualizar.setPreco(scanner.nextFloat());
					viagemDAO.atualizarViagem(viagemAtualizar);
					System.out.println("Viagem atualizada com sucesso!");
				} else {
					System.out.println("Viagem não encontrada.");
				}
				break;
			case 12:
				// Excluir Viagem
				System.out.print("ID da Viagem para exclusão: ");
				int viagemIdExcluir = scanner.nextInt();
				Viagem viagemExcluir = viagemDAO.buscarViagem(viagemIdExcluir);
				if (viagemExcluir != null) {
					viagemDAO.excluirViagem(viagemIdExcluir);
					System.out.println("Viagem excluída com sucesso!");
				} else {
					System.out.println("ID da Viagem não encontrado.");
				}
				break;
			case 13:
				// Cadastrar Reserva
				Reserva reserva = new Reserva();
				java.util.Date dataReserva = new java.util.Date();
				Date dataReserva1 = new Date(dataReserva.getTime());
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String dataFormatada = dateFormat.format(dataReserva1);
				reserva.setData_reserva(dataReserva1);
				System.out.println("Data da reserva: " + dataReserva1);
				System.out.print("ID do Cliente: ");
				int clienteId = scanner.nextInt();
				Cliente clienteReserva = clienteDAO.buscarCliente(clienteId);
				if (clienteReserva != null) {
					reserva.setCliente(clienteReserva);
					System.out.print("ID do Destino: ");
					int id_viagem = scanner.nextInt();
					Viagem viagemReserva = viagemDAO.buscarViagem(id_viagem);
					if (viagemReserva != null) {
						reserva.setViagem(viagemReserva);
						reservaDAO.criarReserva(reserva);
						System.out.println("Reserva realizada com sucesso.");
					} else {
						System.out.println("ID do Destino não encontrado.");
					}
				} else {
					System.out.println("ID do Cliente não encontrado.");
				}
				break;
			case 14:
				List<Reserva> reservas = reservaDAO.listarReservas();
				System.out.println("Lista de Reservas:");
				for (Reserva r : reservas) {
					System.out.println("ID da Reserva: " + r.getId_reserva() + ", Data: " + r.getData_reserva()
							+ ", ID do Cliente: " + r.getCliente().getId_cliente() + ", ID da Viagem: "
							+ r.getViagem().getId_viagem());
				}
				break;

			case 15:
				// Atualizar Reserva
				System.out.print("ID da Reserva para atualização: ");
				int reservaId = scanner.nextInt();
				Reserva reservaAtualizar = reservaDAO.buscarReserva(reservaId);
				if (reservaAtualizar != null) {
					Reserva atualiazarReserva = new Reserva();
					java.util.Date atualizarDataReserva = new java.util.Date();
					Date atualizarDataReserva1 = new Date(atualizarDataReserva.getTime());
					SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String atualizarDataFormatada = dataFormat.format(atualizarDataReserva1);
					reservaAtualizar.setData_reserva(atualizarDataReserva1);
					System.out.println("Data da reserva: " + atualizarDataReserva1);
					System.out.print("ID do Cliente: ");
					int idCliente = scanner.nextInt();
					Cliente ReservaCliente = clienteDAO.buscarCliente(idCliente);
					if (ReservaCliente != null) {
						reservaAtualizar.setCliente(ReservaCliente);
						System.out.print("ID do Destino: ");
						int id_viagem = scanner.nextInt();
						Viagem viagemReserva = viagemDAO.buscarViagem(id_viagem);
						if (viagemReserva != null) {
							reservaAtualizar.setViagem(viagemReserva);
							reservaDAO.atualizarReserva(reservaAtualizar);
							System.out.println("Reserva realizada com sucesso.");
						} else {
							System.out.println("ID da Viagem não encontrado.");
						}
					} else {
						System.out.println("ID do Cliente não encontrado.");
					}
				} else {
					System.out.println("Reserva não encontrada.");
				}
				break;
			case 16:
				// Excluir Reserva
				System.out.print("ID da Reserva para exclusão: ");
				int reservaIdExcluir = scanner.nextInt();
				Reserva reservaExcluir = reservaDAO.buscarReserva(reservaIdExcluir);
				if (reservaExcluir != null) {
					reservaDAO.excluirReserva(reservaIdExcluir);
					System.out.println("Reserva excluída com sucesso!");
				} else {
					System.out.println("Reserva não encontrada.");
				}
				break;
			case 17:
				// Sair
				System.out.println("Saindo do sistema...");
				clienteDAO.fecharConexao();
				destinoDAO.fecharConexao();
				viagemDAO.fecharConexao();
				reservaDAO.fecharConexao();
				scanner.close();
				System.exit(0);
			default:
				System.out.println("Opção inválida. Tente novamente.");
				break;

			}
		}
	}
}
