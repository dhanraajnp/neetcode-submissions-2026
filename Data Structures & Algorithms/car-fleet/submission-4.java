class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] cars = new int[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a, b) -> b[0] - a[0]); // position desc

        int fleets = 0;
        double maxTime = 0.0; // time of the last formed fleet (front-most so far)

        for (int[] car : cars) {
            double time = (double)(target - car[0]) / car[1];
            // if this car takes longer than the fleet ahead, it cannot catch -> new fleet
            if (time > maxTime) {
                fleets++;
                maxTime = time;
            }
            // else: it catches up -> joins existing fleet, do nothing
        }

        return fleets;
    }
}
