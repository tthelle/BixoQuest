package model;

import java.util.ArrayList;
import java.util.List;

public class Mundo {
    private int semana;
    private int semestreAtual;
    private int pontosAcao;
    private Evento climaAtual;
    private boolean emGreve;
    private List<Disciplina> todasDisciplinas; //Lista com todas as disciplinas
    private List<Local> locais; //Lista com todos os locais
    private List<NPC> npcs;//Lista com todos os npcs
    //Custo de pontos de ação de cada ação
    public static final int CUSTO_BANDEJAO = 1;
    public static final int CUSTO_PROVA = 3;
    public static final int CUSTO_CANTINA = 1;
    public static final int CUSTO_INTERAGIR_NPC = 1;
    public static final int CUSTO_ESTUDAR = 2;
    public static final int CUSTO_MAELI = 2;
    public static final int CUSTO_ASSISTIR_AULA = 2;
    //COnstrutor
    public Mundo(){
        this.semana = 1;
        this.semestreAtual = 1;
        this.pontosAcao = 20;
        this.emGreve = false;
        this.climaAtual = null;
        this.todasDisciplinas = new ArrayList<>();
        this.locais = new ArrayList<>();
        this.npcs = new ArrayList<>();
    }
    //Getters e Setters
    public int getSemana() {
        return semana;
    }

    public void setSemana(int semana) {
        this.semana = semana;
    }

    public int getSemestreAtual() {
        return semestreAtual;
    }

    public void setSemestre(int semestre) {
        this.semestreAtual = semestre;
    }

    public int getPontosAcao() {
        return pontosAcao;
    }

    public void setPontosAcao(int pontosAcao) {
        this.pontosAcao = pontosAcao;
    }

    public Evento getClimaAtual() {
        return climaAtual;
    }

    public void setClimaAtual(Evento climaAtual) {
        this.climaAtual = climaAtual;
    }

    public boolean isEmGreve() {
        return emGreve;
    }

    public void setEmGreve(boolean b) {
        this.emGreve = b;
    }

    public List<Disciplina> getTodasDisciplinas() {
        return todasDisciplinas;
    }

    public void setTodasDisciplinas(List<Disciplina> todasDisciplinas) {
        this.todasDisciplinas = todasDisciplinas;
    }

    public List<Local> getLocais() {
        return locais;
    }

    public void setLocais(List<Local> locais) {
        this.locais = locais;
    }

    public List<NPC> getNpcs() {
        return npcs;
    }

    public void setNpcs(List<NPC> npcs) {
        this.npcs = npcs;
    }
    //Lista das disciplinasdo semestre que o jogador não foi aprovado ainda
    public List<Disciplina> getDisciplinasSemestreAtual(){
        List<Disciplina> naoAprovadas = new ArrayList<>();
        for (Disciplina d : todasDisciplinas){
            if (d.getAulasAssistidas() <= semestreAtual &&!d.isAprovado()){
                naoAprovadas.add(d);
            }
        }
        return naoAprovadas;
    }
    //Desconta pontos de ação por ação
    public boolean gastarAcao(int custo){
        if (pontosAcao < custo){
            return false;
        }
        return true;
    }
}
