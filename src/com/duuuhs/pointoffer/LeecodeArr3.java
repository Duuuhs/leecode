import java.util.Arrays;

/**
 *  <数组>
 *  给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *  例如，给定数组 nums = [-1，2，1，-4], 和 target = 1. 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 *
 *  来源：力扣（LeetCode）
 *  链接：https://leetcode-cn.com/problems/3sum-closest
 */
public class LeecodeArr3 {

    public static int threeSumClosest(int[] arr, int target){
        if (null == arr || arr.length == 0 ){
            return (Integer)null;
        }
        Arrays.sort(arr);
        int ans = arr[0] + arr[1] + arr[2];
        for (int i = 0; i < arr.length; i++){
            int left = i + 1;
            int right = arr.length - 1;
            while (left < right && left < arr.length && right < arr.length){
                int sum = arr[i] + arr[left] + arr[right];
                //比较绝对值
                if (Math.abs(sum - target) <= Math.abs(ans - target)){
                    ans = sum;
                }
                //比较和与目标值
                if (sum > target){
                    right --;
                } else if (sum < target){
                    left ++;
                } else {
                    return ans;
                }
            }
        }
 
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {-1, 2, 1, -4};
        int target = 1;
        System.out.println(threeSumClosest(arr, target));
    }
}
