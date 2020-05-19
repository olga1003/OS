package laba___3333;

import java.util.ArrayDeque;

public class MemoryManagment {

	private Process process;
	private ArrayDeque <Page> clock;
	public Memory memory;
	public MemoryManagment(int memorySize, int pageSize)
	{
		memory = new Memory( memorySize,  pageSize);
		process = new Process(10, 30);
		this.clock = new ArrayDeque<>();
	}

	public int addPage(Process process)
	{
		int pageId = this.process.addPage(new Page(process.getId()));
		process.getPagesIds().add(pageId);
		return pageId;
	}

	public Page receivePage(int pageId)
	{
		Page page = process.getPage(pageId);
		if (page.isPresent()) {
			page.setRecourse(true);
		} else {
			int emptyPageId = memory.getEmptyPageId();
			if (emptyPageId != -1) {
				memory.setPage(emptyPageId, page);
				page.setRecourse(true);
				page.setPresence(true);
				page.setPhyslAddress(emptyPageId);
				this.clock.addLast(page);
			} else {
				while (true) {
					Page replacePage = this.clock.pollFirst();
					if (replacePage.isRecourse()) {
						replacePage.setRecourse(false);
						this.clock.addLast(replacePage);
					} else {			
						memory.setPage(replacePage.getPhyslAddress(), page);
						page.setRecourse(true);
						page.setPresence(true);
						page.setPhyslAddress(replacePage.getPhyslAddress());
						this.clock.addLast(page);
						replacePage.setPresence(false);
						replacePage.setVirtAddress(process.addPage(replacePage));
						replacePage.setPhyslAddress(-1);
						break;
					}
				}
			}
		}
		return page;
	}
}
