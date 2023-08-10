import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<AgenciaBancaria> agencias = new ArrayList<AgenciaBancaria>();

        boolean controle = true;
        try(Scanner input = new Scanner(System.in)) {
            while (controle) {
                System.out.println("Digite o que deseja fazer: ");
                System.out.println("1 - Criar agência");
                System.out.println("2 - Criar conta");
                System.out.println("3 - Acessar conta");
                System.out.println("4 - Sair");
                int opcao = input.nextInt();
                switch (opcao) {
                    case 1 -> {
                        System.out.println("Digite o número da agência: ");
                        int agenciaNumero = input.nextInt();
                        AgenciaBancaria agenciaBancaria = new AgenciaBancaria(agenciaNumero);
                        agencias.add(agenciaBancaria);
                        System.out.println("Agência criada com sucesso");
                    }
                    case 2 -> {
                        System.out.println("Digite o número da agência: ");
                        int agenciaNumero = input.nextInt();
                        AgenciaBancaria agencia = null;
                        for (AgenciaBancaria agenciaBancaria : agencias) {
                            if (agenciaBancaria.getAgencyNumber() == agenciaNumero) {
                                System.out.println("Agência encontrada");
                                agencia = agenciaBancaria;
                            } else {
                                System.out.println("Agência não encontrada");
                                controle = false;
                            }
                        }

                        System.out.println("Digite o número da conta: ");
                        int contaNumero = input.nextInt();
                        System.out.println("Digite o saldo da conta: ");
                        double saldo = input.nextDouble();
                        System.out.println("Digite o nome do titular da conta: ");
                        String titular = input.next();
                        ContaBancaria contaBancaria = new ContaBancaria(contaNumero, saldo, titular);
                        agencia.addAccount(contaBancaria);
                        System.out.println("Conta criada com sucesso");
                    }
                    case 3 -> {
                        AgenciaBancaria agencia = null;

                        System.out.println("Digite um número de agência: ");
                        int agenciaNumero = input.nextInt();
                        for (AgenciaBancaria agenciaBancaria : agencias) {
                            if (agenciaBancaria.getAgencyNumber() == agenciaNumero) {
                                System.out.println("Agência encontrada");
                                agencia = agenciaBancaria;
                            } else {
                                System.out.println("Agência não encontrada");
                                controle = false;
                            }
                        }

                        System.out.println("Digite o número da conta que deseja acessar: ");
                        int contaNumero = input.nextInt();
                        ContaBancaria contaBancaria = agencia.getAccount(contaNumero);
                        if (contaBancaria != null) {
                            System.out.println("Conta encontrada");
                            System.out.println(contaBancaria);
                        } else {
                            System.out.println("Conta não encontrada");
                            controle = false;
                        }

                        System.out.println("Escolha uma opção: ");
                        System.out.println("1 - Depositar");
                        System.out.println("2 - Sacar");
                        System.out.println("3 - Transferir");
                        System.out.println("4 - Mostrar conta");
                        System.out.println("5 - Sair");
                        opcao = input.nextInt();
                        switch (opcao) {
                            case 1 -> {
                                System.out.println("Digite o valor a ser depositado: ");
                                double valor = input.nextDouble();
                                contaBancaria.deposit(valor);
                            }
                            case 2 -> {
                                System.out.println("Digite o valor a ser sacado: ");
                                double valor = input.nextDouble();
                                contaBancaria.withdraw(valor);
                            }
                            case 3 -> {
                                System.out.println("Digite o valor a ser transferido: ");
                                double valor = input.nextDouble();
                                System.out.println("Digite o número da conta para qual deseja transferir: ");
                                int contaDestino = input.nextInt();
                                ContaBancaria contaDestinoBancaria = agencia.getAccount(contaDestino);
                                if (contaDestinoBancaria == null) {
                                    System.out.println("Conta não encontrada");
                                    controle = false;
                                }
                                contaBancaria.transfer(valor, contaDestinoBancaria);
                            }
                            case 4 -> {
                                System.out.println(contaBancaria);
                            }
                            case 5 -> {
                                controle = false;
                            }
                        }

                    }

                    case 4 -> {
                        controle = false;
                    }
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida");
        }
    }

}