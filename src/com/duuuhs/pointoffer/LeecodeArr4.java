import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  <数组>
 *  给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *  注意：答案中不可以包含重复的四元组。
 *  示例：
 *  给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *  满足要求的四元组集合为：
 *  [
 *    [-1,  0, 0, 1],
 *    [-2, -1, 1, 2],
 *    [-2,  0, 0, 2]
 *   ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 */
public class LeecodeArr4 {

    public static List<List<Integer>> fourSum(int[] nums, int target){
        List<List<Integer>> list = new ArrayList<>();
        if (null == nums || nums.length < 4){
            return list;
        }
        Arrays.sort(nums);
        //固定第一个值
        for (int i = 0; i < nums.length-2; i++){
            //四个数之和大于target,则后边的数值均不需要再比较了,结束循环
            if (i < nums.length-3 && nums[i] + nums[i+1] +nums[i+2] + nums[i+3] > target){
                break;
            }
            //去重,跳出本次循环
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            //固定第二个值
            for (int j = i+1; j < nums.length-1; j++){
                //四个数之和大于target,则后边的数值均不需要再比较了,结束循环
                if (j < nums.length-2 && nums[i] + nums[j] +nums[j+1] + nums[j+2] > target){
                    break;
                }
                //去重,跳出本次循环
                if (j > i+1  && nums[j] == nums[j-1]){
                    continue;
                }
                int left = j+1;
                int right = nums.length-1;
                while (left < right){
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target){
                        list.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        //左右分别去重剔除掉与当前数相同的重复left与重复right情况
                        //左去重 
                        while (left < right && nums[left] == nums[left+1]){
                            left++;
                        }
                        //右去重
                        while (right < right && nums[right] == nums[right-1]){
                            right--;
                        }
                        left++;
                        right--;
                    } else if (sum < target){
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
//        int nums[] = {1, 0, -1, 0, -2, 2};
        int nums[] = {0, 0, 0, 0};
        int target = 0;
        System.out.println(fourSum(nums, target));
    }
}
