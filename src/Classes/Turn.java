package Classes;

import java.util.ArrayList; // import the ArrayList class
import java.util.Scanner;
import java.util.Random;

public class Turn {
	
	ArrayList<Creatures> jogo = new ArrayList<Creatures>();
	
	Scanner scan = new Scanner(System.in);
	Random rand = new Random();
	
	
	public void check(Creatures c) {
		if(c instanceof Perso) {
			if(((Perso)c).effects != null) {
				for(int i = 0;i < (((Perso)c).effects).size(); i++) {
					if(((Perso)c).effects.get(i).turns == 0) {
						((Perso)c).effects.get(i).removePerso((Perso)c);
					}else {
						((Perso)c).effects.get(i).turns = ((Perso)c).effects.get(i).turns - 1;
					}
				}
			}
		}
	}
	
	public void start(Perso p, Perso q, Perso r, Mob a, Mob b) {
		if(p.vel >= q.vel) {
			if(q.vel >= r.vel) { // p > q > r
				jogo.add(p);
				jogo.add(q);
				jogo.add(r);
			}else { // p > r > q
				jogo.add(p);
				jogo.add(r);
				jogo.add(q);
			}
		}else if(q.vel >= r.vel) {
			if(p.vel >= r.vel) { // q > p > r
				jogo.add(q);
				jogo.add(p);
				jogo.add(r);
			}else { // q > r > p
				jogo.add(q);
				jogo.add(r);
				jogo.add(p);
			}
		}else {
			if(p.vel >= q.vel) { // r > p > q
				jogo.add(r);
				jogo.add(p);
				jogo.add(q);
			}else { // r > q > p
				jogo.add(r);
				jogo.add(q);
				jogo.add(p);
			}
			
		}
		
		if(a.vel >= b.vel) {
			jogo.add(a);
			jogo.add(b);
		}else {
			jogo.add(b);
			jogo.add(a);
		}
		
		int i = 0;
		for(i = 0; i < jogo.size(); i++) {
			Creatures aux = jogo.get(i);
			if(aux instanceof Perso) {  // verifica se o personagem ta morto, se estiver, remove do jogo
				if(((Perso)aux).pa <= 0) {
					jogo.remove(i);
				}
				System.out.println("O personagem é: " + ((Perso) aux).name + " escolha o que fazer.");
				System.out.println("1 - atacar \n2 - skill");
				int choice = scan.nextInt();
				switch (choice) {
					case 1:  // atacar um inimigo
						System.out.println("Escolha o inimigo: ");
						System.out.println("1 - " + a.name);
						System.out.println("2 - " + b.name);
						choice = scan.nextInt();
						if(choice == 1) {
							((Perso) aux).atacar(a);
						}else if(choice == 2) {
							((Perso) aux).atacar(b);
						}
						break;
					case 2:
						if(aux instanceof Healer) {
							System.out.println("Escolha o aliado: ");
							System.out.println("1 - " + p.name);
							System.out.println("2 - " + q.name);
							System.out.println("3 - " + r.name);
							choice = scan.nextInt();
							if(choice == 1) {
								((Healer) aux).skill(p);
							}else if(choice == 2) {
								((Healer) aux).skill(q);
							}else if(choice == 3) {
								((Healer) aux).skill(r);
							}
						}else {
							System.out.println("Escolha o inimigo: ");
							System.out.println("1 - " + a.name);
							System.out.println("2 - " + b.name);
							choice = scan.nextInt();
							if(choice == 1) {
								((Archer) aux).skill(a);
							}else if(choice == 2) {
								((Archer) aux).skill(b);
							}
						}
						break;
				}
			}else {
				if(((Mob)aux).pv <= 0) { // verifica se o monstro ta morto, se estiver, remove do jogo
					jogo.remove(i);
				}else {
					int x = p.agro + q.agro + r.agro;
					int value = rand.nextInt(x); // um numero entre 0 e x-1;
				
					if(value >= 0 && value < p.agro) {
						((Mob) aux).atack(p);
					}else if(value >= p.agro && value < (p.agro + q.agro)) {
						((Mob) aux).atack(q);
					}else {
						((Mob) aux).atack(r);
					}
				}
			}
			
			System.out.println("------------------------------------------------");
		}
		
	}
}
