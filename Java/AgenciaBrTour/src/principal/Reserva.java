package principal;

import java.util.Date;

public class Reserva {
    private int id_reserva;
	private Date data_reserva;
	private Cliente cliente;
	private Viagem viagem;
	
	public Reserva(int id_reserva, Date data_reserva, Cliente cliente, Viagem viagem) {
		super();
		this.id_reserva = id_reserva;
		this.data_reserva = data_reserva;
		this.cliente = cliente;
		this.viagem = viagem;
	}
	
	public Reserva() {
		
	}

	public int getId_reserva() {
		return id_reserva;
	}

	public void setId_reserva(int id_reserva) {
		this.id_reserva = id_reserva;
	}

	public Date getData_reserva() {
		return data_reserva;
	}

	public void setData_reserva(Date data_reserva) {
		this.data_reserva = data_reserva;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Viagem getViagem() {
		return viagem;
	}

	public void setViagem(Viagem viagem) {
		this.viagem = viagem;
	}

}
