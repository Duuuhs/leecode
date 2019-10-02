/**
 *  <数组>
 *  给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 *  找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *  说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 *  来源：力扣（LeetCode）
 *  链接: https://leetcode-cn.com/problems/container-with-most-water/
 */
public class LeecodeArr1 {

    /**
     * 暴力破解法, 时间复杂度O(n^2), 空间复杂度O(1)
     * @param arr
     * @return int
     */
    public static int maxValue1(int arr[]){
        int maxArea = 0;
        for (int i = 0; i < arr.length; i++){
            for (int j = i+1; j < arr.length; j++){
                maxArea = Math.max(maxArea, Math.min(arr[i], arr[j]) * (j-1));
            }
        }
        return maxArea;
    }

    /**
     * 双指针法, 时间复杂度O(n), 空间复杂度O(1)
     * 这种方法背后的思路在于，两线段之间形成的区域总是会受到其中较短那条长度的限制。此外，两线段距离越远，得到的面积就越大。
     * @param arr
     * @return int
     */
    public static int maxValue2(int arr[]){
        int maxArea = 0, left = 0, right = arr.length -1;
        while (left < right && left < arr.length && right < arr.length){
            maxArea = Math.max(maxArea, Math.min(arr[left], arr[right]) * (right - left) );
            if (arr[left] < arr[right]){
                left ++;
            } else {
                right ++;
            }
        }
        return maxArea;
    }

    
    public static void main(String[] args) {
        int arr[] = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxValue1(arr));
        System.out.println(maxValue2(arr));
    }
}
