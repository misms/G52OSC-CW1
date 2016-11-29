package application;

public abstract class FCFS extends SSTF{
	/**
	 * @param disk this is the disk object created in Disk class with 4 other variables (startPos, numberOfRequest, request [ARRAY], and cylinder_size)
	 */
	void fcfs(Disk disk){
		int count = 0;
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
		
		int[] result = new int[disk.numberOfRequest+1];
		for(int i = 0; i < disk.numberOfRequest; ++i){
			result[i+1] = disk.request[i];
		}
		result[0] = disk.startPos;
		disk.request = result;
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
