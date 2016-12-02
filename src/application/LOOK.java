package application;
import static java.util.Arrays.sort;

public abstract class LOOK extends CLOOK {

    public void look(Disk disk){
        int headLocation = 0;
        int count = 0;
        int[] result = new int[disk.numberOfRequest+1];
		for (int i = 0 ;i <disk.numberOfRequest ;++i ) {
			result[i + 1] = disk.request[i];
		}
		result[0] = disk.startPos;
		sort(result);

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
	count = (disk.startPos-result[0]) + (result[result.length-1]-result[0]);
	}
	else{
		
		for (int i :result ) {
			System.out.print(i + " ");
		}
		
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

	count = ((result[result.length-1] - disk.startPos) + (result[result.length-1]-result[0]));
	}
        disk.request = path;
        set(disk,disk.request,count);
    }



}
