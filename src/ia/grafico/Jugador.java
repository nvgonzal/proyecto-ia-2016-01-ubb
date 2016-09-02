package ia.grafico;

/**
 *
 * @author Nicolas Gonzalez Tardon
 */
public class Jugador implements Constantes {

    public Laberinto laberinto;
    public Celda celdaJugador;
    public Pelota pelota;

    public Jugador(Laberinto laberinto,Pelota pelota) {
        this.pelota = pelota;
        this.laberinto = laberinto;
        celdaJugador = new Celda((anchuraMundoVirtual / 2) - 6, alturaMundoVirtual / 2, 'J');
        laberinto.celdas[celdaJugador.x][celdaJugador.y].tipo = 'J';
    }

    public void moverJugadorArribaIzquierda() {
        if (celdaJugador.y > 0 && celdaJugador.x > 0) {
            if (laberinto.celdas[celdaJugador.x - 1][celdaJugador.y - 1].tipo != 'O'
                    && laberinto.celdas[celdaJugador.x - 1][celdaJugador.y - 1].tipo != PORTERIAA
                    && laberinto.celdas[celdaJugador.x - 1][celdaJugador.y - 1].tipo != PORTERIAJ) {

                if (laberinto.celdas[celdaJugador.x - 1][celdaJugador.y - 1].tipo == 'P') {
                    if (celdaJugador.y - 2 >= 0 && celdaJugador.x - 2 >= 0
                            && laberinto.celdas[celdaJugador.x - 2][celdaJugador.y - 2].tipo != 'O'
                            & laberinto.celdas[celdaJugador.x - 2][celdaJugador.y - 2].tipo != 'A') {
                        if (laberinto.celdas[celdaJugador.x - 2][celdaJugador.y - 2].tipo == PORTERIAA) {
                            laberinto.contarGol(PORTERIAA, celdaJugador.x - 1, celdaJugador.y - 1);
                        } else if (laberinto.celdas[celdaJugador.x - 2][celdaJugador.y - 2].tipo == PORTERIAJ) {
                            laberinto.contarGol(PORTERIAJ, celdaJugador.x - 1, celdaJugador.y - 1);
                        } else {
                            laberinto.celdas[celdaJugador.x - 2][celdaJugador.y - 2].tipo = 'P';
                            pelota.celdaPelota.x--;
                            pelota.celdaPelota.y--;
                            laberinto.celdas[celdaJugador.x - 1][celdaJugador.y - 1].tipo = 'C';
                        }

                    } else {
                        laberinto.celdas[celdaJugador.x][celdaJugador.y].tipo = 'C';
                        laberinto.celdas[celdaJugador.x][celdaJugador.y].tipo = 'P';
                        pelota.celdaPelota.x = celdaJugador.x;
                        pelota.celdaPelota.y = celdaJugador.y;
                        this.celdaJugador.y -= 1;
                        this.celdaJugador.x -= 1;
                        laberinto.celdas[celdaJugador.x][celdaJugador.y].tipo = 'J';
                    }
                } else if (laberinto.celdas[celdaJugador.x - 1][celdaJugador.y - 1].tipo != 'A') {
                    laberinto.celdas[celdaJugador.x][celdaJugador.y].tipo = 'C';
                    this.celdaJugador.y -= 1;
                    this.celdaJugador.x -= 1;
                    laberinto.celdas[celdaJugador.x][celdaJugador.y].tipo = 'J';
                } else {
                    this.moverJugadorAbajoDerecha();
                    laberinto.lienzoPadre.adversario.moverAdversarioArribaIzquierda();
                }
            }
        }
    }

