public class Ramoloss extends Eau{
	private static int cpt=1;

	public Ramoloss(String nom, int pvmax, int attaque, int speed, int niveau) {
		super(nom, pvmax, attaque, speed, niveau);
		id="Ramoloss";
	}
	
	public Ramoloss(String nom, int pvmax, int attaque, int speed) {
		this(nom, pvmax, attaque, speed, 1);
	}
	
	public Ramoloss() {
		this("Ramoloss"+cpt, 220+(int)(Math.random()*50), 55+(int)(Math.random()*30), 80+(int)(Math.random()*10));
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
		if(niveau>=10 && id.equals("Ramoloss")){
			System.out.println("Quoi ? "+getAfficherNom()+" évolue?");
			System.out.println("...");
			System.out.println("...");
			System.out.println("...");
			System.out.print("Félicitations ! Votre " + getAfficherNom() + " a évolué en ");
			evolution=true;
			super.changerId("Flagadoss");
			if(!nomPerso)
				super.changerNom(id+cpt);
			else if(nom.equals("Ramoloss"))
				super.changerNom(id);
			System.out.println(getAfficherId() + " ! ");
			super.evolution();
		}
	}

}
