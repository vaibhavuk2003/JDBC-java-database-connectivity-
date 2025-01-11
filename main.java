package myPackage;



public class Main {

	public static void main(String[] args) {
		Employee  E=new Employee();
	    E.CreateDB();
		E.CreateTable();
		E.InsertIntoTable("rohan",2 ,100000);
		E.Update(1,"vaibhav");
		E.Update(2,"nikhil");
		E.delete(2);
		E.ShowData();
	}

}
