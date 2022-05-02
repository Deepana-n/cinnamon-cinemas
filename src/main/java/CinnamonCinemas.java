import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    public static void main(String[] args) {
        CinnamonCinemas cinemaObj = new CinnamonCinemas(15);
        Random rand = new Random();
        boolean successfulAllocation;
        System.out.println("****Welcome to Cinnamon Cinemas random seat allocation application****");
        System.out.println("Number of seats that will be generated will be from 1-3");
        System.out.println();
        do{
            int numberOfSeats = rand.nextInt(3) + 1;
            System.out.println("The number of seats to be allocated " + numberOfSeats);
            successfulAllocation = cinemaObj.allocateSeats(numberOfSeats);
            if(successfulAllocation) System.out.println(cinemaObj.getListOfSeatsAllocated());
            else System.out.println("Sorry seats cannot be allocated. Not enough available seats left 😭");
            System.out.println();
        }while (successfulAllocation);
    }
}
