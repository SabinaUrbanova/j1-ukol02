package cz.czechitas.turtle;

import dev.czechitas.java1.turtle.engine.Turtle;

import java.awt.*;

public class HlavniProgram {
    private Turtle zofka = new Turtle();

    public static void main(String[] args) {
        new HlavniProgram().start();
    }

    public void start() {
        posunNaZacatek();
        nakresliZmrzlinu(Color.red);
        posun(400, 'R');
        posun(100, 'S');
        nakresliSnehulaka(Color.blue);
        zofka.turnRight(180);
        posun(400, 'R');
        posun(100, 'S');
        nakresliMasinku(Color.black);
    }

    public void nakresliTrojuhelnik(double delkaStrany) {
        for (int i = 0; i < 3; i++) {
            zofka.move(delkaStrany);
            zofka.turnRight(120);
        }
    }

    public void nakresliCtverec(double delkaStrany) {
        for (int i = 0; i < 4; i++) {
            zofka.move(delkaStrany);
            zofka.turnRight(90);
        }
    }

    public void nakresliObdelnik(double delkaPrvniStrany, double delkaDruheStrany) {
        for (int i = 0; i < 2; i++) {
            zofka.move(delkaPrvniStrany);
            zofka.turnRight(90);
            zofka.move(delkaDruheStrany);
            zofka.turnRight(90);
        }
    }

    public void nakresliKruh(double polomer) {
        for (int i = 0; i < 20; i++) {
            zofka.move(((double)(2*polomer*Math.PI))/20);
            zofka.turnRight(360 / 20);
        }
    }

    public void nakresliZmrzlinu(Color barva) {
        zofka.setPenColor(barva);
        zofka.turnRight(90);
        nakresliTrojuhelnik(150);
        zofka.turnLeft(90);
        nakresliKruh(75);
    }

    public void nakresliSnehulaka(Color barva) {
        double polomer = 50.0;
        zofka.setPenColor(barva);
        for (int i = 0; i < 3; i++) {
            zofka.turnLeft(90);
            nakresliKruh((double)polomer);
            zofka.penUp();
            if (i!=2) {
                zofka.turnRight(90);
                zofka.move(2 * polomer);
                zofka.penDown();
                polomer = polomer * 0.7;
            }
        }
        for (int i = 0; i < 5; i++) {
            zofka.move(((double)(2*polomer*1.3*Math.PI))/20);
            zofka.turnLeft(360 / 20);
        }
        zofka.penDown();
        nakresliKruh(15);
        zofka.penUp();
        zofka.turnLeft(90);
        zofka.move(90);
        zofka.turnRight(90);
        zofka.penDown();
        nakresliKruh(15);
    }

    public void nakresliMasinku(Color barva) {
        zofka.setPenColor(barva);
        nakresliObdelnik(150,100);
        nakresliKruh(50);
        zofka.turnLeft(90);
        nakresliObdelnik(150,100);
        zofka.move(80);
        zofka.turnRight(180);
        nakresliKruh(20);
        zofka.turnRight(180);
        zofka.move(50);
        zofka.turnRight(180);
        nakresliKruh(20);
        zofka.turnRight(180);
        zofka.move(20);
        zofka.turnRight(30);
        nakresliTrojuhelnik(80);
    }

    public void posunNaZacatek() {
        zofka.penUp();
        zofka.turnLeft(90);
        zofka.move(500);
        zofka.turnRight(90);
        zofka.penDown();
    }

    public void posun(int delkaPosunu, char smer) {
        zofka.penUp();
        if (smer == 'L') {
            zofka.turnLeft(90);
            zofka.move(delkaPosunu);
            zofka.turnRight(90);
        } else if (smer == 'R') {
            zofka.turnRight(90);
            zofka.move(delkaPosunu);
            zofka.turnLeft(90);
        } else if (smer == 'N') {
            zofka.move(delkaPosunu);
        } else if (smer == 'S') {
            zofka.turnRight(180);
            zofka.move(delkaPosunu);
            zofka.turnLeft(180);
        }
        zofka.penDown();
    }
}
