import java.util.Scanner;
import java.util.Arrays;


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

   public static void main(String[] args) {
      boolean[] direction = exits(0, 0, 0);
      System.out.println(Arrays.toString(direction));
      
   }
}
