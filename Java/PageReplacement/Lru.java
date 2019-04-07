import java.io.*;

public class Lru {
    public static int sort(int c[]) {
       int max= -1;
       int temp=-1;
       for(int k=0;k<3;k++){
           if(c[k]>max){
               max=c[k];
               temp=k;
           }
       }
       return temp;
    }

    public static void main(String[] args) throws IOException {
        int z,m=0,hit=0,fault=0;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("enter the size of the array");
        int n=Integer.parseInt(br.readLine());
        int a[]=new int[n];
        int flag[]=new int[n];
        System.out.println("enter the elements :");
        for(int i=0;i<n;i++) {
            a[i]=Integer.parseInt(br.readLine());
            flag[i]=0;
        }
        int b[]=new int[3];
        int c[]=new int[3];
        for(int i=0;i<3;i++){
            b[i]=-1;
            c[i]=0;
        }
        for(int i=0;i<n;i++){
            z=a[i];
            for(int j=0;j<3;j++){
                if(z==b[j]){
                    flag[i]=1;
                    hit=hit+1;
                    break;
                }
            } 
            if(flag[i]==0 && b[2]==-1){
                for(int j=0;j<3;j++){
                    if(b[j]==-1){
                        b[j]=z;
                        fault=fault+1;
                        flag[i]=1;
                        break;
                    }
                }
            }
            if(flag[i]==0){
                m=sort(c);
                b[m]=z;
                fault=fault+1;
                flag[i]=1;
                for(int k=0;k<3;k++)
                    c[k]=c[k]+1;
                c[m]=0;
            }
        }
        System.out.println(" no of hits : "+hit);
        System.out.println(" no of faults : "+fault);
        System.out.println(" hit ratio : "+(hit*100)/(hit+fault));
    }
}
