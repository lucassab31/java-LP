
public class Palindrome extends LecteurFichier {
	private String name;
	public Palindrome(String name) {
		super();
		this.name = name;
	}
	
	@Override
	public String write() {
		boolean test = super.open(name);
		if(test){
			super.read();
			String textInverse = "";
			for(int i = 0; i < text.size(); i++){
				String[] words = text.get(i).split(" ");
				for(int y = 0; y < words.length; y++){
					int taille = words[y].length();
					for(int x = taille -1; x>-1; x--)
			         {
						textInverse += words[y].substring(x, x +1);
			         }
					textInverse+= " ";
				}
				textInverse+= "";
				
			}
			return textInverse;
		}else {
			return "fichier incorrect";
		}
		
	}


}