package kojinenshu.puzzle;
/*
 * 履歴
 */
public class History {
	private final int HISTORY_LIST_SIZE = 10;

	private int index = 0;                //現在の保持リスト数

	/*
	 * 履歴へ追加する情報
	 */
	public String setHistoryData(int count, String string) {
		String history;
		index++;
		return history = String.format("[%d]　　"+string,count );
	}
	/*
	 * 履歴の数が10件ならば古いものを削除
	 */
	public boolean isHistoryOver() {
		if(index > HISTORY_LIST_SIZE) {
			index--;
			return false;
		}
		return true;
	}
	/*
	 * 履歴数をクリア
	 */
	public void ResetHistory() {
		index = 0;
	}
}
