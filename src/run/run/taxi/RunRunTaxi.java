package run.run.taxi;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class RunRunTaxi {

    static List<Colaborador> Colaboradores = new ArrayList<Colaborador>();
    static List<Cliente> Clientes = new ArrayList<Cliente>();
    static Scanner le = new Scanner(System.in);
    static int codigoCliente = 0;

    public static void main(String[] args) {

        ImprimirMenuCadastro();
    }

    public static void ImprimirMenuCadastro() {
        System.out.println(" 1 - Cadastrar cliente");
        System.out.println(" 2 - Cadastrar colaborador");
        System.out.println(" 3 - Agendar corrida");
        System.out.println(" 4 - Sair");

        int resposta = le.nextInt();
        ValidarOpcaoMenu(resposta);
    }

    public static void ValidarOpcaoMenu(int resposta) {
        int[] opcoes = {1, 2, 3, 4};
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

        System.out.println(" ####Cadastro de clientes : \n");
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

        System.out.println("Telefone 01:   ");
        String telefoneA = le.next();
        System.out.println("Telefone 02:   ");
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
            
            System.out.println("\n============================================================\n");   
        }
    }

    public static void CadastrarColaborador() {

        System.out.println("####Cadastro de Colaboradores: \n");
        System.out.println("Nome: ");
        String nome = le.next();
        System.out.println("CPF: ");
        String cpf = le.next();
        cpf = cpf.replaceAll("[ .-]", "");
        while (!ValidaCPF.isCPF(cpf)) {
            System.out.println("\n***CPF invalido!\n  Verifique e digite novamente: ");
            cpf = le.next();
            cpf = cpf.replaceAll("[ .-]", "");
        }
        System.out.println("Numero VR: ");
        int numeroVr = le.nextInt();
        System.out.println("Telefone Fixo: ");
        String telFixo = le.next();
        System.out.println("Telefone movel: ");
        String telMovel = le.next();
        System.out.println("Data de admissao: ");
        String dataAdmissao = le.next();
        Colaborador colaborador = new Colaborador(nome, cpf, numeroVr, telFixo,
                telMovel, dataAdmissao, CadastrarCnh(), CadastrarVeiculo(), CadastrarEndereco());
        Colaboradores.add(colaborador);
        ImprimirColaboradores();
    }

    public static void ImprimirColaboradores() {

        for (Colaborador c : Colaboradores) {
            System.out.println("Nome: " + c.getNome());
            System.out.println("CPF: " + c.getCpf());
            System.out.println("Data de admissao: " + c.getDataAdmissao());
            System.out.println("Numero VR: " + c.getNumeroVR());
            System.out.println("Numero CNH: " + c.getCnh().getNumero());
            System.out.println("Categoria CNH: " + c.getCnh().getCategoria());
            System.out.println("Validade CNH: " + c.getCnh().getValidade());
            System.out.println("Telefone fixo: " + c.getTelefoneFixo());
            System.out.println("Telefone Movel: " + c.getTelefoneMovel());
            System.out.println("Estado: " + c.getEndereco().getEstado());
            System.out.println("Cidade: " + c.getEndereco().getCidade());
            System.out.println("Cep: " + c.getEndereco().getCep());
            System.out.println("Bairro: " + c.getEndereco().getBairro());
            System.out.println("Rua/Logradouro: " + c.getEndereco().getLogradouro());
            System.out.println("Numero: " + c.getEndereco().getNumero());
            if (!empty(c.getDataDesligamento()))
                System.out.print("Data de desligamento: " + c.getDataDesligamento());
            System.out.println("\n============================================================\n");
        }
    }

    public static void AgendarCorrida() {

    }

    public static Cnh CadastrarCnh() {

        System.out.println("Categoria CNH: ");
        String categoria = le.next();
        System.out.println("Numero da CNH: ");
        int numeroCnh = le.nextInt();
        System.out.println("Data de validade da CNH: ");
        String dataValidade = le.next();
        Cnh cnh = new Cnh(categoria, numeroCnh, dataValidade);
        return cnh;
    }

    public static Veiculo CadastrarVeiculo() {

        System.out.println("Modelo do veiculo: ");
        String modelo = le.next();
        System.out.println("Fabricante do veiculo: ");
        String fabricante = le.next();
        System.out.println("Cor do veiculo: ");
        String cor = le.next();
        System.out.println("Placa do veiculo: ");
        String placa = le.next();
        Veiculo veiculo = new Veiculo(modelo, fabricante, cor, placa);
        return veiculo;
    }

    public static Endereco CadastrarEndereco() {
        Endereco endereco = new Endereco();

        System.out.println(" Estado: ");
        endereco.setEstado(le.next());

        System.out.println(" Cidade: ");
        endereco.setCidade(le.next());

        System.out.println("Cep: ");
        endereco.setCep(le.next());

        System.out.println("Numero: ");
        endereco.setNumero(le.nextInt());

        System.out.println("Rua/Logradouro: ");
        endereco.setLogradouro(le.next());

        System.out.println("Bairro: ");
        endereco.setBairro(le.next());

        System.out.println("Complemento: ");
        endereco.setComplemento(le.next());

        return endereco;
    }

    public static boolean empty(final String s) {
        return s == null || s.trim().isEmpty();
    }
}
