package main;

import Classes.Archer;
import Classes.Healer;
import Classes.Mob; // vida atq def
import Classes.Perso; // vida atq vel def

public class main {

	public static void main(String[] args) {
		
		Perso p = new Perso("Paulo",1000,120,100,200);
		
		Mob m = new Mob("goblin",3000,120,300);
		
		p.atacar(m);
		
		Perso a = new Archer("Legolas",750, 160, 120, 150);
		
		a.atacar(m);
		
		Perso h = new Healer("Falin",1500,90,150,125);
		
		h.skill(a);
		
		a.skill(m);
		
		m.atack(h);
		
		h.skill(h);
		
		m.atack(a);
		
		h.skill(a);
	}

}
