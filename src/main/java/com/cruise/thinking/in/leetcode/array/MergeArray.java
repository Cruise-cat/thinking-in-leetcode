package com.cruise.thinking.in.leetcode.array;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 * 示例 1:<br>
 * 输入: [[1,3],[2,6],[8,10],[15,18]]<br>
 * 输出: [[1,6],[8,10],[15,18]]<br>
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].<br>
 * </p>
 * <p>
 * 示例 2:<br>
 * 输入: [[1,4],[4,5]]<br>
 * 输出: [[1,5]]<br>
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * </p>
 *
 * @author Cruise
 * @since 2020/6/25
 */
public class MergeArray {

    public static void main(String[] args) {
        //int[][] intervals = new int[][]{{4,5},{2,4},{4,6},{3,4},{0,0},{1,1},{3,5},{2,2}};
        //int[][] intervals = new int[][]{{1, 4},{4, 5}};
        int[][] intervals = new int[][]{{2, 3}, {4, 6}, {5, 7}, {3, 4}};
        int[][] merge = merge(intervals);
        for (int i = 0; i < merge.length; i++) {
            System.out.println(merge[i][0] + "," + merge[i][1]);
        }
    }

    /**
     * 优化后的合并区间算法
     *
     * @param intervals 给定的区间
     * @return
     */
    public static int[][] merge(int[][] intervals) {
        int length = intervals.length;
        if (length < 2) return intervals;
        // 对每个区间进行排序，通过每个区间的第一个元素升序排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> result = new ArrayList<>(intervals.length);
        result.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];
            int[] last = result.get(result.size() - 1);
            if (current[0] > last[1]) {
                result.add(current);
            } else {
                last[1] = Math.max(current[1], last[1]);
            }
        }
        return result.toArray(new int[0][]);
    }


    /**
     * 这个版本的算法性能较差
     *
     * @param intervals 给定的区间
     * @return
     */
    public static int[][] mergePoorPerformance(int[][] intervals) {
        int length = intervals.length;
        if (length < 2) return intervals;
        List<Integer> handleList = new ArrayList(length);
        List<int[]> collect = Arrays.stream(intervals).sorted(Comparator.comparing(o -> ((int[]) o)[0]).thenComparing(o -> ((int[]) o)[1]))
                .collect(Collectors.toList());
        intervals = collect.toArray(new int[0][]);
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>(length / 2);
        boolean flag = false;
        for (int i = 0; i < length; i++) {
            if (handleList.contains(i)) {
                continue;
            }
            int index0 = intervals[i][0];
            int index1 = intervals[i][1];

            for (int j = i + 1; j < length; j++) {
                int index2 = intervals[j][0];
                int index3 = intervals[j][1];
                if ((index0 <= index2 && index2 <= index1) || (index2 <= index0 && index0 <= index3)) {
                    index0 = Math.min(index0, index2);
                    index1 = Math.max(index1, index3);
                    handleList.add(i);
                    handleList.add(j);
                    flag = true;
                }
            }
            map.put(index0, index1);
        }
        int[][] result = new int[map.size()][2];
        int index = 0;
        for (Integer element : map.keySet()) {
            result[index][0] = element;
            result[index][1] = map.get(element);
            index++;
        }
        if (flag) {
            return merge(result);
        }
        return result;
    }

}

