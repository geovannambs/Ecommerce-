package view;

import java.util.List;
import controller.ConexaoBD;
import controller.IConexaoBD;
import controller.ProdutoDAO;
import model.Produto;


public class MainView 
{
  public static void main(String[] args) 
  {
  IConexaoBD conexao = new ConexaoBD();
  ProdutoDAO produtoDAO = new ProdutoDAO(conexao);
  System.out.println("Listando produtos disponíveis:\n");

  List<Produto> produtos = produtoDAO.listarProdutos();

  if (produtos.isEmpty()) 
  {
    System.out.println("Nenhum produto encontrado.");
  } 
  else 
  {
    produtos.forEach(System.out::println);
  }
  }
}
