package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD implements IConexaoBD {

private Connection conexao;

private static final String URL = "jdbc:mysql://localhost:3306/ecommerce";
private static final String USER = "root";
private static final String PASSWORD = "root";

@Override
public Connection getConnection() 
{
try 
{
    if (conexao == null || conexao.isClosed()) 
    {
     this.conexao = DriverManager.getConnection(URL, USER, PASSWORD);
     System.out.println("ok, conexao, estabelecida com sucesso!");
    }
    return this.conexao;
} 

catch (SQLException e) 
{
 System.err.println("Erro ao conectar: " + e.getMessage());
 return null;
}
}
}
