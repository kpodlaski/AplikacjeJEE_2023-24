package roombabot;

import java.util.concurrent.RunnableFuture;

public class Robot {
    private int x, y ;

    public int getVx() {
        return vx;
    }

    public void setVx(int vx) {
        synchronized (this) {
            this.vx = vx;
        }
    }

    public void addVx(int dx) {
        synchronized (this) {
            this.vx += dx;
        }
    }

    public int getVy() {
        return vy;
    }

    public void setVy(int vy) {
        synchronized (this) {
            this.vy = vy;
        }
    }

    public void addVy(int dy) {
        synchronized (this) {
            this.vy += dy;
        }
    }

    private int vx, vy;
    private boolean wasColision = false;
    private int size = 100;

    public Robot(int x, int y, int vx, int vy){
        this.x=x;
        this.y=y;
        this.vx = vx;
        this.vy = vy;
    }

    public void start(){
        Runnable run = new Runnable() {
            @Override
            public void run() {
                liveCycle();
            }
        };
        Thread t = new Thread(run);
        t.start();
    }

    public void liveCycle(){
        while(true){
            move();
            collision();
            paint();
        }
    }

    private void paint() {
        if (wasColision){
            System.out.println("Collision happened");
            System.out.println("Position : ["+x+", "+y+"]");
            System.out.println("Velocity : ["+vx+", "+vy+"]");
            wasColision = false;
        }

    }

    private void collision() {
        synchronized (this) {
            if (x < 0) {
                x = 0;
                vx = -vx;
                wasColision = true;
            }
            if (y < 0) {
                y = 0;
                vy = -vy;
                wasColision = true;
            }
            if (x > size) {
                x = size;
                vx = -vx;
                wasColision = true;
            }
            if (y > size) {
                y = size;
                vy = -vy;
                wasColision = true;
            }
        }
        if (wasColision){
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void move() {
        x = x+vx;
        y = y+vy;
    }

}
