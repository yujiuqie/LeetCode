class Solution {

    HashMap<Integer,List<Integer>> G;   //有向图
    int[] inCount;  //入度表

    public int minimumSemesters(int n, int[][] relations) {

        G = new HashMap<>();
        inCount = new int[n + 1]; //注意课程编号是从 1 开始的

        //建图
        buildGraph(relations);

        //广度优先搜索

        int step = 0;  //记录学期
        int studiedCount = 0;   //记录学习过的课程

        Queue<Integer> queue = new LinkedList<>();

        //初始化入度为 0 的队列，这些课程都是必须最开始先学习的课程
        for(int node = 1; node < n + 1; node++){
            if(inCount[node] == 0){
                queue.offer(node);
            }
        }

        while(!queue.isEmpty()){
            step++; //每次广度层序遍历需要一个新学期

            int size = queue.size();

            studiedCount += size; //这个学期需要学习的全部课程数

            for(int i = 0; i < size; i++){
                int from = queue.poll(); //当前需要学习的课程

                List<Integer> nextList = G.get(from); //当前课程的后继课程

                if(nextList != null){
                    for(int next : nextList){
                    inCount[next]--; //学完当前课程，则相关的后继课程入度减 1

                    if(inCount[next] == 0){
                        queue.offer(next); //如果某个后继课程入度为 0，则可以下学期优先学
                    }
                }
                }
            }
        }

        return studiedCount == n ? step : -1;
    }

    private void buildGraph(int[][] relations){

        for(int[] relation : relations){
            int from = relation[0];
            int to = relation[1];
            G.putIfAbsent(from,new ArrayList<>());
            G.get(from).add(to);

            inCount[to]++;
        }
    }


}