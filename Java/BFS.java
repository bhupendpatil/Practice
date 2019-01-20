import java.io.*;

class BFS{
	public static void main(String args[]) throws IOException{
		int i,n,j,k;
		System.out.println("How many nodes do you want ?:");
		BufferedReader br= new BufferedReader (new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine()); int q[] = new int[10];
		int m[] = new int[10];
		int a[][] = new int[10][10]; 

		for (i=0; i<10; i++){
			m[i] = 0;
		}

		System.out.println("\n\nEnter 1 if edge is present between nodes else 0 if not");

		for (i=0; i<n; i++){
			System.out.println("\n");
			for (j=i; j<n; j++){
				System.out.println("Edge between node "+ (i+1) + " and node" + (j+1)+ ":" );
				a[i][j]=Integer.parseInt(br.readLine());
				a[j][i]=a[i][j];
			}
			a[i][i]=0;
		}
		System.out.println("\nOrder of accessed nodes according to Breadth First: \n");
		q[0] = 0; m[0] = 1;
		int u;
		int node=1;
		int start1=1, start=0;
		while(node>0){
			u=q[start];
			start++;
			System.out.println(" " +(u+1));
			node--;

			for(j=0;j<n;j++){
				if(a[u][j]==1){
					if(m[j]==0){
						m[j]=1;
						q[start1]=j;
						node++;
						start1++;
					}
				}
			}
		}
	}
}