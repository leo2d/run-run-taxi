
package run.run.taxi;

import static java.lang.Integer.parseInt;
import java.util.Scanner;
import java.util.ArrayList;

public class RunRunTaxi {

    static ArrayList<Cliente> Clientes = new ArrayList<Cliente>();
    static Scanner le = new Scanner(System.in);
    public static void main(String[] args) {
       // System.out.println("aaaaaaah aaaah aaha");
       ImprimirMenuCadastro();
    }

    public static void ImprimirMenuCadastro() {
        System.out.println(" Nome: ");
        String nome = le.next();
        //int resp = parseInt(le.next());
       // if (resp == 1)
            CadastrarCliente(nome);
        
    }
    
    public static void CadastrarCliente(String nome)
    {
        Cliente cliente = new Cliente(nome);
        cliente.setEndereco(CadastrarEndereco());
        //CadastrarEndereco();
        Clientes.add(cliente);
        System.out.print(cliente.getNome() +"\n");
        System.out.print(cliente.getEndereco().getBairro());
    }
    public static Endereco CadastrarEndereco()
    {
        Endereco endereco = new Endereco();
        
        System.out.println(" Cep: ");
        endereco.setCep(le.next());
        
        System.out.println(" Numero: ");
        endereco.setNumero(parseInt(le.next()));
        
        System.out.println(" logradouro: ");
        endereco.setLogradouro(le.next());
        
        System.out.println(" Bairro: ");
        endereco.setBairro(le.next());
        
        System.out.println(" Complemento: ");
        endereco.setComplemento(le.next());
        
        
        
        return endereco;
    }
    
    

}
