package br.unipe.mtp3.dados;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import br.unipe.mtp3.GUI.Main_Menu;
import br.unipe.mtp3.modelo.Botoes;
import br.unipe.mtp3.modelo.ButtonPressOk;
import br.unipe.mtp3.modelo.TextFields;

public class ConnectionCad {
		
	private Main_Menu mm = new Main_Menu();
	private Botoes b = new Botoes();
	private Botoes bM= new Botoes();
	private TextFields tf= new TextFields();

	ButtonPressOk BPO= new ButtonPressOk(b, bM, tf, mm);	
	public ConnectionCad(ButtonPressOk BPO, Main_Menu mm) {
			this.BPO=BPO;
			this.mm=mm;
	}
		
	public void Cadastro() throws ClassNotFoundException, SQLException{
		
		
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
				sql.executeUpdate("INSERT INTO Titular (id, cpf, nome, telefone, endereco, identidade) VALUES("+BPO.getDadoIdC()+",'"+BPO.getDadoCpf()+"','"+BPO.getDadoNome()+"','"+BPO.getDadoTel()+"','"+BPO.getDadoEnd()+"','" +BPO.getDadoIdent()+"')");
			}else if(mm.getTabSelected()==2){
				sql.executeUpdate("INSERT INTO Veiculo (id, placa, modelo, chassis, ano, fabricante, titular) VALUES("+BPO.getDadoIdV()+",'"+BPO.getDadoPla()+"','"+BPO.getDadoMod()+"', '"+BPO.getDadoChass()+"','"+BPO.getDadoAno()+"','" +BPO.getDadoFab()+"','" +BPO.getDadoTitu()+"')");
			}else if(mm.getTabSelected()==3){
				sql.executeUpdate("INSERT INTO Seguro (id, valor, descricao, vigencia, titular) VALUES("+BPO.getDadoIdS()+", "+BPO.getDadoVal()+",'"+BPO.getDadoDes()+"','"+BPO.getDadoVig()+"','"+BPO.getDadoTitu2()+"')");
			} 
		} else {
		}

		}

	}



