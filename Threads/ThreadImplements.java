public class ThreadImplements implements Runnable {
    
    String name;

    public ThreadImplements(String name) {
        this.name = name;    
    }
    
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(this.name + " " + i);
        }    
        
        System.out.println(this.name + " finished");
        
    }
}