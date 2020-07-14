package com.cruise.thinking.in.leetcode.array;

/**
 * 二维数组对角线遍历示例
 * <p>给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素</p>
 * <p>输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * </p>
 * <p>输出:  [1,2,4,7,5,3,6,8,9]</p>
 *
 * @author Cruise
 * @version 1.0
 * @since 2020/7/2
 */
public class DiagonalOrder {

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        findDiagonalOrder(arr);
    }

    /**
     * 进行对角线遍历，先向右上，然后左下，再右上，以此类推直至遍历完整个数组。
     * 由于移动的方向不再是水平或竖直方向，而是对角线方向，那么每移动一次，横纵坐标都要变化，
     * 向右上移动的话要坐标加上[-1, 1]，向左下移动的话要坐标加上[1, -1]，
     * 那么难点在于我们如何处理越界情况，越界后遍历的方向怎么变换。
     * 向右上和左下两个对角线方向遍历的时候都会有越界的可能，
     * 但是除了左下角和右上角的位置越界需要改变两个坐标之外，
     * 其余的越界只需要改变一个。那么我们就先判断要同时改变两个坐标的越界情况，
     * 即在右上角和左下角的位置。如果在右上角位置还要往右上走时，那么要移动到它下面的位置的，
     * 那么如果col超过了n-1的范围，那么col重置为n-1，并且row自增2，然后改变遍历的方向。
     * 同理如果row超过了m-1的范围，那么row重置为m-1，并且col自增2，然后改变遍历的方向。
     * 然后我们再来判断一般的越界情况，如果row小于0，那么row重置0，然后改变遍历的方向。
     * 同理如果col小于0，那么col重置0，然后改变遍历的方向。
     *
     * <p>原文链接：https://blog.csdn.net/amazingren/article/details/90311946</p>
     *
     * @param matrix
     * @return
     */
    public static int[] findDiagonalOrder(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return new int[0];
        }
        int n = matrix[0].length;
        int length = m * n;
        int[] result = new int[length];
        if (n == 0) {
            return result;
        }
        int x = 0, y = 0, z = 0;
        int[][] drift = {{-1, 1}, {1, -1}};
        for (int i = 0; i < length; i++) {
            result[i] = matrix[x][y];
            x += drift[z][0];
            y += drift[z][1];
            if (x >= m) {
                x = m - 1;
                y += 2;
                z = 1 - z;
            }
            if (y >= n) {
                x += 2;
                y = n - 1;
                z = 1 - z;
            }
            if (x < 0) {
                x = 0;
                z = 1 - z;
            }
            if (y < 0) {
                y = 0;
                z = 1 - z;
            }
        }
        return result;
    }
}
