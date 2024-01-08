package calk;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    private Calculator target;

    @Before
    public void prepareTests(){
        target= new Calculator();
    }

    @Test
    public void simpleMultiply(){
        double a = 1.2;
        double b = 2.3;
        double expected = 2.76;
        double obtained = target.multiply(a,b,
                2);
        assertEquals(expected,obtained,.01);
    }

    @Test
    public void parityTest(){
        Random rand = new Random(22);
        for (int i=0; i<10; i++){
            double a = rand.nextDouble()*100;
            double b = rand.nextDouble()*100;
            double expected = a*b;
            double obtained = target.multiply(a,b,
                    3);
            assertEquals(expected,obtained,.001);
        }
    }

    @Test
    public void simpleDivison(){
        assertEquals(11.3/2.2,
                target.division(11.3, 2.2),
                0.001);
    }

    @Test(expected = ArithmeticException.class)
    public void divideByZero(){
        double result =
                target.division(12,0.00000002);
        //System.out.println(result);
    }

    @Test(timeout = 1)
    public void expTest(){
        double exp = Math.exp(12.3);
        double result = target.exp(12.3, 0.0001);
        System.out.println(exp+" : "+result);
        assertEquals(0,
                Math.abs((exp-result)/exp),
                0.0001 );
    }
}
