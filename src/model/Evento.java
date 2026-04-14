package model;

public class Evento {
    private String nome;
    private String descricao;
    private int peso; //menor = mais raro, maior = mais comum
    private int alterarSaude;
    private int alterarMotivacao;
    private int alterarEnergia;
    private int alterarConhecimento;
    private double multiplicadorEnergia; //Usado pela semana de calor, onde o gasto de energia é maior
    //Consrutor
    public Evento(String n, String d, int altSaude, int altMotiv, int altEner, int altCon, int peso, double multEnergia){
        this.nome = n;
        this.descricao = d;
        this.alterarEnergia = altEner;
        this.alterarMotivacao = altMotiv;
        this.alterarSaude = altSaude;
        this.alterarConhecimento = altCon;
        this.peso = peso;
        this.multiplicadorEnergia = multEnergia;
    }

    //Getters e Setters
    public int getPeso() {
        return peso;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getAlterarSaude() {
        return alterarSaude;
    }

    public int getAlterarMotivacao() {
        return alterarMotivacao;
    }

    public int getAlterarEnergia() {
        return alterarEnergia;
    }

    public int getAlterarConhecimento() {
        return alterarConhecimento;
    }

    public double getMultiplicadorEnergia() {
        return multiplicadorEnergia;
    }

    public void setMultiplicadorEnergia(double multiplicadorEnergia) {
        this.multiplicadorEnergia = multiplicadorEnergia;
    }
}
