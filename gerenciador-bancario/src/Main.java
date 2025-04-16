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

        while (estaAtivo) {
            System.out.println("Digite o n° da opção que deseja:\n" +
                    "1 - Cadastrar contas\n" +
                    "2 - Realizar depósitos\n" +
                    "3 - Realizar saques\n" +
                    "4 - Consultar saldo\n" +
                    "5 - Consultar histórico de movimentações\n" +
                    "6 - Transferir entre contas\n" +
                    "0 - Sair");
            int opcao = Integer.parseInt(s.nextLine());

            boolean validando = true;

            switch (opcao) {
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

                case 2:
                    while (validando) {
                        System.out.println("Digite o n° da conta em que deseja depositar:");
                        nConta = Integer.parseInt(s.nextLine());

                        if (nConta > clientes.size() - 1) {
                            System.out.println("Número inválido.");
                        } else {
                            System.out.println("Conta em nome de: " + clientes.get(nConta).get(0) + ", confirma? s/n");
                            String sn = s.nextLine();

                            if (sn.equals("s")) {
                                System.out.println("Digite o valor a ser depositado:");
                                double deposito = Double.parseDouble(s.nextLine());

                                double valorAtual = (double) clientes.get(nConta).get(1) + deposito;
                                clientes.get(nConta).set(1,valorAtual);

                                System.out.println("O valor de R$ " + deposito + " foi depositado com sucesso!");
                            }
                        }
                        validando = false;
                    }
                    break;

                case 3:
                    break;

                case 4:
                    break;

                //Sair
                case 0:
                    System.out.println("Encerrando...");
                    estaAtivo = false;
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente");
            }
        }
    }
}