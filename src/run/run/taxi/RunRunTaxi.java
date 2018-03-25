package run.run.taxi;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.stream.IntStream;

public class RunRunTaxi {

    static ArrayList<Cliente> Clientes = new ArrayList<Cliente>();
    static Scanner le = new Scanner(System.in);
    static int codigoCliente = 0;

    public static void main(String[] args) {

        ImprimirMenuCadastro();
    }

    public static void ImprimirMenuCadastro() {

        int[] opcoes = {1, 2, 3, 4};
        System.out.println(" 1 - Cadastrar cliente");
        System.out.println(" 2 - Cadastrar colaborador");
        System.out.println(" 3 - Agendar corrida");
        System.out.println(" 4 - Sair");

        int resposta = le.nextInt();
        if (IntStream.of(opcoes).anyMatch((int x) -> x == resposta)) {
            ChamarCadastroCorreto(resposta);
        } else {
            System.out.println("\n**Opção inválida! Tente novamente.\n");
            ImprimirMenuCadastro();
        }

    }

    public static void ChamarCadastroCorreto(int resposta) {

        switch (resposta) {
            case 1:
                CadastrarCliente();
                ImprimirMenuCadastro();
                break;
            case 2:
                CadastrarColaborador();
                ImprimirMenuCadastro();
                break;
            case 3:
                AgendarCorrida();
                ImprimirMenuCadastro();
                break;
            default:
                System.out.println("Encerrando Seção...");
                break;
        }

    }

    public static void CadastrarCliente() {

        System.out.println(" ####Cadastro de cliente : \n");
        System.out.println(" Qual tipo de cadastro deseja fazer agora? ");
        System.out.println(" 1 - Completo ");
        System.out.println(" 2 - Rápido ");
        byte cadastroCompleto = le.nextByte();

        System.out.println(" Nome: ");
        String nome = le.next();
        codigoCliente++;
        if (cadastroCompleto == 1) {

            CadastrarCliente(nome);

        } else {

            Cliente cliente = new Cliente(codigoCliente, nome);
            Clientes.add(cliente);
            System.out.println(" Ok. Finalizando Cadastro.. ");
        }
        ImprimirClientes();
    }

    public static void CadastrarCliente(String nome) {

        System.out.println(" ####Cadastro de cliente: \n");
        System.out.println(" Telefone 01:   ");
        String telefoneA = le.next();
        System.out.println(" Telefone 02:   ");
        String telefoneB = le.next();
        Cliente cliente = new Cliente(codigoCliente, nome, telefoneA, telefoneB, CadastrarEndereco());
        Clientes.add(cliente);
        ImprimirClientes();
    }

    public static void ImprimirClientes() {
        for (Cliente c : Clientes) {
            System.out.println("Código : " + c.getCodigo());
            System.out.println("Nome: " + c.getNome());
            if (!empty(c.getTelefoneA())) {
                System.out.println("Telefone 01: " + c.getTelefoneA());
                System.out.println("Telefone 02: " + c.getTelefoneB());
                System.out.println("Estado: " + c.getEndereco().getEstado());
                System.out.println("Cidade: " + c.getEndereco().getCidade());
                System.out.println("Cep: " + c.getEndereco().getCep());
                System.out.println("Bairro: " + c.getEndereco().getBairro());
                System.out.println("Rua/Logradouro: " + c.getEndereco().getLogradouro());
                System.out.println("Numero: " + c.getEndereco().getNumero());
            }

            System.out.println("============================================================\n");
        }
    }

    public static boolean empty(final String s) {
        return s == null || s.trim().isEmpty();
    }

    public static void CadastrarColaborador() {

    }

    public static void AgendarCorrida() {

    }

    public static Endereco CadastrarEndereco() {
        Endereco endereco = new Endereco();

        System.out.println(" Estado: ");
        endereco.setEstado(le.next());

        System.out.println(" Cidade: ");
        endereco.setCidade(le.next());

        System.out.println(" Cep: ");
        endereco.setCep(le.next());

        System.out.println(" Numero: ");
        endereco.setNumero(le.nextInt());

        System.out.println(" logradouro: ");
        endereco.setLogradouro(le.next());

        System.out.println(" Bairro: ");
        endereco.setBairro(le.next());

        System.out.println(" Complemento: ");
        endereco.setComplemento(le.next());

        return endereco;
    }

}
