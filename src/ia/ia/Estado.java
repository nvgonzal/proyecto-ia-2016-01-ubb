/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ia.ia;

/**
 *
 * @author Nicolas Gonzalez Tardon
 */
public class Estado {
    //posicion x e y de la entidad
    public int x;
    public int y;
    public char oper;
    public Estado predecesor;

    public Estado(int x, int y, char oper, Estado predecesor) {
        this.x = x;
        this.y = y;
        this.oper = oper;
        this.predecesor = predecesor;
    }

    @Override
    public boolean equals(Object x) {
        Estado e = (Estado) x;
        return this.x == e.x && this.y == e.y;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.x;
        hash = 89 * hash + this.y;
        return hash;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
