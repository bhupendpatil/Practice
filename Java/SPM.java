// Generate SPM

class SPM1{
  SPM1(){}

  void PrintProduction(String Prod[]){
    System.out.println();
    for(int i=0;i<4;i++){
      System.out.println("\t"+Prod[i]);
    }
    System.out.println("\n");
  }

  void printSubProd(String Prod[]){
    System.out.println();
    for(int i=0;i<5;i++){
      System.out.println("\t"+Prod[i]);			
    }
    System.out.println("\n");
  }

  void displayMatrix(int Matrix[][],String strString){
    System.out.print("\t");
    for(int i=0;i<7;i++)
      System.out.print("   "+strString.charAt(i));

    for(int i=0;i<7;i++){
      System.out.println();
      System.out.print("        "+strString.charAt(i)+"  ");
      for(int j=0;j<7;j++){
        System.out.print(Matrix[i][j]+"   ");
      }
    }
  }
}

class SPM{
  public static void main(String args[]){
    int i,j,k,l=0;

    SPM1 s = new SPM1(); 
    String Prod[]=new String[4];
    Prod[0]="Z->bMb";
    Prod[1]="M->(L";
    Prod[2]="M->a";
    Prod[3]="L->Ma)";

    String NT[]={"Z","M","L"};
    String T[]={"a","b","(",")"}; 
    String first[]=new String[4];
    String last[]=new String[4];
    String equal[]=new String[5];

    int first_matrix[][]=new int[7][7];
    int last_matrix[][]=new int[7][7];
    int equal_matrix[][]=new int[7][7];
    String SPM[][]=new String[7][7] ;

    int A[][]=new int[7][7];
		int B[][]=new int[7][7];
		int C[][]=new int[7][7];
		int D[][]=new int[7][7];
		int E[][]=new int[7][7];
		int I[][]=new int[7][7];
		int TlastPlus_matrix[][]=new int[7][7];
    int lessthan_matrix[][]=new int[7][7];  
    int greterthan_matrix[][]=new int[7][7];          			
    String strString="ZbMLa()";

    //Displaying of productins.
    System.out.println("\n"+"\t"+"Practical No:04"+"\t");
    System.out.println("\n");
    System.out.println("\t"+"Simple Precedence Matrix"+"\t");
    System.out.println("\n Productions are::");
    s.PrintProduction(Prod);
    
    //Finding Elements of First
    for(i=0;i<4;i++){
      first[i]=Prod[i].charAt(0)+""+Prod[i].charAt(3);
    }

    //Displaying of First elements
    System.out.println("First Elements ::");
    s.PrintProduction(first);
    System.out.println("First Matrix ::");
    for(i=0;i<7;i++){
      for(j=0;j<7;j++){
        first_matrix[i][j]=0;
      }
    }
    for(i=0;i<7;i++){
      for(j=0;j<7;j++){
        for(k=0;k<4;k++){
          if(strString.charAt(i)==first[k].charAt(0)&&strString.charAt(j)==first[k].charAt(1)){
            first_matrix[i][j]=1;
          }
        }
      }
    }
    s.displayMatrix(first_matrix,strString);
   
    //Appliying warshall algorithm.
    //Displaying Transitive Closure of first 
    System.out.println("\n\n"+"first+ matrix is:");
    System.out.println();
    for(i=0;i<7;i++){
      for(j=0;j<7;j++){
        A[i][j]=first_matrix[i][j];
      }
    }
    for(i=1;i<7;i++){
      for(j=0;j<7;j++){
        if(A[j][i]==1){
          for(k=1;k<7;k++){
            A[j][k]=A[j][k]|A[i][k];
          }
        }
      }
    }
    s.displayMatrix(A,strString);

    //Displaying first * matrix
    for(i=0;i<7;i++){
      for(j=0;j<7;j++){
        if(i==j)
          I[i][j]=1;
        else
          I[i][j]=0;
      }
    }

    System.out.println("\n\n"+"first*_matrix is;");
    System.out.println();
    for(i=0;i<7;i++){
      for(j=0;j<7;j++){
        C[i][j]=A[i][j]|I[i][j];
      }
    }
    s.displayMatrix(C,strString);

    //Displaying first * matrix
    for(i=0;i<7;i++){
      for(j=0;j<7;j++){
        if(i==j)
          I[i][j]=1;
        else
          I[i][j]=0;
      }
    }
    System.out.println("\n\n"+"first*_matrix is;");
    System.out.println();
    for(i=0;i<7;i++){
      for(j=0;j<7;j++){
        C[i][j]=A[i][j]|I[i][j];
      }
    }
    s.displayMatrix(C,strString);	

    //Finding the elements of Last
    for(i=0;i<Prod.length;i++){
      last[i]=Prod[i].charAt(0)+""+Prod[i].charAt(Prod[i].length()-1);			
    }

    //Displaying of Last elements
    System.out.println();
    System.out.println("\nLast Elements ::");
    s.PrintProduction(last);
    System.out.println("Last Matrix ::");
    for(i=0;i<7;i++){
      for(j=0;j<7;j++){
        last_matrix[i][j]=0;
      }
    }
    for(i=0;i<7;i++){
      for(j=0;j<7;j++){
        for(k=0;k<4;k++){
          if(strString.charAt(i)==last[k].charAt(0)&& strString.charAt(j)==last[k].charAt(1)){
            last_matrix[i][j]=1;
          }
        }
      }
    }
    s.displayMatrix(last_matrix,strString);	

    //Appliying warshall algorithm.
    //Displaying of Transitive Closure last
    System.out.println("\n"+"last+ matrix is:");
    System.out.println();
    for(i=0;i<7;i++){
      for(j=0;j<7;j++){
        B[i][j]=last_matrix[i][j];
      }
    }
    for(i=1;i<7;i++){
      for(j=0;j<7;j++){
        if(B[j][i]==1){
          for(k=1;k<7;k++){
            B[j][k]=B[j][k]|B[i][k];
          }
        }
      }
    }
    s.displayMatrix(B,strString);

    System.out.println("\n"+"last*_matrix is;");
    System.out.println();

    for(i=0;i<7;i++){
      for(j=0;j<7;j++){
        E[i][j]=B[i][j]|I[i][j];
      }
    }
    s.displayMatrix(E,strString);

    //Finding the elements of equal
    int pos=Prod[0].indexOf(">");
    for(i=0;i<Prod.length;i++){
      String str=Prod[i].substring(pos+1);
      if(str.length()>=2){
        for(j=0;j<str.length()-1;j++){
          equal[l]=str.charAt(j)+""+str.charAt(j+1);
          System.out.print(""+equal[l]);
          l++;
        }
      }
    }

    //Displaying of equal elements
    System.out.println();
    System.out.println("\nequal Elements ::");
    s.printSubProd(equal);
    System.out.println("equal Matrix ::");                
    for(i=0;i<equal_matrix.length;i++){
      for(j=0;j<equal_matrix.length;j++){
        equal_matrix[i][j]=0;
      }
    }
    for(i=0;i<7;i++){
      for(j=0;j<7;j++){
        for(k=0;k<5;k++){
          if(strString.charAt(i)==equal[k].charAt(0)&&strString.charAt(j)==equal[k].charAt(1)){
            equal_matrix[i][j]=1;
          }
        }
      }
    }
    s.displayMatrix(equal_matrix,strString);

    //Displaying less than matrix
    System.out.println("\n"+"less_than matrix is;");
    System.out.println();
    for(i=0;i<7;i++){
      for(j=0;j<7;j++){
        lessthan_matrix[i][j] = equal_matrix[i][0]*A[0][j]+
                                equal_matrix[i][1]*A[1][j]+
                                equal_matrix[i][2]*A[2][j]+
                                equal_matrix[i][3]*A[3][j]+
                                equal_matrix[i][4]*A[4][j]+
                                equal_matrix[i][5]*A[5][j]+
                                equal_matrix[i][6]*A[6][j];
      }
    }
    s.displayMatrix( lessthan_matrix,strString);

    //Displaying transpose of lastplus
    //System.out.println("\n"+"transpose of last+ is;");
    //System.out.println();
    for(i=0;i<7;i++){
      for(j=0;j<7;j++){
        TlastPlus_matrix[i][j]=B[j][i];
      }
    }

    //s.displayMatrix( TlastPlus_matrix,strString);

    //Displaying less than matrix
    System.out.println("\n"+"greter_than matrix is;");
    System.out.println();
    for(i=0;i<7;i++){
      for(j=0;j<7;j++){
        D[i][j]=TlastPlus_matrix[i][0]*equal_matrix[0][j]+
                TlastPlus_matrix[i][1]*equal_matrix[1][j]+
                TlastPlus_matrix[i][2]*equal_matrix[2][j]+
                TlastPlus_matrix[i][3]*equal_matrix[3][j]+
                TlastPlus_matrix[i][4]*equal_matrix[4][j]+
                TlastPlus_matrix[i][5]*equal_matrix[5][j]+
                TlastPlus_matrix[i][6]*equal_matrix[6][j];
      }
    }

    for(i=0;i<7;i++){
      for(j=0;j<7;j++){
        greterthan_matrix[i][j] = D[i][0]*C[0][j]+
                                  D[i][1]*C[1][j]+
                                  D[i][2]*C[2][j]+
                                  D[i][3]*C[3][j]+
                                  D[i][4]*C[4][j]+
                                  D[i][5]*C[5][j]+
                                  D[i][6]*C[6][j];
      }
    }
    s.displayMatrix(greterthan_matrix,strString);

    //Displaying SPM matrix
    System.out.println("\n"+"SPM matrix is;");
    System.out.println();
    System.out.print("\t");
    for(i=0;i<7;i++)
      System.out.print("   "+strString.charAt(i));

    for(i=0;i<7;i++){
      System.out.println();
      System.out.print("        "+strString.charAt(i)+"  ");
      for(j=0;j<7;j++){
        if(equal_matrix[i][j]==1)
          SPM[i][j]="=";
        else if(lessthan_matrix[i][j]==1)
          SPM[i][j]="<";
        else if(greterthan_matrix[i][j]==1)
          SPM[i][j]=">";
        else 
          SPM[i][j]="0";
        System.out.print(SPM[i][j]+"   ");
      }
    }
    //s.displayMatrix(SPM,strString);
  }
}