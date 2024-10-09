import java.util.Scanner;

public class amoebas {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

         // Reading input
         int n = scanner.nextInt();
         int m = scanner.nextInt();
         scanner.nextLine(); // Move to the next line after reading integers
         char[][] image = new char[n][m];
         for (int i = 0; i < n; i++) {
             String row = scanner.nextLine();
             for (int j = 0; j < m; j++) {
                 image[i][j] = row.charAt(j);
             }
         }




        

        amoebas cs = new amoebas();

        int numberOfShapes;
        System.out.println(cs.shapecounter(array));


        
       
        
       
    }

public void dfs(char a[][], int row,int column, String marker){
    int rows = a.length;
    int columns = a[0].length;


    
    if (row < 0 || column < 0 || row >= rows || column >= columns || a[row][column] != "#" ) {
        return;
    }
    a[row][column] = marker;

    dfs(a,row+1,column,marker);
    dfs(a,row-1,column,marker);
    dfs(a,row,column-1,marker);
    dfs(a,row,column+1,marker);




}
public  int shapecounter(char a[][]){

    if (a == null || a.length == 0 || a[0].length == 0) {
        return 0;
    }

    int count = 0;
    int rows = a.length;
    int cols = a[0].length;
    String marker = "2";
    
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            if (a[i][j].equals("#")  ) {
                dfs(a, i, j, marker);
                count++;
            }
        }
    }

    return count;



}
}
