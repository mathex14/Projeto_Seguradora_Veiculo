package br.unipe.mtp3.modelo;



import java.sql.SQLException;

import br.unipe.mtp3.GUI.Main_Menu;
import br.unipe.mtp3.dados.ConnectionExb;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

public class ButtonPressExb implements EventHandler<ActionEvent>{
	
	Stage PrimaryStage = new Stage();
	private Botoes b= new Botoes();
	private Botoes bM= new Botoes();
	private TextFields tf= new TextFields();
	private Main_Menu mm= new Main_Menu();
	private TableView <ObservableList<String>> table = new TableView<>();
	Label label = new Label("Clientes cadastrados:");
	VBox tblvbx = new VBox(); 
	Scene scene = new Scene(tblvbx,850,500);
	
	TableColumn <ObservableList<String>, String> ColIdC = new TableColumn<>("ID");
    TableColumn <ObservableList<String>, String> ColCpf = new TableColumn<>("CPF");
    TableColumn <ObservableList<String>, String> ColNome = new TableColumn<>("Nome");
    TableColumn <ObservableList<String>, String> ColTel = new TableColumn<>("Telefone");
    TableColumn <ObservableList<String>, String> ColEnd = new TableColumn<>("Endereço");
    TableColumn <ObservableList<String>, String> ColIdent = new TableColumn<>("Identidade");
    
    TableColumn <ObservableList<String>, String> ColIdV = new TableColumn<>("ID");
    TableColumn <ObservableList<String>, String> ColMod = new TableColumn<>("Modelo");
    TableColumn <ObservableList<String>, String> ColFab = new TableColumn<>("Fabricante");
    TableColumn <ObservableList<String>, String> ColAno = new TableColumn<>("Ano");
    TableColumn <ObservableList<String>, String> ColChass = new TableColumn<>("Chassis");
    TableColumn <ObservableList<String>, String> ColPla = new TableColumn<>("Placa");
    TableColumn <ObservableList<String>, String> ColTitu = new TableColumn<>("Titular");
    
    TableColumn <ObservableList<String>, String> ColIdS = new TableColumn<>("ID");
    TableColumn <ObservableList<String>, String> ColVal = new TableColumn<>("Valor");
    TableColumn <ObservableList<String>, String> ColDes = new TableColumn<>("Descrição");
    TableColumn <ObservableList<String>, String> ColVig = new TableColumn<>("Vigência");
    TableColumn <ObservableList<String>, String> ColTitu2 = new TableColumn<>("Titular");
	
	public ButtonPressExb(Botoes b, Botoes bM, TextFields tf, Stage PrimaryStage, Main_Menu mm) {
		this.b=b;
		this.bM=bM;
		this.tf=tf;
		this.PrimaryStage=PrimaryStage;
		this.mm=mm;
		SetCF();
	}
	
	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub	
		setColumns();
		 
        Stage stage = new Stage();
        ConnectionExb CExb = new ConnectionExb(this, table, mm);
        
        if(mm.getTabSelected()==1)
        	label.setText("Clientes cadastrados:");
        else if(mm.getTabSelected()==2)
        	label.setText("Veiculos cadastrados:");
        else if(mm.getTabSelected()==3)
        	label.setText("Seguros cadastrados:");
        
		try {
			CExb.Exibicao();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(PrimaryStage);
        stage.setTitle("Lista de clientes cadastrados");
        stage.setScene(scene);  
        stage.show();

		bM.getInvs().requestFocus();
		
	}
	
