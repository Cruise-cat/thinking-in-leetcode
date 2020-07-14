package com.cruise.thinking.in.leetcode.array;


/**
 * 寻找数组的中间索引
 * <p>
 * 给定一个整数类型的数组 nums，请编写一个能够返回数组 “中心索引” 的方法。<br>
 * 我们是这样定义数组 中心索引 的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。<br>
 * 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
 * </p>
 * @author Cruise
 * @since 2020/6/25
 */
public class FindArrayCenterIndex {

    public static void main(String[] args) {
        //int index = pivotIndex(1,7,3,6,5,6);
        //int index = pivotIndex(-6, 9, -1, 6, -8, 0, 2, -2, 2, -5);
        int index = pivotIndex(-1,-1,-1,0,1,1);
        System.out.println(index);
    }

    /**
     * 寻找给定数组 nums 的中间索引
     * @param nums 长度范围为 [0, 10000]，任何一个 nums[i] 是一个范围在 [-1000, 1000]的整数
     * @return
     */
    public static int pivotIndex(int...nums) {
        int sumLeft = 0;
        int sumRight = 0;
        // 计算整个数组的元素和
        for(int i = 0; i < nums.length; i++){
            sumRight += nums[i];
        }
        int index = -1;
        for(int i = 0; i < nums.length; i++){
            if (i > 0) {
                sumLeft += nums[i-1];
            }
            sumRight -= nums[i];
            if (sumLeft == sumRight){
                index = i;
                break;
            }
        }
        return index;
    }
}
