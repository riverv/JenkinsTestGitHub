package kojinenshu.puzzle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

/*
 * 履歴情報を10件に制限、リストとして保持
 */
public class HistoryList{
	private final int HISTORY_LIST_SIZE = 10;
	//private ArrayList<History> history;
	private int index = 0;                //現在の保持リスト数
	private ObservableList<String> list;
	/*
	* fxmlのListView受け取り
	*/
	public HistoryList(ListView<String> l){
		//history = new ArrayList<History>();
		list = FXCollections.observableArrayList();
		l.setItems(list);
	}

	/*
	 * リストへ追加
	 */
	public void setListView(int c,int i, int m) {
		setListCheck();
		History h = new History(c,i,m);
		addHistoryList(h);
	}
	public void setListView(int c,int i1,int i2,int m) {
		setListCheck();
		History h = new History(c,i1,i2,m);
		addHistoryList(h);
	}
	public void setListView(int c,int i1, int i2, int i3,int m) {
		setListCheck();
		History h = new History(c,i1,i2,i3,m);
		addHistoryList(h);
	}
	/*
	 * リストの数が10件ならば古いものを削除
	 */
	private void setListCheck() {
		if(index >= HISTORY_LIST_SIZE) {
		//	history.remove(0);
			list.remove(0);
			index--;
		}
	}
	/*
	 * リストへ追加
	 */
	private void addHistoryList(History h) {
		//history.add(h);
		list.add(h.createHistory());
		index++;
	}
	/*
	 * リストをクリア
	 */
	public void ResetHistoryList() {
		//history.clear();
		list.clear();
		index = 0;
	}
}
