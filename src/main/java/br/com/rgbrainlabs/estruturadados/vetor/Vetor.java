package br.com.rgbrainlabs.estruturadados.vetor;

public class Vetor {

    private String[] elementos;
    private int tamanho;

    public Vetor(int capacidade) {
        this.elementos = new String[capacidade];
        this.tamanho = 0;
    }

    public void adicionar(String elemento) {
        if (this.tamanho < this.elementos.length) {
            this.elementos[this.tamanho] = elemento;
            this.tamanho++;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public int tamanho() {
        return this.tamanho;
    }

    @Override
    public String toString() {
        var s = new StringBuilder();
        s.append("[");
        for (int i = 0; i < this.tamanho -1; i++) {
            s.append(this.elementos[i] + ", ");
        }
        s.append(this.elementos[this.tamanho - 1] + "]");
        return s.toString();
    }
}
