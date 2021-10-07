package L03_1007;

public class avg_make {
    private int sum;
    private int num = 6;

    public void set(int x){
        sum = sum+x;
        System.out.println("sum의 값: "+sum);
    }

    public double get(){
        return sum/num;
    }

}
