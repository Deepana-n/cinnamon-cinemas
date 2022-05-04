import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CinnamonCinemasTest {
    private CinnamonCinemas cinemaObj;

    @BeforeEach
    public void setUp(){
        cinemaObj = new CinnamonCinemas(15);
    }

    @ParameterizedTest(name = "{index}) For seats: \"{0}\"")
    @ValueSource(ints = {1, 2, 3})
    public void checkValidSeatSingleAllocation(int seatsRequested) {
        cinemaObj = new CinnamonCinemas(15);
        assertTrue(cinemaObj.allocateSeats(seatsRequested));
    }

    @ParameterizedTest(name = "{index}) For seats: \"{0}\"")
    @ValueSource(ints = {0, 12, 15})
    public void checkInvalidSeatSingleAllocation(int seatsRequested) {
        cinemaObj = new CinnamonCinemas(15);
        assertFalse(cinemaObj.allocateSeats(seatsRequested));
    }

    @Disabled
    @ParameterizedTest(name = "{index}) For seats: \"{0}\" the outcome is \"{1}\"")
    @CsvSource(textBlock = """
            2,  A1 A2,
            4,  A1 A2 A3 A4,
            7,  A1 A2 A3 A4 A5 B1 B2,
            15, A1 A2 A3 A4 A5 B1 B2 B3 B4 B5 C1 C2 C3 C4 C5
            """)
    public void checkSuccessfulListOfAllocatedSeats(int seatsRequested, String expectedResult) {
        cinemaObj = new CinnamonCinemas(15);
        List<String> expectedResultList = Arrays.asList(expectedResult.split(" "));
        cinemaObj.allocateSeats(seatsRequested);
        assertEquals(expectedResultList,cinemaObj.getListOfSeatsAllocated());
    }
}
