// Generation on OPM

import java.io.*;

class opm1 {
  String t[]={"E","T","F","+","*","(",")","a"};
  String pr[]={"E->E+T","E->T","T->T*F","T->F","F->(E)","F->a"};
  String first[][]=new String[9][9];
  String identity[][]=new String[9][9];
  String firststr[][]=new String[9][9];
  String last[][]=new String[9][9];
  String ltranspose[][]=new String[9][9];
  String equal[][]=new String[9][9];
  String Equal[][]=new String[9][9];
  String lessthan[][]=new String[9][9];
  String lessthan1[][]=new String[9][9];
  String greaterthan[][]=new String[9][9];
  String greaterthan1[][]=new String[9][9];
  String opm[][]=new String[9][9];
  String matrix[][]=new String[9][9];
  String matrix1[][]=new String[9][9];
  String matrix2[][]=new String[9][9];
  String firstterm[][]=new String[9][9];
  String lastterm[][]=new String[9][9];

  int i,j,k,flag=0;
  void disp(String matrix[][]){
    System.out.print("  ");
    for(int p=0;p<t.length;p++){
      System.out.print(" "+t[p]+" ");
    }
    System.out.println("\n");
    for(i=1;i<9;i++){
      System.out.print(" "+t[i-1]+" ");
      for(j=1;j<9;j++){
        System.out.print(" "+matrix[i][j]+" ");
      }
      System.out.println("\n");
    }
  }

  void print1(String matrix[][]){
    for(i=0;i<9;i++){
      for(j=0;j<9;j++){
        System.out.print(" "+matrix[i][j]+" ");
      }
      System.out.println("\n");
    }
  }

  void disp1(String matrix[][]){
    for(i=1;i<9;i++){
      matrix[0][i]=t[i-1];
      //System.out.println(matrix[0][i]);
    }
    for(j=1;j<9;j++){
      matrix[j][0]=t[j-1];
      //System.out.println(matrix[j][0]);
    }
  }

  void getfirst(){
    first[0][0]=" ";
    System.out.println("\n Productions :-");
    System.out.println("\n");
    for(i=0;i<6;i++){
      System.out.println(""+pr[i]);
    }
    disp1(first);
    
    for(i=1;i<9;i++){
      for(j=1;j<9;j++){
        flag=0;
        for(k=0;k<pr.length;k++){
          if((first[i][0].charAt(0)==pr[k].charAt(0)) && (first[0][j].charAt(0)==pr[k].charAt(3))){
            flag=1;
            first[i][j]="1";
          }else if(flag!=1){
            first[i][j]="0";
          }
        }
      }
    }
    System.out.println("\n FIRST matrix is:\n");
    print1(first);
  }

  void algo(String first[][]){
    for(i=1;i<9;i++){
      for(j=1;j<9;j++){
        matrix1[i][j]=first[i][j];
      }
    }

    for(i=1;i<9;i++){
      for(j=1;j<9;j++){
        if(matrix1[j][i].equals("1")){
          for(k=1;k<9;k++){
            matrix1[j][k]=""+(Integer.parseInt(matrix1[j][k]) | Integer.parseInt(matrix1[i][k]));
          }
        }
      }
    }
  }

  void getfirstp(){ 
    algo(first);    
    System.out.println(" FIRST+ matrix is:\n");
    disp(matrix1);
  }

  void getstar(String matrix[][]){ 
    algo(matrix);
    for(i=1;i<9;i++){
      for(j=1;j<9;j++){
        if(i==j){
          identity[i][j]="1";
        }else{
          identity[i][j]="0";
        }
      }
    }
    for(i=1;i<9;i++){
      for(j=1;j<9;j++)
        firststr[i][j]=matrix1[i][j]; 
    } 
    for(i=1;i<9;i++){
      for(j=1;j<9;j++){
        matrix2[i][j]=""+(Integer.parseInt(firststr[i][j]) | Integer.parseInt(identity[i][j]));
      }
    }
  }

  void getfirststar(){
    System.out.println("\n"+" FIRST* Matrix is :"+"\n\n");
    getstar(first);
    disp(matrix2);  
  }

