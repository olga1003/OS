package laba___3333;

public class Main {
	
	public static void main(String[] args) {
		
		OperatingSystem os = new OperatingSystem(16, 4);
	    for (int processId = 0; processId < 3; processId++)	{
	    	 os.addProcess();
             for (int pageId = 0; pageId < os.getProcess(processId).getCountPages(); pageId++)
             {
            	 os.addPage(processId);
             }
             os.print();
		}
	}  

}
