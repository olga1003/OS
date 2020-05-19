package laba___3333;

import java.util.ArrayList;

public class Process {
	private int id;
	private int pagesÑount;
	private ArrayList<Page> processes;
    private ArrayList<Integer> pagesIds;
    
    public Process(int id, int pagesCount) {
		this.id = id;
		this.pagesÑount = pagesCount;
		this.processes = new ArrayList<>();
		this.pagesIds = new ArrayList<>();
	}
    
    public int addPage(Page page)
    {
        processes.add(page);
        return processes.indexOf(page);
    }

	public int getId() {
		return id;
	}

	public ArrayList<Integer> getPagesIds() {
 		return pagesIds;
	}

	public Page getPage(int pageId) {
		   return processes.get(pageId);
	}

	public int getCountPages() {
		  return pagesÑount;
	}
}
