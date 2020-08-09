package chunzhaoTest;

import arithmetic.sort.test.RadisSort;

/**
 * @author hsc
 * @date 2020-03-26 19:21:29
 */
public class test2 {

    /**
     *
     * @param n  圆的个数
     * @param raidses  圆的半径
     * @return
     */
    public static double Area(int n,int[] raidses){
        double area=0;
        for (int i=raidses.length-1;i>=1;i-=1){
            area+=raidses[i]*raidses[i]*Math.PI-raidses[i-1]*raidses[i-1]*Math.PI;
        }
        return area;
    }

    public static void main(String[] args) {
        int []arr={1,2,3,4,5};
        System.out.println(Area(5, arr));
        System.out.println(Math.PI * arr[4] * arr[4]);
        System.out.println(Math.PI * arr[2] * arr[2]);
        System.out.println(Math.PI * arr[0] * arr[0]);
        System.out.println(Math.PI * arr[4] * arr[4]+
                Math.PI * arr[2] * arr[2]+
                Math.PI * arr[0] * arr[0]);

    }
}
