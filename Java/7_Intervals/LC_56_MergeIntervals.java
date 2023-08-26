class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals,(a,b)->{
            return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
        });

        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for(int i = 1; i < intervals.length; i++){
            int[] pre = list.get(list.size() - 1);
            int[] cur = intervals[i];
            if(pre[1] < cur[0]){
                list.add(cur);
            }
            else{
                pre[1] = Math.max(pre[1],cur[1]);
            }
        }
     
        return list.toArray(new int[list.size()][]);
    }
}