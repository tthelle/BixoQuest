package service;

import model.Avaliacao;
import model.Jogador;
import model.Mundo;

import java.util.Random;

public class AvaliacaoService {
    private Random random = new Random(); //Gera números aleatórios para a estratégia "Chutar"
    //Determina a dificuldade da prova baseado no conhecimento do jogador
    public Avaliacao.Dificuldade calcularDificuldade(Avaliacao avaliacao, Jogador jogador){
        int conhecimento = jogador.getConhecimento();
        int base = avaliacao.getConhecimentoBase();


        if (conhecimento >= base){
            return Avaliacao.Dificuldade.FACIL;
        } else if (conhecimento <= base){
            return Avaliacao.Dificuldade.DIFICIL;
        } else if (conhecimento == base){
            return Avaliacao.Dificuldade.MEDIA;
        }
        return Avaliacao.Dificuldade.MEDIA;
    }
    //Realiza a prova, calcula a dificuldade e define a estratégia
    public double realizarProva(Avaliacao avaliacao, Jogador jogador, Avaliacao.Estrategia estrategia, Mundo mundo){
        avaliacao.setDificuldade(calcularDificuldade(avaliacao, jogador));
        avaliacao.setEstrategia(estrategia);

        double nota = calcularNotaBase(avaliacao, jogador);

        switch(estrategia){
            case DAR_TUDO:
                nota = Math.min(10.0, nota + 1.5);
                jogador.setEnergia(jogador.getEnergia() - 25);
                jogador.setSaude(jogador.getSaude() - 15);
                break;
            case CALMA:
                jogador.setEnergia(jogador.getEnergia() - 10);
                break;
            case CHUTAR:
                nota = notaAleatoria();
                break;
        }
        //Evento "Deu branco" aplicado com a saúde muito baixa
        if (jogador.getSaude() < 30){
            double perda = nota * 0.3;
            nota = Math.max(0, nota - perda);
        }
        //Maior gasto de energia dependendo do clima
        if (mundo.getClimaAtual() != null && mundo.getClimaAtual().getMultiplicadorEnergia() > 1.0){
            jogador.setEnergia(jogador.getEnergia() - 5);
        }

        avaliacao.setNota(nota);

        atualizarDesempenho(jogador, nota);
        return nota;
    }
    //Calcula a nota dependendo apenas da dificuldade
    private double calcularNotaBase(Avaliacao avaliacao, Jogador jogador){
        int conhecimento = jogador.getConhecimento();
        int base = avaliacao.getConhecimentoBase();
        double razao = (double) conhecimento / Math.max(1, base);

        switch(avaliacao.getDificuldade()){
            case FACIL:
                return Math.min(10.0, 6.0 + razao * 5.0);
            case MEDIA:
                return Math.min(10.0, 4.0 + razao * 5.0);
            case DIFICIL:
                return Math.min(10.0, 1.0 + razao * 4.0);
            default:
                return 5.0;
        }
    }
    //Retorna uma nota aleatória entre 0 1 10 para a estratégia "Chutar"
    private int notaAleatoria(){
        return random.nextInt(11);
    }
    //Atualiza o desempenho acadêmico do jogador após o resultado da prova
    private void atualizarDesempenho(Jogador jogador, double nota){
        int alteracao = 0;
        if (nota >= 7){
            alteracao = 10;
        } else {
            alteracao = -5;
        }

        jogador.setDesempenhoAcademico((int) (jogador.getDesempenhoAcademico() + alteracao));
        if (nota >= 7.0){
            jogador.setAndamentoCurso(jogador.getAndamentoCurso() + (100.0/24));
        }
    }

}
