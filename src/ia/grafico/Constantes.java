package ia.grafico;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.Random;

/**
 *
 * @author Nicolas Gonzalez Tardon
 */
public interface Constantes {

    public final int anchuraCelda=32;
    public final int alturaCelda=32;
    public final int anchuraMundoVirtual=27;
    public final int alturaMundoVirtual=18;
    
    public final char JUGADOR = 'J';
    public final char CAMINO = 'C';
    public final char OBSTACULO = 'O';
    public final char ADVERSARIO = 'A';
    public final char PELOTA = 'P';
    public final char PORTERIAJ = '1';
    public final char PORTERIAA = '2';
    
    public final int ALFA = 50;
    public final Color COLORFONDO = new Color(153, 217, 234, ALFA);
    public final Color COLORPORTERIA = new Color(153, 217, 234, ALFA+3);
    
    public final String RUTA="file:///"+System.getProperty( "user.dir" );
    
    default int numeroAleatorio(int minimo, int maximo) {
        Random random = new Random();
        int numero_aleatorio = random.nextInt((maximo - minimo) + 1) + minimo;
        return numero_aleatorio;
    }
    
    public Dimension SIZE_SCREEN = Toolkit.getDefaultToolkit().getScreenSize();
    
    public final int VELOCIDAD_MINIMA = 300;
    public final int VELOCIDAD_MAXIMA = 2000;
    public final int VELOCIDAD_INICIAL = 1000;
    
    public final Font FUENTE = new Font("Calibri", Font.BOLD, 20);
}
