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
        
        this.tabDoJogo = tab;
        
        System.out.println("Digite sua marca: ");
        for(;;) {
            try {
                this.marca = new Marca(entrada.readLine().charAt(0));
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
        
        tabDoJogo = tab;
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
                System.out.println(this.tabDoJogo.toString());
                System.out.print("\nDigite uma posição X: ");
                lin = Integer.parseInt(entrada.readLine());
                System.out.print("\nDigite uma posição Y: ");
                col = Integer.parseInt(entrada.readLine());
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
        System.out.print("\nParabéns você ganhou!");
        // informa o jogador que ele ganhou
    }

    public void vcPerdeu ()
    {
        System.out.print("\nVocê perdeu =/");
        // informa o jogador que ele perdeu
    }

    public void deuVelha ()
    {
        System.out.print("\nDeu velha!");
        // informa o jogador que deu velha (empate)
    }

    public boolean querMaisUmaPartida ()
    {
        char opt = 'i';
        do {
            System.out.println("\nDeseja jogar novamente? (S) ou (N)");
            try {
                opt = Character.toUpperCase(entrada.readLine().charAt(0));
            } catch (Exception e) {}
        } while (opt != 'S' && opt != 'N');
        
        return opt == 'S';
        // pergunta, quantas vezes forem necessarias, se o jogador deseja jogar
        // mais uma partida (ate que o mesmo forneca uma resposta valida), retornando
        // true caso seja seu desejo jogar mais uma partida, ou false, caso contrario
                
    }

    @Override
    public boolean equals (Object obj)
    {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(!(obj instanceof JogadorHumano))
            return false;
        JogadorHumano outro = (JogadorHumano) obj;
        
        if(!this.marca.equals(outro.marca))
            return false;
        
        return (this.tabDoJogo.equals(outro.tabDoJogo));
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

    public JogadorHumano (JogadorHumano j) throws Exception
    {
        if(j == null)
            throw new Exception ("JogadorHumano nulo");
        
        this.marca = j.marca;
        this.tabDoJogo = (Tabuleiro)j.tabDoJogo.clone();
        // construtor de copia
    }

    @Override
    public Object clone ()
    {
        JogadorHumano j = null;
        try {
            j = new JogadorHumano(this);
        }
        catch(Exception e) {}
        return j;
        // retorna uma exata copia do this
    }
}