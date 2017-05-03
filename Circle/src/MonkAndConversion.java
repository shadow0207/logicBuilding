import java.util.Scanner;

public class MonkAndConversion {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for(int i=0;i<t;i++){
			int flag=0;
			int sum1=0,sum2=0;
			int n = s.nextInt();
			for(int j=0;j<n;j++){
				int a =s.nextInt();
				sum1+=a;
			}
			for(int j=0;j<n;j++){
			    int b = s.nextInt();
			    sum2+=b;
			}
			if(sum1==sum2)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}
