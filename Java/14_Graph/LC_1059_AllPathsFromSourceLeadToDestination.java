
class Solution {

    int VISITING = 1;
    int VISITED = 2;
    Map<Integer, List<Integer>> G;

    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {

        //建图
        buildGraph(edges);

        //回溯+记忆化
        int[] visited = new int[n];
        return dfs(visited,source,source,destination);
    }

    private void buildGraph(int[][] edges){
        G = new HashMap<>();
        for(int[] edge : edges){
            int from = edge[0];
            int to = edge[1];
            G.putIfAbsent(from,new ArrayList<>());
            G.get(from).add(to);
        }
    }

    private boolean dfs(int[] visited,int cur,int source,int destination){
        //叶子节点处理
        if(!G.containsKey(cur)){
            //情况一：叶子节点不是目标节点，失败
            if(cur != destination){
                return false;
            }
        }

        //非叶子节点处理
        if(G.containsKey(cur)){
            visited[cur] = VISITING;
            for(int neighbour : G.get(cur)){

                //已经访问过的节点不重复找
                if(visited[neighbour] == VISITED){
                    continue;
                }

                //情况二：遇到正在访问的节点，说明有环，失败
                if(visited[neighbour] == VISITING){
                    return false;
                }

                //情况三：后续路径存在情况一和情况二，失败
                if(!dfs(visited,neighbour,source,destination)){
                    return false;
                }
            }
            visited[cur] = VISITED;
        }

        return true;
    }
}