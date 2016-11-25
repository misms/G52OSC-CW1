package application;
import static java.util.Arrays.sort;

public abstract class CSCAN extends Result{
	
	public void cscan(Disk disk){
	//int [] arr = {95,180,34,119,11,123,62,64};
	//int cylinder = 200;
	//int head = 50;
	int count = 0;
	int headLocation=0;

	int [] result = new int[disk.numberOfRequest+1];
	for (int i = 0 ;i <disk.numberOfRequest ;++i ) {
		result[i] = disk.request[i];
	}

	result[result.length-1] = disk.startPos;

	
	sort(result);

	for (int i = 0 ;i < result.length ;++i ) {
		if(disk.startPos == result[i]){
			headLocation = i;
		}
	
	}
	// if less than half of size then go left else go right
	if(disk.startPos < (disk.cylinder/2)){
	count = disk.startPos + (disk.cylinder-1 - result[headLocation+1]);
	}
	else{
	count = ((disk.cylinder-1) - disk.startPos) + result[headLocation-1];
	}
	set(result,count);
	}
}
