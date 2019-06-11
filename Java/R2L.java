// Convert Right Linear Grammar to Left Linear Grammar

public class R2L{
  static String production[][]={{"S"," ","B"}, {"B","b","D"}, {"D","b","B"},{"S","a","B"}, {"B","a"," "}};
  char tmp;
  int i;

  public static void main (String args[]){
    PrintProductions();
    PrintNonTerminal();
    PrintTerminal();
    PrintLeft2RightLinear();
  }

  private static void PrintNonTerminal(){
    System.out.println("\n");
    System.out.println("\tNON TERMINALS ARE;"+"S,B,D");
    System.out.println("\n");
  }

  private static void PrintTerminal(){
    System.out.println("\tTERMINALS ARE;a,b");
    System.out.println("\n");
  }

  private static void PrintProductions(){
    int i;
    System.out.println("\n");
    System.out.println("\t CONVERSION OF RIGHT TO LEFT LINEAR GRAMMER: ");
    System.out.println("\n");
    System.out.println("\tPRODUCTION ARE:");
    System.out.println("\t===============");
    for(i=0;i<5;i++){
      if (production[i][1]==" "){
        production[i][1]="N";
        System.out.println("\t   State  "+production[i][0]+"   With Transition     Value   "+ production[i][1]+"    Goes to State    "+production[i][2]);
      } else if(production[i][2]==" ") {
        production[i][2]="N";
        System.out.println("\t   State  "+production[i][0]+"   With Transition Value   "+production[i][1]+"    Goes to State    "+production[i][2]);
      } else
        System.out.println("\t   State  "+production[i][0]+"   With Transition Value   "+production[i][1]+"    Goes to State    "+production[i][2]);
    }
  }

  public static void PrintLeft2RightLinear(){	
    int i;
    System.out.println("\t"+"LEFT LINEAR GRAMMER:");
    System.out.println("\t"+"=============================");
    for(i=0;i<5;i++){
      String tmp=production[i][0];
      production[i][0]=production[i][2];
      production[i][2]=production[i][1];
      production[i][1]=tmp;
      System.out.println("\t"+production[i][0]+" --> "+production[i][1]+production[i][2]);
    }
  }

  public R2L(){
    //Constructor
  }
}