
public interface Adversaire{
	
	public void attaque(Pokemon adversaire, String attaque);
	
	public void subire(Adversaire adversaire, int degats);
	
	public Pokemon getCombattant();
	
	public int calculNiveau();
	
	public int getNiveau();
	
	public void gagnerNiveauAdversaire(int Level);
	
	public int getNbPokemons();
	
	public Pokemon[] getPokemons();
	
	public void infirmerie();
	
	public void vaincu();
	
	public void newCombattant(Pokemon Suivant);
	
	public int getArgent();
	
	public void gagneArgent(int gain);
	
	public void perdArgent(int perte);
	
	public String getNom();
	
	public String getAfficherNom();

}
