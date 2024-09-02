
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Taschenrechner extends Application {
	
	private Label resultLabel;
	private TextField num1Field, num2Field, activeField;
	private Button addButton, subtractButton, multiplyButton, divideButton, squareButton, sqrtButton;

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		//Hier werde ich die Benutzeroberfläche des Taschenrechners programmieren
		
		primaryStage.setTitle("Basic Calculator");
		
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(10, 10, 10, 10));
		
		
		
		addButton = new Button(" Add ");
		addButton.setOnAction(event -> performOperation("+"));
		grid.setConstraints(addButton, 1, 0);
		
		subtractButton = new Button(" Subtract ");
		subtractButton.setOnAction(event -> performOperation("-"));
		grid.setConstraints(subtractButton, 2, 0);
		
		multiplyButton = new Button(" Multiply ");
		multiplyButton.setOnAction(event -> performOperation("•"));
		grid.setConstraints(multiplyButton, 1, 1);
		
		divideButton = new Button(" Divide ");
		divideButton.setOnAction(event -> performOperation("÷"));
		grid.setConstraints(divideButton, 2, 1);
		
		squareButton = new Button(" Square ");
		squareButton.setOnAction(event -> performSquareOrSqrt("ˆ"));
		grid.setConstraints(squareButton, 1, 2);
		
		sqrtButton = new Button(" SquareRoot ");
		sqrtButton.setOnAction(event -> performSquareOrSqrt("√"));
		grid.setConstraints(sqrtButton, 2, 2);
		
		resultLabel = new Label("Result");
		grid.setConstraints(resultLabel, 0, 2);
		
		num1Field = new TextField();
		num1Field.setPromptText("Enter first number");
		grid.setConstraints(num1Field, 0, 0);
		num1Field.addEventFilter(MouseEvent.MOUSE_CLICKED, event -> setActiveField(num1Field));
		
		num2Field = new TextField();
		num2Field.setPromptText("Enter second number");
		grid.setConstraints(num2Field, 0, 1);
		
		grid.getChildren().addAll(num1Field, num2Field, resultLabel, addButton, subtractButton, multiplyButton, divideButton, squareButton, sqrtButton);
		
		
		
		Scene scene = new Scene(grid, 300, 200);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	private void performOperation(String operator) {
		String num1Text = num1Field.getText();
		String num2Text = num2Field.getText();
		
		if(isValidNumber(num1Text) && isValidNumber(num2Text)) {
			double num1 = Double.parseDouble(num1Text);
			double num2 = Double.parseDouble(num2Text);
			double result = 0.0;
			
			switch(operator) {
			case "+":
				result = num1 + num2;
				break;
			case "-":
				result = num1 - num2;
				break;
			case "•":
				result = num1 * num2;
				break;
			case "÷":
				if(num2 != 0) {
					result = num1 / num2;
				} else {
					resultLabel.setText("Es kann nicht durch 0 geteilt werden");
					return;
				}
				break;
			
			default:
				resultLabel.setText("Ungültige Eingabe eines Operators");
				break;
				
			}
			
			resultLabel.setText("Result: " + result);
		} else {
			resultLabel.setText("Result: Ungültiger Input");
		}
	}
	
	private void performSquareOrSqrt(String operator) {
		if(activeField == null) {
			if(!num1Field.getText().isEmpty() && num2Field.getText().isEmpty()) {
				activeField = num1Field;
			} else if(num1Field.getText().isEmpty() && !num2Field.getText().isEmpty()) {
				activeField = num2Field;
			} else {
				resultLabel.setText("Bitte wähle eines der Felder aus");
				return;
			}
			
		}
		
		String activeText = activeField.getText();
		if(isValidNumber(activeText)) {
			double number = Double.parseDouble(activeText);
			double result = 0.0;
			
			switch(operator) {
			
			case "ˆ":
				result = Math.pow(number, 2);
				break;
			case "√":
				if(number >= 0) {
					result = Math.sqrt(number);
				} else {
					resultLabel.setText("Ungültige Eingabe der QuadratWurzel");
					return;
				}
				break;
			
			}
			resultLabel.setText("Result: " + result);
		} else {
			resultLabel.setText("Ungültige Ungültiger Input");
		}
	}
	
	private void setActiveField(TextField field) {
		this.activeField= field;
	}
	
	private boolean isValidNumber(String text) {
		return text.matches("-?\\d*\\.?\\d+");
	}
	
	

	public static void main(String[] args) {
		launch(args);
	}
	

}
