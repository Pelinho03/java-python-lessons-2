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

    //calcula o custo total do aluguer
    public double calcularCusto() {
        long diferencaDias = (dataFim.getTime() - dataInicio.getTime()) / (1000 * 60 * 60 * 24);
        return automovel.calcularCusto((int) diferencaDias);
    }
}
