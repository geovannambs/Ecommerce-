package controller;

import java.util.List;

public interface IProdutoDAO<Produto> 
{
    List<Produto> listarProdutos();
}
