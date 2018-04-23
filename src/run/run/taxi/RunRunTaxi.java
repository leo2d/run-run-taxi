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
    static Scanner input = new Scanner(System.in);
    static int codigoCliente = 0;
    static int codigoCorrida = 0;

    public static void main(String[] args) {

        System.out.println("\n****************************************\n");
        System.out.println("\tBem vindo ao Run Run Taxi");
        System.out.println("\n****************************************\n \n");
        GerarDadosParaTestes();
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
                    System.out.println("Nome: ");
                    CadastrarCliente(input.nextLine().replaceAll("[.-]", "").trim());
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
        System.out.println(" 2 - Cadastrar corrida imediata");
        System.out.println(" 3 - Listar corridas");
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
                    CadastrarCorridaImediata();
                    ImprimirMenuCorrida();
                    break;
                case 3:
                    ImprimirCorridas();
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

    public static Cliente CadastrarCliente(String nome) {

        Cliente cliente = null;
        System.out.println(" ####Cadastro de clientes : \n");
        System.out.println(" Qual tipo de cadastro deseja fazer agora? ");
        System.out.println(" 1 - Completo ");
        System.out.println(" 2 - Rápido ");
        //System.out.println(" 3 - Sair para menu principal ");

        byte resposta = le.nextByte();
        le.nextLine();

        if (resposta == 1) {
            codigoCliente++;
            System.out.println("Telefone 01:   ");
            String telefoneA = le.next();
            System.out.println("Telefone 02:   ");
            String telefoneB = le.next();
            cliente = new Cliente(codigoCliente, nome, telefoneA, telefoneB, CadastrarEndereco());
            Clientes.add(cliente);
            System.out.println("Cadastro finalizado. ");
        } else if (resposta == 2) {
            codigoCliente++;
            cliente = new Cliente(codigoCliente, nome);
            Clientes.add(cliente);
            System.out.println(" Ok. Finalizando Cadastro.. ");
        } else {
            System.out.println("Opcao invalida! Tente novamente.\n");
            CadastrarCliente(nome);
        }

        return cliente;
    }

    public static void ImprimirClientes() {
        if (!Clientes.isEmpty()) {
            for (Cliente c : Clientes) {
                System.out.println("Código : " + c.getCodigo());
                System.out.println("Nome: " + c.getNome());

                if (c.getTelefoneA() != null) {
                    System.out.println("Telefone 01: " + c.getTelefoneA());
                }

                if (c.getEndereco() != null) {
                    System.out.println("Telefone 02: " + c.getTelefoneB());
                    System.out.println("Estado: " + c.getEndereco().getEstado());
                    System.out.println("Cidade: " + c.getEndereco().getCidade());
                    System.out.println("Cep: " + c.getEndereco().getCep());
                }
                if (c.getEndereco() != null) {
                    System.out.println("Bairro: " + c.getEndereco().getBairro());
                    System.out.println("Rua/Logradouro: " + c.getEndereco().getLogradouro());
                    System.out.println("Numero: " + c.getEndereco().getNumero());
                }

                System.out.println("\n============================================================\n");
            }
        } else {
            System.out.println("**Nenhum cliente cadastrado.\n");
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

        Colaborador colaborador = null;
        byte resposta = 0;
        boolean temp = true;
        while(temp){
            System.out.println("1 - Buscar colaborador por CPF");
            System.out.println("2 - Selecionar um colaborador da lista");
            resposta = le.nextByte();
        
            if(resposta == 1){
                colaborador = BuscarColaboradorPorCpf();
                temp = false; }
            else if(resposta == 2){
                colaborador = SelecionarMotorista();
                temp = false; }
            else
                System.out.println("Resposta invalida!");
        }
    
        System.out.println("Digite a data de desligamento: ");
        String dataDesligamento = le.next();
        colaborador.setDataDesligamento(dataDesligamento);
        colaborador.setFuncionarioAtivo(false);
        System.out.println("Colaborador inativado com sucesso.\n");

    }

    public static Colaborador SelecionarMotorista() {

        if (!Colaboradores.isEmpty()) {
            for (Colaborador c : Colaboradores) {
                if (c.isFuncionarioAtivo()) {
                    System.out.println("Nome: " + c.getNome());
                    System.out.println("Numero VR: " + c.getNumeroVR());
                    System.out.println("Telefone Movel: " + c.getTelefoneMovel());
                    System.out.println("Veiculo: " + c.getVeiculo().getModelo());
                    System.out.println("Cor do veiculo: " + c.getVeiculo().getCor());
                    System.out.println("\n----------- Selecionar este motorista? \t1 - Sim \t 2 - Nao\n");
                    byte resposta = le.nextByte();
                    if (resposta == 1)
                        return c;
                } 
                System.out.println("\n============================================================\n");
            }
        } else {
            System.out.println("**Nenhum colaborador Ativo cadastrado.\n");
        }

        return null;
    }

    public static void ImprimirColaboradores() {

        if (!Colaboradores.isEmpty()) {
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
                    System.out.println("Data de desligamento: " + c.getDataDesligamento() + "\n");
                } else 
                    System.out.println("Status: Ativo \n");
                System.out.println("Veiculo: " + c.getVeiculo().getModelo());
                System.out.println("Fabricante do veiculo: " + c.getVeiculo().getFabricante());
                System.out.println("Cor do veiculo: " + c.getVeiculo().getCor());
                System.out.println("Placa do veiculo: " + c.getVeiculo().getPlaca());
                System.out.println("\n============================================================\n");
            }
        } else {
            System.out.println("**Nenhum colaborador cadastrado.\n");
        }
    }

    public static Cliente BuscarClientePorNome(String nome) {

        Cliente cliente = null;
        List<Cliente> clientesRetornados = new ArrayList<Cliente>();
        for (Cliente c : Clientes) {
            if (c.getNome().contains(nome)) {
                clientesRetornados.add(c);
            }
        }

        if (!clientesRetornados.isEmpty()) {
            System.out.println("Verifique se o cliente esta na lista e digite o codigo, caso esteja: ");

            for (Cliente c : clientesRetornados) {
                System.out.print("Codigo: " + c.getCodigo() + " - Nome: " + c.getNome() + "\n");
            }

            int codigo = le.nextInt();

            cliente = clientesRetornados.stream()
                    .filter(x -> x.getCodigo() == codigo)
                    .findFirst()
                    .get();
        }

        return cliente;
    }

    private static void ImprimirCorridas() {

        for (Corrida c : Corridas) {
            System.out.println("Cliente: " + c.getCliente().getNome());
            System.out.println("Telefoine de contato: " + c.getTelefoneContato());
            System.out.println("Endereco de saida: ");
            System.out.println("    Bairro: " + c.getEnderecoSaida().getBairro());
            System.out.println("    Rua: " + c.getEnderecoSaida().getLogradouro());
            System.out.println("    Numero: " + c.getEnderecoSaida().getNumero());
            if (c.getDataSaida() != null)
                System.out.println("Data e horario de saida: " + c.getDataSaida() + " - " + c.getHoraSaida());
            if (c.getColaborador() != null)
                System.out.println("VR Motorista: " + c.getColaborador().getNumeroVR());
            
            System.out.println("Status: " + c.getStatus());

            if (!c.getStatus().contains("inalizad") && !c.getStatus().contains("ancelad")) {
                byte editar = 0;
                while (editar != 1 && editar != 2) {
                    System.out.println("\n####Corrida nao finalizada!\n####Deseja editar esta corrida?\n 1 - Sim \n 2 - Nao ");
                    editar = le.nextByte();
                    if (editar == 1) {
                        EditarCorrida(c);
                    } else {
                        continue;
                    }
                }
            }

            System.out.println("\n============================================================\n");
        }

    }

    public static void EditarCorrida(Corrida corrida) {
        System.out.println(" 1 - Cliente cancelou corrida");
        System.out.println(" 2 - Mudar motorista");
        // System.out.println(" 3 - Avisar o cliente");
        System.out.println(" 3 - Cliente ciente que o carro está a caminho");
        System.out.println(" 4 - Cliente foi pego pelo carro");
        System.out.println(" 5 - Cliente foi entregue ao destino");
        byte resposta = le.nextByte();
        if (resposta == 1) {
            corrida.setStatus("cancelado pelo passageiro");
        } else if (resposta == 3) {
            corrida.setStatus("aviso efetuado");
        } else if (resposta == 2) {
            System.out.println("Selecione o novo motorista:");
            corrida.setColaborador(SelecionarMotorista());
            corrida.setBairroDestino("aguardando aviso");
        }else if (resposta == 4) {
            corrida.setStatus("tripulado");
        }else if (resposta == 5) {
            corrida.setStatus("finalizada");
        }
        else {
            EditarCorrida(corrida);
        }
    }

    public static void AgendarCorridaProgramada() {

        System.out.println("\t Agendar corrida Programada ");
        System.out.println("_________________________________________\n");
        Cliente cliente;

        System.out.println("Nome do cliente: ");
        String nome;
        nome = input.nextLine().replaceAll("[.-]", "").trim();
        cliente = BuscarClientePorNome(nome);
        while (cliente == null) {
            System.out.println("Cliente não encontrado. Cadastre o cliente e tente novamente.\n");
            cliente = CadastrarCliente(nome);
        }

        System.out.println("Rua/Logradouro: ");
        String logradouro = le.next().trim();

        System.out.println("Numero: ");
        int numero = le.nextInt();

        String telefoneContato = null;
        Endereco endereco;
        if (cliente.getEndereco() != null) {

            if (!cliente.getEndereco().getLogradouro().equals(logradouro) | cliente.getEndereco().getNumero() == numero) {
                System.out.println("Endereços diferentes. Cadestre o endereco de saida para esta corrdia: ");
                endereco = CadastrarEndereco(logradouro, numero);

                System.out.println("Telefone Contato: ");
                telefoneContato = le.next();
                cliente.setTelefoneA(telefoneContato);
            } else {
                telefoneContato = cliente.getTelefoneA();
                endereco = cliente.getEndereco();
            }
        } else {
            System.out.println("Cliente não possui nenhum endereco cadastrado. Cadestre o endereco de saida para esta corrdia: ");
            endereco = CadastrarEndereco(logradouro, numero);
            cliente.setEndereco(endereco); //se ele nao tem nenhum cadastrado, entao ele recebe o enreco da primeira corrida

            if (empty(cliente.getTelefoneA()) && empty(cliente.getTelefoneB())) {
                System.out.println("Telefone Contato: ");
                telefoneContato = le.next();
                cliente.setTelefoneA(telefoneContato);
            } else {
                telefoneContato = cliente.getTelefoneA().isEmpty() ? cliente.getTelefoneB() : cliente.getTelefoneA();
            }
        }

        System.out.println("Digite a data de saida: ");
        String dataSaida = le.next();
        System.out.println("Digite o horario de saida: ");
        String horaSaida = le.next();
        System.out.println("Digite o bairro de destino: ");
        String bairroDestino = le.next();

        Corrida corrida = new Corrida(endereco, telefoneContato, bairroDestino, dataSaida, horaSaida, cliente, "aguardando VR");

        Corridas.add(corrida);

    }

    public static void CadastrarCorridaImediata() {

        System.out.println("\t Cadastrar corrida Imediata ");
        System.out.println("_________________________________________\n");
        Cliente cliente;

        System.out.println("***Dados de saida.");
        System.out.println("Rua/Logradouro: ");
        String logradouro = le.next().trim();

        System.out.println("Numero: ");
        int numero = le.nextInt();

        Endereco enderecoSaida = CadastrarEndereco(logradouro, numero);

        System.out.println("Digite o bairro de destino: ");
        String bairroDestino = le.next();

        System.out.println("Telefone Contato: ");
        String telefoneContato = le.next();

        System.out.println("Nome do cliente: ");
        String nome;
        nome = input.nextLine().replaceAll("[.-]", "").trim();
        cliente = BuscarClientePorNome(nome);
        while (cliente == null) {
            System.out.println("Cliente não encontrado. Cadastre o cliente e tente novamente.\n");
            cliente = CadastrarCliente(nome);
        }

        Corrida corrida = new Corrida(enderecoSaida, telefoneContato, bairroDestino, cliente, "aguardando VR");

        System.out.println("Selecionae o motorista que aceitar esta corrida:\n\t***SE NINGUEM ACEITAR, A CORRIDA SERÁ CANCELADA AUTOMATICAMENTE.\n");

        Colaborador colaborador;
        colaborador = SelecionarMotorista();
        if (colaborador != null) {
            corrida.setColaborador(colaborador);
            corrida.setStatus("aguardando aviso");
        } else {
            System.out.println("A corrida foi cancelada por falta de motorista.\n");
            corrida.setStatus("cancelado pela cooperativa por falta de carro");
        }
        Corridas.add(corrida);
    }

    public static Corrida BuscarCorrida() {

        Corrida corrida = null;

        return corrida;
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

        System.out.println("Bairro: ");
        endereco.setBairro(le.next().trim());

        System.out.println("Rua/Logradouro: ");
        endereco.setLogradouro(le.next().trim());

        System.out.println("Numero: ");
        endereco.setNumero(le.nextInt());

        System.out.println("Complemento: ");
        endereco.setComplemento(le.next());

        System.out.println("Cep: ");
        endereco.setCep(le.next());

        System.out.println("Cidade: ");
        endereco.setCidade(le.next());

        System.out.println("Estado: ");
        endereco.setEstado(le.next());

        return endereco;
    }

    public static Endereco CadastrarEndereco(String rua, int numero) {
        Endereco endereco = new Endereco();

        System.out.println("Rua/Logradouro: " + rua);
        endereco.setLogradouro(rua.trim());

        System.out.println("Numero: " + numero);
        endereco.setNumero(numero);

        System.out.println("Bairro: ");
        endereco.setBairro(le.next().trim());

        System.out.println("Complemento: ");
        endereco.setComplemento(le.next());

        return endereco;
    }

    public static boolean empty(final String s) {
        return s == null || s.trim().isEmpty();
    }

    private static void GerarDadosParaTestes() {
        Endereco enderecoCliente = new Endereco();
        enderecoCliente.setLogradouro("Rua25");
        enderecoCliente.setComplemento("2andar");
        enderecoCliente.setBairro("centro");
        enderecoCliente.setNumero(22);
        Endereco enderecoColaborador = new Endereco("ruaSAOJoao", "Bairro10",
                "PertoDoBar", "1231321", 444, "MG", "JF");

        Cliente c1 = new Cliente(999, "moises");
        Cliente c2 = new Cliente(998, "jubileu");
        c2.setEndereco(enderecoCliente);
        Cliente c3 = new Cliente(997, "alice");

        Clientes.add(c1);
        Clientes.add(c2);
        Clientes.add(c3);

        Veiculo v1 = new Veiculo("Versa", "Nissan", "preto", "APU2400G");
        Veiculo v2 = new Veiculo("Auto", "Tesla", "prata", "R72600X");
        Cnh a1 = new Cnh("B", 44, "15/26/2023");

        Colaborador m1 = new Colaborador("Joe", "617.017.450-11", 666, "400028922",
                "99999999", "10/04/2015", a1, v1, enderecoColaborador);
        Colaborador m2 = new Colaborador("Mary", "57517638742", 667, "400028922",
                "99999999", "23/02/2016", a1, v2, enderecoColaborador);

        Colaboradores.add(m1);
        Colaboradores.add(m2);
    }

}
