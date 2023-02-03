public class Item {
	private int id;
	static int numberOfItems=0;
	
	public Item(int id) {
		this.id=id;
		numberOfItems++;
	}
	Item(){
		numberOfItems++;
	}
}
//Eren Çolak - 150121015