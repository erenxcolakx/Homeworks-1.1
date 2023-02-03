public class Payroll {
	private int workHour;
	private int itemCount;
	/*Payroll payroll = new Payroll(8,15);
	o Here, the payroll will be created for the 8 hours of working 
	and 15 produced items.*/	
	public Payroll(int workHour,int itemCount) {
		this.itemCount=itemCount;
		this.workHour=workHour;
	}
	Payroll(){
	}
	public int calculateSalary() {
		int salary=workHour*30 + itemCount*20;
		return salary;
	}
	public String toString() {
		return "The work hour is "+workHour+" and the produced item count is "+itemCount;
	}
}
// Eren Çolak - 150121015