    public void moverJugadorArriba() {
        if (celdaJugador.y > 0) {
            if (laberinto.celdas[celdaJugador.x][celdaJugador.y - 1].tipo != 'O'
                    && laberinto.celdas[celdaJugador.x][celdaJugador.y - 1].tipo != PORTERIAA
                    && laberinto.celdas[celdaJugador.x][celdaJugador.y - 1].tipo != PORTERIAJ) {

                if (laberinto.celdas[celdaJugador.x][celdaJugador.y - 1].tipo == 'P') {
                    if (celdaJugador.y - 2 >= 0
                            && laberinto.celdas[celdaJugador.x][celdaJugador.y - 2].tipo != 'O'
                            && laberinto.celdas[celdaJugador.x][celdaJugador.y - 2].tipo != 'A') {
                        if (laberinto.celdas[celdaJugador.x][celdaJugador.y - 2].tipo == PORTERIAA) {
                            laberinto.contarGol(PORTERIAA, celdaJugador.x, celdaJugador.y - 1);
                        } else if (laberinto.celdas[celdaJugador.x][celdaJugador.y - 2].tipo == PORTERIAJ) {
                            laberinto.contarGol(PORTERIAJ, celdaJugador.x, celdaJugador.y - 1);
                        } else {
                            laberinto.celdas[celdaJugador.x][celdaJugador.y - 2].tipo = 'P';
                            pelota.celdaPelota.y--;
                            laberinto.celdas[celdaJugador.x][celdaJugador.y - 1].tipo = 'C';
                        }

                    } else {
                        laberinto.celdas[celdaJugador.x][celdaJugador.y].tipo = 'C';
                        laberinto.celdas[celdaJugador.x][celdaJugador.y].tipo = 'P';
                        pelota.celdaPelota.y = celdaJugador.y;
                        this.celdaJugador.y -= 1;
                        laberinto.celdas[celdaJugador.x][celdaJugador.y].tipo = 'J';
                    }
                } else if (laberinto.celdas[celdaJugador.x][celdaJugador.y - 1].tipo != 'A') {
                    laberinto.celdas[celdaJugador.x][celdaJugador.y].tipo = 'C';
                    this.celdaJugador.y -= 1;
                    laberinto.celdas[celdaJugador.x][celdaJugador.y].tipo = 'J';
                } else {
                    this.moverJugadorAbajo();
                    laberinto.lienzoPadre.adversario.moverAdversarioArriba();
                }
            }
        }
    }

    public void moverJugadorArribaDerecha() {
        if (celdaJugador.y > 0 && celdaJugador.x < anchuraMundoVirtual - 1) {
            if (laberinto.celdas[celdaJugador.x + 1][celdaJugador.y - 1].tipo != 'O'
                    && laberinto.celdas[celdaJugador.x + 1][celdaJugador.y - 1].tipo != PORTERIAA
                    && laberinto.celdas[celdaJugador.x + 1][celdaJugador.y - 1].tipo != PORTERIAJ) {

                if (laberinto.celdas[celdaJugador.x + 1][celdaJugador.y - 1].tipo == 'P') {
                    if (celdaJugador.y - 2 >= 0 && celdaJugador.x + 2 < anchuraMundoVirtual
                            && laberinto.celdas[celdaJugador.x + 2][celdaJugador.y - 2].tipo != 'O'
                            & laberinto.celdas[celdaJugador.x + 2][celdaJugador.y - 2].tipo != 'A') {
                        if (laberinto.celdas[celdaJugador.x + 2][celdaJugador.y - 2].tipo == PORTERIAA) {
                            laberinto.contarGol(PORTERIAA, celdaJugador.x + 1, celdaJugador.y - 1);
                        } else if (laberinto.celdas[celdaJugador.x - 2][celdaJugador.y - 2].tipo == PORTERIAJ) {
                            laberinto.contarGol(PORTERIAJ, celdaJugador.x + 1, celdaJugador.y - 1);
                        } else {
                            laberinto.celdas[celdaJugador.x + 2][celdaJugador.y - 2].tipo = 'P';
                            pelota.celdaPelota.x++;
                            pelota.celdaPelota.y--;
                            laberinto.celdas[celdaJugador.x + 1][celdaJugador.y - 1].tipo = 'C';
                        }
                    } else {
                        laberinto.celdas[celdaJugador.x][celdaJugador.y].tipo = 'C';
                        laberinto.celdas[celdaJugador.x][celdaJugador.y].tipo = 'P';
                        pelota.celdaPelota.x = celdaJugador.x;
                        pelota.celdaPelota.y = celdaJugador.y;
                        this.celdaJugador.y -= 1;
                        this.celdaJugador.x += 1;
                        laberinto.celdas[celdaJugador.x][celdaJugador.y].tipo = 'J';
                    }
                } else if (laberinto.celdas[celdaJugador.x + 1][celdaJugador.y - 1].tipo != 'A') {
                    laberinto.celdas[celdaJugador.x][celdaJugador.y].tipo = 'C';
                    this.celdaJugador.y -= 1;
                    this.celdaJugador.x += 1;
                    laberinto.celdas[celdaJugador.x][celdaJugador.y].tipo = 'J';
                } else {
                    this.moverJugadorAbajoIzquierda();
                    laberinto.lienzoPadre.adversario.moverAdversarioArribaDerecha();
                }
            }
        }
    }

