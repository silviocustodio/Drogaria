package br.com.drogaria.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.util.JSFUtil;
import br.com.drograria.domain.Fabricante;

@ManagedBean(name = "MBFabricante") // atras da interface grafica
@ViewScoped
public class FabricanteBean {
	private Fabricante fabricante;
	private ArrayList<Fabricante> itens;
	private ArrayList<Fabricante> itensFiltrados;

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public ArrayList<Fabricante> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Fabricante> itens) {
		this.itens = itens;
	}

	public ArrayList<Fabricante> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<Fabricante> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	@PostConstruct // esse metodo chamado automaticamente antes da tela ser
					// chamada
	public void prepararPesquisa() {
		try {
			FabricanteDAO dao = new FabricanteDAO();
			itens = dao.listar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JSFUtil.addErrorMessage(e.getMessage());// take message direct from
													// db
		}

	}

	public void prepararNovoFabricante() {

		fabricante = new Fabricante();
	}

	public void incluirNovoFabricante() {
		try {
			FabricanteDAO dao = new FabricanteDAO();
			dao.salvar(fabricante);

			itens = dao.listar();// Update List

			JSFUtil.addSuccessMessage("Manufacturer add sucessfuly");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JSFUtil.addErrorMessage(e.getMessage());
		}

	}

	// public void prepararExcluir() {

	// fabricante = itens.getRowData(); // Sabe qual linha do fabricante
	// clicado para excluir e traz, getRowData so funciona com ListaDataModel
	// }

	public void excluirFabricante() {

		try {
			FabricanteDAO dao = new FabricanteDAO();
			dao.excluir(fabricante);

			itens = dao.listar();

			JSFUtil.addSuccessMessage("Manufacturer removed sucessfuly");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JSFUtil.addErrorMessage(e.getMessage());
		}
	}

	public void editarFabricante() {

		try {
			FabricanteDAO dao = new FabricanteDAO();
			dao.editar(fabricante);

			itens = dao.listar();

			JSFUtil.addSuccessMessage("Manufacturer edited sucessfuly");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JSFUtil.addErrorMessage(e.getMessage());
		}
	}

}
