package kojinenshu.puzzle;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
public class HistoryList{
	private final int HISTORY_LIST_SIZE = 10;
	private ArrayList<History> history;
	private int index = 0;
	private ObservableList<String> list;

	public HistoryList(ListView<String> l){
		history = new ArrayList<History>();
		list = FXCollections.observableArrayList();
		l.setItems(list);
	}

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
	private void setListCheck() {
		if(index >= HISTORY_LIST_SIZE) {
			history.remove(0);
			list.remove(0);
			index--;
		}
	}
	private void addHistoryList(History h) {
		history.add(h);
		list.add(h.createHistory());
		index++;
	}
	public void ResetHistoryList() {
		history.clear();
		list.clear();
		index = 0;
	}
}
