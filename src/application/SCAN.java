package application;
import static java.util.Arrays.sort;

public abstract class SCAN extends CSCAN {

    public void scan(Disk disk){
        int headLocation = 0;
        int count = 0;
        int [] result = new int[disk.numberOfRequest+2];
		for (int i = 0 ;i <disk.numberOfRequest ;++i ) {
			result[i+1] = disk.request[i];
		}
		result[result.length-1] = disk.startPos;
		if(disk.startPos < (disk.cylinder/2)){
		result[0] = 0;
		sort(result);
		} else {
			result[0] = disk.cylinder-1;
			sort(result);
		}

		for (int i = 0 ;i < result.length ;++i ) {
			if(disk.startPos == result[i]){
				headLocation = i;
			}
		
		}

		int [] path = new int[result.length];
		
		int j = 0;
		int last = 0;
		
		
		/**
		* PATH ARRANGEMENT
		**/


	if(disk.startPos < (disk.cylinder/2)){
	
	for(int i = headLocation; i >= 0; --i){
			path[j] = result[i];
			++j;
			last = j;
		}
		j = last;
		for (int i = headLocation+1 ;i < result.length ; ++i ) {
			path[j] = result[i];
			++j;
		}
	count = disk.startPos + path[path.length-1];
	}
	else{
		
		for(int i = headLocation; i < result.length; ++i){
			
			path[j] = result[i];
			//System.out.println(path[j]);
			++j;
			last = j;
		}
		j = last;
		for (int i = headLocation-1 ;i >= 0 ; --i ) {
			path[j] = result[i];
			++j;
		}

	count = ((disk.cylinder-1) - disk.startPos) + (disk.cylinder-result[0]);
	}
        disk.request = path;
        set(disk.request,count);
    }



}
