package application;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FCFS extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage2) throws Exception {
		
		Image img = new Image("E:\\study\\Eclipse projects\\OS_Lab_Project\\src\\images\\1.jpg");
		ImageView imgV = new ImageView();
		imgV.setImage(img);
		imgV.setFitWidth(800);
		imgV.setFitHeight(600);
		imgV.setOpacity(0.7);
		
		Text t1 = new Text();
        t1.setText("First Come First Serve");
        t1.setLayoutX(210);
        t1.setLayoutY(100);
        t1.setFill(Color.BLACK);
        t1.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 50));
        t1.setUnderline(true);
		
		Button b1 = new Button();
		b1.setText("Back");
		b1.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
        b1.setLayoutX(30);
        b1.setLayoutY(30);
        
        b1.setOnAction (e ->{
        	firstScreen fs = new firstScreen();
        	fs.start(stage2);
        });
        
       
        
        Label l1 = new Label("Arrival Time:");
        l1.setFont(Font.font("Times New Roman", FontWeight.BOLD, 23));
        l1.setLayoutX(180);
        l1.setLayoutY(220);
        TextField tf1= new TextField();
        tf1.setLayoutX(320);
        tf1.setLayoutY(220);
        tf1.setPromptText("e.g 3,5,12,8");
        
        
        Label l2 = new Label("Burst Time:");
        l2.setFont(Font.font("Times New Roman", FontWeight.BOLD, 23));
        l2.setLayoutX(180);
        l2.setLayoutY(280);
        TextField tf2= new TextField();
        tf2.setLayoutX(320);
        tf2.setLayoutY(280);
        tf2.setPromptText("e.g 3,5,12,8");
        
        
        Button b2 = new Button();
		b2.setText("Calculate");
		b2.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
        b2.setLayoutX(330);
        b2.setLayoutY(350);
        
        b2.setOnAction (e ->{
        	String at =tf1.getText();
        	String bt =tf2.getText();
        	
        	String sAT[]=at.split(",");
        	String sBT[]=bt.split(",");
        	String temp="";
        	if(at!="" && bt!="") {
            	for(int i=0;i<sAT.length;i++) {
            		temp+=sAT[i];
            	}
            	for(int i=0;i<sBT.length;i++) {
            		temp+=sBT[i];
            	}
            	if(temp.matches("\\d++")) {
            		if(sAT.length!=sBT.length) {
            			Alert a = new Alert(Alert.AlertType.ERROR);
                        a.setContentText("The Lengths do not match");
                        a.setHeaderText(null);
                        a.showAndWait();
            		}
            		else {
            			int AT[]=new int[sAT.length],
            					BT[]=new int[sBT.length];
            			for(int i=0;i<sAT.length;i++) {
            				AT[i]=Integer.parseInt(sAT[i]);
            				BT[i]=Integer.parseInt(sBT[i]);
            			}
            			
            			for(int i=0;i<sAT.length;i++) {
            				for(int j=0;j<sAT.length-1;j++) {
                				if(AT[j]>AT[j+1]) {
                					int tempo=AT[j];
                					AT[j]=AT[j+1];
                					AT[j+1]=tempo;
                					
                					tempo=BT[j];
                					BT[j]=BT[j+1];
                					BT[j+1]=tempo;
                				}
                			}
            			}
            			
            			
            			
            			connection con = new connection();
            			con.FCFS(AT, BT);
            			
            			Result result = new Result();
            			result.setText("First Come First Serve","FCFS");
            			try {
							result.start(stage2);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
            		}
            	}
            	else {
            		Alert a = new Alert(Alert.AlertType.ERROR);
                    a.setContentText("Please Enter Integer Values");
                    a.setHeaderText(null);
                    a.showAndWait();
            	}
        	
        	}
        	else {
        		Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("Empty");
                a.setHeaderText(null);
                a.showAndWait();
        	}
        });
		
		Image imgStage = new Image("E:\\study\\Eclipse projects\\OS_Lab_Project\\src\\images\\icon.jpg");

        
		Group root = new Group(imgV,t1,b1,b2,tf1,tf2,l1,l2);
        Scene scene = new Scene(root, 800, 600);
        stage2.setScene(scene);
        stage2.getIcons().add(imgStage);
        stage2.setResizable(false);
        stage2.setTitle("Schedulling Algorithms----->FCFS");
        stage2.show();
	}

}
