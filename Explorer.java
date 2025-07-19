import java.util.Scanner;
//import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;

public class Explorer {

/* Given the coordinates of the player, returns adjacent rooms
 * as [N, E, S, W]. If player is adjacent to the edge, int will be 4.
 * checks through exits array to avoid edge cases. Hard-coded
 */
   public static int[] surroundings(int xCoord, int yCoord, int[][] grid, boolean[] exits){
      int[] result = new int[4];

      if(exits[1]){
         result[1] = grid[xCoord][yCoord + 1]; // N side
      } else {
         result[1] = 4;
      }

      if(exits[2]){
         result[2] = grid[xCoord + 1][yCoord]; // E side
      } else{
         result[2] = 4;
      }

      if (exits[3]){
         result[3] = grid[xCoord][yCoord - 1]; // S side
      } else {
         result[3] = 4;
      }
         
      if (exits[4]){
         result[4] = grid[xCoord - 1][yCoord]; // W side
      } else {
         result[4] = 4;
      }
      
      return result;
   }

   /*
    * Given the coordinates of the player, returns adjacent rooms that are available 
    * as [N, E, S, W]. If able to move that direction, then will return true 
    * in the corresponding slot.
    */
   public static boolean[] exits(int xCoord, int yCoord, int max){
      boolean[] result = {true, true, true, true}; //assumes player can move in all directions
      if (yCoord == 0) { result[1] = false; }   // N side
      if (xCoord == max) { result[2] = false; } // E side
      if (yCoord == max){ result[3] = false; }  // S side
      if (xCoord == 0){ result[4] = false; }    // W side

      return result;
   }
   /*
    * prompt and read string from user to get file, then tokenize the ints
    * to a 2D array given the format of the text file contains the size of the 
    * map first, and then the contents of the map.
    */
   public static int [][] readGrid(String filename){
      int size = 0;
      int[][] freshMap = {};
      
      try {
         Scanner intScanner = new Scanner(new File(filename));
         intScanner.useDelimiter(",");
         while (intScanner.hasNext()){
            
         }
         boolean firstLoop = true;
         if (firstLoop){
            size = Integer.parseInt(intScanner.nextLine());
            firstLoop = false;
            freshMap = new int[size][size];
         } else {
            for (int i = 0; i < size; i++){
               for(int j = 0; j < size; j++){
                  freshMap[i][j] = Integer.parseInt(intScanner.next());
               }
            }
         }
         intScanner.close();
      }
      catch(FileNotFoundException ex){
         System.out.println(("ERROR: File " + filename + "not found! "));
      }

      return freshMap;
   }

   public static void main(String[] args) {
      int[][] printThis = readGrid("map33.txt");
      for (int i = 0; i < 6; i++){
         for(int j = 0; j < 6; j++){
            System.out.print(printThis[i][j] + ",");
         }
      System.out.println();
      }
   }
}
