package repository;

import model.Evento;

public class EventoRepository {
    //Iniciaização de todos os eventos
    public static Evento encontrouAmigo() {
        return new Evento(
                "Encontrou um amigo",
                "Você encontrou um amigo pelo campus! Conversar animou seu dia.",
                0, +20, +10, 0, 4, 1.0
        );
    }

    public static Evento provaSurpresa() {
        return new Evento(
                "Prova Surpresa",
                "O professor resolveu aplicar uma prova sem avisar. Torça para ter estudado!",
                0, -15, -10, 0, 2, 1.0
        );
    }

    public static Evento milagreAcademico() {
        return new Evento(
                "Milagre Acadêmico",
                "A prova caiu exatamente o que você estudou! A sorte está do seu lado hoje.",
                0, +20, +5, 0, 1, 1.0
        );
    }

    public static Evento arCondicionadoQuebrado() {
        return new Evento(
                "Ar-condicionado quebrado",
                "O ar da sala resolveu parar bem hoje. Calor sufocante reduz sua motivação.",
                0, -15, -10, 0, 3, 1.0
        );
    }

    public static Evento materialCaro() {
        return new Evento(
                "Material Caro",
                "A disciplina exige um material caríssimo que você não tem. Lá vai o dinheiro...",
                0, -5, 0, +5, 2, 1.0
        );
    }

    public static Evento bugNoCodigo() {
        return new Evento(
                "Bug no Código",
                "Você passou horas caçando um bug impossível... mas no fim aprendeu muito.",
                -10, -10, -15, +20, 3, 1.0
        );
    }

    public static Evento filaGigante() {
        return new Evento(
                "Fila Gigante",
                "A fila do bandejão hoje está enorme. Você esperou tanto que ficou esgotado.",
                0, -5, -15, 0, 4, 1.0
        );
    }
    public static Evento encontrouAnimal() {
        return new Evento(
                "Encontrou um animal",
                "Você encontrou um animalzinho fofo! Fazer carinho nele te deixa motivado!",
                0, +5, 0, 0, 1, 1.0
        );
    }
    //Determinação do array de eventos por local
    public static Evento[] eventosBandejao(){
        return new Evento[]{
                filaGigante(),encontrouAmigo(), encontrouAnimal()
        };
    }

    public static Evento[] eventosBiblioteca(){
        return new Evento[]{
                encontrouAmigo(), encontrouAnimal()
        };
    }

    public static Evento[] eventosLaboratorio(){
        return new Evento[]{
                encontrouAmigo(), bugNoCodigo(), arCondicionadoQuebrado()
        };
    }

    public static Evento[] eventosSaladeAula(){
        return new Evento[]{
                materialCaro(), milagreAcademico(), arCondicionadoQuebrado()
        };
    }

    public static Evento[] eventosCantina(){
        return new Evento[]{
                filaGigante(),encontrouAmigo(), encontrouAnimal()
        };
    }

    public static Evento[] eventosAreaVerde(){
        return new Evento[]{
                encontrouAmigo(), encontrouAnimal()
        };
    }
}
