package farmacia.controller;

import java.util.ArrayList;
import java.util.Optional;

import farmacia.model.Produto;
import farmacia.repository.ProdutoRepository;

public class ProdutoController implements ProdutoRepository {
	
	int id = 0;
	
	private ArrayList <Produto>listaProd = new ArrayList<Produto>();
	
	@Override
	public void criarProduto(Produto produto) {
		
		listaProd.add(produto);
		
		System.out.println("Produto adicionado com sucesso!");
	
	}

	@Override
	public void listarTodosProdutos() {
		for ( var p : listaProd) {
			p.visualizar();
		}
	}

	@Override
	public void consultarProdutoId(int id) {
		
		Optional <Produto> grandeCaixa = buscarNaList(id);
		if(grandeCaixa.isPresent()) {
			grandeCaixa.get().visualizar();
		}else 
			System.out.println("Produto não encontrado!");
	}
	@Override
	public void atualizarProduto(Produto produto) {
		Optional<Produto> grandeCaixa = buscarNaList (produto.getId());
		if (grandeCaixa.isPresent()){
			listaProd.set(listaProd.indexOf(grandeCaixa.get()), produto);
		}else
			
			System.out.println("Produto não encontrado!");	
	}

	@Override
	public void deletarProduto(int id) {
		Optional<Produto> grandeCaixa = buscarNaList (id);
			if (grandeCaixa.isPresent()) {
				if(listaProd.remove(grandeCaixa.get()))
						System.out.println("Produto removido!");
			}else
				System.out.println("Produto não encontrado!");
	}
	public Optional <Produto> buscarNaList (int id) {
		for ( var p : listaProd) {
			if (p.getId() == id )
				return Optional.of(p);
		}
		return Optional.empty();
	}
	public int gerarId() {
		
		return ++id;
	}
	public int retornaTipo(int id) {
		Optional<Produto> grandeCaixa = buscarNaList (id);
		return grandeCaixa.get().getTipo();
	}

}
