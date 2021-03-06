package ep;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/*
 * An immutable data type that solves the 8 puzzle.
 * 
 * @author Henry Doan
 * @version November 3, 2018
 */
public class Solver {
	private Board workBoard;
	private Block lastBlock;
	 
	private class Block implements Comparable<Block> {
		public Block previous;
		public Board board;
		public int numMoves = 0;
		
		public Block(Board incommingBoard) {
			board = incommingBoard;
		}
		
		public Block(Board incommngBoard, Block prev) {
			board = incommngBoard;
			previous = prev;
			numMoves = previous.numMoves++;
		}
		
		@Override
		public int compareTo(Block b) {
			int diffOfBoardsManhattan = board.manhattan() - b.board.manhattan();
			int diffOfMoves = numMoves - b.numMoves;
			int sumOfMovesAndManhattan = diffOfBoardsManhattan + diffOfMoves;
			return sumOfMovesAndManhattan; 
		} 
	}
	
	/*
	 * Find a solution to the initial board (using the A* algorithm)
	 */
	public Solver(Board initial) {
		if (initial == null) {
			throw new java.lang.NullPointerException();
		}
		 
		workBoard = initial;
		 
		if (workBoard.isSolvable() == false) {
			throw new java.lang.IllegalArgumentException();
		}
		
		MinPQ<Block> blocks = new MinPQ<Block>();
		MinPQ<Block> blocks2 = new MinPQ<Block>();

		blocks.insert(new Block(workBoard));
		blocks2.insert(new Block(workBoard));
		
		while(true) {
			lastBlock = expand(blocks);
			if (lastBlock != null || expand(blocks2) != null) {
				return;
			}
		}
	}
	 
	/*
	 * Expanding the block.
	 * 
	 * @return null 
	 * 		   bestBlock -- a block the best move to make.
	 */
	private Block expand(MinPQ<Block> blocks) {
		if (blocks.isEmpty()) {
			return null;
		}
		
		Block bestBlock = blocks.delMin();
		if (bestBlock.board.isGoal()) {
			return bestBlock;
		}
		
		for (Board neighbor: bestBlock.board.neighbors()) {
			if ( bestBlock.previous == null || !neighbor.equals(bestBlock.previous.board)) {
				blocks.insert(new Block(neighbor, bestBlock));
			}
		}
		
		return null;
	}

	/*
	 * Min number of moves to solve initial board.
	 * 
	 * @return int number of moves to solve with the manhattan.
	 */
	 public int moves()	{
		 if (workBoard.isSolvable()) {
			 return lastBlock.numMoves;
		 }
		 else {
			 return -1;
		 }
		
	 }
	 
	/*
	 * Sequence of boards in a shortest solution.
	 * 
	 * @return  -- boards to the shortest solution.
	 */	 
	 public Iterable<Board> solution() {
		Stack<Board> boardsToSol = new Stack<Board>();
		
		while(lastBlock != null) {
			boardsToSol.push(lastBlock.board);
			lastBlock = lastBlock.previous;
		}
		
		return boardsToSol;	 
	 }
	 
	/*
	 * Solve a slider puzzle.
	 */
	public static void main(String[] args) {
		
		// create initial board from file
		In in = new In("");
        int N = in.readInt();
        int[][] blocks = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                blocks[i][j] = in.readInt();
        Board initial = new Board(blocks);

        // check if puzzle is solvable; if so, solve it and output solution
        if (initial.isSolvable()) {
            Solver solver = new Solver(initial);
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }

        // if not, report unsolvable
        else {
            StdOut.println("Unsolvable puzzle");
        }
    }

}
