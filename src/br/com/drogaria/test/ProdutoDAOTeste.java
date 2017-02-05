package br.com.drogaria.test;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.dao.ProdutoDAO;
import br.com.drograria.domain.Fabricante;
import br.com.drograria.domain.Produto;

public class ProdutoDAOTeste {
	@Test
	@Ignore
	
	public void salvar() throws SQLException {
		Produto p = new Produto();
		p.setDescricao("Gelol Pomada");
		p.setPreco(15.55);
		p.setQuantidade(7L);

		Fabricante f = new Fabricante();
		f.setCodigo(7L);

		p.setFabricante(f);

		ProdutoDAO dao = new ProdutoDAO();
		dao.salvar(p);
	}

	@Test
	
	public void listar() throws SQLException {

		ProdutoDAO dao = new ProdutoDAO();

		ArrayList<Produto> lista = dao.listar();
		
		for(Produto p : lista){
			
			System.out.println("Código do Produto: "+ p.getCodigo());
			System.out.println("Descrição do Produto: "+ p.getDescricao());
			System.out.println("Preço: "+ p.getPreco());
			System.out.println("Quantidade: "+ p.getQuantidade());
			System.out.println("Código do Fabricante: "+ p.getFabricante().getCodigo());
			System.out.println("Descrição do Fabricante: "+ p.getFabricante().getDescricao());
			System.out.println("==========================================================");
		}
	}

}