    public void moverJugadorDerecha() {
        if (celdaJugador.x < anchuraMundoVirtual - 1) {
            if (laberinto.celdas[celdaJugador.x + 1][celdaJugador.y].tipo != 'O'
                    && laberinto.celdas[celdaJugador.x + 1][celdaJugador.y].tipo != PORTERIAA
                    && laberinto.celdas[celdaJugador.x + 1][celdaJugador.y].tipo != PORTERIAJ) {

                if (laberinto.celdas[celdaJugador.x + 1][celdaJugador.y].tipo == 'P') {
                    if (celdaJugador.x + 2 < anchuraMundoVirtual
                            && laberinto.celdas[celdaJugador.x + 2][celdaJugador.y].tipo != 'O'
                            && laberinto.celdas[celdaJugador.x + 2][celdaJugador.y].tipo != 'A') {
                        if (laberinto.celdas[celdaJugador.x + 2][celdaJugador.y].tipo == PORTERIAA) {
                            laberinto.contarGol(PORTERIAA, celdaJugador.x + 1, celdaJugador.y);
                        } else if (laberinto.celdas[celdaJugador.x + 2][celdaJugador.y].tipo == PORTERIAJ) {
                            laberinto.contarGol(PORTERIAJ, celdaJugador.x + 1, celdaJugador.y);
                        } else {
                            laberinto.celdas[celdaJugador.x + 2][celdaJugador.y].tipo = 'P';
                            pelota.celdaPelota.x++;
                            laberinto.celdas[celdaJugador.x + 1][celdaJugador.y].tipo = 'C';
                        }

                    } else {
                        laberinto.celdas[celdaJugador.x][celdaJugador.y].tipo = 'C';
                        laberinto.celdas[celdaJugador.x][celdaJugador.y].tipo = 'P';
                        pelota.celdaPelota.x = celdaJugador.x;
                        this.celdaJugador.x += 1;
                        laberinto.celdas[celdaJugador.x][celdaJugador.y].tipo = 'J';
                    }
                } else if (laberinto.celdas[celdaJugador.x + 1][celdaJugador.y].tipo != 'A') {
                    laberinto.celdas[celdaJugador.x][celdaJugador.y].tipo = 'C';
                    this.celdaJugador.x += 1;
                    laberinto.celdas[celdaJugador.x][celdaJugador.y].tipo = 'J';
                } else {
                    this.moverJugadorIzquierda();
                    laberinto.lienzoPadre.adversario.moverAdversarioDerecha();
                }
            }

        }
    }

    public void moverJugadorAbajoDerecha() {
        if (celdaJugador.y < alturaMundoVirtual - 1 && celdaJugador.x < anchuraMundoVirtual - 1) {
            if (laberinto.celdas[celdaJugador.x + 1][celdaJugador.y + 1].tipo != 'O'
                    && laberinto.celdas[celdaJugador.x + 1][celdaJugador.y + 1].tipo != PORTERIAA
                    && laberinto.celdas[celdaJugador.x + 1][celdaJugador.y + 1].tipo != PORTERIAJ) {

                if (laberinto.celdas[celdaJugador.x + 1][celdaJugador.y + 1].tipo == 'P') {
                    if (celdaJugador.y + 2 < alturaMundoVirtual && celdaJugador.x + 2 < anchuraMundoVirtual
                            && laberinto.celdas[celdaJugador.x + 2][celdaJugador.y + 2].tipo != 'O'
                            & laberinto.celdas[celdaJugador.x + 2][celdaJugador.y + 2].tipo != 'A') {
                        if (laberinto.celdas[celdaJugador.x + 2][celdaJugador.y + 2].tipo == PORTERIAA) {
                            laberinto.contarGol(PORTERIAA, celdaJugador.x + 1, celdaJugador.y + 1);
                        } else if (laberinto.celdas[celdaJugador.x + 2][celdaJugador.y + 2].tipo == PORTERIAJ) {
                            laberinto.contarGol(PORTERIAJ, celdaJugador.x + 1, celdaJugador.y + 1);
                        } else {
                            laberinto.celdas[celdaJugador.x + 2][celdaJugador.y + 2].tipo = 'P';
                            pelota.celdaPelota.x++;
                            pelota.celdaPelota.y++;
                            laberinto.celdas[celdaJugador.x + 1][celdaJugador.y + 1].tipo = 'C';
                        }

                    } else {
                        laberinto.celdas[celdaJugador.x][celdaJugador.y].tipo = 'C';
                        laberinto.celdas[celdaJugador.x][celdaJugador.y].tipo = 'P';
                        pelota.celdaPelota.x = celdaJugador.x;
                        pelota.celdaPelota.y = celdaJugador.y;
                        this.celdaJugador.y += 1;
                        this.celdaJugador.x += 1;
                        laberinto.celdas[celdaJugador.x][celdaJugador.y].tipo = 'J';

                    }
                } else if (laberinto.celdas[celdaJugador.x + 1][celdaJugador.y + 1].tipo != 'A') {
                    laberinto.celdas[celdaJugador.x][celdaJugador.y].tipo = 'C';
                    this.celdaJugador.y += 1;
                    this.celdaJugador.x += 1;
                    laberinto.celdas[celdaJugador.x][celdaJugador.y].tipo = 'J';
                } else {
                    this.moverJugadorArribaIzquierda();
                    laberinto.lienzoPadre.adversario.moverAdversarioAbajoDerecha();
                }
            }
        }
    }

