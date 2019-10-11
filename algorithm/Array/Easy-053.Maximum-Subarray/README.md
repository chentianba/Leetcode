# 目标
求数组连续子数组的最大和，返回最大和

# 方法
使用动态规划（DP）
```
F(i) = max{F(i-1) + A[i], A[i]}
res = max{res, F(i)}
```