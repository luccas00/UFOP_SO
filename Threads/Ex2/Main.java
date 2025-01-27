public class Main {

    public static void main(String[] args) {
        System.out.println("Hello There");

        Contador contador = new Contador();

        // Thread para incrementar
        Runnable incrementarTask = () -> {
            contador.incrementar();
            System.out.println("Valor após incrementar: " + contador.getValor());
        };

        // Thread para decrementar
        Runnable decrementarTask = () -> {
            contador.decrementar();
            System.out.println("Valor após decrementar: " + contador.getValor());
        };

        // Criando as threads
        Thread t1 = new Thread(incrementarTask);
        Thread t2 = new Thread(decrementarTask);

        // Iniciando as threads
        t1.start();
        t2.start();

        try {
            t1.join();  // Espera t1 terminar
            t2.join();  // Espera t2 terminar
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    
}
