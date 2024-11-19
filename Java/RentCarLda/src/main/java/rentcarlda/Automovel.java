package rentcarlda;

public class Automovel {

    private String marca;
    private String modelo;
    private String cor;
    private int anoAquisicao;
    private int cilindrada;
    private String matricula;
    private double valorDia;
    private boolean alugado;

    //construtor
    public Automovel(String marca, String modelo, String cor, int anoAquisicao, int cilindrada, String matricula, double valorDia, boolean alugado) {
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.anoAquisicao = anoAquisicao;
        this.cilindrada = cilindrada;
        this.matricula = matricula;
        this.valorDia = valorDia;
        this.alugado = alugado;
    }

    // getteres e setteres
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getAnoAquisicao() {
        return anoAquisicao;
    }

    public void setAnoAquisicao(int anoAquisicao) {
        this.anoAquisicao = anoAquisicao;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double getValorDia() {
        return valorDia;
    }

    public void setValorDia(double valorDia) {
        this.valorDia = valorDia;
    }
    //termina os getteres e setteres

    public boolean isAlugado() {
        return alugado;
    }

    public void setAlugado(boolean alugado) {
        this.alugado = alugado;
    }

    public double calcularCusto(int dias) {
        return dias * valorDia;
    }
}
