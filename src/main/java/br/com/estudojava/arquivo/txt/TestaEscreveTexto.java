package br.com.estudojava.arquivo.txt;

import java.io.IOException;

public class TestaEscreveTexto {

	public static void main(String[] args) {
		
		try {
			System.out.println("Vamos gerar um arquivo no disco ");
			EscreveTexto escreveTexto = new EscreveTexto(); 
			escreveTexto.criar("c:\\teste\\arquivo.txt");
			System.out.println("Vamos vamos escrever duas linhas e fechar  ");
			escreveTexto.escrever("nossa primeira linha "); 
			escreveTexto.escrever("nossa segunda linha ");
			escreveTexto.fechar();
		} catch (IOException e) {
			System.out.println("Opa não conseguimos criar o arquivo " + e.getMessage());
		}
		
	}
	
}
