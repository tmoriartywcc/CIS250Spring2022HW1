/**
 * minesweeper class provides the data<br>
 * and methods for a minesweper game<br>
 *<br>
 * Level 1 - data & methods to implement <br>
 *           Mines, Clues, Tiles, basic Board characters,<br>
 *           and opening/marking tiles<p>
 * Level 2 - Additional data & methods to support game status<br>
 *           and extended Board characters<br>
 * <p>
 * minesweeper.java<br>
 * spring 2004<br>
 *<br>
 */
public class Minesweeper {

	/** mine and clue values, 9 - mine, 0-8 clue values
	 *
	 */
	public int[][] mines;

	/** tile values 0 - open, 1 - closed,<br>
	 * 2 - question, 3 - mine
	 */
	public int[][] tiles;

	/** Level 2 - game status win, lose, play
	 */
	private String status;

	/** default constructor<br>
	 * 	board size 9 x 9<br>
	 *  create mines and tile arrays<br>
	 *  place mines<br>
	 *  calculate clues<br>
	 *  (*)set game status to play<br>   
	 */
	public Minesweeper() {
		initGame(9, 9);
	}

	/** alternate constructor
	 *  use specifies board size<br>
	 *  create mines and tile arrays<br>
	 *  place mines<br>
	 *  calculate clues<br>
	 *  (*)set game status to play<br>
	 * @param newRows number of rows for grid<br>
	 * @param newCols number of columns for grid<br>
	 */
	public Minesweeper(int newRows, int newCols) {
		initGame(newRows, newCols);
	}

	/** Level 2 - game status
	 * @return "play", "win", or "lose"
	 */
	public String getStatus() {
		return status;
	}

	/** number of rows for board
	 * @return number of rows
	 */
	public int getRows() {
		return mines.length;
	}

	/** number of columns for board
	 * @return number of columns
	 */
	public int getCols() {
		return mines[0].length;
	}

	/** value of the mines array at r,c<br>
	 * -1 is returned if invalid r,c
	 * @param r row index
	 * @param c column index
	 * @return value of mines array, -1 if invalid
	 */
	public int getMines(int r, int c) {
		if (validIndex(r, c)) {
			return mines[r][c];
		} else {
			return -1;
		}
	}

	/** value of the tiles array at r,c
	 * -1 is returned if invalid r,c<br>
	 * @param r row index
	 * @param c column index
	 * @return value of tiles array, -1 if invalid
	 */
	public int getTiles(int r, int c) {
		if (validIndex(r, c)) {
			return tiles[r][c];
		} else {
			return -1;
		}
	}

	/** mark tile - open tile, close tile, <br>
	 *  flag tile as mine, set tile as question mark, close tile<br>
	 * <br>
	 * Level 1 - Requirements<br>
	 * - invalid r,c values must be ignored<br>
	 * - a tile that is opened must stay open<br>
	 * - a tile that is marked as a flag (ie. tile[][] value 3) can not be opened<br>
	 * <br>
	 * Level 2 - Requirements<br>
	 * - tile values can only change when game status is "play"<br>
	 * - game status must be updated after a tile is opened<br>
	 * <br>
	 * @param r row index<br>
	 * @param c column index<br>
	 * @param t 0 - open, 1 - close, 2 - question, 3 - mine<br>
	 */
	public void markTile(int r, int c, int t) {
		//		add your code here
	}

	/** mines array as String
	 * @return mines array as a String
	 */
	public String toStringMines() {
		String result = "\n";

		for (int r = 0; r < mines.length; r++) {
			for (int c = 0; c < mines[r].length; c++)
				result = result + mines[r][c];

			result += "\n";
		}

		return result;
	}

	/** tiles array as String
		 * @return mines array as a String
		 */
	public String toStringTiles() {
		String result = "\n";

		for (int r = 0; r < mines.length; r++) {
			for (int c = 0; c < mines[r].length; c++)
				result = result + tiles[r][c];

			result += "\n";
		}

		return result;
	}

	/** game board array as String
	 * @return game board as String
	 */
	public String toStringBoard() {
		String result = "";

		for (int r = 0; r < tiles.length; r++) {
			for (int c = 0; c < tiles[r].length; c++) {
				result += this.getBoard(r, c);
			}
			result += "\n"; //advance to next line
		}

		return result;
	}

	/** getBoard - determines current game board character for r,c position <br>
	 *  using the value of the mines[][] and tiles[][]array<br>
	 *  Note:  Level 2 values are returned when <br>
	 *         game is over (ie. status is "win" or "lose")<br>
	 * <br><br>
	 * Level 1 values<br>
	 * '1'-'8'  opened tile showing clue value<br>
	 * ' '      opened tile blank<br>
	 * 'X'      tile closed<br>
	 * '?'      tile closed marked with ?<br>
	 * 'F'      tile closed marked with flag<br>
	 * '*'      mine<br>
	 * <br><br>
	 * Level 2 values<br>
	 * '-'      if game lost, mine that was incorrectly flagged<br>
	 * '!'      if game lost, mine that ended game<br>
	 * 'F'      if game won, all mines returned with F
	 * <br>
	 * @return char representing game board at r,c
	 */
	public char getBoard(int r, int c) {
		//		add your code here
		return 'X'; //this line must be modified
	}

	/** create mines & tiles array
	 * place mines<br>
	 * update clues<br>
	 * @param newRows number of rows for grid
	 * @param newCols number of columns for grid
	 */
	private void initGame(int newRows, int newCols) {
		//allocate space for mines and tiles array
		if ((newRows >= 1) && (newCols >= 1)) {
			mines = new int[newRows][newCols];
			tiles = new int[newRows][newCols];

			//init tiles array
			resetTiles();

			//place mines
			placeMines();

			//update clues
			calculateClues();

			//set game status
			status = "play";
		}
	}

	/** Sets all tiles to 1 - closed
	 */
	private void resetTiles() {
		//		add your code here
	}

	/** places mines randomly on grid
	 * integer value 9 represents a mine<br>
	 * number of mines = (1 + number of columns * number rows) / 10<br>
	 * minimum number of mines = 1<br>
	 */
	private void placeMines() {
		//		add your code here
	}

	/** calculates clue values and updates
	 * clue values in mines array<br>
	 * integer value 9 represents a mine<br>
	 * clue values will be 0 ... 8<br>
	 */
	private void calculateClues() {
		//		add your code here
	}

	/** determines if x,y is valid position
	 * @param x row index
	 * @param y column index
	 * @return true if valid position on board,
	 * false if not valid board position
	 */
	private boolean validIndex(int x, int y) {
		//add your code here

		return true; //this line must be modified
	}

	/** Level 2 - game won status
	 * @return true if game won
	 * false if game not won
	 */
	private boolean gameWon() {
		//add your code here
		return false; //this line must be modified
	}

}
