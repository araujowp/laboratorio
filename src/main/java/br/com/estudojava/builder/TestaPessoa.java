package br.com.estudojava.builder;

public class TestaPessoa {

	public static void main(String[] args) {
		
		Pessoa pessoa = new Pessoa.builder()
				.nome("Wagner")
				.nomeDoMeio("Pereira")
				.nomeDoPai("Messias")
				.apelido("Wagnão").build();
		System.out.println(pessoa.toString());
	}
	
}
