package bataille;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    public ArrayList<Carte> allCards;
    
    public ArrayList<Carte> getAllCards() {
	    return allCards;
	}

    public Deck() {
    	this.allCards = new ArrayList<Carte>();
        String[] colors = {"Trèfle", "Coeur", "Pique", "Carreau"};
        int[] values = {2,3,4,5,6,7,8,9,10,11,12,13,14};
        
        for (String arrayColors : colors) {
        	for (int arrayValues : values) {
            	allCards.add(new Carte(arrayColors, arrayValues));
            }
        }
        
        Collections.shuffle(allCards);
    }

	public void splitDeck(Deck deck, Joueur j1, Joueur j2) {
	    int numberOfCardEachPlayer = deck.allCards.size() / 2;
	    
	    j1.createPlayerDeck(0, numberOfCardEachPlayer, allCards);
	    j2.createPlayerDeck(numberOfCardEachPlayer, deck.allCards.size(), allCards);
	}
}