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
        if (tab == null)
            throw new Exception("Tabuleiro nulo");
        
        tabDoJogo = new Tabuleiro(tab);
        
        System.out.print("Digite sua marca: ");
        for(;;) {
            try {
                marca = new Marca((char)entrada.read());
                break;
            }
            catch(Exception e) {
                System.err.print(e + ". Tente novamente!");
            }
        }
        // inicia tabDoJogo com tab e pergunta ao jogador qual marca (X ou O) deseja usar,
        // iniciando marca; lanca excecao caso o tab seja nulo
    }

    public JogadorHumano (Tabuleiro tab, Marca mrc) throws Exception
    {
        if(tab == null)
            throw new Exception("Tabuleiro nulo");
        if(mrc == null)
            throw new Exception("Marca nula");
        
        tabDoJogo = new Tabuleiro(tab);
        marca = new Marca(mrc.getSimbolo());
        // inicia tabDoJogo com tab e marca com mrc; lanca excecao caso tab ou mrc sejam nulos
    }

    public Marca getMarca ()
    {
        return this.marca;
        // retorna a marca do jogador
    }

    public void facaSuaJogada ()
    {   
        int lin, col;
        for(;;) {
            try {
                System.out.print("\nDigite uma posição X: ");
                lin = (int)entrada.read();
                System.out.print("\nDigite uma posição Y: ");
                col = (int)entrada.read();
                tabDoJogo.setMarcaNaPosicao(marca, lin, col);
                break;
            }
            catch(Exception e) {
                System.err.print("\nPosição inválida, tente novamente");
            }
        }
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