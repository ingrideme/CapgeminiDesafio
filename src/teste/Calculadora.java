package teste;

import java.util.Iterator;
import java.util.Scanner;

public class Calculadora {


	public static void main(String[] args) {
	
		//iniciando o Scanner para leitura de dados inseridas
		Scanner ler = new Scanner(System.in);
			
		//declara��o das vari�veis iniciadas zeradas.
 		double valorInvestido = 0, viewsAnuncioOriginal = 0, viewsAnuncioCompartilhado = 0, totalViews = 0, viewsQueClicam = 0, viewsQueCompartilham = 0, contador = 0;
 					
		//inicio da intera��o com o usu�rio
 		System.out.println("Entre com o valor que ser� investido:");
		valorInvestido = ler.nextDouble();
		
		//calcular o n�mero de views alcan�ado pelo anuncio original
		viewsAnuncioOriginal = valorInvestido * 30;
		
		//Loop de compartilhamentos para encontrar o alcance do an�ncio
		for (int qtdCompartilhamento = 0; qtdCompartilhamento < 4; qtdCompartilhamento++) {
				viewsQueClicam = viewsAnuncioOriginal * 0.12;
				viewsQueCompartilham = viewsQueClicam * 0.15;
				viewsAnuncioCompartilhado = viewsQueCompartilham * 40;			
				contador += viewsAnuncioCompartilhado;
			}
			totalViews = contador+viewsAnuncioOriginal;
		
			System.out.println(Math.round(totalViews) + " � a quantidade total de views");	
		
	}

}
