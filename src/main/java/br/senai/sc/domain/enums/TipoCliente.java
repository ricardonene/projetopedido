package br.senai.sc.domain.enums;

public enum TipoCliente {
	
	PESSOAFISICA (1, "Pessoa Física"),
	PESSOAF (3, "Pessoa Física"),
	PESSOAJURIDICA (2, "Pessoa Jurídica");
	
	private Integer codigo;
	private String descricao;
	
	public static TipoCliente toEnum(Integer codigo) {
		for (TipoCliente tipo : TipoCliente.values()) {
			if(tipo.getCodigo() == codigo) {
				return tipo;
			}
		}
		return null;
	}
	
	private TipoCliente(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}
	
	
	
}
