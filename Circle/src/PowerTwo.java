
import java.io.*;
class PowerTwo 
{
    public static void main(String args[] ) throws Exception 
    {
       
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t > 0)
        {
            
           
                int num = Integer.parseInt(br.readLine());
                int[] arr = new int[num];
                String arrLen = br.readLine();
                String[] arrStr = arrLen.split(" ");
                boolean flag = false;
                int max = Integer.MIN_VALUE;
                for(int j = 0; j < num; j++) 
                {
                    arr[j] = Integer.parseInt(arrStr[j]);
                    if(max < arr[j])
                    {
                        max = arr[j];
                    }
                }
    
                int len = (int) (java.lang.Math.log10(max) / java.lang.Math.log10(2));
    
                for (int k = 0; k <= len; k++) 
                {
                    int mask = 1 << k, mul = -1;
                    for (int j = 0; j < num; j++) 
                    {
                        if ((arr[j] & mask) != 0)
                        {
                            if (mul == -1)
                                mul = arr[j];
                            else
                                mul &= arr[j];
                        }
                    }
                    if (mul == -1)
                        continue;
                    else if (mul == mask) 
                    {
                        flag = true;
                        break;
                    }
                }
                
                if(flag) 
                {
                    System.out.println("YES");
                } 
                else 
                {
                    System.out.println("NO");
                }
           
            t--;
        }
    }
    
}
