package ia.grafico;

import ia.ia.BusquedaProfundidad;
import java.util.TimerTask;

/**
 *
 * @author Nicolas Gonzalez Tardon
 */
public class Adversario implements Constantes {

    public Laberinto laberinto;
    public Celda celdaAdversario;
    
    public Pelota pelota;
    
    public BusquedaProfundidad inteligencia;

    public Adversario(Laberinto laberinto,Pelota pelota) {
        this.laberinto = laberinto;
        this.pelota = pelota;
        celdaAdversario = new Celda((anchuraMundoVirtual / 2) + 6, alturaMundoVirtual / 2, 'A');
        laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo = 'A';
        this.inteligencia = new BusquedaProfundidad(laberinto, this,pelota);
    }

    public void moverAdversarioArribaIzquierda() {
        if (celdaAdversario.y > 0 && celdaAdversario.x > 0) {
            if (laberinto.celdas[celdaAdversario.x - 1][celdaAdversario.y - 1].tipo != 'O'
                    && laberinto.celdas[celdaAdversario.x - 1][celdaAdversario.y - 1].tipo != PORTERIAA
                    && laberinto.celdas[celdaAdversario.x - 1][celdaAdversario.y - 1].tipo != PORTERIAJ) {

                if (laberinto.celdas[celdaAdversario.x - 1][celdaAdversario.y - 1].tipo == 'P') {
                    if (celdaAdversario.y - 2 >= 0 && celdaAdversario.x - 2 >= 0
                            && laberinto.celdas[celdaAdversario.x - 2][celdaAdversario.y - 2].tipo != 'O'
                            && laberinto.celdas[celdaAdversario.x - 2][celdaAdversario.y - 2].tipo != 'J') {
                        if (laberinto.celdas[celdaAdversario.x - 2][celdaAdversario.y - 2].tipo == PORTERIAA) {
                            laberinto.contarGol(PORTERIAA, celdaAdversario.x - 1, celdaAdversario.y - 1);
                        } else if (laberinto.celdas[celdaAdversario.x - 2][celdaAdversario.y - 2].tipo == PORTERIAJ) {
                            laberinto.contarGol(PORTERIAA, celdaAdversario.x - 2, celdaAdversario.y + 1);
                        } else {
                            laberinto.celdas[celdaAdversario.x - 2][celdaAdversario.y - 2].tipo = 'P';
                            pelota.celdaPelota.x--;
                            pelota.celdaPelota.y--;
                            laberinto.celdas[celdaAdversario.x - 1][celdaAdversario.y - 1].tipo = 'C';
                        }

                    } else {
                        laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo = 'C';
                        laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo = 'P';
                        pelota.celdaPelota.x = celdaAdversario.x;
                        pelota.celdaPelota.y = celdaAdversario.y;
                        this.celdaAdversario.y -= 1;
                        this.celdaAdversario.x -= 1;
                        laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo = 'A';
                    }
                } else if (laberinto.celdas[celdaAdversario.x - 1][celdaAdversario.y - 1].tipo != 'J') {
                    laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo = 'C';
                    this.celdaAdversario.y -= 1;
                    this.celdaAdversario.x -= 1;
                    laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo = 'A';
                } else {
                    this.moverAdversarioAbajoDerecha();
                    laberinto.lienzoPadre.jugador1.moverJugadorArribaIzquierda();
                }
            }
        }
    }

