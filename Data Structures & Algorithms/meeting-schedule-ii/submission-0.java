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
        int maxRooms = 0;

        for(int i=0; i < intervals.size();  i++){
            int active = 0;
            int start = intervals.get(i).start;
            for(int j = 0; j < intervals.size(); j++){
                if(intervals.get(j).start <= start 
                        && start < intervals.get(j).end){
                          active++;
                        }
            }

            maxRooms = Math.max(maxRooms, active);
        }

        return maxRooms;
    }
}