    public void moverJugadorAbajo() {
        if (celdaJugador.y < alturaMundoVirtual - 1) {
            if (laberinto.celdas[celdaJugador.x][celdaJugador.y + 1].tipo != 'O'
                    && laberinto.celdas[celdaJugador.x][celdaJugador.y + 1].tipo != PORTERIAA
                    && laberinto.celdas[celdaJugador.x][celdaJugador.y + 1].tipo != PORTERIAJ) {

                if (laberinto.celdas[celdaJugador.x][celdaJugador.y + 1].tipo == 'P') {
                    if (celdaJugador.y + 2 < alturaMundoVirtual
                            && laberinto.celdas[celdaJugador.x][celdaJugador.y + 2].tipo != 'O'
                            && laberinto.celdas[celdaJugador.x][celdaJugador.y + 2].tipo != 'A') {
                        if (laberinto.celdas[celdaJugador.x][celdaJugador.y + 2].tipo == PORTERIAA) {
                            laberinto.contarGol(PORTERIAA, celdaJugador.x, celdaJugador.y + 1);
                        } else if (laberinto.celdas[celdaJugador.x][celdaJugador.y + 2].tipo == PORTERIAJ) {
                            laberinto.contarGol(PORTERIAJ, celdaJugador.x, celdaJugador.y + 1);
                        } else {
                            laberinto.celdas[celdaJugador.x][celdaJugador.y + 2].tipo = 'P';
                            pelota.celdaPelota.y++;
                            laberinto.celdas[celdaJugador.x][celdaJugador.y + 1].tipo = 'C';
                        }

                    } else {
                        laberinto.celdas[celdaJugador.x][celdaJugador.y].tipo = 'C';
                        laberinto.celdas[celdaJugador.x][celdaJugador.y].tipo = 'P';
                        pelota.celdaPelota.y = celdaJugador.y;
                        this.celdaJugador.y += 1;
                        laberinto.celdas[celdaJugador.x][celdaJugador.y].tipo = 'J';
                    }
                } else if (laberinto.celdas[celdaJugador.x][celdaJugador.y + 1].tipo != 'A') {
                    laberinto.celdas[celdaJugador.x][celdaJugador.y].tipo = 'C';
                    this.celdaJugador.y += 1;
                    laberinto.celdas[celdaJugador.x][celdaJugador.y].tipo = 'J';
                } else {
                    this.moverJugadorArriba();
                    laberinto.lienzoPadre.adversario.moverAdversarioAbajo();
                }
            }

        }
    }

