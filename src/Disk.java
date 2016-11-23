

import java.io.IOException;

public class Disk extends DiskManage{

	static int cylinder;
	static int startPos;
	
	public Disk(int size, int position) {
		cylinder = size;
		startPos = position;
	}

	public Disk() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String [] args) throws IOException{
		Disk disk1 = new Disk();
		disk1.DiskManagement(disk1);
	}



}
