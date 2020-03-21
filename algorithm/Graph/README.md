# 图
+ 图的遍历
  * [深度优先搜索DFS](#深度优先搜索)
  * [宽度优先搜索BFS](#宽度优先搜索)
  * [拓扑排序](#拓扑排序)
  * [关键路径算法](#关键路径)
+ 单源最短路径
  * [Bellman-Ford算法](#Bellman-Ford算法)
  * [有向无环图的单源最短路径](#有向无环图的单源最短路径)
  * [Dijkstra算法（优先队列）](#Dijkstra算法)
+ 所有结点对的最短路径
    * [Floyd算法](#Floyd算法)
+ 最小生成树
    * [Kruskal算法](#Kruskal算法)
    * [Prim算法](#Prim算法)

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

Bellman-Ford算法通过对每条边进行`V-1(V为边的条数)`次**松弛**，使得每个结点上记录最短路径；当再进行第V次松弛判断时，如果可以松弛，则说明存在负值环路，否则，不存在负环。

伪代码：  
![伪代码](/algorithm/Graph/bellman_ford.png)

### **有向无环图的单源最短路径**

> 限制条件：*有向无环图*  
时间复杂度：*O(V+E)*  
作用：



### **Dijkstra算法**
> 限制条件：*所有边的权重都为非de负值*  
时间复杂度：*O((E+V)logV)*  
作用：采用合适的方式，Dijkstra算法的运行时间要低于Bellman-Ford算法的运行时间

Dijkstra算法使用贪心+动态规划，初始化时，集合S为空，从当前路径中找到最短路径的顶点u（该过程可以使用**优先队列**优化），加入到S中，然后从顶点u松弛V-S中顶点的路径，重复V次，直到所有顶点都加入到S中。  
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

***
## 最小生成树


### **Kruskal算法**


### **Prim算法**

