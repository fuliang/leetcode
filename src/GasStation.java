/**
 * Created by fuliang on 2015/4/12.
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = gas.length;
        int current = 0;
        int left = 0;

        do {
            if ( left + (gas[current] - cost[current]) >= 0) {
                left += (gas[current] - cost[current]);
                ++current;
            } else {
                --start;
                left += (gas[start] - cost[start]);
            }
        } while (start != current);

        return left >= 0 ? start % gas.length : -1;
    }

    public static void main(String[] args) {
        GasStation sol = new GasStation();
        int index = sol.canCompleteCircuit(new int[]{2,4,3}, new int[]{3,2,1});
        System.out.println(index);
    }
}
