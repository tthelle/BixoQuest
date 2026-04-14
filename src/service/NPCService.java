package service;

import model.Jogador;
import model.Local;
import model.Mundo;
import model.NPC;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NPCService {
    private Random random = new Random(); //Gerador de números aleatórios para frases e sorteio de aparição
    //Retorna uma frase aleatoria do NPC
    public String fraseAleatoria(NPC npc){
        int randomNum = new Random().nextInt(npc.getFrases().length);
        String frase = npc.getFrases()[randomNum];
        return frase;
    }
    //Interação com os amigos. Falha se o NPC não for um animal
    public boolean interagirAmigo(Jogador jogador, NPC npc, Mundo mundo){
        if(npc.getTipo() != NPC.TipoNPC.AMIGO){
            return false;
        }
        if(!mundo.gastarAcao(Mundo.CUSTO_INTERAGIR_NPC)){
            return false;
        }
        jogador.setMotivacao(jogador.getMotivacao() + 15);
        jogador.setEnergia(jogador.getEnergia() + 5);
        return true;
    }
    //Interação com os animais. Falha se o NPC não for um animal
    public boolean interagirAnimal(Jogador jogador, NPC npc, Mundo mundo){
        if((npc.getTipo() != NPC.TipoNPC.GATO) && (npc.getTipo() != NPC.TipoNPC.CACHORRO)){
            return false;
        }
        if(!mundo.gastarAcao(Mundo.CUSTO_INTERAGIR_NPC)){
            return false;
        }
        jogador.setMotivacao(jogador.getMotivacao() + 15);
        return true;
    }

    //Interação com os professores. Falha se o NPC não for um professor
    public boolean interagirProfessor(Jogador jogador, NPC npc, Mundo mundo){
        if(npc.getTipo() != NPC.TipoNPC.PROFESSOR){
            return false;
        }
        if(!mundo.gastarAcao(Mundo.CUSTO_INTERAGIR_NPC)){
            return false;
        }
        jogador.setMotivacao(jogador.getMotivacao() + 5);
        return true;
    }
    //Sorteia quis NPCS vão aparecer no local
    public List<NPC> sortearNpcs(Mundo mundo, Local local){
        boolean isAreaVerde = false;
        if(local.getTipo() == Local.TipoLocal.AREA_VERDE) {
            isAreaVerde = true;
        }
        List<NPC> aparecem = new ArrayList<>();
        for (NPC npc : mundo.getNpcs()){
            double prob = npc.getProbabilidadeAparecer();
            if (isAreaVerde && npc.getTipo() == NPC.TipoNPC.AMIGO){
                prob = prob * 2.0;
            }
            if (random.nextDouble() < prob){
                aparecem.add(npc);
            }
        }
        return aparecem;
    }

}
