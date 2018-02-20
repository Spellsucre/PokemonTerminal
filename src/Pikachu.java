public class Pikachu extends Electricite{
	private static int cpt=1;

	public Pikachu(String nom, int pvmax, int attaque, int speed, int niveau) {
		super(nom, pvmax, attaque, speed, niveau);
		id="Pikachu";
	}
	
	public Pikachu(String nom, int pvmax, int attaque, int speed) {
		this(nom, pvmax, attaque, speed,1);
	}

	public Pikachu() {
		this("Pikachu"+cpt, 200+(int)(Math.random()*50), 65+(int)(Math.random()*30), 110+(int)(Math.random()*10));
		cpt++;
	}
	
	public void talent(){
	}
	
	public void attaque(Pokemon adversaire, String choixAttaque){
		super.attaque(adversaire, choixAttaque);
		if(Math.random()<0.2){
			adversaire.paralyse+=2;
			System.out.println("\t\t\t\t"+getAfficherNom() + " est éléctrifié ! " +adversaire.getAfficherNom() + " est paralysé ! ");
		}
	}
	
	public void evolution(){
		if(niveau>=10 && id.equals("Pikachu")){
			System.out.println("Quoi ? "+getAfficherNom()+" évolue?");
			System.out.println("...");
			System.out.println("...");
			System.out.println("...");
			System.out.print("Félicitations ! Votre " + getAfficherNom() + " a évolué en ");
			evolution=true;
			super.changerId("Raichu");
			if(!nomPerso)
				super.changerNom(id+cpt);
			else if(nom.equals("Pikachu"))
				super.changerNom(id);
			System.out.println(getAfficherId() + " ! ");
			super.evolution();
		}
	}

}
