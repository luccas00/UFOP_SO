public class Aritmetica {

    public Aritmetica() { }

    public static int soma(int[] vetor) {
        int soma = 0;
        for (int i = 0; i < vetor.length; i++) {
            soma += vetor[i];
        }
        return soma;
    }

    public static int media(int[] vetor) {
        return soma(vetor) / vetor.length;
    }

    public static int mediana(int[] vetor) {
        int n = vetor.length;
        int mediana = 0;
        if (n % 2 == 0) {
            mediana = (vetor[n / 2 - 1] + vetor[n / 2]) / 2;
        } else {
            mediana = vetor[n / 2];
        }
        return mediana;
    }
    
}
