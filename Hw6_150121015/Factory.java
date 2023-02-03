public class Factory {
	private String name;
	private double itemPrice;
	private Storage storage;
	private Employee[] employees;
	private Payroll[] payrolls;
	double total=0;
	public Factory(String name,int capacity, double itemPrice) {
		this.name = name;
		this.itemPrice = itemPrice;
		this.storage=new Storage(capacity);
		this.employees=new Employee[0];
		this.payrolls= new Payroll[0];
	}
	public double getRevenue() {
		return storage.getItems().length * itemPrice;
	}
	public double getPaidSalaries() {
		for (int i = 0; i < payrolls.length; i++) {
			total+=this.payrolls[i].calculateSalary();
		}
		return total;
	}
	boolean isCreatedAnyEmp=false;
	public void addEmployee(Employee employee) {
		isCreatedAnyEmp=true;
		Employee[] newEmp = new Employee[employees.length + 1];
		for (int i = 0; i < employees.length; i++) {
			newEmp[i]=employees[i];
		}
		newEmp[employees.length]=employee;
		this.employees = newEmp;
			
		for(Item item:employee.startShift())
			this.storage.addItem(item);
	}
	
	public Employee removeEmployee(int id) {
		Employee removedEmp = null;
		if(employees.length==0 && isCreatedAnyEmp==false) { /*I added isCreatedAnyEmp bool variable 
		because after remove all employees it should print employee doesn't exist 
		if I don't put this variable after deleting all employee object
		length would be 0 again and it prints There are no employees twice.*/
			System.out.println("There are no employees!");
		}
		else {
		for (int i = 0; i < employees.length;i++){ /*I created new array to resize the array and copied items to new one*/
			boolean idFound=false;
			Employee[] newEmp = new Employee[this.employees.length - 1];
			if(employees[i].getId()==id) {
				idFound=true;
				removedEmp=employees[i];
				employees[i]=null;
				boolean operat=false;
				for (int j = 0; j < newEmp.length; j++) {
					if((this.employees[j]==null)) {
						operat=true;
					}
					if(operat==false) {
						newEmp[j]=this.employees[j];
					}
					
					if((this.employees[j]==null)) {
						operat=true;
					}
					if(operat) { 
						newEmp[j]=this.employees[j+1];
					}
				}
				this.employees=newEmp;
				addPayroll(removedEmp.endShift());
			}
			if(isCreatedAnyEmp==true && idFound==false) { /*If I hadn't added idFound and break it 
			would have prints multiple times "employee doesn't exist" when 
			(this.employees[j]==null) isn't true */
				System.out.println("Employee does not exist!");
				break;
			}
		}
	}	return removedEmp;	
}
	private void addPayroll(Payroll payroll) {
		Payroll[] newPayroll = new Payroll[this.payrolls.length + 1];
		for (int i = 0; i < this.payrolls.length; i++) {
			newPayroll[i]=this.payrolls[i];
		}
		newPayroll[payrolls.length]=payroll;
		this.payrolls = newPayroll;
	}
}
// Eren Çolak - 150121015