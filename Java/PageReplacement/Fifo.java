import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fifo 
{
    public static void main(String[] args)throws IOException 
    {
         int n=0;
       int fifo[]=new int[5];
      
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       System.out.println("enter no of inputs : ");
       n=Integer.parseInt(br.readLine());
       int inp[]=new int[5];
       System.out.println("enter the inputs : ");
       for(int i=0;i<5;i++)
           inp[i]=Integer.parseInt(br.readLine());
       for(int i=0;i<5;i++)
       fifo[i]= -1;
       int hit=0;
       int fault=0;
       int j=0;
       boolean check;
       for(int i=0;i<5;i++)
       {
           check=false;
           for(int k=0;k<5;k++)
               if(fifo[k]==inp[i])
               {
                   check=true;
                   hit=hit+1;
               }
           if(check==false)
           {
               fifo[j]=inp[i];
               j++;
               if(j>=4)
                   j=0;
               fault=fault+1;
           }
       }
       System.out.println("hits are : "+hit+ "faults are :"+fault);
    }
}
