public class Poissirene extends Eau{
	private static int cpt=1;

	public Poissirene(String nom, int pvmax, int attaque, int speed, int niveau) {
		super(nom, pvmax, attaque, speed, niveau);
		id="Poissirene";
	}
	
	public Poissirene(String nom, int pvmax, int attaque, int speed) {
		this(nom, pvmax, attaque, speed, 1);
	}
	
	public Poissirene() {
		this("Poissirene"+cpt, 160+(int)(Math.random()*50), 65+(int)(Math.random()*30), 90+(int)(Math.random()*10));
		cpt++;
	}
	
	public void talent(){
		if(pv<pvmax){
			pv=pv+pvmax/10;
			if(pv>pvmax)
				pv=pvmax;
			System.out.println("\t\t\t\t" +getAfficherNom() + " se sent un peu mieux ! (" + pv + "/" + pvmax + " pvs)");
		}
	}
	
	public void evolution(){
		if(niveau>=10 && id.equals("Poissirene")){
			System.out.println("Quoi ? "+getAfficherNom()+" évolue?");
			System.out.println("...");
			System.out.println("...");
			System.out.println("...");
			System.out.print("Félicitations ! Votre " + getAfficherNom() + " a évolué en ");
			evolution=true;
			super.changerId("Poissoroy");
			if(!nomPerso)
				super.changerNom(id+cpt);
			else if(nom.equals("Poissirene"))
				super.changerNom(id);
			System.out.println(getAfficherId() + " ! ");
			super.evolution();
		}
	}

}
