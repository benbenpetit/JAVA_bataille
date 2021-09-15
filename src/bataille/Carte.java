package bataille;

public class Carte {
	private String couleur;
	private int numero;
	
	public Carte(String couleur, int numero) {
		this.couleur = couleur;
		this.numero = numero;
	}
	
	public String verifyCard(int numero) {
		switch (numero) {
	        case 11:
	            return "Valet";
	        case 12:
	            return "Roi";
	        case 13:
	            return "Reine";
	        case 14:
	            return "As";
	        default:
	            return String.valueOf(numero);
		}
	}
	
	public int getNumber() {
		return numero;
	}
	
	public String toString() {
		return verifyCard(numero) + " de " + couleur;
	}
}
