package br.unipe.mtp3.dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.unipe.mtp3.GUI.Main_Menu;
import br.unipe.mtp3.modelo.Botoes;
import br.unipe.mtp3.modelo.ButtonPressExb;
import br.unipe.mtp3.modelo.TextFields;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class ConnectionExb {
	
	private Botoes b = new Botoes();
	private Botoes bM= new Botoes();
	private TextFields tf= new TextFields();
	private Main_Menu mm = new Main_Menu();
	private Stage stage= new Stage();
	private ObservableList<ObservableList> data;
	private TableView tableview;

	ButtonPressExb BPE= new ButtonPressExb(b, bM, tf, stage, mm);	
	
	public ConnectionExb(ButtonPressExb BPE,  TableView tableview, Main_Menu mm) {
			this.BPE=BPE;
			this.mm=mm;
			this.tableview=tableview;
	}
	
	public void Exibicao() throws ClassNotFoundException, SQLException{
		
		
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
		data = FXCollections.observableArrayList();
		String SQL2="";
		if(mm.getTabSelected()==1){
			SQL2 = "SELECT * FROM titular";
		}else if(mm.getTabSelected()==2){
			SQL2 = "SELECT * FROM veiculo";
		}else if(mm.getTabSelected()==3){
			SQL2 = "SELECT * FROM seguro";
		} else {
			return ;
		}
        ResultSet rs = connection.createStatement().executeQuery(SQL2);
		addTable(rs);

		}
	
	public void addTable(ResultSet rs) throws SQLException{
	        while(rs.next()){
	            //Iterate Row
	            ObservableList<String> row = FXCollections.observableArrayList();
	            for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
	                //Iterate Column
	                row.add(rs.getString(i));
	            }
	            data.add(row);
	
	        }
	        tableview.setItems(data);
	      }

}
