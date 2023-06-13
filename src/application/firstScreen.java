package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class firstScreen extends Application {
	@Override
	public void start(Stage stage1) {
		
		Image img = new Image("E:\\study\\Eclipse projects\\OS_Lab_Project\\src\\images\\1.jpg");
		ImageView imgV = new ImageView();
		imgV.setImage(img);
		imgV.setFitWidth(800);
		imgV.setFitHeight(600);
		
		
		Text t1 = new Text();
        t1.setText("Welcome");
        t1.setLayoutX(300);
        t1.setLayoutY(80);
        t1.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 60));
        t1.setUnderline(true);
		
		Button b1 = new Button();
		b1.setText("First Come First Serve");
		b1.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
        b1.setLayoutX(160);
        b1.setLayoutY(170);
       
        
        b1.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent arg0) {
				FCFS fcfs = new FCFS();
				try {
					fcfs.start(stage1);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
        
		Button b2 = new Button();
		b2.setText("Shortest Job First");
		b2.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
        b2.setLayoutX(450);
        b2.setLayoutY(170);
       
        
        b2.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent arg0) {
				SJF sjf = new SJF();
				try {
					sjf.start(stage1);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
        
        
        Button b3 = new Button();
		b3.setText("Round Robin    (RR)  ");
		b3.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
        b3.setLayoutX(160);
        b3.setLayoutY(330);
       
        
        b3.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent arg0) {
				RoundRobin rr = new RoundRobin();
				try {
					rr.start(stage1);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
        
        
        Button b4 = new Button();
		b4.setText("Priority Non Premptive");
		b4.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
        b4.setLayoutX(450);
        b4.setLayoutY(330);
       
        
        b4.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent arg0) {
				PriorityNP priorityNP = new PriorityNP();
				try {
					priorityNP.start(stage1);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
        
        
        Button b5 = new Button();
		b5.setText("Priority Premptive");
		b5.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
        b5.setLayoutX(300);
        b5.setLayoutY(250);
       
        
        b5.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent arg0) {
				PriorityPremptive priorityPre = new PriorityPremptive();
				try {
					priorityPre.start(stage1);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
        
        
		
        Image imgStage = new Image("E:\\study\\Eclipse projects\\OS_Lab_Project\\src\\images\\icon.jpg");
		
		
		Group root = new Group(imgV,b1,b2,b3,b4,b5,t1);
        Scene scene = new Scene(root, 800, 600);
        stage1.setScene(scene);
        stage1.getIcons().add(imgStage);
        stage1.setResizable(false);
        stage1.setTitle("Schedulling Algorithms----->Welcome");
        stage1.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
