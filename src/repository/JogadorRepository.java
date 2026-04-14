package repository;

import model.Jogador;

public class JogadorRepository {
    private Jogador jogador; //Instância do jogador na sessão atual
    //Salava a sessão atual do jogador
    public void salvar(Jogador jogador){
        this.jogador = jogador;
    }

    //Será usado no Controller, para buscar o jogador
    public Jogador buscar(){
        return jogador;
    }
}
