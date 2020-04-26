package logic;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.layout.GridPane;

public class Main extends Application{
		
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage stage) {
        stage.setTitle("Calculator");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Button add = new Button("+");
        grid.add(add, 2, 0);
        
        Text operator = new Text("");
        add.setOnAction(new EventHandler<ActionEvent>() {
        	 
            @Override
            public void handle(ActionEvent e) {
            	operator.setText("+");
            }
        });
        
        Button subtract = new Button("-");
        grid.add(subtract, 2, 1);
        subtract.setOnAction(new EventHandler<ActionEvent>() {
       	 
            @Override
            public void handle(ActionEvent e) {
            	operator.setText("-");
            }
        });
        
        Button multiply = new Button("x");
        grid.add(multiply, 2, 2);
        multiply.setOnAction(new EventHandler<ActionEvent>() {
          	 
            @Override
            public void handle(ActionEvent e) {
            	operator.setText("*");
            }
        });
        
        Button divide = new Button("/");
        grid.add(divide, 2, 3);
        divide.setOnAction(new EventHandler<ActionEvent>() {
         	 
            @Override
            public void handle(ActionEvent e) {
            	operator.setText("/");
            }
        });
        
        Label firstNumberLbl = new Label("First Number:");
        grid.add(firstNumberLbl, 1, 1);

        TextField firstNumber = new TextField();
        grid.add(firstNumber, 1, 2);
        
        Label secondNumberLbl = new Label("Second Number:");
        grid.add(secondNumberLbl, 3, 1);

        TextField secondNumber = new TextField();
        grid.add(secondNumber, 3, 2);
        
        Label answerLbl = new Label("Result:");
        grid.add(answerLbl, 5, 1);

        TextField answer = new TextField();
        grid.add(answer, 5, 2);
        
        Button equals = new Button("=");
        grid.add(equals, 4, 2);
        equals.setOnAction(new EventHandler<ActionEvent>() {
        	 
            @Override
            public void handle(ActionEvent e) {
            	if(firstNumber.getText().equals("") || secondNumber.getText().equals("")) {
            		answer.setText("enter both numbers");
            	}
            	else if(operator.getText().equals("+")) {
            		Double num1 = Double.parseDouble(firstNumber.getText());
            		Double num2 = Double.parseDouble(secondNumber.getText());
            		Double res = num1+num2;
            		
            		answer.setText(res.toString());
            	}
            	else if(operator.getText().equals("-")) {
            		Double num1 = Double.parseDouble(firstNumber.getText());
            		Double num2 = Double.parseDouble(secondNumber.getText());
            		Double res = num1-num2;
            		answer.setText(res.toString());
            	}
            	else if(operator.getText().equals("*")) {
            		Double num1 = Double.parseDouble(firstNumber.getText());
            		Double num2 = Double.parseDouble(secondNumber.getText());
            		Double res = num1*num2;
            		answer.setText(res.toString());
            	}
            	else if(operator.getText().equals("/")) {
            		Double num2 = Double.parseDouble(secondNumber.getText());
            		if(num2 == 0) {
                		answer.setText("divide by 0 error");
            		}
            		else {
                		Double num1 = Double.parseDouble(firstNumber.getText());
                		Double res = num1/num2;
                		answer.setText(res.toString());	
            		}
            	}
            }
        });
        
        Button savePrev = new Button("Ans");
        grid.add(savePrev, 1, 3);
        savePrev.setOnAction(new EventHandler<ActionEvent>() {
         	 
            @Override
            public void handle(ActionEvent e) {
            	if(!firstNumber.getText().equals("")) {
            		firstNumber.setText(answer.getText());
            	}
            }
        });

        stage.show();
        
        Scene scene = new Scene(grid, 600, 300);
        stage.setScene(scene);
        
        stage.show();
	}
}
