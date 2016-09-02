package ia.grafico;

import ia.grafico.paneles.PanelContador;
import ia.grafico.paneles.PanelMusica;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Nicolas Gonzalez Tardon
 */
public class PanelConfiguracion extends JPanel implements Constantes{
    public PanelDeJuego panelJuego;
    public PanelContador panelContador;
    public PanelMusica panelMusica;
    public VentanaPrincipal ventanaPrincipal;
    
    public PanelConfiguracion(PanelDeJuego panelJuego,VentanaPrincipal ventanaPrincipal){
        this.panelJuego = panelJuego;
        this.ventanaPrincipal = ventanaPrincipal;
        this.panelContador = new PanelContador();
        this.panelMusica = new PanelMusica(ventanaPrincipal);
        
        
        /*
        velocidad = new JLabel("Cambiar velocidad");
        velocidad.setForeground(Color.yellow);
        velocidad.setFont(FUENTE);*/
       
        super.setBackground(Color.GRAY);
        super.setLayout(new BorderLayout());
        super.add(panelContador,BorderLayout.NORTH);
        super.add(panelMusica,BorderLayout.CENTER);
        
    }
}
