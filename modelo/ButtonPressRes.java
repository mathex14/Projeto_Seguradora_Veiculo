package br.unipe.mtp3.modelo;

import br.unipe.mtp3.GUI.Main_Menu;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ButtonPressRes implements EventHandler<ActionEvent>{
	
	Main_Menu mm=new Main_Menu();
	private Botoes b= new Botoes();
	private Botoes bM= new Botoes();
	private TextFields tf= new TextFields();
	
	public ButtonPressRes(Botoes b, Botoes bM, TextFields tf) {
		this.b=b;
		this.bM=bM;
		this.tf=tf;
	}
	
	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		mm.Carregar(b ,bM, tf);
		bM.getInvs().requestFocus();
		
	}

}
