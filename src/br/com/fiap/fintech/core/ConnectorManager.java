package br.com.fiap.fintech.core;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectorManager {
	private static ConnectorManager instance;
	  
	  private ConnectorManager(){}
	  
	  public static ConnectorManager getInstance(){
	    if (instance == null){
	      instance = new ConnectorManager();
	    }
	    return instance;
	  }
	  
	  public Connection getConnection() {
	    Connection conexao = null;
	    try {
	      Class.forName("oracle.jdbc.driver.OracleDriver");

	      conexao = DriverManager.getConnection(
		          "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "RM96368", "240203");

	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	    return conexao;
	  }
}
