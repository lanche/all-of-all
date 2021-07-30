/**
 * @author lanche
 * @Date 2020/11/17
 * @Description
 */
public class Sort {

    public int convert(int num) {
        int[] array = new int[32];
        int index = 0;
        while(num%7 != 0 || num/7 != 0) {
            array[index] = num%7;
            num = num/7;
            index++;
        }
        int res = 0;
        for(int i=0; i<array.length; i++) {
            res += array[i]*Math.pow(10, i);
        }
        return res;

    }


}
