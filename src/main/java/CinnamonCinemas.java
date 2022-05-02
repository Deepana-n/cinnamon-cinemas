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
        if(seatsRequested > totalAvailableSeats) return false;
        for(int row = 0; row < seatMap.length; row++){
            for(int seat = 0; seat < seatMap[0].length; seat++){
                if(!seatMap[row][seat] && seatsRequested > 0){
                    seatMap[row][seat] = true;
                    ableToAllocate = true;
                    listOfSeatsAllocated(row,seat);
                    totalAvailableSeats--;
                    seatsRequested--;
                }
            }
            if(seatsRequested == 0) break;
        }
        return ableToAllocate && totalAvailableSeats >= 0;
    }

    private void listOfSeatsAllocated(int row, int seat){
        StringBuilder sb = new StringBuilder();
        if(row == 0) sb.append("A").append(seat+1);
        else if(row == 1) sb.append("B").append(seat+1);
        else if(row == 2) sb.append("C").append(seat+1);
        allocatedSeatList.add(sb.toString());
    }

    public List<String> getListOfSeatsAllocated(){
        return allocatedSeatList;
    }
}
