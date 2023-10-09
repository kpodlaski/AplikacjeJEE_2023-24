package roombabot;

import java.io.IOException;

public class KeyboardControll implements Runnable{
    private Robot r;
    public KeyboardControll(Robot r) {
        this.r =r;
        Thread t = new Thread(this);
        t.start();

    }

    @Override
    public void run() {
        try {
            while (true) {
                int c = System.in.read();
                switch (c) {
                    case 97:
                        r.addVx(-1);
                        break;
                    case 100:
                        r.addVx(1);
                        break;
                    case 115:
                        r.addVy(-1);
                        break;
                    case 119:
                        r.addVy(1);
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
