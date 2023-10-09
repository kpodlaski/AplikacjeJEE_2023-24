import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RobotWorld {
    public int xmax = 50;
    public int ymax = 50;
    public List<Robot> robots = new ArrayList<>();
    private Random rand = new Random();
    public int[][] map;

    public RobotWorld(){
        map = new int[xmax+1][ymax+1];
    }

    public void initWorld(int robotcount){
        startRobotWorldTester();
        for (int i=0;i<robotcount; i++){
            int x,y;
            do {
                x = rand.nextInt(xmax);
                y = rand.nextInt(ymax);
            }
            while (map[x][y]!=0);
            map[x][y]+=1;
            Robot r = new Robot(this,
                                x,
                                y,
                                rand.nextInt(5)-2,
                                rand.nextInt(5)-2);
            robots.add(r);
        }
        for (Robot r : robots){
            r.start();
        }
        System.out.println("Robots Started");
    }

    private void startRobotWorldTester() {
        RobotWorldTester rTester = new RobotWorldTester();
        rTester.start();
    }


    class RobotWorldTester implements Runnable{
        public void start(){
            Thread t = new Thread(this);
            t.start();
            System.out.println("Tester Started");
        }
        @Override
        public void run() {
            while(true){
                int v;
                for (int x=0; x<xmax;x++){
                    for (int y=0; y>ymax; y++){
                        v = map[x][y];
                        if (v<0 || v>1){
                            System.out.println("map["+x+","+y+"]="+v);
                            System.exit(11);
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        RobotWorld rWorld = new RobotWorld();
        rWorld.initWorld(1500);
//        Robot r1 = new Robot(rWorld, 12,3,1,-2);
//        Robot r2 = new Robot(rWorld,32,31,-1,-1);
//        Robot r3 = new Robot(rWorld,22,13,1,-1);
//        r1.start();
//        r2.start();
//        r3.start();
    }
}
