import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        //matriz contatos
        ArrayList<ArrayList<Object>> clientes = new ArrayList<>();
        boolean estaAtivo = true;
        String nome, nTelefone;

        while (estaAtivo) {
            System.out.println("Digite o n° da opção que deseja:\n" +
                    "1 - Adicionar contato\n" +
                    "2 - Buscar telefone por nome\n" +
                    "3 - Listar todos os contatos\n" +
                    "4 - Remover contato\n" +
                    "0 - Sair");

            int opcao = Integer.parseInt(s.nextLine());

            switch (opcao) {
                //adicionando contato
                case 1:
                    System.out.println("Digite o nome do contato:");
                    nome = s.nextLine();

                    System.out.println("Digite o n° do contato:");
                    nTelefone = s.nextLine();

                    ArrayList<Object> novoContato = new ArrayList<>();
                    novoContato.add(nome);
                    novoContato.add(nTelefone);
                    clientes.add(novoContato);

                    System.out.println("Cliente cadastrado com sucesso!");
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