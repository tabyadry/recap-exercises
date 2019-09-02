package problem1;

import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void showRatioBetweenSimpleAndComplexProperties() {
        Main main = new Main();
        assertEquals(66.66, main.getRatioBetweenSimpleAndComplexProperties(Furniture.class),0.1);
    }

    @Test
    public void showRatioBetweenSimpleAndComplexProperties2() {
        Main main = new Main();
        assertEquals(75.0, main.getRatioBetweenSimpleAndComplexProperties(Chair.class),0.1);
    }

    @Test
    public void showRatioBetweenSimpleAndComplexProperties3() {
        Main main = new Main();
        assertEquals(75.0, main.getRatioBetweenSimpleAndComplexProperties(Table.class),0.1);
    }


}