import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *  <数组>
 *  给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *  注意：答案中不可以包含重复的三元组。
 *  例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *  满足要求的三元组集合为：
 *  [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 *  ]
 *
 *  来源：力扣（LeetCode）
 *  链接：https://leetcode-cn.com/problems/3sum
 */
public class LeecodeArr2 {

    public static List<List<Integer>> threeSum(int arr[]){
        List<List<Integer>> list = new ArrayList<>();
        if (null == arr || arr.length < 3){
            return Collections.emptyList();
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++){
            int left = i+1;
            int right = arr.length-1;
            //当前数字大于0, 则后边三数之和一定大于0
            if (arr[i] > 0){
                break;
            }
            //去重;不能使用arr[i] == arr[i+1],这样会把arr[i] + arr[i+1] + 其他数 = 0的情况剔除掉
            if (i > 0 && arr[i] == arr[i-1]){
                continue;
            }
            while (left < right && left < arr.length && right < arr.length){
                int sum = arr[i] + arr[left] + arr[right];
                if (sum == 0){
                    list.add(Arrays.asList(arr[i], arr[left], arr[right]));
                    //左右分别去重剔除掉与当前数相同的重复left与重复right情况
                    //左去重
                    while (left < right && arr[left] == arr[left+1]){
                        left ++;
                    }
                    //右去重
                    while (left < right && arr[right] == arr[right -1]){
                        right--;
                    }
                    left ++;
                    right --;
                } else if (sum < 0){
                    left ++;
                } else if (sum > 0){
                    right --;
                }

            }
        }
        return list;
    }

    public static void main(String[] args) {

//        int arr[] = {-1,0,1,2,-1,-4};
        int arr[] = {-2,0,0,2,2};
        List<List<Integer>> lists = threeSum(arr);
        System.out.println(lists);
    }
}
