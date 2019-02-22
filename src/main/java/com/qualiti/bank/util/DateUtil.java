package com.qualiti.bank.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateUtil {

	
	public static LocalDate converterTextoData(String texto) {
		
		DateTimeFormatter formatter = 
				DateTimeFormatter.ofPattern("dd/MM/yyyy");
		formatter = formatter.withLocale( Locale.getDefault() ); 
		LocalDate date = LocalDate.parse(texto, formatter);
		
		return date;
		
	}
	
	public static String converterDataTexto(LocalDate data){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		return data.format(formatter);
	}

}
