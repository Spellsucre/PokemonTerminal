public class Carapuce extends Eau{
	private static int cpt=1;

	public Carapuce(String nom, int pvmax, int attaque, int speed, int niveau) {
		super(nom, pvmax, attaque, speed, niveau);
		id="Carapuce";
	}
	
	public Carapuce(String nom, int pvmax, int attaque, int speed) {
		this(nom, pvmax, attaque, speed, 1);
	}
	
	public Carapuce() {
		this("Carapuce"+cpt, 200+(int)(Math.random()*50), 70+(int)(Math.random()*30), 100+(int)(Math.random()*10));
		cpt++;
	}
	
	public void talent(){
		if (pv*3<=pvmax && !talentactif){
			multiplicateur+=0.5;
			System.out.println("\t\t\t\t"+getAfficherNom() + " n'a rien a perdre ! ");
		}
		else if(pv*3>=pvmax && talentactif)
			talentactif=false;
	}
	
	public void evolution(){
		if(niveau>=7 && id.equals("Carapuce")){
			System.out.println("Quoi ?"+getAfficherNom()+" évolue?");
			System.out.println("...");
			System.out.println("...");
			System.out.println("...");
			System.out.print("Félicitations ! Votre " + getAfficherNom() + " a évolué en ");
			evolution=true;
			super.changerId("Carabaffe");
			if(!nomPerso)
				super.changerNom(id+cpt);
			else if(nom.equals("Carapuce"))
				super.changerNom(id);
			System.out.println(id + " ! ");
			super.evolution();
		}
		if(niveau>=15 && id.equals("Carabaffe")){
			System.out.println("Quoi ?"+getAfficherNom()+" évolue?");
			System.out.println("...");
			System.out.println("...");
			System.out.println("...");
			System.out.print("Félicitations ! Votre " + getAfficherNom() + " a évolué en ");
			evolution=true;
			super.changerId("Tortank");
			if(!nomPerso)
				super.changerNom(id+cpt);
			else if(nom.equals("Carabaffe"))
				super.changerNom(id);
			System.out.println(getAfficherId() + " ! ");
			super.evolution();
		}
	}

}
