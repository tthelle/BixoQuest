package model;

import java.io.Serializable;
import java.util.List;

public class EstadoJogo implements Serializable {
    //Todos os dados do jogo que precisam ser salvos
    private String nomeJog;
    private int energJog;
    private int conheJog;
    private int motivJog;
    private int saudeJog;
    private double dinJog;
    private double dAcademicoJog;
    private double andamentoCursoJog;
    private List<Disciplina> dAprovadasJog;
    private List<Disciplina> dMatriculadasJog;
    private int semanaMundo;
    private int semestreAtualMundo;
    private int pAcaoMundo;
    private Evento climaMundo;
    private boolean emGreveMundo;

    //Construtor

    public EstadoJogo(String nomeJog, int energJog, int conheJog, int motivJog, int saudeJog, double dinJog, double dAcademicoJog, double andamentoCursoJog, List<Disciplina> dAprovadasJog, List<Disciplina> dMatriculadasJog, int semanaMundo, int semestreAtualMundo, int pAcaoMundo, Evento climaMundo, boolean emGreveMundo) {
        this.nomeJog = nomeJog;
        this.energJog = energJog;
        this.conheJog = conheJog;
        this.motivJog = motivJog;
        this.saudeJog = saudeJog;
        this.dinJog = dinJog;
        this.dAcademicoJog = dAcademicoJog;
        this.andamentoCursoJog = andamentoCursoJog;
        this.dAprovadasJog = dAprovadasJog;
        this.dMatriculadasJog = dMatriculadasJog;
        this.semanaMundo = semanaMundo;
        this.semestreAtualMundo = semestreAtualMundo;
        this.pAcaoMundo = pAcaoMundo;
        this.climaMundo = climaMundo;
        this.emGreveMundo = emGreveMundo;
    }

    //Getters

    public String getNomeJog() {
        return nomeJog;
    }

    public int getEnergJog() {
        return energJog;
    }

    public int getConheJog() {
        return conheJog;
    }

    public int getMotivJog() {
        return motivJog;
    }

    public int getSaudeJog() {
        return saudeJog;
    }

    public double getDinJog() {
        return dinJog;
    }

    public double getdAcademicoJog() {
        return dAcademicoJog;
    }

    public double getAndamentoCursoJog() {
        return andamentoCursoJog;
    }

    public List<Disciplina> getdAprovadasJog() {
        return dAprovadasJog;
    }

    public List<Disciplina> getdMatriculadasJog() {
        return dMatriculadasJog;
    }

    public int getSemanaMundo() {
        return semanaMundo;
    }

    public int getSemestreAtualMundo() {
        return semestreAtualMundo;
    }

    public int getpAcaoMundo() {
        return pAcaoMundo;
    }

    public Evento getClimaMundo() {
        return climaMundo;
    }

    public boolean isEmGreveMundo() {
        return emGreveMundo;
    }
}

