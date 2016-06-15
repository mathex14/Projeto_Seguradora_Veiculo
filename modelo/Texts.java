package br.unipe.mtp3.modelo;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Texts {
	
	private Text title = new Text("Seguradora SpeedPower");
	private Text menuTop = new Text("Menu");
	private Text txtidC = new Text("ID:");
	private Text txtcpf = new Text("CPF:");
	private Text txtnome = new Text("Nome:");
	private Text txtend = new Text("Endereço:");
	private Text txttel = new Text("Telefone:");
	private Text txtident = new Text("Identidade:");
	
	private Text txtidV = new Text("ID:");
	private Text txtpla = new Text("Placa do carro:");
	private Text txtmod = new Text("Modelo:");
	private Text txtchass = new Text("Chassis:");
	private Text txtano = new Text("Ano:");
	private Text txtfab = new Text("Fabricante:");
	private Text txttitu = new Text("Titular:");
	
	private Text txtidS = new Text("ID:");
	private Text txtval = new Text("Valor:");
	private Text txtdes = new Text("Descrição:");
	private Text txtvig = new Text("Vigência:");
	private Text txttitu2 = new Text("Titular:");
	
	public void settingFonts(){
	getMenuTop().setFont(Font.font("Arial", FontWeight.BOLD, 14));
	
	getTitle().setFont(Font.font("Bernard MT Condensed", FontWeight.BOLD, 30));
	getTitle().setFill(Color.BLACK);
	}

	public Text getTxtidC() {
		return txtidC;
	}

	public void setTxtidC(Text txtidC) {
		this.txtidC = txtidC;
	}

	public Text getTxtcpf() {
		return txtcpf;
	}

	public void setTxtcpf(Text txtcpf) {
		this.txtcpf = txtcpf;
	}

	public Text getTxtnome() {
		return txtnome;
	}

	public void setTxtnome(Text txtnome) {
		this.txtnome = txtnome;
	}

	public Text getTxttel() {
		return txttel;
	}

	public void setTxttel(Text txttel) {
		this.txttel = txttel;
	}

	public Text getTxtend() {
		return txtend;
	}

	public void setTxtend(Text txtend) {
		this.txtend = txtend;
	}

	public Text getTxtident() {
		return txtident;
	}

	public void setTxtident(Text txtident) {
		this.txtident = txtident;
	}

	public Text getTitle() {
		return title;
	}

	public void setTitle(Text title) {
		this.title = title;
	}

	public Text getMenuTop() {
		return menuTop;
	}

	public void setMenuTop(Text menuTop) {
		this.menuTop = menuTop;
	}

	public Text getTxtidV() {
		return txtidV;
	}

	public void setTxtidV(Text txtidV) {
		this.txtidV = txtidV;
	}

	public Text getTxtpla() {
		return txtpla;
	}

	public void setTxtpla(Text txtpla) {
		this.txtpla = txtpla;
	}

	public Text getTxtmod() {
		return txtmod;
	}

	public void setTxtmod(Text txtmod) {
		this.txtmod = txtmod;
	}

	public Text getTxtchass() {
		return txtchass;
	}

	public void setTxtchass(Text txtchass) {
		this.txtchass = txtchass;
	}

	public Text getTxtano() {
		return txtano;
	}

	public void setTxtano(Text txtano) {
		this.txtano = txtano;
	}

	public Text getTxtfab() {
		return txtfab;
	}

	public void setTxtfab(Text txtfab) {
		this.txtfab = txtfab;
	}

	public Text getTxttitu() {
		return txttitu;
	}

	public void setTxttitu(Text txttitu) {
		this.txttitu = txttitu;
	}

	public Text getTxtidS() {
		return txtidS;
	}

	public void setTxtidS(Text txtidS) {
		this.txtidS = txtidS;
	}

	public Text getTxtval() {
		return txtval;
	}

	public void setTxtval(Text txtval) {
		this.txtval = txtval;
	}

	public Text getTxtdes() {
		return txtdes;
	}

	public void setTxtdes(Text txtdes) {
		this.txtdes = txtdes;
	}

	public Text getTxtvig() {
		return txtvig;
	}

	public void setTxtvig(Text txtvig) {
		this.txtvig = txtvig;
	}

	public Text getTxttitu2() {
		return txttitu2;
	}

	public void setTxttitu2(Text txttitu2) {
		this.txttitu2 = txttitu2;
	}
}
