package laba___3333;

public class Page {

	private int processId;
	private int physlAddress;
	private int virtAddress;


	private boolean recourse;
	private boolean presence;

	public Page(int processId) {
		this.processId = processId;
		this.physlAddress = -1;
		this.virtAddress = -1;
		this.recourse = false;
		this.presence = false;
	}

	public boolean isRecourse() {
		return recourse;
	}

	public boolean isPresent() {
		return presence;
	}

	public void setPresence(boolean presence) {
		this.presence = presence;
	}

	public void setRecourse(boolean recourse) {
		this.recourse = recourse;
	}

	public int getPhyslAddress() {
		return physlAddress;
	}

	public void setPhyslAddress(int physlAddress) {
		this.physlAddress = physlAddress;
	}

	public int getVirtAddress() {
		return virtAddress;
	}

	public void setVirtAddress(int virtAddress) {
		this.virtAddress = virtAddress;
	}

	public int getProcessId() {

        return processId;
	}
}
