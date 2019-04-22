package kojinenshu.puzzle;

public class GameInfo {
	private boolean inAction = false; /*T:ゲーム中状態 F:ゲーム停止状態*/
	private int count = 0;             /*手数*/

	/*
	 * ゲーム中/停止状態の切り替え
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
	/*手数を文字列として返す*/
	public String getCount() {
		String str = String.format("%d", count);
		return str;
	}
	/*
	 * 手数を整数型として返す
	 */
	public int getCountInt() {
		return count;
	}
}
