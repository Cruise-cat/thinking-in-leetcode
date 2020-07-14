package com.cruise.thinking.in.leetcode.array;

/**
 * 探索插入位置
 * <p>给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 可以假设数组中无重复元素。</p>
 * <p>示例 1:<br>
 * 输入: [1,3,5,6], 5<br>
 * 输出: 2<br>
 * <p>
 * 示例 2:<br>
 * 输入: [1,3,5,6], 0<br>
 * 输出: 0
 *
 * @author Cruise
 * @since 2020/6/25
 */
public class FindInsertIndex {

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 2, 3}, 6));
        System.out.println(searchInsert(new int[]{1, 3, 9, 10, 13, 17, 27}, 19));
        System.out.println(searchInsert(new int[]{1, 3, 9, 10, 13, 17}, 15));
    }

    /**
     * 此算法的核心思想是：使用二分查找法
     *
     * @param nums   给定的原始数组
     * @param target 需要插入的目标元素
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        if (target < nums[low]) return low;
        if (target > nums[high]) return high + 1;
        int middle = low + (high - low) / 2;
        while (low <= high) {
            if (target == nums[middle]) {
                return middle;
            } else if (target < nums[middle]) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
            middle = low + (high - low) / 2;
        }
        return middle;
    }
}
