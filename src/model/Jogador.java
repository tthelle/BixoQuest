package model;

import java.util.ArrayList;
import java.util.List;

public class Jogador {
    private String nome;
    private int energia;
    private int conhecimento;
    private int motivacao;
    private int saude;
    private double dinheiro;
    private double desempenhoAcademico;
    private double andamentoCurso;
    private List<Disciplina> disciplinasAprovadas; //Lista de disciplinas qeu o jogador foi aprovado
    private List<Disciplina> disciplinasMatriculadas; // Lista de disciplinas que o jogador está matriculado no semestre
    //Construtor
    public Jogador(String nome) {
        this.nome = nome;
        this.energia = 100;
        this.conhecimento = 0;
        this.motivacao = 100;
        this.saude = 100;
        this.dinheiro = 50.0;
        this.desempenhoAcademico = 0.0;
        this.andamentoCurso = 0.0;
        this.disciplinasAprovadas = new ArrayList<>();
        this.disciplinasMatriculadas = new ArrayList<>();
    }
    //Getters e setters
    public String getNome() {
        return nome;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = Math.max(0, Math.min(100, energia));
    }

    public int getConhecimento() {
        return conhecimento;
    }

    public void setConhecimento(int conhecimento) {
        this.conhecimento = Math.max(0, Math.min(100, energia));
    }

    public int getMotivacao() {
        return motivacao;
    }

    public void setMotivacao(int motivacao) {
        this.motivacao = Math.max(0, Math.min(100, energia));
    }

    public int getSaude() {
        return saude;
    }

    public void setSaude(int saude) {
        this.saude = Math.max(0, Math.min(100, energia));
    }

    public double getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(double dinheiro) {
        this.dinheiro = dinheiro;
    }

    public double getDesempenhoAcademico() {
        return desempenhoAcademico;
    }

    public void setDesempenhoAcademico(int desempenhoAcademico) {
        this.desempenhoAcademico = desempenhoAcademico;
    }

    public double getAndamentoCurso() {
        return andamentoCurso;
    }

    public void setAndamentoCurso(double andamentoCurso) {
        this.andamentoCurso = Math.min(100.0, andamentoCurso);
    }

    public List<Disciplina> getDisciplinasAprovadas() {
        return disciplinasAprovadas;
    }

    public List<Disciplina> getDisciplinasMatriculadas() {
        return disciplinasMatriculadas;
    }

    //Verifica se o jogador foi aprovado em certa disciplina
    public void aprovarDisciplina(Disciplina disciplina){
        disciplina.setAprovado(true);
        if(!disciplinasAprovadas.contains(disciplina)){
            disciplinasAprovadas.add(disciplina);
            disciplinasMatriculadas.remove(disciplina);
        }
    }
    //Matricula um jogador
    public void matricularDisciplina(Disciplina disciplina){
        if(!disciplinasMatriculadas.contains(disciplina)){
            disciplinasMatriculadas.add(disciplina);
        }
    }

}