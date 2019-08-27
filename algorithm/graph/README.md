## 图
+ [深度优先搜索DFS](#深度优先搜索)
  * 前序遍历
  * 中序遍历
  * 后序遍历
+ [宽度优先搜索BFS](#宽度优先搜索)
  * 层次遍历
+ 单源最短路径
  * [Dijkstra算法（优先队列）](#Dijkstra算法)

***
### 深度优先搜索
* **前序遍历**
1. 递归版
```cpp
void pre_traverse(TreeNode *root) {
  if (root != NULL) {
    cout << root->val << " ";
    pre_traverse(root->left);
    pre_traverse(root->right);
  }
}
```
2. 非递归版
> 初始化时将根节点压入栈  
弹出栈顶元素，输出该节点  
使用栈记录当前节点的右子节点、左子节点  
重复该操作  
```cpp
stack.push(root);
while (!stack.empty()) {
  p = stack.top(); stack.pop(); cout << p->val << " ";
  if (p->right != NULL) stack.push(p->right);
  if (p->left != NULL) stack.push(p->left);
}
```
* **中序遍历**
1. 递归版
```cpp
void pre_traverse(TreeNode *root) {
  if (root != NULL) {
    pre_traverse(root->left);
    cout << root->val << " ";
    pre_traverse(root->right);
  }
}
```
2. 非递归版  
中序遍历就是正常的深度优先搜索，一直向左遍历压入堆栈，直到叶子节点，然后弹出栈顶元素输出，并将该元素的右子节点压入堆栈，沿着右子节点的左方向继续压栈；重复该操作直至完成。
```cpp
TreeNode *p = root;
while (!stack.empty() || p != NULL) {
  if (p != NULL) {
    stack.push(p);
    p = p->left;
  } else {
    p = stack.top(); cout << p->val << " "; st.pop();
    p = p->right;
  }
}
```
* **后序遍历**
1. 递归版
```cpp
void pre_traverse(TreeNode *root) {
  if (root != NULL) {
    pre_traverse(root->left);
    pre_traverse(root->right);
    cout << root->val << " ";
  }
}
```
2. 非递归版  
使用**双栈**，后序遍历可以看做**倒过来的前序遍历**，即（左、右、中）->（中、右、左），因此先做前序遍历将遍历结果存入一个栈中，然后再将栈依次弹出即可。
***
### 宽度优先搜索
* **层次遍历**
```
使用队列，初始化时将根节点入队  
然后不断出队、输出信息、将左右非空子节点入队，直到队列为空
```
***
### Dijkstra算法
Dijkstra算法使用贪心+动态规划，初始化时，集合S为空，从当前路径中找到最短路径的顶点u（该过程可以使用**优先队列**优化），加入到S中，然后从顶点u松弛V-S中顶点的路径，重复V次，直到所有顶点都加入到S中。  
伪代码：  
![](https://github.com/chentianba/Leetcode/blob/master/algorithm/graph/dijkstra_priority_queue.png)
```cpp
cout << "Hello World!" << endl;
```
