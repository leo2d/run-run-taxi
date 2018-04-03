package run.run.taxi;

public class Endereco {

    private String logradouro;
    private String bairro;
    private String complemento;
    private String cep;
    private int numero;
    private String estado;

    public Endereco(String logradouro, String bairro, String complemento, String cep, int numero, String estado, String cidade) {
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.complemento = complemento;
        this.cep = cep;
        this.numero = numero;
        this.estado = estado;
        this.cidade = cidade;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getCidade() {
        return cidade;
    }
    private String cidade;

    public Endereco() {
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCep() {
        return cep;
    }

    public int getNumero() {
        return numero;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

}