    public void moverAdversarioArriba() {
        if (celdaAdversario.y > 0) {
            if (laberinto.celdas[celdaAdversario.x][celdaAdversario.y - 1].tipo != 'O'
                    && laberinto.celdas[celdaAdversario.x][celdaAdversario.y - 1].tipo != PORTERIAA
                    && laberinto.celdas[celdaAdversario.x][celdaAdversario.y - 1].tipo != PORTERIAJ) {

                if (laberinto.celdas[celdaAdversario.x][celdaAdversario.y - 1].tipo == 'P') {
                    if (celdaAdversario.y - 2 >= 0
                            && laberinto.celdas[celdaAdversario.x][celdaAdversario.y - 2].tipo != 'O'
                            && laberinto.celdas[celdaAdversario.x][celdaAdversario.y - 2].tipo != 'J') {
                        if (laberinto.celdas[celdaAdversario.x][celdaAdversario.y - 2].tipo == PORTERIAA) {
                            laberinto.contarGol(PORTERIAA, celdaAdversario.x, celdaAdversario.y - 1);
                        } else if (laberinto.celdas[celdaAdversario.x][celdaAdversario.y - 2].tipo == PORTERIAJ) {
                            laberinto.contarGol(PORTERIAA, celdaAdversario.x, celdaAdversario.y - 1);
                        } else {
                            laberinto.celdas[celdaAdversario.x][celdaAdversario.y - 2].tipo = 'P';
                            pelota.celdaPelota.y--;
                            laberinto.celdas[celdaAdversario.x][celdaAdversario.y - 1].tipo = 'C';
                        }

                    } else {
                        laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo = 'C';
                        laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo = 'P';
                        pelota.celdaPelota.y = celdaAdversario.y;
                        this.celdaAdversario.y -= 1;
                        laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo = 'A';
                    }
                } else if (laberinto.celdas[celdaAdversario.x][celdaAdversario.y - 1].tipo != 'J') {
                    laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo = 'C';
                    this.celdaAdversario.y -= 1;
                    laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo = 'A';
                } else {
                    this.moverAdversarioAbajo();
                    this.moverAdversarioArriba();
                }
            }
        }
    }

    public void moverAdversarioArribaDerecha() {
        if (celdaAdversario.y > 0 && celdaAdversario.x < anchuraMundoVirtual - 1) {
            if (laberinto.celdas[celdaAdversario.x + 1][celdaAdversario.y - 1].tipo != 'O'
                    && laberinto.celdas[celdaAdversario.x + 1][celdaAdversario.y - 1].tipo != PORTERIAA
                    && laberinto.celdas[celdaAdversario.x + 1][celdaAdversario.y - 1].tipo != PORTERIAJ) {

                if (laberinto.celdas[celdaAdversario.x + 1][celdaAdversario.y - 1].tipo == 'P') {
                    if (celdaAdversario.y - 2 >= 0 && celdaAdversario.x + 2 < anchuraMundoVirtual
                            && laberinto.celdas[celdaAdversario.x + 2][celdaAdversario.y - 2].tipo != 'O'
                            && laberinto.celdas[celdaAdversario.x + 2][celdaAdversario.y - 2].tipo != 'J') {
                        if (laberinto.celdas[celdaAdversario.x + 2][celdaAdversario.y - 2].tipo == PORTERIAA) {
                            laberinto.contarGol(PORTERIAA, celdaAdversario.x + 1, celdaAdversario.y - 1);
                        } else if (laberinto.celdas[celdaAdversario.x + 2][celdaAdversario.y - 2].tipo == PORTERIAJ) {
                            laberinto.contarGol(PORTERIAA, celdaAdversario.x + 1, celdaAdversario.y - 1);
                        } else {
                            laberinto.celdas[celdaAdversario.x + 2][celdaAdversario.y - 2].tipo = 'P';
                            pelota.celdaPelota.x++;
                            pelota.celdaPelota.y--;
                            laberinto.celdas[celdaAdversario.x + 1][celdaAdversario.y - 1].tipo = 'C';
                        }
                    } else {
                        laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo = 'C';
                        laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo = 'P';
                        pelota.celdaPelota.x = celdaAdversario.x;
                        pelota.celdaPelota.y = celdaAdversario.y;
                        this.celdaAdversario.y -= 1;
                        this.celdaAdversario.x += 1;
                        laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo = 'A';
                    }
                } else if (laberinto.celdas[celdaAdversario.x + 1][celdaAdversario.y - 1].tipo != 'J') {
                    laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo = 'C';
                    this.celdaAdversario.y -= 1;
                    this.celdaAdversario.x += 1;
                    laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo = 'A';
                } else {
                    this.moverAdversarioAbajoIzquierda();
                    laberinto.lienzoPadre.jugador1.moverJugadorArribaDerecha();
                }
            }
        }
    }

