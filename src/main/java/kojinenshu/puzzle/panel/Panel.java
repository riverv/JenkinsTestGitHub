package kojinenshu.puzzle.panel;

public class Panel {
	private int value;
	private boolean isAction;
	private int line,row;                //位置

	public Panel() {
	}
	public Panel(int v) {
		setValue(v);
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
