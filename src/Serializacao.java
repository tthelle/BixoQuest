import model.EstadoJogo;

import java.io.*;
import java.util.ArrayList;

public class Serializacao {
    //Diretório onde os arquivos do jogo serão salvos
    private final String SAVES = "saves/";

    //Cria um novo jogo
    public EstadoJogo criarJogo(String nomeJogador){
        return new EstadoJogo(
                nomeJogador, 100, 0, 100, 100, 100, 0.0, 0.0, new ArrayList<>(), new ArrayList<>(),1 , 1, 15, null, false
        );
    }

    //Serializa o estado atual do jogo e salva no slot indicado
    public void salvarJogo(EstadoJogo estadoAtual, int numSave){
        File dir = new File(SAVES);
        //Garante que o diretório existe
        if(!dir.exists()){
            dir.mkdirs();
        }

        String nomeArquivo = SAVES + "save" + numSave;
        try (
            FileOutputStream fos = new FileOutputStream(nomeArquivo);
            ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeObject(estadoAtual);
        } catch (IOException e){
            //Retorna erro caso haja algum erro no salvamento do jogo
            throw new RuntimeException("Erro ao salvar o jogo no arquivo " + numSave, e);
        }
    }

    //Desserializa e retorna o estado do jogo do slot indicado
    public EstadoJogo carregarJogo(int numSave){
        String nomeArquivo = SAVES + "save" + numSave;

        //Retorna erro caso o save não exista ou não possa ser carregado
        try (FileInputStream fis = new FileInputStream(nomeArquivo);
            ObjectInputStream ois = new ObjectInputStream(fis)){
            return (EstadoJogo) ois.readObject();
        } catch (FileNotFoundException e){
            throw new RuntimeException("Save " + numSave + " não encontrado", e);
        } catch (IOException | ClassNotFoundException e){
            throw new RuntimeException("Erro ao carregar save " + numSave, e);
        }
    }

}
