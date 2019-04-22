package kojinenshu.puzzle;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class PuzzleTimer {
	private Timeline gameTime;
	private long second,minute,hour;

	public PuzzleTimer(Label l) {
		ResetTime();
		gameTime = new Timeline(new KeyFrame(new Duration(1000),
				e -> { //定間隔処理内容
					second++;
					if(second % 60 == 0) {
						second=0;
						minute++;
					}
					if(minute % 60 == 0 && minute != 0) {
						minute = 0;
						hour++;
					}

					l.setText(formatTime());
				}
		));
		gameTime.setCycleCount(gameTime.INDEFINITE);	//定間隔呼び出し繰り返し回数 無限
	}
	public void ResetTime() {
		this.second = 0;
		this.minute = 0;
		this.hour = 0;
	}
	public String formatTime() {
		return String.format("%02d:%02d:%02d", hour,minute,second);
	}
	public void stop() {
		gameTime.stop();
	}
	public void start() {
		gameTime.play();
	}
}
