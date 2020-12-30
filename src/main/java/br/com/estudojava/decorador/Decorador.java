package br.com.estudojava.decorador;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import br.com.estudojava.arquivo.txt.Lertexto;

public class Decorador {
	
	public static void main(String[] args) throws IOException {
		
		try {
			System.out.println("Buscando "+ getCaminho() +"\\decorador.txt ");
			//exibir filtros
			//exibir numero de perguntas maximo ";
			
			ArrayList<String> perguntas = getPerguntas(getCaminho() +"\\decorador.txt");
			System.out.println("Digite o numero de questões da avaliação ( 1 - " + perguntas.size() + ") ");
			Scanner entrada = new Scanner(System.in);
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
			
		} catch (IOException e) {
			System.out.println("Desculpe não consegui encontrar as perguntas ");
		} catch (InputMismatchException e ) {
			System.out.println("Valor digitado invalido ");
		} catch (Exception e) {
			System.out.println("Opa estamos com problemas " + e.getMessage());
		}
		
		
	}

	private static String getCaminho() throws IOException {
		return new File(".").getCanonicalPath();
	}
	
	private static ArrayList<String> getPerguntas(String arquivo) throws IOException{
		Lertexto lerTexto = new Lertexto(arquivo);
		return lerTexto.getLinhas();
	}
	
}
