package tictoctoe;

import java.util.Random;

public class JogadorAutomatico implements Cloneable
{
    protected Marca marca = null;
    protected Tabuleiro tabDoJogo;
    private Random gerador;
    
    public JogadorAutomatico (Tabuleiro tab) throws Exception
    {
        if(tab == null)
           throw new Exception("Tabuleiro nulo");
        
        this.gerador = new Random();
        this.tabDoJogo = tab;
        this.marca = new Marca(gerador.nextBoolean()?'X':'O');
        // inicia tabDoJogo com tab e sorteia uma marca (X ou O) para o jogador,
        // iniciando marca; lanca excecao caso tab seja nulo
         
    }

    public JogadorAutomatico (Tabuleiro tab, Marca mrc) throws Exception
    {
        if(tab == null)
            throw new Exception("Tabuleiro nulo");
        if(mrc == null)
            throw new Exception("Marca nula");
        this.gerador = new Random();
        
        this.tabDoJogo = tab;
        this.marca = mrc;
        // inicia tabDoJogo com tab e marca com mrc; lanca excecao caso tab ou mrc sejam nulos
    }

    public Marca getMarca ()
    {
        return this.marca;
        // retorna a marca do jogador
    }

    public void facaSuaJogada ()
    {
        int l, c;
        for(;;) {
            l = gerador.nextInt(3);
            c = gerador.nextInt(3);
            try {
                this.tabDoJogo.haMarcaNaPosicao(l, c);
                this.tabDoJogo.setMarcaNaPosicao(this.marca, l, c);
                break;
            } catch(Exception e) {
                System.out.println("testando");
            }
        }
        // faz o jogador fazer uma jogada INTELIGENTE
    }

    @Override
    public boolean equals (Object obj)
    {
        if(obj == this)
            return true;
        if(obj == null)
            return false;
        if(!(obj instanceof JogadorAutomatico))
            return false;
        
        JogadorAutomatico outro = (JogadorAutomatico) obj;
        
        if(!this.marca.equals(outro.marca))
            return false;
        
        return this.tabDoJogo.equals(outro.tabDoJogo);
        // verifica se this e obj possuem o mesmo conteudo, retornando true
        // se sim ou false se nao
    }

    @Override
    public String toString ()
    {
        return this.marca.toString() + this.tabDoJogo.toString();
        // retorna um String que representa o conteudo do chamante do metodo
    }
    
    @Override
    public int hashCode ()
    {
        int r = super.hashCode();
        r = r * 7 + this.marca.hashCode();
        r = r * 7 + this.tabDoJogo.hashCode();
        
        return r;
        // retorna o codigo de espalhamento do chamante do metodo
    }

    public JogadorAutomatico (JogadorAutomatico j) throws Exception
    {
        if(j == null)
            throw new Exception("JogadorAutomatico nulo");
        
        this.marca = j.marca;
        this.tabDoJogo = new Tabuleiro(j.tabDoJogo);
        this.gerador = new Random();
        // construtor de copia
    }
    
    @Override
    public Object clone ()
    {
        JogadorAutomatico r = null;
        try {
            r = new JogadorAutomatico(this);
        } catch(Exception e) {}
        return r;
        // retorna uma exata copia do this
    }
}