
package ia.grafico.paneles;

import ia.grafico.Constantes;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Nicolas Gonzalez Tardon
 */
public class PanelContador extends JPanel implements Constantes{
    
    public JLabel jugadorNombre;
    public JLabel adversarioNombre;
    
    public JLabel contadorJugador;
    public JLabel contadorAdversario;
    
    public PanelContador(){
        jugadorNombre = new JLabel("Jugador");
        jugadorNombre.setFont(FUENTE);
        
        adversarioNombre = new JLabel("Adversario");
        adversarioNombre.setFont(FUENTE);
        
        contadorJugador = new JLabel("0");
        contadorJugador.setFont(FUENTE);
        contadorJugador.setForeground(Color.BLUE);
        
        contadorAdversario = new JLabel("0");
        contadorAdversario.setFont(FUENTE);
        contadorAdversario.setForeground(Color.red);
        
        this.setLayout(new GridLayout(2,2));
        this.add(jugadorNombre);
        this.add(adversarioNombre);
        this.add(contadorJugador);
        this.add(contadorAdversario);
    }

}
