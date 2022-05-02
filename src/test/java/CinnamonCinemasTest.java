import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void checkSuccessfulListOfAllocatedSeats(){
        cinemaObj = new CinnamonCinemas(15);
        int seatsRequested = 5;
        List<String> expectedAllocatedSeatsList = List.of("A1","A2","A3","A4","A5");
        cinemaObj.allocateSeats(seatsRequested);
        assertEquals(expectedAllocatedSeatsList,cinemaObj.getListOfSeatsAllocated());
    }


}
