package application;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PriorityNP extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage3) throws Exception {
		Image img = new Image("E:\\study\\Eclipse projects\\OS_Lab_Project\\src\\images\\1.jpg");
		ImageView imgV = new ImageView();
		imgV.setImage(img);
		imgV.setFitWidth(800);
		imgV.setFitHeight(600);
		imgV.setOpacity(0.7);
		
		Text t1 = new Text();
        t1.setText("Priority Non Premptive");
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
        	fs.start(stage3);
        });
        
       
        
        Label l1 = new Label("Priority:");
        l1.setFont(Font.font("Times New Roman", FontWeight.BOLD, 23));
        l1.setLayoutX(160);
        l1.setLayoutY(300);
        TextField tf1= new TextField();
        tf1.setLayoutX(310);
        tf1.setLayoutY(300);
        tf1.setPromptText("e.g 1,2,3,4");
        
        
        Label l2 = new Label("Burst Time:");
        l2.setFont(Font.font("Times New Roman", FontWeight.BOLD, 23));
        l2.setLayoutX(160);
        l2.setLayoutY(250);
        TextField tf2= new TextField();
        tf2.setLayoutX(310);
        tf2.setLayoutY(250);
        tf2.setPromptText("e.g 3,5,12,8");
        
        
        
        Label l3 = new Label("Priority Level:");
        l3.setFont(Font.font("Times New Roman", FontWeight.BOLD, 23));
        l3.setLayoutX(160);
        l3.setLayoutY(350);
        ComboBox cb=new ComboBox();
		cb.getItems().addAll("Lower Number = Lower Priority","Lower Number = Higher Priority");
		cb.setPromptText("Select");
		cb.setLayoutX(310);
		cb.setLayoutY(350);
		
		
		Label l4 = new Label("Arrival Time:");
        l4.setFont(Font.font("Times New Roman", FontWeight.BOLD, 23));
        l4.setLayoutX(160);
        l4.setLayoutY(200);
        TextField tf3= new TextField();
        tf3.setLayoutX(310);
        tf3.setLayoutY(200);
        tf3.setPromptText("e.g 3,5,12,8");
        
        
        Button b2 = new Button();
		b2.setText("Calculate");
		b2.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
        b2.setLayoutX(330);
        b2.setLayoutY(400);
        
        b2.setOnAction (e ->{
        	String priority =tf1.getText();
        	String bt =tf2.getText();
        	String pLevel=(String) cb.getSelectionModel().getSelectedItem();
        	String at=tf3.getText();
        	
        	String sPriority[]=priority.split(",");
        	String sBT[]=bt.split(",");
        	String sAT[]=at.split(",");
        	String temp="";
        	if(priority!="" && bt!="" && at!="" && pLevel!=null) {
            	for(int i=0;i<sAT.length;i++) {
            		temp+=sAT[i];
            	}
            	for(int i=0;i<sBT.length;i++) {
            		temp+=sBT[i];
            	}
            	for(int i=0;i<sPriority.length;i++) {
            		temp+=sPriority[i];
            	}
            	if(temp.matches("\\d++")) {
            		if(sPriority.length!=sBT.length && sBT.length!=sAT.length) {
            			Alert a = new Alert(Alert.AlertType.ERROR);
                        a.setContentText("The Lengths do not match");
                        a.setHeaderText(null);
                        a.showAndWait();
            		}
            		else {
            			int Priority[]=new int[sPriority.length],
            					BT[]=new int[sBT.length],
            					AT[]=new int[sAT.length],
            					processNumber[]=new int [sBT.length];
            			for(int i=0;i<sBT.length;i++) {
            				Priority[i]=Integer.parseInt(sPriority[i]);
            				AT[i]=Integer.parseInt(sAT[i]);
            				BT[i]=Integer.parseInt(sBT[i]);
            				processNumber[i]=i+1;
            			}
            			
            			for(int i=0;i<sBT.length;i++) {
                			for(int j=0;j<sBT.length-1;j++) {
                    			if(AT[j]>AT[j+1] || (AT[j]==AT[j+1] && Priority[j]>Priority[j+1])) {
                    				int tempo=Priority[j];
                    				Priority[j]=Priority[j+1];
                    				Priority[j+1]=tempo;
                    				
                    				tempo=AT[j];
                    				AT[j]=AT[j+1];
                    				AT[j+1]=tempo;
                    					
                    				tempo=BT[j];
                    				BT[j]=BT[j+1];
                    				BT[j+1]=tempo;
                    				
                    				tempo = processNumber[j];
                    				processNumber[j] = processNumber[j+1];
                    				processNumber[j+1] = tempo;
                    			}
                    		}
                		}
            				
            			
            			
            			connection con = new connection();
            			con.PriorityNP(AT,BT, processNumber, Priority,pLevel);
            			
            			Result result = new Result();
            			result.setText("Priority Non Premptive","Priority Schedulling");
            			try {
							result.start(stage3);
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

        
		Group root = new Group(imgV,t1,b1,b2,tf1,tf2,l1,l2,l3,cb,l4,tf3);
        Scene scene = new Scene(root, 800, 600);
        stage3.setScene(scene);
        stage3.getIcons().add(imgStage);
        stage3.setResizable(false);
        stage3.setTitle("Schedulling Algorithms----->Priority Non Premptive");
        stage3.show();
	}

}
