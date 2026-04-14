package model;

public class Maeli extends NPC{
    private Acoes[] acoes; //Lista de ações de Maeli
    public enum Acoes {CONVERSAR, MATRICULAR_DISCIPLINA, TRANCAR_CURSO} //Todas as ações de Maeli
    //Construtor
    public Maeli(String n, String[] f, double prob) {
        super(n, f, prob, TipoNPC.MAELI);
        this.acoes = new Acoes[]{Acoes.CONVERSAR, Acoes.MATRICULAR_DISCIPLINA, Acoes.TRANCAR_CURSO};
    }
    //Getters
    public Acoes[] getAcoes() {
        return acoes;
    }
}
