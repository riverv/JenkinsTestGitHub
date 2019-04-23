package kojinenshu.puzzle.panel;

import java.util.Random;

import kojinenshu.puzzle.GameInfo;
import kojinenshu.puzzle.History;
import kojinenshu.puzzle.HistoryList;

public class PanelFrame {
	public static final int PUZZLE_SIDE_SIZE = 4;                                      //パズル1辺の大きさ
	public static final int PUZZLE_SIZE = PUZZLE_SIDE_SIZE * PUZZLE_SIDE_SIZE;     //パズルの大きさ
	public static final int EMPTY_PANEL_VALUE = PUZZLE_SIZE;                         //空パネルが保持している値
	private Panel[][] pf = new Panel[PUZZLE_SIDE_SIZE][PUZZLE_SIDE_SIZE];
	private Panel empty;
	private HistoryList hl;
	private GameInfo gi;

	public PanelFrame(int[] v,HistoryList hList,GameInfo g) {
		int k = 0;
		for(int i = 0; i < PUZZLE_SIDE_SIZE ; i++) {
			for(int j = 0 ; j< PUZZLE_SIDE_SIZE ; j++) {
				pf[i][j] = new Panel(i,j,v[k]);
				k++;
			}
		}
		this.hl = hList;
		this.gi = g;
		empty = pf[PUZZLE_SIDE_SIZE - 1][PUZZLE_SIDE_SIZE - 1];
	}
	/*
	 * ゲーム開始時 シャッフル
	 */
	public void initPanel(int[] v) {
		int random = new Random().nextInt(10) + 200;
		for(int i = 0 ; i< random ; i++) {
				int k = new Random().nextInt(PUZZLE_SIDE_SIZE);
				int l = new Random().nextInt(PUZZLE_SIDE_SIZE);
				movePanel(l,k);
		}
		for(int i= 0,k = 0 ; i < PUZZLE_SIDE_SIZE ; i++)
			for(int j=0 ; j < PUZZLE_SIDE_SIZE ; j++, k++)
				v[k] = pf[i][j].getValue();

	}
	/*
	 * 指定したパネルを動ける方向へ移動
	 */
	public boolean movePanel(int i, int j) {
		//動けるかを判定
		if(pf[i][j].getIsAction()) {
			//上に移動
			if(empty.getLine() < i) {
				int d = Math.abs(empty.getLine() - i);
				//3つ
				if(d == 3) {
					hl.setListView(gi.getCountInt(),pf[i][j].getValue(),pf[i-1][j].getValue(),pf[i-2][j].getValue() , History.UP);
					pf[empty.getLine()][empty.getRow()].setValue(pf[i-2][j].getValue());
					pf[i-2][j].setValue(pf[i-1][j].getValue());
					pf[i-1][j].setValue(pf[i][j].getValue());
					pf[i][j].setValue(EMPTY_PANEL_VALUE);
				//2つ
				}else if(d == 2) {
					hl.setListView(gi.getCountInt(),pf[i][j].getValue(),pf[i-1][j].getValue(), History.UP);
					pf[empty.getLine()][empty.getRow()].setValue(pf[i-1][j].getValue());
					pf[i-1][j].setValue(pf[i][j].getValue());
					pf[i][j].setValue(EMPTY_PANEL_VALUE);
				//1つ
				}else if(d == 1) {
					hl.setListView(gi.getCountInt(), pf[i][j].getValue(), History.UP);
					pf[empty.getLine()][empty.getRow()].setValue(pf[i][j].getValue());
					pf[i][j].setValue(EMPTY_PANEL_VALUE);

				}

			}
			//下に移動
			else if(empty.getLine() > i) {
				int d = Math.abs(empty.getLine() - i);
				//3つ
				if(d == 3) {
					hl.setListView(gi.getCountInt(),pf[i][j].getValue(),pf[i+1][j].getValue(),pf[i+2][j].getValue() , History.DOWN);
					pf[empty.getLine()][empty.getRow()].setValue(pf[i+2][j].getValue());
					pf[i+2][j].setValue(pf[i+1][j].getValue());
					pf[i+1][j].setValue(pf[i][j].getValue());
					pf[i][j].setValue(EMPTY_PANEL_VALUE);
				//2つ
				}else if(d == 2) {
					hl.setListView(gi.getCountInt(),pf[i][j].getValue(),pf[i+1][j].getValue(), History.DOWN);
					pf[empty.getLine()][empty.getRow()].setValue(pf[i+1][j].getValue());
					pf[i+1][j].setValue(pf[i][j].getValue());
					pf[i][j].setValue(EMPTY_PANEL_VALUE);
				//1つ
				}else if(d == 1) {
					hl.setListView(gi.getCountInt(),pf[i][j].getValue() , History.DOWN);
					empty.setValue(pf[i][j].getValue());
					pf[i][j].setValue(EMPTY_PANEL_VALUE);

				}
			}
			//左に移動
			else if(empty.getRow() < j) {
				int d = Math.abs(empty.getRow() - j);
				//3つ
				if(d == 3) {
					hl.setListView(gi.getCountInt(),pf[i][j].getValue(),pf[i][j-1].getValue(),pf[i][j-2].getValue() , History.LEFT);
					pf[empty.getLine()][empty.getRow()].setValue(pf[i][j-2].getValue());
					pf[i][j-2].setValue(pf[i][j-1].getValue());
					pf[i][j-1].setValue(pf[i][j].getValue());
					pf[i][j].setValue(EMPTY_PANEL_VALUE);
				//2つ
				}else if(d == 2) {
					hl.setListView(gi.getCountInt(),pf[i][j].getValue(),pf[i][j-1].getValue(), History.LEFT);
					pf[empty.getLine()][empty.getRow()].setValue(pf[i][j-1].getValue());
					pf[i][j-1].setValue(pf[i][j].getValue());
					pf[i][j].setValue(EMPTY_PANEL_VALUE);
				//1つ
				}else if(d == 1) {
					hl.setListView(gi.getCountInt(),pf[i][j].getValue() , History.LEFT);
					pf[empty.getLine()][empty.getRow()].setValue(pf[i][j].getValue());
					pf[i][j].setValue(EMPTY_PANEL_VALUE);

				}
			}
			//右に移動
			else if(empty.getRow() > j) {
				int d = Math.abs(empty.getRow() - j);
				//3つ
				if(d == 3) {
					hl.setListView(gi.getCountInt(),pf[i][j].getValue(),pf[i][j+1].getValue(),pf[i][j+2].getValue() , History.RIGHT);
					pf[empty.getLine()][empty.getRow()].setValue(pf[i][j+2].getValue());
					pf[i][j+2].setValue(pf[i][j+1].getValue());
					pf[i][j+1].setValue(pf[i][j].getValue());
					pf[i][j].setValue(EMPTY_PANEL_VALUE);
				//2つ
				}else if(d == 2) {
					hl.setListView(gi.getCountInt(),pf[i][j].getValue(),pf[i][j+1].getValue(), History.RIGHT);
					pf[empty.getLine()][empty.getRow()].setValue(pf[i][j+1].getValue());
					pf[i][j+1].setValue(pf[i][j].getValue());
					pf[i][j].setValue(EMPTY_PANEL_VALUE);
				//1つ
				}else if(d == 1) {
					hl.setListView(gi.getCountInt(),pf[i][j].getValue() , History.RIGHT);
					pf[empty.getLine()][empty.getRow()].setValue(pf[i][j].getValue());
					pf[i][j].setValue(EMPTY_PANEL_VALUE);

				}
			}else {
				return false;
			}
			empty = pf[i][j];
			updateIsAction();
			return true;
		}else {
			return false;
		}
	}
	/*
	 * パネルが動けるかを判定し、更新
	 */
	public void updateIsAction() {
		for(int i = 0; i < PUZZLE_SIDE_SIZE ; i++) {
			for(int j = 0 ; j< PUZZLE_SIDE_SIZE ; j++) {
				if(empty.getLine() == i && empty.getRow() == j)
					pf[i][j].setIsAction(false);
				else if(empty.getLine() == i || empty.getRow() == j)
					pf[i][j].setIsAction(true);
				else
					pf[i][j].setIsAction(false);
			}
		}
	}
	/*
	 * パネルが正しい位置にあるか
	 */
	public boolean isClear() {
		int k = 1;
		for(int i = 0; i < PUZZLE_SIDE_SIZE ; i++) {
			for(int j = 0 ; j< PUZZLE_SIDE_SIZE ; j++) {
				if(pf[i][j].getValue() != k) {
					return false;
				}
				k++;
			}
		}
		return true;
	}
	/*
	 * 現在の値を1次元配列で渡す
	 */
	public void getPanelFrameValue(int[] v) {
		for(int i= 0,k = 0 ; i < PUZZLE_SIDE_SIZE ;i++)
			for(int j=0 ; j < PUZZLE_SIDE_SIZE ; j++, k++)
				v[k] = pf[i][j].getValue();
	}

}
