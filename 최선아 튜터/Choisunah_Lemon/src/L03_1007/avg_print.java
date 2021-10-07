package L03_1007;

import java.util.Scanner;

public class avg_print {
    public void print(){
        Scanner scanner = new Scanner(System.in);
        avg_make m = new avg_make();

        for(int i=1; i<=6; i++){
            //입력문
            System.out.println("입력해주세요: ");
            int x = scanner.nextInt();
            m.set(x);
        }
        double avg = m.get();
        System.out.println("평균= "+avg);
    }
}
