package service;

import model.Disciplina;
import model.Jogador;
import model.Mundo;

import java.util.ArrayList;
import java.util.List;

public class DisciplinaService {
    /*Verifica se o jogador pode se matricular em uma disciplina se ele anda não foi
     aprovado nela ou cumpriu os pré-requisitos*/
    public boolean possivelCursar(Disciplina disciplina, Jogador jogador){
        if (disciplina.isAprovado()) { return false; }
        if (jogador.getConhecimento() < disciplina.getConhecimentoNecessario()){ return false;}

        if (disciplina.getPreRequisitos() != null){
            for(Disciplina pre : disciplina.getPreRequisitos()){
                if (!pre.isAprovado()){
                    return false;
                }
            }
        }

        return true;
    }
    //Lista de disciplinas disponíveis para matricula
    public List<Disciplina> disponiveisMatricular(Jogador jogador, Mundo mundo){
        List<Disciplina> disponiveis = new ArrayList<>();
        for (Disciplina d : mundo.getDisciplinasSemestreAtual()){
            if(!jogador.getDisciplinasMatriculadas().contains(d) && possivelCursar(d, jogador)){
                disponiveis.add(d);
            }
        }
        return disponiveis;
    }
    //Matricula o jogador em uma disciplina. Ele só pode se matricular no primeiro semestre
    public boolean matricular(Disciplina disciplina, Jogador jogador, Mundo mundo){
        if (mundo.getSemana() != 1){
            return false;
        }
        if (!mundo.gastarAcao(Mundo.CUSTO_MAELI)){
            return false;
        }
        if(!possivelCursar(disciplina, jogador)){
            return false;
        }
        jogador.matricularDisciplina(disciplina);
        return true;
    }
    //Registra a presença na aula, disponível apenas na sala de aula
    public boolean assistirAula(Disciplina disciplina, Jogador jogador, Mundo mundo){
        if (!mundo.gastarAcao(Mundo.CUSTO_ASSISTIR_AULA)){
            return false;
        }
        if(!jogador.getDisciplinasMatriculadas().contains(disciplina)){
            return false;
        }
        if (disciplina.getAulasAssistidas() >= disciplina.TOTAL_AULAS){
            return false;
        }
        disciplina.assistirAula();
        int ganho = disciplina.getConhecimentoNecessario() / disciplina.TOTAL_AULAS;
        jogador.setConhecimento(jogador.getConhecimento() + ganho);
        jogador.setEnergia(jogador.getEnergia() - 10);
        return true;
    }
    //Aplica penalidade por faltas em uma disciplina
    public void penalidadeFaltas(Disciplina disciplina, Jogador jogador){
        int faltas = disciplina.getFaltas();
        if (faltas > 0){
            jogador.setConhecimento(jogador.getConhecimento() - faltas * 5);
        }
    }
    //Encerra o semestre aplicando a penalidade por faltas em todas as disciplinas
    public void fimDeSemestre(Jogador jogador){
        for (Disciplina d : jogador.getDisciplinasMatriculadas()){
            penalidadeFaltas(d, jogador);
        }
    }
}
