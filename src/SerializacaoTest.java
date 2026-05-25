import model.EstadoJogo;
import org.junit.jupiter.api.*;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SerializacaoTest {

    private static final String SAVES_DIR = "saves/";
    private Serializacao serializacao;
    private EstadoJogo estadoPadrao;

    //Cria um estado padrão para facilitar a realização dos testes
    @BeforeEach
    void padrao(){
        serializacao = new Serializacao();

        estadoPadrao = new EstadoJogo(
                "JogadorTeste", 100, 90, 80, 70, 100, 8.5, 10, List.of(), List.of(), 3, 1, 5, null, false
        );
    }

    //Remove os arquivos de saves criados após os testes. Pode ser utilizada ou não
    /*@AfterEach
    void limparArquivo(){
        for (int i = 0; i <= 10; i++){
            new File(SAVES_DIR + "save" + i).delete();
        }
    }*/

    @Test
    @Order(1)
    void verificarAtributosCriacao(){
        EstadoJogo teste = serializacao.criarJogo("Hellen");

        assertNotNull(teste);

        assertEquals(100, teste.getEnergJog());
        assertEquals(0, teste.getConheJog());
        assertEquals(100, teste.getMotivJog());
        assertEquals(100, teste.getSaudeJog());
        assertEquals(100, teste.getDinJog());
        assertEquals(0.0, teste.getdAcademicoJog());
        assertEquals(0.0, teste.getAndamentoCursoJog());
        assertEquals(1, teste.getSemanaMundo());
        assertEquals(1, teste.getSemestreAtualMundo());
        assertEquals(15, teste.getpAcaoMundo());
        assertFalse(teste.isEmGreveMundo());
    }

    @Test
    @Order(2)
    void criarArquivoAoSalvar(){
        serializacao.salvarJogo(estadoPadrao, 1);
        assertTrue(new File(SAVES_DIR + "save1").exists());
    }

    @Test
    @Order(3)
    void criarDiretorioSeNaoExistir(){
        File dir = new File(SAVES_DIR);
        if (dir.exists()){
            dir.delete();
        }
        serializacao.salvarJogo(estadoPadrao, 1);

        assertTrue(dir.exists());
    }

    @Test
    @Order(4)
    void retornarObjetoAoCarregar(){
        serializacao.salvarJogo(estadoPadrao, 1);
        EstadoJogo carregado = serializacao.carregarJogo(1);

        assertNotNull(carregado);
    }

    @Test
    @Order(5)
    void manterAtributosJogador(){
        serializacao.salvarJogo(estadoPadrao, 1);
        EstadoJogo carregado = serializacao.carregarJogo(1);

        assertEquals("JogadorTeste", carregado.getNomeJog());
        assertEquals(100, carregado.getEnergJog());
        assertEquals(90, carregado.getConheJog());
        assertEquals(80, carregado.getMotivJog());
        assertEquals(70, carregado.getSaudeJog());
        assertEquals(100, carregado.getDinJog());
        assertEquals(8.5, carregado.getdAcademicoJog());
        assertEquals(10, carregado.getAndamentoCursoJog());
    }

    @Test
    @Order(6)
    void manterEstadoMundo(){
        serializacao.salvarJogo(estadoPadrao, 1);
        EstadoJogo carregado = serializacao.carregarJogo(1);

        assertEquals(3, carregado.getSemanaMundo());
        assertEquals(1, carregado.getSemestreAtualMundo());
        assertEquals(5, carregado.getpAcaoMundo());
        assertFalse(carregado.isEmGreveMundo());
    }

    @Test
    @Order(7)
    void salvarOutroEstado(){
        EstadoJogo estado2 = new EstadoJogo(
                "JogadorTeste2", 100, 90, 80, 70, 100, 8.5, 10, List.of(), List.of(), 3, 1, 5, null, false
        );

        serializacao.salvarJogo(estadoPadrao, 1);
        serializacao.salvarJogo(estado2, 2);

        EstadoJogo carregado1 = serializacao.carregarJogo(1);
        EstadoJogo carregado2 = serializacao.carregarJogo(2);

        assertEquals("JogadorTeste", carregado1.getNomeJog());
        assertEquals("JogadorTeste2", carregado2.getNomeJog());
    }

    @Test
    @Order(8)
    void sobrescreverSave(){
        serializacao.salvarJogo(estadoPadrao, 1);

        EstadoJogo modificado = new EstadoJogo(
                "JogadorTeste", 35, 90, 80, 70, 100, 8.5, 10, List.of(), List.of(), 3, 1, 5, null, false
        );

        serializacao.salvarJogo(modificado, 1);
        EstadoJogo carregado = serializacao.carregarJogo(1);

        assertEquals(35, carregado.getEnergJog());
    }
}
