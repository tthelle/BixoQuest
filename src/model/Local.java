package model;

public class Local {
    protected String nome;
    protected Evento[] eventos; //Eventos que podem acontecer no local
    protected TipoLocal tipo;
    protected Maeli maeli; //Só existe no colegiado

    //Todos os tipos de locais disponiveis no mapa
    public enum TipoLocal {BANDEJAO, CANTINA, AREA_VERDE, COLEGIADO, SALA_DE_AULA, LABORATORIO, PONTO_DE_ONIBUS, BIBLIOTECA}

    //Construtor
    public Local(String nome, Evento[] eventos, TipoLocal tipo) {
        this.nome = nome;
        this.tipo = tipo;
        this.eventos = eventos;
    }

    //Getters e setters
    public Evento[] getEventos() {
        return eventos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEventos(Evento[] eventos) {
        this.eventos = eventos;
    }

    public TipoLocal getTipo() {
        return tipo;
    }

    public void setTipo(TipoLocal tipo) {
        this.tipo = tipo;
    }

    public void setMaeli(Maeli maeli) {
        this.maeli = maeli;
    }
}
