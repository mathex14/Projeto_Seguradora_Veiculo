package br.unipe.mtp3.GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.unipe.mtp3.modelo.Botoes;
import br.unipe.mtp3.modelo.ButtonPressAcess;
import br.unipe.mtp3.modelo.ButtonPressAlt;
import br.unipe.mtp3.modelo.ButtonPressCad;
import br.unipe.mtp3.modelo.ButtonPressCons;
import br.unipe.mtp3.modelo.ButtonPressDel;
import br.unipe.mtp3.modelo.ButtonPressExb;
import br.unipe.mtp3.modelo.ButtonPressGer;
import br.unipe.mtp3.modelo.ButtonPressOk;
import br.unipe.mtp3.modelo.ButtonPressRes;
import br.unipe.mtp3.modelo.TextFields;
import br.unipe.mtp3.modelo.Texts;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main_Menu extends Application implements ActionListener{
	
	ButtonPressCons gui;
	private int tabSelected=1;
	private int Cadastrando;
	private int Alterando;
	
	public void Main(ButtonPressCons in) { gui = in; }

	@Override
	public void start(Stage stage){
		// TODO Auto-generated method stub
		BorderPane border= new BorderPane();
		Botoes bC = new Botoes();
		Botoes bV = new Botoes();
		Botoes bS = new Botoes();
		Botoes b = new Botoes();
		Botoes b2 = new Botoes();
		Botoes b3 = new Botoes();
		Texts t= new Texts();
		TextFields tf= new TextFields();
		GridPane gridCl = new GridPane();
		GridPane gridVe = new GridPane();
		GridPane gridSe = new GridPane();
		TabPane Tpane = new TabPane();
		Tab tabCliente = new Tab();
		Tab tabVeiculo = new Tab();
		Tab tabSeguro = new Tab();
		
		Tpane.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>() {
		    @Override
		    public void changed(ObservableValue<? extends Tab> observable, Tab oldTab, Tab newTab) {
		        if(newTab == tabCliente) {
		        	tabSelected=1;
		        	addReset(gridCl,b);
		        	PressesMenu(bC,b,tf,stage);
		        	Presses(bC, b, tf, stage);
		        	Carregar(bC, b, tf);
		        	}
		        }
		    });
		
		Tpane.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>() {
		    @Override
		    public void changed(ObservableValue<? extends Tab> observable, Tab oldTab, Tab newTab) {
		        if(newTab == tabVeiculo) {
		        	tabSelected=2;
		        	addReset(gridVe,b);
		        	PressesMenu(bV,b,tf,stage);
		        	Presses(bV, b, tf, stage);
		        	Carregar(bV, b, tf);
		        	}
		        }
		    });
		
		Tpane.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>() {
		    @Override
		    public void changed(ObservableValue<? extends Tab> observable, Tab oldTab, Tab newTab) {
		        if(newTab == tabSeguro) {
		        	tabSelected=3;
		        	addReset(gridSe,b);
		        	PressesMenu(bS,b,tf,stage);
		        	Presses(bS, b, tf, stage);
		        	Carregar(bS, b, tf);
		        	}
		        }
		    });
		
		VBox princ = new VBox(10);
		HBox mtitle = new HBox(10);
		mtitle.setAlignment(Pos.CENTER);
		mtitle.setPadding(new Insets(20));	
		princ.setPadding(new Insets(20));
		princ.setSpacing(20);
	    gridCl.setHgap(10);
	    gridCl.setVgap(10);
	    gridCl.setPadding(new Insets(0, 10, 0, 10));
	    gridVe.setHgap(10);
	    gridVe.setVgap(10);
	    gridVe.setPadding(new Insets(0, 10, 0, 10));
	    gridSe.setHgap(10);
	    gridSe.setVgap(10);
	    gridSe.setPadding(new Insets(0, 10, 0, 10));
	    Tpane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
	    tabCliente.setText("Cliente");
	    tabCliente.setContent(gridCl);
	    tabVeiculo.setText("Veículo");
	    tabVeiculo.setContent(gridVe);
	    tabSeguro.setText("Seguro");
	    tabSeguro.setContent(gridSe);
	    Tpane.getTabs().addAll(tabCliente,tabVeiculo,tabSeguro);
		
		border.setLeft(princ);
		border.setTop(mtitle);
		border.setCenter(Tpane);
		mtitle.setStyle("-fx-background-color: #86A6C6");
		princ.setStyle("-fx-background-color: #C9D7E7");
		
		//BackgroundImage img = new BackgroundImage(new Image("background.png",512,512,false,true),
		 //       BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
		  //        BackgroundSize.DEFAULT); //adicionando a imagem
		
		addtoGPane(gridCl,gridVe,gridSe, t, tf, bC);
		addtoGPane2(gridCl,bC, b);
		addtoGPane2(gridVe,bV, b);
		addtoGPane2(gridSe,bS, b);
		
		princ.getChildren().addAll(t.getMenuTop(),b.getCadastrar(),b.getAcessar(),b.getListar(), b.getInvs());
		mtitle.getChildren().addAll(t.getTitle());
		Scene scene = new Scene(border,680,440);
		//gridCl.setBackground(new Background(img));
		
		Carregar(bC, b, tf);
		Carregar(bV, b2, tf);
		Carregar(bS, b3, tf);
		
		b.settingSize();
		
		stage.setTitle("Seguradora alguma coisa");
		t.settingFonts();
		bC.settingSize();
		bV.settingSize();
		bS.settingSize();
		stage.setScene(scene);
		stage.show();	
		
	}
	
	public void addtoGPane(GridPane gridCl, GridPane gridVe,GridPane gridSe, Texts t, TextFields tf, Botoes b){
		
		gridCl.add(t.getTxtidC(), 1, 1);
		gridCl.add(t.getTxtcpf(), 1, 2);
		gridCl.add(t.getTxtnome(), 1, 3);
		gridCl.add(t.getTxttel(), 1, 4);
		gridCl.add(t.getTxtend(), 1, 5);
		gridCl.add(t.getTxtident(), 1, 6);
		
		gridCl.add(tf.getTxtfidC(), 2, 1);
		gridCl.setColumnSpan(tf.getTxtfidC(), 2);
		gridCl.add(tf.getTxtfcpf(), 2, 2);
		GridPane.setColumnSpan(tf.getTxtfcpf(), 2);
		gridCl.add(tf.getTxtfnome(), 2, 3);
		gridCl.setColumnSpan(tf.getTxtfnome(), 2);
		gridCl.add(tf.getTxtftel(), 2, 4);
		gridCl.setColumnSpan(tf.getTxtftel(), 2);
		gridCl.add(tf.getTxtfend(), 2, 5);
		gridCl.setColumnSpan(tf.getTxtfend(), 2);
		gridCl.add(tf.getTxtfident(), 2, 6);
		gridCl.setColumnSpan(tf.getTxtfident(), 2);
		
		gridVe.add(t.getTxtidV(), 1, 1);
		gridVe.add(t.getTxtpla(), 1, 2);
		gridVe.add(t.getTxtmod(), 1, 3);
		gridVe.add(t.getTxtchass(), 1, 4);
		gridVe.add(t.getTxtano(), 1, 5);
		gridVe.add(t.getTxtfab(), 1, 6);
		gridVe.add(t.getTxttitu(), 1, 7);
		
		gridVe.add(tf.getTxtfidV(), 2, 1);
		gridVe.setColumnSpan(tf.getTxtfidV(), 2);
		gridVe.add(tf.getTxtfpla(), 2, 2);
		GridPane.setColumnSpan(tf.getTxtfpla(), 2);
		gridVe.add(tf.getTxtfmod(), 2, 3);
		gridVe.setColumnSpan(tf.getTxtfmod(), 2);
		gridVe.add(tf.getTxtfchass(), 2, 4);
		gridVe.setColumnSpan(tf.getTxtfchass(), 2);
		gridVe.add(tf.getTxtfano(), 2, 5);
		gridVe.setColumnSpan(tf.getTxtfano(), 2);
		gridVe.add(tf.getTxtffab(), 2, 6);
		GridPane.setColumnSpan(tf.getTxtffab(), 2);
		gridVe.add(tf.getTxtftitu(), 2, 7);
		GridPane.setColumnSpan(tf.getTxtftitu(), 2);
		
		gridSe.add(t.getTxtidS(), 1, 1);
		gridSe.add(t.getTxtval(), 1, 2);
		gridSe.add(t.getTxtdes(), 1, 3);
		gridSe.add(t.getTxtvig(), 1, 4);
		gridSe.add(t.getTxttitu2(), 1, 5);
		
		gridSe.add(tf.getTxtfidS(), 2, 1);
		GridPane.setColumnSpan(tf.getTxtfidS(), 2);
		gridSe.add(tf.getTxtfval(), 2, 2);
		gridSe.setColumnSpan(tf.getTxtfval(), 2);
		gridSe.add(tf.getTxtfdes(), 2, 3);
		gridSe.setColumnSpan(tf.getTxtfdes(), 2);
		gridSe.add(tf.getTxtfvig(), 2, 4);
		gridSe.setColumnSpan(tf.getTxtfvig(), 2);
		gridSe.add(tf.getTxtftitu2(), 2, 5);
		gridSe.setColumnSpan(tf.getTxtftitu2(), 2);
	}
	
	public void addtoGPane2(GridPane grid, Botoes b0, Botoes bM){
		
		grid.add(b0.getConsultar(), 4, 1);
		grid.add(b0.getGerar(), 5, 1);
		grid.add(b0.getOk(), 1, 8);
		grid.add(b0.getAlterar(), 2, 8);
		grid.add(b0.getDeletar(), 3, 8);
		
	}
	
	public void addReset(GridPane grid, Botoes bM){
		grid.add(bM.getResetar(), 6, 10);
	}
	
	public void Carregar(Botoes b0, Botoes bM, TextFields tf){
		
		Cadastrando=0;
		Alterando=0;
		
		b0.getConsultar().setDisable(true);
		b0.getDeletar().setDisable(true);
		b0.getAlterar().setDisable(true);
		b0.getOk().setDisable(true);
		b0.getGerar().setDisable(true);
		
		bM.getCadastrar().setDisable(false);
		bM.getAcessar().setDisable(false);
		
		tf.getTxtfidC().setDisable(true);
		tf.getTxtfcpf().setDisable(true);
		tf.getTxtfnome().setDisable(true);
		tf.getTxtftel().setDisable(true);
		tf.getTxtfend().setDisable(true);
		tf.getTxtfident().setDisable(true);
		
		tf.getTxtfpla().setDisable(true);
		tf.getTxtffab().setDisable(true);
		tf.getTxtfmod().setDisable(true);
		tf.getTxtfano().setDisable(true);
		tf.getTxtfchass().setDisable(true);
		tf.getTxtfidV().setDisable(true);
		tf.getTxtftitu().setDisable(true);
		
		tf.getTxtfidS().setDisable(true);
		tf.getTxtfval().setDisable(true);
		tf.getTxtfdes().setDisable(true);
		tf.getTxtfvig().setDisable(true);
		tf.getTxtftitu2().setDisable(true);
		
		tf.getTxtfidC().clear();
		tf.getTxtfcpf().clear();
		tf.getTxtfnome().clear();
		tf.getTxtftel().clear();
		tf.getTxtfend().clear();
		tf.getTxtfident().clear();
		
		tf.getTxtfpla().clear();
		tf.getTxtffab().clear();
		tf.getTxtfmod().clear();
		tf.getTxtfano().clear();
		tf.getTxtfchass().clear();
		tf.getTxtfidV().clear();
		tf.getTxtftitu().clear();
		
		tf.getTxtfidS().clear();
		tf.getTxtfval().clear();
		tf.getTxtfdes().clear();
		tf.getTxtfvig().clear();
		tf.getTxtftitu2().clear();
		
	}
	
	public void Presses(Botoes b, Botoes bM, TextFields tf, Stage stage){
		EventHandler actlalt = new ButtonPressAlt(b, bM, tf, this);
		EventHandler actlok = new ButtonPressOk(b, bM, tf, this);
		EventHandler actldel = new ButtonPressDel(b, bM, tf, this);
		EventHandler actlcons = new ButtonPressCons(b, bM, tf, this);
		EventHandler actlger = new ButtonPressGer(b, bM, tf, this, stage);
		
		b.getAlterar().setOnAction(actlalt);
		b.getOk().setOnAction(actlok);
		b.getDeletar().setOnAction(actldel);
		b.getConsultar().setOnAction(actlcons);
		b.getGerar().setOnAction(actlger);
	}
	
	public void PressesMenu(Botoes b, Botoes bM, TextFields tf, Stage stage){
		
		EventHandler actlcad = new ButtonPressCad(b, bM, tf, this);
		EventHandler actlacess = new ButtonPressAcess(b,bM, tf);
		EventHandler actlexb = new ButtonPressExb(b, bM, tf, stage, this);
		EventHandler actlres = new ButtonPressRes(b,bM, tf);
		
		bM.getCadastrar().setOnAction(actlcad);
		bM.getAcessar().setOnAction(actlacess);
		bM.getListar().setOnAction(actlexb);
		bM.getResetar().setOnAction(actlres);
	}
	
	public int getTabSelected() {
		return tabSelected;
	}
	
	public void setTabSelected(int tabSelected) {
		this.tabSelected = tabSelected;
	}
	
	public int getCadastrando() {
		return Cadastrando;
	}
	
	public void setCadastrando(int cadastrando) {
		Cadastrando = cadastrando;
	}
	
	public int getAlterando() {
		return Alterando;
	}
	
	public void setAlterando(int alterando) {
		Alterando = alterando;
	}

	public static void main(String[] args)throws Exception{
		Application.launch();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}


	
}
