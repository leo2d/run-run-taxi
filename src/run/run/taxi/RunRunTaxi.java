package run.run.taxi;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class RunRunTaxi {

    static List<Colaborador> Colaboradores = new ArrayList<Colaborador>();
    static List<Cliente> Clientes = new ArrayList<Cliente>();
    static List<Corrida> Corridas = new ArrayList<Corrida>();
    static Scanner le = new Scanner(System.in);
    static int codigoCliente = 0;

    public static void main(String[] args) {

        System.out.println("\n****************************************\n");
        System.out.println("\tBem vindo ao Run Run Taxi");
        System.out.println("\n****************************************\n \n");
        ImprimirMenuInicial();
    }

    public static void ImprimirMenuInicial() {
        System.out.println("\n 1 - Menu cliente");
        System.out.println(" 2 - Menu colaborador");
        System.out.println(" 3 - Menu corrida");
        System.out.println(" 4 - Sair\n");

        int resposta = le.nextInt();
        int[] opcoes = {1, 2, 3, 4};

        if (ValidarOpcaoMenu(resposta, opcoes)) {
            switch (resposta) {
                case 1:
                    ImprimirMenuCliente();
                    break;
                case 2:
                    ImprimirMenuColaborador();
                    break;
                case 3:
                    ImprimirMenuCorrida();
                    break;
                default:
                    System.out.println("Encerrando Seção...\n");
                    break;
            }
        } else {
            System.out.println("\n**Opção inválida! Tente novamente.\n");
            ImprimirMenuInicial();
        }
    }

    public static void ImprimirMenuCliente() {
        
        System.out.println("\t Opções dos clientes ");
        System.out.println("____________________________________\n");
        System.out.println("\n 1 - Cadastrar cliente");
        System.out.println(" 2 - Listar clientes Cadastrados");
        System.out.println(" 3 - Voltar");
        System.out.println(" 4 - Sair\n");

        int[] opcoes = {1, 2, 3, 4};
        byte resposta = le.nextByte();
        if (ValidarOpcaoMenu(resposta, opcoes)) {
            switch (resposta) {
                case 1:
                    CadastrarCliente();
                    ImprimirMenuCliente();
                    break;
                case 2:
                    ImprimirClientes();
                    ImprimirMenuCliente();
                    break;
                case 3:
                    ImprimirMenuInicial();
                    break;
                default:
                    System.out.println("Encerrando Seção...\n");
                    break;
            }
        } else {
            System.out.println("\n**Opção inválida! Tente novamente.\n");
            ImprimirMenuInicial();
        }

    }

    public static void ImprimirMenuColaborador() {
        System.out.println("\t Opções dos colaboradores ");
        System.out.println("___________________________________________\n");
        System.out.println(" 1 - Cadastrar colaborador");
        System.out.println(" 2 - Desligar colaborador");
        System.out.println(" 3 - Listar colaboradores Cadastrados");
        System.out.println(" 4 - Voltar");
        System.out.println(" 5 - Sair\n");

        int[] opcoes = {1, 2, 3, 4, 5};
        byte resposta = le.nextByte();
        if (ValidarOpcaoMenu(resposta, opcoes)) {
            switch (resposta) {
                case 1:
                    CadastrarColaborador();
                    ImprimirMenuColaborador();
                    break;
                case 2:
                    DesligarColaborador();
                    ImprimirMenuColaborador();
                    break;
                case 3:
                    ImprimirColaboradores();
                    ImprimirMenuColaborador();
                    break;
                case 4:
                    ImprimirMenuInicial();
                    break;
                default:
                    System.out.println("Encerrando Seção...\n");
                    break;
            }
        } else {
            System.out.println("\n**Opção inválida! Tente novamente.\n");
            ImprimirMenuInicial();
        }
    }

    public static void ImprimirMenuCorrida() {
        System.out.println("\t Opções das corridas ");
        System.out.println("____________________________________\n");
        System.out.println(" 1 - Agendar corrida programada");
        System.out.println(" 2 - Agendar corrida imediata");
        System.out.println(" 3 - Mudar Status da corrida");
        System.out.println(" 4 - Voltar");
        System.out.println(" 5 - Sair\n");

        int[] opcoes = {1, 2, 3, 4, 5};
        byte resposta = le.nextByte();
        if (ValidarOpcaoMenu(resposta, opcoes)) {
            switch (resposta) {
                case 1:
                    AgendarCorridaProgramada();
                    ImprimirMenuCorrida();
                    break;
                case 2:
                    AgendarCorridaImediata();
                    ImprimirMenuCorrida();
                    break;
                case 3:
                    MudarStatusCorrida();
                    ImprimirMenuCorrida();
                    break;
                case 4:
                    ImprimirMenuInicial();
                    break;
                default:
                    System.out.println("Encerrando Seção...\n");
                    break;
            }
        } else {
            System.out.println("\n**Opção inválida! Tente novamente.\n");
            ImprimirMenuInicial();
        }

    }

    public static Boolean ValidarOpcaoMenu(int resposta, int[] opcoes) {

        if (IntStream.of(opcoes).anyMatch((int x) -> x == resposta)) {
            return true;
        }

        return false;

    }

    public static void CadastrarCliente() {

        System.out.println(" ####Cadastro de clientes : \n");
        System.out.println(" Qual tipo de cadastro deseja fazer agora? ");
        System.out.println(" 1 - Completo ");
        System.out.println(" 2 - Rápido ");
        byte cadastroCompleto = le.nextByte();
        le.nextLine();

        System.out.println(" Nome: ");

        codigoCliente++;
        if (cadastroCompleto == 1) {
            CadastrarCliente(le.nextLine());
        } else {
            Cliente cliente = new Cliente(codigoCliente, le.nextLine());
            Clientes.add(cliente);
            System.out.println(" Ok. Finalizando Cadastro.. ");
            ImprimirMenuInicial();
        }
    }

    public static void CadastrarCliente(String nome) {

        System.out.println("Telefone 01:   ");
        String telefoneA = le.next();
        System.out.println("Telefone 02:   ");
        String telefoneB = le.next();
        Cliente cliente = new Cliente(codigoCliente, nome, telefoneA, telefoneB, CadastrarEndereco());
        Clientes.add(cliente);
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
    }

    public static Colaborador BuscarColaboradorPorCpf() {

        System.out.println("Digite o Cpf: ");
        String cpf = le.next().replaceAll("[ .-]", "");
        Colaborador colaborador = null;
        for (Colaborador c : Colaboradores) {
            if (c.getCpf().equals(cpf)) {
                colaborador = c;
            }
        }
        if (colaborador == null) {
            System.out.println(" Sem resultados. Verifique o cpf e tente novamente\n");
            BuscarColaboradorPorCpf();
        }
        System.out.println("Resultado: " + colaborador.getNome());
        return colaborador;
    }

    public static void DesligarColaborador() {

        Colaborador colaborador = BuscarColaboradorPorCpf();
        System.out.print("Digite a data de desligamento: ");
        String dataDesligamento = le.next();
        colaborador.setDataDesligamento(dataDesligamento);
        colaborador.setFuncionarioAtivo(false);
        System.out.print("Colaborador inativado com sucesso.\n");

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
            if (!c.isFuncionarioAtivo()) {
                System.out.println("Status: Desligado");
                System.out.print("Data de desligamento: " + c.getDataDesligamento() + "\n");
            } else {
                System.out.println("Status: Ativo \n");
            }
            System.out.println("\n============================================================\n");
        }
    }

    public static Cliente BuscarClientePorNome() {

        Cliente cliente = null;
        List<Cliente> clientesRetornados = new ArrayList<Cliente>();
        System.out.println("Digite o nome do cliente: ");
        String nome = le.next().replaceAll("[ .-]", "");
        nome = nome.trim();

        for (Cliente c : Clientes) {
            if (c.getNome().contains(nome)) {
                clientesRetornados.add(c);
            }
        }

        System.out.println("Verifique se o cliente esta na lista e digite o codigo, caso esteja: ");

        for (Cliente c : clientesRetornados) {
            System.out.print("Codigo: " + c.getCodigo() + " - Nome: " + c.getNome());
        }

        int codigo = le.nextInt();

        cliente = clientesRetornados.stream()
                .filter(x -> x.getCodigo() == codigo)
                .findFirst()
                .get();

        return cliente;
    }

    public static void AgendarCorridaProgramada() {

    }

    public static void AgendarCorridaImediata() {

    }

    public static Corrida BuscarCorrida() {

        Corrida corrida = null;

        return corrida;
    }

    private static void MudarStatusCorrida() {
        System.out.println("## Mudar status da corrida\n Definir status como: \n");
        System.out.println("\n 1 - Aguardando aviso");
        System.out.println("--------- Defina este status apenas se o algum motorista já tiver pego a corrifa mas o cliente ainda NÃO foi avisado.");
        System.out.println(" 2 - Aviso efetuado");
        System.out.println("--------- Defina este status apenas se o cliente já foi avisado mas ainda não foi atendido.");
        System.out.println(" 3 - Tripulado");
        System.out.println("--------- Defina este status apenas se o cliente já foi avisado e atendido.");
        System.out.println(" 4 - Cancelado pelo passageiro");
        System.out.println("--------- Defina este status apenas se a corrida foi cancelada pelo cliente.");
        System.out.println(" 5 - Cancelado pela cooperativa por falta de carro");
        System.out.println("--------- Defina este status apenas se a corrida foi cancelada pelo cooperativa.");

        byte resposta = le.nextByte();
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
