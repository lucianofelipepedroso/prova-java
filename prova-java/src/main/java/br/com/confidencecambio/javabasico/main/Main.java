package br.com.confidencecambio.javabasico.main;

import br.com.confidencecambio.javabasico.exception.NomeException;
import br.com.confidencecambio.javabasico.modelo.Cliente;
import br.com.confidencecambio.javabasico.modelo.ConfigNome;
import br.com.confidencecambio.javabasico.modelo.Gerente;
import br.com.confidencecambio.javabasico.modelo.Robo;

public class Main {

	public static void main(String[] args)  {
		ConfigNome cliente = null;
		ConfigNome gerente=null;
		ConfigNome robo = null;

		try {
			cliente = new Cliente("Luciano Felipe Pedroso");
			gerente = new Gerente("José Carlos Da Silva Souza");
			robo = new Robo("Robô teste");
		} catch (NomeException e) {
			System.out.println(e.getMessage());
		}

		System.out.println(cliente.primeiroNome());
		System.out.println(gerente.primeiroNome());
		System.out.println(robo.primeiroNome());

		try {
			System.out.println(cliente.ultimoNome());
			System.out.println(gerente.ultimoNome());
			System.out.println(robo.ultimoNome());
		} catch (NomeException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.println(cliente.nomeAbreviado());
			System.out.println(gerente.nomeAbreviado());
			System.out.println(robo.nomeAbreviado());
		} catch (NomeException e) {
		    System.out.println(e.getMessage());
		}
		
          System.out.println(cliente.getNomeMaiusculo());
          System.out.println(gerente.getNomeMaiusculo());
          System.out.println(robo.getNomeMaiusculo());
		
	}

}
