import org.junit.jupiter.api.BeforeEach;
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

    @ParameterizedTest(name = "{index}) For multiple seat requests: \"{0}\"")
    @CsvSource(textBlock = """
            1 2 1,
            2 2 2 3 3 3,
            1 2 3 1 2 3 1 1 1
            """)
    public void checkValidMultipleSeatAllocation(String stringOfSeatsRequested) {
        cinemaObj = new CinnamonCinemas(15);
        String[] seatsRequested = stringOfSeatsRequested.split(" ");
        for (String s : seatsRequested) {
            assertTrue(cinemaObj.allocateSeats(Integer.parseInt(s)));
        }
    }

    @ParameterizedTest(name = "{index}) For multiple seats of: \"{0}\"")
    @CsvSource(textBlock = """
            3 3 3 3 3 3,
            2 2 2 3 3 3 2,
            1 2 3 1 2 3 1 1 1 2
            """)
    public void checkInvalidMultipleSeatAllocation(String stringOfSeatsRequested) {
        cinemaObj = new CinnamonCinemas(15);
        int countAllocatedSeats = 15;
        String[] seatsRequested = stringOfSeatsRequested.split(" ");
        for (String s : seatsRequested) {
            countAllocatedSeats -= Integer.parseInt(s);
            if(countAllocatedSeats <= 15 && countAllocatedSeats >=0){
                assertTrue(cinemaObj.allocateSeats(Integer.parseInt(s)));
            }else{
                assertFalse(cinemaObj.allocateSeats(Integer.parseInt(s)));
            }
        }
    }

    @ParameterizedTest(name = "{index}) For seats: \"{0}\" the outcome is \"{1}\"")
    @CsvSource(textBlock = """
            1, A1
            2,  A1 A2,
            3,  A1 A2 A3,
            """)
    public void checkSuccessfulListOfSinglyAllocatedSeats(int seatsRequested, String expectedResult) {
        cinemaObj = new CinnamonCinemas(15);
        List<String> expectedResultList = Arrays.asList(expectedResult.split(" "));
        cinemaObj.allocateSeats(seatsRequested);
        assertEquals(expectedResultList,cinemaObj.getListOfSeatsAllocated());
    }
}
