package com.cruise.thinking.in.leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 零矩阵
 * <p>编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。</p>
 * 示例 1：<br>
 * 输入：<br>
 * [
 *   [1,1,1],<br>
 *   [1,0,1],<br>
 *   [1,1,1]
 * ]<br>
 * 输出：<br>
 * [
 *   [1,0,1],<br>
 *   [0,0,0],<br>
 *   [1,0,1]
 * ]
 *
 * @author Cruise
 * @since 2020/6/25
 */
public class ZeroMatrix {

    public static void main(String[] args) {
        //int[][] matrix = {{ 1,1,1},{1,0,1},{1,1,1}};
        int[][] matrix = {{ 0,1,2,0},{3,4,5,2},{1,3,1,5}};
        System.out.println("设置前：");
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
        setZeroes(matrix);
    }

    public static void setZeroes(int[][] matrix) {
        // 找出存在0元素的行号和列号
        Set<Integer> rowNums = new HashSet<>(matrix.length);
        Set<Integer> columnNums = new HashSet<>(matrix.length);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0) {
                    continue;
                }
                rowNums.add(i);
                columnNums.add(j);
            }
        }
        // 设置 0 ，只需判断一个即可
        if (rowNums.size() > 0) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (rowNums.contains(i) || columnNums.contains(j)) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
        // 输出
        System.out.println("设置后：");
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
