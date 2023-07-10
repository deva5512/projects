package PreparationQuestions.ChainReaction;

public class Player {
	private static int count = 1;
	private int playerid;
	private String playerName;

	public Player(String name) {
		this.playerid = count++;
		this.playerName = name;
	}

	public int getPlayerid() {
		return playerid;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerid(int playerid) {
		this.playerid = playerid;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

}
