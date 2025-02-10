public class ThreadExtends extends Thread {
    
    String name;
    int[] vetor;
    int somaParcial;

    public ThreadExtends(String name) {
        this.name = name;    
    }
    
    public void run() {

        if ("Thread 1".equals(this.name)) {
            somaParcial = getSumStart(vetor);
        } else if ("Thread 2".equals(this.name)) {
            somaParcial = getSumEnd(vetor);
        }
        System.out.println(this.name + " Soma Parcial: " + somaParcial);
        
    }
    
    public void setVetor(int[] vetor) {
        this.vetor = vetor;
    }

    public int getSumStart(int[] vetor) {
        int sum = 0;
        for (int i = 0; i < vetor.length/2; i++) {
            System.out.println(this.name + " - " + i);
            sum += vetor[i];
        }
        return sum;
    }

    public int getSumEnd(int[] vetor) {
        int sum = 0;
        for (int i = vetor.length/2; i < vetor.length; i++) {
            System.out.println(this.name + " - " + i);
            sum += vetor[i];
        }
        return sum;
    }

    public int getSomaParcial() {
        return somaParcial;
    }

}