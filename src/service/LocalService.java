package service;

import model.Jogador;
import model.Local;
import model.Mundo;

public class LocalService {
    private EventoService eventoService = new EventoService();

    public model.Evento visitarLocal(Jogador jogador, Mundo mundo, Local local){
        return eventoService.acontecerEvento(jogador, mundo, local);
    }

    public boolean estudar(Jogador jogador, Mundo mundo, Local local){
        if(local.getTipo() != Local.TipoLocal.BIBLIOTECA && local.getTipo() != Local.TipoLocal.LABORATORIO){
            return false;
        }
        return JogadorService.estudar(jogador, mundo);
    }
}
