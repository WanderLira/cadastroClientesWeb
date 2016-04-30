package entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class PessoaFisica extends Cliente{
	@Column(nullable=false)
	private String cpf;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
