public class Main {
    
    public static void main(String[] args) {
        
        System.out.println("Hello, World!");

        // ThreadExtends t1 = new ThreadExtends("Thread 1");
        // ThreadExtends t2 = new ThreadExtends("Thread 2");
        // ThreadExtends t3 = new ThreadExtends("Thread 3");

        // t1.start();
        // t2.start();

        // try {
        //     t1.join();
        //     t2.join();
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }

        // t3.start();

        // System.out.println("Main finished");

        ThreadExtends t1 = new ThreadExtends("Thread 1");
        ThreadExtends t2 = new ThreadExtends("Thread 2");

        int[] vetor = MeuVetor.getVetor();
        int[] vetor1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // Imprime o vetor em uma unica linha
        for (int i = 0; i < vetor1.length; i++) {
            System.out.print(vetor1[i] + " ");
        }

        System.out.println();

        // Passar o vetor para cada thread
        t1.setVetor(vetor1);
        t2.setVetor(vetor1);

        // Iniciar t1 e t2
        t1.start();
        t2.start();

        try {
            // Aguardar as threads terminarem
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Soma total
        int totalSum = t1.getSomaParcial() + t2.getSomaParcial();
        System.out.println("Soma Total: " + totalSum);

        System.out.println("Main finished");
    
    }

}