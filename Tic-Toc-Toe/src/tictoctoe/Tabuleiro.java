package tictoctoe;
public class Tabuleiro
{
    protected Marca[][] matriz = new Marca [3][3];

    public boolean haMarcaNaPosicao (int lin, int col) throws Exception
    {
        if(lin < 0 || lin >= matriz.length)
            throw new Exception("Linha inválida, excede as rows da matriz");
        if(col < 0 || col >= matriz[0].length)
            throw new Exception("Coluna inválida, excede as colunas da matriz");
        
        
        // verifica se ha marca na posicao indicada por seus parametros, retornando
        // true em caso afirmativo, ou false em caso negativo; lanca excecao se seus
        // parametros forem invalidos
    }

    public Marca getMarcaNaPosicao (int lin, int col) throws Exception
    {
        // resulta a marca que ha na posicao indicada por seus parametros, retornando-a;
        // retorna null, caso ali nao haja nenhuma marca; lanca excecao se seus
        // parametros forem invalidos
    }

    public void setMarcaNaPosicao (Marca mrc, int lin, int col) throws Exception
    {
        // coloca mrc na posicao indicada por seus parametros; lanca excecao se seus
        // parametros forem invalidos
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

    public Tabuleiro (Tabuleiro t) throws Exception
    {
        // construtor de copia
    }

    public Object clone ()
    {
        // retorna uma exata copia do this
    }
}