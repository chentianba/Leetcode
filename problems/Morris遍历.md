## 二叉树的非递归遍历

#### 二叉树的`Morris`遍历算法
> 优点：（不用栈、`O(1)`空间）

* 中序遍历

  * 当当前结点`node`**无前驱结点**，则输出当前结点并`node = node->right`
  * 当当前结点`node`**前驱结点`pre`的右指针指向当前结点**，即`pre->right == node`，则将`pre = null`并输出当前结点
  * 当当前结点`node`前驱结点`pre`的右指针**未指向当前结点**，则将`pre->right = node`并`node = node->left`

* 前序遍历

  * 遍历方法和中序一样，不同的是在**无前驱结点**和前驱结点**未指向当前结点**时输出

* 后序遍历

  * 遍历方法和中序一样，不同的是输出：将**左子结点-右子结点链**按照**翻转-输出-再翻转**

    ```java
        public void printPost(TreeNode node) {
            TreeNode pre = null;
            TreeNode next = null;
            TreeNode cur = node;
            // reverse the right list
            while (cur != null) {
                next = cur.right;
                cur.right = pre;
                pre = cur;
                cur = next;
            }
            // print from tail to head
            for (cur = pre; cur != null; cur = cur.right) {
                System.out.println(cur.val+" ");
            }
            // reverse the right list
            cur = pre; pre = null;
            while (cur != null) {
                next = cur.right;
                cur.right = pre;
                pre = cur;
                cur = next;
            }
        }
    ```