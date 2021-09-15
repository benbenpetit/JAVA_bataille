package bataille;
import java.util.ArrayList;

public class Joueur {
	private ArrayList<Carte> playerDeck = new ArrayList<Carte>();
	private String name;
	private int score;
	
	
	public Joueur(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	public String getName()  {
		return this.name;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public void incrementScore() {
		this.score++;
	}
	
	public void decrementScore() {
		this.score--;
	}
	
	public void addCard(Carte card) {
		this.playerDeck.add(card);
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
