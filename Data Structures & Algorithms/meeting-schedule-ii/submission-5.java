/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {

        if(intervals.isEmpty() || intervals == null){
            return 0;
        }

        int n = intervals.size();
        int[] starts = new int[n];
        int[] ends = new int[n];

        for(int i = 0 ; i < n ; i++){
            starts[i] = intervals.get(i).start;
            ends[i]   = intervals.get(i).end;
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int s = 0, e = 0, rooms = 0, maxRooms = 0;

        while(s<n){
            if(starts[s]>=ends[e]){
                rooms--;
                e++;
            }

            rooms++;
            maxRooms = Math.max(maxRooms, rooms);
            s++;
        }

        return maxRooms;
    }
}
