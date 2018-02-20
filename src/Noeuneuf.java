public class Noeuneuf extends Herbe{
	private static int cpt=1;

	public Noeuneuf(String nom, int pvmax, int attaque, int speed, int niveau) {
		super(nom, pvmax, attaque, speed, niveau);
		id="Noeuneuf";
	}
	
	public Noeuneuf(String nom, int pvmax, int attaque, int speed) {
		this(nom, pvmax, attaque, speed,1);
	}

	public Noeuneuf() {
		this("Noeuneuf"+cpt, 210+(int)(Math.random()*50), 50+(int)(Math.random()*30), 90+(int)(Math.random()*10));
		cpt++;
	}
	
	public void talent(){
	if(pv*2<pvmax && !talentactif){
		pv+=pvmax/2;
		System.out.println("\t\t\t\t" +getAfficherNom()+ " puise dans ses réserves ! ");
		talentactif=true;
		}
	}
	
	public void evolution(){
		if(niveau>=10 && id.equals("Noeuneuf")){
			System.out.println("Quoi ? "+getAfficherNom()+" évolue?");
			System.out.println("...");
			System.out.println("...");
			System.out.println("...");
			System.out.print("Félicitations ! Votre " + getAfficherNom() + " a évolué en ");
			evolution=true;
			super.changerId("Noadkoko");
			if(!nomPerso)
				super.changerNom(id+cpt);
			else if(nom.equals("Noeuneuf"))
				super.changerNom(id);
			System.out.println(getAfficherId() + " ! ");
			super.evolution();
		}
	}

}
