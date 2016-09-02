package ia.grafico;

/**
 *
 * @author Nicolas Gonzalez Tardon
 */
public class Pelota implements Constantes {

    public Laberinto laberinto;
    public Celda celdaPelota;
    public Jugador jugador;
    public Adversario adversario;

    public Pelota(Laberinto laberinto, Jugador jugador, Adversario adversario) {
        this.jugador = jugador;
        this.adversario = adversario;
        this.laberinto = laberinto;
        int x = anchuraMundoVirtual / 2, y = alturaMundoVirtual / 2;
        this.celdaPelota = new Celda(x, y, 'P');
        this.laberinto.celdas[x][y].tipo = 'P';
    }

    public Pelota(Laberinto laberinto, Jugador jugador, Adversario adversario, int x, int y) {
        this.jugador = jugador;
        this.adversario = adversario;
        this.laberinto = laberinto;
        this.celdaPelota = new Celda(x, y, 'P');
        this.laberinto.celdas[x][y].tipo = 'P';
    }

    public void moverPelotaArribaIzquierda(char p) {
        switch (p) {
            case 'J':
                if (jugador.celdaJugador.y > 0 && jugador.celdaJugador.x > 0) {
                    if (laberinto.celdas[jugador.celdaJugador.x - 1][jugador.celdaJugador.y - 1].tipo != 'O') {
                        laberinto.celdas[celdaPelota.x][celdaPelota.y].tipo = 'C';
                        this.celdaPelota.x = jugador.celdaJugador.x - 1;
                        this.celdaPelota.y = jugador.celdaJugador.y - 1;
                        laberinto.celdas[celdaPelota.x][celdaPelota.y].tipo = 'P';
                    }
                }
                break;
            case 'A':
                if (adversario.celdaAdversario.y > 0 && adversario.celdaAdversario.x > 0) {
                    if (laberinto.celdas[adversario.celdaAdversario.x - 1][adversario.celdaAdversario.y - 1].tipo != 'O') {
                        laberinto.celdas[celdaPelota.x][celdaPelota.y].tipo = 'C';
                        this.celdaPelota.x = adversario.celdaAdversario.x - 1;
                        this.celdaPelota.y = adversario.celdaAdversario.y - 1;
                        laberinto.celdas[celdaPelota.x][celdaPelota.y].tipo = 'P';
                    }
                }
                break;
        }
    }

    public void moverPelotaArriba(char p) {
        switch (p) {
            case 'J':
                if (jugador.celdaJugador.y > 0) {
                    if (laberinto.celdas[jugador.celdaJugador.x][jugador.celdaJugador.y - 1].tipo != 'O') {
                        laberinto.celdas[celdaPelota.x][celdaPelota.y].tipo = 'C';
                        this.celdaPelota.y = jugador.celdaJugador.y - 1;
                        laberinto.celdas[celdaPelota.x][celdaPelota.y].tipo = 'P';
                    }
                }
                break;
            case 'A':
                if (adversario.celdaAdversario.y > 0) {
                    if (laberinto.celdas[adversario.celdaAdversario.x][adversario.celdaAdversario.y - 1].tipo != 'O') {
                        laberinto.celdas[celdaPelota.x][celdaPelota.y].tipo = 'C';
                        this.celdaPelota.y = adversario.celdaAdversario.y - 1;
                        this.celdaPelota.x = adversario.celdaAdversario.x;
                        laberinto.celdas[celdaPelota.x][celdaPelota.y].tipo = 'P';
                    }
                }
                break;
        }
    }

    public void moverPelotaArribaDerecha(char p) {
        switch (p) {
            case 'J':
                if (jugador.celdaJugador.y > 0 && jugador.celdaJugador.x < anchuraMundoVirtual - 1) {
                    if (laberinto.celdas[jugador.celdaJugador.x + 1][jugador.celdaJugador.y - 1].tipo != 'O') {
                        laberinto.celdas[celdaPelota.x][celdaPelota.y].tipo = 'C';
                        this.celdaPelota.x = jugador.celdaJugador.x + 1;
                        this.celdaPelota.y = jugador.celdaJugador.y - 1;
                        laberinto.celdas[celdaPelota.x][celdaPelota.y].tipo = 'P';
                    }
                }
                break;
            case 'A':
                if (adversario.celdaAdversario.y > 0) {
                    if (laberinto.celdas[adversario.celdaAdversario.x + 1][adversario.celdaAdversario.y - 1].tipo != 'O') {
                        laberinto.celdas[celdaPelota.x][celdaPelota.y].tipo = 'C';
                        this.celdaPelota.x = adversario.celdaAdversario.x + 1;
                        this.celdaPelota.y = adversario.celdaAdversario.y - 1;
                        laberinto.celdas[celdaPelota.x][celdaPelota.y].tipo = 'P';
                    }
                }
                break;
        }
    }

    public void moverPelotaDerecha(char p) {
        switch (p) {
            case 'J':
                if (jugador.celdaJugador.x < anchuraMundoVirtual - 1) {
                    if (laberinto.celdas[jugador.celdaJugador.x + 1][jugador.celdaJugador.y].tipo != 'O') {
                        laberinto.celdas[celdaPelota.x][celdaPelota.y].tipo = 'C';
                        this.celdaPelota.x = jugador.celdaJugador.x + 1;
                        laberinto.celdas[celdaPelota.x][celdaPelota.y].tipo = 'P';
                    }
                }
                break;
            case 'A':
                if (adversario.celdaAdversario.x < anchuraMundoVirtual - 1) {
                    if (laberinto.celdas[adversario.celdaAdversario.x + 1][adversario.celdaAdversario.y].tipo != 'O') {
                        laberinto.celdas[celdaPelota.x][celdaPelota.y].tipo = 'C';
                        this.celdaPelota.x = adversario.celdaAdversario.x + 1;
                        this.celdaPelota.y = adversario.celdaAdversario.y;
                        laberinto.celdas[celdaPelota.x][celdaPelota.y].tipo = 'P';
                    }
                }
                break;
        }
    }

