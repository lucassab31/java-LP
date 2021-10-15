public class Reverse extends LecteurFichier {
	private String name;
	public Reverse(String name) {
		super();
		this.name = name;
	}

	@Override
	public String write() {
		boolean test = super.open(name);
		String contain = "";
		if(test){
			super.read();
			for(int a = text.size()-1; a >= 0;a--){
				contain += text.get(a);
			}
			return contain;
		}else {
			return "fichier incorrect";
		}
	}

}