import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.locks.Condition;

public class JantarFilosofos {
    
    enum Estado {
        PENSANDO, COMENDO, FAMINTO
    };

    Estado filosofos[] = new Estado[5];

    Condition condicao[] = new Condition[5];

    // Fila de inteiros para controlar a ordem de execução dos filósofos
    Queue<Integer> fila = new LinkedList<Integer>();

    public JantarFilosofos() {
        for (int i = 0; i < 5; i++) {
            filosofos[i] = Estado.PENSANDO;
        }
    }

    public void PegarHashi(int i) throws InterruptedException {
        filosofos[i] = Estado.FAMINTO;
        Testar(i);
        if (filosofos[i] != Estado.COMENDO) {
            condicao[i].await();

            if (!fila.contains(i))
                fila.add(i);
                
        }
    }

    public void LargarHashi(int i) {
        filosofos[i] = Estado.PENSANDO;
        Testar((i + 4) % 5);
        Testar((i + 1) % 5);
    }

    public void Testar(int i) {
        if (filosofos[i] == Estado.FAMINTO && filosofos[(i + 4) % 5] != Estado.COMENDO && filosofos[(i + 1) % 5] != Estado.COMENDO) {
            filosofos[i] = Estado.COMENDO;

            int aux = fila.poll();
            condicao[aux].signal();
        }
    }
}
