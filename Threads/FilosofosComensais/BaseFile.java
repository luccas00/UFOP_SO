import java.util.concurrent.Semaphore;

public class BaseFile {

    //Variavel Compartilhada
    public static Semaphore hashi[] = new Semaphore[5];

    public static void main(String[] args) throws InterruptedException {

        boolean flag = true;

        for (int i = 0; i < 5; i++) {
            hashi[i] = new Semaphore(1);
        }

        while (flag) {

            for (int i = 0; i < 5; i++) {
                
                Penso();
                hashi[i].acquire();
                hashi[(i + 1) % 5].acquire();
                Comendo();
                hashi[i].release();
                hashi[(i + 1) % 5].release();

            }
        }

        while (flag) {

            for (int i = 0; i < 5; i++) {
                
                if (i % 2 == 0)
                {
                    Penso();
                    hashi[i].acquire();
                    hashi[(i + 1) % 5].acquire();
                    Comendo();
                    hashi[i].release();
                    hashi[(i + 1) % 5].release();
                }
                else
                {
                    Penso();
                    hashi[(i + 1) % 5].acquire();
                    hashi[i].acquire();
                    Comendo();
                    hashi[(i + 1) % 5].release();
                    hashi[i].release();
                }
            }
        }
    }

    public static void Penso() {
        System.out.println("Filosofo pensando");
    }

    public static void Comendo() {
        System.out.println("Filosofo comendo");
    }
}