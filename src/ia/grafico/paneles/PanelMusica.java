/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ia.grafico.paneles;

import ia.grafico.VentanaPrincipal;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

/**
 *
 * @author Nicolas Gonzalez Tardon
 */
public class PanelMusica extends JPanel{
    
    public JCheckBox sinMusica;
    public JCheckBox conMusica;
    
    public ButtonGroup musica;
    
    public VentanaPrincipal ventanaPrincipal;
    
    public PanelMusica(VentanaPrincipal ventanaPrincipal){
        this.ventanaPrincipal = ventanaPrincipal;
        
        this.sinMusica = new JCheckBox("Sin musica.");
        this.sinMusica.addActionListener(this::ApagarMusica);
        
        this.conMusica = new JCheckBox("Con musica", true);
        this.conMusica.addActionListener(this::CorrerMusica);
        
        this.setLayout(new GridLayout(2,1));
        
        this.musica = new ButtonGroup();
        this.musica.add(sinMusica);
        this.musica.add(conMusica);
        
        super.add(sinMusica);
        super.add(conMusica);
        
    }
    
    public void ApagarMusica(ActionEvent e){
        System.out.println("Apagar");
        this.ventanaPrincipal.panelJuego.lienzo.requestFocus();
        this.ventanaPrincipal.pararMusica();
    }
    
    public void CorrerMusica(ActionEvent e){
        System.out.println("Encender");
        this.ventanaPrincipal.panelJuego.lienzo.requestFocus();
        this.ventanaPrincipal.ejecutarMusica();
    }

}
