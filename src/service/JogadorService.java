package service;

import model.*;

public class JogadorService {

    public static boolean estudar(Jogador jogador, Mundo mundo){
        if (!mundo.gastarAcao(Mundo.CUSTO_ESTUDAR)){
            return false;
        }

        int custoEnergia = 10;
        int ganhoConhecimento = 15;

        Evento clima = mundo.getClimaAtual();

        if(clima != null){
            if(mundo.getClimaAtual().getNome().equals("Semana de frio")){
                ganhoConhecimento += 10;
            } else if (mundo.getClimaAtual().getNome().equals("Semana de frio")){
                custoEnergia = (int)(custoEnergia * clima.getMultiplicadorEnergia());
            }
        }

        jogador.setEnergia(jogador.getEnergia() - custoEnergia);
        jogador.setConhecimento(jogador.getConhecimento() + ganhoConhecimento);

        return true;
    }

    public void pularTurno(Jogador jogador, Mundo mundo){
        mundo.setPontosAcao(0);
        jogador.setDesempenhoAcademico((int) (jogador.getDesempenhoAcademico() - 10));
    }

}
