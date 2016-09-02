package ia.grafico;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import javax.imageio.ImageIO;

/**
 *
 * @author Nicolas
 */
public class Lienzo extends Canvas implements Constantes{
    
    public VentanaPrincipal ventanaPrincipal;
    
    public Laberinto laberinto;
    public Image fondo;
    
    public Graphics graficoBuffer;
    public Image imagenBuffer;
    
    public Adversario adversario;
    public Jugador jugador1;
    public Pelota pelota;
    
    public Timer lanzadorTareas;
    
    public Lienzo(VentanaPrincipal ventanaPrincipal){
        this.ventanaPrincipal = ventanaPrincipal;
        laberinto = new Laberinto(this);
        super.setBackground(new Color(36, 119, 36));
        super.setSize(laberinto.anchuraLaberinto, laberinto.alturaLaberinto);
        try{
            fondo = ImageIO.read(new File("imagenes/fondo.jpg"));
        }
        catch(IOException e){
            System.out.println(e.toString());
        }
        
        super.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                laberinto.moverCelda(e);
                repaint();
            }
        });
        pelota = new Pelota(laberinto,jugador1,adversario);
        jugador1 = new Jugador(laberinto,pelota);
        adversario = new Adversario(laberinto,pelota);
        pelota.jugador = jugador1;
        pelota.adversario = adversario;
        lanzadorTareas = new Timer();
        lanzadorTareas.scheduleAtFixedRate(adversario.inteligencia, 0, 500);
    }
    
    @Override
    public void update(Graphics g){
        //inicialización del buffer gráfico mediante la imagen
        if (graficoBuffer == null) {
            imagenBuffer = createImage(this.getWidth(), this.getHeight());
            graficoBuffer = imagenBuffer.getGraphics();
        }
//volcamos color de fondo e imagen en el nuevo buffer grafico
        graficoBuffer.setColor(getBackground());
        graficoBuffer.fillRect(0, 0, this.getWidth(), this.getHeight());
        graficoBuffer.drawImage(fondo, 0, 0, null);

        laberinto.update(graficoBuffer);
        g.drawImage(imagenBuffer, 0, 0, null);
    }
    
    
    public boolean buscarPelotaJ(){
        if (jugador1.celdaJugador.y > 0 && jugador1.celdaJugador.x > 0) {
            if(laberinto.celdas[jugador1.celdaJugador.x - 1][jugador1.celdaJugador.y - 1].tipo == 'P'){
                return true;
            }
        }
        if (jugador1.celdaJugador.y > 0) {
            if(laberinto.celdas[jugador1.celdaJugador.x][jugador1.celdaJugador.y - 1].tipo == 'P'){
                return true;
            }
        }
        if (jugador1.celdaJugador.y > 0 && jugador1.celdaJugador.x < anchuraMundoVirtual - 1) {
            if(laberinto.celdas[jugador1.celdaJugador.x + 1][jugador1.celdaJugador.y - 1].tipo == 'P'){
                return true;
            }
        }
        if (jugador1.celdaJugador.x < anchuraMundoVirtual - 1) {
            if(laberinto.celdas[jugador1.celdaJugador.x + 1][jugador1.celdaJugador.y].tipo == 'P'){
                return true;
            }
        }
        if (jugador1.celdaJugador.y < alturaMundoVirtual - 1 && jugador1.celdaJugador.x < anchuraMundoVirtual - 1){
            if(laberinto.celdas[jugador1.celdaJugador.x + 1][jugador1.celdaJugador.y + 1].tipo == 'P'){
                return true;
            }
        }
        if (jugador1.celdaJugador.y < alturaMundoVirtual - 1){
            if(laberinto.celdas[jugador1.celdaJugador.x][jugador1.celdaJugador.y + 1].tipo == 'P'){
                return true;
            }
        }
        if (jugador1.celdaJugador.y < alturaMundoVirtual - 1 && jugador1.celdaJugador.x > 0){
            if(laberinto.celdas[jugador1.celdaJugador.x - 1][jugador1.celdaJugador.y + 1].tipo == 'P'){
                return true;
            }
        }
        if (jugador1.celdaJugador.x > 0){
            if(laberinto.celdas[jugador1.celdaJugador.x - 1][jugador1.celdaJugador.y].tipo == 'P'){
                return true;
            }
        }
        return false;
    }
    
    public boolean buscarPelotaA(){
        if (adversario.celdaAdversario.y > 0 && adversario.celdaAdversario.x > 0) {
            if(laberinto.celdas[adversario.celdaAdversario.x - 1][adversario.celdaAdversario.y - 1].tipo == 'P'){
                return true;
            }
        }
        if (adversario.celdaAdversario.y > 0) {
            if(laberinto.celdas[adversario.celdaAdversario.x][adversario.celdaAdversario.y - 1].tipo == 'P'){
                return true;
            }
        }
        if (adversario.celdaAdversario.y > 0 && adversario.celdaAdversario.x < anchuraMundoVirtual - 1) {
            if(laberinto.celdas[adversario.celdaAdversario.x + 1][adversario.celdaAdversario.y - 1].tipo == 'P'){
                return true;
            }
        }
        if (adversario.celdaAdversario.x < anchuraMundoVirtual - 1) {
            if(laberinto.celdas[adversario.celdaAdversario.x + 1][adversario.celdaAdversario.y].tipo == 'P'){
                return true;
            }
        }
        if (adversario.celdaAdversario.y < alturaMundoVirtual - 1 && adversario.celdaAdversario.x < anchuraMundoVirtual - 1) {
            if(laberinto.celdas[adversario.celdaAdversario.x + 1][adversario.celdaAdversario.y + 1].tipo == 'P'){
                return true;
            }
        }
        if (adversario.celdaAdversario.y < alturaMundoVirtual - 1){
            if(laberinto.celdas[adversario.celdaAdversario.x][adversario.celdaAdversario.y + 1].tipo == 'P'){
                return true;
            }
        }
        if (adversario.celdaAdversario.y < alturaMundoVirtual - 1 && adversario.celdaAdversario.x > 0){
            if(laberinto.celdas[adversario.celdaAdversario.x - 1][adversario.celdaAdversario.y + 1].tipo == 'P'){
                return true;
            }
        }
        if (adversario.celdaAdversario.x > 0){
            if(laberinto.celdas[adversario.celdaAdversario.x - 1][adversario.celdaAdversario.y].tipo == 'P'){
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void paint(Graphics g){
        update(g);
    }
}
