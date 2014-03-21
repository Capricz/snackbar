package com.zliang.snackbar.core.homework.suha;

public class Player {
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		String s = "";
		if(ownCards!=null && ownCards.length>0){
			for (int i = 0; i < ownCards.length; i++) {
				s = "(card"+i+":"+i+"),";
			}
			s = s.substring(0,s.length()-1);
			sb.append(s);
		}
		sb.append("}");
		return "{position:"+this.position+"},{status:"+this.status+"},"+sb.toString();
	}
	@Override
	public boolean equals(Object obj) {
		if(obj==null) return false;
		Player p = (Player) obj;
		if(this.position == p.position){
			return true;
		}
		return false;
	}
	private Player nextPlayer;

	private boolean isVisited;
	private int position;
	private int status;
	private Card[] ownCards;
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Card[] ownCards() {
		return ownCards;
	}
	public void setOwnCards(Card[] ownCards) {
		this.ownCards = ownCards;
	}
	public Player getNextPlayer() {
		return nextPlayer;
	}
	public void setNextPlayer(Player nextPlayer) {
		this.nextPlayer = nextPlayer;
	}
	public boolean isVisited() {
		return isVisited;
	}
	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}
}
