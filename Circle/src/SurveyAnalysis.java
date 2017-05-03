import java.util.*;
class SurveyAnalysis
{
    public static void main(String args[] ) throws Exception
    {
        Scanner sc=new Scanner(System.in);
        int array[]=new int[7];
        double mean=0;
        for(int i=0;i<7;i++)
        {
            String str=sc.nextLine();
            int one=0;
            for(int j=0;j<str.length();j++)
            {
                if(str.charAt(j)=='1')
                    one++;
            }
            array[i]=one;
            mean+=one;
        }
        mean/=7;
        double sum=0;
        for(int i=0;i<7;i++)
            sum+=((array[i]-mean)*(array[i]-mean));
        sum/=7;
        double sd=Math.sqrt(sum);
        sd*=10000;
        sd=Math.round(sd);
        sd/=10000;
        String str=Double.toString(sd);
        System.out.print(str);
        int z=str.length()-str.indexOf('.')-1;
        for(int i=z;i<4;i++)
            System.out.print("0");
    }
}
