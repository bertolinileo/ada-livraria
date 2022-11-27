package com.company;

public class Caixa {
    private Double saldo;

    public Caixa(Double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public Double obterSaldo() {
        return saldo;
    }

    public void atualizarSaldoCaixa(Double valor) {
        this.saldo += valor;
    }
}
