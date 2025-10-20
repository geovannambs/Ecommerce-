package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Produto;

public class ProdutoDAO implements controller.IProdutoDAO 
{

private final controller.IConexaoBD conexaoBD;

public ProdutoDAO(controller.IConexaoBD conexao) 
{
   this.conexaoBD = (controller.IConexaoBD) conexao;
}

@Override
public List<Produto> listarProdutos() 
{
   List<Produto> produtos = new ArrayList<>();
   String sql = "SELECT id, nome, preco FROM produtos";

try (Connection conn = conexaoBD.getConnection()) 
{
    if (conn == null) 
    {
      System.err.println("Falha na conexão com o banco!");
      return produtos;
    }

    try (PreparedStatement stmt = conn.prepareStatement(sql);
    ResultSet rs = stmt.executeQuery()) 
    {
       while (rs.next()) 
       {
        Produto p = new Produto(
        rs.getInt("id"),
        rs.getString("nome"),
        rs.getDouble("preco")
        );
        produtos.add(p);
       }
    }

} 

catch (SQLException e) 
{
  System.err.println("Erro ao listar produtos: " + e.getMessage());
}

return produtos;

}
}
