package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Employee> list = new ArrayList<>();
		
		System.out.print("Haw many employee will registed? ");
		int N = sc.nextInt();
		
		for (int i = 1; i < N; i++) {
			System.out.println("Employee #" +i+": ");
			System.out.print("Id ");
			int id = sc.nextInt();
			while (hasId(list, id)) {
				System.out.println("Id invalid");
			}
			System.out.print("Name :");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.println("Salary: ");
			Double salary = sc.nextDouble();
			list.add(new Employee(id, name, salary));
			
		}
		System.out.println("Enter the Employee for salary increase :");
		int id = sc.nextInt();
		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		
		if (emp == null) {
			System.out.println("this Id does not existed ");
		}
		else {
		System.out.println("Enter the percentag :");
		Double percent = sc.nextDouble();
		emp.increaseSalary(percent);		
	}		
	System.out.println();
	System.out.println("List of Employees: ");
	for (Employee obj : list ) {
		System.out.println(obj);
	}
	
		sc.close();
	}
	public static boolean hasId(List<Employee> list, int id) {
		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;
	}
}
