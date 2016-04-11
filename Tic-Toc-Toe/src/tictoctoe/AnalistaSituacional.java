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
            if(verificaSeHaVencedor(this.tabDoJogo.matriz[i][0], this.tabDoJogo.matriz[i][1], this.tabDoJogo.matriz[i][2])) {
                return this.tabDoJogo.matriz[i][0];
            }
            if(verificaSeHaVencedor(this.tabDoJogo.matriz[0][i], this.tabDoJogo.matriz[1][i], this.tabDoJogo.matriz[2][i])) {
                return this.tabDoJogo.matriz[0][i];
            }
        }
        if(verificaSeHaVencedor(this.tabDoJogo.matriz[0][2], this.tabDoJogo.matriz[1][1], this.tabDoJogo.matriz[2][0]))
            return this.tabDoJogo.matriz[0][2];
        if(verificaSeHaVencedor(this.tabDoJogo.matriz[0][0], this.tabDoJogo.matriz[1][1], this.tabDoJogo.matriz[2][2]))
            return this.tabDoJogo.matriz[0][0];
        
        return null;
    }

    protected boolean tabuleiroCheio ()
    {
        for(int i = 0; i < this.tabDoJogo.matriz.length; i++)
            for(int j = 0; j < this.tabDoJogo.matriz[0].length; j++)
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

    protected boolean verificaSeHaVencedor(Marca a1, Marca a2, Marca a3) {
        return (a1.equals(a2) && a2.equals(a3)) && a1 != null;
    }
    public boolean fimDeJogo ()
    {
        if(tabuleiroCheio())
            return true;
        
        for(int i = 0; i < this.tabDoJogo.matriz.length; i++) {
            if(verificaSeHaVencedor(this.tabDoJogo.matriz[i][0], this.tabDoJogo.matriz[i][1], this.tabDoJogo.matriz[i][2])) {
                return true;
            }
            if(verificaSeHaVencedor(this.tabDoJogo.matriz[0][i], this.tabDoJogo.matriz[1][i], this.tabDoJogo.matriz[2][i])) {
                return true;
            }
        }
        if(verificaSeHaVencedor(this.tabDoJogo.matriz[0][2], this.tabDoJogo.matriz[1][1], this.tabDoJogo.matriz[2][0]))
            return true;
        if(verificaSeHaVencedor(this.tabDoJogo.matriz[0][0], this.tabDoJogo.matriz[1][1], this.tabDoJogo.matriz[2][2]))
            return true;
        // verifica se o jogo acabou, retornando true se sim ou false se nao
        return false;
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
            for(int j = 0; j < this.tabDoJogo.matriz[0].length; j++)
                if(!this.tabDoJogo.matriz[i][j].equals(outro.tabDoJogo.matriz[i][j]))
                    return false;
        
        return true;
        // verifica se this e obj possuem o mesmo conteudo, retornando true
        // se sim ou false se nao
    }

    @Override
    public String toString ()
    {
        
        return this.tabDoJogo.toString();
        // retorna um String que representa o conteudo do chamante do metodo
    }

    @Override
    public int hashCode ()
    {
        int resul = super.hashCode();
        for(int i=0; i < this.tabDoJogo.matriz.length; i++)
            for(int j = 0; j < this.tabDoJogo.matriz[0].length; j++)
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