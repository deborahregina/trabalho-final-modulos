package deborah.dbc.service;

import deborah.dbc.exceptions.BancoDeDadosException;
import deborah.dbc.model.Endereco;
import deborah.dbc.model.Produto;
import deborah.dbc.repository.EnderecoRepository;
import deborah.dbc.repository.PedidoProdutoRepository;
import deborah.dbc.repository.ProdutoRepository;

import java.text.DecimalFormat;

public class ProdutoService {

    PedidoProdutoRepository pedidoProdutoRepository = new PedidoProdutoRepository();
    private ProdutoRepository produtoRepository;

    public ProdutoService() {
        this.produtoRepository = new ProdutoRepository();
    }

    // criação de um objeto
    public void adicionarProduto(Produto produto) {
        try {
            Produto produtoAdicionado = produtoRepository.adicionar(produto);
            System.out.println("Produto adicinado com sucesso! ");
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    // remoção
    public void remover(Integer id) {
        try {
            pedidoProdutoRepository.removerProdutoFromPedido(id);
            boolean conseguiuRemover = produtoRepository.remover(id);
            System.out.println("removido? " + conseguiuRemover + "| com id=" + id);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    // atualização de um objeto
    public void editar(Integer id, Produto produto) {
        try {
            boolean conseguiuEditar = produtoRepository.editar(id, produto);
            System.out.println("editado? " + conseguiuEditar + "| com id=" + id);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

    // leitura
    public void listar() {
        try {
            produtoRepository.listar().forEach(System.out::println);
        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

  // fazer lsitar produtos por pedido
}
