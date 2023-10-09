public class Robot implements Runnable{
    private final RobotWorld rWorld;
    private int x, y ;
    private int vx, vy;
    private static int lastId = 0;
    private int id;
    boolean collision;

    public Robot(RobotWorld rWorld, int x, int y, int vx, int vy){
        lastId++;
        this.id = lastId;
        this.rWorld = rWorld;
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
    }

    public void start(){
        Thread t = new Thread(this);
        t.start();
    }

    private void wallColision(){
        collision = false;
        if (x+vx<0){
            x=0;
            vx = -vx;
            collision  = true;
        }
        if (y+vy<0){
            y=0;
            vy = -vy;
            collision  =true;
        }
        if (x+vx>rWorld.xmax){
            x= rWorld.xmax;
            vx = -vx;
            collision  =true;
        }
        if (y+vy>rWorld.ymax){
            y=rWorld.ymax;
            vy = -vy;
            collision  =true;
        }

    }

    @Override
    public void run() {
        while(true){
            wallColision();
            move();
            robotsCollision();
            paint();
        }
    }

    private void paint() {
        if (collision){
            System.out.println("Robot "+id+" p=["+x+","+y+"]");
            System.out.println("Robot "+id+" v=["+vx+","+vy+"]");
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void move() {
        if (collision) return;
        if (rWorld.map[x+vx][y+vy]==0){
            rWorld.map[x][y]-=1;
            rWorld.map[x+vx][y+vy]+=1;
            x+=vx;
            y+=vy;
        }

    }

    private void robotsCollision(){

    }
}
