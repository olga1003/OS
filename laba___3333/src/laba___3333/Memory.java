package laba___3333;

public class Memory {

	private Page[] pages;
	
	 public Memory(int memorySize, int pageSize)
     {
         this.pages = new Page[memorySize / pageSize];
     }

	public int getEmptyPageId() {
		for (int index = 0; index < pages.length; index++) {
			if (pages[index] == null) {
				return index;
			}
		}
		return -1;
	}

	public void setPage(int pageid, Page page) {
		pages[pageid] = page;
	}

	public int getPagesCount() {
		  return pages.length;
	}

	public Page getPage(int pageId) {
		return pages[pageId];
	}

 
	 
}
