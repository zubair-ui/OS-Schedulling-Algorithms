package application;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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

public class RoundRobin extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage5) throws Exception {
		
		Image img = new Image("E:\\study\\Eclipse projects\\OS_Lab_Project\\src\\images\\1.jpg");
		ImageView imgV = new ImageView();
		imgV.setImage(img);
		imgV.setFitWidth(800);
		imgV.setFitHeight(600);
		imgV.setOpacity(0.7);
		
		Text t1 = new Text();
        t1.setText("Round Robin");
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
        	fs.start(stage5);
        });
        
       
        
        Label l1 = new Label("Burst Time:");
        l1.setFont(Font.font("Times New Roman", FontWeight.BOLD, 23));
        l1.setLayoutX(180);
        l1.setLayoutY(220);
        TextField tf1= new TextField();
        tf1.setLayoutX(320);
        tf1.setLayoutY(220);
        tf1.setPromptText("e.g 3,5,12,8");
        
        
        Label l2 = new Label("Time Slice:");
        l2.setFont(Font.font("Times New Roman", FontWeight.BOLD, 23));
        l2.setLayoutX(180);
        l2.setLayoutY(280);
        TextField tf2= new TextField();
        tf2.setLayoutX(320);
        tf2.setLayoutY(280);
        tf2.setPromptText("e.g 3");
        
        
        Button b2 = new Button();
		b2.setText("Calculate");
		b2.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
        b2.setLayoutX(330);
        b2.setLayoutY(350);
        
        b2.setOnAction (e ->{
        	String bt =tf1.getText();
        	String ts =tf2.getText();
        	
        	String sBT[]=bt.split(",");
        	String temp=ts;
        	if(ts!="" && bt!="") {
            	for(int i=0;i<sBT.length;i++) {
            		temp+=sBT[i];
            	}
            	if(temp.matches("\\d++")) {
            			int BT[]=new int[sBT.length];
            			for(int i=0;i<sBT.length;i++) {
            				BT[i]=Integer.parseInt(sBT[i]);
            			}
            			
            			int TS=Integer.parseInt(ts);
            			
            			if(TS<1) {
            				Alert a = new Alert(Alert.AlertType.ERROR);
                            a.setContentText("Time Slice cannot be less than 1");
                            a.setHeaderText(null);
                            a.showAndWait();
            			}
            			
            			
            			connection con = new connection();
            			con.RR(BT, TS);
            			
            			Result result = new Result();
            			result.setText("Round Robin","RR");
            			try {
							result.start(stage5);
						} catch (Exception e1) {
							e1.printStackTrace();
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
        stage5.setScene(scene);
        stage5.getIcons().add(imgStage);
        stage5.setResizable(false);
        stage5.setTitle("Schedulling Algorithms----->RR");
        stage5.show();
	}

}
