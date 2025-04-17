import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        //matriz contatos
        ArrayList<ArrayList<Object>> contatos = new ArrayList<>();
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
                    contatos.add(novoContato);

                    System.out.println("Contato cadastrado com sucesso!");
                    break;

                //Buscar telefone por nome
                case 2:
                    System.out.println("Digite o nome do contato:");
                    nome = s.nextLine();

                    for (int i = 0; i < contatos.size(); i++){
                        if (contatos.get(i).contains(nome)){
                            System.out.println("O n° desse contato é: " + contatos.get(i).get(1));
                        } else {
                            System.out.println("Nome inválido!!");
                        }
                    }
                    break;

                //listar todos os contatos
                case 3:
                    System.out.println("Estes são os seus contatos registrados:\n " + contatos);
                    break;

                //Remover contato
                case 4:
                    System.out.println("Digite o nome do contato a ser removido:");
                    nome = s.nextLine();

                    for (int i = 0; i < contatos.size(); i++){
                        if (contatos.get(i).contains(nome)){
                            contatos.remove(i);
                            System.out.println("Contato removido!");
                        } else {
                            System.out.println("Nome inválido!!");
                        }
                    }
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