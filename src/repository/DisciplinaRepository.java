package repository;

import model.Disciplina;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DisciplinaRepository {
    private final List<Disciplina> disciplinas; //Lista completa com todas as disciplinas do curso
    //Construtor do repositorio
    public DisciplinaRepository(){
        this.disciplinas = construirGrade();
    }
    //Retorna a lista com todasa sa disciplinas do curso
    public List<Disciplina> todasDisciplinas(){
        return disciplinas;
    }
    //Retorna as disciplinas de um semestre especifico
    public List<Disciplina> porsemestre(int semestre){
        List<Disciplina> porSemestre = new ArrayList<>();
        for(Disciplina d : disciplinas){
            if(d.getSemestreReferente() == semestre){
                porSemestre.add(d);
            }
        }
        return porSemestre;
    }
    //Constrói a grade curricular do curso
    private List<Disciplina> construirGrade() {
        Disciplina algProgI = new Disciplina("Algoritmos e programação I",1,0,null);
        Disciplina introEle = new Disciplina("Introdução à Eletrônica",1,0,null);
        Disciplina prodTex = new Disciplina("Produção de textos técnicos e Acadêmicos",1,0,null);

        Disciplina calculoI = new Disciplina("Cálculo I",2,0,null);
        Disciplina circDigit = new Disciplina("Circuitos Digitais",2, 10,  new Disciplina[]{introEle});
        Disciplina estrutDados = new Disciplina("Estrutura de Dados",2, 10,  new Disciplina[]{algProgI});

        Disciplina algProgII = new Disciplina("Algoritmos e programação II",3,20, new Disciplina[]{estrutDados});
        Disciplina calculoII = new Disciplina("Cálculo II",3, 20,  new Disciplina[]{calculoI});
        Disciplina fisI= new Disciplina("Física I",3, 20,  new Disciplina[]{calculoI});

        Disciplina arqComp = new Disciplina("Arquitetura de computadores",4,30, new Disciplina[]{circDigit});
        Disciplina sistDigi = new Disciplina("Sistemas Digitais",4,30, new Disciplina[]{circDigit});
        Disciplina sisOp= new Disciplina("Sistemas operacionais",4,30, new Disciplina[]{algProgII});

        Disciplina quimi = new Disciplina("Química",5,30, new Disciplina[]{calculoI});
        Disciplina redesComp = new Disciplina("Redes de computadores",5,40, new Disciplina[]{sisOp, sistDigi});
        Disciplina conConec = new Disciplina("Concorrencia e conectividade",5,40, new Disciplina[]{sisOp, algProgII});

        Disciplina bancoDados = new Disciplina("Banco de dados",6,50, new Disciplina[]{sisOp, estrutDados});
        Disciplina engSoft = new Disciplina("Engenharia de Software",6,50, new Disciplina[]{sisOp, estrutDados});
        Disciplina circEle = new Disciplina("Circuitos Elétricos",6,50, new Disciplina[]{conConec});

        Disciplina TCCI = new Disciplina("TCCI",7,60, new Disciplina[]{prodTex});
        Disciplina sinSis = new Disciplina("Sinais e sistemas",7,60, new Disciplina[]{calculoII, circEle});
        Disciplina eleGeral = new Disciplina("Eletrônica Geral",7,60, new Disciplina[]{fisI,sistDigi, calculoII});

        Disciplina proDigi = new Disciplina("Processamento Digital",8,70, new Disciplina[]{estrutDados, calculoII, circEle, sinSis});
        Disciplina comp = new Disciplina("Linguagem geral e Compiladores",8,70, new Disciplina[]{algProgII, sisOp, sistDigi});
        Disciplina TCCII = new Disciplina("TCCI",8,70, new Disciplina[]{TCCI});

        return Arrays.asList(
                calculoI, circDigit, estrutDados, algProgII, algProgI, calculoII, fisI, arqComp, sisOp, sistDigi, quimi, redesComp, conConec, bancoDados, engSoft, circEle, TCCII, TCCI, sinSis, eleGeral, proDigi, comp
        );
    }
}
