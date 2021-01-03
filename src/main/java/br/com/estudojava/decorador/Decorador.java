package br.com.estudojava.decorador;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import br.com.estudojava.arquivo.txt.LerTexto;

public class Decorador {
	
	public static void main(String[] args) throws IOException {
		
		try {
			//exibir filtros
			Banco banco  = new Banco(getCaminho() +"\\decorador2.txt ");
			
			HashMap<Integer, String> filtros  = banco.getFiltros(); 
			
			if (filtros.isEmpty()) {
				System.out.println("Arquivo vazio "+ getCaminho() +"\\decorador.txt ");
				return;
			}
			
			System.out.println(0 + " - " + "Todos");
			for (Entry<Integer, String> entrada : filtros.entrySet()) {
				System.out.println(entrada.getKey() + " - " + entrada.getValue());
			}

			Scanner entradaTeclado = new Scanner(System.in);
			String resposta = entradaTeclado.nextLine();
			
			if (isInteger(resposta)) {
				
				String escolhido = getDescricaoFiltro(filtros, Integer.parseInt(resposta));
				if(escolhido.contentEquals("")) {
					System.out.println("Filtro inválido! ");
				}else {
					
					int acertos = 0;
					HashMap<String,String> perguntas = banco.getRegistros(escolhido);
					
					for(Entry<String, String> pergunta : perguntas.entrySet()) {

						System.out.println("--- " + pergunta.getKey()   );//pergunta
						resposta = entradaTeclado.nextLine();
						System.out.println("--- " + pergunta.getValue());//resposta
						System.out.println("Acertou ?");
						resposta = entradaTeclado.nextLine();
						acertos += resposta.trim().equals("s") ? 1 : 0;  
					}
					System.out.println("resultado " + perguntas.size() / acertos + "%");//resposta
					;
					
				}
				
				System.out.println("Filtro escolhido - " + escolhido);
				
			}else {
				sair();
			}
			
			do{
				resposta = entradaTeclado.nextLine();
			}while (!isInteger(resposta));
			
			
			/*
			//exibir numero de perguntas maximo ";
			
			ArrayList<String> perguntas = getPerguntas(getCaminho() +"\\decorador.txt");
			System.out.println("Digite o numero de questões da avaliação ( 1 - " + perguntas.size() + ") ");
			//System.out.println("selecionou " + entrada.nextLine() );
			
			int acertos = 0;
			for(String linhaPergunta :perguntas) {
				System.out.println(linhaPergunta.split(";")[0] + ":");   //tema 
				System.out.println("--- " + linhaPergunta.split(";")[1]);//pergunta
				String resposta = entrada.nextLine();
				System.out.println("--- " + linhaPergunta.split(";")[2]);//resposta
				System.out.println("Acertou ?");
				resposta = entrada.nextLine();
				acertos += resposta.trim().equals("s") ? 1 : 0;  
			}
			System.out.println("resultado " + perguntas.size() / acertos);//resposta
			;
			
			//validar contra o maximo
			//inicia o contador de tempo
			//pergunta se esta correta
			//tempo medio estatistica
			
			*/
			
		} catch (FileNotFoundException e) {
			System.out.println("arquivo não encontrado ! - " + getCaminho() +"\\decorador.txt ");
		} catch (IOException e) {
			System.out.println("Desculpe não consegui encontrar as perguntas ");
		} catch (InputMismatchException e ) {
			System.out.println("Valor digitado invalido ");
		} catch (Exception e) {
			System.out.println("Opa estamos com problemas " + e.getMessage());
			e.printStackTrace();
		}
	}

    private static String getDescricaoFiltro(HashMap<Integer, String> filtros, int escolhido) {
    	
		String descricao = "";
		
		for (Entry<Integer,String> entrada : filtros.entrySet()) {
			if (entrada.getKey() == escolhido)
				return entrada.getValue();
		}
		
		return descricao;
	}

	private static void sair() {
    	Scanner entradaTeclado = new Scanner(System.in);
    	System.out.println("Pressione qualquer tecla para sair ");
		String resposta = entradaTeclado.nextLine();
	}

	private static boolean isInteger(String str) {
        return str != null && str.matches("[0-9]*");
    }
	
	private static String getCaminho() throws IOException {
		return new File(".").getCanonicalPath();
	}
	
	private static ArrayList<String> getPerguntas(String arquivo) throws IOException{
		LerTexto lerTexto = new LerTexto(arquivo);
		return lerTexto.getLinhas();
	}
	
}
