package br.com.estudojava.decorador;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import br.com.estudojava.arquivo.txt.LerTexto;

public class Banco {

	private String caminho;

	public Banco(String caminho) {
		this.caminho = caminho;
	}
	
	private ArrayList<String> getLinhas() throws IOException{
		LerTexto lerTexto;
		lerTexto = new LerTexto(caminho);
		return lerTexto.getLinhas();
	}
	
	public HashMap<String, String> getRegistros(String filtro) throws IOException {
		
		HashMap<String, String> map = new HashMap<String, String>();
		ArrayList<String> linhas = getLinhas();

		if(linhas.size() == 0 ) 
			return map;
		
		for (String linha : linhas) {
			
			String[] registro = linha.split(";");
			if (filtro.equals(registro[0].trim().toUpperCase()) || filtro.equals("*")) {
				map.put(registro[1], registro[2]);
			}
		}
		
		return map;
	}
	
	public HashMap<Integer, String> getFiltros() throws IOException {
		
		HashMap<Integer, String> map = new HashMap<Integer, String>() ;

		
		ArrayList<String> linhas = getLinhas();
		if(linhas.size() == 0 ) 
			return map;
		
		int cont = 0;
		
		String anterior = "";
		
		for (String linha : linhas) {
			
			if (!anterior.equals(linha.split(";")[0].trim().toUpperCase())) {
				cont++;
				map.put(cont,linha.split(";")[0]);
				anterior = linha.split(";")[0].trim().toUpperCase();
			}
		}
					
		return map;
	}
	
}
