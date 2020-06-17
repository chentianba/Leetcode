# 树算法

- [二叉树的遍历——深度优先搜索DFS](#深度优先搜索)
  * 前序遍历
  * 中序遍历
  * 后序遍历
- [二叉树的遍历——宽度优先搜索BFS](#宽度优先搜索)
    * 层次遍历
- [哈夫曼树的编码与解码](#哈夫曼树)
- [堆的构建与增删](#堆)
- [二叉搜索树的增删改查](#二叉搜索树BST)
  * 增
  * 删
  * 查
- [AVL的增删改查](#AVL)

***

## 深度优先搜索
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
    > 初始化时使用遍历指针记录root结点  
    * **当遍历指针不为空时**，输出该结点，并将右子结点压入栈，指针指向左子结点  
    * **当遍历指针为空时**，遍历指针定位到从栈中弹出的结点
    > 重复该操作，直到**遍历指针为空**并且**栈为空**
    ```java
    public void preTraverse(TreeNode root) {
        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.empty() || p != null) {
            if (p != null) {
                System.out.print(p.val+" "); // 第一次遍历时输出，不需要入栈
                stack.push(p.right); // 结点p已经遍历，不需要入栈
                p = p.left;
            } else {
                p = stack.pop(); // 弹出右子结点
            }
        }
        System.out.println();
    }
    ```
* **中序遍历**
    1. 递归版
    ```cpp
    void in_traverse(TreeNode *root) {
    if (root != NULL) {
        pre_traverse(root->left);
        cout << root->val << " ";
        pre_traverse(root->right);
    }
    }
    ```
    2. 非递归版  
    > 初始化时使用遍历指针记录root结点  
    * **当遍历指针不为空时**，将该结点压入栈，指针指向左子结点  
    * **当遍历指针为空时**，从栈中弹出结点并输出，同时遍历指针指向该结点的右子结点
    > 重复该操作，直到**遍历指针为空**并且**栈为空**
    ```java
    public void inTraverse(TreeNode root) {
        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.empty() || p != null) {
            if (p != null) {
                stack.push(p); // 需要第二次遍历时输出，因此需要入栈
                p = p.left; // 向左深度优先搜索
            } else {
                p = stack.pop(); // 弹出未遍历的父结点
                System.out.print(p.val+" "); // 第二次遍历时，输出
                p = p.right; // 进入未遍历的右子结点
            }
        }
        System.out.println();
    }
    ```
* **后序遍历**
    1. 递归版
    ```cpp
    void post_traverse(TreeNode *root) {
    if (root != NULL) {
        pre_traverse(root->left);
        pre_traverse(root->right);
        cout << root->val << " ";
    }
    }
    ```
    2. 非递归版  
    > 使用**双栈**，后序遍历可以看做**倒过来的前序遍历**，即（左、右、中）->（中、右、左），因此先做前序遍历将遍历结果存入一个栈中，然后再将栈依次弹出即可。

***
## 宽度优先搜索
* **层次遍历**
> 使用队列，初始化时将根节点入队  
然后不断出队、输出信息、将左右非空子节点入队，直到队列为空

***

## 哈夫曼树
哈夫曼编码是一种**贪心**算法，其过程如下：
1. 将字符集合(N个字符)作为叶子结点，并加入到优先队列中
2. 重复以下操作N-1次
    * 从优先队列中找到最小结点`a`
    * 从优先队列中找到最小结点`b`
    * 将`a`和`b`合并为`z`，并加入到优先队列中
3. 最后队列中只剩下一个结点，该结点即为哈夫曼树的根结点
```java
public TreeNode huffmanEncoding(int[] count) {
    Comparator<TreeNode> comp = new Comparator<TreeNode>() {
        @Override
        public int compare(TreeNode e1, TreeNode e2) {
            return e1.val - e2.val;
        }
    };
    PriorityQueue<TreeNode> pq = new PriorityQueue<>(comp);
    for (int i = 0; i < count.length; ++i) {
        pq.add(new TreeNode(count[i]));
    }
    TreeNode a = null, b = null, z = null;
    while (pq.size() > 1) {
        a = pq.remove();
        b = pq.remove();
        z = new TreeNode(a.val+b.val);
        z.left = a;
        z.right = b;
        pq.add(z);
    }
    return pq.remove();
}
```

## 堆

## 二叉搜索树BST
1. **增**  
    在二叉树中查找值为`z`的结点，停止查找时的遍历结点即为要插入的位置
    ```java
    public void insert(TreeNode root, int x) {
        TreeNode p = root;
        TreeNode t = null;
        while (p != null) {
            t = p;
            if (x == p.val) return;
            if (x < p.val) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (t == null) {
            root = new TreeNode(x);
        } else {
            if (x < t.val) {
                t.left = new TreeNode(x);
            } else {
                t.right = new TreeNode(x);
            }
        }
    }
    ```

2. **删**  
    删除结点后该位置由哪个结点替代
    * 当删除节点`不存在右子结点`，则该结点由其`左子结点`替代
        * 如果左子结点为null，则直接删除结点并用null替代
        * 如果左子结点不为null，则用左子结点替代
    * 当删除结点`存在右子结点`，则需要用其后继结点（一定在右子结点子树中）替代
        * 如果后继结点`X`为其右子结点时，说明右子结点`X`无左子结点，将删除节点`Z`的位置由`X`替代，且`X`的左子结点为`Z`的左子结点，`X`的右子结点不变
        * 如果后继结点`X`不为其右子结点，但是后继结点`X`一定不存在左子结点，那么用`X`替代删除节点`Z`，`X`的左右子结点为`Z`的左右子结点，`X`所在位置由`X`的右子结点替代
    ```java
    public void delete(TreeNode root, int x) {
        TreeNode z = search(root, x);
        if (z == null) return;
        TreeNode t = parent(root, x); // 删除结点的父结点
        if (z.right == null) { // 删除结点无右子树
            if (t.left == z) t.left = z.left;
            else t.right = z.left;
        } else { // 删除结点有右子树
            TreeNode y = search(z.right, minimum(z.right)); // 找到后继结点
            if (y == z.right) { // 后继结点为删除结点的右子结点
                if (t.left == z) t.left = y;
                else t.right = y;
                y.left = z.left;
            } else { // 后继结点不为删除结点的右子结点
                TreeNode p = parent(root.right, y.val);
                if (t.left == z) t.left = y;
                else t.right = y;
                p.left = y.right;
                y.left = z.left;
                y.right = z.right;
            }
        }
    }
    ```

3. **查**
    * 查找
        ```java
        public TreeNode search(TreeNode root, int x) {
            TreeNode p = root;
            while (p != null && p.val != x) {
                if (x < p.val) {
                    p = p.left;
                } else {
                    p = p.right;
                }
            }
            return p;
        }
        ```
    * 最小值和最大值
        ```java
        public int minimum(TreeNode root) {
            if (root == null) return -1;
            TreeNode p = root;
            while (p.left != null) {
                p = p.left;
            }
            return p.val;
        }
        ```
    * 后继和前驱  
        后继和前驱对称，寻找后继的步骤为：
        1. 如果该结点有右子树，则右子树中的`最小值`为后继结点
        2. 如果该结点无右子树，则说明在*该结点为根的子树*中，该结点值最大，需要从该结点的`父结点或者祖宗结点`中继续寻找寻找后继结点
            * 如果该结点为*父结点的左子结点*，那么比该结点大的父结点即为后继结点
            * 如果该结点为*父结点的右子结点*，那么需要找到`为左子结点的祖宗结点`，该祖宗结点的父结点即为后继结点
        ```java
        public TreeNode successor(TreeNode root, int x) {
            if (root == null) return null;
            TreeNode p = search(root, x);
            if (p.right != null) {  // 如果结点右侧有结点，则从右侧找到最小结点
                return search(root, minimum(p.right));
            }
            TreeNode parent = parent(root, x); // 右侧没有结点，从父结点开始寻找
            while (parent != null && parent.right == p) { 
                p = parent; // 该结点是父结点的右子结点，找为左子结点的祖宗结点
                parent = parent(root, p.val);
            }
            return parent; // 该结点是父结点的左子结点，则父结点为后继
        }
        ```


## AVL