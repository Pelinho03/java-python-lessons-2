package rentcarlda;

import java.util.Date;

public class Aluguer {

    private Automovel automovel;
    private Cliente cliente;
    private Date dataInicio;
    private Date dataFim;

    //construtor
    public Aluguer(Automovel automovel, Cliente cliente, Date dataInicio, Date dataFim) {
        this.automovel = automovel;
        this.cliente = cliente;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    //getters e setters
    public Automovel getAutomovel() {
        return automovel;
    }

    public void setAutomovel(Automovel automovel) {
        this.automovel = automovel;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }
    //fim dos getters e setters

    //calcula o custo total do aluguer
    public double calcularCusto() {
        long diferencaDias = (dataFim.getTime() - dataInicio.getTime()) / (1000 * 60 * 60 * 24);
        return automovel.calcularCusto((int) diferencaDias);
    }
}
