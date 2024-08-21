package game.gui;

import javafx.geometry.Insets;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import game.engine.Battle;
import game.engine.BattlePhase;
import game.engine.base.Wall;
import game.engine.exceptions.InsufficientResourcesException;
import game.engine.exceptions.InvalidLaneException;
import game.engine.lanes.Lane;
import game.engine.titans.AbnormalTitan;
import game.engine.titans.ArmoredTitan;
import game.engine.titans.ColossalTitan;
import game.engine.titans.PureTitan;
import game.engine.titans.Titan;
//import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.*;
//import org.junit.experimental.ParallelComputer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.control.Slider;
import javafx.scene.media.MediaView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

public class View extends Application {

	private Battle battle;
	private Label currentScore;
	private Label currentTurn;
	private Label currentPhase;
	private Label currentResources;
	private int weaponCodeChosen;
	private Label dangerlevel1 = new Label("Danger Level= ");
	private Label dangerlevel2 = new Label("Danger Level= ");
	private Label dangerlevel3 = new Label("Danger Level= ");
	private VBox root4 = new VBox(10);
	private MediaPlayer mediaPlayer2;
	private MediaPlayer mediaPlayer3;
	private boolean stop = false;
	private int settingsNum = 0;
	//EASY
	private FlowPane lane1weaponHB = new FlowPane();
	private FlowPane lane2weaponHB = new FlowPane();
	private FlowPane lane3weaponHB = new FlowPane();
	private FlowPane lane1titans = new FlowPane();
	private FlowPane lane2titans = new FlowPane();
	private FlowPane lane3titans = new FlowPane();
	private Image lane = new Image("lane with wall.jpeg");
	private ImageView lane1 = new ImageView(lane);
	private ImageView lane2 = new ImageView(lane);
	private ImageView lane3 = new ImageView(lane);
	private ProgressBar wallHealth1 = new ProgressBar();
	private ProgressBar wallHealth2 = new ProgressBar();
	private ProgressBar wallHealth3 = new ProgressBar();
	private StackPane lane1weapon = new StackPane(lane1,lane1weaponHB,wallHealth1,lane1titans);
	private StackPane lane2weapon = new StackPane(lane2,lane2weaponHB,wallHealth2,lane2titans);
	private StackPane lane3weapon = new StackPane(lane3,lane3weaponHB,wallHealth3,lane3titans);
	private ColorAdjust colorAdjust = new ColorAdjust();
	private Stage primaryStage = new Stage();
	private Scene s4 = new Scene(root4,1920,1080);
    private StackPane root7 = new StackPane();
    private Scene s1 = new Scene(root7,1920,1080);
    private ImageCursor Cursor;
    private HashMap<Titan,ImageView> titans1 = new HashMap<Titan,ImageView>();
    private HashMap<Titan,ImageView> titans2 = new HashMap<Titan,ImageView>();
    private HashMap<Titan,ImageView> titans3 = new HashMap<Titan,ImageView>();
    private HashMap<Titan,Label> titans1labels = new HashMap<Titan,Label>();
    private HashMap<Titan,Label> titans2labels = new HashMap<Titan,Label>();
    private HashMap<Titan,Label> titans3labels = new HashMap<Titan,Label>();
	private HashMap<Titan,ProgressBar> titans1ProgressBars = new HashMap<Titan,ProgressBar>();
	private HashMap<Titan,ProgressBar> titans2ProgressBars = new HashMap<Titan,ProgressBar>();
	private HashMap<Titan,ProgressBar> titans3ProgressBars = new HashMap<Titan,ProgressBar>();
    
    private ArrayList<ImageView> titans1h = new ArrayList<>();
    private ArrayList<ImageView> titans2h = new ArrayList<>();
    private ArrayList<ImageView> titans3h = new ArrayList<>();
    private ArrayList<ImageView> titans4h = new ArrayList<>();
    private ArrayList<ImageView> titans5h = new ArrayList<>();
    private ArrayList<Label> titans1labelsh = new ArrayList<>();
    private ArrayList<Label> titans2labelsh = new ArrayList<>();
    private ArrayList<Label> titans3labelsh = new ArrayList<>();
    private ArrayList<Label> titans4labelsh = new ArrayList<>();
    private ArrayList<Label> titans5labelsh = new ArrayList<>();

	//HARD
	//HARD Jomana
	private Label dangerlevel1H = new Label("Danger Level= ");
	private Label dangerlevel2H = new Label("Danger Level= ");
	private Label dangerlevel3H = new Label("Danger Level= ");
	private Label dangerlevel4H = new Label("Danger Level= ");
	private Label dangerlevel5H = new Label("Danger Level= ");

	private VBox hardlanes = new VBox(1);
	private ImageView lane1hard = new ImageView(lane);
	private ImageView lane2hard = new ImageView(lane);
	private ImageView lane3hard = new ImageView(lane);
	private ImageView lane4hard = new ImageView(lane);
	private ImageView lane5hard = new ImageView(lane);
	
	private FlowPane lane1titansh = new FlowPane();
	private FlowPane lane2titansh = new FlowPane();
	private FlowPane lane3titansh = new FlowPane();
	private FlowPane lane4titansh = new FlowPane();
	private FlowPane lane5titansh = new FlowPane();
	
	
	private ProgressBar wallHealth1H = new ProgressBar();
	private ProgressBar wallHealth2H = new ProgressBar();
	private ProgressBar wallHealth3H = new ProgressBar();
	private ProgressBar wallHealth4H = new ProgressBar();
	private ProgressBar wallHealth5H = new ProgressBar();
	
	private FlowPane lane1weaponFlow = new FlowPane();
	private FlowPane lane2weaponFlow = new FlowPane();
	private FlowPane lane3weaponFlow = new FlowPane();
	private FlowPane lane4weaponFlow = new FlowPane();
	private FlowPane lane5weaponFlow = new FlowPane();
	
	private StackPane lane1weaponh = new StackPane(lane1hard,lane1weaponFlow,lane1titansh);
	private StackPane lane2weaponh = new StackPane(lane2hard,lane2weaponFlow,lane2titansh);
	private StackPane lane3weaponh = new StackPane(lane3hard,lane3weaponFlow,lane3titansh);
	private StackPane lane4weaponh = new StackPane(lane4hard,lane4weaponFlow,lane4titansh);
	private StackPane lane5weaponh = new StackPane(lane5hard,lane5weaponFlow,lane5titansh);
	
	private StackPane lane1weaponStack = new StackPane(lane1hard,lane1weaponh,lane1weaponFlow,wallHealth1H);
	private StackPane lane2weaponStack = new StackPane(lane2hard,lane2weaponh,lane2weaponFlow,wallHealth2H);
	private StackPane lane3weaponStack = new StackPane(lane3hard,lane3weaponh,lane3weaponFlow,wallHealth3H);
	private StackPane lane4weaponStack = new StackPane(lane4hard,lane4weaponh,lane4weaponFlow,wallHealth4H);
	private StackPane lane5weaponStack = new StackPane(lane5hard,lane5weaponh,lane5weaponFlow,wallHealth5H);
	
