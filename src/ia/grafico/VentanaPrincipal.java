
package ia.grafico;

import ia.musica.HiloMusica;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JSplitPane;

/**
 *
 * @author Nicolas Gonzalez Tardon
 */
public class VentanaPrincipal extends JFrame implements Constantes{
    
    public JSplitPane panelSeparador;
    public PanelDeJuego panelJuego;
    public PanelConfiguracion panelConfiguracion;
    
    public PanelMenuInicio panelMenuInicio;
    public HiloMusica player;
    
    public VentanaPrincipal(){
        
        panelSeparador = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        panelSeparador.setOneTouchExpandable(true);
        
        panelMenuInicio = new PanelMenuInicio();
        
        panelJuego = new PanelDeJuego(this);
        panelConfiguracion = new PanelConfiguracion(panelJuego,this);
        panelSeparador.setLeftComponent(panelJuego);
        panelSeparador.setRightComponent(panelConfiguracion);
        panelSeparador.setDividerLocation(panelJuego.getWidth() + 32);
        panelSeparador.setDividerSize(8);
        
        super.getContentPane().setLayout(new BorderLayout());
        super.getContentPane().add(panelSeparador,BorderLayout.CENTER);
        panelSeparador.setEnabled(false);
        
        
        player = new HiloMusica(RUTA + "/musica/doom.wav", 5);
        this.ejecutarMusica();
        
        //super.add(panelMenuInicio);
        super.setSize(SIZE_SCREEN.width - 40, SIZE_SCREEN.height - 132);
        
        

    }
    
    public void ejecutarMusica(){
//        player.run();
    }
    
    public void pararMusica(){
//        player.parar();
    }
    
}
