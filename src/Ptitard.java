public class Ptitard extends Eau{
	private static int cpt=1;

	public Ptitard(String nom, int pvmax, int attaque, int speed, int niveau) {
		super(nom, pvmax, attaque, speed, niveau);
		id="Ptitard";
	}
	
	public Ptitard(String nom, int pvmax, int attaque, int speed) {
		this(nom, pvmax, attaque, speed, 1);
	}
	
	public Ptitard() {
		this("Ptitard"+cpt, 140+(int)(Math.random()*50), 55+(int)(Math.random()*30), 90+(int)(Math.random()*10));
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
		if(niveau>=7 && id.equals("Ptitard")){
			System.out.println("Quoi ?"+getAfficherNom()+" évolue?");
			System.out.println("...");
			System.out.println("...");
			System.out.println("...");
			System.out.print("Félicitations ! Votre " + getAfficherNom() + " a évolué en ");
			evolution=true;
			super.changerId("Tetarte");
			if(!nomPerso)
				super.changerNom(id+cpt);
			else if(nom.equals("Ptitard"))
				super.changerNom(id);
			System.out.println(id + " ! ");
			super.evolution();
		}
		if(niveau>=15 && id.equals("Tetarte")){
			System.out.println("Quoi ?"+getAfficherNom()+" évolue?");
			System.out.println("...");
			System.out.println("...");
			System.out.println("...");
			System.out.print("Félicitations ! Votre " + getAfficherNom() + " a évolué en ");
			evolution=true;
			super.changerId("Tartard");
			if(!nomPerso)
				super.changerNom(id+cpt);
			else if(nom.equals("Tetarte"))
				super.changerNom(id);
			System.out.println(getAfficherId() + " ! ");
			super.evolution();
		}
	}
}
