import java.util.*;

class Solution_582 {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < ppid.size(); i++){
            if(ppid.get(i) > 0){
                List<Integer> list = map.getOrDefault(ppid.get(i),new ArrayList<>());
                list.add(pid.get(i));
                map.put(ppid.get(i),list);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(kill);
        List<Integer> res = new ArrayList<>();
        while(!queue.isEmpty()){
            int r = queue.poll();
            res.add(r);
            if(map.containsKey(r)){
                for(int id : map.get(r)){
                    queue.add(id);
                }
            }
        }

        return res;
    }
}
