package com.mycompany.bancofuncao_2;

import java.util.Scanner;


public class BancoFuncao_2 {

    static Scanner t = new Scanner(System.in);
    static Scanner t2 = new Scanner(System.in);

    public static boolean validaCpf(String cpf) {
        if (cpf.length()==11) {
            for (int i = 0; i < cpf.length(); i++) {
                if (!cpf.substring(0,11).matches("[0-9]*")) {
                    return false;
                }
            }
        }     
     return true;
    }
         
     
    public static void cadastro(String[] nome, float[] valor, String[] cpf, String[] cel) {
        int cont=0;
        
        System.out.println("Bem Vindo ao Cadastro de usuarios! \n");
        System.out.print("Primeiramente informe seu nome: \n");
        nome[cont] = t2.nextLine();
        System.out.print("Informe agora seu saldo: \n");
        valor[cont] = t.nextFloat();
        System.out.print("Informe agora seu CPF (Apenas números): \n");
        cpf[cont] = t2.nextLine();
        System.out.print("Por ultimo, informe seu numero telefonico: \n");
        cel[cont] = t2.nextLine();
        System.out.println("Não Esqueça isso!! Seu codigo de acesso é: " + contador + "\n");
        cont++;
   
    }

    public static void credito(String[] nome, float[] valor, String[] cpf) {
        int contador;
        String veriCpf;
        System.out.println("Bem Vindo ao Sistema de Credito! \n");
        System.out.print("Qual conta vai acessar? digite o CPF \n");
        veriCpf = t2.nextLine();
        if(validaCpf(veriCpf)){
        for(contador=0 ; contador<10; contador++){
            if(cpf[contador]==veriCpf){
        System.out.print("Bem-Vindo/a senhor/a " + nome[contador] + "\n");
        System.out.print("Saldo atual é de: " + valor[contador] + "\n");
        System.out.print("Qual o Valor do deposito: \n");
        valor[contador] += t.nextFloat();
        System.out.print("Saldo Final é de: " + valor[contador] + "\n");
            }
        }
        }
    }

    public static void debito(String[] nome, float[] valor, String[] cpf) {
        int contador=0;
        String veriCpf;
        System.out.println("Bem Vindo ao Sistema de Débito! \n");
        System.out.print("Qual conta vai acessar? digite o CPF \n");
        veriCpf = t.nextLine();
        if(validaCpf(veriCpf)){
        for(contador=0 ; contador<10; contador++){
            if(cpf[contador]==veriCpf){
                contador=contador;
            }
        }
        System.out.print("Bem-Vindo/a senhor/a " + nome[contador] + "\n");
        System.out.print("Saldo atual é de: " + valor[contador] + "\n");
        System.out.print("Qual o Valor que vai retirar?: \n");
        valor[contador] -= t.nextFloat();
        System.out.print("Saldo Final é de: " + valor[contador] + "\n");
    }
    }

    public static void atualizar(String[] nome, String[] cel, String[] cpf) {
        int contador=0;
        String veriCpf;
        System.out.println("Bem Vindo ao Sistema de Atualização de Dados! \n");
        System.out.print("Qual conta vai acessar? digite o CPF \n");
        veriCpf = t.nextLine();
        if(validaCpf(veriCpf)){
        for(contador=0 ; contador<10; contador++){
            if(cpf[contador]==veriCpf){
                contador=contador;
            }
        }
        System.out.print("Bem-Vindo/a senhor/a " + nome[contador] + "\n");
        System.out.println("Número atual é : " + cel[contador] + "\n");
        System.out.print("Informamos que o unico dado disponivel para alteração é o celular! \n");
        System.out.print("Por favor, informe seu novo numero telefonico: \n");
        cel[contador] = t2.nextLine();
        System.out.println("Número atualizado: " + cel[contador] + "\n");
    }
}

    public static void verificarUsers(String[] cpf, String[] nome, String[] cel ) {
        int contador=0;
        String veriCpf;
        System.out.println("Bem Vindo ao Sistema de Verificação de Usuarios! \n");
        System.out.print("Qual conta vai acessar? digite o CPF \n");
        veriCpf = t.nextLine();
        if(validaCpf(veriCpf)){
        for(contador=0 ; contador<10; contador++){
            if(cpf[contador]==veriCpf){
                contador=contador;
            }
        }
        System.out.print("Bem-Vindo/a senhor/a " + nome[contador] + "\n");
        System.out.print("Seu telefone é: " + cel[contador] + "\n");
        System.out.print("Seu CPF é: " + cpf[contador] + "\n");
    }
    }

    public static void verificarSaldo(String[] cpf, String[] nome, float[] valor) {
        int contador=0;
        String veriCpf;
        System.out.println("Bem Vindo ao Sistema de Verificação de Saldo! \n");
         System.out.print("Qual conta vai acessar? digite o CPF \n");
        veriCpf = t.nextLine();
        if(validaCpf(veriCpf)){
        for(contador=0 ; contador<10; contador++){
            if(cpf[contador]==veriCpf){
                contador=contador;
            }
        }
        System.out.print("Bem-Vindo/a senhor/a " + nome[contador] + "\n");
        System.out.print("Seu saldo é: " + valor[contador] + "\n");
    }
    }

    public static void main(String[] args) {
        
     int op = 7;
     float valor[] = new float[10];
     String nome[] = new String[10], cel[] = new String[10], cpf[] = new String[10];


        do {
            System.out.println("");
            System.out.println("Bem Vindo ao banco Flôres!");
            System.out.print("Qual operação deseja realizar? \n");
            System.out.println("\n 1-Cadastro        | 2-Credito \n 3-Debito          | 4-Atualizar \n 5-Verificar Users | 6-Verifica Saldo \n 7-Sair.           |");
            op = t.nextInt();
            switch (op) {
                case 1 -> {
                    cadastro(nome, valor, cpf, cel);
                    break;
                }
                case 2 -> {
                    credito(nome,valor,cpf);
                    break;
                }
                case 3 -> {
                    debito(nome,valor,cpf);
                    break;
                }
                case 4 -> {
                    atualizar(nome,cel,cpf);
                    break;
                }
                case 5 -> {
                    verificarUsers(cpf,nome,cel);
                    break;
                }
                case 6 -> {
                    verificarSaldo(cpf,nome,valor);
                    break;
                }
                case 7 -> {
                    System.out.println("Obrigado por escolher nosso banco, volte sempre :3 S2! \n");
                }
            }
        } while (op != 7);
    }
}

