package oracle.jason.com;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import conecta.oracle.com.ConectaOracle;
import conecta.oracle.com.SentenciasSQL;

import org.json.simple.JSONArray;
import org.json.simple.JSONAware;
import org.json.simple.JSONObject;

import org.apache.log4j.Logger;


class OracleTabla implements JSONAware {		 

	private long id;
	private String rfc;
	@SuppressWarnings("unused")
	private String password;

	public OracleTabla(long id, String RFC, String Nombre){
		this.id = id;
		this.rfc = RFC;
		this.password = Nombre;
	}

	public String toJSONString(){
		StringBuffer sb = new StringBuffer();

		sb.append("{");

		sb.append(JSONObject.escape("rfc"));
		sb.append(":");
		sb.append("\"" + JSONObject.escape(rfc) + "\"");

		sb.append(",");

		sb.append(JSONObject.escape("ID"));
		sb.append(":");
		sb.append(id);

		sb.append("}");

		return sb.toString();
	}
}


public class OracleJason  {
	
	private final static Logger log = Logger.getLogger(OracleJason.class);
		
	public static Connection conOracle = null;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		JSONArray clientes = new JSONArray();
		String[] arrDatos = new String[20];
		long lID = 0;
		long lNumeroCliente = 0;
		int iTodos = 1;
		//BasicConfigurator.configure();
		
		log.info("inicio");		
		
		conOracle = ConectaOracle.connOrcl("127.0.0.1", "1521", "orclapps" , "mcdmxfacturas", "mcdmxfacturas"); 
		log.debug( conOracle);
		if(conOracle != null) {			
			log.debug("Conectado a oracle");
		}
		else
			log.debug("No se pudo conectar a oracle");		
		//Clientes.intCreateClientes( conOracle  );
		try {
			PreparedStatement smtClientes = conOracle.prepareStatement(SentenciasSQL.clientes());						
			ResultSet resClientes = smtClientes.executeQuery();
       
			log.trace("inicio while");
			while (resClientes.next()) {	
				
				lID = resClientes.getLong("ID");
				arrDatos[0] = resClientes.getString("RFC");				
				arrDatos[1] = resClientes.getString("NOMBRE");				
				lNumeroCliente = resClientes.getLong("NUMERO_CLIENTE");
				arrDatos[2] = resClientes.getString("DIRECCION");
				arrDatos[3] = resClientes.getString("NUMERO");
				arrDatos[4] = resClientes.getString("NUMERO_INTERIOR");
				arrDatos[5] = resClientes.getString("COLONIA");
				arrDatos[6] = resClientes.getString("LOCALIDAD");
				arrDatos[7] = resClientes.getString("REFERENCIA");
				arrDatos[8] = resClientes.getString("MUNICIPIO");
				arrDatos[9] = resClientes.getString("ESTADO");
				arrDatos[10] = resClientes.getString("PAIS");
				arrDatos[11] = resClientes.getString("CP");
				arrDatos[12] = resClientes.getString("VAT_ID");
				arrDatos[13] = resClientes.getString("CORREO");
				arrDatos[14] = resClientes.getString("CORREO_CC");
				arrDatos[15] = resClientes.getString("CORREO_CO");
				arrDatos[16] = resClientes.getString("CREADO_POR");
				arrDatos[17] = resClientes.getString("FEC_CREACION");
				arrDatos[18] = resClientes.getString("MODIF_POR");
				arrDatos[19] = resClientes.getString("FEC_MODIF");
			
				clientes.add(new OracleTabla(lID,arrDatos[0],arrDatos[1]));								 
				
				arrDatos = new String[20];
				if (iTodos!=1) {
					System.out.println(clientes);
				   clientes.clear(); // una sola notacion
				}
			}
			
			if (iTodos==1) 
				System.out.println(clientes);
			
		}
		catch(SQLException sqe)
		{
			System.out.println( sqe.getMessage());			
		}
	}	
}

