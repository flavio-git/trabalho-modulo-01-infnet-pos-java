package model;

public abstract class Produto {
    private String nome;
    private float preco;
    private int codigo;
    private double imposto;

    public Produto(String nome, float preco, int codigo) {
        this.nome = nome;
        this.preco = preco;
        this.codigo = codigo;
    }

    public abstract void calculaImposto();

    public String getNome() {
        return nome;
    }

    public float getPreco() {
        return preco;
    }

    public int getCodigo() {
        return codigo;
    }

    public double getImposto() {
        return imposto;
    }

    public void setImposto(double imposto) {
        this.imposto = imposto;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                ", codigo=" + codigo +
                '}';
    }
}
