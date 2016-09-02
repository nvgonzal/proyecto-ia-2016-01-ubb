package ia.ia;

import ia.grafico.Adversario;
import ia.grafico.Constantes;
import ia.grafico.Jugador;
import ia.grafico.Laberinto;
import ia.grafico.Pelota;
import java.util.ArrayList;
import java.util.TimerTask;

/**
 *
 * @author Nicolas Gonzalez Tardon
 */
public class BusquedaProfundidad extends TimerTask implements Constantes {

    public Laberinto laberinto;
    public ArrayList<Estado> colaEstados;
    public ArrayList<Estado> historial;
    public ArrayList<Character> pasos;
    public int index_pasos;
    public Estado inicial;
    public Estado objetivo;
    public Estado temp;
    public boolean exito;
    public Adversario adversario;
    public ArrayList<Estado> destinos;
    public boolean parar;

    public Pelota pelota;

    public BusquedaProfundidad(Laberinto laberinto, Adversario jugador, Pelota pelota) {
        this.laberinto = laberinto;
        colaEstados = new ArrayList<>();
        historial = new ArrayList<>();
        pasos = new ArrayList<>();
        index_pasos = 0;
        exito = false;
        this.adversario = jugador;
        destinos = new ArrayList<>();
        parar = false;
        this.pelota = pelota;
    }

    @Override
    public synchronized void run() {
        if (!laberinto.lienzoPadre.buscarPelotaA()) {
            if (!parar) {
                colaEstados.clear();
                historial.clear();
                pasos.clear();
                Estado subinicial, subobjetivo;
                boolean resultado;
                subinicial = new Estado(adversario.celdaAdversario.x,
                        adversario.celdaAdversario.y, 'N', null);
                subobjetivo = new Estado(
                        pelota.celdaPelota.x,
                        pelota.celdaPelota.y, 'N', null);
                resultado = this.buscar(subinicial, subobjetivo);
                if (pasos.size() > 1) {
                    switch (pasos.get(1)) {
                        case 'D':
                            adversario.moverAdversarioAbajo();
                            break;
                        case 'U':
                            adversario.moverAdversarioArriba();
                            break;
                        case 'R':
                            adversario.moverAdversarioDerecha();
                            break;
                        case 'L':
                            adversario.moverAdversarioIzquierda();
                            break;
                    }
                    laberinto.lienzoPadre.repaint();
                }
            }
        } else if (!parar) {
            colaEstados.clear();
            historial.clear();
            pasos.clear();
            Estado subinicial, subobjetivo;
            boolean resultado;
            subinicial = new Estado(adversario.celdaAdversario.x,
                    adversario.celdaAdversario.y, 'N', null);
            subobjetivo = new Estado(
                    0,
                    9, 'N', null);
            resultado = this.buscar(subinicial, subobjetivo);
            if (pasos.size() > 1) {
                switch (pasos.get(1)) {
                    case 'D':
                        if(laberinto.celdas[adversario.celdaAdversario.x][adversario.celdaAdversario.y + 1].tipo != 'P'){
                            pelota.moverPelotaAbajo('A');
                        }
                        adversario.moverAdversarioAbajo();
                        break;
                    case 'U':
                        if(laberinto.celdas[adversario.celdaAdversario.x][adversario.celdaAdversario.y - 1].tipo != 'P'){
                            pelota.moverPelotaArriba('A');
                        }
                        adversario.moverAdversarioArriba();
                        break;
                    case 'R':
                        if(laberinto.celdas[adversario.celdaAdversario.x + 1][adversario.celdaAdversario.y].tipo != 'P'){
                            pelota.moverPelotaDerecha('A');
                        }
                        adversario.moverAdversarioDerecha();
                        break;
                    case 'L':
                        if(laberinto.celdas[adversario.celdaAdversario.x - 1][adversario.celdaAdversario.y].tipo != 'P'){
                            pelota.moverPelotaIzquierda('A');
                        }
                        adversario.moverAdversarioIzquierda();
                        break;
                }
                laberinto.lienzoPadre.repaint();
            }
        }
    }

    public boolean buscar(Estado inicial, Estado objetivo) {
        index_pasos = 0;
        colaEstados.add(inicial);
        historial.add(inicial);
        this.objetivo = objetivo;
        exito = false;
        if (inicial.equals(objetivo)) {
            exito = true;
        }
        while (!colaEstados.isEmpty() && !exito) {
            temp = colaEstados.get(0);
            colaEstados.remove(0);
            moverArriba(temp);
            moverAbajo(temp);
            moverIzquierda(temp);
            moverDerecha(temp);
        }
        if (exito) {
            System.out.println("Ruta calculada");
            this.calcularRuta();
            return true;
        } else {
            System.out.println("La ruta no pudo calcularse");
            return false;
        }
    }

    public void calcularRuta() {
        Estado predecesor = objetivo;
        do {
            pasos.add(0, predecesor.oper);
            predecesor = predecesor.predecesor;
        } while (predecesor != null);
        index_pasos = pasos.size() - 1;
    }

    private void moverArriba(Estado e) {
        if (e.y > 0) {
            if (laberinto.celdas[e.x][e.y - 1].tipo != 'O' &&
                    laberinto.celdas[e.x][e.y - 1].tipo != 'J') {
                Estado arriba = new Estado(e.x, e.y - 1, 'U', e
                );
                if (!historial.contains(arriba)) {
                    colaEstados.add(arriba);
                    historial.add(arriba);
                    if (arriba.equals(objetivo)) {
                        objetivo = arriba;
                        exito = true;
                    }
                }
            }
        }
    }

    private void moverAbajo(Estado e) {
        if (e.y + 1 < alturaMundoVirtual) {
            if (laberinto.celdas[e.x][e.y + 1].tipo != 'O' &&
                    laberinto.celdas[e.x][e.y + 1].tipo != 'J') {
                Estado abajo = new Estado(e.x, e.y + 1, 'D', e);
                if (!historial.contains(abajo)) {
                    colaEstados.add(abajo);
                    historial.add(abajo);
                    if (abajo.equals(objetivo)) {
                        objetivo = abajo;
                        exito = true;
                    }
                }
            }
        }
    }

    private void moverIzquierda(Estado e) {
        if (e.x > 0) {
            if (laberinto.celdas[e.x - 1][e.y].tipo != 'O' &&
                    laberinto.celdas[e.x - 1][e.y].tipo != 'J') {
                Estado izquierda = new Estado(e.x - 1, e.y, 'L', e);
                if (!historial.contains(izquierda)) {
                    colaEstados.add(izquierda);
                    historial.add(izquierda);
                    if (izquierda.equals(objetivo)) {
                        objetivo = izquierda;
                        exito = true;
                    }
                }
            }
        }
    }

    private void moverDerecha(Estado e) {
        if (e.x < anchuraMundoVirtual - 1) {
            if (laberinto.celdas[e.x + 1][e.y].tipo != 'O' &&
                    laberinto.celdas[e.x + 1][e.y].tipo != 'J') {
                Estado derecha = new Estado(e.x + 1, e.y, 'R', e);
                if (!historial.contains(derecha)) {
                    colaEstados.add(derecha);
                    historial.add(derecha);
                    if (derecha.equals(objetivo)) {
                        objetivo = derecha;
                        exito = true;
                    }
                }
            }
        }
    }

}
