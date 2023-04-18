package com.mycompany.bancofuncao;

import java.util.Scanner;

/**
 * This is a simple banking application in Java that allows users to create accounts, check their balance, make deposits and withdrawals, and update their account information.
It has a menu system that provides various options for users to choose from.

Here's a brief overview of the functionality provided by each method:

cadastro() - Allows users to create a new account by providing their name, starting balance, CPF (Brazilian personal identification number), and phone number.

credito() - Allows users to make a deposit to their account by providing the account number and the amount to be deposited.

debito() - Allows users to make a withdrawal from their account by providing the account number and the amount to be withdrawn.

atualizar() - Allows users to update their account information, specifically their phone number.

verificarUsers() - Allows users to view their account information, specifically their phone number and CPF.

verificarSaldo() - Allows users to view their account balance.

main() - The main method that provides a menu for users to choose from and calls the appropriate method based on their selection.

Overall, this program provides basic functionality for a simple banking application.
However, it is important to note that there are no security measures implemented, which could lead to potential vulnerabilities.
Additionally, it is not a production-ready banking application as it lacks several necessary features such as transactions, account validation, and so on.
 */
public class BancoFuncao {

    static Scanner t = new Scanner(System.in);
    static Scanner t2 = new Scanner(System.in);
    static int i = 0, op = 7, conta = 0, cont = 0;
    static float valor[] = new float[10];
    static String nome[] = new String[10], cel[] = new String[10], cpf[] = new String[10];

    public static void cadastro() {

        System.out.println("Bem Vindo ao Cadastro de usuarios! \n");
        System.out.print("Primeiramente informe seu nome: \n");
        nome[cont] = t2.nextLine();
        System.out.print("Informe agora seu saldo: \n");
        valor[cont] = t.nextFloat();
        System.out.print("Informe agora seu CPF (Apenas números): \n");
        cpf[cont] = t2.nextLine();
        System.out.print("Por ultimo, informe seu numero telefonico: \n");
        cel[cont] = t2.nextLine();
        System.out.println("Não Esqueça isso!! Seu codigo de acesso é: " + cont + "\n");
        i++;
        cont++;
    }

    public static void credito() {
        System.out.println("Bem Vindo ao Sistema de Credito! \n");
        System.out.print("Qual conta vai acessar? \n");
        conta = t.nextInt();
        i = conta;
        System.out.print("Bem-Vindo/a senhor/a " + nome[i] + "\n");
        System.out.print("Saldo atual é de: " + valor[i] + "\n");
        System.out.print("Qual o Valor do deposito: \n");
        valor[i] += t.nextFloat();
        System.out.print("Saldo Final é de: " + valor[i] + "\n");
    }

    public static void debito() {
        System.out.println("Bem Vindo ao Sistema de Débito! \n");
        System.out.print("Qual conta vai acessar? \n");
        conta = t.nextInt();
        i = conta;
        System.out.print("Bem-Vindo/a senhor/a " + nome[i] + "\n");
        System.out.print("Saldo atual é de: " + valor[i] + "\n");
        System.out.print("Qual o Valor que vai retirar?: \n");
        valor[i] -= t.nextFloat();
        System.out.print("Saldo Final é de: " + valor[i] + "\n");
    }

    public static void atualizar() {
        System.out.println("Bem Vindo ao Sistema de Atualização de Dados! \n");
        System.out.print("Qual conta vai acessar? \n");
        conta = t.nextInt();
        i = conta;
        System.out.print("Bem-Vindo/a senhor/a " + nome[i] + "\n");
        System.out.println("Número atual é : " + cel[i] + "\n");
        System.out.print("Informamos que o unico dado disponivel para alteração é o celular! \n");
        System.out.print("Por favor, informe seu novo numero telefonico: \n");
        cel[i] = t2.nextLine();
        System.out.println("Número atualizado: " + cel[i] + "\n");
    }

    public static void verificarUsers() {
        System.out.println("Bem Vindo ao Sistema de Verificação de Usuarios! \n");
        System.out.print("Qual conta vai acessar? \n");
        conta = t.nextInt();
        i = conta;
        System.out.print("Bem-Vindo/a senhor/a " + nome[i] + "\n");
        System.out.print("Seu telefone é: " + cel[i] + "\n");
        System.out.print("Seu CPF é: " + cpf[i] + "\n");
    }

    public static void verificarSaldo() {
        System.out.println("Bem Vindo ao Sistema de Verificação de Saldo! \n");
        System.out.print("Qual conta vai acessar? \n");
        conta = t.nextInt();
        i = conta;
        System.out.print("Bem-Vindo/a senhor/a " + nome[i] + "\n");
        System.out.print("Seu saldo é: " + valor[i] + "\n");
    }

    public static void main(String[] args) {

        do {
            System.out.println("");
            System.out.println("Bem Vindo ao banco Flôres!");
            System.out.print("Qual operação deseja realizar? \n");
            System.out.println("\n 1-Cadastro        | 2-Credito \n 3-Debito          | 4-Atualizar \n 5-Verificar Users | 6-Verifica Saldo \n 7-Sair.           |");
            op = t.nextInt();
            switch (op) {
                case 1 -> {
                    cadastro();
                    break;
                }
                case 2 -> {
                    credito();
                    break;
                }
                case 3 -> {
                    debito();
                    break;
                }
                case 4 -> {
                    atualizar();
                    break;
                }
                case 5 -> {
                    verificarUsers();
                    break;
                }
                case 6 -> {
                    verificarSaldo();
                    break;
                }
                case 7 -> {
                    System.out.println("Obrigado por escolher nosso banco, volte sempre :3 S2! \n");
                }
            }
        } while (op != 7);
    }
}
