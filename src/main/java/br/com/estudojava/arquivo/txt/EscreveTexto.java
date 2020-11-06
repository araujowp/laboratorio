package br.com.estudojava.arquivo.txt;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class EscreveTexto {

	private FileWriter fileWriter;
	private PrintWriter printWriter;
	
	public void criar(String nome) throws IOException {
		
		fileWriter = new FileWriter(nome); 
		printWriter  = new PrintWriter(fileWriter);
	}

	public void escrever(String texto) {
		printWriter.printf(texto + "%n");
	}
	
	public void fechar() throws IOException {
		fileWriter.close();
	}
}
