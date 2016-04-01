package tictoctoe;
public class Marca
{
    protected char simbolo;

    public Marca (char smb) throws Exception
    {
        smb = Character.toUpperCase(smb);
        if(smb != 'X' || smb != 'O')
            throw new Exception("Marca inválida");
        
        this.simbolo = smb;
        // verifica se smb � um simbolo valido (X ou O), iniciando simbolo com smb
        // em caso afirmativo, ou lancando excecao, caso contrario
    }

    public char getSimbolo ()
    {
        return this.simbolo;
    }

    public boolean equals (Object obj)
    {
        if(obj == this)
            return true;
        if(obj == null)
            return false;
        if(!(obj instanceof Marca))
            return false;
        
        Marca outro = (Marca)obj;
            
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

    public Marca (Marca m) throws Exception
    {
        // construtor de copia
    }

    public Object clone ()
    {
        // retorna uma exata copia do this
    }
}