    public void moverAdversarioDerecha() {
        if (celdaAdversario.x < anchuraMundoVirtual - 1) {
            if (laberinto.celdas[celdaAdversario.x + 1][celdaAdversario.y].tipo != 'O'
                    && laberinto.celdas[celdaAdversario.x + 1][celdaAdversario.y].tipo != PORTERIAA
                    && laberinto.celdas[celdaAdversario.x + 1][celdaAdversario.y].tipo != PORTERIAJ) {
                if (laberinto.celdas[celdaAdversario.x + 1][celdaAdversario.y].tipo == 'P') {
                    if (celdaAdversario.x + 2 < anchuraMundoVirtual
                            && laberinto.celdas[celdaAdversario.x + 2][celdaAdversario.y].tipo != 'O'
                            && laberinto.celdas[celdaAdversario.x + 2][celdaAdversario.y].tipo != 'J') {
                        if (laberinto.celdas[celdaAdversario.x + 2][celdaAdversario.y].tipo == PORTERIAA) {
                            laberinto.contarGol(PORTERIAA, celdaAdversario.x + 1, celdaAdversario.y);
                        } else if (laberinto.celdas[celdaAdversario.x + 2][celdaAdversario.y].tipo == PORTERIAJ) {
                            laberinto.contarGol(PORTERIAA, celdaAdversario.x + 1, celdaAdversario.y);
                        } else {
                            laberinto.celdas[celdaAdversario.x + 2][celdaAdversario.y].tipo = 'P';
                            pelota.celdaPelota.x++;
                            laberinto.celdas[celdaAdversario.x + 1][celdaAdversario.y].tipo = 'C';
                        }

                    } else {
                        laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo = 'C';
                        laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo = 'P';
                        pelota.celdaPelota.x = celdaAdversario.x;
                        this.celdaAdversario.x += 1;
                        laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo = 'A';
                    }
                } else if (laberinto.celdas[celdaAdversario.x + 1][celdaAdversario.y].tipo != 'J') {
                    laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo = 'C';
                    this.celdaAdversario.x += 1;
                    laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo = 'A';
                } else {
                    this.moverAdversarioIzquierda();
                    laberinto.lienzoPadre.jugador1.moverJugadorDerecha();
                }
            }

        }
    }

    public void moverAdversarioAbajoDerecha() {
        if (celdaAdversario.y < alturaMundoVirtual - 1 && celdaAdversario.x < anchuraMundoVirtual - 1) {
            if (laberinto.celdas[celdaAdversario.x + 1][celdaAdversario.y + 1].tipo != 'O'
                    && laberinto.celdas[celdaAdversario.x + 1][celdaAdversario.y + 1].tipo != PORTERIAA
                    && laberinto.celdas[celdaAdversario.x + 1][celdaAdversario.y + 1].tipo != PORTERIAJ) {

                if (laberinto.celdas[celdaAdversario.x + 1][celdaAdversario.y + 1].tipo == 'P') {
                    if (celdaAdversario.y + 2 < alturaMundoVirtual && celdaAdversario.x + 2 < anchuraMundoVirtual
                            && laberinto.celdas[celdaAdversario.x + 2][celdaAdversario.y + 2].tipo != 'O'
                            && laberinto.celdas[celdaAdversario.x + 2][celdaAdversario.y + 2].tipo != 'J') {
                        if (laberinto.celdas[celdaAdversario.x + 2][celdaAdversario.y + 2].tipo == PORTERIAA) {
                            laberinto.contarGol(PORTERIAA, celdaAdversario.x + 1, celdaAdversario.y + 1);
                        } else if (laberinto.celdas[celdaAdversario.x + 2][celdaAdversario.y + 2].tipo == PORTERIAJ) {
                            laberinto.contarGol(PORTERIAA, celdaAdversario.x + 1, celdaAdversario.y + 1);
                        } else {
                            laberinto.celdas[celdaAdversario.x + 2][celdaAdversario.y + 2].tipo = 'P';
                            pelota.celdaPelota.x++;
                            pelota.celdaPelota.y++;
                            laberinto.celdas[celdaAdversario.x + 1][celdaAdversario.y + 1].tipo = 'C';
                        }

                    } else {
                        laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo = 'C';
                        laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo = 'P';
                        pelota.celdaPelota.x = celdaAdversario.x;
                        pelota.celdaPelota.y = celdaAdversario.y;
                        this.celdaAdversario.y += 1;
                        this.celdaAdversario.x += 1;
                        laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo = 'A';
                    }
                } else if (laberinto.celdas[celdaAdversario.x + 1][celdaAdversario.y + 1].tipo != 'J') {
                    laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo = 'C';
                    this.celdaAdversario.y += 1;
                    this.celdaAdversario.x += 1;
                    laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo = 'A';
                } else {
                    this.moverAdversarioArribaIzquierda();
                    laberinto.lienzoPadre.jugador1.moverJugadorAbajoDerecha();
                }
            }
        }
    }

