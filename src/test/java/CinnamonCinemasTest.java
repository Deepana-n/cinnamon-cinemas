import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CinnamonCinemasTest {
    private CinnamonCinemas cinemaObj;

    @BeforeEach
    public void setUp(){
        cinemaObj = new CinnamonCinemas(15);
    }

    @ParameterizedTest(name = "{index}) For seats: \"{0}\"")
    @ValueSource(ints = {1, 2, 3, 14, 15})
    public void checkValidSeatAllocation(int seatsRequested) {
        cinemaObj = new CinnamonCinemas(15);
        assertTrue(cinemaObj.allocateSeats(seatsRequested));
    }

    @ParameterizedTest(name = "{index}) For seats: \"{0}\"")
    @ValueSource(ints = {0, 16, 18})
    public void checkInvalidSeatAllocation(int seatsRequested) {
        cinemaObj = new CinnamonCinemas(15);
        assertFalse(cinemaObj.allocateSeats(seatsRequested));
    }


}
