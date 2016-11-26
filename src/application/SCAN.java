package application;

public abstract class SCAN extends CSCAN {

    public void scan(Disk disk){
        int temp;
        int head = 50;
        int count = 0;
        int[] result = new int[disk.numberOfRequest+1];

        for(int i = 0 ; i < disk.numberOfRequest ; i++){
            result[i] = disk.request[i];
        }

        result[disk.numberOfRequest] = head;

        for(int i = 0 ; i < result.length ; i++){
            for(int j = 0 ; j < result.length ; j++){
                if(result[i] < result[j]){
                    temp = result[i];
                    result[i] = result[j];
                    result[j] = temp;
                }
            }
        }

        count = head + result[result.length-1];
        disk.request = result;
        set(disk.request,count);
    }



}
