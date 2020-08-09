package temp;

/**
 * @author hsc
 * @date 2020-04-01 23:25:47
 */
public class Father {
        int a=100;
        public void miner(){ 
            a--;
        }
        public static void main(String[] args){
            Son y = new Son();  
            System.out.println(y.a);  
            System.out.println( y.getA());  
            y.miner(); 
            System.out.println(y.a);
            System.out.println(y.getA());
        }
    }
    class Son extends Father{  
        int a = 0;
        public void plus(){    
            a++;  
        }
        public int getA() {  
            return super.a;  
        }
}
