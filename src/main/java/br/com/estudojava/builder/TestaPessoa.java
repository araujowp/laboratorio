package br.com.estudojava.builder;

public class TestaPessoa {

	public static void main(String[] args) {
		
		Pessoa pessoa = new Pessoa.builder()
				.nome("Wagner")
				.nomeDoMeio("Pereira")
				.nomeDoPai("Messias")
				.apelido("Wagn�o").build();
		System.out.println(pessoa.toString());
	}
	
}