    public void moverAdversarioAbajo() {
        if (celdaAdversario.y < alturaMundoVirtual - 1) {
            if (laberinto.celdas[celdaAdversario.x][celdaAdversario.y + 1].tipo != 'O'
                    && laberinto.celdas[celdaAdversario.x][celdaAdversario.y + 1].tipo != PORTERIAA
                    && laberinto.celdas[celdaAdversario.x][celdaAdversario.y + 1].tipo != PORTERIAJ) {

                if (laberinto.celdas[celdaAdversario.x][celdaAdversario.y + 1].tipo == 'P') {
                    if (celdaAdversario.y + 2 < alturaMundoVirtual
                            && laberinto.celdas[celdaAdversario.x][celdaAdversario.y + 2].tipo != 'O'
                            && laberinto.celdas[celdaAdversario.x][celdaAdversario.y + 2].tipo != 'J') {
                        if (laberinto.celdas[celdaAdversario.x][celdaAdversario.y + 2].tipo == PORTERIAA) {
                            laberinto.contarGol(PORTERIAA, celdaAdversario.x, celdaAdversario.y + 1);
                        } else if (laberinto.celdas[celdaAdversario.x][celdaAdversario.y + 2].tipo == PORTERIAJ) {
                            laberinto.contarGol(PORTERIAA, celdaAdversario.x, celdaAdversario.y + 1);
                        } else {
                            laberinto.celdas[celdaAdversario.x][celdaAdversario.y + 2].tipo = 'P';
                            pelota.celdaPelota.y++;
                            laberinto.celdas[celdaAdversario.x][celdaAdversario.y + 1].tipo = 'C';
                        }

                    } else {
                        laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo = 'C';
                        laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo = 'P';
                        pelota.celdaPelota.y = celdaAdversario.y;
                        this.celdaAdversario.y += 1;
                        laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo = 'A';
                    }
                } else if (laberinto.celdas[celdaAdversario.x][celdaAdversario.y + 1].tipo != 'J') {
                    laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo = 'C';
                    this.celdaAdversario.y += 1;
                    laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo = 'A';
                } else {
                    this.moverAdversarioArriba();
                    laberinto.lienzoPadre.jugador1.moverJugadorAbajo();
                }
            }

        }
    }

