package application;

public abstract class SSTF extends SCAN{


    public void sstf(Disk disk){
        set(path(disk),serviceRequests(disk));
    }
    

    public int serviceRequests(Disk disk){
        int headMovement = 0;
        int prev = disk.startPos;
        int [] rpath = path(disk);
        for (int i=0; i < rpath.length; i++) {
            headMovement += Math.abs(rpath[i]-prev);
            prev = rpath[i];
        }
        return headMovement;
    }

    public int[] path(Disk disk){
        int [] resultPath = new int[disk.numberOfRequest];
        int now = disk.startPos;
        int [] requests = new int[disk.numberOfRequest];
        for (int i = 0; i < disk.numberOfRequest; i++){
            requests[i] = disk.request[i];
        }
        for (int i = 0; i < disk.numberOfRequest; i++){
            int closest = closest(now, requests,disk);
            resultPath[i] = closest;
            now = closest;
        }
        return resultPath;
    }

    int closest(int k, int[] requests,Disk disk){
        int min = 5000000;
        int minPos = -1;
        for (int i = 0; i < disk.numberOfRequest; i++){
            if (requests[i] == -1) continue;
            else if  (Math.abs(k-disk.request[i]) < min) {
                minPos = i;
                min = Math.abs(k-disk.request[i++]);
            }
        }
        int nearestCylinder = requests[minPos];
        requests[minPos] = -1;
        return nearestCylinder;
    }
}
