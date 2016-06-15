package br.unipe.mtp3.dados;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import br.unipe.mtp3.GUI.Main_Menu;
import br.unipe.mtp3.modelo.Botoes;
import br.unipe.mtp3.modelo.ButtonPressGer;
import br.unipe.mtp3.modelo.TextFields;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class GeradorTXT {
	
	private Botoes b = new Botoes();
	private Botoes bM= new Botoes();
	private TextFields tf= new TextFields();
	private Main_Menu mm = new Main_Menu();
	private Stage stage = new Stage();

	ButtonPressGer BPG= new ButtonPressGer(b, bM, tf, mm, stage);	
	public GeradorTXT(ButtonPressGer BPG,  Main_Menu mm, Stage stage) {
			this.BPG=BPG;
			this.mm=mm;
	}
	
	public void Gerando() throws FileNotFoundException, UnsupportedEncodingException{
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Info");
		alert.setHeaderText("Arquivo gerado com sucesso!");
		try{
		PrintWriter writer = new PrintWriter("Arquivo_Seguradora.txt", "UTF-8");
		if(mm.getTabSelected()==1){
			writer.println("Cliente:");
			writer.println("ID: "+BPG.getDadoIdC());
			writer.println("CPF: "+BPG.getDadoCpf());
			writer.println("Nome: "+BPG.getDadoNome());
			writer.println("Telefone: "+BPG.getDadoTel());
			writer.println("Endereço: "+BPG.getDadoEnd());
			writer.println("Identidade: "+BPG.getDadoIdent());
			writer.close();
			alert.show();
		}else if(mm.getTabSelected()==2){
			writer.println("Veiculo:");
			writer.println("ID: "+BPG.getDadoIdV());
			writer.println("Placa: "+BPG.getDadoPla());
			writer.println("Modelo: "+BPG.getDadoMod());
			writer.println("Chassis: "+BPG.getDadoChass());
			writer.println("Ano: "+BPG.getDadoAno());
			writer.println("Fabricante: "+BPG.getDadoFab());
			writer.println("Titular: "+BPG.getDadoTitu());
			writer.close();
			alert.show();
		}else if(mm.getTabSelected()==3){
			writer.println("Seguro:");
			writer.println("ID: "+BPG.getDadoIdS());
			writer.println("Valor: "+BPG.getDadoVal());
			writer.println("Descrição: "+BPG.getDadoDes());
			writer.println("Vigência: "+BPG.getDadoVig());
			writer.println("Titular: "+BPG.getDadoTitu2());
			writer.close();
			alert.show();
		}
		} catch (IOException ex) {
			  System.out.println("FAIL");
			  ex.printStackTrace();
		}
	}

}