  void getlast(){
    disp1(last);
    last[0][0]=" ";
    for(i=1;i<9;i++){
      for(j=1;j<9;j++){
        flag=0;
        for(k=0;k<pr.length;k++){
          if((last[i][0].charAt(0)==pr[k].charAt(0)) && (last[0][j].charAt(0)==pr[k].charAt(pr[k].length()-1))){
            flag=1;
            last[i][j]="1";
          }else if(flag!=1){
            last[i][j]="0";
          }
        }
      }
    }
    System.out.println("\n  LAST matrix is:\n");
    print1(last);
  }

  void getlastplus(){
    System.out.println("\n  LAST+ matrix is:\n");
    algo(last); 
    disp(matrix1);
  }

  void getlaststar(){
    getstar(last);
    System.out.println("\n LAST STAR Matrix:-\n ");
    disp(matrix2);  
  }

  void cal(){
    firstterm[0][0]=" ";
    disp1(firstterm);
    for(i=1;i<9;i++){
      for(j=1;j<9;j++){
        flag=0;
        for(k=0;k<pr.length;k++){
          if(pr[k].length()==4){ 
            if((firstterm[i][0].charAt(0)==pr[k].charAt(0)) && (firstterm[0][j].charAt(0)==pr[k].charAt(3)) && !(pr[k].charAt(3)>='A' && pr[k].charAt(3)<='Z')){ 
              flag=1;
              firstterm[i][j]="1"; 
            }else if(flag!=1){
              firstterm[i][j]="0";
            }
          }else if(pr[k].length()==6){ 
            if((firstterm[i][0].charAt(0)==pr[k].charAt(0)) && (firstterm[0][j].charAt(0)==pr[k].charAt(3)) && !(pr[k].charAt(3)>='A' && pr[k].charAt(3)<='Z')){ 
              flag=1;
              firstterm[i][j]="1"; 
            }else if((firstterm[i][0].charAt(0)==pr[k].charAt(0)) && (firstterm[0][j].charAt(0)==pr[k].charAt(4)) && !(pr[k].charAt(4)>='A' && pr[k].charAt(4)<='Z')){ 
              flag=1;
              firstterm[i][j]="1";
            }else if(flag!=1){
              firstterm[i][j]="0";
            } 
          }      
        }
      }
    }
    System.out.println("\n FIRST TERM Matrix:-\n ");
    print1(firstterm);
    lastterm[0][0]=" ";
    disp1(lastterm);
    for(i=1;i<9;i++){
      for(j=1;j<9;j++){
        flag=0;
        for(k=0;k<pr.length;k++){ 
          if((lastterm[i][0].charAt(0)==pr[k].charAt(0)) && (lastterm[0][j].charAt(0)==pr[k].charAt(pr[k].length()-1)) && !(pr[k].charAt(pr[k].length()-1)>='A' && pr[k].charAt(pr[k].length()-1)<='Z')){ 
           flag=1;
            lastterm[i][j]="1"; 
          }else if((lastterm[i][0].charAt(0)==pr[k].charAt(0)) && (lastterm[0][j].charAt(0)==pr[k].charAt(pr[k].length()-2)) && !(pr[k].charAt(pr[k].length()-2)>='A' && pr[k].charAt(pr[k].length()-2)<='Z')) { 
            flag=1;
            lastterm[i][j]="1"; 
          }else if(flag!=1){
            lastterm[i][j]="0";
          }
        }
      }
    }
    System.out.println("\n LAST TERM Matrix:-\n ");
    print1(lastterm);
      
    equal[0][0]=" ";
    disp1(equal);
    for(i=1;i<9;i++){
      for(j=1;j<9;j++){
        flag=0;
        for(k=0;k<pr.length;k++){
          if(pr[k].length()==6 || pr[k].length()==5){
          if((!(pr[k].charAt(3)>='A' && pr[k].charAt(3)<='Z')) && (!(pr[k].charAt(4)>='A' && pr[k].charAt(4)<='Z'))){ 
            if((equal[i][0].charAt(0)==pr[k].charAt(3)) && (equal[0][j].charAt(0)==pr[k].charAt(4))){                   
              flag=1;
              equal[i][j]="1";
            }        
          }else if((!(pr[k].charAt(3)>='A' && pr[k].charAt(3)<='Z')) && (pr[k].charAt(4)>='A' && pr[k].charAt(4)<='Z') && (!(pr[k].charAt(5)>='A' && pr[k].charAt(5)<='Z'))){
            if((equal[i][0].charAt(0)==pr[k].charAt(3)) && (equal[0][j].charAt(0)==pr[k].charAt(5))){                   
              flag=1;
              equal[i][j]="1";
            }
          }else if(flag!=1){
              equal[i][j]="0";
          }
          }
        }
      }
    }
    System.out.println("\n EQUAL Precedence Matrix:-\n ");
    print1(equal);
    disp1(Equal);
    System.out.println("\n Equal Matrix :\n ");
    for(i=1;i<9;i++){
      for(j=1;j<9;j++){
        flag=0;
        for(k=0;k<pr.length;k++){
          if(pr[k].length()==5){
            if((pr[k].charAt(3)==Equal[i][0].charAt(0))&&(pr[k].charAt(pr[k].length()-1)==Equal[0][j].charAt(0))){
              flag=1;
              Equal[i][j]="1";
            }else if(flag!=1){
            Equal[i][j]="0";
            }
          }
          if(pr[k].length()>5){ 
            if((pr[k].charAt(3)==Equal[i][0].charAt(0))&&(pr[k].charAt(4)==Equal[0][j].charAt(0))){   
              flag=1; Equal[i][j]="1";     
            }
            if((pr[k].charAt(4)==Equal[i][0].charAt(0))&&(pr[k].charAt(pr[k].length()-1)==Equal[0][j].charAt(0))){   
              flag=1;Equal[i][j]="1";  
            }else if(flag!=1){
              Equal[i][j]="0";
            }
          } 
        }
      }
    }
    Equal[0][0]=" ";
    print1(Equal);

    getstar(last);
    for(i=1;i<9;i++){
      for(j=1;j<9;j++){
        greaterthan[i][j]="0";
        for(k=1;k<9.;k++){
          greaterthan[i][j]=""+(Integer.parseInt(greaterthan[i][j]) | (Integer.parseInt(matrix2[i][k]) & Integer.parseInt(lastterm[k][j])));
        }
      }
    }
    for(i=1;i<9;i++){
      for(j=1;j<9;j++){
        ltranspose[i][j]=greaterthan[j][i];
      }
    }
    
    for(i=1;i<9;i++){
      for(j=1;j<9;j++){
        greaterthan1[i][j]="0";
        for(k=1;k<9.;k++){
          greaterthan1[i][j]=""+(Integer.parseInt(greaterthan1[i][j]) | (Integer.parseInt(ltranspose[i][k]) & Integer.parseInt(Equal[k][j])));
        }
      }
    }
    System.out.println("\n Greater than  Precedence Matrix:-\n ");
    disp(greaterthan1); 
    getstar(first);
    for(i=1;i<9;i++){
      for(j=1;j<9;j++){
        lessthan[i][j]="0";
        for(k=1;k<9.;k++){
          lessthan[i][j]=""+(Integer.parseInt(lessthan[i][j]) | (Integer.parseInt(Equal[i][k]) & Integer.parseInt(matrix2[k][j])));
        }
      }
    }
    
    for(i=1;i<9;i++){
      for(j=1;j<9;j++){
        lessthan1[i][j]="0";
        for(k=1;k<9.;k++){
          lessthan1[i][j]=""+(Integer.parseInt(lessthan1[i][j]) |(Integer.parseInt(lessthan[i][k]) & Integer.parseInt(firstterm[k][j])));
        }
      }
    }
    System.out.println("\n Less than Precedence Matrix:-\n ");
    disp(lessthan1);
    
    System.out.println("\n OPM :- \n");
    for(i=1;i<9;i++){
      for(j=1;j<9;j++){ 
        if(equal[i][j].equals("1"))
          opm[i][j]="=";
        else if(lessthan1[i][j].equals("1"))
          opm[i][j]="<";
        else if(greaterthan1[i][j].equals("1"))
          opm[i][j]=">";
        else
          opm[i][j]="0";
      }
    } 
    String op="+*()a";
    System.out.print("  ");
    for(int p=0;p<op.length();p++){
      System.out.print(" "+op.charAt(p)+" ");
    }
    System.out.println("\n");
    for(i=4;i<9;i++){
      System.out.print(" "+op.charAt(i-4)+" ");
      for(j=4;j<9;j++){
        System.out.print(" "+opm[i][j]+" ");
      }
      System.out.println("\n");
    } 
  }   
}

class opm{
  public static void main(String ar[]){
    opm1 o1=new opm1();
    o1.getfirst();
    o1.getfirstp();
    o1.getfirststar();
    o1.getlast();
    o1.getlastplus();
    o1.getlaststar();
    o1.cal();
  }
}