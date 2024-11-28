package estruturaDeDados;

public class Lista {
    private int[] elementos;
    private int tamanho;

    public Lista() {
        this.elementos = new int[10];
        this.tamanho = 0;
    }

    public void insereInicio(int valor) {
        if (tamanho == elementos.length) {
            throw new RuntimeException("A lista está cheia.");
        }
        for (int i = tamanho; i > 0; i--) {
            elementos[i] = elementos[i - 1];
        }
        elementos[0] = valor;
        tamanho++;
    }

    public boolean buscaElemento(int valor) {
        for (int i = 0; i < tamanho; i++) {
            if (elementos[i] == valor) {
                return true;
            }
        }
        return false;
    }

    public int buscaIndice(int indice) {
        if (indice < 0 || indice >= tamanho) {
            throw new IndexOutOfBoundsException("Índice inválido: " + indice);
        }
        return elementos[indice];
    }

    public void insereFim(int valor) {
        if (tamanho == elementos.length) {
            throw new RuntimeException("A lista está cheia.");
        }
        elementos[tamanho] = valor;
        tamanho++;
    }

    public void removeInicio() {
        if (tamanho == 0) {
            return;
        }
        for (int i = 0; i < tamanho - 1; i++) {
            elementos[i] = elementos[i + 1];
        }
        elementos[tamanho - 1] = 0;
        tamanho--;
    }

    public void removeFim() {
        if (tamanho == 0) {
            return;
        }
        elementos[tamanho - 1] = 0;
        tamanho--; 
    }



    public void removeIndice(int indice) {
        if (indice < 0 || indice >= tamanho) {
            throw new RuntimeException("O índice deve ser entre 0 e " + (tamanho - 1));
        }
        for (int i = indice; i < tamanho - 1; i++) {
            elementos[i] = elementos[i + 1];
        }
        elementos[tamanho - 1] = 0;
        tamanho--;
    }

    public void insereElementoPosicao(int valor, int indice) {
        if (tamanho == elementos.length) {
            throw new RuntimeException("A lista está cheia.");
        }
        if (indice < 0 || indice > tamanho) {
            throw new RuntimeException("O índice deve ser entre 0 e " + tamanho);
        }
        for (int i = tamanho; i > indice; i--) {
            elementos[i] = elementos[i - 1];
        }
        elementos[indice] = valor;
        tamanho++;
    }
}
