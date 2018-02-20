public class Ponyta extends Feu{
	private static int cpt=1;

	public Ponyta(String nom, int pvmax, int attaque, int speed, int niveau) {
		super(nom, pvmax, attaque, speed, niveau);
		id="Ponyta";
	}
	
	public Ponyta(String nom, int pvmax, int attaque, int speed) {
		this(nom, pvmax, attaque, speed, 1);
	}
	
	public Ponyta() {
		this("Ponyta"+cpt, 160+(int)(Math.random()*50), 70+(int)(Math.random()*30), 105+(int)(Math.random()*10));
		cpt++;
	}
	
	public void talent(){
	}
	
	public void subire(Adversaire adversaire, int degats){
		if(Math.random()<0.2 && !adversaire.getCombattant().type.equals("Feu")){
			adversaire.getCombattant().brulure=true;
			System.out.println("\t\t\t\t"+adversaire.getCombattant().getAfficherNom() + " s'est brulé en attaquant ! ");
		}
		super.subire(adversaire, degats);
	}
	
	public void evolution(){
		if(niveau>=10 && id.equals("Ponyta")){
			System.out.println("Quoi ? "+getAfficherNom()+" évolue?");
			System.out.println("...");
			System.out.println("...");
			System.out.println("...");
			System.out.print("Félicitations ! Votre " + getAfficherNom() + " a évolué en ");
			evolution=true;
			super.changerId("Galopa");
			if(!nomPerso)
				super.changerNom(id+cpt);
			else if(nom.equals("Ponyta"))
				super.changerNom(id);
			System.out.println(getAfficherId() + " ! ");
			super.evolution();
		}
	}

}
