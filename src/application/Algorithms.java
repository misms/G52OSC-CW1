package application;
import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Algorithms {
	int count = 0;
	 //TEST case {23,89,132,42,187} Start = 100 / Total = 421
	 //TEST case {95,180,34,119,11,123,62,64} Start = 50 / Total = 644

	public void fcfs(Disk disk){
		int head;
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
		System.out.println("\nTotal Head Movement: "+count);
		}
}
