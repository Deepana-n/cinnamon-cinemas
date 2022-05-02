import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CinnamonCinemasTest {
    private CinnamonCinemas cinemaObj;

    @BeforeEach
    public void setUp(){
        cinemaObj = new CinnamonCinemas(15);
    }

    @Test
    public void checkSuccessfulAllocation(){
        int seatsRequested = 1;
        assertTrue(cinemaObj.allocateSeats(seatsRequested));
    }

    @Test
    public void checkUnSuccessfulAllocation(){
        int seatsRequested = 16;
        assertTrue(cinemaObj.allocateSeats(seatsRequested));
    }

}
