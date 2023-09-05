package model;

public class Console extends Produto {
    private String marca;

    public Console(String nome, float preco, int codigo, String marca) {
        super(nome, preco, codigo);
        this.marca = marca;
        calculaImposto();
    }

    public String getMarca() {
        return marca;
    }

    @Override
    public void calculaImposto() {
        this.setImposto(super.getPreco() * 0.30);
    }

    @Override
    public String toString() {
        return "Console{" +
                "nome='" + super.getNome() + '\'' +
                ", preco=" + super.getPreco() +
                ", codigo=" + super.getCodigo() +
                ", marca='" + marca + '\'' +
                ", imposto=" + super.getImposto() +
                '}';
    }
}
