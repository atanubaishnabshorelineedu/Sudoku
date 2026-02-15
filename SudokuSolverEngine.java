public class SudokuSolverEngine {

   public static void main(String[] args) {
      // Here I have called my class `MySudokuBoard` if you named your class
      // differently, modify the line below to use your own class name
      SudokuBoard board = new SudokuBoard("boards/very-fast-solve.sdk");
      System.out.println("Initial board");
      System.out.println(board);
      System.out.println();
      
      if (!board.isValid()) {
      System.out.println("This board cannot be solved (invalid board).");
      return;
      }
      if (board.isSolved()) {
      System.out.println("This board is already solved.");
      return;
      }

      System.out.print("Solving board...");
      long start = System.currentTimeMillis();
      boolean solved = board.solve();    
      long stop = System.currentTimeMillis();
      System.out.printf("SOLVED in %.3f seconds.\n", ((stop-start)/1000.0));
      System.out.println("Was I able to solve it? " + solved);
      System.out.println();
      System.out.println(board); 
   }
}