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
		
		
			//declara��o das vari�veis iniciadas zeradas.
			double viewsAnuncioOriginal = 0, viewsAnuncioCompartilhado = 0, totalViews = 0, viewsQueClicam = 0, viewsQueCompartilham=0, contador = 0, contadorClicks = 0, contadorViewsCompartilham = 0, investimentoDiario = 0;
			
			//iniciando o Scanner para leitura de dados inseridas
			Scanner ler = new Scanner(System.in);
		
			//declara��o das vari�veis 
			String nomeAnuncio;
			String nomeCliente;
			
			System.out.println("Digite o nome do cliente");
			nomeCliente = ler.nextLine();
		
			//inicio da intera��o com o usu�rio
			System.out.println("Digite o nome do an�ncio");
			nomeAnuncio = ler.nextLine();
			
			//declara��o dos tipos LocalDate e a String auxiliar
			LocalDate dataInicio;
			String dataInicioString;
			
			System.out.println("Digite a data de inicio, formato dd/MM/yyyy, ex: 03/03/2020");
			dataInicioString = ler.next();
			
			//utilizando DateTimeFormatter para formatar a data 
			dataInicio = LocalDate.parse(dataInicioString.toString(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

			//declara��o dos tipos LocalDate e a String auxiliar
			LocalDate dataTermino;
			String dataTerminoString;
			
			System.out.println("Digite a data de t�rmino, formato dd/MM/yyyy, ex: 03/03/2020");
			dataTerminoString = ler.next();
			

			//utilizando DateTimeFormatter para formatar a data 
			dataTermino = LocalDate.parse(dataTerminoString.toString(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

			//ChronoUnit e between para calcular a diferen�a entre as duas datas
			double dias = ChronoUnit.DAYS.between(dataInicio, dataTermino);
							
			System.out.println("Digite o valor investido por dia");
			investimentoDiario = ler.nextDouble();
			
			//calculo do investimento total
			double investimentoTotal = dias*investimentoDiario;
		
			//calcular o n�mero de views alcan�ado pelo anuncio original
			viewsAnuncioOriginal = investimentoTotal * 30;
			
			//Loop de compartilhamentos para encontrar o alcance do an�ncio
			for (int qtdCompartilhamento = 0; qtdCompartilhamento < 4; qtdCompartilhamento++) {
				viewsQueClicam = viewsAnuncioOriginal * 0.12;
				viewsQueCompartilham = viewsQueClicam * 0.15;
				viewsAnuncioCompartilhado = viewsQueCompartilham * 40;			
				contador += viewsAnuncioCompartilhado;
				contadorClicks += viewsQueClicam;
				contadorViewsCompartilham += viewsQueCompartilham;
			}
			totalViews = contador+viewsAnuncioOriginal;
			
			//impress�o do relat�rio
			System.out.println("Relat�rio do an�ncio " + nomeAnuncio + " referente ao cliente " + nomeCliente);
			System.out.println("R$" + Math.round(investimentoTotal) + " � o valor do Investimento Total");
			System.out.println(Math.round(totalViews) + " � a quantidade final total de views");
			System.out.println(Math.round(contadorClicks) + " � a quantidade de users que clicaram no an�ncio");
			System.out.println(Math.round(contadorViewsCompartilham) + " � a quantidade quantidade de users que compartilharam o an�ncio");
				
		
			
			//dados n�o est�o sendo armazenados em banco de dados, consequentemente n�o h� filtros para busca.
	}
			
			
		
		
}		


