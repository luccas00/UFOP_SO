public class MeuVetor {

    public static int[] getVetor() {
        int[] vetor = new int[10];
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = (int) (Math.random() * 100);
        }
        return vetor;
    }
    
}
