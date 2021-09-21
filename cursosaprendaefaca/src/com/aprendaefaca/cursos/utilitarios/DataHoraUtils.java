package com.aprendaefaca.cursos.utilitarios;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.annotation.SuppressLint;

@SuppressLint("simpleDateFormat")
public class DataHoraUtils {
	private static final String DATA ="dd-MM-yyyy";
	private static final String HORA ="HH:mm:ss";
	private static final String DATA_HORA = DATA + HORA;

	public static String obtemDataHoraAtual(){
		return new SimpleDateFormat(DATA_HORA).format(new Date());
	}
	
	public static String formatar(String padrao, Date data){
		return new SimpleDateFormat(padrao).format(data);
		
	}
	public static String obtemDataHoraAtualComUnderline(){
		return obtemDataHoraAtual().replaceAll("[- :]","_");
	}

}
