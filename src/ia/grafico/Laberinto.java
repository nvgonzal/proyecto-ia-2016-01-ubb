package ia.grafico;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

/**
 *
 * @author Nicolas
 */
public class Laberinto extends JComponent implements Constantes{
    
    public int anchuraLaberinto,alturaLaberinto;
    public Celda[][] celdas;
    public Celda pelota;
    
    public Lienzo lienzoPadre;
    
    public int contadorJugador;
    public int contadorAdversario;
    
    public Laberinto(Lienzo lienzoPadre){
        this.lienzoPadre = lienzoPadre;
        this.contadorJugador = 0;
        this.contadorAdversario = 0;
        
        celdas = new Celda[anchuraMundoVirtual][alturaMundoVirtual];

        for (int i = 0; i < anchuraMundoVirtual; i++) {
            for (int j = 0; j < alturaMundoVirtual; j++) {
                celdas[i][j] = new Celda(i + (i* anchuraCelda) , j+(j* alturaCelda),'C');
            }
        }
        this.anchuraLaberinto = anchuraMundoVirtual * anchuraCelda;
        this.alturaLaberinto = alturaMundoVirtual * alturaCelda;
        this.setSize(anchuraLaberinto, alturaLaberinto);
        this.pelota = new Celda(anchuraMundoVirtual / 2,alturaMundoVirtual / 2,'P');
        this.celdas[pelota.x][pelota.y].tipo = 'P';
        
        generarPorterias();
        generarObstaculos(15);
        
    }
    
    @Override
    public void update(Graphics g){
        for (int i = 0; i < anchuraMundoVirtual; i++) {
            for (int j = 0; j < alturaMundoVirtual; j++) {
                celdas[i][j].paintComponent(g);
            }
        }
    }
    
    @Override
    public void paintComponent(Graphics g){
        update(g);
    }
    
    public void moverCelda(KeyEvent evento) {
        
        boolean b = lienzoPadre.buscarPelotaJ();
        System.out.println(b);
        switch (evento.getKeyCode()) {
            case KeyEvent.VK_Q:
                //MOVER JUGADOR ARRIBA IZQUIERDA
                lienzoPadre.jugador1.moverJugadorArribaIzquierda();
                break;
            case KeyEvent.VK_UP:
                //MOVER JUGADOR ARRIBA
                lienzoPadre.jugador1.moverJugadorArriba();
                break;
            case KeyEvent.VK_E:
                //MOVER JUGADOR ARRIBA DERECHA
                lienzoPadre.jugador1.moverJugadorArribaDerecha();
                break;
            case KeyEvent.VK_RIGHT:
                //MOVER JUGADOR DERECHA
                lienzoPadre.jugador1.moverJugadorDerecha();
                break;
            case KeyEvent.VK_D:
                //MOVER JUGADOR ABAJO DERECHA
                lienzoPadre.jugador1.moverJugadorAbajoDerecha();
                break;
            case KeyEvent.VK_DOWN:
                //MOVER JUGADOR ABAJO
                lienzoPadre.jugador1.moverJugadorAbajo();
                break;
            case KeyEvent.VK_A:
                //MOVER JUGADOR ABAJO IZQUIERDA
                lienzoPadre.jugador1.moverJugadorAbajoIzquierda();
                break;
            case KeyEvent.VK_LEFT:
                //MOVER JUGADOR IZQUIERDA
                lienzoPadre.jugador1.moverJugadorIzquierda();
                break;
        }
    }
    
    
    private void generarObstaculos(int cantidad){
        int contador = 0;
        while(contador < cantidad){
            int x = numeroAleatorio(0, anchuraMundoVirtual - 1);
            int y = numeroAleatorio(0, alturaMundoVirtual - 1);
            if(celdas[x][y].tipo != 'O' && celdas[x][y].tipo != 'P' && celdas[x][y].tipo != 'A' &&
                    celdas[x][y].tipo != 'J' && celdas[x][y].tipo != PORTERIAA && celdas[x][y].tipo != PORTERIAJ){
                celdas[x][y].tipo = 'O';
                contador++;
            }
        }
    }
    
    private void generarPorterias(){
       for(int i=6; i<12 ;i++){
           celdas[0][i].tipo = PORTERIAA;
       }
       for(int i=6; i<12 ;i++){
           celdas[anchuraMundoVirtual-1][i].tipo = PORTERIAJ;
       }
    }
    
    public void contarGol(char golPorteria,int x,int y){
        if(golPorteria == PORTERIAA){
            JOptionPane.showMessageDialog(null, "GOL A JUGADOR");
            this.lienzoPadre.ventanaPrincipal.panelConfiguracion.
                    panelContador.contadorAdversario.setText(String.valueOf(++contadorJugador));
        }
        else{
            JOptionPane.showMessageDialog(null, "GOL A ADVERSARIO");
            this.lienzoPadre.ventanaPrincipal.panelConfiguracion.
                    panelContador.contadorJugador.setText(String.valueOf(++contadorAdversario));
        }
        reiniciarCampo(x,y);
    }
    
    public void reiniciarCampo(int x, int y){
        celdas[lienzoPadre.jugador1.celdaJugador.x][lienzoPadre.jugador1.celdaJugador.y].tipo = 'C';
        lienzoPadre.jugador1.celdaJugador.x = (anchuraMundoVirtual / 2) - 3;
        lienzoPadre.jugador1.celdaJugador.y = alturaMundoVirtual / 2;
        celdas[lienzoPadre.jugador1.celdaJugador.x][lienzoPadre.jugador1.celdaJugador.y].tipo = 'J';
        celdas[lienzoPadre.adversario.celdaAdversario.x][lienzoPadre.adversario.celdaAdversario.y].tipo = 'C';
        lienzoPadre.adversario.celdaAdversario.x = (anchuraMundoVirtual / 2) + 3;
        lienzoPadre.adversario.celdaAdversario.y = alturaMundoVirtual / 2;
        celdas[lienzoPadre.adversario.celdaAdversario.x][lienzoPadre.adversario.celdaAdversario.y].tipo = 'A';
        celdas[x][y].tipo = 'C';
        lienzoPadre.pelota.celdaPelota.x = anchuraMundoVirtual / 2;
        lienzoPadre.pelota.celdaPelota.y = alturaMundoVirtual / 2;
        celdas[anchuraMundoVirtual / 2][alturaMundoVirtual / 2].tipo = 'P';
    }
}

