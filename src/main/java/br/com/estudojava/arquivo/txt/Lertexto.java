package br.com.estudojava.arquivo.txt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Lertexto {

	private FileReader fileReader;
	private BufferedReader bufferedReader;

	public Lertexto(String nome) throws FileNotFoundException {
		fileReader = new FileReader(nome);
		bufferedReader  = new BufferedReader(fileReader);
	}
	
	public String getLinha() throws IOException {
		return bufferedReader.readLine();
	}
	
	public ArrayList<String> getLinhas() throws IOException{
		
		ArrayList<String> linhas = new ArrayList<String>();
		
		String linha = getLinha();
		while(linha != null ) {
			linhas.add(linha);
			linha = getLinha();
		}
		return linhas;
	}
	
}
