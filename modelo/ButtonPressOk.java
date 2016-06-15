package br.unipe.mtp3.modelo;
import java.sql.SQLException;

import br.unipe.mtp3.GUI.Main_Menu;
import br.unipe.mtp3.dados.ConnectionAlt;
import br.unipe.mtp3.dados.ConnectionCad;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ButtonPressOk implements EventHandler<ActionEvent>{
	
	private Main_Menu mm=new Main_Menu();
	private Botoes b= new Botoes();
	private Botoes bM= new Botoes();
	private TextFields tf= new TextFields();
	
	private String DadoIdC = String.valueOf(tf.txtfidC.getText());
	private String DadoCpf = String.valueOf(tf.getTxtfcpf().getText());
	private String DadoNome = String.valueOf(tf.getTxtfnome().getText());
	private String DadoTel = String.valueOf(tf.txtftel.getText());
	private String DadoEnd = String.valueOf(tf.txtfend.getText());
	private String DadoIdent = String.valueOf(tf.txtfident.getText());
	
	private String DadoIdV = String.valueOf(tf.txtfidV.getText());
	private String DadoPla = String.valueOf(tf.txtfpla.getText());
	private String DadoMod = String.valueOf(tf.txtfmod.getText());
	private String DadoChass = String.valueOf(tf.txtfchass.getText());
	private String DadoAno = String.valueOf(tf.txtfano.getText());
	private String DadoFab = String.valueOf(tf.txtffab.getText());
	private String DadoTitu = String.valueOf(tf.txtftitu.getText());
	
	private String DadoIdS = String.valueOf(tf.txtfidS.getText());
	private String DadoVal = String.valueOf(tf.txtfval.getText());
	private String DadoDes = String.valueOf(tf.txtfdes.getText());
	private String DadoVig = String.valueOf(tf.txtfvig.getText());
	private String DadoTitu2 = String.valueOf(tf.txtftitu2.getText());
	
	public String getDadoCpf() {
		return DadoCpf;
	}

	public void setDadoCpf(String dadoCpf) {
		DadoCpf = dadoCpf;
	}

	public String getDadoNome() {
		return DadoNome;
	}

	public void setDadoNome(String dadoNome) {
		DadoNome = dadoNome;
	}

	public String getDadoDtNasc() {
		return DadoIdent;
	}

	public void setDadoDtNasc(String dadoDtNasc) {
		DadoIdent = dadoDtNasc;
	}

	public String getDadoTel() {
		return DadoTel;
	}

	public void setDadoTel(String dadoTel) {
		DadoTel = dadoTel;
	}

	public String getDadoIdC() {
		return DadoIdC;
	}

	public void setDadoIdC(String dadoIdC) {
		DadoIdC = dadoIdC;
	}

	public String getDadoEnd() {
		return DadoEnd;
	}

	public void setDadoEnd(String dadoEnd) {
		DadoEnd = dadoEnd;
	}

	public String getDadoIdent() {
		return DadoIdent;
	}

	public void setDadoIdent(String dadoIdent) {
		DadoIdent = dadoIdent;
	}

	public String getDadoIdV() {
		return DadoIdV;
	}

	public void setDadoIdV(String dadoIdV) {
		DadoIdV = dadoIdV;
	}

	public String getDadoPla() {
		return DadoPla;
	}

	public void setDadoPla(String dadoPla) {
		DadoPla = dadoPla;
	}

	public String getDadoMod() {
		return DadoMod;
	}

	public void setDadoMod(String dadoMod) {
		DadoMod = dadoMod;
	}

	public String getDadoChass() {
		return DadoChass;
	}

	public void setDadoChass(String dadoChass) {
		DadoChass = dadoChass;
	}

	public String getDadoAno() {
		return DadoAno;
	}

	public void setDadoAno(String dadoAno) {
		DadoAno = dadoAno;
	}

	public String getDadoFab() {
		return DadoFab;
	}

	public void setDadoFab(String dadoFab) {
		DadoFab = dadoFab;
	}

	public String getDadoTitu() {
		return DadoTitu;
	}

	public void setDadoTitu(String dadoTitu) {
		DadoTitu = dadoTitu;
	}

	public String getDadoIdS() {
		return DadoIdS;
	}

	public void setDadoIdS(String dadoIdS) {
		DadoIdS = dadoIdS;
	}

	public String getDadoVal() {
		return DadoVal;
	}

	public void setDadoVal(String dadoVal) {
		DadoVal = dadoVal;
	}

	public String getDadoDes() {
		return DadoDes;
	}

	public void setDadoDes(String dadoDes) {
		DadoDes = dadoDes;
	}

	public String getDadoVig() {
		return DadoVig;
	}

	public void setDadoVig(String dadoVig) {
		DadoVig = dadoVig;
	}

	public String getDadoTitu2() {
		return DadoTitu2;
	}

	public void setDadoTitu2(String dadoTitu2) {
		DadoTitu2 = dadoTitu2;
	}

	public ButtonPressOk(Botoes b, Botoes bM, TextFields tf, Main_Menu mm) {
		this.b=b;
		this.bM=bM;
		this.tf=tf;
		this.mm = mm;
	}
	
	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		ConnectionCad Ccad= new ConnectionCad(this,mm);
		ConnectionAlt Calt= new ConnectionAlt(this, mm);
		
		setVars();
		
		if (mm.getCadastrando()==1){
		try {
			Ccad.Cadastro();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}else if (mm.getAlterando()==1){
		try {
			Calt.Alteracao();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		bM.getInvs().requestFocus();
		mm.Carregar(b, bM, tf);
		
	}
	
	public void setVars(){
		DadoIdC = String.valueOf(tf.txtfidC.getText());
		DadoCpf = String.valueOf(tf.getTxtfcpf().getText());
		DadoNome = String.valueOf(tf.getTxtfnome().getText());
		DadoTel = String.valueOf(tf.txtftel.getText());
		DadoEnd = String.valueOf(tf.txtfend.getText());
		DadoIdent = String.valueOf(tf.txtfident.getText());
		
		DadoIdV = String.valueOf(tf.txtfidV.getText());
		DadoPla = String.valueOf(tf.txtfpla.getText());
		DadoMod = String.valueOf(tf.txtfmod.getText());
		DadoChass = String.valueOf(tf.txtfchass.getText());
		DadoAno = String.valueOf(tf.txtfano.getText());
		DadoFab = String.valueOf(tf.txtffab.getText());
		DadoTitu = String.valueOf(tf.txtftitu.getText());
		
		DadoIdS = String.valueOf(tf.txtfidS.getText());
		DadoVal = String.valueOf(tf.txtfval.getText());
		DadoDes = String.valueOf(tf.txtfdes.getText());
		DadoVig = String.valueOf(tf.txtfvig.getText());
		DadoTitu2 = String.valueOf(tf.txtftitu2.getText());
	}

}