	private Label currentScoreH;
	private Label currentTurnH;
	private Label currentPhaseH;
	private Label currentResourcesH;
	private int weaponCodeChosenH;
	private String filePath;

//	private HBox lane1weapon = new HBox(lane1,lane1weaponHB);
	@Override
	public void start(Stage s) throws Exception {  
		primaryStage.setFullScreen(false);
        File file = new File("src/Intro.mp4");
        Media media = new Media(file.toURI().toString());
        MediaPlayer video = new MediaPlayer(media);
        MediaView mediaView = new MediaView(video);
        
		Label label = new Label("Press 'Esc' to close the application.");
		// TODO Auto-generated method stub
		Rectangle background = new Rectangle(800, 50);
		label.setTextFill(javafx.scene.paint.Color.WHITE);
        background.setArcWidth(10);
        background.setArcHeight(10);
        background.setOpacity(0.5);
       
        
		battle = new Battle(0, 0, 0, 0, 0);
		VBox root = new VBox(10);
		Button startGame = new Button("Start Game");
		Background originalBackground = new Background(new BackgroundFill(Color.web("#d1ede9"),new CornerRadii(10), Insets.EMPTY));
		DropShadow dropShadow = new DropShadow();
		dropShadow.setColor(Color.web("#cac9ca"));
		dropShadow.setRadius(10);
		dropShadow.setOffsetX(-3);
		dropShadow.setOffsetY(3);
		startGame.setPrefHeight(26);
		startGame.setPrefWidth(190);
		startGame.setBackground(originalBackground);
		startGame.setPadding(new Insets(10));
		startGame.setOnMouseEntered(e -> startGame.setEffect(dropShadow));
		startGame.setOnMouseExited(e -> startGame.setEffect(null));
		Button Instructions = new Button("Game Instructions");
		Instructions.setBackground(originalBackground);
		Instructions.setPadding(new Insets(10));
		Instructions.setOnMouseEntered(e -> Instructions.setEffect(dropShadow));
		Instructions.setOnMouseExited(e -> Instructions.setEffect(null));
		root.setAlignment(Pos.CENTER);
		root.setStyle("-fx-background-color: transparent");
		root.setTranslateY(20);
		Instructions.setPrefHeight(26);
		Instructions.setPrefWidth(300);
		InputStream is = getClass().getResourceAsStream("/SpaceGames.otf");
		Font font = Font.loadFont(is,16);
		label.setFont(font);
		Instructions.setFont(font);
		startGame.setFont(font);
		//scene 1  
        StackPane messagePane = new StackPane();
        messagePane.getChildren().addAll(background, label);
        root7.setStyle("-fx-background-color: transparent");

        root7.getChildren().addAll(root,messagePane);

		//set close with esc
		s1.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode() == KeyCode.ESCAPE) {
                primaryStage.close(); // Close the stage when 'Esc' is pressed
            }
        });
		
		  Timeline timeline = new Timeline(new KeyFrame(
	                Duration.seconds(4),
	                event -> root7.getChildren().remove(messagePane)
	            ));
	            timeline.play();
	          
	    Image cursorImage = new Image(getClass().getResourceAsStream("/Cursor.png"));	            
	    Cursor = new ImageCursor(cursorImage, cursorImage.getWidth()/2, cursorImage.getHeight()/2);
	    s1.setCursor(Cursor);	
	    
		primaryStage.setTitle("Attack on Titan: Utopia");
		//add icon
		Image icon = new Image("icon.jpeg");
		//add bg
		Image backgroundImage = new Image("Backg.jpg");
		ImagePattern backIP = new ImagePattern(backgroundImage);
		s1.setFill(backIP);
		primaryStage.setScene(s1);
		Image logoPic = new Image("logo.png");
		ImageView logo = new ImageView(logoPic);
		logo.setFitHeight(200);
		logo.setFitWidth(500);
		logo.setLayoutX(558.0);
		logo.setLayoutY(311.0);
		logo.setTranslateY(-45);
		
		Media defaultButtonSound = new Media(new File("src/defaultButtonSound.mp3").toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(defaultButtonSound);
		Media modeButtonSound = new Media(new File("src/modeButtonSound.mp3").toURI().toString());
		MediaPlayer mediaPlayer1 = new MediaPlayer(modeButtonSound);
		Slider systemVolume = new Slider(0, 1, 0.5);
        systemVolume.setShowTickMarks(true);
        systemVolume.setShowTickLabels(true);
        systemVolume.setMajorTickUnit(100);
        systemVolume.setMaxWidth(100); 
		mediaPlayer.volumeProperty().bind(systemVolume.valueProperty());
		mediaPlayer1.volumeProperty().bind(systemVolume.valueProperty());
		Media defaultMusic = new Media(new File("src/VanguardOfHope.mp3").toURI().toString());
		mediaPlayer2 = new MediaPlayer(defaultMusic);
		mediaPlayer2.setCycleCount(MediaPlayer.INDEFINITE);
		Media grumblingMusic = new Media(new File("src/BarbariansAtTheGate.mp3").toURI().toString());
		mediaPlayer3 = new MediaPlayer(grumblingMusic);
		mediaPlayer3.setCycleCount(MediaPlayer.INDEFINITE);
		Slider musicVolume = new Slider(0, 1, 0.5);
        musicVolume.setShowTickMarks(true);
        musicVolume.setShowTickLabels(true);
        musicVolume.setMajorTickUnit(100);
        musicVolume.setMaxWidth(100); 
		mediaPlayer2.volumeProperty().bind(musicVolume.valueProperty());
		mediaPlayer3.volumeProperty().bind(musicVolume.valueProperty());
	    mediaPlayer2.seek(Duration.ZERO); 
	    mediaPlayer2.play(); 
		
		HBox systemVol = new HBox(20);
		Label sysVol = new Label("System Volume");
		sysVol.setStyle("-fx-font-family: 'Space Games'; -fx-font-size: 30; ");
		sysVol.setTextFill(javafx.scene.paint.Color.WHITE);
		systemVol.getChildren().addAll(sysVol,systemVolume);
		HBox musicVol = new HBox(20);
		Label musVol = new Label("Music Volume");
		musVol.setStyle("-fx-font-family: 'Space Games'; -fx-font-size: 30; ");
		musVol.setTextFill(javafx.scene.paint.Color.WHITE);
		musicVol.getChildren().addAll(musVol,musicVolume);
		Image blurredImage = new Image("blurredBackg.jpeg");
        VBox settingsSliders = new VBox(30);
        settingsSliders.setLayoutX(750);
        settingsSliders.setLayoutY(500);
		settingsSliders.setStyle("-fx-background-color: transparent");
        settingsSliders.getChildren().addAll(systemVol,musicVol);
        Scene settings = new Scene(settingsSliders,1920,1080);
        settings.setFill(new ImagePattern(blurredImage));
        settings.setCursor(Cursor);
		Button backButtonSettings = new Button("Back");
		settings.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode() == KeyCode.ESCAPE) {
                primaryStage.close(); // Close the stage when 'Esc' is pressed
            }
        });
		settingsSliders.getChildren().add(backButtonSettings);
		backButtonSettings.setPrefWidth(10);
		backButtonSettings.setPrefWidth(150);
		backButtonSettings.setBackground(originalBackground);
		backButtonSettings.setPadding(new Insets(10));
		backButtonSettings.setOnMouseEntered(e -> backButtonSettings.setEffect(dropShadow));
		backButtonSettings.setOnMouseExited(e -> backButtonSettings.setEffect(null));
		backButtonSettings.setTranslateX(140);
		backButtonSettings.setStyle("-fx-font-family: 'Space Games'; -fx-font-size: 24; ");
        Image settingsIc = new Image("Settings.png");
        ImageView settingsIcon = new ImageView(settingsIc);
        settingsIcon.setFitHeight(40);
        settingsIcon.setFitWidth(40);
		Button settingsButton = new Button();
        settingsButton.setGraphic(settingsIcon);
		settingsButton.setPrefHeight(40);
		settingsButton.setPrefWidth(40);
		settingsButton.setTranslateX(700);
		settingsButton.setTranslateY(-600);
		settingsButton.setStyle("-fx-background-color: transparent");
		settingsButton.setOnAction(new EventHandler<ActionEvent>() {			
		public void handle(ActionEvent event) {
			mediaPlayer.seek(Duration.ZERO);
			mediaPlayer.play();
			settingsNum = 1;
			primaryStage.setScene(settings);
			
			}
			});
        
		root.getChildren().add(logo);
		root.getChildren().addAll(startGame, Instructions,settingsButton);
		HBox easyHard = new HBox(100);
		VBox root2 = new VBox(65);
		Scene s2 = new Scene(root2,1920,1080);
		s2.setFill(backIP);
		s2.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode() == KeyCode.ESCAPE) {
                primaryStage.close(); // Close the stage when 'Esc' is pressed
            }
        });
		Cursor = new ImageCursor(cursorImage, cursorImage.getWidth()/2, cursorImage.getHeight()/2);
	    s2.setCursor(Cursor);
		Label choose = new Label("Choose Game mode");
		//choose.setTranslateY(-20);
		root2.setTranslateY(-10);
		choose.setStyle("-fx-font-family: 'Space Games'; -fx-font-size: 30; -fx-font-color: #979798; ");
		choose.setTextFill(javafx.scene.paint.Color.WHITE);
		//buttons for easy and hard
		Button Easy = new Button("Easy");
		Button Hard = new Button("Hard");

		root2.setAlignment(Pos.CENTER);
		root2.setStyle("-fx-background-color: transparent");
		easyHard.setAlignment(Pos.CENTER);
		easyHard.setStyle("-fx-background-color: transparent");

		Easy.setPrefHeight(26);
		Easy.setPrefWidth(113);
		Easy.setFont(font);
		Easy.setBackground(originalBackground);
		Easy.setPadding(new Insets(10));
		Easy.setOnMouseEntered(e -> Easy.setEffect(dropShadow));
		Easy.setOnMouseExited(e -> Easy.setEffect(null));
		Hard.setPrefHeight(26);
		Hard.setPrefWidth(113);
		Hard.setFont(font);
		Hard.setBackground(originalBackground);
		Hard.setPadding(new Insets(10));
		Hard.setOnMouseEntered(e -> Hard.setEffect(dropShadow));
		Hard.setOnMouseExited(e -> Hard.setEffect(null));
		Button easyHardSettingsButton = new Button();
		easyHardSettingsButton.setGraphic(settingsIcon);
		easyHardSettingsButton.setPrefHeight(40);
		easyHardSettingsButton.setPrefWidth(40);
		easyHardSettingsButton.setTranslateX(700);
		easyHardSettingsButton.setTranslateY(-475);
		easyHardSettingsButton.setStyle("-fx-background-color: transparent");
		easyHardSettingsButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				mediaPlayer.seek(Duration.ZERO);
				mediaPlayer.play();
				settingsNum = 2;
				primaryStage.setScene(settings);
			}
		});
		root2.getChildren().addAll(choose,easyHard,easyHardSettingsButton);
		easyHard.getChildren().addAll(Easy, Hard);

		
		AnchorPane videopane = new AnchorPane();
		videopane.getChildren().add(mediaView);
		mediaView.setFitWidth(1920);
		mediaView.setFitHeight(1080);
		Scene video1 = new Scene(videopane,1920,1080);
		
		video1.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode() == KeyCode.ESCAPE) {
                primaryStage.close(); 
            }
        });
		Cursor = new ImageCursor(cursorImage, cursorImage.getWidth()/2, cursorImage.getHeight()/2);
	    video1.setCursor(Cursor);
		Button skip = new Button("skip");
		videopane.getChildren().add(skip);
		skip.setFont(font);
		skip.setTextFill(javafx.scene.paint.Color.WHITE);
		skip.setStyle("-fx-background-color: transparent");
		skip.setLayoutX(1600);
		skip.setLayoutY(900);
		skip.setTranslateY(-8);
		skip.setTranslateX(20);
		startGame.setOnAction(new EventHandler<ActionEvent>() {
		public void handle(ActionEvent event) {
		    mediaPlayer.seek(Duration.ZERO); 
		    mediaPlayer.play(); 
		    mediaPlayer2.pause();
		    video.play();
			primaryStage.setScene(video1);
			}
			});
		 
		
		skip.setOnAction(new EventHandler<ActionEvent>() {			
			public void handle(ActionEvent event) {
			    mediaPlayer.seek(Duration.ZERO); 
			    mediaPlayer.play(); 
			    video.stop();
				primaryStage.setScene(s2);
				mediaPlayer2.play();
				}
				});
		video.setOnEndOfMedia(() -> {
            primaryStage.setScene(s2);
			mediaPlayer2.play();
        });
		VBox root3 = new VBox(10);
		Scene s3 = new Scene(root3,1920,1080);
		s3.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode() == KeyCode.ESCAPE) {
                primaryStage.close(); // Close the stage when 'Esc' is pressed
            }
        });
		Cursor = new ImageCursor(cursorImage, cursorImage.getWidth()/2, cursorImage.getHeight()/2);
	    s3.setCursor(Cursor);
		//Label instructionsLabel = new Label("Instructions");
		Button back = new Button("Back");
		back.setStyle("-fx-font-family: 'Space Games'; -fx-font-size: 16;");
		root3.setAlignment(Pos.CENTER);
		root3.setStyle("-fx-background-color: transparent");
		back.setPrefWidth(100);
		back.setPrefHeight(40);
		back.setBackground(originalBackground);
		back.setPadding(new Insets(10));
		back.setOnMouseEntered(e -> back.setEffect(dropShadow));
		back.setOnMouseExited(e -> back.setEffect(null));
		Image Instructionsimage = new Image("InstructionsImage.png");
		ImageView InstructionsIV = new ImageView(Instructionsimage);
		InstructionsIV.setFitWidth(1182);
		InstructionsIV.setFitHeight(662);
		root3.getChildren().addAll(InstructionsIV,back);
		Instructions.setStyle("-fx-font-family: 'Space Games'; -fx-font-size: 16;");
		back.setAlignment(Pos.BOTTOM_CENTER);
		s3.setFill(new ImagePattern(blurredImage));
		
		Instructions.setOnAction(new EventHandler<ActionEvent>() {			
			public void handle(ActionEvent event) {
			    mediaPlayer.seek(Duration.ZERO); 
			    mediaPlayer.play();
				primaryStage.setScene(s3);		
				}
				});
				
		back.setOnAction(new EventHandler<ActionEvent>() {			
			public void handle(ActionEvent event) {
			    mediaPlayer.seek(Duration.ZERO); 
			    mediaPlayer.play();
				primaryStage.setScene(s1);			
				}
				});

		Label currentRescourcesInShop = new Label();
		currentRescourcesInShop.setTextFill(javafx.scene.paint.Color.WHITE);
		currentRescourcesInShop.setLayoutX(48);
		currentRescourcesInShop.setLayoutY(84);

		//root4
		s4.setFill(new ImagePattern(blurredImage));
		root4.setStyle("-fx-background-color: transparent");

		
		Easy.setOnAction(new EventHandler<ActionEvent>() {			
			public void handle(ActionEvent event) {
				// check for 700 for titan spawn distance
				try {
					battle = new Battle(1, 0, 700, 3, 250);
					//System.out.println("Easy battle starts now");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				updateall();
			    mediaPlayer1.seek(Duration.ZERO); 
			    mediaPlayer1.play();
				primaryStage.setScene(s4);
				}
				});
		s4.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode() == KeyCode.ESCAPE) {
                primaryStage.close(); // Close the stage when 'Esc' is pressed
            }
        });
		Cursor = new ImageCursor(cursorImage, cursorImage.getWidth()/2, cursorImage.getHeight()/2);
	    s4.setCursor(Cursor);
	    
		currentScore = new Label("Current score: " );
		currentTurn= new Label("Current Turn: " );
		currentPhase= new Label("Current Phase:" );
		currentResources= new Label("Current Resources: ");
		currentScore.setStyle("-fx-font-family: 'Space Games'; -fx-font-size: 18;");
		currentScore.setTextFill(javafx.scene.paint.Color.WHITE);
		currentTurn.setStyle("-fx-font-family: 'Space Games'; -fx-font-size: 18;");
		currentTurn.setTextFill(javafx.scene.paint.Color.WHITE);
		currentPhase.setStyle("-fx-font-family: 'Space Games'; -fx-font-size: 18;");
		currentPhase.setTextFill(javafx.scene.paint.Color.WHITE);
		currentResources.setStyle("-fx-font-family: 'Space Games'; -fx-font-size: 18;");
		currentResources.setTextFill(javafx.scene.paint.Color.WHITE);
		HBox labels = new HBox(35);
		labels.setAlignment(Pos.CENTER);
		labels.getChildren().addAll(currentScore,currentTurn,currentPhase,currentResources);
		dangerlevel1.setStyle("-fx-font-family: 'Space Games'; -fx-font-size: 18;");
		dangerlevel1.setTextFill(javafx.scene.paint.Color.WHITE);
		dangerlevel2.setStyle("-fx-font-family: 'Space Games'; -fx-font-size: 18;");
		dangerlevel2.setTextFill(javafx.scene.paint.Color.WHITE);
		dangerlevel3.setStyle("-fx-font-family: 'Space Games'; -fx-font-size: 18;");
		dangerlevel3.setTextFill(javafx.scene.paint.Color.WHITE);
		lane1.setFitHeight(200);
		lane1.setFitWidth(1400);
		lane2.setFitHeight(200);
		lane2.setFitWidth(1400);
		lane3.setFitHeight(200);
		lane3.setFitWidth(1400);
		colorAdjust.setBrightness(-0.5);
		
		
		lane1weaponHB.setPrefWidth(150);
		lane1weaponHB.setTranslateY(-8);
		lane1weaponHB.setTranslateX(-580);
		lane1weaponHB.setMaxWidth(180);
		lane1weaponHB.setMaxHeight(100);
		
		lane2weaponHB.setPrefWidth(150);
		lane2weaponHB.setTranslateY(-8);
		lane2weaponHB.setTranslateX(-580);
		lane2weaponHB.setMaxWidth(180);
		lane2weaponHB.setMaxHeight(100);
		
		lane3weaponHB.setPrefWidth(150);
		lane3weaponHB.setTranslateY(-8);
		lane3weaponHB.setTranslateX(-580);
		lane3weaponHB.setMaxWidth(180);
		lane3weaponHB.setMaxHeight(100);

			
		lane1titans.setPrefWidth(150);
		lane1titans.setTranslateY(0);
		lane1titans.setTranslateX(0);
		lane1titans.setMaxWidth(200);
		lane1titans.setMaxHeight(1400);
		
		lane2titans.setPrefWidth(150);
		lane2titans.setTranslateY(0);
		lane2titans.setTranslateX(0);
		lane2titans.setMaxWidth(200);
		lane2titans.setMaxHeight(1400);
		
		lane3titans.setPrefWidth(150);
		lane3titans.setTranslateY(0);
		lane3titans.setTranslateX(0);
		lane3titans.setMaxWidth(200);
		lane3titans.setMaxHeight(1400);
		
		wallHealth1.setPrefWidth(50);
		wallHealth1.setPrefHeight(15);
		wallHealth1.setRotate(-90);
		wallHealth1.setTranslateX(-455);
		wallHealth1.setStyle("-fx-accent: #4f7696; -fx-border-width:0.5px");
		
		wallHealth2.setPrefWidth(50);
		wallHealth2.setPrefHeight(15);
		wallHealth2.setRotate(-90);
		wallHealth2.setTranslateX(-455);
		wallHealth2.setStyle("-fx-accent: #4f7696; -fx-border-width:0.5px");
		
		wallHealth3.setPrefWidth(50);
		wallHealth3.setPrefHeight(15);
		wallHealth3.setRotate(-90);
		wallHealth3.setTranslateX(-455);
		wallHealth3.setStyle("-fx-accent: #4f7696; -fx-border-width:0.5px");
		
		
		root4.setTranslateY(-40);
		root4.setAlignment(Pos.CENTER);
		root4.getChildren().add(0,labels);
		root4.getChildren().add(1,dangerlevel1);
		root4.getChildren().add(2,lane1weapon);
		root4.getChildren().add(3,dangerlevel2);
		root4.getChildren().add(4,lane2weapon);
		root4.getChildren().add(5,dangerlevel3);
		root4.getChildren().add(6,lane3weapon);
		HBox purchaseAndPass = new HBox(20);
		Button purchase = new Button("Purchase");
		Button pass = new Button("Pass");
		purchase.setFont(font);
		purchase.setBackground(originalBackground);
		purchase.setPadding(new Insets(10));
		purchase.setOnMouseEntered(e -> purchase.setEffect(dropShadow));
		purchase.setOnMouseExited(e -> purchase.setEffect(null));
		pass.setFont(font);
		pass.setBackground(originalBackground);
		pass.setPadding(new Insets(10));
		pass.setOnMouseEntered(e -> pass.setEffect(dropShadow));
		pass.setOnMouseExited(e -> pass.setEffect(null));
		purchaseAndPass.setAlignment(Pos.CENTER);
		Button easySettingsButton = new Button();
		easySettingsButton.setGraphic(settingsIcon);
		easySettingsButton.setPrefHeight(40);
		easySettingsButton.setPrefWidth(40);
		easySettingsButton.setStyle("-fx-background-color: transparent");
		easySettingsButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				mediaPlayer.seek(Duration.ZERO);
				mediaPlayer.play();
				settingsNum = 3;
				primaryStage.setScene(settings);
			}
		});
		purchaseAndPass.getChildren().addAll(purchase,pass,easySettingsButton);
		root4.getChildren().add(purchaseAndPass);
		VBox root5 = new VBox(10);
		
		root5.setStyle("-fx-background-color: transparent");		
		pass.setOnAction(new EventHandler<ActionEvent>() {			
			public void handle(ActionEvent event) {
				
				battle.passTurn();
				spawnTitansi();
				updateall();
			    mediaPlayer.seek(Duration.ZERO); 
			    mediaPlayer.play();
				}
		});
		
		StackPane weapon = new StackPane();
		weapon.setAlignment(Pos.CENTER);
		weapon.setPrefHeight(1080);
		weapon.setPrefWidth(1920);
		weapon.setStyle("-fx-background-color: transparent");
		Scene weaponshop = new Scene(weapon,1920,1080);
		Cursor = new ImageCursor(cursorImage, cursorImage.getWidth()/2, cursorImage.getHeight()/2);
		weaponshop.setCursor(Cursor);
		Image weaponshopimage = new Image("shop layout.jpeg");
		ImageView weaponShopImageView = new ImageView(weaponshopimage);
		weaponshop.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode() == KeyCode.ESCAPE) {
                primaryStage.close(); // Close the stage when 'Esc' is pressed
            }
        });

		weapon.getChildren().add(weaponShopImageView);
    
        weaponShopImageView.setFitWidth(1365);
        weaponShopImageView.setFitHeight(768);
        weaponShopImageView.setTranslateY(-35);
        weapon.setStyle("-fx-background-color: #2d0c3b;");
		Button purchasePiercing = new Button("Purchase");
		Button purchaseSniper = new Button("Purchase");
		Button purchaseVolley = new Button("Purchase");
		Button purchaseWallTrap = new Button("Purchase");
		
		Font font2 = new Font("Britannic Bold", 12);
		
		//lanes choice box
		ChoiceBox<String> selectLane = new ChoiceBox<>();
        selectLane.getItems().addAll("Lane 1", "Lane 2", "Lane 3");
        selectLane.setTranslateY(240);
        selectLane.setPrefWidth(150);
		currentRescourcesInShop.setStyle("-fx-font-family: 'Space Games'; -fx-font-size: 16;");
		currentRescourcesInShop.setTextFill(javafx.scene.paint.Color.WHITE);
		currentRescourcesInShop.setTranslateX(-400);
		currentRescourcesInShop.setTranslateY(-400);
		weapon.getChildren().addAll(purchasePiercing,purchaseSniper,purchaseVolley,purchaseWallTrap,currentRescourcesInShop, selectLane);
		Image piercingCannon = new Image("weapon1.png");
		Image sniperCannon = new Image("weapon2.png");
		Image volleySpreadCannon = new Image("weapon3.png");
		Image wallTrap = new Image("weapon4.png");
		
		//first button
				purchasePiercing.setTranslateX(-435);
				purchasePiercing.setTranslateY(160);
				purchasePiercing.setFont(font2);
				purchasePiercing.setStyle("-fx-background-color: #dfbd69;");
				purchasePiercing.setPrefHeight(50-20);
				purchasePiercing.setPrefWidth(160-20-20);
				//second button
				purchaseSniper.setTranslateX(-141);
				purchaseSniper.setTranslateY(160);
				purchaseSniper.setFont(font2);
				purchaseSniper.setStyle("-fx-background-color: #dfbd69;");
				purchaseSniper.setPrefHeight(30);
				purchaseSniper.setPrefWidth(160-20-20);
				//third button
				purchaseVolley.setTranslateX(150);
				purchaseVolley.setTranslateY(160);
				purchaseVolley.setFont(font2);
				purchaseVolley.setStyle("-fx-background-color: #dfbd69;");
				purchaseVolley.setPrefHeight(30);
				purchaseVolley.setPrefWidth(160-20-20);
				//fourth button
				purchaseWallTrap.setTranslateX(443);
				purchaseWallTrap.setTranslateY(160);
				purchaseWallTrap.setFont(font2);
				purchaseWallTrap.setStyle("-fx-background-color: #dfbd69;");
				purchaseWallTrap.setPrefHeight(30);
				purchaseWallTrap.setPrefWidth(160-20-20);
		selectLane.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
		    mediaPlayer.seek(Duration.ZERO); 
		    mediaPlayer.play();
		    //spawnTitans();
            // Switch to the corresponding scene based on the selected choice
            if ("Lane 1".equals(newValue)) {
                // Load and set the scene for Option 1
            	if(weaponCodeChosen != 0)
            	{
                    try {
    					battle.purchaseWeapon(weaponCodeChosen,battle.getOriginalLanes().get(0));
    				} catch (InsufficientResourcesException e) {
    					// TODO Auto-generated catch block
    					displayAlert("Insufficient Resources","Not enough resources, resources provided = " + battle.getResourcesGathered());
    				} catch (InvalidLaneException e) {
    					// TODO Auto-generated catch block
    					displayAlert("Invalid Lane","Choose Another Lane this lane is Lost");
    					weaponCodeChosen = -1;
    				}
            	}
             updateall();
             if(weaponCodeChosen == 1)
             {
            		ImageView piercing = new ImageView(piercingCannon);
             		 piercing.setFitHeight(50);
            		 piercing.setFitWidth(25);
            		 lane1weaponHB.getChildren().add(piercing);
            	 //need to add animation even if added more than once
            	 primaryStage.setScene(s4);
            	 
             }
             else 
             {
                 if(weaponCodeChosen == 2)
                 {
                		 ImageView sniper = new ImageView(sniperCannon);
                 		 sniper.setFitHeight(50);
                		 sniper.setFitWidth(25);
                		 lane1weaponHB.getChildren().add(sniper);
                	 primaryStage.setScene(s4);
                	 
                 }
                 else 
                 {
                     if(weaponCodeChosen == 3)
                     {   
                    	 ImageView volleySpread = new ImageView(volleySpreadCannon);
                 		 volleySpread.setFitHeight(50);
                		 volleySpread.setFitWidth(25);
                		 lane1weaponHB.getChildren().add(volleySpread);
                    	 primaryStage.setScene(s4);
                    	 
                     }
                     else 
                     {
                         if(weaponCodeChosen == 4)
                         {
                        	  ImageView wallT = new ImageView(wallTrap);
                        	  wallT.setFitHeight(50);
                        	  wallT.setFitWidth(25);
                        	  lane1weaponHB.getChildren().add(wallT);                       	  
                        	  primaryStage.setScene(s4);
                         }
                         else 
                         {	if(weaponCodeChosen == 0)
						   {
                        	displayAlert("Error", "Please Choose a Weapon Before Purchasing");
							selectLane.setValue(null);
						   }
                         	
                         }
                     }
                     
				}
             }
                
            } else if ("Lane 2".equals(newValue)) {
                // Load and set the scene for Option 2
            	if(weaponCodeChosen != 0)
            	{
                    try {
    					battle.purchaseWeapon(weaponCodeChosen,battle.getOriginalLanes().get(1));
    				} catch (InsufficientResourcesException e) {
    					// TODO Auto-generated catch block
    					displayAlert("Insufficient Resources","Not enough resources, resources provided = " + battle.getResourcesGathered());
    				} catch (InvalidLaneException e) {
    					// TODO Auto-generated catch block
    					displayAlert("Invalid Lane","Choose Another Lane this lane is Lost");
    					weaponCodeChosen = -1;
    				}
            	}
             updateall();
             if(weaponCodeChosen == 1)
             {
            		ImageView piercing = new ImageView(piercingCannon);
             		 piercing.setFitHeight(50);
            		 piercing.setFitWidth(25);
            		 lane2weaponHB.getChildren().add(piercing);
            		 //need to add animation even if added more than once
            		 primaryStage.setScene(s4);
            	 
             }
             else 
             {
                 if(weaponCodeChosen == 2)
                 {
                		 ImageView sniper = new ImageView(sniperCannon);
                 		 sniper.setFitHeight(50);
                		 sniper.setFitWidth(25);
                		 lane2weaponHB.getChildren().add(sniper);
                	 primaryStage.setScene(s4);
                	 
                 }
                 else 
                 {
                     if(weaponCodeChosen == 3)
                     {   
                    	 ImageView volleySpread = new ImageView(volleySpreadCannon);
                 		 volleySpread.setFitHeight(50);
                		 volleySpread.setFitWidth(25);
                		 lane2weaponHB.getChildren().add(volleySpread);
                    	 primaryStage.setScene(s4);
                    	 
                     }
                     else 
                     {
                         if(weaponCodeChosen == 4)
                         {
                        	  ImageView wallT = new ImageView(wallTrap);
                        	  wallT.setFitHeight(50);
                        	  wallT.setFitWidth(25);
                        	  lane2weaponHB.getChildren().add(wallT);                       	  
                        	  primaryStage.setScene(s4);
                         }
                         else 
                         {	if(weaponCodeChosen == 0)
						   {
                        	displayAlert("Error", "Please Choose a Weapon Before Purchasing");
							selectLane.setValue(null);
						   }
                         	
                         }
                     }
                     
				}
             }
                
            } else if ("Lane 3".equals(newValue)) {
                // Load and set the scene for Option 3
            	if(weaponCodeChosen != 0)
            	{
                    try {
    					battle.purchaseWeapon(weaponCodeChosen,battle.getOriginalLanes().get(2));
    				} catch (InsufficientResourcesException e) {
    					// TODO Auto-generated catch block
    					displayAlert("Insufficient Resources","Not enough resources, resources provided = " + battle.getResourcesGathered());
    				} catch (InvalidLaneException e) {
    					// TODO Auto-generated catch block
    					displayAlert("Invalid Lane","Choose Another Lane this lane is Lost");
    					weaponCodeChosen = -1;
    				}
            	}
             updateall();
             if(weaponCodeChosen == 1)
             {
            		ImageView piercing = new ImageView(piercingCannon);
             		 piercing.setFitHeight(50);
            		 piercing.setFitWidth(25);
            		 lane3weaponHB.getChildren().add(piercing);
            		 //need to add animation even if added more than once
            		 primaryStage.setScene(s4);
            	 
             }
             else 
             {
                 if(weaponCodeChosen == 2)
                 {
                		 ImageView sniper = new ImageView(sniperCannon);
                 		 sniper.setFitHeight(50);
                		 sniper.setFitWidth(25);
                		 lane3weaponHB.getChildren().add(sniper);
                		 primaryStage.setScene(s4);
                	 
                 }
                 else 
                 {
                     if(weaponCodeChosen == 3)
                     {   
                    	 ImageView volleySpread = new ImageView(volleySpreadCannon);
                 		 volleySpread.setFitHeight(50);
                		 volleySpread.setFitWidth(25);
                		 lane3weaponHB.getChildren().add(volleySpread);
                    	 primaryStage.setScene(s4);
                    	 
                     }
                     else 
                     {
                         if(weaponCodeChosen == 4)
                         {
                        	  ImageView wallT = new ImageView(wallTrap);
                        	  wallT.setFitHeight(50);
                        	  wallT.setFitWidth(25);
                        	  lane3weaponHB.getChildren().add(wallT);                       	  
                        	  primaryStage.setScene(s4);
                         }
                         else 
                         {	if(weaponCodeChosen == 0)
						   {
                        	displayAlert("Error", "Please Choose a Weapon Before Purchasing");
							selectLane.setValue(null);
						   }
                         	
                         }
                     }
                     
				}
             }
                
            }
			spawnTitansi();
        });
		purchase.setOnAction(new EventHandler<ActionEvent>() {			
			public void handle(ActionEvent event) {
				selectLane.setValue(null);
				weaponCodeChosen = 0;
				currentRescourcesInShop.setText(currentResources.getText());
				primaryStage.setScene(weaponshop);
			    mediaPlayer.seek(Duration.ZERO); 
			    mediaPlayer.play();
				}
		});
		purchasePiercing.setOnAction(new EventHandler<ActionEvent>() {			
			public void handle(ActionEvent event) {
				weaponCodeChosen = 1;
			    mediaPlayer.seek(Duration.ZERO); 
			    mediaPlayer.play();
				}
		});
		purchaseSniper.setOnAction(new EventHandler<ActionEvent>() {			
			public void handle(ActionEvent event) {
				weaponCodeChosen = 2;
			    mediaPlayer.seek(Duration.ZERO); 
			    mediaPlayer.play();
				}
		});
		purchaseVolley.setOnAction(new EventHandler<ActionEvent>() {			
			public void handle(ActionEvent event) {
				weaponCodeChosen = 3;
			    mediaPlayer.seek(Duration.ZERO); 
			    mediaPlayer.play();
				}
		});
		purchaseWallTrap.setOnAction(new EventHandler<ActionEvent>() {			
			public void handle(ActionEvent event) {
				weaponCodeChosen = 4;
			    mediaPlayer.seek(Duration.ZERO); 
			    mediaPlayer.play();
				}
		});
		
		//Hard here Jomana
		hardlanes.setTranslateY(-40);
		Scene s5 = new Scene(hardlanes,1920,1080);
		s5.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode() == KeyCode.ESCAPE) {
                primaryStage.close(); // Close the stage when 'Esc' is pressed
            }
        });
		Cursor = new ImageCursor(cursorImage, cursorImage.getWidth()/2, cursorImage.getHeight()/2);
	    s5.setCursor(Cursor);
	    
		s5.setFill(new ImagePattern(blurredImage));
		hardlanes.setStyle("-fx-background-color: transparent");
		Hard.setOnAction(new EventHandler<ActionEvent>() {			
			public void handle(ActionEvent event) {
				// check for 700 for titan spawn distance
				try {
					battle = new Battle(1, 0, 700, 5, 125);
					updateallHard();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			    mediaPlayer1.seek(Duration.ZERO); 
			    mediaPlayer1.play();
				primaryStage.setScene(s5);
				}
		});
		backButtonSettings.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				mediaPlayer.seek(Duration.ZERO);
				mediaPlayer.play();
				if (settingsNum == 1)
					primaryStage.setScene(s1);
				else if (settingsNum == 2)
					primaryStage.setScene(s2);
				else if (settingsNum == 3)
					primaryStage.setScene(s4);
				else if (settingsNum == 4)
					primaryStage.setScene(s5);
			}
		});
		currentScoreH = new Label("Current score: " );
		currentTurnH= new Label("Current Turn: " );
		currentPhaseH= new Label("Current Phase: " );
		currentResourcesH= new Label("Current Resources: ");
		currentScoreH.setStyle("-fx-font-family: 'Space Games'; -fx-font-size: 16;");
		currentScoreH.setTextFill(javafx.scene.paint.Color.WHITE);
		currentTurnH.setStyle("-fx-font-family: 'Space Games'; -fx-font-size: 16;");
		currentTurnH.setTextFill(javafx.scene.paint.Color.WHITE);
		currentPhaseH.setStyle("-fx-font-family: 'Space Games'; -fx-font-size: 16;");
		currentPhaseH.setTextFill(javafx.scene.paint.Color.WHITE);
		currentResourcesH.setStyle("-fx-font-family: 'Space Games'; -fx-font-size: 16;");
		currentResourcesH.setTextFill(javafx.scene.paint.Color.WHITE);
		
		HBox labelsH = new HBox(35);
		labelsH.setAlignment(Pos.CENTER);
		labelsH.getChildren().addAll(currentScoreH,currentTurnH,currentPhaseH,currentResourcesH);
		dangerlevel1H.setStyle("-fx-font-family: 'Space Games'; -fx-font-size: 18;");
		dangerlevel1H.setTextFill(javafx.scene.paint.Color.WHITE);
		dangerlevel2H.setStyle("-fx-font-family: 'Space Games'; -fx-font-size: 18;");
		dangerlevel2H.setTextFill(javafx.scene.paint.Color.WHITE);
		dangerlevel3H.setStyle("-fx-font-family: 'Space Games'; -fx-font-size: 18;");
		dangerlevel3H.setTextFill(javafx.scene.paint.Color.WHITE);
		dangerlevel4H.setStyle("-fx-font-family: 'Space Games'; -fx-font-size: 18;");
		dangerlevel4H.setTextFill(javafx.scene.paint.Color.WHITE);
		dangerlevel5H.setStyle("-fx-font-family: 'Space Games'; -fx-font-size: 18;");
		dangerlevel5H.setTextFill(javafx.scene.paint.Color.WHITE);
		//lane dimensions
		lane1hard.setFitHeight(125);
		lane1hard.setFitWidth(1400);
		lane2hard.setFitHeight(125);
		lane2hard.setFitWidth(1400);
		lane3hard.setFitHeight(125);
		lane3hard.setFitWidth(1400);
		lane4hard.setFitHeight(125);
		lane4hard.setFitWidth(1400);
		lane5hard.setFitHeight(125);
		lane5hard.setFitWidth(1400);
		
		//FLOW
		lane1weaponFlow.setPrefWidth(150);
		lane1weaponFlow.setTranslateY(-8);
		lane1weaponFlow.setTranslateX(-580);
		lane1weaponFlow.setMaxWidth(230);
		lane1weaponFlow.setMaxHeight(100);
		
		lane2weaponFlow.setPrefWidth(150);
		lane2weaponFlow.setTranslateY(-8);
		lane2weaponFlow.setTranslateX(-580);
		lane2weaponFlow.setMaxWidth(230);
		lane2weaponFlow.setMaxHeight(100);
		
		lane3weaponFlow.setPrefWidth(150);
		lane3weaponFlow.setTranslateY(-8);
		lane3weaponFlow.setTranslateX(-580);
		lane3weaponFlow.setMaxWidth(230);
		lane3weaponFlow.setMaxHeight(100);
		
		lane4weaponFlow.setPrefWidth(150);
		lane4weaponFlow.setTranslateY(-8);
		lane4weaponFlow.setTranslateX(-580);
		lane4weaponFlow.setMaxWidth(230);
		lane4weaponFlow.setMaxHeight(100);
		
		lane5weaponFlow.setPrefWidth(150);
		lane5weaponFlow.setTranslateY(-8);
		lane5weaponFlow.setTranslateX(-580);
		lane5weaponFlow.setMaxWidth(230);
		lane5weaponFlow.setMaxHeight(100);
		
		//progressbars
		wallHealth1H.setPrefWidth(50);
		wallHealth1H.setPrefHeight(15);
		wallHealth1H.setRotate(-90);
		wallHealth1H.setTranslateX(-455);
		wallHealth1H.setStyle("-fx-accent: #4f7696; -fx-border-width:0.5px");
		
		wallHealth2H.setPrefWidth(50);
		wallHealth2H.setPrefHeight(15);
		wallHealth2H.setRotate(-90);
		wallHealth2H.setTranslateX(-455);
		wallHealth2H.setStyle("-fx-accent: #4f7696; -fx-border-width:0.5px");
		
		wallHealth3H.setPrefWidth(50);
		wallHealth3H.setPrefHeight(15);
		wallHealth3H.setRotate(-90);
		wallHealth3H.setTranslateX(-455);
		wallHealth3H.setStyle("-fx-accent: #4f7696; -fx-border-width:0.5px");
		
		wallHealth4H.setPrefWidth(50);
		wallHealth4H.setPrefHeight(15);
		wallHealth4H.setRotate(-90);
		wallHealth4H.setTranslateX(-455);
		wallHealth4H.setStyle("-fx-accent: #4f7696; -fx-border-width:0.5px");
		
		wallHealth5H.setPrefWidth(50);
		wallHealth5H.setPrefHeight(15);
		wallHealth5H.setRotate(-90);
		wallHealth5H.setTranslateX(-455);
		wallHealth5H.setStyle("-fx-accent: #4f7696; -fx-border-width:0.5px");
		
		HBox purchaseAndPassH = new HBox(20);
		Button purchaseH = new Button("Purchase");
		Button passH = new Button("Pass");
		purchaseH.setFont(font);
		purchaseH.setBackground(originalBackground);
		purchaseH.setPadding(new Insets(10));
		purchaseH.setOnMouseEntered(e -> purchaseH.setEffect(dropShadow));
		purchaseH.setOnMouseExited(e -> purchaseH.setEffect(null));
		passH.setFont(font);
		passH.setBackground(originalBackground);
		passH.setPadding(new Insets(10));
		passH.setOnMouseEntered(e -> passH.setEffect(dropShadow));
		passH.setOnMouseExited(e -> passH.setEffect(null));
		purchaseAndPassH.setAlignment(Pos.CENTER);
		Button hardSettingsButton = new Button();
		hardSettingsButton.setGraphic(settingsIcon);
		hardSettingsButton.setPrefHeight(40);
		hardSettingsButton.setPrefWidth(40);
		hardSettingsButton.setStyle("-fx-background-color: transparent");
		hardSettingsButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				mediaPlayer.seek(Duration.ZERO);
				mediaPlayer.play();
				settingsNum = 4;
				primaryStage.setScene(settings);
			}
		});
		purchaseAndPassH.getChildren().addAll(purchaseH,passH,hardSettingsButton);
		//add lanes and labels and dangerlevels to vbox hardlanes
		
		hardlanes.setAlignment(Pos.CENTER);
		hardlanes.getChildren().add(0,labelsH);
		hardlanes.getChildren().add(1,dangerlevel1H);
		hardlanes.getChildren().add(2,lane1weaponStack);
		hardlanes.getChildren().add(3,dangerlevel2H);
		hardlanes.getChildren().add(4,lane2weaponStack);
		hardlanes.getChildren().add(5,dangerlevel3H);
		hardlanes.getChildren().add(6,lane3weaponStack);
		hardlanes.getChildren().add(7,dangerlevel4H);
		hardlanes.getChildren().add(8,lane4weaponStack);
		hardlanes.getChildren().add(9,dangerlevel5H);
		hardlanes.getChildren().add(10,lane5weaponStack);
		hardlanes.getChildren().add(purchaseAndPassH);
		
		Button purchasePiercingH = new Button("Purchase");
		Button purchaseSniperH = new Button("Purchase");
		Button purchaseVolleyH = new Button("Purchase");
		Button purchaseWallTrapH = new Button("Purchase");
		
		StackPane weaponH = new StackPane();
		weaponH.setStyle("-fx-background-color: transparent");
		Scene weaponshopH = new Scene(weaponH,1920,1080);
		weaponshopH.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode() == KeyCode.ESCAPE) {
                primaryStage.close(); // Close the stage when 'Esc' is pressed
            }
        });
		Cursor = new ImageCursor(cursorImage, cursorImage.getWidth()/2, cursorImage.getHeight()/2);
	    weaponshopH.setCursor(Cursor);
	    ImageView weaponShopImageH = new ImageView(weaponshopimage);
		weaponH.getChildren().add(weaponShopImageH);
    
    	 weaponH.setStyle("-fx-background-color: #2d0c3b;");

        weaponShopImageH.setFitWidth(1365);
        weaponShopImageH.setFitHeight(768);
        weaponShopImageH.setTranslateY(-35);
		//first button
				purchasePiercingH.setTranslateX(-435);
				purchasePiercingH.setTranslateY(160);
				purchasePiercingH.setFont(font2);
				purchasePiercingH.setStyle("-fx-background-color: #dfbd69;");
				purchasePiercingH.setPrefHeight(50-20);
				purchasePiercingH.setPrefWidth(160-20-20);
				//second button
				purchaseSniperH.setTranslateX(-141);
				purchaseSniperH.setTranslateY(160);
				purchaseSniperH.setFont(font2);
				purchaseSniperH.setStyle("-fx-background-color: #dfbd69;");
				purchaseSniperH.setPrefHeight(30);
				purchaseSniperH.setPrefWidth(160-20-20);
				//third button
				purchaseVolleyH.setTranslateX(150);
				purchaseVolleyH.setTranslateY(160);
				purchaseVolleyH.setFont(font2);
				purchaseVolleyH.setStyle("-fx-background-color: #dfbd69;");
				purchaseVolleyH.setPrefHeight(30);
				purchaseVolleyH.setPrefWidth(160-20-20);
				//fourth button
				purchaseWallTrapH.setTranslateX(443);
				purchaseWallTrapH.setTranslateY(160);
				purchaseWallTrapH.setFont(font2);
				purchaseWallTrapH.setStyle("-fx-background-color: #dfbd69;");
				purchaseWallTrapH.setPrefHeight(30);
				purchaseWallTrapH.setPrefWidth(160-20-20);
		
		passH.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				mediaPlayer.play();
				battle.passTurn();
				spawnTitansH();
				updateallHard();
			    mediaPlayer.seek(Duration.ZERO); 
			    mediaPlayer.play();
				}
		});
		
		Label currentRescourcesInShoph = new Label();
		currentScoreH.setStyle("-fx-font-family: 'Space Games'; -fx-font-size: 16;");
		currentScoreH.setTextFill(javafx.scene.paint.Color.WHITE);
		currentRescourcesInShoph.setStyle("-fx-font-family: 'Space Games'; -fx-font-size: 16;");
		currentRescourcesInShoph.setTextFill(javafx.scene.paint.Color.WHITE);
		currentRescourcesInShoph.setTranslateX(-400);
		currentRescourcesInShoph.setTranslateY(-400);
		//CHOICE 
		ChoiceBox<String> selectLaneH = new ChoiceBox<>();
        selectLaneH.getItems().addAll("Lane 1", "Lane 2", "Lane 3","Lane 4","Lane 5");
	 selectLaneH.setTranslateY(240);
 	 selectLaneH.setPrefWidth(150);
	
		weaponH.getChildren().addAll(purchasePiercingH,purchaseSniperH,purchaseVolleyH,purchaseWallTrapH,currentRescourcesInShoph, selectLaneH);
		selectLaneH.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
		    mediaPlayer.seek(Duration.ZERO); 
		    mediaPlayer.play();
			// Switch to the corresponding scene based on the selected choice
            if ("Lane 1".equals(newValue)) {
                // Load and set the scene for Option 1
            	if(weaponCodeChosenH != 0)
            	{
                    try {
    					battle.purchaseWeapon(weaponCodeChosenH,battle.getOriginalLanes().get(0));
    				} catch (InsufficientResourcesException e) {
    					// TODO Auto-generated catch block
    					displayAlert("Insufficient Resources","Not enough resources, resources provided = " + battle.getResourcesGathered());
    				} catch (InvalidLaneException e) {
    					// TODO Auto-generated catch block
    					displayAlert("Invalid Lane","Choose Another Lane this lane is Lost");
    					weaponCodeChosenH = -1;
    				}
            	}
             updateallHard();
             if(weaponCodeChosenH == 1)
             {
            		ImageView piercing = new ImageView(piercingCannon);
             		 piercing.setFitHeight(50);
            		 piercing.setFitWidth(30);
            		 lane1weaponFlow.getChildren().add(piercing);
            	 //need to add animation even if added more than once
            	 primaryStage.setScene(s5);
            	 
             }
             else 
             {
                 if(weaponCodeChosenH == 2)
                 {
                		 ImageView sniper = new ImageView(sniperCannon);
                 		 sniper.setFitHeight(50);
                		 sniper.setFitWidth(30);
                		 lane1weaponFlow.getChildren().add(sniper);
                	 primaryStage.setScene(s5);
                	 
                 }
                 else 
                 {
                     if(weaponCodeChosenH == 3)
                     {
                    	 ImageView volleySpread = new ImageView(volleySpreadCannon);
                 		 volleySpread.setFitHeight(50);
                		 volleySpread.setFitWidth(30);
                		 lane1weaponFlow.getChildren().add(volleySpread);
                    	 primaryStage.setScene(s5);
                    	 
                     }
                     else 
                     {
                         if(weaponCodeChosenH == 4)
                         {
                        	  ImageView wallT = new ImageView(wallTrap);
                        	  wallT.setFitHeight(50);
                        	  wallT.setFitWidth(30);
                        	  lane1weaponFlow.getChildren().add(wallT);                       	  
                        	 primaryStage.setScene(s5);
                         }
                         else 
                         {	if(weaponCodeChosenH == 0)
						   {
                        	displayAlert("Error", "Please Choose a Weapon Before Purchasing");
							selectLaneH.setValue(null);
						   }
                         	
                         }
                     }
                     
				}
             }
                
            } else if ("Lane 2".equals(newValue)) {
                // Load and set the scene for Option 3
            	if(weaponCodeChosenH != 0)
            	{
                    try {
    					battle.purchaseWeapon(weaponCodeChosenH,battle.getOriginalLanes().get(1));
    				} catch (InsufficientResourcesException e) {
    					// TODO Auto-generated catch block
    					displayAlert("Insufficient Resources","Not enough resources, resources provided = " + battle.getResourcesGathered());
    				} catch (InvalidLaneException e) {
    					// TODO Auto-generated catch block
    					displayAlert("Invalid Lane","Choose Another Lane this lane is Lost");
    					weaponCodeChosenH = -1;
    				}
            	}
             updateallHard();
             if(weaponCodeChosenH == 1)
             {
            		ImageView piercing = new ImageView(piercingCannon);
             		 piercing.setFitHeight(50);
            		 piercing.setFitWidth(25);
            		 lane2weaponFlow.getChildren().add(piercing);
            		 //need to add animation even if added more than once
            		 primaryStage.setScene(s5);
            	 
             }
             else 
             {
                 if(weaponCodeChosenH == 2)
                 {
                		 ImageView sniper = new ImageView(sniperCannon);
                 		 sniper.setFitHeight(50);
                		 sniper.setFitWidth(25);
                		 lane2weaponFlow.getChildren().add(sniper);
                		 primaryStage.setScene(s5);
                	 
                 }
                 else 
                 {
                     if(weaponCodeChosenH == 3)
                     {   
                    	 ImageView volleySpread = new ImageView(volleySpreadCannon);
                 		 volleySpread.setFitHeight(50);
                		 volleySpread.setFitWidth(25);
                		 lane2weaponFlow.getChildren().add(volleySpread);
                    	 primaryStage.setScene(s5);
                    	 
                     }
                     else 
                     {
                         if(weaponCodeChosenH == 4)
                         {
                        	  ImageView wallT = new ImageView(wallTrap);
                        	  wallT.setFitHeight(50);
                        	  wallT.setFitWidth(25);
                        	  lane2weaponFlow.getChildren().add(wallT);                       	  
                        	  primaryStage.setScene(s5);
                         }
                         else 
                         {	if(weaponCodeChosenH == 0)
						   {
                        	displayAlert("Error", "Please Choose a Weapon Before Purchasing");
							selectLane.setValue(null);
						   }
                         	
                         }
                     }
                     
                 }}}
			 
			 else if ("Lane 3".equals(newValue)) {
                // Load and set the scene for Option 3
            	if(weaponCodeChosenH != 0)
            	{
                    try {
    					battle.purchaseWeapon(weaponCodeChosenH,battle.getOriginalLanes().get(2));
    				} catch (InsufficientResourcesException e) {
    					// TODO Auto-generated catch block
    					displayAlert("Insufficient Resources","Not enough resources, resources provided = " + battle.getResourcesGathered());
    				} catch (InvalidLaneException e) {
    					// TODO Auto-generated catch block
    					displayAlert("Invalid Lane","Choose Another Lane this lane is Lost");
    					weaponCodeChosenH = -1;
    				}
            	}
             updateallHard();
             if(weaponCodeChosenH == 1)
             {
            		ImageView piercing = new ImageView(piercingCannon);
             		 piercing.setFitHeight(50);
            		 piercing.setFitWidth(25);
            		 lane3weaponFlow.getChildren().add(piercing);
            		 //need to add animation even if added more than once
            		 primaryStage.setScene(s5);
            	 
             }
             else 
             {
                 if(weaponCodeChosenH == 2)
                 {
                		 ImageView sniper = new ImageView(sniperCannon);
                 		 sniper.setFitHeight(50);
                		 sniper.setFitWidth(25);
                		 lane3weaponFlow.getChildren().add(sniper);
                		 primaryStage.setScene(s5);
                	 
                 }
                 else 
                 {
                     if(weaponCodeChosenH == 3)
                     {   
                    	 ImageView volleySpread = new ImageView(volleySpreadCannon);
                 		 volleySpread.setFitHeight(50);
                		 volleySpread.setFitWidth(25);
                		 lane3weaponFlow.getChildren().add(volleySpread);
                    	 primaryStage.setScene(s5);
                    	 
                     }
                     else 
                     {
                         if(weaponCodeChosenH == 4)
                         {
                        	  ImageView wallT = new ImageView(wallTrap);
                        	  wallT.setFitHeight(50);
                        	  wallT.setFitWidth(25);
                        	  lane3weaponFlow.getChildren().add(wallT);                       	  
                        	  primaryStage.setScene(s5);
                         }
                         else 
                         {	if(weaponCodeChosenH == 0)
						   {
                        	displayAlert("Error", "Please Choose a Weapon Before Purchasing");
							selectLane.setValue(null);
						   }
                         	
                         }
                     }
                     
				}
             }}
              else if ("Lane 4".equals(newValue)) {
                // Load and set the scene for Option 3
            	if(weaponCodeChosenH != 0)
            	{
                    try {
    					battle.purchaseWeapon(weaponCodeChosenH,battle.getOriginalLanes().get(3));
    				} catch (InsufficientResourcesException e) {
    					// TODO Auto-generated catch block
    					displayAlert("Insufficient Resources","Not enough resources, resources provided = " + battle.getResourcesGathered());
    				} catch (InvalidLaneException e) {
    					// TODO Auto-generated catch block
    					displayAlert("Invalid Lane","Choose Another Lane this lane is Lost");
    					weaponCodeChosenH = -1;
    				}
            	}
             updateallHard();
             if(weaponCodeChosenH == 1)
             {
            		ImageView piercing = new ImageView(piercingCannon);
             		 piercing.setFitHeight(50);
            		 piercing.setFitWidth(25);
            		 lane4weaponFlow.getChildren().add(piercing);
            		 //need to add animation even if added more than once
            		 primaryStage.setScene(s5);
            	 
             }
             else 
             {
                 if(weaponCodeChosenH == 2)
                 {
                		 ImageView sniper = new ImageView(sniperCannon);
                 		 sniper.setFitHeight(50);
                		 sniper.setFitWidth(25);
                		 lane4weaponFlow.getChildren().add(sniper);
                		 primaryStage.setScene(s5);
                	 
                 }
                 else 
                 {
                     if(weaponCodeChosenH == 3)
                     {   
                    	 ImageView volleySpread = new ImageView(volleySpreadCannon);
                 		 volleySpread.setFitHeight(50);
                		 volleySpread.setFitWidth(25);
                		 lane4weaponFlow.getChildren().add(volleySpread);
                    	 primaryStage.setScene(s5);
                    	 
                     }
                     else 
                     {
                         if(weaponCodeChosenH == 4)
                         {
                        	  ImageView wallT = new ImageView(wallTrap);
                        	  wallT.setFitHeight(50);
                        	  wallT.setFitWidth(25);
                        	  lane4weaponFlow.getChildren().add(wallT);                       	  
                        	  primaryStage.setScene(s5);
                         }
                         else 
                         {	if(weaponCodeChosenH == 0)
						   {
                        	displayAlert("Error", "Please Choose a Weapon Before Purchasing");
							selectLane.setValue(null);
						   }
                         	
                         }
                     }
                     
				}
             }} 
			 else if ("Lane 5".equals(newValue)) {
                // Load and set the scene for Option 3
            	if(weaponCodeChosenH != 0)
            	{
                    try {
    					battle.purchaseWeapon(weaponCodeChosenH,battle.getOriginalLanes().get(4));
    				} catch (InsufficientResourcesException e) {
    					// TODO Auto-generated catch block
    					displayAlert("Insufficient Resources","Not enough resources, resources provided = " + battle.getResourcesGathered());
    				} catch (InvalidLaneException e) {
    					// TODO Auto-generated catch block
    					displayAlert("Invalid Lane","Choose Another Lane this lane is Lost");
    					weaponCodeChosenH = -1;
    				}
            	}
             updateallHard();
             if(weaponCodeChosenH == 1)
             {
            		ImageView piercing = new ImageView(piercingCannon);
             		 piercing.setFitHeight(50);
            		 piercing.setFitWidth(25);
            		 lane5weaponFlow.getChildren().add(piercing);
            		 //need to add animation even if added more than once
            		 primaryStage.setScene(s5);
            	 
             }
             else 
             {
                 if(weaponCodeChosenH == 2)
                 {
                		 ImageView sniper = new ImageView(sniperCannon);
                 		 sniper.setFitHeight(50);
                		 sniper.setFitWidth(25);
                		 lane5weaponFlow.getChildren().add(sniper);
                		 primaryStage.setScene(s5);
                	 
                 }
                 else 
                 {
                     if(weaponCodeChosenH == 3)
                     {   
                    	 ImageView volleySpread = new ImageView(volleySpreadCannon);
                 		 volleySpread.setFitHeight(50);
                		 volleySpread.setFitWidth(25);
                		 lane5weaponFlow.getChildren().add(volleySpread);
                    	 primaryStage.setScene(s5);
                    	 
                     }
                     else 
                     {
                         if(weaponCodeChosenH == 4)
                         {
                        	  ImageView wallT = new ImageView(wallTrap);
                        	  wallT.setFitHeight(50);
                        	  wallT.setFitWidth(25);
                        	  lane5weaponFlow.getChildren().add(wallT);                       	  
                        	  primaryStage.setScene(s5);
                         }
                         else 
                         {	if(weaponCodeChosenH == 0)
						   {
                        	displayAlert("Error", "Please Choose a Weapon Before Purchasing");
							selectLane.setValue(null);
						   }
                         	
                         }
                     }
                     
				}
             } 
            }
        });
