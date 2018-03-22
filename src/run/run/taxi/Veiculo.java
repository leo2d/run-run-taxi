package run.run.taxi;

public class Veiculo {

    private String modelo;
    private String fabricante;
    private String cor;
    private String placa;

    public Veiculo(String modelo, String fabricante, String cor, String placa) {
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.cor = cor;
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public String getCor() {
        return cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

}
