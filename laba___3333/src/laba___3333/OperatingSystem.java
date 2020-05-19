package laba___3333;

import java.util.ArrayList;


public class OperatingSystem {

	private MemoryManagment memoryManagment;
	private ArrayList<Process> process;
	private ArrayList<Page> pages;

	public OperatingSystem(int memorySize, int pageSize) {
		memoryManagment = new MemoryManagment(memorySize, pageSize);
		process = new ArrayList<>();
		pages = new ArrayList<>();
	}

	public void addProcess() {
		Process process = new Process(this.process.size(), 3);
		this.process.add(process);
		System.out.println("Cоздание нового процесса " + process.getId() + " требующий  " + process.getCountPages() + " страниц");
	}

	public Process getProcess(int processId) {

		for (Process process : this.process) {
			if (process.getId() == processId) {
				return process;
			}
		}
		return null;
	}

	public void getPage(int processId, int pageId) {
		Process process = this.getProcess(processId);
		if (process != null) {
			if (process.getPagesIds().contains(pageId)) {
				this.memoryManagment.receivePage(pageId);
				System.out.println("Процесс " + process.getId() + " запросил страницу " + pageId);
			}
			else 
				System.out.println("У процесса " + process.getId() + " нет страницы " + pageId);
		}
	}


	public  int addPage(Page page) {
		pages.add(page);
		return pages.indexOf(page);
	}

	public void addPage(int processId) {
		Process process = this.getProcess(processId);
		if (process != null) {
			int pageId = this.memoryManagment.addPage(process);
			this.getPage(processId, pageId);
			System.out.println("Создание страницы " + pageId + " для процесса " + process.getId());
		}
	}

	public void print() {
		System.out.println("Оперативная память");
		System.out.printf("| Страница | Процесс | Бит обращения | \n");
		for (int pageId = 0; pageId < memoryManagment.memory.getPagesCount(); pageId++) {
			Page page = memoryManagment.memory.getPage(pageId);
			if (page == null) {
				System.out.printf(" %d\n", pageId);

			} else {
				Process process = this.getProcess(page.getProcessId());
				System.out.printf("| %5d    | \t%4d |  \t%4s |\n", pageId, process.getId(), page.isRecourse() ? 1 : 0);
			}
		}
	}



}
