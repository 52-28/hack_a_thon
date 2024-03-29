package com.wildcodeschool.Hackofthon.models;

import java.lang.Math;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;

public class HearthOfThon {
	
	private static int playerLife = 0;
	private static int computerLife = 0;
	private static Card blankCard = new Card ();
	private static Card[] globalDeck = Deck.createCards();
    private static Player player1 = new Player(1, "Michel");
    private static String[] ranks = new String[] { "Novice", "Fighter", "Warrior", "Veteran", "Sage", "Elite",
            "Conqueror", "Champion", "Master", "Greatest", "Java > PHP" };
    private static Card[] computerDeck = new Card[9];
    private static Card[] playerDeck = new Card[10];
    
    public static Card[] createPlayerDeck () {
    	playerLife = 0;
    	playerDeck = new Card[] {blankCard, globalDeck[0], globalDeck[1], globalDeck[2], globalDeck[3], globalDeck[4]};
    	for (int i = 1; i < playerDeck.length; i++) {
    		int lifePoints = 0;
    		lifePoints = 20 + randomVar(20);
    		playerDeck[i].setLife(lifePoints);
    		playerLife += lifePoints;
    	}
    	return playerDeck;
    }
    
    
    public static Card[] createComputerDeck () {
    	computerLife = 0;
    	computerDeck = new Card[] {blankCard, globalDeck[5], globalDeck[6], globalDeck[7], globalDeck[8], globalDeck[9]};
    	for (int i = 1; i < computerDeck.length; i++) {
    		int lifePoints = 20 + randomVar(20);
    		computerDeck[i].setLife(lifePoints);
    		computerLife += lifePoints;
    	}
    	return computerDeck;
    }
    
    
    public static int getPlayerLife() {
    	return playerLife;
    }
    
    
    public static int getComputerLife() {
    	return computerLife;
    }
    
    
    public static int takeHit(Card card1, Card card2) {
        int damageDeal = card2.getAttack() + randomVar(10) - card1.getDefense()/4;
        int tempLife = card1.getLife();
        card1.setLife(card1.getLife() - damageDeal);
        if (card1.getLife() < 0) {
            card1.setLife(0);
            damageDeal = tempLife;
        }
        return damageDeal;
    }
    
    
    public static Card[] deckShuffle (Card[] deck) {
		List<Card> listCard = Arrays.asList(deck);
		Collections.shuffle(listCard);
		return listCard.toArray(deck);
    }

    
    public static String displayStatusBattle( boolean battleResult) {
		if (battleResult)
			return "Félicitations vous avez remporté la victoire !!";
		return "Cet Halloween sera votre dernier, vous n'avez pas vu derrière vous la faucheuse qui à eu raison de votre tête !";
	}
    

    public static String xpGain(double levelJoueur, double levelAdversaire) {
        double levelDiff = levelJoueur - levelAdversaire;
        if (levelDiff > 10) {
            return "Vous ne gagnez pas de points d'expérience.";
        } else if (levelDiff > 5) {
            xpAdd(0.1);
            return "Vous gagnez 10 points d'expérience.";
        } else if (levelDiff > 3) {
            xpAdd(0.2);
            return "Vous gagnez 20 points d'expérience.";
        } else if (levelDiff > 1) {
            xpAdd(0.3);
            return "Vous gagnez 30 points d'expérience.";
        } else if (levelDiff > -1) {
            xpAdd(0.5);
            return "Vous gagnez 50 points d'expérience.";
        } else if (levelDiff > -3) {
            xpAdd(0.8);
            return "Vous gagnez 80 points d'expérience.";
        } else if (levelDiff > -5) {
            xpAdd(1.0);
            return "Vous gagnez 100 points d'expérience.";
        } else if (levelDiff > -10) {
            xpAdd(1.5);
            return "Vous gagnez 150 points d'expérience.";
        } else {
            xpAdd((-levelDiff) * 0.2);
            String result = "Vous gagnez " + ((-levelDiff) * 0.2) + " points d'expérience";
            return result;
        }

    }
    

    public static String uprank() {
        String rank = ranks[(int) (player1.getExperience() / 10)];
        player1.setRank(rank);
        String result = "Votre rang : " + rank;
        return result;
    }
    
    
    public static void xpAdd(double xp) {
        player1.setExperience(player1.getExperience() + xp);
    }
    
    
    public static int randomVar(int variation) {
        return (int) (Math.random() * variation - (variation / 2));
    }
    
    public static Card[] getComputerDeck() {
    	return computerDeck;
    }
    
    public static Card[] getPlayerDeck() {
    	
    	return playerDeck;
    	
    }
   
}
