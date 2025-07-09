class PetrolPump {
    int petrol;
    int distance;

    PetrolPump(int petrol, int distance) {
        this.petrol = petrol;
        this.distance = distance;
    }
}

public class CircularTour {

    // Returns the starting pump index if possible, else -1
    public static int findStartPoint(PetrolPump[] pumps) {
        int n = pumps.length;
        int total_tank = 0, curr_tank = 0;
        int start = 0;

        for (int i = 0; i < n; i++) {
            int gain = pumps[i].petrol - pumps[i].distance;
            total_tank += gain;
            curr_tank += gain;

            // If current tank is negative, cannot start from 'start'
            if (curr_tank < 0) {
                start = i + 1;    // Try next pump as starting point
                curr_tank = 0;    // Reset current tank
            }
        }

        return (total_tank >= 0) ? start : -1;
    }

    public static void main(String[] args) {
        PetrolPump[] pumps = {
            new PetrolPump(4, 6),
            new PetrolPump(6, 5),
            new PetrolPump(7, 3),
            new PetrolPump(4, 5)
        };

        int startIndex = findStartPoint(pumps);

        if (startIndex != -1)
            System.out.println("Start at petrol pump index: " + startIndex);
        else
            System.out.println("No possible circular tour.");
    }
}
