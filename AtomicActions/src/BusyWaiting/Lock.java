
package BusyWaiting;
class Lock{
        private boolean value;
        /*
            The Methods in Lock are set to
            Synchronized so that they are performed Atomically
        */
        Lock(){
            value = false;
        }
        
        public synchronized boolean Tset(){
            boolean setting;          
            setting = value;
            value = true;
            return setting;
        } 
        
        public synchronized void free(){
            value = false;
        }
    }