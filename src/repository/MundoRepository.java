package repository;

import model.*;

import java.util.Arrays;
import java.util.List;

public class MundoRepository {
    private Mundo mundo; //Instância do mundo
    //Construtor do mundo, populando ele com locais, disciplinas e NPCs
    public MundoRepository(){
        this.mundo = new Mundo();
        mundo.setLocais(construirLocais());
        mundo.setTodasDisciplinas(new DisciplinaRepository().todasDisciplinas());
        mundo.setNpcs(constuirNPCs());
    }
    //Retorna o mundo inicializado
    public Mundo getMundo() {
        return mundo;
    }
    //Cria todos os Locais do mapa do jogo, os associam aos seus eventos
    private List<Local> construirLocais(){
        Maeli maeli = new Maeli("Maeli", new String[]{"Bixo, não desanima não! O caminho é difícil, mas você chega lá!"}, 1.0);

        Local bandejao = new Local("Bandejão", EventoRepository.eventosBandejao(), Local.TipoLocal.BANDEJAO);
        Local biblioteca = new Local("Biblioteca", EventoRepository.eventosBiblioteca(), Local.TipoLocal.BIBLIOTECA);
        Local lab = new Local("Laboratório LESS", EventoRepository.eventosLaboratorio(), Local.TipoLocal.LABORATORIO);
        Local cantina = new Local("Cantina", EventoRepository.eventosCantina(), Local.TipoLocal.CANTINA);
        Local sala1 = new Local("Sala PAT 31", EventoRepository.eventosSaladeAula(), Local.TipoLocal.SALA_DE_AULA);
        Local sala2 = new Local("Sala PAT 32", EventoRepository.eventosSaladeAula(), Local.TipoLocal.SALA_DE_AULA);
        Local colegiado = new Local("Colegiado", new Evento[0], Local.TipoLocal.COLEGIADO);
        Local areaVerde = new Local("Área verde", EventoRepository.eventosAreaVerde(), Local.TipoLocal.AREA_VERDE);
        Local pontoOnibus = new Local("Ponto de ônibus", new Evento[0], Local.TipoLocal.PONTO_DE_ONIBUS);

        colegiado.setMaeli(maeli);

        return Arrays.asList(cantina,bandejao,areaVerde,sala1, sala2, lab, biblioteca);
    }
    //Cria todos os NPCs do jogo
    private List<NPC> constuirNPCs(){
        NPC gato = new NPC("Rosa", new String[]{"*ronrona para você*", "Olhinhos brilhando", "Balança o rabo"}, 0.40, NPC.TipoNPC.GATO);
        NPC cachorro = new NPC("Bolinha", new String[]{"Late amigavelmente", "Olhinhos brilhando", "Passa pelas suas pernas", "Balança o rabo"}, 0.40, NPC.TipoNPC.CACHORRO);
        NPC amgJulia = new NPC("Júlia", new String[]{"Amiga, vamos almoçar?", "OI!!! Que saudades de você *abraça*", "Nossa, as matérias desse semestre são complicadas né?", "Aguenta firme viu! Vai dar tudo certo."}, 0.40, NPC.TipoNPC.AMIGO);
        NPC amgDaniel = new NPC("Daniel", new String[]{"Eita fome do diabo.", "E aí? Como vão as coisa?", "Tô estudando demais, mas vai valer a pena", "Aguenta firme viu! Vai dar tudo certo."}, 0.40, NPC.TipoNPC.AMIGO);
        NPC profEuclides = new NPC("Euclides", new String[]{"Você já leu o manual?"}, 0.4, NPC.TipoNPC.PROFESSOR);
        NPC profVanessa = new NPC("Vanessa", new String[]{"Que bom ver você, eh..., hm... Como é seu nome mesmo?"}, 0.4, NPC.TipoNPC.PROFESSOR);
        NPC profJuliana = new NPC("Juliana", new String[]{"Sempre que tiver uma dúvida pode tirar ela comigo!"}, 0.4, NPC.TipoNPC.PROFESSOR);

        return Arrays.asList(gato,cachorro,amgJulia,amgDaniel,profEuclides, profVanessa, profJuliana);
    }
}
