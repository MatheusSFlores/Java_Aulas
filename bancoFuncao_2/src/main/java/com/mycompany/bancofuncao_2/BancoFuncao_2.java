package com.mycompany.bancofuncao_2;

import java.util.Scanner;

/*
The code is a simple banking management program that allows for user registration, querying and updating of user
data, as well as the making of deposits and withdrawals from the bank accounts of registered users.

I'll provide a more detailed analysis below:

The program uses the "Usuario" class, that has been defined in another .java.
In the "cadastro" function, the program requests the user's name, CPF (Brazilian taxpayer identification number), cell phone number, and balance and creates a new User object with this data.
The object is stored in a position in the array of users.
In the "credito" function, the program requests the user's CPF and checks if it exists in the array. If it does, the program adds a value provided by the user to the user's account balance.
In the "debito" function, the program requests the user's CPF and checks if it exists in the array. If it does, the program subtracts a value provided by the user from the user's account balance, provided that the balance is sufficient.
Otherwise, the program displays a message of insufficient balance.
In the "atualizar" function, the program requests the user's CPF and checks if it exists in the array. If it does, the program requests a new cell phone number for the user and updates the number in the corresponding User object.
In the "verificarUsers" function, the program allows the user to choose whether to search by CPF or name. Then, the program requests the value to be searched and checks if there is a corresponding user in the array.
If there is a corresponding user, the program displays their data on the screen.
In the "verificarSaldo" function, the program requests the user's CPF and checks if it exists in the array. If it does, the program displays the customer's total balance.

 */
public class BancoFuncao_2 {

    static Scanner t = new Scanner(System.in);
    static Scanner t2 = new Scanner(System.in);
    static int posi = 0, numUsers = 0;

    public static Usuario remocaoUser(Usuario[] usuario) {
        String cpfConsult;
        int r = 0;
        System.out.println("Bem Vindo ao Sistema de Remoção de usuario! \n");
        System.out.print("Qual CPF de acesso? \n");
        cpfConsult = t2.nextLine();
        for (posi = 0; posi < usuario.length; posi++) {
            if (usuario[posi].getCpf().equals(cpfConsult)) {
                System.out.print("O usuario " + usuario[posi].getNome() + " sera deletado, tem certeza?\n 1-Sim | 2-Não \n");
                r = t.nextInt();
                if (r == 1) {
                    usuario[posi].setNome(null);
                    usuario[posi].setCpf(null);
                    usuario[posi].setSaldo(0);
                    usuario[posi].setCelular(null);
                    numUsers--;
                    return null;
                }
            }
        }
        return null;
    }

    public static Usuario cadastro(Usuario[] usuario) {
        if (numUsers == 2) {
            remocaoUser(usuario);
            return null;
        }
        System.out.print("Digite o nome do usuário: ");
        String nome = t2.nextLine();

        System.out.print("Digite o CPF do usuário: ");
        String cpf = t2.nextLine();
        if (!cpf.matches("\\d{11}") || !cpf.matches("[0-9]*")) {

            System.out.println("CPF inválido. O CPF deve ter exatamente 11 dígitos e sem letras.");
            return null;
        }

        System.out.print("Digite o celular do usuário: ");
        String celular = t2.nextLine();

        System.out.print("Digite o saldo do usuário: ");
        double saldo = t.nextDouble();

        usuario[posi] = new Usuario(nome, cpf, celular, saldo);

        System.out.println("Usuário cadastrado com sucesso!");
        System.out.println(usuario[posi].getNome() + "\n CPF: " + usuario[posi].pontCpf() + "\n Celular: " + usuario[posi].getCelular() + "\n Saldo: R$" + usuario[posi].getSaldo());
        posi++;
        numUsers++;
        return null;
    }

    public static Usuario credito(Usuario[] usuario) {
        String cpfConsulta;
        double saldoadd = 0;
        Scanner t3 = new Scanner(System.in);
        int i = 0;
        System.out.println("Bem Vindo ao Sistema de Credito! \n");
        System.out.print("Qual CPF de acesso? \n");
        cpfConsulta = t3.nextLine();
        for (posi = 0; posi < usuario.length; posi++) {
            if (usuario[posi].getCpf().equals(cpfConsulta)) {
                System.out.print("Bem-Vindo/a senhor/a " + usuario[posi].getNome() + "\n");
                System.out.print("Saldo atual é de: " + usuario[posi].getSaldo() + "\n");
                System.out.print("Qual o Valor do deposito: \n");
                saldoadd += t.nextDouble();
                usuario[posi].addSaldo(saldoadd);
                System.out.print("Saldo Final é de: " + usuario[posi].getSaldo() + "\n");
                return null;
            } else {
                System.out.println("CPF não encontrado ");

            }
        }
        return null;
    }

