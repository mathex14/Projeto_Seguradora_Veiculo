package br.unipe.mtp3.dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import br.unipe.mtp3.GUI.Main_Menu;
import br.unipe.mtp3.modelo.Botoes;
import br.unipe.mtp3.modelo.ButtonPressOk;
import br.unipe.mtp3.modelo.TextFields;

public class ConnectionAlt {
	
	private Botoes b = new Botoes();
	private Botoes bM= new Botoes();
	private TextFields tf= new TextFields();
	private Main_Menu mm = new Main_Menu();

	ButtonPressOk BPO= new ButtonPressOk(b, bM, tf, mm);	
	public ConnectionAlt(ButtonPressOk BPO, Main_Menu mm) {
		    this.mm=mm;
			this.BPO=BPO;
	}
		
	public void Alteracao() throws ClassNotFoundException, SQLException{
		
		
	    String url="jdbc:postgresql://localhost:5432/seguradora";
	    String login="postgres";
	    String senha="h160844";

		try {
		Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
		e.printStackTrace();
		return;
		}
		Connection connection = null;
		
		try {
		connection = DriverManager.getConnection(url,login,senha);
		} catch (SQLException e) {
		e.printStackTrace();
		return;
		}

		Statement sql = connection.createStatement();
		if (connection != null) {
			if(mm.getTabSelected()==1){
				sql.executeUpdate("UPDATE titular SET id="+BPO.getDadoIdC()+", cpf='"+BPO.getDadoCpf()+"', nome='"+BPO.getDadoNome()+"', telefone='"+BPO.getDadoTel()+"', endereco='"+BPO.getDadoEnd()+"', identidade='"+BPO.getDadoIdent()+"' WHERE id="+BPO.getDadoIdC()+"");
			}else if(mm.getTabSelected()==2){
				sql.executeUpdate("UPDATE veiculo SET id="+BPO.getDadoIdV()+", placa='"+BPO.getDadoPla()+"', modelo='"+BPO.getDadoMod()+"', chassis='"+BPO.getDadoChass()+"', ano='"+BPO.getDadoAno()+"', fabricante='"+BPO.getDadoFab()+"', titular='"+BPO.getDadoTitu()+"' WHERE id="+BPO.getDadoIdV()+"");
			} else if(mm.getTabSelected()==3){
				sql.executeUpdate("UPDATE seguro SET id="+BPO.getDadoIdS()+", valor='"+BPO.getDadoVal()+"', descricao='"+BPO.getDadoDes()+"', vigencia='"+BPO.getDadoVig()+"', titular='"+BPO.getDadoTitu2()+"' WHERE id="+BPO.getDadoIdS()+"");
			}
		} else {
		}

		}

	}
