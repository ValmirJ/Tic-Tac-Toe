package tictoctoe;
import com.sun.istack.internal.logging.Logger;
import java.io.IOException;
import java.util.logging.Level;

public class Velha
{
    public static void main (String[] args)
    {
        Tabuleiro           tabDoJogo;

        JogadorHumano       jogadorH = null;
        JogadorAutomatico   jogadorA = null;

        AnalistaSituacional analista;

        boolean jogadorHumanoComeca = (int)(Math.random()*2) == 0;

        do
        {
            try
            {
                tabDoJogo = new Tabuleiro();


                if (jogadorHumanoComeca)
                {
                    jogadorH = new JogadorHumano (tabDoJogo);
                    jogadorA = new JogadorAutomatico
                              (tabDoJogo,
                               new Marca(jogadorH.getMarca().getSimbolo()=='X'?'O':'X'));
                }
                else
                {
                    jogadorA = new JogadorAutomatico (tabDoJogo);
                    jogadorH = new JogadorHumano
                              (tabDoJogo,
                               new Marca(jogadorA.getMarca().getSimbolo()=='X'?'O':'X'));
                }

                analista = new AnalistaSituacional (tabDoJogo);

                boolean vezDojogadorHumano  = jogadorHumanoComeca;

                do
                {
                    if (vezDojogadorHumano)
                        jogadorH.facaSuaJogada();
                    else
                        jogadorA.facaSuaJogada();

                    vezDojogadorHumano = !vezDojogadorHumano;
                }
                while (!analista.fimDeJogo());

                if (analista.getMarcaDoVencedor().equals(jogadorH.getMarca()))
                    jogadorH.vcGanhou ();
                else
                    if (analista.getMarcaDoVencedor().equals(jogadorA.getMarca()))
                        jogadorH.vcPerdeu ();
                    else
                        jogadorH.deuVelha ();

                jogadorHumanoComeca = !jogadorHumanoComeca;
            }
            catch(Exception e){
                Logger.getLogger(Velha.class.getClass()).log(Level.SEVERE, null, e);
            }
        }
        while (jogadorH.querMaisUmaPartida()); 
    }
}