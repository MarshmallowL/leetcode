### 题解1
1. 首先统计数组中每个数的度，存储到map中
2. 遍历map,得到最大的度
3. 遍历数组，如果数字对应的度是最大的，则记录下数字在
   数组中的位置，`Map<Integer,List<Integer>>`
4. 遍历第3步得到的map，计算符合要求的数组的长度