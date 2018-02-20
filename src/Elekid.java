public class Elekid extends Electricite{
	private static int cpt=1;

	public Elekid(String nom, int pvmax, int attaque, int speed, int niveau) {
		super(nom, pvmax, attaque, speed, niveau);
		id="Elekid";
	}
	
	public Elekid(String nom, int pvmax, int attaque, int speed) {
		this(nom, pvmax, attaque, speed, 1);
	}

	public Elekid() {
		this("Elekid"+cpt, 180+(int)(Math.random()*50), 70+(int)(Math.random()*30), 95+(int)(Math.random()*10));
		cpt++;
	}
	
	public void talent(){
	}
	
	public void attaque(Pokemon adversaire, String choixAttaque){
		super.attaque(adversaire, choixAttaque);
		if(Math.random()<0.2){
			adversaire.paralyse+=1;
			System.out.println("\t\t\t\t" +adversaire.getAfficherNom() + " est paralysé ! ");
		}
	}
	
	public void evolution(){
		if(niveau>=10 && id.equals("Elekid")){
			System.out.println("Quoi ? "+getAfficherNom()+" évolue?");
			System.out.println("...");
			System.out.println("...");
			System.out.println("...");
			System.out.print("Félicitations ! Votre " + getAfficherNom() + " a évolué en ");
			evolution=true;
			super.changerId("Elektek");
			if(!nomPerso)
				super.changerNom(id+cpt);
			else if(nom.equals("Elekid"))
				super.changerNom(id);
			System.out.println(getAfficherId() + " ! ");
			super.evolution();
		}
	}

}
