package com.wildcodeschool.Hackofthon.models;

import java.lang.Math;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;

public class HearthOfThon {
	
	private static Card[] globalDeck = Deck.createCards();
    private static String displayMessage;
    private static boolean isPlaying;
    private static Player player1 = new Player(1, "Michel");
    private static boolean battleResult; // false par déf
    private static String[] ranks = new String[] { "Novice", "Fighter", "Warrior", "Veteran", "Sage", "Elite",
            "Conqueror", "Champion", "Master", "Greatest", "Java > PHP" };

    private static int takeHit(Card card1, Card card2) {
        int damageDeal = card2.getAttack() + randomInt(10);
        card1.setLife((card1.getLife() + card1.getDefense()) - damageDeal);
        if (card1.getLife() < 0) {
            card1.setLife(0);
        }
        return damageDeal;
    }

    
    private static Card[] cardShuffle () {
		List<Card> listCard = Arrays.asList(globalDeck);
		Collections.shuffle(listCard);
		return listCard.toArray(globalDeck);
    }
    
    
    private static Card[] createPlayerDeck () {
    	Card[] playerDeck = new Card[] {globalDeck[0], globalDeck[1], globalDeck[2], globalDeck[3], globalDeck[4], globalDeck[5], globalDeck[6], globalDeck[7], globalDeck[8], globalDeck[9]};
    	return playerDeck;
    }
    
    private static Card[] createOrdiDeck () {
    	Card[] ordiDeck = new Card[] {globalDeck[10], globalDeck[11], globalDeck[12], globalDeck[13], globalDeck[14], globalDeck[15], globalDeck[16], globalDeck[17], globalDeck[18]};
    	return ordiDeck;
    }

    
    private static String displayStatusBattle( boolean battleResult) {
			
		if (battleResult)
			return " Félicitation vous avez remporté la victoire !!";
		return " Cet Halloween sera votre dernier, vous n'avez pas vu derrière vous la faucheuse qui à eu raison de votre tête !";
	}
    

    private static String xpGain(double levelJoueur, double levelAdversaire) {

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
    

    private static String uprank() {
        String rank = ranks[(int) (player1.getExperience() / 10)];
        player1.setRank(rank);
        String result = "Votre rang : " + rank;
        return result;
    }
    
    
    private static void xpAdd(double xp) {
        player1.setExperience(player1.getExperience() + xp);
    }
    
    
    private static int randomInt(int variation) {
        return (int) (Math.random() * variation - (variation * 2));
    }
    
}
