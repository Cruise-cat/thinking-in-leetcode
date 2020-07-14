package com.cruise.thinking.in.leetcode.array;

import java.util.Arrays;

/**
 * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
 * 不占用额外内存空间能否做到？
 * <p>
 * 示例 1:<br>
 * 给定 matrix = <br>
 * [[1,2,3],<br>
 * &nbsp;[4,5,6],<br>
 * &nbsp;[7,8,9]]<br>
 * 原地旋转输入矩阵，使其变为:<br>
 * [[7,4,1],<br>
 * &nbsp;[8,5,2],<br>
 * &nbsp;[9,6,3]]<br>
 * </p>
 * <p>
 * 示例 2:<br>
 * 给定 matrix =<br>
 * [[ 5, 1, 9,11],<br>
 * &nbsp;[ 2, 4, 8,10],<br>
 * &nbsp;[13, 3, 6, 7],<br>
 * &nbsp;[15,14,12,16]]<br>
 * 原地旋转输入矩阵，使其变为:<br>
 * [[15,13, 2, 5],<br>
 * &nbsp;[14, 3, 4, 1],<br>
 * &nbsp;[12, 6, 8, 9],<br>
 * &nbsp;[16, 7,10,11]]
 * </p>
 *
 * @author Cruise
 * @since 2020/6/21
 */
public class RotationMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{ 5, 1, 9,11},{2, 4, 8,10},{13, 3, 6, 7},{15,14,12,16}};
        System.out.println("转换前：");
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
        rotate(matrix);
    }

    /**
     * [
     * [ 5, 1, 9,11],
     * [ 2, 4, 8,10],
     * [13, 3, 6, 7],
     * [15,14,12,16]
     * ]
     * <p>
     * [
     * [15,13, 2, 5],
     * [14, 3, 4, 1],
     * [12, 6, 8, 9],
     * [16, 7,10,11]
     * ]
     *
     * 找到旋转前后的坐标
     * 00-03 01-13 02-23 03-33
     * 10-02 11-22 12-32 13-32
     * 20-01 21-11 22-21 23-31
     * 30-00 31-10 32-20 33-30
     *
     * @param matrix
     */
    public static void rotate(int[][] matrix) {
        int length = matrix.length;
        int temp;
        for (int i = 0; i < length - 1 ; i++) {
            for (int j = i; j < length - i - 1; j++) {
                temp = matrix[j][length - i - 1];
                matrix[j][length - i - 1] = matrix[i][j];
                matrix[i][j] = matrix[length - j - 1][i];
                matrix[length - j - 1][i] = matrix[length - i - 1][length - j - 1];
                matrix[length - i - 1][length - j - 1] = temp;
            }
        }
        System.out.println("转换后：");
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }
    /**
     * 推导过程：
     * i =0 j = 0
     * temp = 03;
     * 03 = 00;
     * 00 = 30;
     * 30 = 33
     * 33 = temp
     *
     * i =0 j = 1
     * temp = 13
     * 13 = 01
     * 01 = 20
     * 20 = 32
     * 32 =temp
     *
     * i=0 j =2
     * temp = 23
     * 23 = 02
     * 02 = 10
     * 10 = 31
     * 31 = 23
     *
     * i =0 j = 3
     * temp = 33
     * 33 = 03
     * 03 =
     */
}
