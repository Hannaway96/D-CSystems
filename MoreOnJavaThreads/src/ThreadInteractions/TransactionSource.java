
package ThreadInteractions;
import java.util.*;

public class TransactionSource extends Thread{
    
    private final Bank bank;
    private final int from;
    private final Random rnd;    
    
    public TransactionSource(Bank b, int i){
        from = i;
        bank = b;
        rnd = new Random();
    }
    
    @Override
    public void run(){       
        while(true){
            int to = rnd.nextInt(Bank.NACCOUNTS);
            
            if(to == from){
                to = (to + 1) % Bank.NACCOUNTS;                                          
            }        
            
            int amount = rnd.nextInt(Bank.INITIAL_BALANCE / 4);
            bank.Transfer(from, to, amount);
            try{
                sleep(1);
            }catch(InterruptedException e){}
        }    
    }    
}
