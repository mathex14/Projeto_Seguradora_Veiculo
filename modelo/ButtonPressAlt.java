package br.unipe.mtp3.modelo;

import br.unipe.mtp3.GUI.Main_Menu;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ButtonPressAlt implements EventHandler<ActionEvent> {
	
	private Main_Menu mm = new Main_Menu();
	private Botoes b= new Botoes();
	private Botoes bM= new Botoes();
	private TextFields tf= new TextFields();
	
	public ButtonPressAlt(Botoes b, Botoes bM, TextFields tf, Main_Menu mm) {
		this.b=b;
		this.bM=bM;
		this.tf=tf;
		this.mm = mm;
	}

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		mm.setCadastrando(0);
		mm.setAlterando(1);
		b.getConsultar().setDisable(true);
		
		b.getCadastrar().setDisable(false);
		b.getAcessar().setDisable(true);
		b.getDeletar().setDisable(true);
		b.getAlterar().setDisable(true);
		b.getOk().setDisable(false);
		
		tf.txtfidC.setDisable(true);
		tf.getTxtfcpf().setDisable(false);
		tf.getTxtfnome().setDisable(false);
		tf.txtfident.setDisable(false);
		tf.txtftel.setDisable(false);
		tf.txtfend.setDisable(false);
		tf.txtfpla.setDisable(false);
		
		tf.txtfidV.setDisable(true);
		tf.txtfpla.setDisable(false);
		tf.txtffab.setDisable(false);
		tf.txtfmod.setDisable(false);
		tf.txtfano.setDisable(false);
		tf.txtfchass.setDisable(false);
		tf.txtftitu.setDisable(false);
		
		tf.txtfidS.setDisable(true);
		tf.txtfval.setDisable(false);
		tf.txtfdes.setDisable(false);
		tf.txtfvig.setDisable(false);
		tf.txtftitu2.setDisable(false);
		
		bM.getInvs().requestFocus();
		
	}

}
