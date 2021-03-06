## 无序数组求第k大
* 解法一：[大小为k的最小堆](#大小为k的最小堆)
* 解法二：[快速排序](#快速排序)

### 大小为k的最小堆
维护一个k大小的最小堆，对于数组中的每一个元素判断与堆顶的大小，若堆顶较大，则不管，否则，弹出堆顶，将当前值插入到堆中。  

*时间复杂度O(n * logk)*

### 快速排序
利用快速排序的思想，从数组S中随机找出一个元素X，把数组分为两部分Sa和Sb。Sa中的元素大于等于X，Sb中元素小于X。这时有两种情况：  
1. Sa中元素的个数小于k，则Sb中的第k-|Sa|个元素即为第k大数；
2. Sa中元素的个数大于等于k，则返回Sa中的第k大数。    

*时间复杂度近似为O(n)*

### 两种方法优势对比
使用堆的好处是：
* 快速排序需要先保存所有数据，而使用堆可以处理数据量较大的流式数据，每来一个元素就插入到堆中
* 快速排序需要修改原数组，如果原数组不能修改的话，需要对原数组拷贝，增加了空间复杂度

快速排序（分治法）的好处：
* 时间复杂度优