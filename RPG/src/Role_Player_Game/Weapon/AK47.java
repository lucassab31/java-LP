package Role_Player_Game.Weapon;

public class AK47 extends Weapon {

	public AK47(float p, int d) {
		super("AK47", p, d);
	}
	
	
	public String ascii_art() {
		return 
				"                         .-----------------TTTT_-----_______              \n" +
				"                       /''''''''''(______O] ----------____  \\______/]_   \n" +
				"    __...---'\"\"\"\\_ --''   Q                               ___________@\n" +
				"|'''                   ._   _______________=---------\"\"\"\"\"\"\"       \n" +
				"|                ..--''|   l L |_l   |                                    \n" +
				"|          ..--''      .  /-___j '   '                                    \n" +
				"|    ..--''           /  ,       '   '                                    \n" +
				"|--''                /           `    \\                                  \n" +
				"                     L__'         \\    -                                 \n" +
				"                                   -    '-.                               \n" +
				"                                    '.    /                               \n" +
				"                                      '-./                                \n";
	}
}