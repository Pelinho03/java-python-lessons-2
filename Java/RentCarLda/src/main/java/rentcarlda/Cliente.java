package rentcarlda;

public class Cliente {

    private String nome;
    private String morada;
    private String cc;
    private String cartaConducao;

    //construtor
    public Cliente(String nome, String morada, String cc, String cartaConducao) {
        this.nome = nome;
        this.morada = morada;
        this.cc = cc;
        this.cartaConducao = cartaConducao;
    }

    //getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getCartaConducao() {
        return cartaConducao;
    }

    public void setCartaConducao(String cartaConducao) {
        this.cartaConducao = cartaConducao;
    }
    //termina os getteres e setteres

    @Override
    public String toString() {
        return "Cliente: " + nome + ", CC: " + cc + ", Morada: " + morada + ", Carta Condução: " + cartaConducao;
    }

}
