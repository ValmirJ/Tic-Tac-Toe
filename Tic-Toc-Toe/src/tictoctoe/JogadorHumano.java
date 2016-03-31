package tictoctoe;
import java.io.*;

public class JogadorHumano implements Cloneable
{
    protected Marca          marca = null;
    protected Tabuleiro      tabDoJogo;
    protected BufferedReader entrada = new BufferedReader
                                    (new InputStreamReader
                                    (System.in));

    public JogadorHumano (Tabuleiro tab) throws Exception
    {
        // inicia tabDoJogo com tab e pergunta ao jogador qual marca (X ou O) deseja usar,
        // iniciando marca; lanca excecao caso o tab seja nulo
    }

    public JogadorHumano (Tabuleiro tab, Marca mrc) throws Exception
    {
        // inicia tabDoJogo com tab e marca com mrc; lanca excecao caso tab ou mrc sejam nulos
    }

    public Marca getMarca ()
    {
        // retorna a marca do jogador
    }

    public void facaSuaJogada ()
    {
        // pergunta, quantas vezes forem necessarias, onde o jogador quer jogar
        // (ate que o mesmo indique uma jogada valida), que sera a jogada do jogador
    }

    public void vcGanhou ()
    {
        // informa o jogador que ele ganhou
    }

    public void vcPerdeu ()
    {
        // informa o jogador que ele perdeu
    }

    public void deuVelha ()
    {
        // informa o jogador que deu velha (empate)
    }

    public boolean querMaisUmaPartida ()
    {
        // pergunta, quantas vezes forem necessarias, se o jogador deseja jogar
        // mais uma partida (ate que o mesmo forneca uma resposta valida), retornando
        // true caso seja seu desejo jogar mais uma partida, ou false, caso contrario
    }

    public boolean equals (Object obj)
    {
        // verifica se this e obj possuem o mesmo conteudo, retornando true
        // se sim ou false se nao
    }

    public String toString ()
    {
        // retorna um String que representa o conteudo do chamante do metodo
    }

    public int hashCode ()
    {
        // retorna o codigo de espalhamento do chamante do metodo
    }

    public JogadorHumano (JogadorHumano j) throws Exception
    {
        // construtor de copia
    }

    public Object clone ()
    {
        // retorna uma exata copia do this
    }
}