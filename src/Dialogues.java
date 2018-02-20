public class Dialogues{
	
	public static void randomDialogues(Dresseur D){
		int i = (int)(Math.random()*20);
		switch(i){
		case 0:
				System.out.println("["+D.getNom()+"] "+"C'est l'heure du DU-DU-DU-DU-DU-DUEEL !!!");
				break;
		case 1:
				System.out.println("["+D.getNom()+"] "+"LEEEEEEROOOOOOY JENKINS !!!");
				break;
		case 2:
				System.out.println("["+D.getNom()+"] "+"Omae wa mo shindeiru.");
				System.out.println("[Vous] "+"Nani?");
				break;
		case 3:
				System.out.println("["+D.getNom()+"] "+"Juste une fois au chalet !");
				break;
		case 4:
				System.out.println("["+D.getNom()+"] "+"C'est pour... le travail.");
				break;
		case 5:
				System.out.println("["+D.getNom()+"] "+"Je vais faire caca chez Paul !");
				break;
		case 6:
				System.out.println("["+D.getNom()+"] "+"VOUS...NE PASSEREZ...PAAAS !");
				break;
		case 7:
				System.out.println("["+D.getNom()+"] "+"Sega, c'est plus fort que toi.");
				break;
		case 8:
				System.out.println("["+D.getNom()+"] "+"Eh, tire sur mon doigt ! ");
				System.out.println("[Vous] "+"*tire*");
				break;
		case 9:
				System.out.println("["+D.getNom()+"] "+"Je suis... ton père.");
				break;
		case 10:
				System.out.println("["+D.getNom()+"] "+"Mon coup n'est pas fatal, mais je fais parfois mal... souvent je suis dressé, et sent bon la marée.. Quiii suiiiss je ?");
				System.out.println("[Vous] "+" Un phare breton ?");
				System.out.println("["+D.getNom()+"] "+"Perdu, c'est ma b*** ! ");
				break;
		case 11:
				System.out.println("["+D.getNom()+"] "+"C'est la congolexicomatisation des lois du marché !");
				break;
		case 12:
				System.out.println("["+D.getNom()+"] "+"...");
				break;
		case 13:
				System.out.println("["+D.getNom()+"] "+"Stupide hobbit joufflu !");
				break;
		case 14:
				System.out.println("["+D.getNom()+"] "+"All your bases are belong to us !");
				break;
		case 15:
				System.out.println("["+D.getNom()+"] "+"Avant j'étais aventurier, mais j'ai pris une fleche dans le genoux.");
				break;
		case 16:
				System.out.println("["+D.getNom()+"] "+"NYAN NYAN NYAN NYAN NYAN NYAN NYAN NYAN NYAN NYAN NYAN NYAN");
				break;
		case 17:
				System.out.println("["+D.getNom()+"] "+"I see dead people... everywhere (°-°)");
				break;
		case 18:
				System.out.println("["+D.getNom()+"] "+"SASUUKEEEEEE!!!");
				System.out.println("[Vous]"+"NARUUTOOOOOO!!!");
				break;
		case 19:
				System.out.println("["+D.getNom()+"] "+"Ye... veu..des...chaussUUUres");
				break;
		}
	}
}
