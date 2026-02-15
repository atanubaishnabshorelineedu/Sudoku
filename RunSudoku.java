// Atanu
// CS 143
// Topics: Sudoku


   public class RunSudoku {
   public static void main(String[] args) {
   SudokuBoard b = new SudokuBoard("data1.sdk"); 
   System.out.println(b);
   }
}

/*

 ----jGRASP exec: java RunSudoku
 +-------+-------+-------+
 | 2     | 1   5 |     3 | 
 |   5 4 |       | 7 1   | 
 |   1   | 2   3 |   8   | 
 +-------+-------+-------+
 | 6   2 | 8   7 | 3   4 | 
 |       |       |       | 
 | 1   5 | 3   9 | 8   6 | 
 +-------+-------+-------+
 |   2   | 7   1 |   6   | 
 |   8 1 |       | 2 4   | 
 | 7     | 4   2 |     1 | 
 +-------+-------+-------+
 
 
  ----jGRASP: Operation complete.
 
 

*/