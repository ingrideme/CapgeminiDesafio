package teste;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Scanner;

public class Anuncio {

		public static void main(String[] args) {
		
		
			//declaração das variáveis iniciadas zeradas.
			double viewsAnuncioOriginal = 0, viewsAnuncioCompartilhado = 0, totalViews = 0, viewsQueClicam = 0, viewsQueCompartilham=0, contador = 0, contadorClicks = 0, contadorViewsCompartilham = 0, investimentoDiario = 0;
			
			//iniciando o Scanner para leitura de dados inseridas
			Scanner ler = new Scanner(System.in);
		
			//declaração das variáveis 
			String nomeAnuncio;
			String nomeCliente;
			
			System.out.println("Digite o nome do cliente");
			nomeCliente = ler.nextLine();
		
			//inicio da interação com o usuário
			System.out.println("Digite o nome do anúncio");
			nomeAnuncio = ler.nextLine();
			
			//declaração dos tipos LocalDate e a String auxiliar
			LocalDate dataInicio;
			String dataInicioString;
			
			System.out.println("Digite a data de inicio, formato dd/MM/yyyy, ex: 03/03/2020");
			dataInicioString = ler.next();
			
			//utilizando DateTimeFormatter para formatar a data 
			dataInicio = LocalDate.parse(dataInicioString.toString(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

			//declaração dos tipos LocalDate e a String auxiliar
			LocalDate dataTermino;
			String dataTerminoString;
			
			System.out.println("Digite a data de término, formato dd/MM/yyyy, ex: 03/03/2020");
			dataTerminoString = ler.next();
			

			//utilizando DateTimeFormatter para formatar a data 
			dataTermino = LocalDate.parse(dataTerminoString.toString(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

			//ChronoUnit e between para calcular a diferença entre as duas datas
			double dias = ChronoUnit.DAYS.between(dataInicio, dataTermino);
							
			System.out.println("Digite o valor investido por dia");
			investimentoDiario = ler.nextDouble();
			
			//calculo do investimento total
			double investimentoTotal = dias*investimentoDiario;
		
			//calcular o número de views alcançado pelo anuncio original
			viewsAnuncioOriginal = investimentoTotal * 30;
			
			//Loop de compartilhamentos para encontrar o alcance do anúncio
			for (int qtdCompartilhamento = 0; qtdCompartilhamento < 4; qtdCompartilhamento++) {
				viewsQueClicam = viewsAnuncioOriginal * 0.12;
				viewsQueCompartilham = viewsQueClicam * 0.15;
				viewsAnuncioCompartilhado = viewsQueCompartilham * 40;			
				contador += viewsAnuncioCompartilhado;
				contadorClicks += viewsQueClicam;
				contadorViewsCompartilham += viewsQueCompartilham;
			}
			totalViews = contador+viewsAnuncioOriginal;
			
			//impressão do relatório
			System.out.println("Relatório do anúncio " + nomeAnuncio + " referente ao cliente " + nomeCliente);
			System.out.println("R$" + Math.round(investimentoTotal) + " é o valor do Investimento Total");
			System.out.println(Math.round(totalViews) + " é a quantidade final total de views");
			System.out.println(Math.round(contadorClicks) + " é a quantidade de users que clicaram no anúncio");
			System.out.println(Math.round(contadorViewsCompartilham) + " é a quantidade quantidade de users que compartilharam o anúncio");
				
		
			
			//dados não estão sendo armazenados em banco de dados, consequentemente não há filtros para busca.
	}
			
			
		
		
}		


