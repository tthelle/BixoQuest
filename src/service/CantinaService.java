package service;

import model.Jogador;
import model.Mundo;

public class CantinaService {
    //Compra um energetico
    public boolean energetico(Jogador jogador, Mundo mundo){
        if (!mundo.gastarAcao(Mundo.CUSTO_CANTINA)){
            return false;
        }
        if(jogador.getDinheiro() < 5){
            return false;
        }
        jogador.setEnergia(jogador.getEnergia() + 20);
        jogador.setSaude(jogador.getSaude() - 10);
        jogador.setDinheiro(jogador.getDinheiro() - 5);
        return true;
    }
    //Compra um almoço
    public boolean almoco(Jogador jogador, Mundo mundo){
        if (!mundo.gastarAcao(Mundo.CUSTO_CANTINA)){
            return false;
        }
        if(jogador.getDinheiro() < 15){
            return false;
        }
        jogador.setEnergia(jogador.getEnergia() + 15);
        jogador.setSaude(jogador.getSaude() + 5);
        jogador.setDinheiro(jogador.getDinheiro() - 15);
        return true;
    }
    //Compra um lanche com suco
    public boolean lancheSuco(Jogador jogador, Mundo mundo){
        if (!mundo.gastarAcao(Mundo.CUSTO_CANTINA)){
            return false;
        }
        if(jogador.getDinheiro() < 10){
            return false;
        }
        jogador.setEnergia(jogador.getEnergia() + 10);
        jogador.setSaude(jogador.getSaude() - 5);
        jogador.setDinheiro(jogador.getDinheiro() - 10);
        return true;
    }
    //Compra um doce
    public boolean doce(Jogador jogador, Mundo mundo){
        if (!mundo.gastarAcao(Mundo.CUSTO_CANTINA)){
            return false;
        }
        if(jogador.getDinheiro() < 5){
            return false;
        }
        jogador.setEnergia(jogador.getEnergia() + 5);
        jogador.setSaude(jogador.getSaude() - 5);
        jogador.setDinheiro(jogador.getDinheiro() - 5);
        return true;
    }


}
