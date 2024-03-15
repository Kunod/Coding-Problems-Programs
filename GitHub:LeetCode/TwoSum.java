import java.util.*;
import java.util.Arrays;
class TwoSum
{
    public int[] twoSum(int[] nums, int target) 
    {
        int check = 0;
        int holder = nums[0];
        int[] numsChecker = nums;
        
        for(int i = 1; check < nums.length;) 
        {
            if (nums[0] + (nums[nums.length-i]) == target) {
                 nums = new int[] {check, numsChecker.length-i};
                 return nums;
            }
            else {
                i++;
            }
            if (i == nums.length) {
                check++;
                nums[0] = nums[check];
                nums[check] = holder;
                i = 1;
            }
            
            
        }
        return nums;
    }

}