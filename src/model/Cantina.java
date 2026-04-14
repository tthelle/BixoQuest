package model;

import static model.Local.TipoLocal.CANTINA;

public class Cantina extends Local {
    //Todos os lanches vendidos na cantina
    private final String[] lanches = {"ALMOCO", "ENERGETICO", "SALGADO_COM_SUCO", "DOCE"}; //Lista de lanches na ccantina
    //COnstrutor
    public Cantina(String nome, Evento[] eventos, TipoLocal tipo) {
        super(nome, eventos, CANTINA);
    }
    //Getter
    public String[] getLanches() {
        return lanches;
    }
}
