public class Kokiyas extends Eau{
	private static int cpt=1;

	public Kokiyas(String nom, int pvmax, int attaque, int speed, int niveau) {
		super(nom, pvmax, attaque, speed, niveau);
		id="Kokiyas";
	}
	
	public Kokiyas(String nom, int pvmax, int attaque, int speed) {
		this(nom, pvmax, attaque, speed, 1);
	}
	
	public Kokiyas() {
		this("Kokiyas"+cpt, 200+(int)(Math.random()*50), 55+(int)(Math.random()*30), 90+(int)(Math.random()*10));
		cpt++;
	}
	
	public void talent(){
	}

	public void subire(Adversaire adversaire, int degats){
		degats*=0.85;
		super.subire(adversaire, degats);
	}
	
	public void evolution(){
		if(niveau>=10 && id.equals("Kokiyas")){
			System.out.println("Quoi ? "+getAfficherNom()+" évolue?");
			System.out.println("...");
			System.out.println("...");
			System.out.println("...");
			System.out.print("Félicitations ! Votre " + getAfficherNom() + " a évolué en ");
			evolution=true;
			super.changerId("Crustabri");
			if(!nomPerso)
				super.changerNom(id+cpt);
			else if(nom.equals("Kokiyas"))
				super.changerNom(id);
			System.out.println(getAfficherId() + " ! ");
			super.evolution();
		}
	}

}
