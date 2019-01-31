package butler_java3_lab2;

public class Butler_Java3_Lab2 {
    public static void main(String[] args) {
        Runnable ping = new PingPong("Ping");
        Runnable pong = new PingPong("Pong");
        
        Thread thread1 = new Thread(ping);
        Thread thread2 = new Thread(pong);
        
        thread1.start();
        thread2.start();
    }
    
}

class PingPong implements Runnable{
    private String threadPrint;
    
    public PingPong(String a){
        threadPrint = a;
    }
    
    @Override
    public void run(){
        try{
            for(int i = 0; i < 10; i++){
            System.out.print(threadPrint + " #" + (i + 1) + "\n");
            Thread.sleep(10);
             } 
        } catch (InterruptedException e){
            System.out.print("Thread " + threadPrint + " interrupted");
        }
        
    }
}
