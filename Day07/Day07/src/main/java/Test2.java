import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: zhangyian
 * @Date: 2023/4/5 23:07
 * @Description:给定一个整数数组 nums 和一个目标值 target，
 * 请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * [3,2,4]
 * [3,2,3]
 * [3,3]
 * 当他们target为6的时候
 */
public class Test2 {

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        int nums[] = {3,2,4};
        int[] n = test2.twoSum(nums, 6);
        for (int i : n) {
            System.out.println(i);
        }

    }

    public int[] twoSum(int nums[], int target) {
        Map<Integer, List<Integer>> map = new HashMap();//用来存放遍历过的数，key存储数值，value是下标
        int arr[] = new int[2];
        if (nums == null || nums.length == 0) {
            return arr;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int needNum = target - num;

            if (map.containsKey(needNum)) {
                List<Integer> indexList = map.get(needNum);
                if (needNum == num && indexList.size() == 1) {//【3,2，4】,target=6,如果需要的3，和本身相同，需要判断size是否只有1，只有1说明是自己本身，不算
                    continue;
                }
                //当前输入的是3,2,3
                for (int j = 0; j < indexList.size(); i++) {
                    int index = indexList.get(j);//[3,2,3] 3的indexlist（0,2）
                    if(index!=i) {
                        arr[0] = index;
                        arr[1] = i;
                        break;
                    }
                }
            }
        }
        return arr;
    }
}
