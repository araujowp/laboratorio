package br.com.estudojava.decorador;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Avaliacao {
	
	private String msgErro;
	public String getMsgErro() {
		return msgErro;
	}


	public void setMsgErro(String msgErro) {
		this.msgErro = msgErro;
	}


	public int getAcertos() {
		return acertos;
	}


	public void setAcertos(int acertos) {
		this.acertos = acertos;
	}


	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}


	private int acertos;
	private double total;
	
	
	public Avaliacao(String Arquivo ) {
		
	}
	
	
	public String getResultado() {
		
		 DecimalFormat df = new DecimalFormat("0.00");
		 df.setRoundingMode(RoundingMode.HALF_UP);
		 
		 System.out.println("teste");
		 System.out.println(df.format(getTotal() / 100.00 * (double)getAcertos()));
		 System.out.println((3.00 * 10.00)/100.00  );
		 System.out.println("/teste");
		 
		 return df.format(getTotal() / 100.00 * (double)getAcertos());
	}
	
	
	public static void main(String[] args) {
		Avaliacao avaliacao  = new Avaliacao("");
		avaliacao.setTotal(10.00);
		avaliacao.setAcertos(3);
		System.out.println(avaliacao.getResultado());
		System.out.println(10.00 / 3.00);
		System.out.println(String.format("%012d", Integer.parseInt("24")));

		System.out.println(Math.ceil(1.01));
		
		
		
	}
	
}
