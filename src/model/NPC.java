package model;

public class NPC {
    protected String nome;
    protected String[] frases;
    protected double probabilidadeAparecer;
    protected TipoNPC tipo; //Tipo do NPC
    //Todos os tipos de NPC
    public enum TipoNPC {AMIGO, GATO, CACHORRO, MAELI, PROFESSOR}
    //Construtor
    public NPC(String n, String[] f, double prob, TipoNPC t) {
        this.frases = f;
        this.nome = n;
        this.tipo = t;
        this.probabilidadeAparecer = prob;
    }
    //Getters e setters
    public double getProbabilidadeAparecer() {
        return probabilidadeAparecer;
    }

    public void setProbabilidadeAparecer(double probabilidadeAparecer) {
        this.probabilidadeAparecer = probabilidadeAparecer;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String[] getFrases() {
        return frases;
    }

    public void setFrases(String[] frases) {
        this.frases = frases;
    }

    public TipoNPC getTipo() {
        return tipo;
    }
}
