/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practical1;

public class EssentialMethods {
    public static void main (String args[]){
        greeter("Hello Methods.");
        greeter(waver(3));
    }
    
    public static void greeter(String greeting){
        repeater(greeting, 1);
    }
    
    public static String waver(int waves){
        repeater("WAVE", waves);
        return("Done waving");
    }
    
    public static void repeater (String line, int times){
        for(int i = 1; i <= times; i++){
            System.out.println(line);
        };
    }
}
