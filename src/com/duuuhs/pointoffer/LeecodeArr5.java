/**
 *  <数组>
 *  假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 你可以假设数组中不存在重复的元素。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 示例 1:
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 */
public class LeecodeArr5 {


    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int middle = (left + right)/2;
            //匹配的情况
            if (nums[middle] == target){
                return middle;
            }
            //非匹配,其中前半部分有序
            if (nums[middle] >= nums[left]){
                //以有序的部分作为判断条件
                if (target >= nums[left] && target < nums[middle]){
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            //非匹配,其中后半部分有序
            } else {
                //以有序的部分作为判断条件
                if (target > nums[middle] && target <= nums[right]){
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
        }
        return  -1;

    }


    public static void main(String[] args) {
        int nums[] = {4,5,6,7,0,1,2};
        int target = 4;
        System.out.println(search(nums, target));
    }
}
