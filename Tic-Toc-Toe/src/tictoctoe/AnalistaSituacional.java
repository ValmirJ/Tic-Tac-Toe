package tictoctoe;
public class AnalistaSituacional implements Cloneable
{
    protected Tabuleiro tabDoJogo;

    public AnalistaSituacional (Tabuleiro tab) throws Exception
    {
        // inicia tabDoJogo com tab; lanca excecao caso tab seja nulo
    }

    public Marca getMarcaDoVencedor ()
    {
        // retorna a marca do vencedor ou null se nao houver vencedor
    }

    protected boolean tabuleiroCheio ()
    {
        // verifica se o tabuleiro esta totalmente preenchido com marcas
    }

    public boolean fimDeJogo ()
    {
        // verifica se o jogo acabou, retornando true se sim ou false se nao
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

    public AnalistaSituacional (AnalistaSituacional a) throws Exception
    {
        // construtor de copia
    }

    public Object clone ()
    {
        // retorna uma exata copia do this
    }
}