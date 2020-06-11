# 图

| 功能 | 方法 | 时间复杂度 | 简介
| --- | --- | :---: | :--- |
| 图的遍历 | [深度优先搜索DFS](#深度优先搜索) | - | 使用栈 |
| | [宽度优先搜索BFS](#宽度优先搜索) | - | 使用队列 |
| | [拓扑排序](#拓扑排序) | - | <li>选取入度为0的结点</li><li>删除该结点和其所有出边</li> |
| |　[关键路径算法](#关键路径) | - | <li>先拓扑排序</li><li>顺序求出最晚开始时间，再逆序求出最早开始时间</li><li>最晚、最早开始时间相等的就是关键活动</li> |
| 单源最短路径 | [Bellman-Ford算法](#Bellman-Ford算法) | O(VE) | <li>对所有边进行松弛操作，进行V-1次</li> <li>再对所有边进行第V次松弛判断，如果可以松弛，则存在负值环路</li>|
| | [有向无环图的单源最短路径](#有向无环图的单源最短路径) | O(V+E) | <li>先拓扑排序</li><li>按照拓扑序对每个顶点的出边执行松弛操作</li> |
| | [Dijkstra算法（优先队列）](#Dijkstra算法) | O((V+E)logV) | <li>从U(初始为V)中找出路径最短的结点u，加入到集合S中</li><li>对u的所有出边执行松弛操作</li><li>重复V次</li> |
| 所有结点对的最短路径 | [Floyd算法](#Floyd算法) | O(V^3) | 动态规划 |
| 最小生成树 | [Kruskal算法](#Kruskal算法) | O(VE) | <li>从边集合中找出权重最小的边</li><li>判断该边的两个顶点是否在同一连通分量中</li>|
| | [Prim算法](#Prim算法) | O(V^2) | <li>找到U(初始化为u0)和V-U之间权重最小的边<u,v></li><li>将v加入U中，重复V次</li> |
***

## 图的遍历

### **深度优先搜索**

深度优先搜索DFS使用**栈**
```java
public void dfs() {
    Stack<Integer> stack = new Stack<>();
    boolean[] visited = new boolean[n];
    int p = 0;
    stack.push(0);
    visited[p] = true; // 标记入栈结点，防止重复遍历
    while (!stack.empty()) {
        p = stack.pop();
        System.out.print((p+1)+" ");
        for (int i = n-1; i >= 0; --i) {
            if (edge[p][i] < inf && edge[p][i] > 0 && !visited[i]) { // 该边有效且新节点未被遍历
                stack.push(i);
                visited[i] = true;
            }
        }
    }
    System.out.println();
}
```

### **宽度优先搜索**

宽度优先搜索BFS使用**队列**
```java
public void bfs() {
    Queue<Integer> queue = new LinkedList<>();
    boolean[] visited = new boolean[n];
    int p = 0;
    queue.offer(p);
    visited[p] = true; // 标记入队结点，防止重复遍历
    while (!queue.isEmpty()) {
        p = queue.poll();
        System.out.print((p+1)+" ");
        for (int i = n-1; i >= 0; --i) {
            if (edge[p][i] < inf && edge[p][i] > 0 && !visited[i]) { // 该边有效且新节点未被遍历
                queue.offer(i);
                visited[i] = true;
            }
        }
    }
    System.out.println();
}
```

### **拓扑排序**

1. 从网格中选择一个入度为0的顶点输出；
2. 从网中删除该顶点及其所有出边；
3. 执行步骤1、步骤2，直到所有顶点已输出，或网中剩余顶点入度均不为0（说明网中存在回路）

伪代码：  
```java
```

### **关键路径**

求关键活动算法：
1. 对AOE网络**拓扑排序**；（若网中有回路，则终止算法）
2. 按拓扑次序求出各顶点事件的**最早发生时间ve**；
3. 按拓扑序列的**逆序**求各顶点事件的**最迟发生时间vl**；
4. 根据ve和vl的值，*最早开始时间*与*最迟开始时间***相等**的活动，即为关键活动。
***
## 单源最短路径

### **Bellman-Ford算法**

> 限制条件：*对边无要求*  
> 时间复杂度：*O(VE)*  
> 作用：**侦测是否存在从源结点可以到达的权重为负值的环路**  

Bellman-Ford算法是**基于边**的算法，通过对每条边进行`V-1(V为边的条数)`次**松弛**，使得每个结点上记录最短路径；当再进行第V次松弛判断时，如果可以松弛，则说明存在负值环路，否则，不存在负环。

伪代码：  
![伪代码](/algorithm/Graph/bellman_ford.png)

### **有向无环图的单源最短路径**

> 限制条件：*有向无环图*  
时间复杂度：*O(V+E)*  
作用：利用DAG的拓扑排序减少复杂度

步骤：
1. 对DAG拓扑排序
2. 按照**拓扑序**遍历顶点，对每个顶点**u**
    * 对以u为源点的边，执行**松弛**操作
3. 结束后即可得到最短路径

伪代码：  
```
DAG-SINGLE-SOURCE-SHORTEST-PATH(G,s)
1 INITIALIZE-SINGLE-SOURCE(G,s)
2 topo_vertices = topologically sort the vertices of G
3 for u in topo_vertices
4   for v in G.Adj[u]
5     RELAX[u, v]
```

### **Dijkstra算法**
> 限制条件：*所有边的权重都为非负值*  
时间复杂度：*O((E+V)logV)*  
作用：采用合适的方式，Dijkstra算法的运行时间要低于Bellman-Ford算法的运行时间

Dijkstra算法使用**贪心+动态规划**，初始化时，集合S为空，从当前路径中找到最短路径的顶点u（该过程可以使用**优先队列**优化），加入到S中，然后从顶点u松弛V-S中顶点的路径，重复V次，直到所有顶点都加入到S中。  
伪代码：  
![伪代码](/algorithm/Graph/dijkstra_priority_queue.png)
```cpp
/*
class Node {
public:
    int id, dis;
    Node(int x, int y):id(x), dis(y) {}
    bool operator < (const Node &an) const{
        return dis > an.dis;
    }
};
*/
priority_queue<Node> pq; // 优先队列
vector<Node> adj[N]; // 邻接矩阵
bool visit[N]; 
int d[N]; // 最短路径
visit[0] = true; d[0] = 0;
pq.push(Node(0, 0));
while (!pq.empty()) {
    u = pq.top().id;
    pq.pop(); // 从优先队列找到最短路径的顶点，记为u
    if (visit[u]) continue; // 如果u已经找到最短路径，跳过
    visit[u] = false;
    for (int i = 0; i < adj[u].size(); ++i) { // 和u相连的所有边
        v = adj[u][i].id;
        if (!visit[v] && d[u] + adj[u][i].dis < d[v]) { // 松弛操作
            d[v] = d[u] + adj[u][i].dis;
            // 压入优先队列，不用担心重复压入，因为每次弹出的都是路径最短的顶点，
            // 所以只有第一次出队的元素有效，被visit标记，以后都会直接略过
            pq.push(Node(v, d[v])); 
        }
    }
}
```
***
## 所有结点对的最短路径

### **Floyd算法**

> 限制条件：*可以有负权重，但不能存在权重为负值的环路*  
时间复杂度：*O(V^3)*  
作用：解决所有结点对最短路径问题

**Floyd-Warshall**算法利用**动态规划**，从结点i到结点j的最短路径有两种情况，要么直接从i到j，要么从i经过多个结点k到达j。
![](/algorithm/Graph/floyd.png)

伪代码：
```java
for (int k = 0; k < n; ++k) {
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
            if (A[i][j] > A[i][k] + A[k][j]) {
                A[i][j] = A[i][k] + A[k][j]; // relax
            }
        }
    }
}
```

***
## 最小生成树

连接图中所有节点且具有最小权重的图（树），称为**最小生成树**。

### **Kruskal算法**

> 时间复杂度：*O(VE)*  
> 适用：适用于求边稀疏网的最小生成树

Kruskal算法过程为：
1. 初始化T为只有n的顶点的最小生成树；
2. 从边集合E中选权值最小的边，并将此边从E中删除；
3. 如果此边两个顶点在T的不同连通分量中，则将此边加入到T中，从而导致T中减少一个连通分量；
4. 如果此边的两个顶点在同一连通分量中，则重复执行步骤2，直至仅剩一个连通分量，终止操作。

伪代码：
```java
public void kruskal() {
    int[] con = new int[m];
    for (int i = 0; i < m; ++i) {
        con[i] = i; // 标记连通分量
    }
    for (int k = 0; k < m-1; ++k) {
        int minVal = inf;
        int u = -1, v = -1;
        // 找到权重最小的边
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < m; ++j) {
                if (adj[i][j] > 0 && adj[i][j] < inf && con[i] != con[j] && adj[i][j] < minVal) {
                    minVal = adj[i][j];
                    u = i;
                    v = j;
                }
            }
        }
        System.out.println("edge "+u+" --> "+v);
        // 更新选中边的连通分量
        int level = Math.min(con[u], con[v]);
        int change = Math.max(con[u], con[v]);
        for (int i = 0; i < m; ++i) {
            if (con[i] == change) con[i] = level;
        }
    }
}  
```

### **Prim算法**

> 时间复杂度：*O(V^2)*  
> 适用：适用于求边稠密网的最小生成树

Prim算法过程为：
1. 初始化MST的顶点U={u0}，MST的边集合为TE为空；
2. 找到权重最小的边，其中边的一个顶点u在U中，一个顶点v在V-U中；
3. 把该边并入TE中，顶点v并入U中；
4. 重复执行步骤2，直至U=V，算法结束。

伪代码：
```java
public void prim() {
    boolean[] visited = new boolean[m]; // 记录访问结点
    int[] dis = new int[m]; // 参考Dijkstra算法，记录未访问结点到访问集合的距离
    int[] parent = new int[m]; // 记录父结点
    for (int i = 0; i < m; ++i) {
        dis[i] = inf;
        parent[i] = -1;
    }
    dis[0] = 0; // 标记起始结点
    for (int k = 0; k < m; ++k) {
        int minVal = inf;
        int v = -1;
        for (int i = 0; i < m; ++i) {
            // 找到未访问结点中距离最短的结点
            if (dis[i] < minVal && !visited[i]) { 
                minVal = dis[i];
                v = i;
            }
        }
        visited[v] = true; // 标记
        System.out.println("edge "+parent[v]+" --> "+v);
        for (int i = 0; i < m; ++i) {
            // 松弛该结点所有的出边
            if (adj[v][i] > 0 && adj[v][i] < inf && adj[v][i] < dis[i] && !visited[i]) {
                dis[i] = adj[v][i];
                parent[i] = v;
            }
        }
    }
}
```
***