package br.com.alura.CriatividadeCompras.modelo;

public class Cartao {
    private double limiteDoCartao;

    public double compra (double valorCompra) {
        return this.limiteDoCartao -= valorCompra;
    }

    public Cartao(double limiteDoCartao) {
        this.setLimiteDoCartao(limiteDoCartao);
    }

    public double getLimiteDoCartao() {
        return limiteDoCartao;
    }

    public void setLimiteDoCartao(double limiteDoCartao) {
        this.limiteDoCartao = limiteDoCartao;
    }
}
