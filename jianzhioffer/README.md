# Content
加粗的是第一次做没考虑到的，可以重做

1. [**二维数组中的查找**](#二维数组中的查找)
2. [替换空格](#替换空格)
3. [从尾到头打印链表](#从尾到头打印链表)
4. [重建二叉树](#重建二叉树)
5. [用两个栈实现队列](#用两个栈实现队列)
6. [旋转数组的最小数字](#旋转数组的最小数字)
7. [斐波那契数列](#斐波那契数列)
8. [跳台阶](#跳台阶)
9. [变态跳台阶](#变态跳台阶)
10. [矩形覆盖](#矩形覆盖)
11. [二进制中1的个数](#二进制中1的个数)
12. [数值的整数次幂](#数值的整数次幂)
13. [调整数组顺序使奇数位于偶数前面](#调整数组顺序使奇数位于偶数前面)
14. [链表中倒数第k个结点](#链表中倒数第k个结点)
15. [反转链表](#反转链表)
16. [合并两个排序的链表](#合并两个排序的链表)
17. [树的子结构](#树的子结构)
18. [二叉树的镜像](#二叉树的镜像)
19. [顺时针打印矩阵](#顺时针打印矩阵)
20. [**包含min函数的栈**](#包含min函数的栈)
21. [栈的压入、弹出序列](#栈的压入、弹出序列)
22. [从上往下打印二叉树](#从上往下打印二叉树)
23. [二叉搜索树的后序遍历序列](#二叉搜索树的后序遍历序列)
24. [**二叉树中和为某一值的路径**](#二叉树中和为某一值的路径)
25. [**复杂链表的复制**](#复杂链表的复制)
26. [二叉搜索树与双向链表](#二叉搜索树与双向链表)
27. [字符串的排列](#字符串的排列)
28. [数组中出现次数超过一半的数字](#数组中出现次数超过一半的数字)
29. [最小的K个数](#最小的K个数)
30. [连续子数组的最大和](#连续子数组的最大和)
31. [**整数中1出现的次数（从1到n整数中1出现的次数）**](#整数中1出现的次数（从1到n整数中1出现的次数）)
32. [**把数组排成最小的数**](#把数组排成最小的数)
33. [**丑数**](#丑数)
34. [第一个只出现一次的字符](#第一个只出现一次的字符)
35. [数组中的逆序对](#数组中的逆序对)
36. [**两个链表的第一个公共结点**](#两个链表的第一个公共结点)
37. [数字在排序数组中出现的次数](#数字在排序数组中出现的次数)
38. [二叉树的深度](#二叉树的深度)
39. [平衡二叉树](#平衡二叉树)
40. [数组中只出现一次的数字](#数组中只出现一次的数字)
41. [**和为S的连续正数序列**](#和为S的连续正数序列)
42. [和为S的两个数字](#和为S的两个数字)
43. [左旋转字符串](#左旋转字符串)
44. [翻转单词顺序列](#翻转单词顺序列)
45. [扑克牌顺子](#扑克牌顺子)
46. [孩子们的游戏(圆圈中最后剩下的数)](#孩子们的游戏(圆圈中最后剩下的数))
47. [求1+2+3+...+n](#求1+2+3+...+n)
48. [**不用加减乘除做加法**](#不用加减乘除做加法)
49. [把字符串转换成整数](#把字符串转换成整数)
50. [数组中重复的数字](#数组中重复的数字)
51. [构建乘积数组](#构建乘积数组)
52. [正则表达式匹配](#正则表达式匹配)
53. [表示数值的字符串](#表示数值的字符串)
54. [](#)
55. [**链表中环的入口结点**](#链表中环的入口结点)
56. [删除链表中重复的结点](#删除链表中重复的结点)
57. [二叉树的下一个结点](#二叉树的下一个结点)
58. [对称的二叉树](#对称的二叉树)
59. [按之字形顺序打印二叉树](#按之字形顺序打印二叉树)
60. [把二叉树打印成多行](#把二叉树打印成多行)
61. [序列化二叉树](#序列化二叉树)
62. [二叉搜索树的第k个结点](#二叉搜索树的第k个结点)
63. [](#)
64. [**滑动窗口的最大值**](#滑动窗口的最大值)
65. [矩阵中的路径](#矩阵中的路径)


* [66机器人的运动范围](#机器人的运动范围)
* [67剪绳子](#剪绳子)


## 二维数组中的查找
**题目描述**：在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

**思路**：**二分查找**，这里使用二维的二分查找方法，和一维二分查找使用两个指针不断逼近不同，二维二分查找在横、纵两个方向上不断缩小平面的范围，从右上角不断向左下角逼近。

伪代码：
```
input: 数组arr, 整数target
r = 0, c = arr.columns - 1
while r < c.rows and c >= 0
    if arr(r, c) == target
        return true
    if arr(r, c) < target
        r++
    else
        c--
return false
```

## 替换空格
**题目描述**：给定一个数组，完成In-place字符替换，将空格替换成"%20"

**思路**：双指针  
伪代码：
```
Input: 数组a，数组字符串长度len，数组最大长度maxLen
p = len-1, t = maxLen - 1
while p >= 0
    if a[p] == ' '
        a[t--] = '0'
        a[t--] = '2'
        a[t--] = '%'
        p -= 1
    else
        a[t--] = a[p--]
for i = t+1 to maxLen-1
    a[i-t-1] = a[i]
```

## 从尾到头打印链表
反转链表

## 重建二叉树
递归实现

## 用两个栈实现队列
使用两个栈模拟

## 旋转数组的最小数字
**思路**：二分查找，由于旋转数组基本有序，因此可以考虑使用二分法查找。
伪代码：
```
Input: 数组a
r = a.length
l = 0
while l < r
    mid = l + (r-l)/2
    if a[mid] == a[r]
        r -= 1
    elif a[mid] < a[r]
        r = mid
    else
        l = mid + 1
return a[l]
```

## 斐波那契数列
递归或者简单的动态规划

## 跳台阶
和斐波那契数列解法一样

## 变态跳台阶
**动态规划**：问题转化成——从哪个台阶跳上终点台阶

## 矩形覆盖
斐波那契数列

## 二进制中1的个数
> 技巧：val & (val-1)会消去val二进制中的一个1，比如val=110100，val-1=110011，val&(val-1)=110000，1少了一个

## 数值的整数次幂
**思路**：**快速幂**。
伪代码：
```
Input: 浮点数base，整数exponent
if exponent < 0
    exponent = -exponent
    base = 1/base
n = exponent
x = base
ret = 1
while n != 0
    if n%2 == 1
        ret = ret * x
    x = x*x
    n = n/2
return ret
```

## 调整数组顺序使奇数位于偶数前面
* 使用辅助数组
* 不使用辅助数组
    * 冒泡排序思路
    * 插入排序思路

## 链表中倒数第k个结点
**思路**：快慢指针

## 反转链表
**思路**：指针操作

## 合并两个排序的链表

## 树的子结构
**思路**：递归。分两部分，一部分是比较两个子树结构是否相等，另一个是遍历A树，找出所有子树，从而进行比较

伪代码：
```
fuction isEqual: 根节点root1，根节点root2
if root2 == null
    return true
if root1 == null
    return false
return root1.val == root2.val 
        and isEqual(root1.left, root2.left)
        and isEqual(root1.right, root2.right)

function hasSubTree: A根节点root1，B根节点root2
if root2 == null or root1 == null
    return false
return isEqual(root1, root2) ||
        hasSubTree(root1.left, root2) ||
        hasSubTree(root1.right, root2)
```

## 二叉树的镜像
层次遍历

## 顺时针打印矩阵

## 包含min函数的栈
使用双栈，用空间换时间

stack1:[4, 2, 1, 3, 4, 2, -1]  
stack2:[4, 2, 1, 1, 1, 1, -1]

## 栈的压入、弹出序列
模拟栈

## 从上往下打印二叉树
层次遍历

## 二叉搜索树的后序遍历序列
分治法

## 二叉树中和为某一值的路径
DFS，遍历二叉树的，同时维护一个路径数组

## 复杂链表的复制
使用多次遍历的方法，实现起来需要考虑random为null的情况，可以锻炼对链表的操作

## 二叉搜索树与双向链表
分治法

## 字符串的排列
回溯法

## 数组中出现次数超过一半的数字
使用候选法，遍历数组，将两两不同的数字抵消，最后标记的可能是众数、也可能不是，再次遍历判断是不是众数。

伪代码：
```
Input: 数组a
cnt = 0
cand = -1
for i = 0 to a.length-1
    if cnt == 0
        cnt += 1
        cand = a[i]
    else
        if a[i] == cand
            cnt += 1
        else:
            cnt -= 1
cnt = 0
for i = 0 to a.length-1
    if cand == a[i]
        cnt += 1
return cnt > a.length/2 ? cand : -1
```

## 最小的K个数
TOP K问题：快排、堆排

## 连续子数组的最大和
动态规划，f(i)是以i结尾的、最大和的子数组，f(i) = max{f(i-1)+array[i], array[i]}，但是没必要存储n个状态，因为f(i)只和f(i-1)相关

## 整数中1出现的次数（从1到n整数中1出现的次数）
整数中1出现的次数等于`整数中各个位是1的次数之和`，难点在分析各个位是`==0`、`==1`，`2-9`三种情况下次数出现规律

## 把数组排成最小的数
利用库函数排序，主要是对两个数大小比较：将两个数分别按照先后顺序拼接，比较两个字符串的大小

> 做题时，先从最直接的方法开始思考，然后一步一步优化，不要一开始就想太多

## 丑数
由于时间限制，要通过已有的丑数不断地生成后续丑数，一个丑数乘以2/3/5后还是丑数，关键是丑数顺序。

类似K个链表合并，维持3个“链”——2a/3b/5c，不断合并最小丑数。

## 第一个只出现一次的字符
哈希

## 数组中的逆序对
归并排序

## 两个链表的第一个公共结点
思路：双指针法，例如
```
a1 -> a2 -> c -> d
      b1 -> |
```
则可以将链表a和链表b拼接，如
```
b1 ->  c ->  d -> a1 -> a2 -> c ->d
a1 -> a2 ->  c ->  d -> b1 -> |
```
这样链表a和链表b遍历相同的步数即可找到第一个共同结点

## 数字在排序数组中出现的次数
二分查找

## 二叉树的深度
分治法

## 平衡二叉树
递归分治

## 数组中只出现一次的数字
位运算或者哈希

## 和为S的连续正数序列
滑动窗口

## 和为S的两个数字
双指针/滑动窗口

## 左旋转字符串

## 翻转单词顺序列
字符串切割、拼接

## 扑克牌顺子

## 孩子们的游戏(圆圈中最后剩下的数)
约瑟夫环问题

## 求1+2+3+...+n

## 不用加减乘除做加法
用位运算模拟

## 把字符串转换成整数
要考虑整数边界

## 数组中重复的数字
哈希或者In-place算法：由于数组中的元素都小于n，如果无重复元素，排序后第i个位置的元素一定为i

## 构建乘积数组
正反个遍历一次

## 正则表达式匹配
递归或者动态规划

## 表示数值的字符串
分类考虑

## 


## 链表中环的入口结点
哈希或者**双指针**

## 删除链表中重复的结点
注意题目条件：链表有序，利用相邻结点是否相等

## 二叉树的下一个结点
类似二叉搜索树的后继结点

## 对称的二叉树
递归

## 按之字形顺序打印二叉树
队列

## 把二叉树打印成多行
队列、层次遍历

## 序列化二叉树
二叉树的遍历和构造

## 二叉搜索树的第k个结点
中序遍历

## 滑动窗口的最大值 
滑动窗口+单调队列

## 


## 矩阵中的路径
深度优先搜索+回溯





## 机器人的运动范围
**思路**：DFS或者BFS

## 剪绳子
**思路**：动态规划，需要注意绳子至少被切割成两段，最重要的是找出最优子结构：无论绳子怎么切割，最终都是分割成一段加一堆（大于等于一段），因此长度为m的绳子最大乘积f(m) = max{max(f(i), i)*max(f(m-i), m-i), ...}，i范围为[1, 2, ..., m-1]，需要注意，被分割的两段可能会被继续分割f(i)和f(m-i)，也可能不分割i和m-i，因此选两者最大值。

> 贪心算法是一种特殊的动态规划