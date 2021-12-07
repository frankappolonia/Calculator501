
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.input.KeyCode;

public class CalculatorUI extends Application{

    /** Button declarations */
    private TextField equation = new TextField();
    private TextField result = new TextField();

    private Button btCalculate = new Button("=");
    private Button btClear = new Button("Clr");
    private Button btDel = new Button("Del");
    private Button btLeftPar = new Button("(");
    private Button btRightPar = new Button(")");
    private Button btExponent = new Button("^");
    private Button btPoint = new Button(".");
    private Button btPlus = new Button("+");
    private Button btMinus = new Button("-");
    private Button btMult = new Button("X");
    private Button btDivide = new Button("/");

    private Button btOne = new Button("1");
    private Button btTwo = new Button("2");
    private Button btThree = new Button("3");
    private Button btFour = new Button("4");
    private Button btFive = new Button("5");
    private Button btSix = new Button("6");
    private Button btSeven = new Button("7");
    private Button btEight = new Button("8");
    private Button btNine = new Button("9");
    private Button btZero = new Button("0");


    @Override
    public void start(Stage primaryStage){

        GridPane gridPane = new GridPane();

        gridPane.setHgap(10);
        gridPane.setVgap(10);

        /** Button array thats used for setButtonAttributes
         * method below that styles the buttons */
        Button[] buttons = new Button[]{btOne, btTwo, btThree, btFour, btFive, btSix, btSeven, 
        btEight, btNine, btZero, btPoint, btPlus, btMinus, btMult, btDivide, btCalculate,
        btClear, btLeftPar, btRightPar, btExponent};
        
        setButtonAttributes(buttons);
        btDel.setMinSize(270, 10);

        // Makes the textfields uneditable, except for using buttons on GUI
        equation.setEditable(false);
        result.setEditable(false);

        /** Geometry Setup of buttons and textField objects in gridpane*/
        equation.setMinSize(275, 15);
        result.setMinSize(275, 15);

        gridPane.add(equation, 0, 0, 5, 1);
        gridPane.add(result, 0, 1, 5, 1);

                            //column, row
        gridPane.add(btExponent, 1, 3);
        gridPane.add(btLeftPar, 2, 3);
        gridPane.add(btRightPar, 3, 3);
        gridPane.add(btDivide, 4, 3);

        gridPane.add(btSeven, 1, 4);
        gridPane.add(btEight, 2, 4);
        gridPane.add(btNine, 3, 4);
        gridPane.add(btMult, 4, 4);

        gridPane.add(btFour, 1, 5);
        gridPane.add(btFive, 2, 5);
        gridPane.add(btSix, 3, 5);
        gridPane.add(btMinus, 4, 5);

        gridPane.add(btOne, 1, 6);
        gridPane.add(btTwo, 2, 6);
        gridPane.add(btThree, 3, 6);
        gridPane.add(btPlus, 4, 6);
        
        gridPane.add(btClear, 1, 7);
        gridPane.add(btZero, 2, 7);
        gridPane.add(btPoint, 3, 7);
        gridPane.add(btCalculate, 4, 7);

        gridPane.add(btDel, 1, 8, 5, 1);
   
        /**Methods attached to each button
         * - Add addValueToCalc adds the the second argument i.e. '9; 
         *      to the equation textField
        *  - eval() is the method that calculates the text in the equation textField
           - clearCalc() is the method that clears both textField objects     */
        btZero.setOnAction(event -> EventHandling.addValueToCalc(equation,"0"));
        btOne.setOnAction(event -> EventHandling.addValueToCalc(equation,"1"));
        btTwo.setOnAction(event -> EventHandling.addValueToCalc(equation,"2"));
        btThree.setOnAction(event -> EventHandling.addValueToCalc(equation,"3"));
        btFour.setOnAction(event -> EventHandling.addValueToCalc(equation,"4"));
        btFive.setOnAction(event -> EventHandling.addValueToCalc(equation,"5"));
        btSix.setOnAction(event -> EventHandling.addValueToCalc(equation,"6"));
        btSeven.setOnAction(event -> EventHandling.addValueToCalc(equation,"7"));
        btEight.setOnAction(event -> EventHandling.addValueToCalc(equation,"8"));
        btNine.setOnAction(event -> EventHandling.addValueToCalc(equation,"9"));

        btPlus.setOnAction(event -> EventHandling.addValueToCalc(equation, "+"));
        btMinus.setOnAction(event -> EventHandling.addValueToCalc(equation, "-"));
        btDivide.setOnAction(event -> EventHandling.addValueToCalc(equation, "/"));
        btMult.setOnAction(event -> EventHandling.addValueToCalc(equation,"*"));
        btLeftPar.setOnAction(event -> EventHandling.addValueToCalc(equation, "("));
        btRightPar.setOnAction(event -> EventHandling.addValueToCalc(equation, ")"));
        btPoint.setOnAction(event -> EventHandling.addValueToCalc(equation, "."));
        btExponent.setOnAction(event -> EventHandling.addValueToCalc(equation, "^"));
        btDel.setOnAction(event -> EventHandling.addValueToCalc(equation, ""));

        btCalculate.setOnAction(event -> EventHandling.eval2(equation, result));
        btClear.setOnAction(event -> EventHandling.clearCalc(equation, result));
        

        /** Event Handling for key presses - i.e. pressing key 9 adds key 9 to the 
         * equation textField
         */
        btZero.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.DIGIT0)) {
                btZero.fire();
            }
        });  

        btOne.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.DIGIT1)) {
                btOne.fire();
            }
        });  
        
        btTwo.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.DIGIT2)) {
                btTwo.fire();
            }
        });  
        
        btThree.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.DIGIT3)) {
                btThree.fire();
            }
        });  
        
        btFour.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.DIGIT4)) {
                btFour.fire();
            }
        });  
        
        btFive.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.DIGIT5)) {
                btFive.fire();
            }
        });  
        
        btSix.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.DIGIT6)) {
                btSix.fire();
            }
        });  
        
        btSeven.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.DIGIT7)) {
                btSeven.fire();
            }
        });

        btEight.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.DIGIT8)) {
                btEight.fire();
            }
        });
        btNine.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.DIGIT9)) {
                btNine.fire();
            }
        });
        btPlus.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.PLUS)) {
                btPlus.fire();
            }
        });
        btMinus.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.MINUS)) {
                btMinus.fire();
            }
        });
        btMult.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ASTERISK)) {
                btMult.fire();
            }
        });
        btDivide.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.SLASH)) {
                btDivide.fire();
            }
        });


        /** Stage setting for the GUI */
        Scene scene = new Scene(gridPane, 300, 470);
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.setResizable(false);
        primaryStage.show();
        
    }
    
    public void setButtonAttributes(Button[] buttonArray){
        /** This method sets the CSS attributes for each button by looping through
         * an array of all the buttons, and applying the styling to each button
         */
        for (Button button: buttonArray) {
            button.setMinSize(60, 60);
            button.setStyle("-fx-font-size:20");
        }     
    }

    public static void main(String[] args) {
        launch(args);
      }

    
}
