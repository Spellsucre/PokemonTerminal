public class Magicarpe extends Eau{
	private static int cpt=1;

	public Magicarpe(String nom, int pvmax, int attaque, int speed, int niveau) {
		super(nom, pvmax, attaque, speed, niveau);
		id="Magicarpe";
	}
	
	public Magicarpe(String nom, int pvmax, int attaque, int speed) {
		this(nom, pvmax, attaque, speed, 1);
	}
	
	public Magicarpe() {
		this("Magicarpe"+cpt, 100+(int)(Math.random()*30), 35+(int)(Math.random()*25), 80+(int)(Math.random()*10));
		cpt++;
	}
	
	public void talent(){
	}
	
	public void attaque(Pokemon adversaire, String choixAttaque){
		if(id.equals("Magicarpe")){
			multiplicateur=0;
			System.out.println("\t\t\t\t" +getAfficherNom() + " barbote ! ");
			super.attaque(adversaire, "Trempette");
		}	
		else{
			if(Math.random()<0.5){
				if(!stun){
					multiplicateur*=2;
					System.out.println("\t\t\t\t" +getAfficherNom() + " est enragé ! ");
					super.attaque(adversaire, choixAttaque);
					stun=true;
				}
			}
			else
				super.attaque(adversaire, choixAttaque);
		}
	}
	
	public void evolution(){
		if((niveau>=20 || bonbonRage) && id.equals("Magicarpe")){
			System.out.println("Quoi ? "+getAfficherNom()+" évolue?");
			System.out.println("...");
			System.out.println("...");
			System.out.println("...");
			System.out.print("Félicitations ! Votre " + getAfficherNom() + " a évolué en ");
			evolution=true;
			super.changerId("Leviator");
			if(!nomPerso)
				super.changerNom(id+cpt);
			else if(nom.equals("Magicarpe")){
				super.changerNom(id);
			}
			System.out.println(getAfficherId() + " ! ");
			attaque*=2;
			pvmax*=1.5;
			speed+=15;
			super.evolution();
		}
	}

}
