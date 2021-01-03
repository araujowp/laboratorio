package br.com.estudojava.arquivo.txt;

import java.io.IOException;

public class TestaLerTexto {

	public static void main(String[] args) {
		System.out.println("vamos ler um texto e imprimir seu conteudo abaixo:");
		
		try {
			LerTexto lerTexto  = new LerTexto("c:\\teste\\arquivo.txt");
			
			String linha = lerTexto.getLinha();
			while(linha != null) {
				System.out.println(linha);
				linha = lerTexto.getLinha();
			}
			
		} catch (IOException e) {
			System.out.println("opa não conseguimos ler o texto:" + e.getMessage());
		}
	}
	
}
