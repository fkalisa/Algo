package disjoint_set.concept;

class DS{
    int n;
    int root [];
    int rank[];
    DS(int n){
        this.n = n;
        root = new int[n];
        rank = new int[n];

        for(int i = 0; i < n; i++){
            root[i] = i;
            rank[i] = 1;
        }
    }

    // union by rank
    void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX != rootY){
            if(rank[rootX] >rank[rootY] ){
                root[rootY] = rootX;
            }else if(rank[rootX] <rank[rootY]){
                root[rootX] = rootY;
            }else{
                root[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }

    // path compression
    int find(int x){
        if(x == root[x]){
            return x;
        }
        return root[x] = find(root[x]);
    }

    boolean connected(int x, int y){
        return find(x) == find(y);
    }
}
