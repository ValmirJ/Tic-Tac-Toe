package tictoctoe;
public class AnalistaSituacional implements Cloneable
{
    protected Tabuleiro tabDoJogo;

    public AnalistaSituacional (Tabuleiro tab) throws Exception
    {
        if(tab == null)
            throw new Exception("Tabuleiro nulo");
        
        tabDoJogo = new Tabuleiro(tab);
        // inicia tabDoJogo com tab; lanca excecao caso tab seja nulo
    }

    public Marca getMarcaDoVencedor () throws Exception
    {
        if(!fimDeJogo())
            throw new Exception("Jogo ainda não acabou");
        for(int i = 0; i < this.tabDoJogo.matriz.length; i++) {
            for(int j = 0; j <this.tabDoJogo.matriz[0].length; j++) {
                
            }
        }
    }

    protected boolean tabuleiroCheio ()
    {
        for(int i = 0; i < tabDoJogo.matriz.length; i++)
            for(int j = 0; j < tabDoJogo.matriz[0].length; i++)
            {
                try
                {
                    if(!tabDoJogo.haMarcaNaPosicao(i, j))
                        return false;
                }
                catch(Exception e)
                {
                    return false;
                }
            }
        return true;
        // verifica se o tabuleiro esta totalmente preenchido com marcas
    }

    public boolean fimDeJogo ()
    {
        if(tabuleiroCheio())
            return true;
        return false;
        // verifica se o jogo acabou, retornando true se sim ou false se nao
    }

    @Override
    public boolean equals (Object obj)
    {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(!(obj instanceof AnalistaSituacional))
            return false;
        
        AnalistaSituacional outro = (AnalistaSituacional)obj;
        
        for(int i = 0; i < this.tabDoJogo.matriz.length; i++)
            for(int j = 0; j <this.tabDoJogo.matriz[0].length; j++)
                if(!this.tabDoJogo.matriz[i][j].equals(outro.tabDoJogo.matriz[i][j]))
                    return false;
        
        return true;
        // verifica se this e obj possuem o mesmo conteudo, retornando true
        // se sim ou false se nao
    }

    @Override
    public String toString ()
    {
        String str = "";
        for(int i=0; i < this.tabDoJogo.matriz.length; i++) {
            str += i + " | " ;
            for(int j = 0; j < this.tabDoJogo.matriz[0].length; i++) {
                str += "_\n" + this.tabDoJogo.matriz[i][j].getSimbolo();
            }
        }
        
        return str;
        // retorna um String que representa o conteudo do chamante do metodo
    }

    public int hashCode ()
    {
        int resul = super.hashCode();
        for(int i=0; i < this.tabDoJogo.matriz.length; i++)
            for(int j = 0; j < this.tabDoJogo.matriz[0].length; i++)
                resul = resul * 7 + this.tabDoJogo.matriz[i][j].hashCode();
        
        return resul;
        // retorna o codigo de espalhamento do chamante do metodo
    }

    public AnalistaSituacional (AnalistaSituacional a) throws Exception
    {
        if(a == null)
            throw new Exception ("Objeto nulo");
        
        this.tabDoJogo = new Tabuleiro(a.tabDoJogo);
        // construtor de copia
    }

    @Override
    public Object clone ()
    {
        AnalistaSituacional resul = null;
        try {
            resul = new AnalistaSituacional(this);
        }
        catch(Exception e) {}
        
        return resul;
        // retorna uma exata copia do this
    }
}