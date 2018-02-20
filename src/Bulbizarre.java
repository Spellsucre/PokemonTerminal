public class Bulbizarre extends Herbe{
	private static int cpt=1;

	public Bulbizarre(String nom, int pvmax, int attaque, int speed, int niveau) {
		super(nom, pvmax, attaque, speed, niveau);
		id="Bulbizarre";
		talentactif=false;
	}
	
	public Bulbizarre(String nom, int pvmax, int attaque, int speed) {
		this(nom, pvmax, attaque, speed, 1);
	}

	public Bulbizarre() {
		this("Bulbizarre"+cpt, 220+(int)(Math.random()*50), 60+(int)(Math.random()*30), 90+(int)(Math.random()*10));
		cpt++;
	}
	
	public void talent(){
		if (pv*3<pvmax && !talentactif){
			multiplicateur+=0.5;
			System.out.println("\t\t\t\t"+getAfficherNom() + " n'a rien a perdre ! ");
			talentactif=true;
		}
		else if(pv*3>=pvmax && talentactif)
			talentactif=false;
	}
	
	public void evolution(){
		if(niveau>=7 && id.equals("Bulbizarre")){
			System.out.println("Quoi ?"+getAfficherNom()+" évolue?");
			System.out.println("...");
			System.out.println("...");
			System.out.println("...");
			System.out.print("Félicitations ! Votre " + getAfficherNom() + " a évolué en ");
			evolution=true;
			super.changerId("Herbizarre");
			if(!nomPerso)
				super.changerNom(id+cpt);
			else if(nom.equals("Bulbizarre"))
				super.changerNom(id);
			System.out.println(id + " ! ");
			super.evolution();
		}
		if(niveau>=15 && id.equals("Herbizarre")){
			System.out.println("Quoi ?"+getAfficherNom()+" évolue?");
			System.out.println("...");
			System.out.println("...");
			System.out.println("...");
			System.out.print("Félicitations ! Votre " + getAfficherNom() + " a évolué en ");
			evolution=true;
			super.changerId("Florizarre");
			if(!nomPerso)
				super.changerNom(id+cpt);
			else if(nom.equals("Herbizarre"))
				super.changerNom(id);
			System.out.println(getAfficherId() + " ! ");
			super.evolution();
		}
	}

} 
