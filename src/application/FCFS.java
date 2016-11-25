package application;

public abstract class FCFS extends SSTF{
	//Test this cases
	//TEST case Cylinder size = 200 / {23,89,132,42,187} Start = 100 / Total = 421
	int count;
	/**
	 * @param disk this is the disk object created in Disk class with 4 other variables (startPos, numberOfRequest, request [ARRAY], and cylinder_size)
	 */
	void fcfs(Disk disk){
		System.out.println("FCFS Scheduling in the order that follows: ");
		int head = disk.startPos;
		for(int i = 0 ; i < disk.numberOfRequest ; i++){
				if(head > disk.request[i]){
					count += head - disk.request[i];
				}else{
					count += disk.request[i] - head;
				}
				head = disk.request[i];
				System.out.print(disk.request[i]+ " ");
			}
		if(checkZero(disk))
			count = 0;
		System.out.println("\nTotal Head Movement: "+count);
		set(disk.request,count);
	}


	/**
	 * Check if the request queue is all zero; if zero method should not use head as movement.
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
