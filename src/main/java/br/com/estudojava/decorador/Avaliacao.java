package br.com.estudojava.decorador;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashMap;

public class Avaliacao {
	
	private String msgErro;
	private HashMap<String, String> perguntas;
	
	public Avaliacao( HashMap<String, String> perguntas) {
		this.perguntas = perguntas;
	}
	
	
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
		 
		 return df.format(getTotal() / 100.00 * (double)getAcertos());
	}
	
}
