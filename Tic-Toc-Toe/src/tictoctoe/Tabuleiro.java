package tictoctoe;
public class Tabuleiro implements Cloneable
{
    protected Marca[][] matriz; 

    public boolean haMarcaNaPosicao (int lin, int col) throws Exception
    {
        if(lin < 0 || lin >= matriz.length)
            throw new Exception("Linha inválida, excede as rows da matriz");
        if(col < 0 || col >= matriz[0].length)
            throw new Exception("Coluna inválida, excede as colunas da matriz");
        
        if(matriz[lin][col].equals('O') || matriz[lin][col].equals('X'))
            return true;
        
        return false;
        // verifica se ha marca na posicao indicada por seus parametros, retornando
        // true em caso afirmativo, ou false em caso negativo; lanca excecao se seus
        // parametros forem invalidos
    }
    public Tabuleiro() {
        matriz = new Marca [3][3];
    }

    public Marca getMarcaNaPosicao (int lin, int col) throws Exception
    {
        if(lin < 0 || lin >= matriz.length)
            throw new Exception("Linha inválida, excede as rows da matriz");
        if(col < 0 || col >= matriz[0].length)
            throw new Exception("Coluna inválida, excede as colunas da matriz");
        
        
        return matriz[lin][col];
        // resulta a marca que ha na posicao indicada por seus parametros, retornando-a;
        // retorna null, caso ali nao haja nenhuma marca; lanca excecao se seus
        // parametros forem invalidos
    }

    public void setMarcaNaPosicao (Marca mrc, int lin, int col) throws Exception
    {
        if(lin < 0 || lin >= matriz.length)
            throw new Exception("Linha inválida, excede as rows da matriz");
        if(col < 0 || col >= matriz[0].length)
            throw new Exception("Coluna inválida, excede as colunas da matriz");
        
        if(haMarcaNaPosicao(lin, col))
            throw new Exception("Posição inválida, está posição já foi jogada");
        
        matriz[lin][col] = mrc;
        // coloca mrc na posicao indicada por seus parametros; lanca excecao se seus
        // parametros forem invalidos
    }

    @Override
    public boolean equals (Object obj)
    {
        if(obj == this)
            return true;
        
        if(obj == null)
            return false;
        
        if(!(obj instanceof Tabuleiro))
            return false;
        
        Tabuleiro outro = (Tabuleiro) obj;
        for(int i=0; i < matriz.length; i++)
            for(int j = 0; j < matriz[0].length; i++)
                if(this.matriz[i][j] != outro.matriz[i][j])
                    return false;
        
        return true;
        // verifica se this e obj possuem o mesmo conteudo, retornando true
        // se sim ou false se nao
    }

    @Override
    public String toString ()
    {
        String str = "";
        for(int i=0; i < matriz.length; i++) {
            str += i + " | " ;
            for(int j = 0; j < matriz[0].length; i++) {
                str += "_\n" + matriz[i][j].getSimbolo();
            }
        }
        
        return str;
        // retorna um String que representa o conteudo do chamante do metodo
    }
    
    @Override
    public int hashCode ()
    {
        int resul = super.hashCode();
        for(int i=0; i < matriz.length; i++)
            for(int j = 0; j < matriz[0].length; i++)
                resul = resul * 7 + matriz[i][j].hashCode();
        
        return resul;
        // retorna o codigo de espalhamento do chamante do metodo
    }

    public Tabuleiro (Tabuleiro t) throws Exception
    {
        if(t == null)
            throw new Exception("Objeto nulo, não há o que copiar");
        
        this.matriz = new Marca[t.matriz.length][t.matriz[0].length];
        
        for(int i=0; i < matriz.length; i++)
            for(int j = 0; j < matriz[0].length; i++)
                this.matriz[i][j] = t.matriz[i][j];
        // construtor de copia
    }

    @Override
    public Object clone ()
    {
        Tabuleiro resul = null;
        try {
            resul = new Tabuleiro(this);
        }
        catch(Exception e)
        {} //sei que não vai acontecer, pois, se o objeto chamou metodos ele não esta null
        return resul;
    }
}