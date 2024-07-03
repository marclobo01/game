package main;

import Classes.Archer;
import Classes.Healer;
import Classes.Mob; // vida atq def
//import Classes.Perso; // vida atq vel def
import Classes.Turn;

public class main {

	public static void main(String[] args) {
		
		Archer arch = new Archer("Legolas", 500, 120, 160, 100, 50);
		Archer arch2 = new Archer("Lucas", 600,100,150,70,80);
		Healer heal = new Healer("Sara",900,80,120,80,60);
		
		Mob goblin = new Mob("Goblin", 900, 120, 100,130);
		Mob alf = new Mob("Ticotico", 820, 100, 50,70);
		
		Turn novo = new Turn();
		novo.start(heal, arch, arch2);
		novo.start(alf,goblin);
		
		novo.loop();
		
	}

}
