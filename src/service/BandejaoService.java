package service;

import model.Jogador;
import model.Mundo;

public class BandejaoService {
    //Compra um almoço no bandejao
    public boolean almoco(Jogador jogador, Mundo mundo){
        if(!mundo.gastarAcao(Mundo.CUSTO_BANDEJAO)){
            return false;
        }
        if(jogador.getDinheiro() < 2){
            return false;
        }
        jogador.setDinheiro(jogador.getDinheiro() -2);
        jogador.setEnergia(jogador.getEnergia() +20);
        jogador.setSaude(jogador.getSaude() + 10);
        return true;
    }
}
