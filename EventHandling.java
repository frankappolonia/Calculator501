
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;


public class EventHandling {


    public static void addValueToCalc(TextField f, String s){
        f.appendText(s);
    }


    /**public static void calculateTotal(String final){
        CalculatorUI.result.appendText(final);
        
      
    } */
       
    public static void eval2(TextField equation, TextField result){
        /** This method is an attempt at using the javascript built in
         * text parser. For some reason it deos not work
         */
        String s;
        String eqTxt = equation.getText();
     
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");

        try{
      
        
        s = engine.eval(eqTxt).toString();
        System.out.print(s);
        result.appendText(s);
       
    }
    catch (ScriptException ex) {
        Exception e = new Exception(ex);
        System.out.print(e);
        result.appendText("Invalid");
    }
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
    

