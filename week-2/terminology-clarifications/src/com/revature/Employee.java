package com.revature;

public class Employee {
	
	public int age;
	public String name;
	public int salary;
	
	public Employee(int age, String name, int salary) {
		this.age = age;
		this.name = name;
		this.salary = salary;
	}
	
	public void changeSalaryandName(int s, String name) {
		changeName(name);
		changeSalary(s);
	}
	
	public void changeSalary(int s) {
		this.salary = s;
	}
	
	public void changeName(String name) {
		this.name = name;
	}
	
	public static void main(String[] args) {
		//int i = 10;
		
		Employee.changeCeo("Ashwin");
		
		System.out.println(Employee.ceoName);
		
		Employee e1 = new Employee(50, "John", 75000);
		Employee e2 = new Employee(45, "Quinn", 60000);
		Employee e3 = new Employee(40, "Jim", 65000);
		
		System.out.println(e1);
		System.out.println(e2);
		System.out.println(e3);
		
		e1.changeSalary(100000);
		e2.changeSalary(50000);
		e3.changeSalaryandName(80000, "Jymm");
		
		System.out.println(e1);
		System.out.println(e2);
		System.out.println(e3);
		
		Employee.ceoName = "Bob";
		
		System.out.println(e1.ceoName);
		System.out.println(e2.ceoName);
		System.out.println(e3.ceoName);
		
		Employee.changeCeo("Bill");
		
		System.out.println(e1.ceoName);
		System.out.println(e2.ceoName);
		System.out.println(e3.ceoName);
		
		e1.ceoName = "Jane";
		
		System.out.println(e1.ceoName);
		System.out.println(e2.ceoName);
		System.out.println(e3.ceoName);
		
	}
	
	
	@Override
	public String toString() {
		return "Employee [age=" + age + ", name=" + name + ", salary=" + salary + "]";
	}


	public static String ceoName;
	
	public static void changeCeo(String name) {
		Employee.ceoName = name;
	}
}
