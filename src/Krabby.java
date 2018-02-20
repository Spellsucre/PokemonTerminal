public class Krabby extends Eau{
	private static int cpt=1;

	public Krabby(String nom, int pvmax, int attaque, int speed, int niveau) {
		super(nom, pvmax, attaque, speed, niveau);
		id="Krabby";
	}
	
	public Krabby(String nom, int pvmax, int attaque, int speed) {
		this(nom, pvmax, attaque, speed, 1);
	}
	
	public Krabby() {
		this("Krabby"+cpt, 160+(int)(Math.random()*50), 60+(int)(Math.random()*30), 90+(int)(Math.random()*10));
		cpt++;
	}
	
	public void talent(){
	}
	
	public void attaque(Pokemon adversaire, String choixAttaque){
		multiplicateur*=1.1;
		System.out.println("\t\t\t\t" + getAfficherNom() + " a une grosse pince ! ");
		super.attaque(adversaire, choixAttaque);
	}
	
	public void evolution(){
		if(niveau>=10 && id.equals("Krabby")){
			System.out.println("Quoi ? "+getAfficherNom()+" évolue?");
			System.out.println("...");
			System.out.println("...");
			System.out.println("...");
			System.out.print("Félicitations ! Votre " + getAfficherNom() + " a évolué en ");
			evolution=true;
			super.changerId("Krabbos");
			if(!nomPerso)
				super.changerNom(id+cpt);
			else if(nom.equals("Krabby"))
				super.changerNom(id);
			System.out.println(getAfficherId() + " ! ");
			super.evolution();
		}
	}

}
