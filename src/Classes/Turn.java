package Classes;

import java.util.ArrayList; // import the ArrayList class
import java.util.Collections;
import java.util.Scanner;
import java.util.Random;

public class Turn {
	
	ArrayList<Perso> game = new ArrayList<Perso>();
	ArrayList<Mob> mob = new ArrayList<Mob>();
	
	Scanner scan = new Scanner(System.in);
	Random rand = new Random();
	
	
	public void check(Perso c) {
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
	
	
	// inicialisando a lista inicial com os personagens
	
	public void start(Perso ...persos) {
		for(Perso item: persos) {
			game.add(item);
		}
		
		Collections.sort(game);
		
	}
	
	public void start(Mob ...mobs) {
		for(Mob item: mobs) {
			mob.add(item);
		}
		Collections.sort(mob);
	}
	
	public void addGame(Perso p) {
		p.ap = 10000/p.max_vel;
		game.add(p);
		Collections.sort(game);
	}
	
	public void addGame(Mob m) {
		m.ap = 10000/m.vel;
		mob.add(m);
		Collections.sort(mob);
	}
	
	public void removeGame() {
		
		Perso aux;
		Mob other;
		
		aux = game.get(0);
		other = mob.get(0);
		
		if(aux.ap <= other.ap) {
			game.remove(0);
			
			for(int i = 0; i < game.size(); i++) {
				game.get(i).ap -= aux.ap;
			}
			for(int i = 0; i < mob.size(); i++) {
				mob.get(i).ap -= aux.ap;
			}
			Collections.sort(game);
			this.addGame(aux);
		}else {
			mob.remove(0);
			
			for(int i = 0; i < game.size(); i++) {
				game.get(i).ap -= other.ap;
			}
			for(int i = 0; i < mob.size(); i++) {
				mob.get(i).ap -= other.ap;
			}
			Collections.sort(mob);
			this.addGame(other);
		}
		
		
		
	}
	
	public void printGame() {
		
		Perso aux;
		Mob other;
		
		int j = 0;
		int k = 0;
		
		
		
		while(j < game.size() && k < mob.size()) {
			aux = game.get(j);
			other = mob.get(k);
			
			if(aux.ap <= other.ap) {
				System.out.print(game.get(j).name + " ==== ");
				System.out.println(game.get(j).ap);
				System.out.println(game.get(j).vel);
				j++;
			}else {
				System.out.print(mob.get(k).name + " ==== ");
				System.out.println(mob.get(k).ap);
				System.out.println(mob.get(k).vel);
				k++;
			}
			
		}
		
		
		
		for(int tam = j;tam < game.size(); tam++) {
			System.out.print(game.get(tam).name + " ==== ");
			System.out.println(game.get(tam).ap);
			System.out.println(game.get(tam).vel);
		}
		
		for(int tam = k;tam < mob.size(); tam++) {
			System.out.print(mob.get(tam).name + " ==== ");
			System.out.println(mob.get(tam).ap);
			System.out.println(mob.get(tam).vel);
		}
		
	}
	
	public void playGame(Mob m) {
		
	}
	
	public void playGame(Perso p) {
		
	}
	
/*	public void start(Perso p, Perso q, Perso r, Mob a, Mob b) {
		
		inutil -------------------------------------------------
		
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
		
		----------------------------------------------------------------------
		
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
		
	}*/
}