    public void moverAdversarioAbajoIzquierda() {
        if (celdaAdversario.y < alturaMundoVirtual - 1 && celdaAdversario.x > 0) {
            if (laberinto.celdas[celdaAdversario.x - 1][celdaAdversario.y + 1].tipo != 'O'
                    && laberinto.celdas[celdaAdversario.x - 1][celdaAdversario.y + 1].tipo != PORTERIAA
                    && laberinto.celdas[celdaAdversario.x - 1][celdaAdversario.y + 1].tipo != PORTERIAJ) {

                if (laberinto.celdas[celdaAdversario.x - 1][celdaAdversario.y + 1].tipo == 'P') {
                    if (celdaAdversario.y + 2 < alturaMundoVirtual && celdaAdversario.x - 2 >= 0
                            && laberinto.celdas[celdaAdversario.x - 2][celdaAdversario.y + 2].tipo != 'O'
                            && laberinto.celdas[celdaAdversario.x - 2][celdaAdversario.y + 2].tipo != 'J') {
                        if (laberinto.celdas[celdaAdversario.x - 2][celdaAdversario.y + 2].tipo == PORTERIAA) {
                            laberinto.contarGol(PORTERIAA, celdaAdversario.x - 1, celdaAdversario.y + 1);
                        } else if (laberinto.celdas[celdaAdversario.x - 2][celdaAdversario.y + 2].tipo == PORTERIAJ) {
                            laberinto.contarGol(PORTERIAA, celdaAdversario.x - 1, celdaAdversario.y + 1);
                        } else {
                            laberinto.celdas[celdaAdversario.x - 2][celdaAdversario.y + 2].tipo = 'P';
                            pelota.celdaPelota.x--;
                            pelota.celdaPelota.y++;
                            laberinto.celdas[celdaAdversario.x - 1][celdaAdversario.y + 1].tipo = 'C';
                        }

                    } else {
                        laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo = 'C';
                        laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo = 'P';
                        pelota.celdaPelota.x = celdaAdversario.x;
                        pelota.celdaPelota.y = celdaAdversario.y;
                        this.celdaAdversario.y += 1;
                        this.celdaAdversario.x -= 1;
                        laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo = 'A';
                    }
                } else if (laberinto.celdas[celdaAdversario.x - 1][celdaAdversario.y + 1].tipo != 'J') {
                    laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo = 'C';
                    this.celdaAdversario.y += 1;
                    this.celdaAdversario.x -= 1;
                    laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo = 'A';
                } else {
                    this.moverAdversarioArribaDerecha();
                    laberinto.lienzoPadre.jugador1.moverJugadorArribaIzquierda();
                }
            }
        }
    }

    public void moverAdversarioIzquierda() {
        if (celdaAdversario.x > 0) {
            if (laberinto.celdas[celdaAdversario.x - 1][celdaAdversario.y].tipo != 'O'
                    && laberinto.celdas[celdaAdversario.x - 1][celdaAdversario.y].tipo != PORTERIAA
                    && laberinto.celdas[celdaAdversario.x - 1][celdaAdversario.y].tipo != PORTERIAJ) {

                if (laberinto.celdas[celdaAdversario.x - 1][celdaAdversario.y].tipo == 'P') {
                    if (celdaAdversario.x - 2 >= 0
                            && laberinto.celdas[celdaAdversario.x - 2][celdaAdversario.y].tipo != 'O'
                            && laberinto.celdas[celdaAdversario.x - 2][celdaAdversario.y].tipo != 'J') {
                        if (laberinto.celdas[celdaAdversario.x - 2][celdaAdversario.y].tipo == PORTERIAA) {
                            laberinto.contarGol(PORTERIAA, celdaAdversario.x - 1, celdaAdversario.y);
                        } else if (laberinto.celdas[celdaAdversario.x - 2][celdaAdversario.y].tipo == PORTERIAJ) {
                            laberinto.contarGol(PORTERIAA, celdaAdversario.x - 1, celdaAdversario.y);
                        } else {
                            laberinto.celdas[celdaAdversario.x - 2][celdaAdversario.y].tipo = 'P';
                            pelota.celdaPelota.x--;
                            laberinto.celdas[celdaAdversario.x - 1][celdaAdversario.y].tipo = 'C';
                        }

                    } else {
                        laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo = 'C';
                        laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo = 'P';
                        pelota.celdaPelota.x = celdaAdversario.x;
                        this.celdaAdversario.x -= 1;
                        laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo = 'A';
                    }
                } else if (laberinto.celdas[celdaAdversario.x - 1][celdaAdversario.y].tipo != 'J') {
                    laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo = 'C';
                    this.celdaAdversario.x -= 1;
                    laberinto.celdas[celdaAdversario.x][celdaAdversario.y].tipo = 'A';
                } else {
                    this.moverAdversarioDerecha();
                    laberinto.lienzoPadre.jugador1.moverJugadorIzquierda();
                }
            }

        }
    }
}