//		purchase.setOnAction(new EventHandler<ActionEvent>() {
//			public void handle(ActionEvent event) {
//				selectLane.setValue(null);
//				weaponCodeChosen = 0;
//				currentRescourcesInShop.setText(currentResources.getText());
//				primaryStage.setScene(weaponshop);
//				spawnTitansi();
//			    mediaPlayer.seek(Duration.ZERO);
//			    mediaPlayer.play();
//				}
//		});
		purchaseH.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				selectLaneH.setValue(null);
				weaponCodeChosenH = 0;
				currentRescourcesInShoph.setText(currentResourcesH.getText());
				primaryStage.setScene(weaponshopH);
				spawnTitansH();
			    mediaPlayer.seek(Duration.ZERO); 
			    mediaPlayer.play();

				}
		});

		purchasePiercingH.setOnAction(new EventHandler<ActionEvent>() {			
			public void handle(ActionEvent event) {
				weaponCodeChosenH = 1;
			    mediaPlayer.seek(Duration.ZERO); 
			    mediaPlayer.play();
				}
		});
		purchaseSniperH.setOnAction(new EventHandler<ActionEvent>() {			
			public void handle(ActionEvent event) {
				weaponCodeChosenH = 2;
			    mediaPlayer.seek(Duration.ZERO); 
			    mediaPlayer.play();
				}
		});
		purchaseVolleyH.setOnAction(new EventHandler<ActionEvent>() {			
			public void handle(ActionEvent event) {
				weaponCodeChosenH = 3;
			    mediaPlayer.seek(Duration.ZERO); 
			    mediaPlayer.play();
				}
		});
		purchaseWallTrapH.setOnAction(new EventHandler<ActionEvent>() {			
			public void handle(ActionEvent event) {
				weaponCodeChosenH = 4;
			    mediaPlayer.seek(Duration.ZERO); 
			    mediaPlayer.play();
				}
		});

		primaryStage.setResizable(false);
		primaryStage.getIcons().add(icon);
		primaryStage.show();

	}

	public void spawnTitansi()
	{
		Image pureTitan = new Image("PureTitan.png");
		Image abnormalTitan = new Image("AbnormalTitan.png");
		Image armoredTitan = new Image("ArmoredTitan.png");
		Image colossalTitan = new Image("ColossalTitan.png");
		Iterator<Titan> lane1Titans =  battle.getOriginalLanes().get(0).getTitans().iterator();
		Iterator<Titan> lane2Titans =  battle.getOriginalLanes().get(1).getTitans().iterator();
		Iterator<Titan> lane3Titans =  battle.getOriginalLanes().get(2).getTitans().iterator();
		int random = 0;
		Random rand = new Random();
		random = rand.nextInt(-30,25);
		/*loops over the existing titans updates the health and moves and removes any dead titans
		also moves the titans according to their speed and adds new titan*/
		if(!battle.getOriginalLanes().get(0).isLaneLost()) {
			for (Map.Entry<Titan, ImageView> entry : titans1.entrySet()) {

				if (entry.getKey().isDefeated()) {
					lane1weapon.getChildren().removeAll(entry.getValue(), titans1ProgressBars.get(entry.getKey()));
					titans1.remove(entry.getKey());
					titans1ProgressBars.remove(entry.getKey());
				} else {
					if (!entry.getKey().hasReachedTarget()) {
						if(entry.getKey() instanceof ColossalTitan) {
							movei(entry.getValue(), titans1ProgressBars.get(entry.getKey()), entry.getKey().getSpeed() * 1.48);
						}
						else
						{
							movei(entry.getValue(), titans1ProgressBars.get(entry.getKey()), entry.getKey().getSpeed() * 1.6);
						}
					}
					titans1ProgressBars.get(entry.getKey()).setProgress((double) entry.getKey().getCurrentHealth() /entry.getKey().getBaseHealth());
				}
			}
			while (lane1Titans.hasNext()) {
				Titan titan = lane1Titans.next();
				int translate = 0;
				if (!titans1.containsKey(titan)) {
					ImageView addedTitan = null;
					if (titan instanceof PureTitan) {
						addedTitan = new ImageView(pureTitan);
						translate = 35;
					}
					if (titan instanceof AbnormalTitan){
						addedTitan = new ImageView(abnormalTitan);
						translate = 25;
					}
					if (titan instanceof ArmoredTitan) {
						addedTitan = new ImageView(armoredTitan);
						translate = 35;
					}
					if (titan instanceof ColossalTitan) {
						addedTitan = new ImageView(colossalTitan);
						translate = 100;
					}

					ProgressBar health1 = new ProgressBar();
					health1.setProgress((double) titan.getCurrentHealth()/titan.getBaseHealth());
					health1.setPrefWidth(40);
					health1.setPrefHeight(12);
					health1.setStyle("-fx-accent: #4f7696; -fx-border-width: 0.5px; ");
					health1.setTranslateY(random - translate);
					health1.setTranslateX(685);
					lane1weapon.getChildren().addAll(addedTitan, health1);
					addedTitan.setTranslateX(685);
					addedTitan.setTranslateY(random);
					if (titan instanceof ColossalTitan) {
						addedTitan.setFitHeight(titan.getHeightInMeters() * 2);
					} else {
						addedTitan.setFitHeight(titan.getHeightInMeters() * 4);
					}
					addedTitan.setPreserveRatio(true);
					titans1.put(titan, addedTitan);
					titans1ProgressBars.put(titan, health1);
				}

			}
		}
		if(!battle.getOriginalLanes().get(1).isLaneLost()) {
			for (Map.Entry<Titan, ImageView> entry : titans2.entrySet()) {

				if (entry.getKey().isDefeated()) {
					lane2weapon.getChildren().removeAll(entry.getValue(), titans2ProgressBars.get(entry.getKey()));
					titans2.remove(entry.getKey());
					titans2ProgressBars.remove(entry.getKey());
				} else {
					if (!entry.getKey().hasReachedTarget()) {
						if (entry.getKey() instanceof ColossalTitan) {
							movei(entry.getValue(), titans2ProgressBars.get(entry.getKey()), entry.getKey().getSpeed() * 1.48);
						}
						else
						{
							movei(entry.getValue(), titans2ProgressBars.get(entry.getKey()), entry.getKey().getSpeed() * 1.6);
						}
					}
					titans2ProgressBars.get(entry.getKey()).setProgress((double) entry.getKey().getCurrentHealth()/entry.getKey().getBaseHealth());
				}
			}
			while (lane2Titans.hasNext()) {

				Titan titan = lane2Titans.next();
				int translate = 0;
				if (!titans2.containsKey(titan)) {
					ImageView addedTitan = null;
					if (titan instanceof PureTitan) {
						addedTitan = new ImageView(pureTitan);
						translate = 35;
					}
					if (titan instanceof AbnormalTitan){
						addedTitan = new ImageView(abnormalTitan);
						translate = 25;
					}
					if (titan instanceof ArmoredTitan) {
						addedTitan = new ImageView(armoredTitan);
						translate = 35;
					}
					if (titan instanceof ColossalTitan) {
						addedTitan = new ImageView(colossalTitan);
						translate = 100;
					}
					ProgressBar health1 = new ProgressBar();
					health1.setProgress((double)titan.getCurrentHealth()/titan.getBaseHealth());
					health1.setPrefWidth(40);
					health1.setPrefHeight(12);
					health1.setStyle("-fx-accent: #4f7696; -fx-border-width:0.5px");
					health1.setTranslateY(random - translate);
					health1.setTranslateX(685);
					lane2weapon.getChildren().addAll(addedTitan, health1);
					addedTitan.setTranslateX(685);
					addedTitan.setTranslateY(random);
					if (titan instanceof ColossalTitan) {
						addedTitan.setFitHeight(titan.getHeightInMeters() * 2);
						health1.setTranslateY(random - 50);
					} else {
						addedTitan.setFitHeight(titan.getHeightInMeters() * 4);
					}
					addedTitan.setPreserveRatio(true);
					titans2.put(titan, addedTitan);
					titans2ProgressBars.put(titan, health1);
				}
			}
		}
		if(!battle.getOriginalLanes().get(2).isLaneLost()) {
			for (Map.Entry<Titan, ImageView> entry : titans3.entrySet()) {

				if (entry.getKey().isDefeated()) {
					lane3weapon.getChildren().removeAll(entry.getValue(), titans3ProgressBars.get(entry.getKey()));
					titans3.remove(entry.getKey());
					titans3labels.remove(entry.getKey());
				} else {
					if (!entry.getKey().hasReachedTarget()) {
						if(entry.getKey() instanceof ColossalTitan) {
							movei(entry.getValue(), titans3ProgressBars.get(entry.getKey()), entry.getKey().getSpeed()*1.48);
						}
						else {
							movei(entry.getValue(), titans3ProgressBars.get(entry.getKey()), entry.getKey().getSpeed() * 1.6);
						}
					}
					titans3ProgressBars.get(entry.getKey()).setProgress((double)entry.getKey().getCurrentHealth()/entry.getKey().getBaseHealth());
				}
			}
			while (lane3Titans.hasNext()) {
				Titan titan = lane3Titans.next();
				int translate = 0;
				if (!titans3.containsKey(titan)) {
					ImageView addedTitan = null;
					if (titan instanceof PureTitan) {
						addedTitan = new ImageView(pureTitan);
						translate = 35;
					}
					if (titan instanceof AbnormalTitan){
						addedTitan = new ImageView(abnormalTitan);
						translate = 25;
					}
					if (titan instanceof ArmoredTitan) {
						addedTitan = new ImageView(armoredTitan);
						translate = 35;
					}
					if (titan instanceof ColossalTitan) {
						addedTitan = new ImageView(colossalTitan);
						translate = 100;
					}

					ProgressBar health1 = new ProgressBar();
					health1.setProgress((double)titan.getCurrentHealth()/titan.getBaseHealth());
					health1.setPrefWidth(40);
					health1.setPrefHeight(12);
					health1.setStyle("-fx-accent: #4f7696; -fx-border-width:0.5px");
					health1.setTranslateY(random - translate);
					health1.setTranslateX(685);
					lane3weapon.getChildren().addAll(addedTitan, health1);
					addedTitan.setTranslateX(685);
					addedTitan.setTranslateY(random);
					if (titan instanceof ColossalTitan) {
						addedTitan.setFitHeight(titan.getHeightInMeters() * 2);
						health1.setTranslateY(random - 50);
					} else {
						addedTitan.setFitHeight(titan.getHeightInMeters() * 4);
					}
					addedTitan.setPreserveRatio(true);
					titans3.put(titan, addedTitan);
					titans3ProgressBars.put(titan, health1);
				}
			}
		}
	}
