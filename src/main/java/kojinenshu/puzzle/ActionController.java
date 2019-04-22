package kojinenshu.puzzle;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import kojinenshu.puzzle.panel.PanelFrame;

public class ActionController implements Initializable{
	@FXML
	private AnchorPane pane;
	@FXML
	private Button playStopButton;
	@FXML
	private ListView historyList;
	@FXML
	Label labelTime,labelCount;

	private Button[] panel= new Button[PanelFrame.PUZZLE_SIZE];
	HistoryList hList;
	PanelFrame puzzle;
	PuzzleTimer pt;
	GameInfo gi;
	int[] panelValue;

	/*
	 * 初期化処理
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		hList = new HistoryList(historyList);
		panelValue = new int[PanelFrame.PUZZLE_SIZE];
		int child = 0;

		//パネルをpaneの子を受け取りpanelで配列として扱えるようにする
		for(javafx.scene.Node c:pane.getChildren()) {
			if(child < 8) {
				child++;
				continue;
			}
			panel[child - 8] = (Button)c;
			child++;
		}
		//初期値をパネルへセット
		for(int i = 0; i < PanelFrame.PUZZLE_SIZE ; i++) {
			panelValue[i] = i + 1;
		}
		gi = new GameInfo();
		puzzle = new PanelFrame(panelValue,hList,gi);
		puzzle.updateIsAction();
		pt = new PuzzleTimer(labelTime);

		showPuzzle();
	}
	@FXML
	public void onClickPanel1(ActionEvent event) {
		if(gi.getInAction()) {
			if(puzzle.movePanel(0, 0)) {
				gi.plusCount();
				showPuzzle();
			}
		}

	}
	@FXML
	public void onClickPanel2(ActionEvent event) {
		if(gi.getInAction()) {
			if(puzzle.movePanel(0, 1)) {
				gi.plusCount();
				showPuzzle();
			}
		}
	}
	@FXML
	public void onClickPanel3(ActionEvent event) {
		if(gi.getInAction()) {
			if(puzzle.movePanel(0, 2)) {
				gi.plusCount();
				showPuzzle();
			}
		}
	}
	@FXML
	public void onClickPanel4(ActionEvent event) {
		if(gi.getInAction()) {
			if(puzzle.movePanel(0, 3)) {
				gi.plusCount();
				showPuzzle();
			}
		}
	}
	@FXML
	public void onClickPanel5(ActionEvent event) {
		if(gi.getInAction()) {
			if(puzzle.movePanel(1, 0)) {
				gi.plusCount();
				showPuzzle();
			}
		}
	}
	@FXML
	public void onClickPanel6(ActionEvent event) {
		if(gi.getInAction()) {
			if(puzzle.movePanel(1, 1)) {
				gi.plusCount();
				showPuzzle();
			}
		}
	}
	@FXML
	public void onClickPanel7(ActionEvent event) {
		if(gi.getInAction()) {
			if(puzzle.movePanel(1, 2)) {
				gi.plusCount();
				showPuzzle();
			}
		}
	}
	@FXML
	public void onClickPanel8(ActionEvent event) {
		if(gi.getInAction()) {
			if(puzzle.movePanel(1, 3)) {
				gi.plusCount();
				showPuzzle();
			}
		}
	}
	@FXML
	public void onClickPanel9(ActionEvent event) {
		if(gi.getInAction()) {
			if(puzzle.movePanel(2, 0)) {
				gi.plusCount();
				showPuzzle();
			}
		}
	}
	@FXML
	public void onClickPanel10(ActionEvent event) {
		if(gi.getInAction()) {
			if(puzzle.movePanel(2, 1)) {
				gi.plusCount();
				showPuzzle();
			}
		}
	}
	@FXML
	public void onClickPanel11(ActionEvent event) {
		if(gi.getInAction()) {
			if(puzzle.movePanel(2, 2)) {
				gi.plusCount();
				showPuzzle();
			}
		}
	}
	@FXML
	public void onClickPanel12(ActionEvent event) {
		if(gi.getInAction()) {
			if(puzzle.movePanel(2, 3)) {
				gi.plusCount();
				showPuzzle();
			}
		}
	}
	@FXML
	public void onClickPanel13(ActionEvent event) {
		if(gi.getInAction()) {
			if(puzzle.movePanel(3, 0)) {
				gi.plusCount();
				showPuzzle();
			}
		}
	}
	@FXML
	public void onClickPanel14(ActionEvent event) {
		if(gi.getInAction()) {
			if(puzzle.movePanel(3, 1)) {
				gi.plusCount();
				showPuzzle();
			}
		}
	}
	@FXML
	public void onClickPanel15(ActionEvent event) {
		if(gi.getInAction()) {
			if(puzzle.movePanel(3, 2)) {
				gi.plusCount();
				showPuzzle();
			}
		}
	}
	@FXML
	public void onClickPanel16(ActionEvent event) {
		if(gi.getInAction()) {
			if(puzzle.movePanel(3, 3)) {
				gi.plusCount();
				showPuzzle();

			}
		}
	}

	@FXML
	public void onClickPlayStop(ActionEvent event) {
		if(gi.getInAction()) {
			gameStop();
		}else {
			//ゲームを開始する
			labelTime.setText(pt.formatTime());
			gi.changeInAction();
			gi.resetCount();
			pt.ResetTime();
			labelTime.setText(pt.formatTime());
			pt.start();
			puzzle.initPanel(panelValue);
			hList.ResetHistoryList();
			showPuzzle();
			playStopButton.setText("終了");
		}
	}
	/*
	 * ゲーム終了処理
	 */
	private void gameStop() {
		gi.changeInAction();
		pt.stop();
		playStopButton.setText("開始");
	}
	/*
	 * アプリケーション終了処理
	 */
	@FXML
	public void onClickExit(ActionEvent event) {
		System.exit(0);
	}
	/*
	 * パネルの表示を更新
	 */
	private void showPuzzle() {
		String str;
		puzzle.getPfValue(panelValue);
		for(int i = 0; i < PanelFrame.PUZZLE_SIZE ; i++) {
			str = String.format("%d", panelValue[i]);
			panel[i].setText(str);
			panel[i].setVisible(true);
		}
		for(int i = 0; i < PanelFrame.PUZZLE_SIZE ; i++)
			if(panelValue[i] == PanelFrame.EMPTY_PANEL_VALUE) {
				panel[i].setVisible(false);
		}
		labelCount.setText(gi.getCount());  //手数を表示
		//クリア判定
		if(puzzle.isClear()) {
			labelTime.setText(pt.formatTime());
			gameStop();
		}
	}
}
