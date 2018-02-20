public class Stari extends Eau{
	private static int cpt=1;

	public Stari(String nom, int pvmax, int attaque, int speed, int niveau) {
		super(nom, pvmax, attaque, speed, niveau);
		id="Stari";
	}
	
	public Stari(String nom, int pvmax, int attaque, int speed) {
		this(nom, pvmax, attaque, speed, 1);
	}
	
	public Stari() {
		this("Stari"+cpt, 200+(int)(Math.random()*50), 70+(int)(Math.random()*30), 80+(int)(Math.random()*10));
		cpt++;
	}
	
	public void talent(){
		if((estParalyse()||brulure||poison) && Math.random()<0.33){
			System.out.println("\t\t\t\t" +getAfficherNom() + " s'est soigné ! ");
			paralyse=0;
			brulure=false;
			poison=false;
		}
	}
	
	public void evolution(){
		if(niveau>=10 && id.equals("Stari")){
			System.out.println("Quoi ? "+getAfficherNom()+" évolue?");
			System.out.println("...");
			System.out.println("...");
			System.out.println("...");
			System.out.print("Félicitations ! Votre " + getAfficherNom() + " a évolué en ");
			evolution=true;
			super.changerId("Staross");
			if(!nomPerso)
				super.changerNom(id+cpt);
			else if(nom.equals("Stari"))
				super.changerNom(id);
			System.out.println(getAfficherId() + " ! ");
			super.evolution();
		}
	}


}
