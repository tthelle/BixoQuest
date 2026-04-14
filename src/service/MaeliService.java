package service;

import model.Disciplina;
import model.Jogador;
import model.Maeli;
import model.Mundo;

import java.util.ArrayList;
import java.util.List;

public class MaeliService {
    //Service de Disciplinas usado nos métodos de matrícula
    private final DisciplinaService disciplinaService = new DisciplinaService();
    //Ação de conversar com Maeli
    public boolean conversar(Jogador jogador, Mundo mundo){
        if (!mundo.gastarAcao(Mundo.CUSTO_MAELI)){
            return false;
        }

        jogador.setMotivacao(jogador.getMotivacao() + 10);
        return true;
    }
    //Matricula o jogador nas matérias disponíveis
    public boolean matricular(Disciplina disciplina, Jogador jogador, Mundo mundo){
        return disciplinaService.matricular(disciplina, jogador, mundo);
    }
    //Jogador desiste do curso e encerra o jogo
    public void desistirCurso(Jogador jogador, Mundo mundo){
        jogador.setAndamentoCurso(-1);
        mundo.setPontosAcao(0);
    }
    //Retorna a lista de disciplinas disponíveis para matrícula
    public List<Disciplina> disciplinasDisponiveis(Jogador jogador, Mundo mundo){
        if(mundo.getSemana() == 1){
            return disciplinaService.disponiveisMatricular(jogador, mundo);
        }
        return new ArrayList<>();
    }
    //Executa a ação escolhida pelo jogador com base no enum de ações de Maeli
    public boolean executarAcao(Maeli.Acoes acao, Jogador jogador, Mundo mundo, Disciplina disciplina){
        switch (acao){
            case CONVERSAR:
                return conversar(jogador, mundo);
            case MATRICULAR_DISCIPLINA:
                return matricular(disciplina, jogador, mundo);
            case TRANCAR_CURSO:
                desistirCurso(jogador, mundo);
                return true;
            default: return false;
        }
    }
}
