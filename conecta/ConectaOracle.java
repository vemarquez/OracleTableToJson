package conecta.oracle.com;
import java.sql.*;

import oracle.jdbc.driver.OracleDriver;
import org.apache.log4j.Logger;
  
public class ConectaOracle {
	
  private final static Logger log = Logger.getLogger(ConectaOracle.class);
  public static Connection connOrcl(String ip, String puerto, String sid, String usr, String pwd)
  {

      Connection con = null;      
      String conexion = (new StringBuilder("jdbc:oracle:thin:@")).append(ip).append(":"+puerto+":").append(sid).append(",").append(usr).append(",").append(pwd).toString();
      log.debug( conexion);    
      try
      {
          DriverManager.registerDriver(new OracleDriver());
      }
      catch(Exception ex)
      {
    	  log.warn( "No hay driver de Oracle " + ex.getMessage());
          return null;
      }
      try
      {
          con = DriverManager.getConnection((new StringBuilder("jdbc:oracle:thin:@")).append(ip).append(":").append(puerto).append(":").append(sid).toString(), usr, pwd);
        //  log.debug( "Conexión de oracle " + con);
          return con;
      }
      catch(SQLException sqe)
      {
    	  log.warn( "No se puedo conecta a oracle " + sqe.getMessage());         
          return null;
      }
  }
}

