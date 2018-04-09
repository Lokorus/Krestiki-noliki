import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayTest {
    private Play p;
    private MyPanel t;
    private int PlayBoard[][];

    @Before
    public void setUp() {
        t = new MyPanel();
        p = new Play(t);
    }

    @Test
    public void testResultCheck1() {
        p.InArray(0, 0, 1, 0);
        p.InArray(0, 1, 2, 1);
        p.InArray(1, 1, 1, 2);
        p.InArray(0, 2, 2, 3);
        p.InArray(2, 2, 1, 4);
        assertEquals(1, p.k);
    }
    @Test
    public void testResultCheck2() {
        p.InArray(0, 0, 1, 0);
        p.InArray(1, 0, 2, 1);
        p.InArray(0, 1, 1, 2);
        p.InArray(1, 1, 2, 3);
        p.InArray(0, 2, 1, 4);
        assertEquals(1, p.k);
    }
    @Test
    public void testResultCheck3() {
        p.InArray(0, 0, 1, 0);
        p.InArray(0, 1, 2, 1);
        p.InArray(1, 0, 1, 2);
        p.InArray(1, 1, 2, 3);
        p.InArray(2, 0, 1, 4);
        assertEquals(1, p.k);
    }
    @Test
    public void testResultCheck4() {
        p.InArray(0, 0, 1, 0);
        p.InArray(0, 2, 2, 1);
        p.InArray(0, 1, 1, 2);
        p.InArray(1, 0, 2, 3);
        p.InArray(1, 1, 1, 4);
        p.InArray(2, 1, 2, 5);
        p.InArray(1, 2, 1, 6);
        p.InArray(2, 2, 2, 7);
        p.InArray(2, 0, 1, 8);
        assertEquals(3, p.k);
    }
}