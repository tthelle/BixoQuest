package model;

public class Disciplina {
    private String nome;
    private int semestreReferente;
    private int conhecimentoNecessario;
    private Disciplina[] preRequisitos; //Disciplinas que precisam ser aprovadas antes de cursar
    private boolean aprovado;
    private int aulasAssistidas;
    public static final int TOTAL_AULAS = 2; //Total de aulas por semestre
    private double notaProva1;
    private double notaProva2;
    public int faltas;
    //Construtor
    public Disciplina(String n, int semReferente, int conNece, Disciplina[] preRequisitos) {
        this.nome = n;
        this.semestreReferente = semReferente;
        this.conhecimentoNecessario = conNece;
        this.preRequisitos = preRequisitos;
        this.aprovado = false;
        this.aulasAssistidas = 0;
        this.notaProva1 = 0;
        this.notaProva2 = 0;
        this.faltas = 0;
    }
    //Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getSemestreReferente() {
        return semestreReferente;
    }

    public void setSemestreReferente(int semestreReferente) {
        this.semestreReferente = semestreReferente;
    }

    public int getConhecimentoNecessario() {
        return conhecimentoNecessario;
    }

    public void setConhecimentoNecessario(int conhecimentoNecessario) {
        this.conhecimentoNecessario = conhecimentoNecessario;
    }

    public Disciplina[] getPreRequisitos() {
        return preRequisitos;
    }

    public void setPreRequisitos(Disciplina[] preRequisitos) {
        this.preRequisitos = preRequisitos;
    }

    public boolean isAprovado() {
        return aprovado;
    }

    public void setAprovado(boolean aprovado) {
        this.aprovado = aprovado;
    }

    public int getAulasAssistidas() {
        return aulasAssistidas;
    }

    public void setAulasAssistidas(int aulasAssistidas) {
        this.aulasAssistidas = aulasAssistidas;
    }

    public double getNotaProva1() {
        return notaProva1;
    }

    public double getNotaProva2() {
        return notaProva2;
    }

    public int getFaltas() {
        return TOTAL_AULAS - this.aulasAssistidas;
    }
    //Registra a ida para uma aula
    public void assistirAula() {
        if (aulasAssistidas < TOTAL_AULAS) {
            aulasAssistidas++;
        }
    }

    public void registrarNota(int numeroProva, double nota){
        if (numeroProva == 1){
            notaProva1 = nota;
        } else {
            notaProva2 = nota;
        }
    }
    //Calcula a media na disciplina pela nota das provas
    public double getMedia(){
        return (notaProva1 + notaProva2) / 2.0;
    }
    //Calcula aprovação na disciplina
    public boolean calcularAprovacao(){
        if (getMedia() >= 7.0) {
            this.aprovado = true;
        }
        return this.aprovado;
    }
    //Calcula quantas aulas foram perdidas no semestre
    public void resetarFrequencia(){
        this.aulasAssistidas = 0;
        this.aprovado = false;
        this.notaProva2 = 0;
        this.notaProva1 = 0;
    }
}
