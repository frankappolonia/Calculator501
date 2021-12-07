
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;


public class EventHandling {


    public static void addValueToCalc(TextField f, String s){
        f.appendText(s);
    }
       
    public static void eval2(TextField equation, TextField result){
        /** This method is an attempt at using the javascript built in
         * text parser. For some reason it deos not work
         */
        String eqTxt = equation.getText();
        String finalResult = EvaluateString.evaluateExpression(eqTxt);

        result.clear();
        result.appendText(eqTxt + " = ");
        result.appendText(finalResult);
        equation.clear();
}

    public static void clearCalc(TextField equation, TextField result){
        /** Clears all text fields */
        equation.clear();
        result.clear();
    }


}
 
    



    
    /***class CalculateHandlerClass implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
        }
        public void addValueToCalc(String s){
            equation.appendText(s);
        }
    }

    class ClearHandlerClass implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
        }
    
    } */
    

