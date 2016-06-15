package br.unipe.mtp3.modelo;

import javafx.scene.control.Button;

public class Botoes {
	
	private Button Resetar = new Button ("  Resetar  ");
	private Button Cadastrar = new Button ("  Cadastrar  ");
	private Button Acessar  = new Button ("  Acessar  ");
	private Button Alterar  = new Button ("  Alterar  ");	
	private Button Deletar  = new Button ("  Deletar  ");	
	private Button Listar  = new Button ("  Exibir  ");
	private Button Consultar = new Button ("  Consultar  ");
	private Button Gerar = new Button ("  Gerar txt  ");
	
	private Button Ok  = new Button ("  OK  ");
	private Button invs  = new Button ();
	
	public void settingSize(){
		
		getCadastrar().setMinWidth(80);
		getConsultar().setMinWidth(80);
		getAlterar().setMinWidth(80);
		getDeletar().setMinWidth(80);
		getListar().setMinWidth(80);
		getAcessar().setMinWidth(80);
		getGerar().setMinWidth(80);
		getOk().setMinWidth(80);
		
		getInvs().setStyle("-fx-color: #C9D7E7; -fx-background-color: #C9D7E7; -fx-focus-color: #C9D7E7 ; -fx-faint-focus-color: #C9D7E7 ;");
		getInvs().requestFocus();
		
	}

	public Button getCadastrar() {
		return Cadastrar;
	}

	public void setCadastrar(Button cadastrar) {
		Cadastrar = cadastrar;
	}

	public Button getListar() {
		return Listar;
	}

	public void setListar(Button listar) {
		Listar = listar;
	}

	public Button getAcessar() {
		return Acessar;
	}

	public void setAcessar(Button acessar) {
		Acessar = acessar;
	}

	public Button getInvs() {
		return invs;
	}

	public void setInvs(Button invs) {
		this.invs = invs;
	}

	public Button getConsultar() {
		return Consultar;
	}

	public void setConsultar(Button consultar) {
		Consultar = consultar;
	}

	public Button getDeletar() {
		return Deletar;
	}

	public void setDeletar(Button deletar) {
		Deletar = deletar;
	}

	public Button getAlterar() {
		return Alterar;
	}

	public void setAlterar(Button alterar) {
		Alterar = alterar;
	}

	public Button getOk() {
		return Ok;
	}

	public void setOk(Button ok) {
		Ok = ok;
	}

	public Button getGerar() {
		return Gerar;
	}

	public void setGerar(Button gerar) {
		Gerar = gerar;
	}

	public Button getResetar() {
		return Resetar;
	}

	public void setResetar(Button resetar) {
		Resetar = resetar;
	}
	

}