    public void moverPelotaAbajoDerecha(char p) {
        switch (p) {
            case 'J':
                if (jugador.celdaJugador.y < alturaMundoVirtual - 1 && jugador.celdaJugador.x < anchuraMundoVirtual - 1) {
                    if (laberinto.celdas[jugador.celdaJugador.x + 1][jugador.celdaJugador.y + 1].tipo != 'O') {
                        laberinto.celdas[celdaPelota.x][celdaPelota.y].tipo = 'C';
                        this.celdaPelota.y = jugador.celdaJugador.x + 1;
                        this.celdaPelota.y = jugador.celdaJugador.y + 1;
                        laberinto.celdas[celdaPelota.x][celdaPelota.y].tipo = 'P';
                    }
                }
                break;
            case 'A':
                if (adversario.celdaAdversario.y < alturaMundoVirtual - 1 && adversario.celdaAdversario.x < anchuraMundoVirtual - 1) {
                    if (laberinto.celdas[adversario.celdaAdversario.x + 1][adversario.celdaAdversario.y + 1].tipo != 'O') {
                        laberinto.celdas[celdaPelota.x][celdaPelota.y].tipo = 'C';
                        this.celdaPelota.y = adversario.celdaAdversario.x + 1;
                        this.celdaPelota.y = adversario.celdaAdversario.y + 1;
                        laberinto.celdas[celdaPelota.x][celdaPelota.y].tipo = 'P';
                    }
                }
                break;
        }
    }

    public void moverPelotaAbajo(char p) {
        switch (p) {
            case 'J':
                if (jugador.celdaJugador.y < alturaMundoVirtual - 1) {
                    if (laberinto.celdas[jugador.celdaJugador.x][jugador.celdaJugador.y + 1].tipo != 'O') {
                        laberinto.celdas[celdaPelota.x][celdaPelota.y].tipo = 'C';
                        this.celdaPelota.y = jugador.celdaJugador.y + 1;
                        laberinto.celdas[celdaPelota.x][celdaPelota.y].tipo = 'P';
                    }
                }
                break;
            case 'A':
                if (adversario.celdaAdversario.y < alturaMundoVirtual - 1) {
                    if (laberinto.celdas[adversario.celdaAdversario.x][adversario.celdaAdversario.y + 1].tipo != 'O') {
                        laberinto.celdas[celdaPelota.x][celdaPelota.y].tipo = 'C';
                        this.celdaPelota.y = adversario.celdaAdversario.y + 1;
                        this.celdaPelota.x = adversario.celdaAdversario.x;
                        laberinto.celdas[celdaPelota.x][celdaPelota.y].tipo = 'P';
                    }
                }
                break;
        }
    }

    public void moverPelotaAbajoIzquierda(char p) {
        switch (p) {
            case 'J':
                if (jugador.celdaJugador.y < alturaMundoVirtual - 1 && jugador.celdaJugador.x > 0) {
                    if (laberinto.celdas[jugador.celdaJugador.x - 1][jugador.celdaJugador.y + 1].tipo != 'O') {
                        laberinto.celdas[celdaPelota.x][celdaPelota.y].tipo = 'C';
                        this.celdaPelota.y = jugador.celdaJugador.x - 1;
                        this.celdaPelota.y = jugador.celdaJugador.y + 1;
                        laberinto.celdas[celdaPelota.x][celdaPelota.y].tipo = 'P';
                    }
                }
                break;
            case 'A':
                if (adversario.celdaAdversario.y < alturaMundoVirtual - 1 && adversario.celdaAdversario.x >0) {
                    if (laberinto.celdas[adversario.celdaAdversario.x][adversario.celdaAdversario.y + 1].tipo != 'O') {
                        laberinto.celdas[celdaPelota.x][celdaPelota.y].tipo = 'C';
                        this.celdaPelota.y = adversario.celdaAdversario.x - 1;
                        this.celdaPelota.y = adversario.celdaAdversario.y + 1;
                        laberinto.celdas[celdaPelota.x][celdaPelota.y].tipo = 'P';
                    }
                }
                break;
        }
    }

    public void moverPelotaIzquierda(char p) {
        switch (p) {
            case 'J':
                if (jugador.celdaJugador.x > 0) {
                    if (laberinto.celdas[jugador.celdaJugador.x - 1][jugador.celdaJugador.y + 1].tipo != 'O') {
                        laberinto.celdas[celdaPelota.x][celdaPelota.y].tipo = 'C';
                        this.celdaPelota.y = jugador.celdaJugador.x - 1;
                        laberinto.celdas[celdaPelota.x][celdaPelota.y].tipo = 'P';
                    }
                }
                break;
            case 'A':
                if (adversario.celdaAdversario.x >0) {
                    if (laberinto.celdas[adversario.celdaAdversario.x][adversario.celdaAdversario.y + 1].tipo != 'O') {
                        laberinto.celdas[celdaPelota.x][celdaPelota.y].tipo = 'C';
                        this.celdaPelota.x = adversario.celdaAdversario.x - 1;
                        this.celdaPelota.y = adversario.celdaAdversario.y;
                        laberinto.celdas[celdaPelota.x][celdaPelota.y].tipo = 'P';
                    }
                }
                break;
        }
    }
}
