package L03_1007;

public class bucket { //1번문제
    int num;
    String s_s;

    public bucket(int num, String s_s){
        //매개변수 생성자
        this.num = num;
        this.s_s = s_s;
    }
    public bucket(){
        //기본생성자
        this(2,"영국 여행가기");
    }
}
