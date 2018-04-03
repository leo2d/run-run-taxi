
package run.run.taxi;

import java.lang.Enum;

public class Corrida {
    
    private Endereco enderecoSaida;
    private String  telefoneContato;
    private String bairroDestino;
    private String dataSaida;
    private String horaSaida;
    private Cliente cliente;
    private Colaborador colaborador;
    private String status;

    public Corrida(Endereco enderecoSaida, String telefoneContato, String bairroDestino, String dataSaida, String horaSaida, Cliente cliente, String status) {
        this.enderecoSaida = enderecoSaida;
        this.telefoneContato = telefoneContato;
        this.bairroDestino = bairroDestino;
        this.dataSaida = dataSaida;
        this.horaSaida = horaSaida;
        this.cliente = cliente;
        this.status = status;
}
    
    public Endereco getEnderecoSaida() {
        return enderecoSaida;
    }

    public void setEnderecoSaida(Endereco enderecoSaida) {
        this.enderecoSaida = enderecoSaida;
    }

    public String getTelefoneContato() {
        return telefoneContato;
    }

    public void setTelefoneContato(String telefoneContato) {
        this.telefoneContato = telefoneContato;
    }

    public String getBairroDestino() {
        return bairroDestino;
    }

    public void setBairroDestino(String bairroDestino) {
        this.bairroDestino = bairroDestino;
    }

    public String getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(String dataSaida) {
        this.dataSaida = dataSaida;
    }

    public String getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(String horaSaida) {
        this.horaSaida = horaSaida;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
 

}
