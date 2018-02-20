public abstract class Items{
	protected final String nom;
	protected final int prix;
	protected int qte;
	
	public Items(String nom, int prix, int qte){
		this.nom=nom;
		this.prix=prix;
		this.qte=qte;
	}
	
	public String getNom(){
		return nom;
	}
	
	public int getPrix(){
		return prix;
	}
	
	public int getQte(){
		return qte;
	}
	
	public void addQte(int plusQte){
		qte+=plusQte;
	}
	
	public void takeQte(int moinsQte){
		if(qte>0)
			qte-=moinsQte;
		else
			System.out.println("Vous n'en avez pas assez !"); 
	}
	
	public boolean utilise(Pokemon pokemon, Dresseur J){
		if(qte>0){
			return effetItem(pokemon, J);
		}
		System.out.println("Vous n'en avez pas assez !"); 
		return false;
	}
	
	public String toSave(){
		return getClass()+" "+qte+" ";
	}
	
	public abstract boolean effetItem(Pokemon pokemon, Dresseur J);

}
