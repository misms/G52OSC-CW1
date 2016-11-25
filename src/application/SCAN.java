package application;

public abstract class SCAN extends Result {

    public void scan(Disk disk){
        int temp;
        int head = 50;
        int count = 0;
        int[] result_array = new int[disk.numberOfRequest+1];

        for(int i = 0 ; i < disk.numberOfRequest ; i++){
            result_array[i] = disk.request[i];
        }
        result_array[disk.numberOfRequest] = head;

        for(int i = 0 ; i < result_array.length ; i++){
            for(int j = 0 ; j < result_array.length ; j++){
                if(result_array[i] < result_array[j]){
                    temp = result_array[i];
                    result_array[i] = result_array[j];
                    result_array[j] = temp;
                }
            }
        }

        count = head + result_array[result_array.length-1];
        set(result_array,count);
    }



}
