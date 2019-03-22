
package ThreadInteractions;


public class Bank {
    
    public static final int INITIAL_BALANCE = 10000;
    public static final int NACCOUNTS = 10;
    private final long [] accounts;
    private int nTransacts;
    
    public Bank(){
        
        accounts = new long[NACCOUNTS];
        
        for(int i = 0; i < NACCOUNTS; i++){
            accounts[i] = INITIAL_BALANCE;            
        }    
        nTransacts = 0;
        test();
    }
    
    public synchronized void Transfer(int from, int to, int amount){
        while(accounts[from] < amount){
            try {
                wait();
            }catch(InterruptedException e){}           
        }
        
        accounts[from] -= amount;
        accounts[to] += amount;
        nTransacts++;
        
        if(nTransacts % 50 == 0){
            test();
        }        
        notify();
    }
    
    private void test(){
        
        long sum = 0;
        
        for(int i = 0; i < NACCOUNTS; i++){
            sum += accounts[i];
        }
        System.out.println("Transactions: " + nTransacts + " Sum:" + sum);      
    }    
}
