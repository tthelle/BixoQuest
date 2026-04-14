package service;

import model.Evento;
import model.Jogador;
import model.Mundo;

import java.util.Random;

public class MundoService {
    private Random random = new Random(); //Gera números aleatórios para os eventos climáticos
    // Avança o calendário para a próxima semana, processa turno  de greve, encerra o semestre e sorteia novo clima
    public void avancarCalendario(Jogador jogador, Mundo mundo){
        if (mundo.isEmGreve()){
            turnoGreve(jogador, mundo);
            verificarFimGreve(mundo);
            return;
        }

        if (mundo.getSemana() < 4){
            mundo.setSemana(mundo.getSemana() +1);
        } else {
            mundo.setSemana(1);
            climaSemana(mundo);
            mundo.setSemestre(mundo.getSemestreAtual() + 1);
        }

        aplicarMesada(jogador);
        verificarInicioGreve(mundo);

    }
    //Processa a passagem de semana no ponto de onibus e avança o calendário
    public boolean passarSemana(Jogador jogador, Mundo mundo){
        if (mundo.getPontosAcao() > 0){
            return false;
        }
        jogador.setEnergia(Math.min(100, jogador.getEnergia()) + 30);
        jogador.setEnergia(Math.min(100, jogador.getEnergia()) + 30);
        avancarCalendario(jogador,mundo);
        return true;
    }
    //Sorteia o clima da semana
    private void climaSemana(Mundo mundo){
        double random = Math.random();

        if (random <= 0.3){
            mundo.setClimaAtual(new Evento("Semana de Calor", "Está muito calor em Feira de Santana essa semana... Você vai gastar mais energia para realizar suas tarefas.", 0, 0, - 5, 0, 3, 2.0));
        } else if (random > 0.3 && random <= 0.4){
            mundo.setClimaAtual(new Evento("Semana de Frio", "Está muito frio em Feira de Santana essa semana... Você vai perder motivacao, mas o clima está propício ao estudo.", 0, - 10, - 5, 10, 3, 2.0));
        } else {
            mundo.setClimaAtual(null);
        }
    }
    //Processa o turno de greve
    private void turnoGreve(Jogador jogador, Mundo mundo) {
        jogador.setEnergia(jogador.getEnergia() + 20);
        jogador.setSaude(jogador.getSaude() + 20);
        mundo.setPontosAcao(1); // O jogador decide se vai estudar ou não
        mundo.setEmGreve(true);
    }
    //Possibilidade de uma greve começar
    private void verificarInicioGreve(Mundo mundo) {
        if (random.nextDouble() < 0.05) { // 5% de chance de greve começar
            mundo.setEmGreve(true);
        }
    }
    //Chance da greve terminar
    private void verificarFimGreve(Mundo mundo) {
        if (random.nextDouble() < 0.3) { // As aulas podem voltar em uma semana aleatória
            mundo.setEmGreve(false);
        }
    }
    //Aplica a mesada semanal do jogador
    private void aplicarMesada(Jogador jogador) {
        jogador.setDinheiro(jogador.getDinheiro() + 50);
    }
    //Verifica se o jogo chegou ao fim
    public String verificarFimDeJogo(Jogador jogador, Mundo mundo) {
        if (jogador.getAndamentoCurso() >= 100) {
            return "VITÓRIA";
        }

        if (mundo.getSemestreAtual() > 16 && jogador.getAndamentoCurso() < 100) {
            return"JUBILADO";
        }

        if (jogador.getSaude() <= 0 || jogador.getMotivacao() <= 0) {
            return "DERROTA";
        }

        return null;
    }

}
