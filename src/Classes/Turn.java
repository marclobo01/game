package Classes;

import java.util.ArrayList; // import the ArrayList class

public class Turn {
	
	ArrayList<Creatures> jogo = new ArrayList<Creatures>();
	
	
	
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
		for(i = 0; i < 5; i++) {
			Creatures aux = jogo.get(i);
			
			if(aux instanceof Perso) {
				
			}else {
				
			}
		}
		
	}
}
