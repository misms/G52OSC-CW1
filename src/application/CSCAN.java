package application;
import static java.util.Arrays.sort;

public abstract class CSCAN extends LOOK {

    public void cscan(Disk disk){
        int headLocation = 0;
        int count = 0;
        int[] result = new int[disk.numberOfRequest+3];
		int j = 0;
		
		for (int i = 0 ;i <disk.numberOfRequest ;++i ) {
			result[i + 3] = disk.request[i];
		}
		result[2] = disk.startPos;
		result[1] = disk.cylinder-1;
		result[0] = 0;
		sort(result);
		

		for (int i = 0 ;i < result.length ;++i ) {
			if(disk.startPos == result[i]){
				headLocation = i;
			}
		
		}

		int [] path = new int[result.length];

		
	if(disk.startPos < (disk.cylinder/2)){
		for(int i = headLocation ; i >= 0 ; i-- ){
			path[j] = result[i];
			j++;
		}
		j = path.length -1;
		for(int i = headLocation + 1 ; i < path.length ; i++){
			path[j] = result[i];
			j--;
		}
		count = disk.startPos + (disk.cylinder-1 - result[headLocation+1]);	
	}
	
	if(disk.startPos > (disk.cylinder/2)){
		for(int i = headLocation ; i < result.length ; i++){
			path[j] = result[i];
			j++;
		}
		for(int i = 0 ; i < headLocation ; i++ ){
			path[j] = result[i];
			j++;
		}
		count = ((disk.cylinder-1) - disk.startPos) + result[headLocation-1];
	}
        disk.request = path;
        set(disk.request,count);
    }



}
