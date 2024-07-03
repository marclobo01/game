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
	
	
	// Coisas para fazer depois
	
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
	
	// criando a lista dos mobs
	
	public void start(Mob ...mobs) {
		for(Mob item: mobs) {
			mob.add(item);
		}
		Collections.sort(mob);
	}
	
	// funções que adicionam os personagens e os mobs nas listas
	
	public void addGame(Perso p) {
		if(p.pv > 0) {
			p.ap = 10000/p.max_vel;
			game.add(p);
			Collections.sort(game);
		}else {
			System.out.println(p.name + "morreu");
		}
		
	}
	
	public void addGame(Mob m) {
		if(m.pv > 0) {
			m.ap = 10000/m.vel;
			mob.add(m);
			Collections.sort(mob);
		}else {
			System.out.println(m.name + " morreu");
		}
		
	}
	
	// vai percorrendo as duas listas
	// a criatura removida vai tomar ação
	
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
			
			printGame();
			aux.ap = 0;
			printa(aux);
			
			playGame(aux);
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
			
			printGame();
			other.ap = 0;
			printa(other);
			
			playGame(other);
			this.addGame(other);
		}
		
		
		
	}
	
	// printa o jogo
	
	public void printGame() {
		
		Perso aux;
		Mob other;
		
		int j = 0;
		int k = 0;
		
		
		
		while(j < game.size() && k < mob.size()) {
			aux = game.get(j);
			other = mob.get(k);
			
			if(aux.ap <= other.ap) {
				printa(aux);
				j++;
			}else {
				printa(other);
				k++;
			}
			
		}
		
		// como uma lista é maior q a outra, termina de printar os itens q faltavam
		
		for(int tam = j;tam < game.size(); tam++) {
			printa(game.get(tam));
		}
		
		for(int tam = k;tam < mob.size(); tam++) {
			printa(mob.get(tam));
		}
		
		System.out.println("\n --------------------\n");
		
	}
	
	// funções que fazem personagens e mobs jogarem
	
	public void playGame(Mob m) {
		
		int x = 0;
		Perso p;
		
		for(int i = 0; i < game.size(); i++) {
			p = game.get(i);
			x += p.agro;
		}
		
		int value = rand.nextInt(x);
		
		if(value >= 0 && value < game.get(0).agro) {
			m.atack(game.get(0));
		}else if(value < game.get(0).agro + game.get(1).agro) {
			m.atack(game.get(1));
		}else {
			m.atack(game.get(2));
		}
		
		
		/*
		int x = p.agro + q.agro + r.agro;
		int value = rand.nextInt(x); // um numero entre 0 e x-1;
	
		if(value >= 0 && value < p.agro) {
			((Mob) aux).atack(p);
		}else if(value >= p.agro && value < (p.agro + q.agro)) {
			((Mob) aux).atack(q);
		}else {
			((Mob) aux).atack(r);
		}
		
		*/
		
	}
	
	public void playGame(Perso p) {
		
		System.out.println("Escolha o que " + p.name +" quer usar: ");
		System.out.println("1 - atq basico");
		System.out.println("2 - skill");
		
		int choice = scan.nextInt();
		
		Mob m;
		Perso n;
		
		switch (choice){
		case 1:
			System.out.println("Escolha quem atacar: ");
			for(int i = 0;i < mob.size();i++) {
				m = mob.get(i);
				System.out.println(i + ":" + m.name );
			}
			
			choice = scan.nextInt();
			
			m = mob.get(choice);
			
			p.atacar(m);
			if(m.pv <= 0) {
				mob.remove(m);
			}
			
			break;
			
		case 2:
			if(p instanceof Healer) {
				
				System.out.println("Escolha em quem usar");
				for(int i = 0; i< game.size();i++) {
					n = game.get(i);
					System.out.println(i + ":" + n.name);
				}
				
				System.out.println(game.size() + ":" + p.name);
				
				
				choice = scan.nextInt();
				
				if(choice == game.size()) {
					p.skill(p);
				}else {
					n = game.get(choice);
					
					p.skill(n);
				}
				
			
				
				
			}else if(p instanceof Archer) {
				System.out.println("Escolha quem atacar: ");
				for(int i = 0;i < mob.size();i++) {
					m = mob.get(i);
					System.out.println(i + ":" + m.name );
				}
				
				choice = scan.nextInt();
				
				m = mob.get(choice);
				
				p.skill(m);
				if(m.pv <= 0) {
					mob.remove(m);
				}
			}
			
			break;
		}
		
	}
	
	// chama jogar e remover em loop
	
	public void loop() {
		
		while(game.size() != 0 && mob.size() != 0) {
			removeGame();
		}
		
		System.out.println("O combate acabou: FIM");
		
		
	}
	
	public void printa(Perso p) {
		System.out.println(p.name + ": \n" + "Vida: " + p.pv + " de " + p.max_pv + "\nValor de ação: " + p.ap + "\n -----------");
	}
	
	public void printa(Mob p) {
		System.out.println(p.name + ": \n" + "Vida: " + p.pv + " de " + p.max_pv + "\nValor de ação: " + p.ap + "\n -----------");
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
		
		-----------------------------------------------------------------------
		
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
