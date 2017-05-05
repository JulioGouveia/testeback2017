package br.com.testeback2017.main;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import br.com.testeback2017.config.JPAUtil;
import br.com.testeback2017.dao.ClienteDao;
import br.com.testeback2017.modelo.Ativo;
import br.com.testeback2017.modelo.Cliente;

public class Processa {

	public static void main(String[] args) {

		boolean continua = true;
		Scanner scan = new Scanner(System.in);
		EntityManager em = new JPAUtil().createEntityManager();
		ClienteDao dao = new ClienteDao();

		while (continua) {

			Cliente cliente = new Cliente();

			System.out.println("[[IMPORTANTE]Insira os dados na ordem: CPF,NOME,ATIVO ou INATIVO,SALDO]");
			System.out.println("CPF/CNPJ:");
			String cpf = scan.nextLine();
			cliente.setCpf_cnpj(cpf);

			System.out.println("Nome:");
			String nome = scan.nextLine();
			cliente.setNm_customer(nome);

			System.out.println("Ativo [s/n]:");
			String ehAtivo = scan.nextLine();
			Ativo valueOfActive = Ativo.valueOf(ehAtivo);
			cliente.setIs_active(valueOfActive);

			System.out.println("Saldo R$:");
			String valor = scan.nextLine();
			double valor2 = Double.parseDouble(valor);
			cliente.setVl_total(valor2);
			
			System.out.println(valor2);

			dao.persisteUmCliente(cliente);

			System.out.println("[Deseja adicionar outro Cliente: [S/N]]");
			String resp = scan.nextLine();
			if (resp.equals("n"))
				continua = false;

		}

		double buscaMediaVlTotal = dao.buscaMediaVlTotal();
		DecimalFormat df = new DecimalFormat("0.##");
		String valorFotmatado = df.format(buscaMediaVlTotal);
		System.out.println("[[Medforia do Valor Total]: --->" + valorFotmatado + "]\n");

		List<Cliente> buscaClientes = dao.buscaClientes();
		System.out.println("[Lista Base para Calculo da media]--->");
		for (Cliente cliente : buscaClientes) {

			System.out.println(cliente);

		}
	}

}
