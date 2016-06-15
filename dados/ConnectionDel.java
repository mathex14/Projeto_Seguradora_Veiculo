package br.unipe.mtp3.dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import br.unipe.mtp3.GUI.Main_Menu;
import br.unipe.mtp3.modelo.Botoes;
import br.unipe.mtp3.modelo.ButtonPressDel;
import br.unipe.mtp3.modelo.TextFields;

public class ConnectionDel {

	private Botoes b = new Botoes();
	private Botoes bM= new Botoes();
	private TextFields tf= new TextFields();
	private Main_Menu mm = new Main_Menu();

	ButtonPressDel BPD= new ButtonPressDel(b, bM, tf, mm);	
	public ConnectionDel(ButtonPressDel BPD,  Main_Menu mm) {
			this.BPD=BPD;
			this.mm=mm;
	}
		
	public void Deletar() throws ClassNotFoundException, SQLException{
		
		
	    String url="jdbc:postgresql://localhost:5432/seguradora";
	    String login="postgres";
	    String senha="h160844";

		try {
		Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
		e.printStackTrace();
		return;
		}

		System.out.println(BPD.getDadoCpf());
		Connection connection = null;
		
		try {
		connection = DriverManager.getConnection(url,login,senha);
		} catch (SQLException e) {
		e.printStackTrace();
		return;
		}
		//sql.executeUpdate("DELETE FROM titular WHERE id='"+BPD.getDadoIdS()+"'");
		Statement sql = connection.createStatement();
		System.out.println(mm.getTabSelected());
		if(mm.getTabSelected()==1){
			sql.executeUpdate("DELETE FROM titular WHERE id="+BPD.getDadoIdC());
		}else if(mm.getTabSelected()==2){
			sql.executeUpdate("DELETE FROM veiculo WHERE id="+BPD.getDadoIdV());
		}else if(mm.getTabSelected()==3){
			sql.executeUpdate("DELETE FROM titular WHERE id="+BPD.getDadoIdS());
		} else {
		}

		}

	}
