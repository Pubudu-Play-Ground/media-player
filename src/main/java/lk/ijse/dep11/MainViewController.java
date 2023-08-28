package lk.ijse.dep11;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;

import java.io.File;

public class MainViewController {
    public AnchorPane root;
    public TextField txtAudioPath;
    public TextField txtVideoPath;
    public Button btnBrowseAudio;
    public Button btnBrowseVideo;
    public Button btnPlayAudio;
    public Button btnStopAudio;
    public Button btnPlayVideo;
    public Button btnStopVideo;
    public MediaView mvPlayer;

    MediaPlayer audioPlayer;
    MediaPlayer videoPlayer;

    public void btnBrowseAudioOnAction(ActionEvent e) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Mp3 files","*.mp3"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Wave files","*.wmv"));
        File audio = fileChooser.showOpenDialog(root.getScene().getWindow());
        if(audio!=null){
            txtAudioPath.setText(audio.getAbsolutePath());

            Media media = new Media(audio.toURI().toString());
            audioPlayer = new MediaPlayer(media);
        } else{
            txtAudioPath.clear();
        }

    }

    public void btnBrowseVideoOnAction(ActionEvent e) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Video","*.mp4","*.mkv"));
        File video = fileChooser.showOpenDialog(root.getScene().getWindow());
        if(video!=null){
            txtVideoPath.setText(video.getAbsolutePath());
            Media media = new Media(video.toURI().toString());

            videoPlayer = new MediaPlayer(media);

        }
    }

    public void btnPlayAudioOnAction(ActionEvent e) {
        if(audioPlayer!=null) audioPlayer.play();
    }

    public void btnStopAudioOnAction(ActionEvent e) {
        if(audioPlayer!=null) audioPlayer.stop();
    }

    public void btnPlayVideoOnAction(ActionEvent e) {
        if(videoPlayer!=null){
            mvPlayer.setMediaPlayer(videoPlayer);
            videoPlayer.play();
        }
    }

    public void btnStopVideoOnAction(ActionEvent e) {
        if(videoPlayer!=null){
            mvPlayer.setMediaPlayer(videoPlayer);
            videoPlayer.stop();
        }
    }
}
