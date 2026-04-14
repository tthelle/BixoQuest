package model;

public class Avaliacao {
    private String nome;
    private Disciplina disciplina;
    private int conhecimentoBase;
    private double nota;
    private Dificuldade dificuldade;//Dificuldade da prova
    private Estrategia estrategia;//Estrategia usada na prova
    //Dificuldades das avaliacao e possíveis estrategias para utilizar na avaliacao
    public enum Dificuldade { FACIL, MEDIA, DIFICIL }
    public enum Estrategia { DAR_TUDO, CALMA, CHUTAR }
    //Construtor
    public Avaliacao(String n, Disciplina d, int conheBase, Dificuldade difi) {
        this.nome = n;
        this.disciplina = d;
        this.conhecimentoBase = conheBase;
        this.nota = 0.0;
        this.dificuldade = difi;
        this.estrategia = Estrategia.CALMA;
    }
    //Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public int getConhecimentoBase() {
        return conhecimentoBase;
    }

    public void setConhecimentoBase(int conhecimentoBase) {
        this.conhecimentoBase = conhecimentoBase;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public Dificuldade getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(Dificuldade dificuldade) {
        this.dificuldade = dificuldade;
    }

    public Estrategia getEstrategia() {
        return estrategia;
    }

    public void setEstrategia(Estrategia estrategia) {
        this.estrategia = estrategia;
    }
}
