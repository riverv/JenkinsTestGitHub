package kojinenshu.puzzle;

public class GameInfo {
	private boolean inAction = false;
	private int count = 0;

/*
	public GameInfo() {
		inAction = false;
	}
*/
	public void changeInAction(){
		inAction = !inAction;
	}
	public boolean getInAction() {
		return inAction;
	}
	public void plusCount() {
		count++;
	}
	public void resetCount() {
		count = 0;
	}
	public String getCount() {
		String str = String.format("%d", count);
		return str;
	}
	public int getCountInt() {
		return count;
	}
}
