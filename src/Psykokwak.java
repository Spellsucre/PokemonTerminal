public class Psykokwak extends Eau{
	private static int cpt=1;

	public Psykokwak(String nom, int pvmax, int attaque, int speed, int niveau) {
		super(nom, pvmax, attaque, speed, niveau);
		id="Psykokwak";
	}
	
	public Psykokwak(String nom, int pvmax, int attaque, int speed) {
		this(nom, pvmax, attaque, speed, 1);
	}
	
	public Psykokwak() {
		this("Psykokwak"+cpt, 180+(int)(Math.random()*50), 60+(int)(Math.random()*30), 90+(int)(Math.random()*10));
		cpt++;
	}
	
	public void talent(){
		if(Math.random()<0.1){
			System.out.println("\t\t\t\t" +getAfficherNom() + " a une migraine ! ");
			multiplicateur*=2.5;
		}
	}
	
	public void evolution(){
		if(niveau>=10 && id.equals("Psykokwak")){
			System.out.println("Quoi ? "+getAfficherNom()+" évolue?");
			System.out.println("...");
			System.out.println("...");
			System.out.println("...");
			System.out.print("Félicitations ! Votre " + getAfficherNom() + " a évolué en ");
			evolution=true;
			super.changerId("Akwakwak");
			if(!nomPerso)
				super.changerNom(id+cpt);
			else if(nom.equals("Psykokwak"))
				super.changerNom(id);
			System.out.println(getAfficherId() + " ! ");
			super.evolution();
		}
	}

}
