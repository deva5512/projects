package com.cricketscoremanagement.CricketView;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import com.cricketscoremanagement.dto.Player;
import com.cricketscoremanagement.dto.Team;

import repository.ScoreManagementDb;

public class CricketModel {

	private CricketView cricketView;

	private Team winningteam = null;

	public CricketModel(CricketView cricketView) {
		this.cricketView = cricketView;
	}

	public int getOver() {
		return ScoreManagementDb.getInstance().getNumber_overs();
	}

	public String getTeam1name() {
		return ScoreManagementDb.getInstance().getTeam1().getTeam_name();
	}

	public String getTeam2name() {
		return ScoreManagementDb.getInstance().getTeam2().getTeam_name();
	}

	public void setOvers(int overs) {
		ScoreManagementDb.getInstance().setNumber_overs(overs);
	}

	public void setTeam2PlayerName(List<String> names) {
		List<Player> player = ScoreManagementDb.getInstance().getTeam2().getTeam();

		for (int i = 0; i < player.size(); i++) {
			player.get(i).setName(names.get(i));
		}
	}

	public void setTeam1PlayerName(List<String> names) {
		List<Player> player = ScoreManagementDb.getInstance().getTeam1().getTeam();

		for (int i = 0; i < player.size(); i++) {
			player.get(i).setName(names.get(i));
		}
	}

	public void setTeamName(String team1, String team2) {
		ScoreManagementDb.getInstance().getTeam1().setTeam_name(team1);
		ScoreManagementDb.getInstance().getTeam2().setTeam_name(team2);
	}

	public List<Player> getTeam2Players() {
		return ScoreManagementDb.getInstance().getTeam2().getTeam();
	}

	public List<Player> getTeam1Players() {
		return ScoreManagementDb.getInstance().getTeam1().getTeam();
	}

	public void swapTeam() {
		ScoreManagementDb.getInstance().swapTeamsInBoard();
	}

	public String getWinner() {
		return ScoreManagementDb.getInstance().getWinning_team();
	}

	public void SetScoreBoard() {
		ScoreManagementDb.getInstance().secondScoreBoard();
	}

	public char getTossRes(String string) {
		Random r = new Random();

		int i = r.nextInt(string.length());

		return string.charAt(i);
	}

	public String GetManOfTheMatch() {
		Team team1 = ScoreManagementDb.getInstance().getTeam1();
		Team res = ScoreManagementDb.getInstance().getTeam2();

		String winner = getWinner();
		if (winner.equals(team1.getTeam_name())) {
			res = team1;
		}

		winningteam = res;

		Iterator<Player> it = res.getTeam().iterator();

		Player highest = it.next();

		Player score = highest;

		while (it.hasNext()) {
			Player player = it.next();
			if (highest.getNumberofWickets() < player.getNumberofWickets()) {
				highest = player;
			}
			if (score.getIndevidual_score() < player.getIndevidual_score()) {
				score = player;
			} else if (score.getIndevidual_score() == player.getIndevidual_score()) {
				if ((score.getIndevidual_score() / (float)score.getNo_of_balls()) < (player.getIndevidual_score()
						/ player.getNo_of_balls())) {
					
					score = player;
				}
			}
		}
		if (highest.getNumberofWickets() < 3) {
			return score.getName();
		}
		return highest.getName();
	}
	
	public Player[] getTopPlayers() {
		Player[] topplayers = new Player[3];

		Collections.sort(winningteam.getTeam());

		int i = 0;
		for (; i < 3; i++) {
			if (winningteam.getTeam().get(i).getIndevidual_score() == 0) {
				break;
			}
			topplayers[i] = winningteam.getTeam().get(i);
		}
		if (i <= 3) {
			return Arrays.copyOfRange(topplayers, 0, i);
		}
		return topplayers;

	}
}
