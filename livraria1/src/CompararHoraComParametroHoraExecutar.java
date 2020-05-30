
public class CompararHoraComParametroHoraExecutar {
	
	public static Boolean compararHora(String HorarioParaInicio, String horaParametroInicio) {
		Boolean retorno =  false; 
		if (HorarioParaInicio.equals(horaParametroInicio)) {
			retorno = true;
			ConexaoComBGS.iniciarConexaoGBS();
//			System.out.println("São iguais --> " + HorarioParaInicio + " == " + horaParametroInicio);
		}else {
			retorno = false;
			ConexaoComBGS.fecharConexaoGBS();
//			System.out.println("São diferentes --> " + HorarioParaInicio + " <> " + horaParametroInicio);
		}
		return retorno;
	}

}
