package run.run.taxi;

import java.util.Date;

class Cnh {

    private char categoria;
    private int numero;
    private Date validade;

    public Cnh(char categoria, int numero, Date validade) {
        this.categoria = categoria;
        this.numero = numero;
        this.validade = validade;
    }

    public char getCategoria() {
        return categoria;
    }

    public int getNumero() {
        return numero;
    }

    public Date getValidade() {
        return validade;
    }

    public void setCategoria(char categoria) {
        this.categoria = categoria;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

}
