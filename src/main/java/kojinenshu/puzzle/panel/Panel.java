package kojinenshu.puzzle.panel;

public class Panel {
	private int value;                   //現在の値
	private boolean isAction;           //T: 動ける位置 F:動けない位置
	private int line,row;                //位置

	public Panel() {
	}
	public Panel(int l, int r, int v) {
		setValue(v);
		setLine(l);
		setRow(r);
		setIsAction(false);
	}
	void setValue(int v) {
		this.value = v;
	}
	void setIsAction(boolean b) {
		this.isAction = b;
	}
	void setLine(int l) {
		this.line = l;
	}
	void setRow(int r) {
		this.row = r;
	}

	public int getValue() {
		return this.value;
	}
	public boolean getIsAction() {
		return this.isAction;
	}
	public int getLine() {
		return this.line;
	}
	public int getRow() {
		return this.row;
	}
}
