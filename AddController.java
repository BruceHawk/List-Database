package uk.ac.aston.oop.javafx.assessed;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import uk.ac.aston.oop.javafx.assessed.model.Database;
import uk.ac.aston.oop.javafx.assessed.model.Item;
import uk.ac.aston.oop.javafx.assessed.model.Video;

public class AddController {
	
	private Database model;
	@FXML private TextField title;
	@FXML private TextField director;
	@FXML private Slider slider;
	@FXML private CheckBox checkBox;
	@FXML private TextArea comment;
	
	public AddController(Database model) {
		this.model = model;
	}
	
	@FXML
	public void CancelPressed() {
		title.getScene().getWindow().hide();
	}
	
	@FXML
	public void CreatePressed() {
		final Video video = new Video(title.getText(), director.getText(), (int) slider.getValue());
		video.setComment(comment.getText());
		video.setOwn((boolean) checkBox.isSelected());
		model.addItem(video);
		title.getScene().getWindow().hide();
	}
}