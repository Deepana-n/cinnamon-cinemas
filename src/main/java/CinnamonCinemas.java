import java.util.ArrayList;
import java.util.List;

public class CinnamonCinemas {
    private final List<String> allocatedSeatList;
    private final boolean[][] seatMap;
    private int totalAvailableSeats;


    public CinnamonCinemas(int totalAvailableSeats) {
        this.totalAvailableSeats = totalAvailableSeats;
        allocatedSeatList = new ArrayList<>();
        seatMap =  new boolean[][]{{false, false, false, false, false},{false, false, false, false, false},
                {false, false, false, false, false}};
    }

    public boolean allocateSeats(int seatsRequested) {
        boolean ableToAllocate = false;
        for(int row = 0; row < seatMap.length; row++){
            for(int seat = 0; seat < seatMap[0].length; seat++){
                if(!seatMap[row][seat] && seatsRequested > 0){
                    seatMap[row][seat] = true;
                    ableToAllocate = true;
                    totalAvailableSeats--;
                    seatsRequested--;
                }
            }
            if(seatsRequested == 0) break;
        }
        return ableToAllocate && totalAvailableSeats >= 0;
    }
}
