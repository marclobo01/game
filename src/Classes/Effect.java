package Classes;

public class Effect {
	
	int id;
	int effect;
	int turns;
	
	public Effect (int id, int effect, int turns){
		this.id = id;
		this.effect = effect;
		this.turns = turns;
	}
	
	
	void applyMob(Mob m) {
		switch (this.id) {
			case 0:
				// pa
				m.pa = m.pa - (m.pa * this.effect)/100;
				break;
			case 1:
				// pd
				m.pd = m.pd - (m.pd * this.effect)/100;
				break;
				
		}
	}
	
	void applyPerso(Perso p) {
		switch (this.id) {
			case 0:
				// pa
				p.pa = p.pa + (p.pa * this.effect)/100;
				break;
			case 1:
				// pd
				p.pd = p.pd + (p.pd * this.effect)/100;
				break;
				
		}
	}
	
	void removeMob(Mob m) {
		switch (this.id) {
			case 0:
				// pa
				m.pa = m.pa;
				break;
			case 1:
				// pd
				m.pd = m.pd;
				break;
		}
	}
	
	void removePerso(Perso p) {
		switch (this.id) {
			case 0:
				// pa
				p.pa = p.max_pa;
				break;
			case 1:
				// pd
				p.pd = p.max_pd;
				break;
		}
	}
	
}
