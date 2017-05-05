package br.com.testeback2017.modelo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_customer;

	@Column(unique = true)
	private String cpf_cnpj;

	private String nm_customer;

	@Enumerated
	private Ativo is_active;

	private double vl_total;

	public Integer getId_customer() {
		return id_customer;
	}

	public void setId_customer(Integer id_customer) {
		this.id_customer = id_customer;
	}

	public String getCpf_cnpj() {
		return cpf_cnpj;
	}

	public void setCpf_cnpj(String cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}

	public String getNm_customer() {
		return nm_customer;
	}

	public void setNm_customer(String nm_customer) {
		this.nm_customer = nm_customer;
	}

	public Ativo getIs_active() {
		return is_active;
	}

	public void setIs_active(Ativo is_active) {
		this.is_active = is_active;
	}

	public double getVl_total() {
		return vl_total;
	}

	public void setVl_total(double vl_total) {
		this.vl_total = vl_total;
	}

	@Override
	public String toString() {
		return "Cliente [ID: " + id_customer + ", CPF/CNPJ: " + cpf_cnpj + ", NOME: " + nm_customer
				+ ", ATIVO/INATIVO: " + is_active + ", SALDO TOTAL: " + vl_total + "]";
	}

}
