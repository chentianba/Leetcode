# 树算法

- [二叉树的遍历——深度优先搜索DFS](#深度优先搜索)
  * 前序遍历
  * 中序遍历
  * 后序遍历
- [二叉树的遍历——宽度优先搜索BFS](#宽度优先搜索)
    * 层次遍历
- [哈夫曼树的编码与解码](#哈夫曼树)
- [堆的构建与增删](#堆)
- [二叉搜索树的增删改查](#BST)
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
    > 重复该操作，直到遍历指针为空并且栈为空
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
    > 重复该操作，直到遍历指针为空并且栈为空
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


## 堆

## BST

## AVL