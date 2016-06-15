package br.unipe.mtp3.dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.unipe.mtp3.GUI.Main_Menu;
import br.unipe.mtp3.modelo.Botoes;
import br.unipe.mtp3.modelo.ButtonPressCons;
import br.unipe.mtp3.modelo.TextFields;

public class ConnectionLer {
	private Botoes b = new Botoes();
	private Botoes bM= new Botoes();
	private TextFields tf= new TextFields();
	Main_Menu mm = new Main_Menu();
	ButtonPressCons BPO= new ButtonPressCons(b, bM, tf, mm);	
	
	public ConnectionLer(ButtonPressCons BPO, TextFields tf, Main_Menu mm) {
			this.tf=tf;
			this.BPO=BPO;
			this.mm=mm;
	}
		
	public void Consulta() throws ClassNotFoundException, SQLException{
		
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
				ResultSet rs = sql.executeQuery("Select * from titular where id='"+BPO.getDadoIdC()+"'");
				while (rs.next()) {
					  String id = rs.getString("id");
					  String cpf = rs.getString("cpf");
					  String nome = rs.getString("nome");
					  String telefone = rs.getString("telefone");
					  String endereco = rs.getString("endereco");
					  String identidade = rs.getString("identidade");
					  tf.getTxtfidC().setText(id);
					  tf.getTxtfcpf().setText(cpf);
					  tf.getTxtfnome().setText(nome);
					  tf.getTxtfident().setText(identidade);
					  tf.getTxtftel().setText(telefone);
					  tf.getTxtfend().setText(endereco);
					  
					}
			}else if(mm.getTabSelected()==2){
				ResultSet rs = sql.executeQuery("Select * from veiculo where id='"+BPO.getDadoIdV()+"'");
				while (rs.next()) {
					  String id = rs.getString("id");
					  String placa = rs.getString("placa");
					  String modelo = rs.getString("modelo");
					  String chassis = rs.getString("chassis");
					  String ano = rs.getString("ano");
					  String fabricante = rs.getString("fabricante");
					  String titular = rs.getString("titular");
					  tf.getTxtfidV().setText(id);
					  tf.getTxtfpla().setText(placa);
					  tf.getTxtfmod().setText(modelo);
					  tf.getTxtfchass().setText(chassis);
					  tf.getTxtfano().setText(ano);
					  tf.getTxtffab().setText(fabricante);
					  tf.getTxtftitu().setText(titular);
					  
					}
			}else if(mm.getTabSelected()==3){
				ResultSet rs = sql.executeQuery("Select * from seguro where id='"+BPO.getDadoIdS()+"'");
				while (rs.next()) {
					  String id = rs.getString("id");
					  String valor = rs.getString("valor");
					  String descricao = rs.getString("descricao");
					  String vigencia = rs.getString("vigencia");
					  String titular = rs.getString("titular");
					  tf.getTxtfidS().setText(id);
					  tf.getTxtfval().setText(valor);
					  tf.getTxtfdes().setText(descricao);
					  tf.getTxtfvig().setText(vigencia);
					  tf.getTxtftitu2().setText(titular);
					  
					}
			}
		} else {
		}

		}

	}
