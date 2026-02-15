// Atanu
// CS 143
// Topics: Sudoku
//

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

   public class SudokuBoard {
   private char[][] board;

// PRE: find the filePath 
// POST: board is filled 
   public SudokuBoard(String filePath) {
   board = new char[9][9];
   try {
   Scanner input = new Scanner(new File(filePath));
   for (int r = 0; r < 9; r++) {
   String line = input.nextLine();          
   for (int c = 0; c < 9; c++) {
   board[r][c] = line.charAt(c);        
   }
   }
   input.close();
   } 
   catch (FileNotFoundException e) {
   System.out.println("File not found: " + filePath);
     }
    }
   
/*PRE : Board loading 
  POST:Running the board
*/    

   public String toString() {
   String s = "";
   s += "+-------+-------+-------+\n";
   for (int r = 0; r < 9; r++) {
   s += "| ";
   for (int c = 0; c < 9; c++) {
   char ch = board[r][c];
   if (ch == '.') {
   s += "  ";
   } else {
   s += ch + " ";
   }
   if ((c + 1) % 3 == 0) {
   s += "| ";
   }
   }
   s += "\n";
   if ((r + 1) % 3 == 0) {
   s += "+-------+-------+-------+\n";
    }
        }
        return s;
    }
   
   /* PRE: Selecting numbers between from 1 and 9
      POST: prints the board in 3x3 format
   */ 
    
   private char[][] miniSquare(int spot) {
   char[][] mini = new char[3][3];
   for (int r = 0; r < 3; r++) {
   for (int c = 0; c < 3; c++) {
   mini[r][c] = board[(spot - 1) / 3 * 3 + r]
   [(spot - 1) % 3 * 3 + c];
   }
   }
   return mini;
   }

   // PRE: board is already loaded
   // POST: true if board follows Sudoku rules 
   public boolean isValid() {
   return validData() && validRows() && validCols() && validMinis();
}

   // PRE: board is loaded
   // POST: true if solved 
   public boolean isSolved() {
   if (!isValid()) return false;
   
   Map<Character, Integer> map = new HashMap<>();
   for (char ch = '1'; ch <= '9'; ch++) {
   map.put(ch, 0);
   }
   for (int r = 0; r < 9; r++) {
   for (int c = 0; c < 9; c++) {
   char ch = board[r][c];
   if (ch == '.' || ch == '0' || ch == ' ') return false;
   map.put(ch, map.get(ch) + 1);
   }
   }
   for (char ch = '1'; ch <= '9'; ch++) {
   if (map.get(ch) != 9) return false;
   }
   return true;
}

   private boolean validData() {
   for (int r = 0; r < 9; r++) {
   for (int c = 0; c < 9; c++) {
   char ch = board[r][c];
   boolean empty = (ch == '.' || ch == '0' || ch == ' ');
   boolean digit = (ch >= '1' && ch <= '9');
   if (!(empty || digit)) return false;
   }
   }
   return true;
}

   private boolean validRows() {
   for (int r = 0; r < 9; r++) {
   Set<Character> seen = new HashSet<>();
   for (int c = 0; c < 9; c++) {
   char ch = board[r][c];
   if (ch != '.' && ch != '0' && ch != ' ') {
   if (!seen.add(ch)) return false;
   }
   }
   }
   return true;
}

   private boolean validCols() {
   for (int c = 0; c < 9; c++) {
   Set<Character> seen = new HashSet<>();
   for (int r = 0; r < 9; r++) {
   char ch = board[r][c];
   if (ch != '.' && ch != '0' && ch != ' ') {
   if (!seen.add(ch)) return false;
   }
   }
   }
   return true;
}

   private boolean validMinis() {
   for (int spot = 1; spot <= 9; spot++) {
   char[][] mini = miniSquare(spot);
   Set<Character> seen = new HashSet<>();
   for (int r = 0; r < 3; r++) {
   for (int c = 0; c < 3; c++) {
   char ch = mini[r][c];
   if (ch != '.' && ch != '0' && ch != ' ') {
   if (!seen.add(ch)) return false;
   }
   }
   }
   }
   return true;
   }
   public boolean solve() {

   if (!isValid()) {
   return false;
   }
   if (isSolved()) {
   return true;
   }

   for (int r = 0; r < 9; r++) {
   for (int c = 0; c < 9; c++) {
   char ch = board[r][c];
   if (ch == '.' || ch == '0' || ch == ' ') {
   for (char x = '1'; x <= '9'; x++) {
   board[r][c] = x;
   if (isValid() && solve()) {
   return true;
   }
   }
   board[r][c] = '.';
   }
   }
   }
   return false;
}
}