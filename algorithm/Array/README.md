# 线性表
## 一、链表
#### 五个常见操作：
* 单链表反转
* 链表中环的检测
* 两个有序的链表合并
* 删除链表倒数第n个节点
 
#### 经典操作：
* 快慢指针

## 二、数组
数组支持随机访问，根据下标随机访问的时间复杂度为*O(1)*。数组为了保持内存数据的连续性，会导致插入、删除这两个操作比较低效。

    警惕数组的访问越界问题
针对数组类型，很多语言都提供了容器类，比如Java中的ArrayList、C++ STL中的vector。容器类的优势就是可以将很多数组操作的细节封装起来，且支持动态扩容。那么数组是不是就没有用武之地呢？并不是，适合数组使用的场景包括：
```
1. Java ArrayList无法存储基本类型，比如int、long，需要封装为Integer、Long类，而Autoboxing、Unboxing则有一定的性能消耗，所以如果特别关注性能，或者希望使用基本类型，就可以选用数组。

2. 如果数据大小事先已知，并且对数据的操作非常简单，用不到ArrayList提供的大部分方法，也可以直接使用数组。

3. 当要表示多维数组时，用数组往往会更加直观。比如Object[][] array；而用容器的话则需要这样定义：ArrayList<ArrayList > array。
```
总结一下，对于业务开发，直接使用容器就足够了，省时省力。毕竟损耗一丢丢性能，完全不会影响到系统整体的性能。但如果做一些非常底层的开发，比如开发网络框架，性能的优化需要做到极致，这个时候数组就会优于容器，成为首选。
## 三、栈
#### 在表达式求值中的应用

实际上，编译器中表达式求值就是通过两个栈来实现的。其中一个保存操作数的栈，另一个是保存运算符的栈。我们从左向右遍历表达式，当遇到数字，我们就直接压入操作数栈；当遇到运算符，就与运算符栈的栈顶元素进行比较。

如果比运算符栈顶元素的优先级高，就将当前运算符压入栈；如果比运算符栈顶元素的优先级低或者相同，从运算符栈中取栈顶运算符，从操作数栈的栈顶取2个操作数，然后进行计算，再把计算完的结果压入操作数栈，继续比较。

将3+5*8-6这个表达式的计算过程画成了一张图，结合图来理解计算过程。

![](/algorithm/Array/resource/stack_expression.jpg)

#### 括号匹配
用栈来保存未匹配的左括号，从左到右依次扫描字符串。当扫描到左括号时，则将其压入栈中；当扫描到右括号时，从栈顶取出一个左括号。如果能够匹配，比如“(”跟“)”匹配，“[”跟“]”匹配，“{”跟“}”匹配，则继续扫描剩下的字符串。如果扫描的过程中，遇到不能配对的右括号，或者栈中没有数据，则说明为非法格式。

当所有的括号都扫描完成之后，如果栈为空，则说明字符串为合法格式；否则，说明有未匹配的左括号，为非法格式。

#### 实现浏览器的前进、后退

使用两个栈，X和Y，我们把首次浏览的页面依次压入栈X，当点击后退按钮时，再依次从栈X中出栈，并将出栈的数据依次放入栈Y。当我们点击前进按钮时，我们依次从栈Y中取出数据，放入栈X中。当栈X中没有数据时，那就说明没有页面可以继续后退浏览了。当栈Y中没有数据，那就说明没有页面可以点击前进按钮浏览了。

## 四、队列
作为一种非常基础的数据结构，队列的应用也非常广泛，特别是一些具有某些额外特性的队列，比如循环队列、阻塞队列、并发队列。它们在很多偏底层系统、框架、中间件的开发中，起着关键性的作用。比如高性能队列Disruptor、Linux环形缓存，都用到了循环并发队列；Java concurrent并发包利用ArrayBlockingQueue来实现公平锁等。
#### 顺序队列
用数组实现的队列叫作顺序队列，使用**head**和**tail**分别指向队列首和尾，入队时**head+1**，出队时**tail+1**；不难发现，随着出队、入队操作，**head**和**tail**不断地往后移，当**tail**移动到最右边，即使数组中还有空闲空间，也无法继续往队列中添加数据了。这个问题该如何解决呢？**数据迁移**。当**tail**移动到最右边时，将**head**和**tail**之间的数据往前移动，腾出入队的空间。
#### 链式队列
用链表实现的队列叫作链式队列
![](/algorithm/Array/resource/linked_list_1.jpg)
#### 循环队列
将队列的首尾相连就是循环队列，实现循环队列，最关键的是，**确定好队空和队满的判定条件**。
队列为空的判断条件仍然是

    head == tail
队满的判断条件是

    (tail+1)%n == head
![](/algorithm/Array/resource/circular_queue_1.jpg)
#### 阻塞队列和并发队列
**阻塞队列**其实就是在队列基础上增加了阻塞操作。简单来说，就是在队列为空的时候，从队头取数据会被阻塞。因为此时还没有数据可取，直到队列中有了数据才能返回；如果队列已经满了，那么插入数据的操作就会被阻塞，直到队列中有空闲位置后再插入数据，然后再返回。我们可以使用阻塞队列，轻松实现一个“生产者-消费者模型”。

线程安全的队列我们叫作**并发队列**。最简单直接的实现方式是直接在enqueue()、dequeue()方法上加锁，但是锁粒度大并发度会比较低，同一时刻仅允许一个存或者取操作。实际上，基于数组的循环队列，利用CAS原子操作，可以实现非常高效的并发队列。

对于大部分资源有限的场景，当没有空闲资源时，基本上都可以通过“队列”这种数据结构来实现请求排队。