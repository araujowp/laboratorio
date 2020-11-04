package br.com.estudojava.clone;

public class TesteClone {

	public static void main(String[] args) {
		
		System.out.println("testando clones");
		Pessoa pessoa1  = new Pessoa();
		pessoa1.setNome("Wagner");
		pessoa1.setIdade(40);
		
		Pessoa pessoa2  = pessoa1.getClone();
		
		System.out.println("a pessoa é ugual ao clone ? " + pessoa1.equals(pessoa2));
		
		System.out.println("Nome pessoa 1 - " + pessoa1.getNome());
		System.out.println("Nome pessoa 2 - " + pessoa2.getNome());
		
		System.out.println("alterando nome de pessoa 2  para maria ");
		
		pessoa2.setNome("Maria");
		
		System.out.println("Nome pessoa 1 - " + pessoa1.getNome());
		System.out.println("Nome pessoa 2 - " + pessoa2.getNome());
		
	}
	
	
}
