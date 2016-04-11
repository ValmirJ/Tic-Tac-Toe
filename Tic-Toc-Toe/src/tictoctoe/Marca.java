package tictoctoe;
public class Marca
{
    protected char simbolo;

    public Marca (char smb) throws Exception
    {
        smb = Character.toUpperCase(smb);
        
        if(smb != 'X' && smb != 'O')
            throw new Exception("Marca inválida");
        
        this.simbolo = smb;
        // verifica se smb � um simbolo valido (X ou O), iniciando simbolo com smb
        // em caso afirmativo, ou lancando excecao, caso contrario
    }

    public char getSimbolo ()
    {
        return this.simbolo;
    }

    @Override
    public boolean equals (Object obj)
    {
        if(obj == this)
            return true;
        if(obj == null)
            return false;
        if(!(obj instanceof Marca))
            return false;
        
        Marca outro = (Marca)obj;
        
        if(this.simbolo != outro.simbolo)
            return false;
        
        return true;
        // verifica se this e obj possuem o mesmo conteudo, retornando true
        // se sim ou false se nao
    }
    
    @Override
    public String toString ()
    {
        return "Simbolo: " + simbolo;
        // retorna um String que representa o conteudo do chamante do metodo
    }

    @Override
    public int hashCode ()
    {
        int resul = super.hashCode();
        
        resul = resul * 7 + new Character(this.simbolo).hashCode();
        return resul;
        // retorna o codigo de espalhamento do chamante do metodo
    }
}