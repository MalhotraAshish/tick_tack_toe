package tick_tack_toe;

public class Main {
	public static void main(String args[]) {
		Player p2 = new Player("Ashu", 1, "80066066680", 'x');
		Player p1 = new Player("Mummy", 2, "9013447194", 'o');
		Player[] players = { p1, p2 };
		Board b = new Board(3, players);
		b.startGame();

	}
}
