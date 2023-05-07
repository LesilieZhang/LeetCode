import java.util.HashSet;
import java.util.Set;

/**
 * @Auther: zhangyian
 * @Date: 2023/4/3 21:23
 * @Description:
 */
public class TEST1 {

    public static void main(String[] args) {

        int nums1[] =  {1,2,3,1};
        int nums2[] =  {1,2,3};
        TEST1 test1 = new TEST1();
        int a[]= test1.intersection(nums1,nums2);
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }

    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> resRet = new HashSet<>();

        //遍历第一个数组
        for (int i : nums1) {
            set1.add(i);
        }
        //遍历第二个数组判断哈希表中是否存在该元素
        for (int i : nums2) {
            if (set1.contains(i)) {
                resRet.add(i);
            }
        }
        //结果集合转为数组
        return resRet.stream().mapToInt(x->x).toArray();
    }
}
