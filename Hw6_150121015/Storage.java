public class Storage {
	private int capacity;
	private Item[] items;
	int size=1;
	Storage(int capacity) {
		this.capacity=capacity;
	}
	public void addItem(Item item) {
		this.items = new Item[size];
		items[size-1] = item;
		size++;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public Item[] getItems() {
		return items;
	}
	public void setItems(Item[] items) {
		this.items = items;
	}
}
// Eren Çolak - 150121015