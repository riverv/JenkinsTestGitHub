package kojinenshu.puzzle;

import java.util.Random;

public class PanelFrame {
	public static final int PUZZLE_SIDE_SIZE = 4;                                      //パズル1辺の大きさ
	public static final int PUZZLE_SIZE = PUZZLE_SIDE_SIZE * PUZZLE_SIDE_SIZE;     //パズルの大きさ
	public static final int EMPTY_PANEL_VALUE = PUZZLE_SIZE;                         //空パネルが保持している値
	public static final int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3;

	private Panel[][] pf = new Panel[PUZZLE_SIDE_SIZE][PUZZLE_SIDE_SIZE];
	private Panel empty;

	public PanelFrame(int[] v) {
		int k = 0;
		for(int i = 0; i < PUZZLE_SIDE_SIZE ; i++) {
			for(int j = 0 ; j< PUZZLE_SIDE_SIZE ; j++) {
				pf[i][j] = new Panel(i,j,v[k]);
				k++;
			}
		}
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
	 * 移動したパネル番号と方向を文字列で返す
	 */
	public String movePanel(int i, int j) {
		//動けるかを判定
		if(pf[i][j].getIsAction()) {
			String res = "";
			//上に移動
			if(empty.getLine() < i) {
				int d = Math.abs(empty.getLine() - i);
				//3つ
				if(d == 3) {
					res = String.format("[%d,%d,%d]　", pf[i][j].getValue(),pf[i-1][j].getValue(),pf[i-2][j].getValue());
					pf[empty.getLine()][empty.getRow()].setValue(pf[i-2][j].getValue());
					pf[i-2][j].setValue(pf[i-1][j].getValue());
					pf[i-1][j].setValue(pf[i][j].getValue());
				//2つ
				}else if(d == 2) {
					res = String.format("[%d,%d]　　", pf[i][j].getValue(),pf[i-1][j].getValue());
					pf[empty.getLine()][empty.getRow()].setValue(pf[i-1][j].getValue());
					pf[i-1][j].setValue(pf[i][j].getValue());
				//1つ
				}else if(d == 1) {
					res = String.format("[%d]　　　", pf[i][j].getValue());
					pf[empty.getLine()][empty.getRow()].setValue(pf[i][j].getValue());
				}
				res = res + getMoveString(UP);
			}
			//下に移動
			else if(empty.getLine() > i) {
				int d = Math.abs(empty.getLine() - i);
				//3つ
				if(d == 3) {
					res = String.format("[%d,%d,%d]　", pf[i][j].getValue(),pf[i+1][j].getValue(),pf[i+2][j].getValue());
					pf[empty.getLine()][empty.getRow()].setValue(pf[i+2][j].getValue());
					pf[i+2][j].setValue(pf[i+1][j].getValue());
					pf[i+1][j].setValue(pf[i][j].getValue());
				//2つ
				}else if(d == 2) {
					res = String.format("[%d,%d]　　", pf[i][j].getValue(),pf[i+1][j].getValue());
					pf[empty.getLine()][empty.getRow()].setValue(pf[i+1][j].getValue());
					pf[i+1][j].setValue(pf[i][j].getValue());
				//1つ
				}else if(d == 1) {
					res = String.format("[%d]　　　", pf[i][j].getValue());
					empty.setValue(pf[i][j].getValue());
				}
				res = res + getMoveString(DOWN);
			}
			//左に移動
			else if(empty.getRow() < j) {
				int d = Math.abs(empty.getRow() - j);
				//3つ
				if(d == 3) {
					res = String.format("[%d,%d,%d]　", pf[i][j].getValue(),pf[i][j-1].getValue(),pf[i][j-2].getValue());
					pf[empty.getLine()][empty.getRow()].setValue(pf[i][j-2].getValue());
					pf[i][j-2].setValue(pf[i][j-1].getValue());
					pf[i][j-1].setValue(pf[i][j].getValue());
				//2つ
				}else if(d == 2) {
					res = String.format("[%d,%d]　　", pf[i][j].getValue(),pf[i][j-1].getValue());
					pf[empty.getLine()][empty.getRow()].setValue(pf[i][j-1].getValue());
					pf[i][j-1].setValue(pf[i][j].getValue());
				//1つ
				}else if(d == 1) {
					res = String.format("[%d]　　　", pf[i][j].getValue());
					pf[empty.getLine()][empty.getRow()].setValue(pf[i][j].getValue());
				}
				res = res + getMoveString(LEFT);
			}
			//右に移動
			else if(empty.getRow() > j) {
				int d = Math.abs(empty.getRow() - j);
				//3つ
				if(d == 3) {
					res = String.format("[%d,%d,%d]　", pf[i][j].getValue(),pf[i][j+1].getValue(),pf[i][j+2].getValue());
					pf[empty.getLine()][empty.getRow()].setValue(pf[i][j+2].getValue());
					pf[i][j+2].setValue(pf[i][j+1].getValue());
					pf[i][j+1].setValue(pf[i][j].getValue());
				//2つ
				}else if(d == 2) {
					res = String.format("[%d,%d]　　", pf[i][j].getValue(),pf[i][j+1].getValue());
					pf[empty.getLine()][empty.getRow()].setValue(pf[i][j+1].getValue());
					pf[i][j+1].setValue(pf[i][j].getValue());
				//1つ
				}else if(d == 1) {
					res = String.format("[%d]　　　", pf[i][j].getValue());
					pf[empty.getLine()][empty.getRow()].setValue(pf[i][j].getValue());
				}
				res = res + getMoveString(RIGHT);
			}else {
				return null;
			}
			pf[i][j].setValue(EMPTY_PANEL_VALUE);
			empty = pf[i][j];
			updateIsAction();
			return res;
		}else {
			return null;
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
	/*
	 * 方向の整数値を文字列に置き換える
	 */
	public static String getMoveString(int m) {
		switch(m) {
			case UP:	return "[上]";
			case DOWN:	return "[下]";
			case LEFT:	return "[左]";
			case RIGHT:return "[右]";
			default: 	return "";
		}
	}
}
