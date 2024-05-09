package main;

import Classes.Archer;
import Classes.Healer;
import Classes.Mob; // vida atq def
import Classes.Perso; // vida atq vel def

public class main {

	public static void main(String[] args) {
		
		Perso p = new Perso(1000,120,100,200);
		
		Mob m = new Mob(3000,50,300);
		
		p.atacar(m);
		
		Perso a = new Archer(750, 160, 120, 150);
		
		a.atacar(m);
		
		Perso h = new Healer(1500,90,150,125);
		
		h.skill(a);
	}

}
