import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import arvore.No;

public class TesteData {
	public static String[] InicioFim = { "01/01/2023", "30/01/2023" }; //datas de entrada


	public TesteData() {

	}

	
	
	
	public static LocalDate ConverterParaData(String Data) { //converte string de data para o formato local date 

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		LocalDate DataFormatada = LocalDate.parse(Data, formatter);
		return DataFormatada;
	}

	public static String ConverterParaString(LocalDate data) {  //converte de data para String de novo
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String texto = data.format(formatter);
		return texto;

	}

	public static List<LocalDate> DatasEntre(LocalDate DataInicio, LocalDate DataFim) { //calcula datas entre dois periodos 

		return DataInicio.datesUntil(DataFim).collect(Collectors.toList());
	}

	public static String[] BuscaData() {      //Gera as datas baseado na entrada e retorna elas em um array
		LocalDate DataInicio = ConverterParaData(InicioFim[0]);
		System.out.println(DataInicio);
		LocalDate DataFinal = ConverterParaData(InicioFim[1]);
		System.out.println(DataFinal);
		String [] array = new String [DatasEntre(DataInicio, DataFinal.plusDays(1)).size()];
		int aux = 0;
		for( LocalDate data : DatasEntre(DataInicio, DataFinal.plusDays(1))) {	
				array[aux] = ConverterParaString(data);
				System.out.println(data);
				aux++;
		}
		return array;
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(BuscaData()));
		
	}

}