package application;

import java.io.BufferedReader;
import java.io.FileReader;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Result extends Application{
	
	private String text1,text2;
	
	public void setText(String text1,String text2) {
		this.text1=text1;
		this.text2=text2;
	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage6) throws Exception {
		
		Image img = new Image("E:\\study\\Eclipse projects\\OS_Lab_Project\\src\\images\\1.jpg");
		ImageView imgV = new ImageView();
		imgV.setImage(img);
		imgV.setFitWidth(800);
		imgV.setFitHeight(600);
		imgV.setOpacity(0.6);
		
		Text t1 = new Text();
        t1.setText(text1);
        t1.setLayoutX(200);
        t1.setLayoutY(80);
        t1.setFill(Color.BLACK);
        t1.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 50));
        t1.setUnderline(true);
		
		TextArea textArea = new TextArea();
        String filePath = "E:\\study\\Eclipse projects\\OS_Lab_Project\\OS_Lab.txt";
        StringBuilder contents = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                contents.append(line).append("\n");
            }
        }
        
        textArea.setText(contents.toString());
        textArea.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
        textArea.setMaxWidth(600);
        textArea.setMaxHeight(400);
        textArea.setMinWidth(600);
        textArea.setMinHeight(400);
        textArea.setLayoutX(100);
        textArea.setLayoutY(100);
        textArea.setEditable(false);
        
        Button b = new Button();
        b.setText("Back");
        b.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
        b.setLayoutX(30);
        b.setLayoutY(30);
        
        b.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent arg0) {
				firstScreen fs= new firstScreen();
				try {
					fs.start(stage6);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
		Image imgStage = new Image("E:\\study\\Eclipse projects\\OS_Lab_Project\\src\\images\\icon.jpg");

        
		Group root = new Group(imgV,textArea,b,t1);
        Scene scene = new Scene(root, 800, 600);
        stage6.setScene(scene);
        stage6.getIcons().add(imgStage);
        stage6.setResizable(false);
        stage6.setTitle("Schedulling Algorithms----->"+text2+"----->Result");
        stage6.show();
	}

}