    public static Usuario debito(Usuario[] usuario) {
        String cpfConsulta;
        double saldosub = 0;
        int i = 0;
        System.out.println("Bem Vindo ao Sistema de Débito! \n");
        System.out.print("Qual CPF de acesso? \n");
        cpfConsulta = t2.nextLine();
        for (i = 0; i < usuario.length; i++) {
            if (usuario[i].getCpf().equals(cpfConsulta)) {
                System.out.print("Bem-Vindo/a senhor/a " + usuario[i].getNome() + "\n");
                System.out.print("Saldo atual é de: " + usuario[i].getSaldo() + "\n");
                System.out.print("Qual o Valor que vai retirar?: \n");
                saldosub += t.nextDouble();
                if (saldosub <= usuario[i].getSaldo()) {
                    usuario[i].subSaldo(saldosub);
                    System.out.print("Saldo Final é de: " + usuario[i].getSaldo() + "\n");
                    return null;
                } else {
                    System.out.println("Saldo Insuficiente");
                }
            } else {
                System.out.println("CPF não encontrado");
            }
        }
        return null;
    }

    public static Usuario atualizar(Usuario[] usuario) {
        String cpfConsulta;
        int i = 0;
        System.out.println("Bem Vindo ao Sistema de Atualização de Dados! \n");
        System.out.print("Qual CPF de acesso? \n");
        cpfConsulta = t2.nextLine();
        for (i = 0; i < usuario.length; i++) {
            if (usuario[i].getCpf().equals(cpfConsulta)) {
                System.out.print("Bem-Vindo/a senhor/a " + usuario[i].getNome() + "\n");
                System.out.println("Número atual é : " + usuario[i].getCelular() + "\n");
                System.out.print("Informamos que o unico dado disponivel para alteração é o celular! \n");
                System.out.print("Por favor, informe seu novo numero telefonico: \n");
                String celular = t2.nextLine();
                usuario[i].setCelular(celular);
                System.out.println("Número atualizado: " + usuario[i].getCelular() + "\n");
                return null;
            }
            
        }
        return null;
    }

    public static Usuario verificarUsers(Usuario[] usuario) {
        String cpfConsulta, nomeConsulta;
        int i = 0, op = 0;
        System.out.println("Bem Vindo ao Sistema de Verificação de Usuarios! \n");
        System.out.println("Qual a forma de pesquisa?\n 1-CPF | 2-Nome \n");
        op = t.nextInt();
        switch (op) {
            case 1 -> {
                System.out.print("Qual CPF de acesso? \n");
                cpfConsulta = t2.nextLine();
                for (i = 0; i < usuario.length; i++) {
                    if (usuario[i].getCpf().equals(cpfConsulta)) {
                        System.out.print("Bem-Vindo/a senhor/a " + usuario[i].getNome() + "\n");
                        System.out.print("Seu telefone é: " + usuario[i].getCelular() + "\n");
                        System.out.print("Seu CPF é: " + usuario[i].pontCpf() + "\n");
                    }
                    break;
                }
            }
            case 2 -> {
                System.out.print("Qual Nome de acesso? \n");
                nomeConsulta = t2.nextLine();
                for (i = 0; i < usuario.length; i++) {
                    if (usuario[i].getNome().equals(nomeConsulta)) {
                        System.out.print("Bem-Vindo/a senhor/a " + usuario[i].getNome() + "\n");
                        System.out.print("Seu telefone é: " + usuario[i].getCelular() + "\n");
                        System.out.print("Seu CPF é: " + usuario[i].pontCpf() + "\n");
                    }

                    break;
                }
            }
        }
        return null;
    }

    public static Usuario verificarSaldo(Usuario[] usuario) {
        String cpfConsulta;
        int i = 0;
        System.out.println("Bem Vindo ao Sistema de Verificação de Saldo! \n");
        System.out.print("Qual CPF de acesso? \n");
        cpfConsulta = t2.nextLine();
        for (i = 0; i < usuario.length; i++) {
            if (usuario[i].getCpf().equals(cpfConsulta)) {
                System.out.print("Bem-Vindo/a senhor/a " + usuario[i].getNome() + "\n");
                System.out.print("Saldo total de: " + usuario[i].getSaldo() + "\n");
                return null;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int op = 7;
        Usuario[] usuario = new Usuario[2];

        do {
            System.out.println("");
            System.out.println("Bem Vindo ao banco Flôres!");
            System.out.print("Qual operação deseja realizar? \n");
            System.out.println("\n 1-Cadastro        | 2-Credito \n 3-Debito          | 4-Atualizar \n 5-Verificar Users | 6-Verifica Saldo \n 7-Sair.           |");
            op = t.nextInt();
            switch (op) {
                case 1 -> {
                    cadastro(usuario);
                    break;
                }
                case 2 -> {
                    credito(usuario);
                    break;
                }
                case 3 -> {
                    debito(usuario);
                    break;
                }
                case 4 -> {
                    atualizar(usuario);
                    break;
                }
                case 5 -> {
                    verificarUsers(usuario);
                    break;
                }

                case 6 -> {
                    verificarSaldo(usuario);
                    break;
                }

                case 7 -> {
                    System.out.println("Obrigado por escolher nosso banco, volte sempre :3 S2! \n");
                }
            }

        } while (op != 7);
    }
}