// width from above till first lane is 58 pixels, first lane height is 149, same for all lanes too so we need to spawn between 58 and 207
	public void spawnTitans()
	{
		Image pureTitan = new Image("PureTitan.png");
		Image abnormalTitan = new Image("AbnormalTitan.png");
		Image armoredTitan = new Image("ArmoredTitan.png");
		Image colossalTitan = new Image("ColossalTitan.png");

 
		Lane leastDangerousLane= battle.getLanes().peek();
		int index = battle.getOriginalLanes().indexOf(leastDangerousLane);
		Titan titan = null;
		if(index == 0)
		{
			for(int i = 0;i<battle.getNumberOfTitansPerTurn();i++)
			{	
				int random = 0; 
		        Random rand = new Random();
	            random = rand.nextInt(-30,25);
				titan = leastDangerousLane.getTitans().peek();
				if (titan == null) {
					break; // No more Titans in the lane to spawn
				}
	            if(titan instanceof PureTitan)
	            {	
	        		ImageView pure = new ImageView(pureTitan); 
	        		Label health1 = new Label();
	        		health1.setText("Health: " + titan.getCurrentHealth());
	        		health1.setTranslateY(random-25);
	        		health1.setTranslateX(730);
	            	lane1weapon.getChildren().addAll(pure,health1);
	            	pure.setTranslateX(700);
	            	pure.setTranslateY(random);
	        		pure.setFitHeight(15*4);
	        		pure.setFitWidth(10*4);
	        		titans1.put(titan,pure);
	        		titans1labels.put(titan,health1);
					move(pure,health1,500);
	            }
	            if(titan instanceof AbnormalTitan)
	            {	
	        		ImageView abnormal = new ImageView(abnormalTitan);
	        		Label health2 = new Label();
	        		health2.setText("Health: " + titan.getCurrentHealth());
	        		health2.setTranslateY(-20);
	        		health2.setTranslateX(730);
	        		lane1weapon.getChildren().addAll(abnormal,health2);
	            	abnormal.setTranslateX(730);
	            	abnormal.setTranslateY(random);
	        		abnormal.setFitHeight(10*4);
	        		abnormal.setFitWidth(10*4);
	        		titans1.put(titan,abnormal);
	        		titans1labels.put(titan,health2);
					move(abnormal,health2,500);
	            }
	            if(titan instanceof ArmoredTitan)
	            {	
	        		ImageView armored = new ImageView(armoredTitan); 
	        		Label health3 = new Label();
	        		health3.setText("Health: " + titan.getCurrentHealth());
	        		health3.setTranslateY(-25);
	        		health3.setTranslateX(730);
	            	lane1weapon.getChildren().addAll(armored,health3);
	            	armored.setTranslateX(730);
	            	armored.setTranslateY(random);
	        		armored.setFitHeight(15*4);
	        		armored.setFitWidth(10*4);
	        		titans1.put(titan,armored);
	        		titans1labels.put(titan,health3);
					move(armored,health3,500);
	            }
	            if(titan instanceof ColossalTitan)
	            {	
	        		ImageView colossal = new ImageView(colossalTitan); 
	        		Label health4 = new Label();
	        		health4.setText("Health: " + titan.getCurrentHealth());
	        		health4.setTranslateY(-30);
	        		health4.setTranslateX(725);
	            	lane1weapon.getChildren().addAll(colossal,health4);
	            	colossal.setTranslateX(725);
	            	colossal.setTranslateY(random);
	        		colossal.setFitHeight(60*2);
	        		colossal.setFitWidth(10*6);
	        		titans1.put(titan,colossal);
	        		titans1labels.put(titan,health4);
					move(colossal,health4,500);
	            }
			}
		}
	            
		if(index == 1)
		{
			for(int i = 0;i<battle.getNumberOfTitansPerTurn();i++)
			{	
				int random = 0; 
		        Random rand = new Random();
	            random = rand.nextInt(-30,25);
				titan = leastDangerousLane.getTitans().peek();
				if (titan == null) {
					break; // No more Titans in the lane to spawn
				}
	            if(titan instanceof PureTitan)
	            {	
	        		ImageView pure = new ImageView(pureTitan); 
	        		Label health1 = new Label();
	        		health1.setText("Health: " + titan.getCurrentHealth());
	        		health1.setTranslateY(random-25);
	        		health1.setTranslateX(730);
	            	lane2weapon.getChildren().addAll(pure,health1);
	            	pure.setTranslateX(730);
	            	pure.setTranslateY(random);
	        		pure.setFitHeight(15*4);
	        		pure.setFitWidth(10*4);
	        		titans2.put(titan,pure);
	        		titans2labels.put(titan,health1);
					move(pure,health1,500);
	            }
	            if(titan instanceof AbnormalTitan)
	            {	
	        		ImageView abnormal = new ImageView(abnormalTitan);
	        		Label health2 = new Label();
	        		health2.setText("Health: " + titan.getCurrentHealth());
	        		health2.setTranslateY(-20);
	        		health2.setTranslateX(730);
	            	lane2weapon.getChildren().addAll(abnormal,health2);
	            	abnormal.setTranslateX(730);
	            	abnormal.setTranslateY(random);
	        		abnormal.setFitHeight(10*4);
	        		abnormal.setFitWidth(10*4);
	        		titans2.put(titan,abnormal);
	        		titans2labels.put(titan,health2);
					move(abnormal,health2,500);
	            }
	            if(titan instanceof ArmoredTitan)
	            {	
	        		ImageView armored = new ImageView(armoredTitan);
	        		Label health3 = new Label();
	        		health3.setText("Health: " + titan.getCurrentHealth());
	        		health3.setTranslateY(-25);
	        		health3.setTranslateX(730);
	            	lane2weapon.getChildren().addAll(armored,health3);
	            	armored.setTranslateX(730);
	            	armored.setTranslateY(random);
	        		armored.setFitHeight(15*4);
	        		armored.setFitWidth(10*4);
	        		titans2.put(titan,armored);
	        		titans2labels.put(titan,health3);
					move(armored,health3,500);
	            }
	            if(titan instanceof ColossalTitan)
	            {	
	        		ImageView colossal = new ImageView(colossalTitan); 
	        		Label health4 = new Label();
	        		health4.setText("Health: " + titan.getCurrentHealth());
	        		health4.setTranslateY(-30);
	        		health4.setTranslateX(725);
	            	lane2weapon.getChildren().addAll(colossal,health4);
	            	colossal.setTranslateX(725);
	            	colossal.setTranslateY(random);
	        		colossal.setFitHeight(60*2);
	        		colossal.setFitWidth(10*6);
	        		titans2.put(titan,colossal);
	        		titans2labels.put(titan,health4);
					move(colossal,health4,500);
	            }
			}
		}
		if(index == 2)
		{
			for(int i = 0;i<battle.getNumberOfTitansPerTurn();i++)
			{	
				int random = 0; 
		        Random rand = new Random();
	            random = rand.nextInt(-30,25);
				titan = leastDangerousLane.getTitans().peek();
				if (titan == null) {
					break; // No more Titans in the lane to spawn
				}
	            if(titan instanceof PureTitan)
	            {	
	        		ImageView pure = new ImageView(pureTitan);
	        		Label health1 = new Label();
	        		health1.setText("Health: " + titan.getCurrentHealth());
	        		health1.setTranslateY(random-25);
	        		health1.setTranslateX(730);
	            	lane3weapon.getChildren().addAll(pure,health1);
	            	pure.setTranslateX(730);
	            	pure.setTranslateY(random);
	        		pure.setFitHeight(15*4);
	        		pure.setFitWidth(10*4);
	        		titans2.put(titan,pure);
	        		titans2labels.put(titan,health1);
					move(pure,health1,500);
	            }
	            if(titan instanceof AbnormalTitan)
	            {	
	        		ImageView abnormal = new ImageView(abnormalTitan);
	        		Label health2 = new Label();
	        		health2.setText("Health: " + titan.getCurrentHealth());
	        		health2.setTranslateY(random-20);
	        		health2.setTranslateX(730);
	            	lane3weapon.getChildren().addAll(abnormal,health2);
	            	abnormal.setTranslateX(730);
	            	abnormal.setTranslateY(random);
	        		abnormal.setFitHeight(10*4);
	        		abnormal.setFitWidth(10*4);
	        		titans2.put(titan,abnormal);
	        		titans2labels.put(titan,health2);
					move(abnormal,health2,500);
	            }
	            if(titan instanceof ArmoredTitan)
	            {	
	        		ImageView armored = new ImageView(armoredTitan);
	        		Label health3 = new Label();
	        		health3.setText("Health: " + titan.getCurrentHealth());
	        		health3.setTranslateY(random-25);
	        		health3.setTranslateX(730);
	            	lane3weapon.getChildren().addAll(armored,health3);
	            	armored.setTranslateX(730);
	            	armored.setTranslateY(random);
	        		armored.setFitHeight(15*4);
	        		armored.setFitWidth(10*4);
	        		titans2.put(titan,armored);
	        		titans2labels.put(titan,health3);
					move(armored,health3,500);
	            }
	            if(titan instanceof ColossalTitan)
	            {	
	        		ImageView colossal = new ImageView(colossalTitan); 
	        		Label health4 = new Label();
	        		health4.setText("Health: " + titan.getCurrentHealth());
	        		health4.setTranslateY(random-30);
	        		health4.setTranslateX(725);
	            	lane3weapon.getChildren().addAll(colossal,health4);
	            	colossal.setTranslateX(725);
	            	colossal.setTranslateY(random);
	        		colossal.setFitHeight(60*2);
	        		colossal.setFitWidth(10*6);
	        		titans2.put(titan,colossal);
	        		titans2labels.put(titan,health4);
					move(colossal,health4,500);
	            }
			}
		}
	}

	public void spawnTitansH()
	{
		Image pureTitan = new Image("PureTitan.png");
		Image abnormalTitan = new Image("AbnormalTitan.png");
		Image armoredTitan = new Image("ArmoredTitan.png");
		Image colossalTitan = new Image("ColossalTitan.png");

 
		Lane leastDangerousLane= battle.getLanes().peek();
		int index = battle.getOriginalLanes().indexOf(leastDangerousLane);
		Titan titan = null;
		if(index == 0)
		{
			for(int i = 0;i<battle.getNumberOfTitansPerTurn();i++)
			{	
				int random = 0; 
		        Random rand = new Random();
	            random = rand.nextInt(-30,25);
				titan = leastDangerousLane.getTitans().peek();
	            if(titan instanceof PureTitan)
	            {	
	        		ImageView pure = new ImageView(pureTitan); 
	        		Label health1 = new Label();
	        		health1.setText("Health: " + titan.getCurrentHealth());
	        		health1.setTranslateY(random-25);
	        		health1.setTranslateX(730);
	            	lane1weaponh.getChildren().addAll(pure,health1);
	            	pure.setTranslateX(730);
	            	pure.setTranslateY(random);
	        		pure.setFitHeight(15*4);
	        		pure.setFitWidth(10*4);
	        		titans1h.add(pure);
	        		titans1labelsh.add(health1);
					move(pure,health1,500);
	            }
	            if(titan instanceof AbnormalTitan)
	            {	
	        		ImageView abnormal = new ImageView(abnormalTitan);
	        		Label health2 = new Label();
	        		health2.setText("Health: " + titan.getCurrentHealth());
	        		health2.setTranslateY(-20);
	        		health2.setTranslateX(730);
	        		lane1weaponh.getChildren().addAll(abnormal,health2);
	            	abnormal.setTranslateX(730);
	            	abnormal.setTranslateY(random);
	        		abnormal.setFitHeight(10*4);
	        		abnormal.setFitWidth(10*4);
	        		titans1h.add(abnormal);
	        		titans1labelsh.add(health2);
					move(abnormal,health2,500);
	            }
	            if(titan instanceof ArmoredTitan)
	            {	
	        		ImageView armored = new ImageView(armoredTitan); 
	        		Label health3 = new Label();
	        		health3.setText("Health: " + titan.getCurrentHealth());
	        		health3.setTranslateY(-25);
	        		health3.setTranslateX(730);
	            	lane1weaponh.getChildren().addAll(armored,health3);
	            	armored.setTranslateX(730);
	            	armored.setTranslateY(random);
	        		armored.setFitHeight(15*4);
	        		armored.setFitWidth(10*4);
	        		titans1h.add(armored);
	        		titans1labelsh.add(health3);
					move(armored,health3,500);
	            }
	            if(titan instanceof ColossalTitan)
	            {	
	        		ImageView colossal = new ImageView(colossalTitan); 
	        		Label health4 = new Label();
	        		health4.setText("Health: " + titan.getCurrentHealth());
	        		health4.setTranslateY(-30);
	        		health4.setTranslateX(725);
	            	lane1weaponh.getChildren().addAll(colossal,health4);
	            	colossal.setTranslateX(725);
	            	colossal.setTranslateY(random);
	        		colossal.setFitHeight(60*2);
	        		colossal.setFitWidth(10*6);
	        		titans1h.add(colossal);
	        		titans1labelsh.add(health4);
					move(colossal,health4,500);
	            }
			}
		}
	            
		if(index == 1)
		{
			for(int i = 0;i<battle.getNumberOfTitansPerTurn();i++)
			{	
				int random = 0; 
		        Random rand = new Random();
	            random = rand.nextInt(-30,25);
				titan = leastDangerousLane.getTitans().peek();
	            if(titan instanceof PureTitan)
	            {	
	        		ImageView pure = new ImageView(pureTitan); 
	        		Label health1 = new Label();
	        		health1.setText("Health: " + titan.getCurrentHealth());
	        		health1.setTranslateY(random-25);
	        		health1.setTranslateX(730);
	            	lane2weaponh.getChildren().addAll(pure,health1);
	            	pure.setTranslateX(730);
	            	pure.setTranslateY(random);
	        		pure.setFitHeight(15*4);
	        		pure.setFitWidth(10*4);
	        		titans2h.add(pure);
	        		titans2labelsh.add(health1);
					move(pure,health1,500);
	            }
	            if(titan instanceof AbnormalTitan)
	            {	
	        		ImageView abnormal = new ImageView(abnormalTitan);
	        		Label health2 = new Label();
	        		health2.setText("Health: " + titan.getCurrentHealth());
	        		health2.setTranslateY(-20);
	        		health2.setTranslateX(730);
	            	lane2weaponh.getChildren().addAll(abnormal,health2);
	            	abnormal.setTranslateX(730);
	            	abnormal.setTranslateY(random);
	        		abnormal.setFitHeight(10*4);
	        		abnormal.setFitWidth(10*4);
	        		titans2h.add(abnormal);
	        		titans2labelsh.add(health2);
					move(abnormal,health2,500);
	            }
	            if(titan instanceof ArmoredTitan)
	            {	
	        		ImageView armored = new ImageView(armoredTitan);
	        		Label health3 = new Label();
	        		health3.setText("Health: " + titan.getCurrentHealth());
	        		health3.setTranslateY(-25);
	        		health3.setTranslateX(730);
	            	lane2weaponh.getChildren().addAll(armored,health3);
	            	armored.setTranslateX(730);
	            	armored.setTranslateY(random);
	        		armored.setFitHeight(15*4);
	        		armored.setFitWidth(10*4);
	        		titans2h.add(armored);
	        		titans2labelsh.add(health3);
					move(armored,health3,500);
	            }
	            if(titan instanceof ColossalTitan)
	            {	
	        		ImageView colossal = new ImageView(colossalTitan); 
	        		Label health4 = new Label();
	        		health4.setText("Health: " + titan.getCurrentHealth());
	        		health4.setTranslateY(-30);
	        		health4.setTranslateX(725);
	            	lane2weaponh.getChildren().addAll(colossal,health4);
	            	colossal.setTranslateX(725);
	            	colossal.setTranslateY(random);
	        		colossal.setFitHeight(60*2);
	        		colossal.setFitWidth(10*6);
	        		titans2h.add(colossal);
	        		titans2labelsh.add(health4);
					move(colossal,health4,500);
	            }
			}
		}
		if(index == 2)
		{
			for(int i = 0;i<battle.getNumberOfTitansPerTurn();i++)
			{	
				int random = 0; 
		        Random rand = new Random();
	            random = rand.nextInt(-30,25);
				titan = leastDangerousLane.getTitans().peek();
	            if(titan instanceof PureTitan)
	            {	
	        		ImageView pure = new ImageView(pureTitan);
	        		Label health1 = new Label();
	        		health1.setText("Health: " + titan.getCurrentHealth());
	        		health1.setTranslateY(random-25);
	        		health1.setTranslateX(730);
	            	lane3weaponh.getChildren().addAll(pure,health1);
	            	pure.setTranslateX(730);
	            	pure.setTranslateY(random);
	        		pure.setFitHeight(15*4);
	        		pure.setFitWidth(10*4);
	        		titans3h.add(pure);
	        		titans3labelsh.add(health1);
					move(pure,health1,500);
	            }
	            if(titan instanceof AbnormalTitan)
	            {	
	        		ImageView abnormal = new ImageView(abnormalTitan);
	        		Label health2 = new Label();
	        		health2.setText("Health: " + titan.getCurrentHealth());
	        		health2.setTranslateY(random-20);
	        		health2.setTranslateX(730);
	            	lane3weaponh.getChildren().addAll(abnormal,health2);
	            	abnormal.setTranslateX(730);
	            	abnormal.setTranslateY(random);
	        		abnormal.setFitHeight(10*4);
	        		abnormal.setFitWidth(10*4);
	        		titans3h.add(abnormal);
	        		titans3labelsh.add(health2);
					move(abnormal,health2,500);
	            }
	            if(titan instanceof ArmoredTitan)
	            {	
	        		ImageView armored = new ImageView(armoredTitan);
	        		Label health3 = new Label();
	        		health3.setText("Health: " + titan.getCurrentHealth());
	        		health3.setTranslateY(random-25);
	        		health3.setTranslateX(730);
	            	lane3weaponh.getChildren().addAll(armored,health3);
	            	armored.setTranslateX(730);
	            	armored.setTranslateY(random);
	        		armored.setFitHeight(15*4);
	        		armored.setFitWidth(10*4);
	        		titans3h.add(armored);
	        		titans3labelsh.add(health3);
					move(armored,health3,500);
	            }
	            if(titan instanceof ColossalTitan)
	            {	
	        		ImageView colossal = new ImageView(colossalTitan); 
	        		Label health4 = new Label();
	        		health4.setText("Health: " + titan.getCurrentHealth());
	        		health4.setTranslateY(random-30);
	        		health4.setTranslateX(725);
	            	lane3weaponh.getChildren().addAll(colossal,health4);
	            	colossal.setTranslateX(725);
	            	colossal.setTranslateY(random);
	        		colossal.setFitHeight(60*2);
	        		colossal.setFitWidth(10*6);
	        		titans3h.add(colossal);
	        		titans3labelsh.add(health4);
					move(colossal,health4,500);
	            }
			}
		}
		if(index == 3)
		{
			for(int i = 0;i<battle.getNumberOfTitansPerTurn();i++)
			{	
				int random = 0; 
		        Random rand = new Random();
	            random = rand.nextInt(-30,25);
				titan = leastDangerousLane.getTitans().peek();
	            if(titan instanceof PureTitan)
	            {	
	        		ImageView pure = new ImageView(pureTitan);
	        		Label health1 = new Label();
	        		health1.setText("Health: " + titan.getCurrentHealth());
	        		health1.setTranslateY(random-25);
	        		health1.setTranslateX(730);
	            	lane4weaponh.getChildren().addAll(pure,health1);
	            	pure.setTranslateX(730);
	            	pure.setTranslateY(random);
	        		pure.setFitHeight(15*4);
	        		pure.setFitWidth(10*4);
	        		titans4h.add(pure);
	        		titans4labelsh.add(health1);
					move(pure,health1,500);
	            }
	            if(titan instanceof AbnormalTitan)
	            {	
	        		ImageView abnormal = new ImageView(abnormalTitan);
	        		Label health2 = new Label();
	        		health2.setText("Health: " + titan.getCurrentHealth());
	        		health2.setTranslateY(random-20);
	        		health2.setTranslateX(730);
	            	lane4weaponh.getChildren().addAll(abnormal,health2);
	            	abnormal.setTranslateX(730);
	            	abnormal.setTranslateY(random);
	        		abnormal.setFitHeight(10*4);
	        		abnormal.setFitWidth(10*4);
	        		titans4h.add(abnormal);
	        		titans4labelsh.add(health2);
					move(abnormal,health2,500);
	            }
	            if(titan instanceof ArmoredTitan)
	            {	
	        		ImageView armored = new ImageView(armoredTitan);
	        		Label health3 = new Label();
	        		health3.setText("Health: " + titan.getCurrentHealth());
	        		health3.setTranslateY(random-25);
	        		health3.setTranslateX(730);
	            	lane4weaponh.getChildren().addAll(armored,health3);
	            	armored.setTranslateX(730);
	            	armored.setTranslateY(random);
	        		armored.setFitHeight(15*4);
	        		armored.setFitWidth(10*4);
	        		titans4h.add(armored);
	        		titans4labelsh.add(health3);
					move(armored,health3,500);
	            }
	            if(titan instanceof ColossalTitan)
	            {	
	        		ImageView colossal = new ImageView(colossalTitan); 
	        		Label health4 = new Label();
	        		health4.setText("Health: " + titan.getCurrentHealth());
	        		health4.setTranslateY(random-30);
	        		health4.setTranslateX(725);
	            	lane4weaponh.getChildren().addAll(colossal,health4);
	            	colossal.setTranslateX(725);
	            	colossal.setTranslateY(random);
	        		colossal.setFitHeight(60*2);
	        		colossal.setFitWidth(10*6);
	        		titans4h.add(colossal);
	        		titans4labelsh.add(health4);
					move(colossal,health4,500);
	            }
			}
		}
		if(index == 4)
		{
			for(int i = 0;i<battle.getNumberOfTitansPerTurn();i++)
			{	
				int random = 0; 
		        Random rand = new Random();
	            random = rand.nextInt(-30,25);
				titan = leastDangerousLane.getTitans().peek();
	            if(titan instanceof PureTitan)
	            {	
	        		ImageView pure = new ImageView(pureTitan);
	        		Label health1 = new Label();
	        		health1.setText("Health: " + titan.getCurrentHealth());
	        		health1.setTranslateY(random-25);
	        		health1.setTranslateX(730);
	            	lane5weaponh.getChildren().addAll(pure,health1);
	            	pure.setTranslateX(730);
	            	pure.setTranslateY(random);
	        		pure.setFitHeight(15*4);
	        		pure.setFitWidth(10*4);
	        		titans5h.add(pure);
	        		titans5labelsh.add(health1);
					move(pure,health1,500);
	            }
	            if(titan instanceof AbnormalTitan)
	            {	
	        		ImageView abnormal = new ImageView(abnormalTitan);
	        		Label health2 = new Label();
	        		health2.setText("Health: " + titan.getCurrentHealth());
	        		health2.setTranslateY(random-20);
	        		health2.setTranslateX(730);
	            	lane5weaponh.getChildren().addAll(abnormal,health2);
	            	abnormal.setTranslateX(730);
	            	abnormal.setTranslateY(random);
	        		abnormal.setFitHeight(10*4);
	        		abnormal.setFitWidth(10*4);
	        		titans5h.add(abnormal);
	        		titans5labelsh.add(health2);
					move(abnormal,health2,500);
	            }
	            if(titan instanceof ArmoredTitan)
	            {	
	        		ImageView armored = new ImageView(armoredTitan);
	        		Label health3 = new Label();
	        		health3.setText("Health: " + titan.getCurrentHealth());
	        		health3.setTranslateY(random-25);
	        		health3.setTranslateX(730);
	            	lane5weaponh.getChildren().addAll(armored,health3);
	            	armored.setTranslateX(730);
	            	armored.setTranslateY(random);
	        		armored.setFitHeight(15*4);
	        		armored.setFitWidth(10*4);
	        		titans5h.add(armored);
	        		titans5labelsh.add(health3);
					move(armored,health3,500);
	            }
	            if(titan instanceof ColossalTitan)
	            {	
	        		ImageView colossal = new ImageView(colossalTitan); 
	        		Label health4 = new Label();
	        		health4.setText("Health: " + titan.getCurrentHealth());
	        		health4.setTranslateY(random-30);
	        		health4.setTranslateX(725);
	            	lane5weaponh.getChildren().addAll(colossal,health4);
	            	colossal.setTranslateX(725);
	            	colossal.setTranslateY(random);
	        		colossal.setFitHeight(60*2);
	        		colossal.setFitWidth(10*6);
	        		titans5h.add(colossal);
	        		titans5labelsh.add(health4);
					move(colossal,health4,500);
	            }
			}
		}
	}

	public static void movei(ImageView Titan,ProgressBar Health,double Speed)
	{

		TranslateTransition translate1 = new TranslateTransition();
		translate1.setByX(-Speed);
		translate1.setDuration(Duration.millis(500));
		translate1.setCycleCount(1);
		translate1.setNode(Titan);
		translate1.play();
		TranslateTransition translate2 = new TranslateTransition();
		translate2.setByX(-Speed);
		translate2.setDuration(Duration.millis(500));
		translate2.setCycleCount(1);
		translate2.setNode(Health);
		translate2.play();

	}
	public static void move(ImageView Titan,Label Health,double Speed)
	{

			TranslateTransition translate1 = new TranslateTransition();
			translate1.setByX(-Speed);
			translate1.setDuration(Duration.millis(500));
			translate1.setCycleCount(1);
			translate1.setNode(Titan);
			translate1.play();
			TranslateTransition translate2 = new TranslateTransition();
			translate2.setByX(-Speed);
			translate2.setDuration(Duration.millis(500));
			translate2.setCycleCount(1);
			translate2.setNode(Health);
			translate2.play();

	}

	public void updateall()
	{
		//moveTitansEasy();
		
		currentScore.setText("Current score: " +battle.getScore());
		currentPhase.setText("Current Phase: " +battle.getBattlePhase());
		currentResources.setText("Current Resources: " +battle.getResourcesGathered());
		currentTurn.setText("Current Turn: " +battle.getNumberOfTurns());	  
		dangerlevel1.setText("Danger Level: " + battle.getOriginalLanes().get(0).getDangerLevel());
		dangerlevel2.setText("Danger Level: " + battle.getOriginalLanes().get(1).getDangerLevel());
		dangerlevel3.setText("Danger Level: " + battle.getOriginalLanes().get(2).getDangerLevel());
		
		double progress1 = (double) battle.getOriginalLanes().get(0).getLaneWall().getCurrentHealth() / battle.getOriginalLanes().get(0).getLaneWall().getBaseHealth();
		double progress2 = (double) battle.getOriginalLanes().get(1).getLaneWall().getCurrentHealth() / battle.getOriginalLanes().get(1).getLaneWall().getBaseHealth();
		double progress3 = (double) battle.getOriginalLanes().get(2).getLaneWall().getCurrentHealth() / battle.getOriginalLanes().get(2).getLaneWall().getBaseHealth();
		wallHealth1.setProgress(progress1);
		wallHealth2.setProgress(progress2);
		wallHealth3.setProgress(progress3);
		
		
		
		if(battle.getOriginalLanes().get(0).isLaneLost())
			lane1weapon.setEffect(colorAdjust);
		if(battle.getOriginalLanes().get(1).isLaneLost())
			lane2weapon.setEffect(colorAdjust);
		if(battle.getOriginalLanes().get(2).isLaneLost())
			lane3weapon.setEffect(colorAdjust);
		if(battle.getBattlePhase() == BattlePhase.GRUMBLING && !stop)
			{
				mediaPlayer2.stop();
			    mediaPlayer3.seek(Duration.ZERO); 
			    mediaPlayer3.play(); 
			    stop = true;
			}
		if(battle.isGameOver())
		{
			displayAlertGameOver("Game Over", "Your Score is: " + battle.getScore());
		}
	}
	
	public void updateallHard()
	{	
		moveTitansHard();
		currentScoreH.setText("Current score: " +battle.getScore());
		currentPhaseH.setText("Current Phase: " +battle.getBattlePhase());
		currentResourcesH.setText("Current Resources: " +battle.getResourcesGathered());
		currentTurnH.setText("Current Turn: " +battle.getNumberOfTurns());	  
		dangerlevel1H.setText("Danger Level: " + battle.getOriginalLanes().get(0).getDangerLevel());
		dangerlevel2H.setText("Danger Level: " + battle.getOriginalLanes().get(1).getDangerLevel());
		dangerlevel3H.setText("Danger Level: " + battle.getOriginalLanes().get(2).getDangerLevel());
		dangerlevel4H.setText("Danger Level: " + battle.getOriginalLanes().get(3).getDangerLevel());
		dangerlevel5H.setText("Danger Level: " + battle.getOriginalLanes().get(4).getDangerLevel());
		
		double progress1H = (double) battle.getOriginalLanes().get(0).getLaneWall().getCurrentHealth() / battle.getOriginalLanes().get(0).getLaneWall().getBaseHealth();
		double progress2H = (double) battle.getOriginalLanes().get(1).getLaneWall().getCurrentHealth() / battle.getOriginalLanes().get(1).getLaneWall().getBaseHealth();
		double progress3H = (double) battle.getOriginalLanes().get(2).getLaneWall().getCurrentHealth() / battle.getOriginalLanes().get(2).getLaneWall().getBaseHealth();
		double progress4H = (double) battle.getOriginalLanes().get(3).getLaneWall().getCurrentHealth() / battle.getOriginalLanes().get(3).getLaneWall().getBaseHealth();
		double progress5H = (double) battle.getOriginalLanes().get(4).getLaneWall().getCurrentHealth() / battle.getOriginalLanes().get(4).getLaneWall().getBaseHealth();
		wallHealth1H.setProgress(progress1H);
		wallHealth2H.setProgress(progress2H);
		wallHealth3H.setProgress(progress3H);
		wallHealth4H.setProgress(progress4H);
		wallHealth5H.setProgress(progress5H);
		
		if(battle.getOriginalLanes().get(0).isLaneLost())
			lane1weaponStack.setEffect(colorAdjust);
		if(battle.getOriginalLanes().get(1).isLaneLost())
			lane2weaponStack.setEffect(colorAdjust);
		if(battle.getOriginalLanes().get(2).isLaneLost())
			lane3weaponStack.setEffect(colorAdjust);
		if(battle.getOriginalLanes().get(3).isLaneLost())
			lane4weaponStack.setEffect(colorAdjust);
		if(battle.getOriginalLanes().get(4).isLaneLost())
			lane5weaponStack.setEffect(colorAdjust);
		if(battle.getBattlePhase() == BattlePhase.GRUMBLING && !stop)
		{
			mediaPlayer2.stop();
		    mediaPlayer3.seek(Duration.ZERO); 
		    mediaPlayer3.play(); 
		    stop = true;
		}
		if(battle.isGameOver())
		{
			displayAlertGameOver("Game Over", "Your Score is: " + battle.getScore());
		}	
	}

	public void moveTitansEasy() {
		// Process titans1
		List<Titan> defeatedTitans1 = new ArrayList<>();
		for (Map.Entry<Titan, ImageView> entry : titans1.entrySet()) {
			if (entry.getKey().isDefeated()) {
				lane1weapon.getChildren().removeAll(entry.getValue(), titans1labels.get(entry.getKey()));
				defeatedTitans1.add(entry.getKey());
			} else {
				move(entry.getValue(), titans1labels.get(entry.getKey()), 500);
				titans1labels.get(entry.getKey()).setText("Health=" + entry.getKey().getCurrentHealth());
			}
		}
		for (Titan titan : defeatedTitans1) {
			titans1.remove(titan);
			titans1labels.remove(titan);
		}

		// Process titans2
		List<Titan> defeatedTitans2 = new ArrayList<>();
		for (Map.Entry<Titan, ImageView> entry : titans2.entrySet()) {
			if (entry.getKey().isDefeated()) {
				lane2weapon.getChildren().removeAll(entry.getValue(), titans2labels.get(entry.getKey()));
				defeatedTitans2.add(entry.getKey());
			} else {
				move(entry.getValue(), titans2labels.get(entry.getKey()), 500);
				titans2labels.get(entry.getKey()).setText("Health=" + entry.getKey().getCurrentHealth());
			}
		}
		for (Titan titan : defeatedTitans2) {
			titans2.remove(titan);
			titans2labels.remove(titan);
		}

		// Process titans3
		List<Titan> defeatedTitans3 = new ArrayList<>();
		for (Map.Entry<Titan, ImageView> entry : titans3.entrySet()) {
			if (entry.getKey().isDefeated()) {
				lane3weapon.getChildren().removeAll(entry.getValue(), titans3labels.get(entry.getKey()));
				defeatedTitans3.add(entry.getKey());
			} else {
				move(entry.getValue(), titans3labels.get(entry.getKey()), 500);
				titans3labels.get(entry.getKey()).setText("Health=" + entry.getKey().getCurrentHealth());
			}
		}
		for (Titan titan : defeatedTitans3) {
			titans3.remove(titan);
			titans3labels.remove(titan);
		}
	}
	
	public void moveTitansHard()
	{
		for(int i = 0; i < titans1h.size();i++)
		{
			move(titans1h.get(i), titans1labelsh.get(i), 500);
			titans1labelsh.get(i).setText("Health="+battle.getOriginalLanes().get(0).getTitans().peek().getCurrentHealth());
		}
		for(int i = 0; i < titans2h.size();i++)
		{
			move(titans2h.get(i), titans2labelsh.get(i), 500);
			titans2labelsh.get(i).setText("Health="+battle.getOriginalLanes().get(1).getTitans().peek().getCurrentHealth());
		}
		for(int i = 0; i < titans3h.size();i++)
		{
			move(titans3h.get(i), titans3labelsh.get(i), 500);
			titans3labelsh.get(i).setText("Health="+battle.getOriginalLanes().get(2).getTitans().peek().getCurrentHealth());
		}
		for(int i = 0; i < titans4h.size();i++)
		{
			move(titans4h.get(i), titans4labelsh.get(i), 500);
			titans4labelsh.get(i).setText("Health="+battle.getOriginalLanes().get(3).getTitans().peek().getCurrentHealth());
		}
		for(int i = 0; i < titans5h.size();i++)
		{
			move(titans5h.get(i), titans5labelsh.get(i), 500);
			titans5labelsh.get(i).setText("Health="+battle.getOriginalLanes().get(4).getTitans().peek().getCurrentHealth());
		}
	}

    private void displayAlert(String title, String message) {
        Stage alertStage = new Stage();
        alertStage.setTitle(title);
        alertStage.getIcons().add(new Image("icon.jpeg"));   
        Label label = new Label(message);
        label.setStyle("-fx-font-family: 'Space Games'; -fx-font-size: 14; ");
        Button closeButton = new Button("Back");
        closeButton.setOnAction(event -> alertStage.close());

        VBox pane = new VBox(15);
        pane.setAlignment(Pos.CENTER);
        pane.getChildren().addAll(label,closeButton);
        label.setAlignment(Pos.CENTER);
        closeButton.setAlignment(Pos.CENTER);
        closeButton.setStyle("-fx-font-family: 'Space Games'; -fx-font-size: 14; ");

        Scene scene = new Scene(pane, 650, 100);
        alertStage.setScene(scene);
        alertStage.show();
    }
    
    private void displayAlertGameOver(String title, String message) {
        Stage alertStage = new Stage();
        alertStage.setTitle(title);
        alertStage.getIcons().add(new Image("icon.jpeg"));   
        Label label = new Label(message);
        label.setStyle("-fx-font-family: 'Space Games'; -fx-font-size: 14; ");
        Button closeButton = new Button("Play Again");
        closeButton.setOnAction(event -> {
            alertStage.close();
            primaryStage.close();
            primaryStage.setScene(s1);
            primaryStage.show();

        });
        
        VBox pane = new VBox(15);
        pane.setAlignment(Pos.CENTER);
        pane.getChildren().addAll(label,closeButton);
        label.setAlignment(Pos.CENTER);
        closeButton.setAlignment(Pos.CENTER);
        closeButton.setStyle("-fx-font-family: 'Space Games'; -fx-font-size: 14; ");

        Scene scene = new Scene(pane, 650, 100);
        alertStage.setScene(scene);
        alertStage.show();
    }

	public static void main(String[] args) {
		launch(args);
		
	}

}
 class KeyEventFilter implements javafx.event.EventHandler<KeyEvent> {
        private final Stage stage;

        public KeyEventFilter(Stage stage) {
            this.stage = stage;
        }

        @Override
        public void handle(KeyEvent event) {
            if (event.getCode() == KeyCode.ESCAPE) {
                stage.close(); // Close the stage when 'Esc' is pressed
            }
        }
    }