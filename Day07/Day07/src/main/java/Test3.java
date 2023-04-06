import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: zhangyian
 * @Date: 2023/4/6 22:47
 * @Description:
 */
public class Test3 {

    public static void main(String[] args) {

    }

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        //先遍历前两个数组，找到a+b,遍历后两个数组找到c+d：key：a+b,value：出现过的次数
        //0-(c+d)=(a+b):符合题目
        int res = 0;
        Map map = new HashMap();
        //统计两个数组中的元素之和，同时统计出现的次数放入map中
        for (int i : nums1) {
            for (int j : nums2) {
                int num = i + j;
                int tmp = (int) map.getOrDefault(num, 0);//如果这个键不存在，就返回指定的默认值0
                if (tmp == 0) {//tmp为0表示不存在
                    map.put(num, 1);//不存在的话放入map里并且记录次数为1
                } else {
                    map.replace(num, tmp + 1);//存在的话增加次数
                }
            }
        }
        //统计另外两个数组的和，在map中寻找是否存在相加为0的情况，同时记录次数
        for (int i : nums3) {
            for (int j : nums4) {
                int num = 0 - (i + j);//num表示需要找的数，我们去map保存的a+b里面找，看看有几个
                int tmp = (int) map.getOrDefault(num, 0);//如果这个键不存在，就返回指定的默认值0
                if (tmp != 0) {//如果存在次数的话
                    res = res + tmp;//叠加
                }
            }
        }
        return res;
    }
}
