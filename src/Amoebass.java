import java.util.Scanner;
//correct answer
public class Amoebass {
    
    static boolean isValidMove(char[][] image, boolean[][] visited, int row, int col) {
        // Check if the move is within the boundaries of the image
        return row >= 0 && row < image.length && col >= 0 && col < image[0].length 
               && !visited[row][col] && image[row][col] == '#';
    }

    static void dfs(char[][] image, boolean[][] visited, int row, int col) {
        // Define all eight possible moves from the current pixel
        int[] dr = {1, -1, 0, 0, 1, -1, -1, 1};
        int[] dc = {0, 0, 1, -1, 1, -1, 1, -1};

        // Mark the current pixel as visited
        visited[row][col] = true;

        // Explore all eight possible moves
        for (int i = 0; i < 8; i++) {
            int newRow = row + dr[i];
            int newCol = col + dc[i];
            if (isValidMove(image, visited, newRow, newCol)) {
                dfs(image, visited, newRow, newCol);
            }
        }
    }

    static int countLoops(char[][] image) {
        // Initialize a visited matrix to keep track of visited pixels
        boolean[][] visited = new boolean[image.length][image[0].length];
        
        // Initialize the loop count
        int loopCount = 0;
        
        // Traverse through each pixel in the image
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                // If the pixel is black and not visited, start a new DFS to explore the loop
                if (image[i][j] == '#' && !visited[i][j]) {
                    dfs(image, visited, i, j);
                    loopCount++;  // Increment the loop count for each new loop found
                }
            }
        }
        
        return loopCount;
    }

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

        // Counting loops and printing the result
        System.out.println(countLoops(image));

        scanner.close();
    }
}