	public void setColumns(){
		
		if(mm.getTabSelected()==1){
			ColIdC.prefWidthProperty().bind(table.widthProperty().multiply(0.125));
			ColCpf.prefWidthProperty().bind(table.widthProperty().multiply(0.125)); 
			ColNome.prefWidthProperty().bind(table.widthProperty().multiply(0.2)); 
			ColTel.prefWidthProperty().bind(table.widthProperty().multiply(0.15)); 
			ColEnd.prefWidthProperty().bind(table.widthProperty().multiply(0.25));
			ColIdent.prefWidthProperty().bind(table.widthProperty().multiply(0.15)); 
			
			tblvbx.getChildren().removeAll(label, table);
			table.getColumns().removeAll(ColIdC,ColCpf, ColNome, ColEnd,ColTel, ColIdent);
			
			label.setFont(new Font("Arial.BOLD", 16));
			table.getColumns().addAll(ColIdC, ColCpf, ColNome, ColTel, ColEnd, ColIdent);
			tblvbx.getChildren().addAll(label, table);
			tblvbx.setPadding(new Insets(15, 15, 15, 15));
		}else if(mm.getTabSelected()==2){
			ColIdV.prefWidthProperty().bind(table.widthProperty().multiply(0.125)); 
			ColPla.prefWidthProperty().bind(table.widthProperty().multiply(0.15)); 
			ColMod.prefWidthProperty().bind(table.widthProperty().multiply(0.15)); 
			ColAno.prefWidthProperty().bind(table.widthProperty().multiply(0.125)); 
			ColFab.prefWidthProperty().bind(table.widthProperty().multiply(0.15));
			ColChass.prefWidthProperty().bind(table.widthProperty().multiply(0.175));
			ColTitu.prefWidthProperty().bind(table.widthProperty().multiply(0.125));
			
			tblvbx.getChildren().removeAll(label, table);
			table.getColumns().removeAll(ColIdV, ColPla, ColMod, ColAno, ColFab, ColChass, ColTitu);
			
			label.setFont(new Font("Arial.BOLD", 16));
			table.getColumns().addAll(ColIdV, ColPla, ColMod, ColAno, ColFab, ColChass, ColTitu);
			tblvbx.getChildren().addAll(label, table);
			tblvbx.setPadding(new Insets(15, 15, 15, 15));
		}else if(mm.getTabSelected()==3){
			ColIdS.prefWidthProperty().bind(table.widthProperty().multiply(0.125)); 
			ColVal.prefWidthProperty().bind(table.widthProperty().multiply(0.125)); 
			ColDes.prefWidthProperty().bind(table.widthProperty().multiply(0.375)); 
			ColVig.prefWidthProperty().bind(table.widthProperty().multiply(0.25)); 
			ColTitu2.prefWidthProperty().bind(table.widthProperty().multiply(0.125)); 
			
			tblvbx.getChildren().removeAll(label, table);
			table.getColumns().removeAll(ColIdS, ColVal, ColDes,ColVig, ColTitu2);
			
			label.setFont(new Font("Arial.BOLD", 16));
			table.getColumns().addAll(ColIdS, ColVal, ColDes,ColVig, ColTitu2);
			tblvbx.getChildren().addAll(label, table);
			tblvbx.setPadding(new Insets(15, 15, 15, 15));
		}
		
	}
	
	public void SetCF(){
		
		if (mm.getTabSelected()==1){
			
			ColIdC.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList<String>,String>, ObservableValue<String>>() {         
		        @Override
		        public ObservableValue<String> call(CellDataFeatures<ObservableList<String>, String> cdf) {     
		            return new SimpleStringProperty(cdf.getValue().get(0));
		        }
		    }); 
			
			ColCpf.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList<String>,String>, ObservableValue<String>>() {         
		        @Override
		        public ObservableValue<String> call(CellDataFeatures<ObservableList<String>, String> cdf) {     
		            return new SimpleStringProperty(cdf.getValue().get(1));
		        }
		    }); 
			
