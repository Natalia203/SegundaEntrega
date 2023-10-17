package principal;

import java.util.Date;

public class Viagem {
	int id_viagem;
	Date data_saida;
	Date data_volta;
	float preco;
	private Destino destino;
	
	
	public Viagem(int id_viagem, Date data_saida, Date data_volta, float preco, Destino destino) {
		super();
		this.id_viagem = id_viagem;
		this.data_saida = data_saida;
		this.data_volta = data_volta;
		this.preco = preco;
		this.destino = destino;
	}

	public Viagem() {}

	public int getId_viagem() {
		return id_viagem;
	}

	public void setId_viagem(int id_viagem) {
		this.id_viagem = id_viagem;
	}

	public Date getData_saida() {
		return data_saida;
	}

	public void setData_saida(Date data_saida) {
		this.data_saida = data_saida;
	}

	public Date getData_volta() {
		return data_volta;
	}

	public void setData_volta(Date data_volta) {
		this.data_volta = data_volta;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public Destino getDestino() {
		return destino;
	}

	public void setDestino(Destino destino) {
		this.destino = destino;
	}

	
	
}
