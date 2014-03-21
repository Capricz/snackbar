package com.zliang.snackbar.core.homework.suha;

import java.util.Arrays;
import java.util.Random;

public class Game {
	
	private final int CARD_SIZE = 50;
	private final int PLAYER_SIZE = 5;
	
	private Player[] players;
	private Card[] remainCards;
	private Card[] allCards;
	private int cursor = 0;
	
	public Game(){
		this.players = new Player[PLAYER_SIZE];
		this.remainCards = new Card[CARD_SIZE];
		this.allCards = new Card[CARD_SIZE];
		this.cursor = CARD_SIZE - 1;
		initPlayers();
		inttCards();
	}
	
	
	private void inttCards() {
		System.out.println("INFO : initialize cards...");
		for (int i = 0; i < allCards.length; i++) {
			Card c = new Card();
			c.setCardId(i);
			allCards[i] = c;
		}
	}


	private void initPlayers() {
		System.out.println("INFO : initialize players...");
		Player prevP = null;
		for (int i = 0; i < PLAYER_SIZE; i++) {
			Player p = new Player();
			p.setPosition(i);
			p.setStatus(0);
//			p.setOwnCards(new Card[1]);
			players[i] = p;
			if(prevP!=null){
				prevP.setNextPlayer(p);
			}
			prevP = p;
		}
		players[PLAYER_SIZE-1].setNextPlayer(players[0]);
	}


	public Player[] getPlayers() {
		return players;
	}

	public void setPlayers(Player[] players) {
		this.players = players;
	}

	public Card[] getRemainCards() {
		return remainCards;
	}

	public void setRemainCards(Card[] remainCards) {
		this.remainCards = remainCards;
	}
	
	public void play(){
		Player player = null;
		do{
			player = delivery();
		} while(player == null);
		System.out.println("player is "+player);
	}

	
	
	//start from who?
	//skip who?
	//update remainCards
	public Player delivery(){
		Player player = new Player();
		player.setPosition(2);
		player.setStatus(0);
		player.setVisited(false);
		
		
		Player p = null;
		boolean found = false;
		for (int i = 0; i < players.length; i++) {
			p = players[i];
			if(p.equals(player)){
				found = true;
				break;
			}
		}
		
		if(!found){
			System.out.println("Error : not found Player");
			return null;
		}
		
		if(p == null){
			System.out.println("Error : exits because of no match player");
			return null;
		}
		
		
		while(Boolean.FALSE == p.isVisited()){
			p.setVisited(true);
			if(p.getStatus() == 1){
				continue;
			}
			
			//set a card to a player, remove the card from allCards
			Card[] ownCards = p.ownCards();
			if(ownCards==null ||ownCards.length==0){
				ownCards = new Card[1];
			}else{
				int newLength = ownCards.length + 1;
				ownCards = Arrays.copyOf(ownCards, newLength);
			}
			Card aCard = removeCardFromAllCards();
			ownCards[ownCards.length-1] = aCard;
			p.setOwnCards(ownCards);
			System.out.println("INFO : Assign a card"+aCard+" to a player "+player);
			p = p.getNextPlayer();
		}
		
		showHandForACertainPlayer();
		
		Player winner = checkTheOwner();
		if(winner!=null){
			System.out.println("winner is "+winner);
			return winner;
		}

		for (int j = 0; j < players.length; j++) {
			players[j].setVisited(false);
		}
		
		return null;
	}


	private Player checkTheOwner() {
		int alive = 0;
		Player winner = null;
		outer:
		for (int i = 0; i < players.length; i++) {
			if(players[i].getStatus() == 0){
				if(alive>=2){
					break outer;
				}
				alive++;
				winner = players[i];
			}
		}
		if(alive==1){
			return winner;
		}
		return null;
	}


	private void showHandForACertainPlayer() {
		Random r = new Random();
		int count = 0;
		for (int i = 0; i < players.length; i++) {
			if(players[i].getStatus()==0){
				count++;
			}
		}
		int nextInt = r.nextInt(count);
		players[nextInt].setStatus(1);
		System.out.println("INFO : player"+nextInt+" show hand");
	}


	private Card removeCardFromAllCards() {
		Random r = new Random();
		int nextInt = r.nextInt(cursor+1);
		Card c = allCards[nextInt];
		if(nextInt!= cursor){
			for (int i = nextInt; i < cursor; i++) {
				allCards[i] = allCards[i+1];
			}
			cursor--;
		} else{
			allCards = Arrays.copyOf(allCards, cursor-1);
			cursor--;
		}
		return c;
	}

}
