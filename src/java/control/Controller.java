package control;
import java.util.HashMap;

public class Controller {
//	public static HashMap<String, doMath> key = new HashMap <String, doMath>();
	
	public void Controller(){
		
	}
	//Hmm I'll have to set this up to accept at least a require instruction (button)
        //Then I'll need to have any possibility that will exist as optional parameters
        //I wonder whether there is a generic Object type that could cover it.  Then
        //based on what was passed in (according to the button requirements) I can cast the objects as their types.
	public static void handleOperator(String operator, Integer input1, Integer input2){
            //Planned maps based on button clicked/cmd sent
            //Authenticate, Add to Cart, Make Purchase, View Purchase History
//		key.put("+", new Addition());
//		key.put("-", new Subtraction());
//		key.put("/", new Division());
//		key.put("*", new Multiplication());
		
//		doMath handler = key.get(operator);
//		handler.execute(input1, input2);
	}
}
