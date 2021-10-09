package bataille;
import java.util.ArrayList;

public class Joueur {
	private ArrayList<Carte> playerDeck = new ArrayList<Carte>();
	private String name;	
	
	public Joueur(String name) {
		this.name = name;
	}
	
	public String getName()  {
		return this.name;
	}
	
	public void addCard(Carte card) {
		this.playerDeck.add(card);
	}
	
	public void addCards(ArrayList<Carte> cards) {
		this.playerDeck.addAll(cards);
	}
	
	public void removeTopCard() {
		this.playerDeck.remove(0);
	}
	
    public void createPlayerDeck(int start, int end, ArrayList<Carte> allCards) {
        for (int i = start; i < end; i++)
            this.playerDeck.add(allCards.get(i));
    }
    
    public ArrayList<Carte> getPlayerDeck() {
        return playerDeck;
    }
    
    public Carte getPlayerTopCard() {
    	return playerDeck.get(0);
    }
}
