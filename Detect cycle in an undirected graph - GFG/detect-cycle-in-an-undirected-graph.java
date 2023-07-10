//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends

class Pair {
    int node;
    int parent;
    
    Pair(int node, int parent) {
        this.node = node;
        this.parent = parent;
    }
}

class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int[] vis = new int[V];
        
        for(int i=0; i<V; i++) {
            if(vis[i]==0) {
                // if(bfs(adj, vis, i)) {
                //     return true;
                // }
                if(dfs(adj, vis, i, -1)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean dfs(ArrayList<ArrayList<Integer>> adj, int[] vis, int node, int parent) {
        
        vis[node] = 1;
        for(int adjNode: adj.get(node)) {
            if(vis[adjNode]==0) {
                if(dfs(adj, vis, adjNode, node)) {
                    return true;
                }
            } else if(adjNode!=parent) {
                return true;
            }
        }
        
        return false;
    } 
    
    public boolean bfs(ArrayList<ArrayList<Integer>> adj, int[] vis, int idx) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(idx, -1));
        vis[idx] = 1;
        
        while(!q.isEmpty()) {
            Pair pair = q.poll();
            int node = pair.node;
            int parent = pair.parent;
            
            for(int nb: adj.get(node)) {
                if(vis[nb]==0) {
                    q.offer(new Pair(nb, node));
                    vis[nb] = 1;
                } else if(nb!=parent) {
                    return true;
                }
            }
        }
        
        return false;
    } 
}