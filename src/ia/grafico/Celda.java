package ia.grafico;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

/**
 *
 * @author Nicolas
 */
public class Celda extends JComponent implements Constantes{
    
    public int x;
    public int y;
    public char tipo;
    public Rectangle rectanguloCelda;
    public BufferedImage jugador,obstaculo,camino,adversario;
    public BufferedImage pelota;
    
    
    public Celda(int x , int y,char tipo){
        this.x = x;
        this.y = y;
        this.tipo = tipo;
        try{
            jugador = ImageIO.read(new File("imagenes/jugador.png"));
            obstaculo = ImageIO.read(new File("imagenes/obstaculo.png"));
            camino = ImageIO.read(new File("imagenes/camino.png"));
            adversario = ImageIO.read(new File("imagenes/adversario.png"));
            pelota = ImageIO.read(new File("imagenes/pelota.png"));
        }
        catch(IOException e){
            System.out.println(e.toString());
        }
        this.rectanguloCelda = new Rectangle(x, y, anchuraCelda, alturaCelda);
    }
    
    @Override
    public void paintComponent(Graphics g){
        update(g);
    }
    
    @Override
    public void update(Graphics g){
        switch(tipo){
            case 'J':
                g.drawImage(jugador, x, y, null);
                break;
            case 'O':
                g.drawImage(obstaculo, x, y, null);
                break;
            case 'A':
                g.drawImage(adversario, x, y, null);
                break;
            case 'C':
                g.setColor(COLORFONDO);
                g.fillRect(x, y, anchuraCelda, alturaCelda);
                break;
            case 'P':
                g.drawImage(pelota, x, y, null);
                break;
            case PORTERIAA:
                g.setColor(COLORPORTERIA);
                g.fillRect(x, y, anchuraCelda, alturaCelda);
                break;
            case PORTERIAJ:
                g.setColor(COLORPORTERIA);
                g.fillRect(x, y, anchuraCelda, alturaCelda);
                break;
        }
    }
}
