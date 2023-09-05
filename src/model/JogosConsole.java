package model;

public class JogosConsole extends Produto {
    private Console console;

    public JogosConsole(String nome, float preco, int codigo, Console console) {
        super(nome, preco, codigo);
        this.console = console;
        calculaImposto();
    }

    public String getMarca() {
        return console.getMarca();
    }

    @Override
    public void calculaImposto() {
        this.setImposto(super.getPreco() * 0.15);
    }

    @Override
    public String toString() {
        return "JogosConsole{" +
                "nome='" + super.getNome() + '\'' +
                ", preco=" + super.getPreco() +
                ", codigo=" + super.getCodigo() +
                ", marca='" + console.getMarca() + '\'' +
                ", imposto=" + super.getImposto() +
                '}';
    }
}