    public void moverJugadorAbajoIzquierda() {
        if (celdaJugador.y < alturaMundoVirtual - 1 && celdaJugador.x > 0) {
            if (laberinto.celdas[celdaJugador.x - 1][celdaJugador.y + 1].tipo != 'O'
                    && laberinto.celdas[celdaJugador.x - 1][celdaJugador.y + 1].tipo != PORTERIAA
                    && laberinto.celdas[celdaJugador.x - 1][celdaJugador.y + 1].tipo != PORTERIAJ) {

                if (laberinto.celdas[celdaJugador.x - 1][celdaJugador.y + 1].tipo == 'P') {
                    if (celdaJugador.y + 2 < alturaMundoVirtual && celdaJugador.x - 2 >= 0
                            && laberinto.celdas[celdaJugador.x - 2][celdaJugador.y + 2].tipo != 'O'
                            && laberinto.celdas[celdaJugador.x - 2][celdaJugador.y + 2].tipo != 'A') {
                        if (laberinto.celdas[celdaJugador.x - 2][celdaJugador.y + 2].tipo == PORTERIAA) {
                            laberinto.contarGol(PORTERIAA, celdaJugador.x - 1, celdaJugador.y + 1);
                        } else if (laberinto.celdas[celdaJugador.x - 2][celdaJugador.y + 2].tipo == PORTERIAJ) {
                            laberinto.contarGol(PORTERIAJ, celdaJugador.x - 1, celdaJugador.y + 1);
                        } else {
                            laberinto.celdas[celdaJugador.x - 2][celdaJugador.y + 2].tipo = 'P';
                            pelota.celdaPelota.x--;
                            pelota.celdaPelota.y++;
                            laberinto.celdas[celdaJugador.x - 1][celdaJugador.y + 1].tipo = 'C';
                        }
                    } else {
                        laberinto.celdas[celdaJugador.x][celdaJugador.y].tipo = 'C';
                        laberinto.celdas[celdaJugador.x][celdaJugador.y].tipo = 'P';
                        pelota.celdaPelota.x = celdaJugador.x;
                        pelota.celdaPelota.y = celdaJugador.y;
                        this.celdaJugador.y += 1;
                        this.celdaJugador.x -= 1;
                        laberinto.celdas[celdaJugador.x][celdaJugador.y].tipo = 'J';
                    }
                } else if (laberinto.celdas[celdaJugador.x - 1][celdaJugador.y + 1].tipo != 'A') {
                    laberinto.celdas[celdaJugador.x][celdaJugador.y].tipo = 'C';
                    this.celdaJugador.y += 1;
                    this.celdaJugador.x -= 1;
                    laberinto.celdas[celdaJugador.x][celdaJugador.y].tipo = 'J';
                } else {
                    this.moverJugadorArribaDerecha();
                    laberinto.lienzoPadre.adversario.moverAdversarioAbajoIzquierda();
                }
            }
        }
    }

    public void moverJugadorIzquierda() {
        if (celdaJugador.x > 0) {
            if (laberinto.celdas[celdaJugador.x - 1][celdaJugador.y].tipo != 'O'
                    && laberinto.celdas[celdaJugador.x - 1][celdaJugador.y].tipo != PORTERIAA
                    && laberinto.celdas[celdaJugador.x - 1][celdaJugador.y].tipo != PORTERIAJ) {

                if (laberinto.celdas[celdaJugador.x - 1][celdaJugador.y].tipo == 'P') {
                    if (celdaJugador.x - 2 >= 0
                            && laberinto.celdas[celdaJugador.x - 2][celdaJugador.y].tipo != 'O'
                            && laberinto.celdas[celdaJugador.x - 2][celdaJugador.y].tipo != 'A') {
                        if (laberinto.celdas[celdaJugador.x - 2][celdaJugador.y].tipo == PORTERIAA) {
                            laberinto.contarGol(PORTERIAA, celdaJugador.x - 1, celdaJugador.y);
                        } else if (laberinto.celdas[celdaJugador.x - 2][celdaJugador.y].tipo == PORTERIAJ) {
                            laberinto.contarGol(PORTERIAJ, celdaJugador.x - 1, celdaJugador.y);
                        } else {
                            laberinto.celdas[celdaJugador.x - 2][celdaJugador.y].tipo = 'P';
                            pelota.celdaPelota.x--;
                            laberinto.celdas[celdaJugador.x - 1][celdaJugador.y].tipo = 'C';
                        }

                    } else {
                        laberinto.celdas[celdaJugador.x][celdaJugador.y].tipo = 'C';
                        laberinto.celdas[celdaJugador.x][celdaJugador.y].tipo = 'P';
                        pelota.celdaPelota.x = celdaJugador.x;
                        this.celdaJugador.x -= 1;
                        laberinto.celdas[celdaJugador.x][celdaJugador.y].tipo = 'J';
                    }
                } else if (laberinto.celdas[celdaJugador.x - 1][celdaJugador.y].tipo != 'A') {
                    laberinto.celdas[celdaJugador.x][celdaJugador.y].tipo = 'C';
                    this.celdaJugador.x -= 1;
                    laberinto.celdas[celdaJugador.x][celdaJugador.y].tipo = 'J';
                } else {
                    this.moverJugadorDerecha();
                    laberinto.lienzoPadre.adversario.moverAdversarioIzquierda();
                }
            }

        }
    }
}
