public class Main {
    
    public static void main(String[] args) {
        
        int[] vetor1 = {2 ,8 , 10, 20};
        int[] vetor2 = {2 ,8 , 10, 20, 60};
        
        Aritmetica aritmetica = new Aritmetica();

        // Thread para incrementar
        Runnable mediaTask1 = () -> {
            System.out.println("Média Vetor 1: " + aritmetica.media(vetor1));
        };

        Runnable mediaTask2 = () -> {
            System.out.println("Média Vetor 2: " + aritmetica.media(vetor2));
        };

        Runnable medianaTask1 = () -> {
            System.out.println("Mediana Vetor 1: " + aritmetica.mediana(vetor1));
        };

        Runnable medianaTask2 = () -> {
            System.out.println("Mediana Vetor 2: " + aritmetica.mediana(vetor2));
        };

        // Criando as threads
        Thread t1 = new Thread(mediaTask1);
        Thread t2 = new Thread(mediaTask2);
        Thread t3 = new Thread(medianaTask1);
        Thread t4 = new Thread(medianaTask2);
        
        // Iniciando as threads
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    
        try {
            t1.join();  // Espera t1 terminar
            t2.join();  // Espera t2 terminar
            t3.join();  // Espera t3 terminar
            t4.join();  // Espera t4 terminar
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


