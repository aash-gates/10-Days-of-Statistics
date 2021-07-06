import java.util.Scanner;

public class BinomialDistributionI {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        double r = kb.nextDouble();
        double c = kb.nextDouble();
        double b = r/(r+c);
        int x = 6;
        double prob = 0;
        for(int i=3;i<=x;i++)
            prob+=Math.pow(b,i)*Math.pow(1-b,x-i)/(f(i)*f(x-i));
        System.out.printf("%.3f",f(x)*prob);
        kb.close();
    }
    public static int f(int n){
        return n==0 ? 1 : n*f(n-1);
    }
}