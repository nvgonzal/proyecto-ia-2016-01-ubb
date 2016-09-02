
package ia.grafico;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Nicolas Gonzalez Tardon
 */
public class PanelMenuInicio extends JPanel{
    
    public JLabel etiquetaNombre;
    public JTextField nombre;
    public JCheckBox sinMusica;
    public JCheckBox conMusica;
    
    public ButtonGroup musica;
    
    public JButton comenzar;
    
    
    public Image fondoMenu; 
            
    public PanelMenuInicio(){
        this.setLayout(null);
        this.etiquetaNombre = new JLabel("Ingresa tu nombre");
        this.etiquetaNombre.setBounds(20,100,400,40);
        this.etiquetaNombre.setFont(new Font("Open Sans", Font.BOLD, 40));
        this.etiquetaNombre.setForeground(new Color(150,124,32));
        
        this.nombre = new JTextField("");
        this.nombre.setBounds(450, 30, 500, 30);
        
        this.sinMusica = new JCheckBox("Sin musica.", true);
        this.sinMusica.setBounds(500, 300, 100, 50);
        
        this.conMusica = new JCheckBox("Con musica");
        this.conMusica.setBounds(500, 350, 100, 50);
        
        this.musica = new ButtonGroup();
        this.musica.add(sinMusica);
        this.musica.add(conMusica);
        
        this.comenzar = new JButton("COMENZAR");
        this.comenzar.setBounds(600, 500, 150, 20);
        
        
        try{
            fondoMenu = ImageIO.read(new File("imagenes/fondo menu.jpg"));
        }
        catch(IOException e){
            System.out.println(e);
        }
        
        super.add(etiquetaNombre);
        super.add(nombre);
        super.add(sinMusica);
        super.add(conMusica);
        super.add(comenzar);
        super.repaint();
    }
    
    @Override
    public void paintComponent(Graphics g){
        g.drawImage(fondoMenu, 0, 0, null);
    }
}
