package br.unipe.mtp3.modelo;

import br.unipe.mtp3.GUI.Main_Menu;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ButtonPressAcess implements EventHandler<ActionEvent> {
	
		Main_Menu mm=new Main_Menu();
		private Botoes b= new Botoes();
		private Botoes bM= new Botoes();
		private TextFields tf= new TextFields();
		
		public ButtonPressAcess(Botoes b, Botoes bM, TextFields tf) {
			this.b=b;
			this.bM=bM;
			this.tf=tf;
		}

		@Override
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub
			mm.Carregar(b, bM, tf);
			
			b.getConsultar().setDisable(false);
			
			bM.getAcessar().setDisable(true);
			bM.getCadastrar().setDisable(false);
			
			tf.txtfidS.setDisable(false);
			tf.txtfidV.setDisable(false);
			tf.txtfidC.setDisable(false);
			
			bM.getInvs().requestFocus();
			
		}

}
