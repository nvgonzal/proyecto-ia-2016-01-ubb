package ia.grafico;

import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 *
 * @author Nicolas Gonzalez Tardon
 */
public class PanelDeJuego extends JPanel implements Constantes{
    
    public Lienzo lienzo;
    public VentanaPrincipal ventanaPrincipal;
    
    public PanelDeJuego(VentanaPrincipal ventanaPrincipal){
        this.ventanaPrincipal = ventanaPrincipal;
        this.setLayout(new BorderLayout());
        lienzo = new Lienzo(this.ventanaPrincipal);
        lienzo.setFocusable(true);
        lienzo.requestFocus();
        this.add(lienzo);
        this.setSize(lienzo.getWidth(), lienzo.getHeight());
    }

}
