import java.util.InputMismatchException;
import java.util.Scanner;

public class FCFS {
	Scanner scan = new Scanner(System.in);
	 int start = Disk.startPos, numberOfRequest = 0,count = 0;
	 //TEST case {23,89,132,42,187} Start = 100 / Total = 421
	 //TEST case {95,180,34,119,11,123,62,64} Start = 50 / Total = 644
	 int[] request;
	 int pass;
	 
	public void request(){
		int i = 0;

		while(true){
		try{
			System.out.println("ENTER NUMBER OF REQUEST(S): ");
			numberOfRequest = scan.nextInt();
			request = new int[numberOfRequest];
			System.out.println("ENTER THE REQUEST QUEUE: ");
			for(i = 0 ; i < 5 ; i++){
				pass = scan.nextInt();
				if(pass < Disk.cylinder){
					request[i] = pass;
				}
				else{
					System.out.println("ERROR : Enter number less than the define cylinder size: " + Disk.cylinder);
					i--;
				}
			}
			System.out.println("Request SUCCESSFUL!");
			fcfs();
			break;
		}catch(InputMismatchException ex){
			System.out.println("ERROR : Enter numbers only!");
				i--;
				scan.next();
			}
		}
	}
	

	public  void fcfs(){
		int head;
		System.out.println("FCFS Scheduling in the order that follows: ");
		head = start;
		for(int i = 0 ; i < numberOfRequest ; i++){
				if(head > request[i]){
					count += head - request[i];
				}else{
					count += request[i] - head;
				}
				head = request[i];
				System.out.print(request[i]+ " ");
			}
		System.out.println("\nTotal Head Movement: "+count);
		}
}
