# 目标  
删除数组里值为val的元素，返回新数组的长度；注意，不关注新数组里元素的顺序。

# 方法  
遍历原数组，判断当前元素是否等于val，如果等于，则将该元素和新数组的最后一个元素交换

# 伪代码
```
count = n - 1
for( i=0; i<= count;)
  if nums[i] equal to val
    nums[i] = nums[count--]
  else
    i++
return count + 1;
```
