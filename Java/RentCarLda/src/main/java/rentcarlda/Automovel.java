package rentcarlda;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Automovel {

    private String marca;
    private String modelo;
    private String cor;
    private int anoAquisicao;
    private int cilindrada;
    private String matricula;
    private double valorDia;
    private List<Aluguer> alugueres; // Lista de alugueres

    // Construtor
    public Automovel(String marca, String modelo, String cor, int anoAquisicao, int cilindrada, String matricula, double valorDia, boolean alugado, List<Aluguer> alugueres) {
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.anoAquisicao = anoAquisicao;
        this.cilindrada = cilindrada;
        this.matricula = matricula;
        this.valorDia = valorDia;
        this.alugueres = (alugueres != null) ? alugueres : new ArrayList<>(); // Evita null
    }

    // Getters e Setters
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

    public List<Aluguer> getAlugueres() {
        return alugueres;
    }

    public void adicionarAluguer(Aluguer aluguer) {
        alugueres.add(aluguer);
    }

    // Verificar se o automóvel está disponível numa data específica
    public boolean estaDisponivel(Date dataInicio, Date dataFim) {
        for (Aluguer aluguer : alugueres) {
            Date inicio = aluguer.getDataInicio();
            Date fim = aluguer.getDataFim();

            if (!(dataFim.before(inicio) || dataInicio.after(fim))) {
                return false; // Está ocupado
            }
        }
        return true; // Está disponível
    }

    // Verificar se está alugado no momento
    public boolean isAlugado() {
        for (Aluguer aluguer : alugueres) {
            Date hoje = new Date();
            if (!(hoje.before(aluguer.getDataInicio()) || hoje.after(aluguer.getDataFim()))) {
                return true;
            }
        }
        return false;
    }

    // Calcular o custo do aluguer para um número de dias
    public double calcularCusto(int dias) {
        return dias * valorDia;
    }

    // Listar todos os alugueres
    public void listarAlugueres() {
        if (alugueres.isEmpty()) {
            System.out.println("Este automóvel não possui alugueres.");
            return;
        }
        for (Aluguer aluguer : alugueres) {
            System.out.println("Cliente: " + aluguer.getCliente().getNome()
                    + " | Data Início: " + aluguer.getDataInicio()
                    + " | Data Fim: " + aluguer.getDataFim());
        }
    }
}
