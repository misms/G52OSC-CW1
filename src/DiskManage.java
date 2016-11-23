import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;

public class DiskManage {

	Scanner scan = new Scanner(System.in);
	FileInputStream in = null;
	
	/**
	 * Set array takes a user input to set cylinder (array) size
	 * Set current position of the header
	 */
	public void setCylinder() {
		System.out.println("ENTER THE NUMBER OF CYLINDER:");
		int cylinder = scan.nextInt();
		System.out.println("ENTER THE CURRENT HEADER POSITION:");
		int start = scan.nextInt();
		new Disk(cylinder,start);
	}
	
	/**
	 * Read input.txt from the src folder
	 * @throws IOException happens when input.txt cannot be found
	

	public void readFile() throws IOException {
		try {
			in = new FileInputStream("src/input.txt");
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		} finally {
			if (in != null) {
				in.close();
			}
		}
	}

	*/
	
	/**
	 * Disk Management sets the cylinder size, read I/O file and starts the scheduling process
	 * @param a = disk1 which is the object created in Disk.java
	 * @throws IOException happens if the input.txt cannot be found
	 */
	public void DiskManagement(Disk a) throws IOException{
		a.setCylinder();
		a.schedule(a);
	//	a.readFile();
	//	a.setDisk();
	//	a.printDisk();
	}
	
	/**
	 * Choose a schedule algorithm to run with
	 * Switch case is used to run different algorithm when user input
	 * @throws NoSuchElementException Error message output when user input anything other than integer
	 */
	public void schedule(Disk a) throws InputMismatchException{
		int sel = -1;
		while(true){
			try{
				System.out.println("DISK SCHEDULE ALGORITHMS");
				System.out.println("1. FCFS\n"+"2. SSTF\n"+"3. SCAN\n"+"4. C-SCAN\n"+"5. LOOK\n"+"6. C-LOOK\n"+"0. EXIT");
				System.out.println("ENTER SELECTION: ");
				sel = scan.nextInt();
				if((sel >= 0) && (sel <= 6)){
					break;
				}
				System.out.println("ERROR : Enter number from 0 to 6 only!\n");
				
			}catch (InputMismatchException ex){
	    		System.out.println("ERROR : Enter numbers only!\n");
	    		scan.next();
			}
		}
		
		switch(sel){
			case 1:	
				FCFS algo = new FCFS();
				algo.request();
				break;
			case 2:
				System.out.println("You chose two");
				break;
			case 3:
				System.out.println("You chose three");
				break;
			case 4:
				System.out.println("You chose four");
				break;
			case 5:
				System.out.println("You chose five");
				break;
			case 6:
				System.out.println("You chose six"); 
				break;
			case 0:
				System.out.println("Program ending ...");
				break;
		}
		
		scan.close();
	}

}
