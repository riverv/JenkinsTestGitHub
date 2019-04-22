package kojinenshu.puzzle;

public class History {
	private int count,move;
	private int[]	index = {-1,-1,-1};
	public static final int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3;
	public History(int c,int i, int m) {
		this.count = c;
		this.index[0] = i;
		this.move = m;
	}
	public History(int c, int i1, int i2, int m) {
		this.count = c;
		this.index[0] = i1;
		this.index[1] = i2;
		this.move = m;
	}
	public History(int c, int i1,int i2, int i3, int m) {
		this.count = c;
		this.index[0] = i1;
		this.index[1] = i2;
		this.index[2] = i3;
		this.move = m;
	}
	public String createHistory() {
		String history;
		String[] m = new String[3];


		if(this.index[2] != -1) {
			history = String.format("[%d]　　[%d,%d,%d]　",count,index[0],index[1],index[2] );
		}else if(this.index[1] != -1) {
			history = String.format("[%d]　　　[%d,%d]　　",count,index[0],index[1] );
		}else {
			history = String.format("[%d]　　　[%d]　　　",count,index[0]);
		}
		history = history + getMoveString(move);
		return history;
	}
	private String getMoveString(int m) {
		switch(m) {
			case UP:	return "[上]";
			case DOWN:	return "[下]";
			case LEFT:	return "[左]";
			case RIGHT:return "[右]";
			default: 	return "";
		}
	}
}
