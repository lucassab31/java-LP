
public class File extends LecteurFichier {
	private String name;
	public File(String name) {
		super();
		this.name = name;
	}

	public String write(){
		boolean test = super.open(name);
		String contain = "";
		if(test){
			super.read();
			for(int a = 0; a<text.size();a++){
				contain += text.get(a);
			}
			return contain;
			
		}else {
			return "fichier incorrect";
		}
	}
	
	public void compare(File f) {
		String text = this.write();
		String text2 = f.write();
		
		int nb = text.compareTo(text2);
		
		if(nb==0) {
			System.out.println("Les fichiers sont identiques");
		}else {
			System.out.println("Les fichiers sont différents");
		}
	}

}