			ColNome.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList<String>,String>, ObservableValue<String>>() {         
		        @Override
		        public ObservableValue<String> call(CellDataFeatures<ObservableList<String>, String> cdf) {     
		            return new SimpleStringProperty(cdf.getValue().get(2));
		        }
		    }); 
			
			ColTel.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList<String>,String>, ObservableValue<String>>() {         
		        @Override
		        public ObservableValue<String> call(CellDataFeatures<ObservableList<String>, String> cdf) {     
		            return new SimpleStringProperty(cdf.getValue().get(3));
		        }
		    }); 
			
			ColEnd.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList<String>,String>, ObservableValue<String>>() {         
		        @Override
		        public ObservableValue<String> call(CellDataFeatures<ObservableList<String>, String> cdf) {     
		            return new SimpleStringProperty(cdf.getValue().get(4));
		        }
		    }); 
			
			ColIdent.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList<String>,String>, ObservableValue<String>>() {         
		        @Override
		        public ObservableValue<String> call(CellDataFeatures<ObservableList<String>, String> cdf) {     
		            return new SimpleStringProperty(cdf.getValue().get(5));
		        }
		    }); 
		
		}else if(mm.getTabSelected()==2){
			ColIdV.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList<String>,String>, ObservableValue<String>>() {         
		        @Override
		        public ObservableValue<String> call(CellDataFeatures<ObservableList<String>, String> cdf) {     
		            return new SimpleStringProperty(cdf.getValue().get(0));
		        }
		    }); 
			
			ColPla.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList<String>,String>, ObservableValue<String>>() {         
		        @Override
		        public ObservableValue<String> call(CellDataFeatures<ObservableList<String>, String> cdf) {     
		            return new SimpleStringProperty(cdf.getValue().get(1));
		        }
		    }); 
			
			ColMod.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList<String>,String>, ObservableValue<String>>() {         
		        @Override
		        public ObservableValue<String> call(CellDataFeatures<ObservableList<String>, String> cdf) {     
		            return new SimpleStringProperty(cdf.getValue().get(2));
		        }
		    }); 
			
			ColAno.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList<String>,String>, ObservableValue<String>>() {         
		        @Override
		        public ObservableValue<String> call(CellDataFeatures<ObservableList<String>, String> cdf) {     
		            return new SimpleStringProperty(cdf.getValue().get(3));
		        }
		    }); 
			
			ColFab.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList<String>,String>, ObservableValue<String>>() {         
		        @Override
		        public ObservableValue<String> call(CellDataFeatures<ObservableList<String>, String> cdf) {     
		            return new SimpleStringProperty(cdf.getValue().get(4));
		        }
		    }); 
			
			ColChass.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList<String>,String>, ObservableValue<String>>() {         
		        @Override
		        public ObservableValue<String> call(CellDataFeatures<ObservableList<String>, String> cdf) {     
		            return new SimpleStringProperty(cdf.getValue().get(5));
		        }
		    }); 
			
			ColTitu.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList<String>,String>, ObservableValue<String>>() {         
		        @Override
		        public ObservableValue<String> call(CellDataFeatures<ObservableList<String>, String> cdf) {     
		            return new SimpleStringProperty(cdf.getValue().get(6));
		        }
		    }); 
		}else if(mm.getTabSelected()==3){
			
			ColIdS.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList<String>,String>, ObservableValue<String>>() {         
		        @Override
		        public ObservableValue<String> call(CellDataFeatures<ObservableList<String>, String> cdf) {     
		            return new SimpleStringProperty(cdf.getValue().get(0));
		        }
		    }); 
			
			ColVal.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList<String>,String>, ObservableValue<String>>() {         
		        @Override
		        public ObservableValue<String> call(CellDataFeatures<ObservableList<String>, String> cdf) {     
		            return new SimpleStringProperty(cdf.getValue().get(1));
		        }
		    }); 
			
			ColDes.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList<String>,String>, ObservableValue<String>>() {         
		        @Override
		        public ObservableValue<String> call(CellDataFeatures<ObservableList<String>, String> cdf) {     
		            return new SimpleStringProperty(cdf.getValue().get(2));
		        }
		    }); 
			
			ColVig.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList<String>,String>, ObservableValue<String>>() {         
		        @Override
		        public ObservableValue<String> call(CellDataFeatures<ObservableList<String>, String> cdf) {     
		            return new SimpleStringProperty(cdf.getValue().get(3));
		        }
		    }); 
			
			ColTitu2.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList<String>,String>, ObservableValue<String>>() {         
		        @Override
		        public ObservableValue<String> call(CellDataFeatures<ObservableList<String>, String> cdf) {     
		            return new SimpleStringProperty(cdf.getValue().get(4));
		        }
		    }); 

			
		}
	}
	

}
