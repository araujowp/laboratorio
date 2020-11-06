package br.com.estudojava.arquivo.txt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Lertexto {

	private FileReader fileReader;
	private BufferedReader bufferedReader;

	public Lertexto(String nome) throws FileNotFoundException {
		fileReader = new FileReader(nome);
		bufferedReader  = new BufferedReader(fileReader);
	}
	
	public String ler() throws IOException {
		return bufferedReader.readLine();
	}
	
}
