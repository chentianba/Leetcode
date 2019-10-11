# 目标
删除数组中的重复元素，返回去重后的数组的长度

# 方法
设置两个游标，一个指向目标数组的长度，另一个遍历原数组，  
比较原数组的遍历元素是否重复，如果不重复，则赋值给目标数组

###伪代码
```
count = 0  
for j from 0 to size  
  for i from 0 to count  
    if a[j] equal to a[i]  
      break;  
  assign a[j] to a[count++]  
return count
```
