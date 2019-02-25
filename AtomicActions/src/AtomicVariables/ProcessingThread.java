
package AtomicVariables;


public class ProcessingThread implements Runnable{
    
    private int count;
    
    @Override
    public void run(){       
        for(int i=1; i<5; i++){
           processSomething(i);
           count++;
        }       
    }
    
    public int getCount(){
        return this.count;
    }
    
    public void processSomething(int i){
        //processing job
        try{
            Thread.sleep(i * 100);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
