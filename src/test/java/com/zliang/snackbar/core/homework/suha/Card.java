package com.zliang.snackbar.core.homework.suha;

public class Card {
	@Override
	public String toString() {
		return String.valueOf(this.cardId);
	}

	private int cardId;

	public int getCardId() {
		return cardId;
	}

	public void setCardId(int cardId) {
		this.cardId = cardId;
	}
}
