package run.run.taxi;

import java.util.Date;

class Cnh {

    private String categoria;
    private int numero;
    private String validade;

    public Cnh(String categoria, int numero, String validade) {
        this.categoria = categoria;
        this.numero = numero;
        this.validade = validade;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getNumero() {
        return numero;
    }

    public String getValidade() {
        return validade;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

}
