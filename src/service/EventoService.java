package service;

import model.Evento;
import model.Jogador;
import model.Local;
import model.Mundo;

import java.util.Random;

public class EventoService {
    private Random random = new Random(); //Gerados de números aleatórios para sorteio de eventos
    //Tentar disparar um evento no local visitado pelo jogador
    public Evento acontecerEvento(Jogador jogador, Mundo mundo, Local local){

        double chanceBase = 0.3;

        if (mundo.getSemana() == 3){
            chanceBase = 0.5;
        }

        if (random.nextDouble() <= chanceBase){
            Evento sorteado = possibilidadeEvento(local.getEventos());
            if (sorteado != null){
                aplicarEfeitos(jogador, sorteado, mundo);
                return sorteado;
            }
        }

        return null;
    }
    //Sorteia um evento no array de eventos. Eventos com peso maior tem mais chance de ser sorteado;
    private Evento possibilidadeEvento(Evento[] eventos){ 
        if (eventos == null || eventos.length == 0) {
            return null;
        }

        int somaPesos = 0;

        for (Evento e : eventos){
          somaPesos += e.getPeso();
        }

        int numSorteio = random.nextInt(somaPesos);
        int acumulo = 0;

        for(Evento e : eventos){
            acumulo += e.getPeso();
            if (acumulo >= numSorteio){
                return e;
            }
        }

        return null;
    }
    //Aplica os efeitos do eventos nos atributos do jogador
    public void aplicarEfeitos(Jogador jogador, Evento evento, Mundo mundo){

        int gastoEnergia = evento.getAlterarEnergia();
        if (mundo.getClimaAtual() != null && gastoEnergia < 0){
            gastoEnergia = (int)(gastoEnergia * mundo.getClimaAtual().getMultiplicadorEnergia());
        }

        jogador.setEnergia(jogador.getEnergia() + gastoEnergia);
        jogador.setMotivacao(jogador.getMotivacao() + evento.getAlterarMotivacao());
        jogador.setSaude(jogador.getSaude() + evento.getAlterarSaude());
        jogador.setConhecimento(jogador.getConhecimento() + evento.getAlterarConhecimento());

        if (evento.getNome().equals("Material caro")){
            jogador.setDinheiro(jogador.getDinheiro() - 30);
        }
    }
}
