package br.unipe.mtp3.modelo;

import br.unipe.mtp3.GUI.Main_Menu;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ButtonPressCad implements EventHandler<ActionEvent> {
	
	private Main_Menu mm=new Main_Menu();
	private Botoes b= new Botoes();
	private Botoes bM= new Botoes();
	private TextFields tf= new TextFields();
	
	public ButtonPressCad(Botoes b, Botoes bM, TextFields tf, Main_Menu mm) {
		this.b=b;
		this.bM=bM;
		this.tf=tf;
		this.mm = mm;
	}

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		mm.Carregar(b, bM, tf);
		mm.setCadastrando(1);
		mm.setAlterando(0);
		b.getConsultar().setDisable(true);
		
		bM.getCadastrar().setDisable(true);
		bM.getAcessar().setDisable(false);
		b.getDeletar().setDisable(true);
		b.getAlterar().setDisable(true);
		b.getOk().setDisable(false);
		
		tf.txtfidC.setDisable(false);
		tf.getTxtfcpf().setDisable(false);
		tf.getTxtfnome().setDisable(false);
		tf.txtfident.setDisable(false);
		tf.txtftel.setDisable(false);
		tf.txtfend.setDisable(false);
		
		tf.txtfpla.setDisable(false);
		tf.txtffab.setDisable(false);
		tf.txtfmod.setDisable(false);
		tf.txtfano.setDisable(false);
		tf.txtfchass.setDisable(false);
		tf.txtfidV.setDisable(false);
		tf.txtftitu.setDisable(false);
		
		tf.txtfidS.setDisable(false);
		tf.txtfval.setDisable(false);
		tf.txtfdes.setDisable(false);
		tf.txtfvig.setDisable(false);
		tf.txtftitu2.setDisable(false);
		
		bM.getInvs().requestFocus();
		
	}

}
