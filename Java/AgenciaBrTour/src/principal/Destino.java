package principal;

public class Destino {

	private int id_destino;
	private String cidade;
	private String estado;
	private String descricao;
	
	
	public Destino(int id_destino, String cidade, String estado, String descricao) {
		super();
		this.id_destino = id_destino;
		this.cidade = cidade;
		this.estado = estado;
		this.descricao = descricao;
	}
	
	public Destino() {	
	
	}

	public int getId_destino() {
		return id_destino;
	}

	public void setId_destino(int id_destino) {
		this.id_destino = id_destino;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
}
