package application;
import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Algorithms extends Result{
	//Test this cases
	//TEST case Cylinder size = 200 / {23,89,132,42,187} Start = 100 / Total = 421
	//TEST case Cylinder size = 200 / {95,180,34,119,11,123,62,64} Start = 50 / Total = 644

	void fcfs(Disk disk){
		int head,count = 0;
		System.out.println("FCFS Scheduling in the order that follows: ");
		head = disk.startPos;
		for(int i = 0 ; i < disk.numberOfRequest ; i++){
				if(head > disk.request[i]){
					count += head - disk.request[i];
				}else{
					count += disk.request[i] - head;
				}
				head = disk.request[i];
				System.out.print(disk.request[i]+ " ");
			}
		if(checkZero(disk) == true)
			count = 0;
		System.out.println("\nTotal Head Movement: "+count);
		set(disk.request,count);
	}

	void sstf(Disk disk){

	}

	/**
	 * Check if the request queue is all zero; if zero method should not use head as movement.
	 * @param checkdisk
	 * @return
	 */
	boolean checkZero(Disk checkdisk){
		for(int i = 0 ; i < checkdisk.numberOfRequest; i++){
			if(checkdisk.request[0] != checkdisk.request[i]) {
				return false;
			}
		}
		return true;
	}

}
