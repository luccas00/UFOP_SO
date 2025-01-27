public class Contador {

    private int valor;

    public Contador() { valor = 0; }

    public void incrementar() {
        for (int i = 0; i < 100000; i++) {
            valor++;
        }
    }

    public void decrementar() {
        for (int i = 0; i < 100000; i++) {
            valor--;
        }
    }

    public int getValor() { return valor; }
    
}
