import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        //matriz clientes
        ArrayList<ArrayList<Object>> clientes = new ArrayList<>();
        int nConta;
        boolean estaAtivo = true;
        double saldoAtual;
        String senhaAdmin = "PedrinhoGamer@123";

        while (estaAtivo) {
            System.out.println("Digite o n° da opção que deseja:\n" +
                    "1 - Cadastrar contas\n" +
                    "2 - Realizar depósitos\n" +
                    "3 - Realizar saques\n" +
                    "4 - Consultar saldo\n" +
                    "5 - Consultar histórico de movimentações\n" +
                    "6 - Transferir entre contas\n" +
                    "0 - Sair\n" +
                    "99 - Admin");
            int opcao = Integer.parseInt(s.nextLine());

            boolean validando = true;

            switch (opcao) {
                //adicionando cliente
                case 1:
                    System.out.println("Digite o nome do cliente:");
                    String nome = s.nextLine();

                    System.out.println("Digite o saldo inicial:");
                    double saldo = Integer.parseInt(s.nextLine());

                    ArrayList<Object> novoCliente = new ArrayList<>();
                    novoCliente.add(nome);
                    novoCliente.add(saldo);
                    clientes.add(novoCliente);

                    nConta = clientes.size() - 1;

                    System.out.println("Cliente cadastrado com sucesso!");
                    System.out.println("N° da conta: " + nConta);
                    break;

                //realizando depósitos
                case 2:
                    while (validando) {
                        System.out.println("Digite o n° da conta em que deseja depositar:");
                        nConta = Integer.parseInt(s.nextLine());

                        if (nConta > clientes.size() - 1) {
                            System.out.println("Número inválido!!!!");
                        } else {
                            System.out.println("Conta em nome de: " + clientes.get(nConta).get(0) + ", confirma? s/n");
                            String sn = s.nextLine();

                            if (sn.equals("s")) {
                                System.out.println("Digite o valor a ser depositado:");
                                double deposito = Double.parseDouble(s.nextLine());

                                saldoAtual = (double) clientes.get(nConta).get(1) + deposito;
                                clientes.get(nConta).set(1, saldoAtual);

                                System.out.println("O valor de R$ " + deposito + " foi depositado com sucesso!");
                            }
                        }
                        validando = false;
                    }
                    break;

                //realizando saques
                case 3:
                    while (validando) {
                        System.out.println("Digite o n° de sua conta:");
                        nConta = Integer.parseInt(s.nextLine());

                        if (nConta > clientes.size() - 1) {
                            System.out.println("Número inválido.");
                        } else {
                            System.out.println("Conta em nome de: " + clientes.get(nConta).get(0) + ", confirma? s/n");
                            String sn = s.nextLine();

                            if (sn.equals("s")) {
                                System.out.println("Digite o valor a ser sacado:");
                                double saque = Double.parseDouble(s.nextLine());

                                if (saque > (double) clientes.get(nConta).get(1)) {
                                    System.out.println("Valor de saque superior ao valor em conta!!!");
                                } else {
                                    saldoAtual = (double) clientes.get(nConta).get(1) - saque;
                                    clientes.get(nConta).set(1, saldoAtual);
                                    System.out.println("O valor de R$ " + saque + " foi sacado com sucesso!");
                                }
                            }
                        }
                        validando = false;
                    }
                    break;

                //consultando saldo
                case 4:
                    while (validando) {
                        System.out.println("Digite o n° de sua conta:");
                        nConta = Integer.parseInt(s.nextLine());

                        if (nConta > clientes.size() - 1) {
                            System.out.println("Número inválido.");
                        } else {
                            System.out.println("Conta em nome de: " + clientes.get(nConta).get(0) + ", confirma? s/n");
                            String sn = s.nextLine();

                            if (sn.equals("s")) {
                                System.out.println("Valor em conta: R$ " + clientes.get(nConta).get(1));
                            }
                        }
                        validando = false;
                    }
                    break;

                //consultar histórico de movimentações
                case 5:
                    break;

                //transferir entre contas
                case 6:
                    while (validando) {
                        System.out.println("Digite o n° de sua conta:");
                        nConta = Integer.parseInt(s.nextLine());

                        if (nConta > clientes.size() - 1) {
                            System.out.println("Número inválido.");
                        } else {
                            System.out.println("Conta em nome de: " + clientes.get(nConta).get(0) + ", confirma? s/n");
                            String sn = s.nextLine();

                            if (sn.equals("s")) {
                                System.out.println("Digite o valor da transferência:");
                                double valorTransferencia = Double.parseDouble(s.nextLine());

                                System.out.println("Digite o n° da conta para depósito:");
                                int contaDeposito = Integer.parseInt(s.nextLine());

                                if (contaDeposito > clientes.size() - 1) {
                                    System.out.println("Número inválido.");
                                } else {
                                    System.out.println("Conta em nome de: " + clientes.get(contaDeposito).get(0) + ", confirma? s/n");
                                    sn = s.nextLine();

                                    if (sn.equals("s")) {
                                        //conta que está transferindo
                                        double saldoC1 = (double) clientes.get(nConta).get(1) - valorTransferencia;
                                        clientes.get(nConta).set(1, saldoC1);

                                        //conta que recebeu transferencia
                                        double saldoC2 = (double) clientes.get(contaDeposito).get(1) + valorTransferencia;
                                        clientes.get(contaDeposito).set(1, saldoC2);

                                        System.out.println("Realizado a transferência com sucesso!");
                                        System.out.println(clientes.get(nConta).set(1, saldoC1));
                                        System.out.println(clientes.get(contaDeposito).set(1, saldoC2));
                                    }
                                }
                            }
                        }
                        validando = false;
                    }
                    break;

                //Sair
                case 0:
                    System.out.println("Encerrando...");
                    estaAtivo = false;
                    break;

                case 99:
                    System.out.println("Digite a senha de administrador:");
                    String senhaInformada = s.nextLine();

                    if (senhaInformada.equals(senhaAdmin)) {
                        System.out.println("Listagem de clientes e seu respectivo saldo:");
                        System.out.println(clientes);
                    } else {
                        System.out.println("Acesso negado!!!");
                    }
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente");
            }
        }
    }
}