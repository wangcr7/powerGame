package algorithm.pai_xu.xuan_ze_lei;

/**
 * @program: CristianoRonaldo
 * @description:
 * @author: wang chi
 * @create: 2020-06-12 00:39
 */
public class main {

    public static void main(String[] args) {

        /**
         * arr.length = 17
         */
//        int[] arr = new int[]{99999,3,143,2,63,4,32,4,1,78,123,1,2,3,64,63,5};
        long [] arrLong = new long[]{1,2,3,4,5,6};


        arrLong = sort.sort(arrLong);

        for (int k = 0; k < arrLong.length; k++) {
            System.out.print(arrLong[k]+ ",");
        }

    }
}
