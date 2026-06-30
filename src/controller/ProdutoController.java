package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import construcao.model.Produto;
 
import repository.ProdutoRepository;

public class ProdutoController implements ProdutoRepository {
	
	private List<Produto> listaProdutos = new ArrayList<Produto>();
	int id = 0;

	@Override
	public void listarTodos() {
		for(var produto : listaProdutos) {
			produto.visualizar();
		}
	}

	@Override
	public void cadastrar(Produto produto) {
		listaProdutos.add(produto);
		System.out.println("\n Produto Cadastrado com sucesso!");
	}

	@Override
	public void atualizar(Produto produto) {

	    Optional<Produto> buscarProduto = buscarNaCollection(produto.getId());

	    if (buscarProduto.isPresent()) {

	        listaProdutos.set(listaProdutos.indexOf(buscarProduto.get()), produto);

	        System.out.printf("\nO Produto ID %d foi atualizado com sucesso!%n", produto.getId());

	    } else {

	        System.out.printf("\nO Produto ID %d não foi encontrado!%n", produto.getId());

	    }
	}

	@Override
	public void procurarPorId(int id) {
		Optional<Produto> conta = buscarNaCollection(id);
		
		if(conta.isPresent())
			conta.get().visualizar();
		else
			System.out.printf("\nProduto de ID %d não foi encontrado! ", id);
	}

	@Override
	public void deletar(int id) {

	    Optional<Produto> produto = buscarNaCollection(id);

	    if (produto.isPresent()) {

	        listaProdutos.remove(produto.get());

	        System.out.printf("\nO Produto ID %d foi deletado com sucesso!%n", id);

	    } else {

	        System.out.printf("\nO Produto ID %d não foi encontrado!%n", id);

	    }
	}
	
	//Método auxiliar
		public int gerarId() {
			return ++ id;
		}
		
		public Optional<Produto> buscarNaCollection(int id) {
			for(var produto : listaProdutos) {
				if(produto.getId() == id)
					return Optional.of(produto);
			}
			return Optional.empty();
		}

}
