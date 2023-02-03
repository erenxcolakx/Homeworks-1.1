public class Employee {
	private int id;
	private String name;
	private String surname;
	private int workHour;
	private int speed;
	private Payroll payroll = new Payroll();
	private Item[] items;
	public Employee() {}
	public Employee(int id, String name, String surname, int workHour, int speed) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.workHour = workHour;
		this.speed = speed;
		this.items=new Item[workHour*speed];
	}
	public Item[] startShift(){
		for (int i = 0; i < this.items.length; i++) {
			int randomNumber=(int) Math.random()*100+1;
			Item newItem=new Item(randomNumber);
			this.items[i]=newItem;
		}
		return items;
	}
	public Payroll endShift() {
		Payroll empPayroll=new Payroll(workHour, workHour*speed);
		return empPayroll;
	}
	public String toString() {
		return "This is the employee with id "+id+" speed "+speed+". The work hour is "+workHour+" and the produced item count is "+speed*workHour+".";
	}
	public int getId() {
		return id;
	}
	public int getTotalItem() {
		return workHour * speed;
	}
}
// Eren Çolak- 150121015