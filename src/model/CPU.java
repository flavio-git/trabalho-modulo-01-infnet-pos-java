package model;

public class CPU extends Produto {
    private int numeroNucleos;
    private int numeroThreads;

    public CPU(String nome, float preco, int codigo, int numeroNucleos, int numeroThreads) {
        super(nome, preco, codigo);
        this.numeroNucleos = numeroNucleos;
        this.numeroThreads = numeroThreads;
        calculaImposto();
    }

    public int getNumeroNucleos() {
        return numeroNucleos;
    }

    public int getNumeroThreads() {
        return numeroThreads;
    }

    @Override
    public void calculaImposto() {
        this.setImposto(super.getPreco() * 0.20);
    }

    @Override
    public String toString() {
        return "CPU{" +
                "nome='" + super.getNome() + '\'' +
                ", preco=" + super.getPreco() +
                ", codigo=" + super.getCodigo() +
                ", nucleos=" + numeroNucleos +
                ", threads=" + numeroThreads +
                ", imposto=" + super.getImposto() +
                '}';
    }
}
