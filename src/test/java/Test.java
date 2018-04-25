import java.util.*;

/**
 * Discribe:
 * Project:springmvc-datasource
 * Package: PACKAGE_NAME
 * User: Chengwenbo
 * Date:  2016/3/18
 * Time: .16:17
 */
public class Test {
    public static void main(String[] args) {
        int [] arr = {123123,123123,4,213,12323};
        for(int i = 0, len = arr.length; i < len; i++) {
             isHuiwen(arr[i]);
        }
    }
    static List<Integer> array = new ArrayList<>();
    static boolean isHuiwen(int number) {
        array.clear();
        int count = 0;
        while (number != 0) {
            array.add(number % 10);
            count++;
            number /= 10;
        }
        for(int i = 0, s = array.size(), t = s / 2; i < t; i++) {
            if(array.get(i) != array.get(s - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
