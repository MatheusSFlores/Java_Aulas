package com.mycompany.bancofuncao_2;

/**
 *
 * @author MatheusF
 */
public class Usuario {

    private String nome;
    private String cpf;
    private String celular;
    private double saldo;

    public Usuario(String nome, String cpf, String celular, double saldo) {
        this.nome = nome;
        this.cpf = cpf;
        this.celular = celular;
        this.saldo = saldo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void addSaldo(double valor) {
        this.saldo += valor;
    }

    public void subSaldo(double valor) {
        this.saldo -= valor;
    }
}
