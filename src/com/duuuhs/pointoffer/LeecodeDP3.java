package com.duuuhs.leecode;

/**
 *  <动态规划>
 *  一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *  机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *  现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *  网格中的障碍物和空位置分别用 1 和 0 来表示。
 *  说明：m 和 n 的值均不超过 100。
 *  示例 1:
 *  输入:
 *  [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 *  ]
 *  输出: 2
 *  解释:
 *  3x3 网格的正中间有一个障碍物。
 *  从左上角到右下角一共有 2 条不同的路径：
 *  1. 向右 -> 向右 -> 向下 -> 向下
 *  2. 向下 -> 向下 -> 向右 -> 向右
 *
 *  来源：力扣（LeetCode）
 *  链接：https://leetcode-cn.com/problems/unique-paths-ii
 */
public class LeecodeDP3 {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        /**
         * 如果第一个格点 obstacleGrid[0,0] 是 1，说明有障碍物，那么机器人不能做任何移动，我们返回结果 0。
         * 否则，如果 obstacleGrid[0,0] 是 0，我们初始化这个值为 1 然后继续算法。
         * 遍历第一行，如果有一个格点初始值为 1 ，说明当前节点有障碍物，没有路径可以通过，设值为 0 ；否则设这个值是前一个节点的值 obstacleGrid[i,j] = obstacleGrid[i,j-1]。
         * 遍历第一列，如果有一个格点初始值为 1 ，说明当前节点有障碍物，没有路径可以通过，设值为 0 ；否则设这个值是前一个节点的值 obstacleGrid[i,j] = obstacleGrid[i-1,j]。
         * 现在，从 obstacleGrid[1,1] 开始遍历整个数组，如果某个格点初始不包含任何障碍物，就把值赋为上方和左侧两个格点方案数之和 obstacleGrid[i,j] = obstacleGrid[i-1,j] + obstacleGrid[i,j-1]。
         * 如果这个点有障碍物，设值为 0 ，这可以保证不会对后面的路径产生贡献。
         *
         */
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0][0] == 1){
            return 0;
        }
        int row = obstacleGrid.length;
        int column = obstacleGrid[0].length;
        //处理之后,路障为0,非0为非路障
        obstacleGrid[0][0] = 1;
        //处理第一行的点
        for (int i = 1; i < row; i++){
            //当某一点为0(即非路障)且前一点为1(前一点非路障)
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i-1][0] == 1)? 1 : 0;
        }
        //处理第一列的点
        for (int j = 1; j < column; j++){
            obstacleGrid[0][j] = (obstacleGrid[0][j] == 0 && obstacleGrid[0][j-1] == 1)? 1 : 0;
        }
        //处理其他点
        for (int i = 1; i < row; i ++){
            for (int j = 1; j < column; j++){
                //非路障
                if (obstacleGrid[i][j] == 0){
                    //杨辉三角形
                    obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
                } else {
                //路障
                    obstacleGrid[i][j] = 0;
                }
            }
        }
        return obstacleGrid[row-1][column-1];
    }




    public static void main(String[] args) {
        int arr[][] = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(uniquePathsWithObstacles(arr));
    }
}
