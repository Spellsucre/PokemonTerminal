public class Aspicot extends Herbe{
	private static int cpt=1;

	public Aspicot(String nom, int pvmax, int attaque, int speed, int niveau) {
		super(nom, pvmax, attaque, speed, niveau);
		id="Aspicot";
	}
	
	public Aspicot(String nom, int pvmax, int attaque, int speed) {
		this(nom, pvmax, attaque, speed, 1);
	}
	
	public Aspicot() {
		this("Aspicot"+cpt, 140+(int)(Math.random()*50), 60+(int)(Math.random()*30), 90+(int)(Math.random()*10));
		cpt++;
	}
	
	public void talent(){
		if((estParalyse()||brulure||poison) && Math.random()<0.33){
			System.out.println("\t\t\t\t" +getAfficherNom() + " a changé de peau ! ");
			paralyse=0;
			brulure=false;
			poison=false;
		}
	}
	
	public void evolution(){
		if(niveau>=5 && id.equals("Aspicot")){
			System.out.println("Quoi ? "+getAfficherNom()+" évolue?");
			System.out.println("...");
			System.out.println("...");
			System.out.println("...");
			System.out.print("Félicitations ! Votre " + getAfficherNom() + " a évolué en ");
			evolution=true;
			super.changerId("Coconfort");
			if(!nomPerso)
				super.changerNom(id+cpt);
			else if(nom.equals("Aspicot"))
				super.changerNom(id);
			System.out.println(getAfficherId() + " ! ");
			super.evolution();
		}
		if(niveau>=10 && id.equals("Coconfort")){
			System.out.println("Quoi ? "+getAfficherNom()+" évolue?");
			System.out.println("...");
			System.out.println("...");
			System.out.println("...");
			System.out.print("Félicitations ! Votre " + getAfficherNom() + " a évolué en ");
			evolution=true;
			super.changerId("Dardargnan");
			if(!nomPerso)
				super.changerNom(id+cpt);
			else if(nom.equals("Coconfort"))
				super.changerNom(id);
			System.out.println(id + " ! ");
			super.evolution();
		}
	}

}
