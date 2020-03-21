# 排序算法
* [冒泡排序](#冒泡排序)
* [选择排序](#选择排序)
* [插入排序](#插入排序)
* [希尔排序](#希尔排序)
* [归并排序](#归并排序)
* [快速排序](#快速排序)
* [堆排序](#堆排序)
* [计数排序](#计数排序)
* [桶排序](#桶排序)
* [基数排序](#基数排序)

## Summary

![排序算法](/algorithm/Sorting/sorting_summary.png)

[十大经典排序算法](https://www.cnblogs.com/guoyaohua/p/8600214.html)


特点：
* **原址的(in place)**： 如果输入数组中仅有常数个元素需要在排序过程中存储在数组之外，则称排序算法是原址的；
* 比较排序算法：通过对元素进行比较操作来确定输入数组的有序次序；
* 稳定：如果a在b的前面，且a==b，排序后a仍然在b的前面；


> * 快速排序再实际应用中通常比堆排序快；
> * 使用决策树模型，可以证明：任意比较排序算法排序n个元素的最坏情况运行时间的下界为Omega(nlgn)；

## 冒泡排序
算法：
1. 从头到尾遍历一次数组
    * 比较相邻两个元素的大小，如果第一个比第二个元素大，则交换两个元素
2. 如果遍历过程中没有交换，则结束；如果有交换操作，则回到步骤1
3. 结束后即可得到排序的数组

> 时间复杂度：最好（O(n)）、最坏（O(n^2)）、平均（O(n^2)）
> 
> 空间复杂度：O(1)


![未显示](/algorithm/Sorting/BubbleSort.gif)


## 选择排序
算法：
1. 从未排序的位置开始往后遍历，记录最小的元素
2. 将最小元素和未排序的第一个元素进行交换
3. 重复n-1次，即可得到有序数组

> 时间复杂度：最好（O(n^2)）、最坏（O(n^2)）、平均（O(n^2)）
> 
> 空间复杂度：O(1)
> 
> 不稳定：比如序列5、8、5、2、9，在一遍遍历交换后，第一个5和第二个5顺序发生改变了

![未显示](/algorithm/Sorting/SelectionSort.gif)


## 插入排序

算法：
1. 选择第一个未排序的元素
    * 在已排序的元素中插入该未排序的元素：如果插入元素比当前元素小，后移一位当前元素；否则插入元素
2. 所有未排序元素遍历完成后，即可得到有序数组

> 时间复杂度：最好（O(n)）、最坏（O(n^2)）、平均（O(n^2)）
> 
> 空间复杂度：O(1)

![未显示](/algorithm/Sorting/InsertionSort.gif)


## 希尔排序

算法：
1. 设置增量大小为序列长度的一半，K=n/2
2. 按照增量为步长，分组进行插入排序
3. 将增量减小一半K=K/2，重复步骤2
4. 当增量减为0时停止，即可得到有序数组

**实质上，希尔排序是一种分组插入排序**

> 时间复杂度：最好（O(n\*log^2 n)）、最坏（O(n\*log^2 n)）、平均（O(nlogn)）
> 
> 空间复杂度：O(1)
> 
> 不稳定：在不同的插入排序过程中，相同的元素可能在各自的插入排序中移动，最后其稳定性就会被打乱，所以shell排序是不稳定的。

![未显示](/algorithm/Sorting/ShellSort.png)

## 归并排序

算法1：
1. 将长度为n的序列分成两个长度为n/2的序列
2. 对两个序列分别采用归并排序
3. 将两个排序后的子序列合并成最终序列

算法2：
1. K=1，按照每K个有序元素，两组合并
2. K=K\*2，重复操作1，直到K>=n


> 时间复杂度：最好（O(nlogn)）、最坏（O(nlogn)）、平均（O(nlogn)）
> 
> 空间复杂度：O(n)

![未显示](/algorithm/Sorting/MergeSort.gif)

## 快速排序

算法：
1. 从数组中找到一个“基准”元素（pivot）
2. 重新排列数组，所有比基准值小的元素放到基准前面，所有比基准值大的元素放到基准后面，基准放到中间位置
3. 递归地将小于基准的子数组和大于基准的子数组，分别按照1进行同样的处理


> 时间复杂度：最好（O(nlogn)）、最坏（O(n^2)）、平均（O(nlogn)）
> 
> 空间复杂度：O(logn)
> 
> 不稳定：快排是不稳定的，比如，将大于基准的元素和小于基准的元素交换位置时，会使得相同的元素相对位置发生改变

![未显示](/algorithm/Sorting/QuickSort.gif)

## 堆排序

算法：
1. 首先将数组的n个元素构建成大顶堆
2. 从大顶堆的堆顶取出最大的元素，和数组中的第n个元素交换，这会破坏大顶堆的性质，需要执行下沉操作重新构建大顶堆
3. 重复步骤2，使得n-1、n-2、...、2位置的数组元素依次排序


> 时间复杂度：最好（O(nlogn)）、最坏（O(nlogn)）、平均（O(nlogn)）
> 
> 空间复杂度：O(1)
> 
> 不稳定：堆排序是不稳定的，因此每次元素的“下沉”操作都有可能会破坏元素的稳定性

![未显示](/algorithm/Sorting/HeapSort.gif)

## 计数排序

计数排序的核心在于将数据值转化为键存储在额外开辟的数组空间中，只能对整数进行排序。

算法：  
1. 找出待排序的数组中最大元素和最小元素
2. 统计数组中每个值为i的元素出现次数，存入数组C的第i项
3. 将数组C的每一项依次累加（Ci=Ci-1+Ci）
4. 反向填充数组：从最后一项遍历，将值为i的数放到位置Ci处，同时Ci减一

> 时间复杂度：最好（O(n+k)）、最坏（O(n+k)）、平均（O(n+k)）
> 
> 空间复杂度：O(n+k)
> 
> 稳定：计数排序是稳定的，因为反向填充数组的顺序是固定的

![未显示](/algorithm/Sorting/CountingSort.gif)


## 桶排序

桶排序是将数组分到有限数量的桶里，每个桶再分别排序

算法：
1. 根据待排序集合中最大元素和最小元素的差值范围和映射规则，确定申请桶的个数
2. 遍历待排序集合，将每个元素移动到对应的桶中
3. 对每个桶中元素进行排序，并移动到已排序集合中

> 时间复杂度：最好（O(n+k)）、最坏（O(n^2)）、平均（O(n+k)）
> 
> 空间复杂度：O(n+k)
> 
> 稳定：桶排序的稳定性取决于每个桶内的排序算法，一般可以选择稳定的算法

![未显示](/algorithm/Sorting/BucketSort.png)

## 基数排序

算法：
1. 从最低优先级的位数开始，按照桶排序依次排序
2. 在各个优先级位数重复步骤1，从而得到排序集合

> 时间复杂度：最好（O(n×k)）、最坏（O(n×k)）、平均（O(n×k)）
> 
> 空间复杂度：O(n+k)
> 
> 稳定：基数排序是稳定的，因为每次都是顺序遍历的

![未显示](/algorithm/Sorting/RadixSort.gif)