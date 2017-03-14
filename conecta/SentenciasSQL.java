package conecta.oracle.com;

public class SentenciasSQL {
	public static String clientes() {
		String valor;
		valor = "SELECT ID ID " +
				",RFC RFC " +
				",NOMBRE NOMBRE " +
				",NUMERO_CLIENTE NUMERO_CLIENTE " +
				",DIRECCION DIRECCION " +
				",NUMERO NUMERO " +
				",NUMERO_INTERIOR NUMERO_INTERIOR " +
				",COLONIA COLONIA " +
				",LOCALIDAD LOCALIDAD " +
				",REFERENCIA REFERENCIA " +
				",MUNICIPIO MUNICIPIO " +
				",ESTADO ESTADO " +
				",PAIS PAIS " +
				",CP CP " +
				",VAT_ID VAT_ID " +
				",CORREO CORREO " +
				",CORREO_CC CORREO_CC " +
				",CORREO_CO CORREO_CO " +
				",CREADO_POR CREADO_POR " +
				",TO_CHAR(FEC_CREACION, 'DD-MM-RRRR HH24:MI:SS') FEC_CREACION " +
				",MODIF_POR MODIF_POR " +
				",TO_CHAR(FEC_MODIF,'DD-MM-RRRR HH24:MI:SS') FEC_MODIF " +
				"FROM INT_CLIENTES " +
				"ORDER BY ID";
		return valor;
	}

}
