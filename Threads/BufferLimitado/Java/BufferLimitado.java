import java.util.concurrent.Semaphore;

public class BufferLimitado {

    Object buffer[];
    int tam;
    int in, out, cont;

    /*
        mutex é um semáforo binário que garante acesso exclusivo à seção crítica.
        cheio é um semáforo que conta o número de itens disponíveis no buffer.
        vazio é um semáforo que conta o número de espaços disponíveis no buffer.
    */

    private final Semaphore mutex = new Semaphore(1); 
    private final Semaphore cheio = new Semaphore(0);
    private final Semaphore vazio;

    public BufferLimitado(int tam) {
        this.tam = tam;
        buffer = new Object[tam];
        in = out = cont = 0;
        vazio = new Semaphore(tam);
    }

    public void Insere2(Object item) throws InterruptedException {
        vazio.acquire(); // Decrementa o número de espaços disponíveis
        mutex.acquire();  // Entra na seção crítica

        buffer[in] = item;
        in = (in + 1) % tam;
        cont++;

        mutex.release();  // Sai da seção crítica
        cheio.release();  // Incrementa o número de itens disponíveis
    }

    public Object Retira2() throws InterruptedException {
        cheio.acquire(); // Decrementa o número de itens disponíveis
        mutex.acquire(); // Entra na seção crítica

        Object item = buffer[out];
        out = (out + 1) % tam;
        cont--;

        mutex.release(); // Sai da seção crítica
        vazio.release(); // Incrementa o número de espaços disponíveis
        return item;
    }

    // public void Insere(Object item) {
    //     while (cont == tam);
        
    //     // {
    //     //     try {
    //     //         wait();
    //     //     } catch (InterruptedException e) {
    //     //     }
    //     // }
        
    //     buffer[in] = item;
    //     in = (in + 1) % tam;
    //     cont++;
    //     //notifyAll();
    // }

    // public Object Retira() {
    //     Object item;
    //     while (cont == 0);
        
    //     // {
    //     //     try {
    //     //         wait();
    //     //     } catch (InterruptedException e) {
    //     //     }
    //     // }
        
    //     item = buffer[out];
    //     out = (out + 1) % tam;
    //     cont--;
    //     //notifyAll();
    //     return item;
    // }

}