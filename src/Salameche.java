public class Salameche extends Feu{
	private static int cpt=1;

	public Salameche(String nom, int pvmax, int attaque, int speed, int niveau) {
		super(nom, pvmax, attaque, speed, niveau);
		talentactif=false;
		id="Salameche";
	}
	
	public Salameche(String nom, int pvmax, int attaque, int speed) {
		this(nom, pvmax, attaque, speed,1);
	}
	
	public Salameche() {
		this("Salameche"+cpt, 180+(int)(Math.random()*50), 80+(int)(Math.random()*30), 105+(int)(Math.random()*10));
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
		if(niveau>=7 && id.equals("Salameche")){
			System.out.println("Quoi ?"+getAfficherNom()+" évolue?");
			System.out.println("...");
			System.out.println("...");
			System.out.println("...");
			System.out.print("Félicitations ! Votre " + getAfficherNom() + " a évolué en ");
			evolution=true;
			super.changerId("Reptincel");
			if(!nomPerso)
				super.changerNom(id+cpt);
			else if(nom.equals("Salameche"))
				super.changerNom(id);
			System.out.println(getAfficherId() + " ! ");
			super.evolution();
		}
		if(niveau>=15 && id.equals("Reptincel")){
			System.out.println("Quoi ?"+getAfficherNom()+" évolue?");
			System.out.println("...");
			System.out.println("...");
			System.out.println("...");
			System.out.print("Félicitations ! Votre " + getAfficherNom() + " a évolué en ");
			evolution=true;
			super.changerId("Dracaufeu");
			if(!nomPerso)
				super.changerNom(id+cpt);
			else if(nom.equals("Reptincel"))
				super.changerNom(id);
			System.out.println(id + " ! ");
			super.evolution();
		}
	}

}
