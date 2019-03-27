package br.senai.sc.domain.enums;

public enum EstadoPagamento {
	PENDENTE(1, "Pendente"), 
	QUITADO(2, "Quitado"), 
	CANCELADO(3, "Cancelado");

	private Integer codigo;
	private String descricao;

	private EstadoPagamento(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public static EstadoPagamento toEnum(Integer codigo) {
		for (EstadoPagamento estado : EstadoPagamento.values()) {
			if(estado.getCodigo() == codigo) {
				return estado;
			}
		}
		return null;
	}
	
	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	
}
