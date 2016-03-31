package tictoctoe;
public class JogadorAutomatico implements Cloneable
{
    protected Marca marca = null;
    protected Tabuleiro tabDoJogo;

    public JogadorAutomatico (Tabuleiro tab) throws Exception
    {
        // inicia tabDoJogo com tab e sorteia uma marca (X ou O) para o jogador,
        // iniciando marca; lanca excecao caso tab seja nulo
    }

    public JogadorAutomatico (Tabuleiro tab, Marca mrc) throws Exception
    {
        // inicia tabDoJogo com tab e marca com mrc; lanca excecao caso tab ou mrc sejam nulos
    }

    public Marca getMarca ()
    {
        // retorna a marca do jogador
    }

    public void facaSuaJogada ()
    {
        // faz o jogador fazer uma jogada INTELIGENTE
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

    public JogadorAutomatico (JogadorAutomatico j) throws Exception
    {
        // construtor de copia
    }

    public Object clone ()
    {
        // retorna uma exata copia do this
    }
}