package roombabot;

public class Program {
    public static void main(String[] args) {
        Robot r = new Robot(10,15,-1,0);
        r.start();
        KeyboardControll km = new KeyboardControll(r);
    }
}
