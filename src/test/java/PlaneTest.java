import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlaneTest {

    Plane plane;

    @Before
    public void before(){
        plane = new Plane(PlaneType.AIRBUSA330);
    }

    @Test
    public void hasPlaneType(){
        assertEquals(PlaneType.AIRBUSA330, plane.getType());
    }
}
