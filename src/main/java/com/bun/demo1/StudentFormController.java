package com.bun.demo1;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;


import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalTime;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;


public class StudentFormController implements Initializable {


    @FXML
    private Label ap_grade;

    @FXML
    private Label ap_subject;

    @FXML
    private Label birthDateLabel;

    @FXML
    private Label english_grade;

    @FXML
    private Label english_subject;

    @FXML
    private Label filipino_grade;

    @FXML
    private Label filipino_subject;

    @FXML
    private Label final_grade;

    @FXML
    private Label genderLabel;

    @FXML
    private Button home_btn;

    @FXML
    private AnchorPane home_displayClock;

    @FXML
    private AnchorPane home_form;

    @FXML
    private ImageView img0;

    @FXML
    private ImageView img0_2;

    @FXML
    private Label levelGrade;

    @FXML
    private Button logout;

    @FXML
    private Label mapeh_grade;

    @FXML
    private Label mapeh_subject;

    @FXML
    private Label math_grade;

    @FXML
    private Label math_subject;

    @FXML
    private Label nameGrade;

    @FXML
    private Label nameLabel;

    @FXML
    private Label science_grade;

    @FXML
    private Label science_subject;

    @FXML
    private Label sectionGrade;

    @FXML
    private Label sectionLabel;

    @FXML
    private Label statusLabel;

    @FXML
    private Label statusMessage;

    @FXML
    private Button studentGrade_btn;

    @FXML
    private Label studentIDLabel;

    @FXML
    private ImageView studentImageView;

    @FXML
    private Button studentProfile_btn;

    @FXML
    private AnchorPane studentProfile_form;

    @FXML
    private Button studentSubjects_btn;

    @FXML
    private Label student_username;

    @FXML
    private Label subjectTitle;

    @FXML
    private Label tle_grade;

    @FXML
    private Label tle_subject;

    @FXML
    private AnchorPane viewGrades_form;

    @FXML
    private AnchorPane viewSubjects_form;

    @FXML
    private Label yearLabel;

    private String studentID; // This will hold the studentID passed from login


    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;

    public void homeDisplayLiveClock() {
        home_displayClock.widthProperty().addListener((obs, oldWidth, newWidth) -> drawClock());
        home_displayClock.heightProperty().addListener((obs, oldHeight, newHeight) -> drawClock());


        if (home_displayClock.getWidth() > 0 && home_displayClock.getHeight() > 0) {
            drawClock();
        }
    }

    public void drawClock() {
        home_displayClock.getChildren().clear();
        double paneWidth = home_displayClock.getWidth();
        double paneHeight = home_displayClock.getHeight();
        double centerX = paneWidth / 2;
        double centerY = paneHeight / 2;
        double clockRadius = Math.min(paneWidth, paneHeight) / 10 - 150;


        Circle clockFace = new Circle(centerX, centerY, clockRadius);
        clockFace.setFill(Color.WHITE);
        clockFace.setStroke(Color.BLACK);
        home_displayClock.getChildren().add(clockFace);


        for (int i = 1; i <= 12; i++) {
            double angle = Math.toRadians(i * 30 + 90);
            double textX = centerX + (clockRadius - 40) * Math.cos(angle);
            double textY = centerY + (clockRadius - 40) * Math.sin(angle);
            Text hourNumber = new Text(textX - 12, textY + 12, String.valueOf(i));
            hourNumber.setFont(Font.font("Bookman Old Style", FontWeight.BOLD, 30)); // Set font size and weight
            hourNumber.setFill(Color.color(0.035,0.153,0.318));
            home_displayClock.getChildren().add(hourNumber);
        }


        Line hourHand = new Line(centerX, centerY, centerX, centerY - clockRadius / 0.80);
        hourHand.setStrokeWidth(6);
        hourHand.setStroke(Color.color(0.035,0.153,0.318));


        Line minuteHand = new Line(centerX, centerY, centerX, centerY - clockRadius * 0.30);
        minuteHand.setStrokeWidth(4);
        minuteHand.setStroke(Color.color(0.196, 0.294, 0.647));


        Line secondHand = new Line(centerX, centerY, centerX, centerY - clockRadius * 1);
        secondHand.setStrokeWidth(2);
        secondHand.setStroke(Color.color(0.776, 0.863, 0.961));


        Circle centerCircle = new Circle(centerX, centerY, 5, Color.BLACK);
        home_displayClock.getChildren().addAll(hourHand, minuteHand, secondHand, centerCircle);


        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            LocalTime now = LocalTime.now();


            double hourAngle = (now.getHour() % 12 + now.getMinute() / 60.0) * 30 + 90;
            double minuteAngle = (now.getMinute() + now.getSecond() / 60.0) * 6 + 90;
            double secondAngle = now.getSecond() * 6 + 90;


            hourHand.setEndX(centerX + (clockRadius / 2) * Math.cos(Math.toRadians(hourAngle)));
            hourHand.setEndY(centerY + (clockRadius / 2) * Math.sin(Math.toRadians(hourAngle)));


            minuteHand.setEndX(centerX + (clockRadius * 0.75) * Math.cos(Math.toRadians(minuteAngle)));
            minuteHand.setEndY(centerY + (clockRadius * 0.75) * Math.sin(Math.toRadians(minuteAngle)));


            secondHand.setEndX(centerX + (clockRadius * 0.9) * Math.cos(Math.toRadians(secondAngle)));
            secondHand.setEndY(centerY + (clockRadius * 0.9) * Math.sin(Math.toRadians(secondAngle)));
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        home_displayClock.setUserData(timeline);
    }

    // Method to set the studentID
    public void setStudentID(String studentID) {
        this.studentID = studentID;
        displayStudentInfo();
    }


    // Fetch and display student data based on studentID
    public void displayStudentInfo() {
        studentData student = getStudentData(studentID);


        if (student != null) {
            studentIDLabel.setText(String.valueOf(student.getStudentID()));
            yearLabel.setText(student.getYear());
            sectionLabel.setText(student.getSection());
            nameLabel.setText(student.getFirstName() + " " + student.getLastName());
            birthDateLabel.setText(student.getBirth().toString());
            genderLabel.setText(student.getGender());
            statusLabel.setText(student.getStatus());


            if (student.getImage() != null && !student.getImage().isEmpty()) {
                Image image = new Image(student.getImage()); // Load image from the URL/path
                studentImageView.setImage(image);
            } else {
                studentImageView.setImage(null); // Clear if no image
            }
        } else {
            studentIDLabel.setText("No data found");
        }
    }


    // Fetch student data from the database based on studentID
    private studentData getStudentData(String studentID) {
        studentData studentD = null;
        String sql = "SELECT * FROM student WHERE studentID = ?";


        try {
            connect = Database.connectDB();
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, studentID);
            result = prepare.executeQuery();


            if (result.next()) {
                studentD = new studentData(
                        result.getInt("studentID"),
                        result.getString("year"),
                        result.getString("section"),
                        result.getString("lastName"),
                        result.getString("firstName"),
                        result.getDate("birth"),
                        result.getString("gender"),
                        result.getString("status"),
                        result.getString("image")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (result != null) result.close();
                if (prepare != null) prepare.close();
                if (connect != null) connect.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return studentD;
    }


    public void displayStudentGrade() {
        studentData student = getStudentGrade(studentID);

        if (student != null) {
            nameGrade.setText(String.valueOf(student.getStudentID()));
            levelGrade.setText(String.valueOf(student.getYear()));
            sectionGrade.setText(String.valueOf(student.getSection()));
            math_grade.setText(String.valueOf(student.getMathematics()));
            english_grade.setText(String.valueOf(student.getBasicenglish()));
            filipino_grade.setText(String.valueOf(student.getFil()));
            science_grade.setText(String.valueOf(student.getSci()));
            tle_grade.setText(String.valueOf(student.getTech()));
            ap_grade.setText(String.valueOf(student.getAralinP()));
            mapeh_grade.setText(String.valueOf(student.getMapeh()));
            final_grade.setText(String.valueOf(student.getFinals()));
        } else {
            nameGrade.setText("No data found");
        }
    }


    // Fetch student data from the database based on studentID
    private studentData getStudentGrade(String studentID) {
        studentData studentG = null;
        String sql = "SELECT * FROM student_grade WHERE studentID = ?";


        try {
            connect = Database.connectDB();
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, studentID);
            result = prepare.executeQuery();


            if (result.next()) {
                studentG = new studentData(
                        result.getInt("studentID"),
                        result.getString("year"),
                        result.getString("section"),
                        result.getDouble("math"),
                        result.getDouble("english"),
                        result.getDouble("filipino"),
                        result.getDouble("science"),
                        result.getDouble("tle"),
                        result.getDouble("ap"),
                        result.getDouble("mapeh"),
                        result.getDouble("final")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (result != null) result.close();
                if (prepare != null) prepare.close();
                if (connect != null) connect.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return studentG;
    }

    public void displaySubjects() {
        String sql = "SELECT status FROM student WHERE studentID = ?";
        connect = Database.connectDB();

        try {
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, studentID); // Set the studentID parameter
            result = prepare.executeQuery();

            // Reset visibility of subjects and status messages
            resetSubjectVisibility();

            if (result.next() && "Enrolled".equalsIgnoreCase(result.getString("status"))) {
                // If the student is enrolled, display subjects
                subjectTitle.setText("Enrolled Subjects:");
                subjectTitle.setVisible(true);


                math_subject.setText("Mathematics");
                math_subject.setVisible(true);


                english_subject.setText("English");
                english_subject.setVisible(true);


                filipino_subject.setText("Filipino");
                filipino_subject.setVisible(true);


                science_subject.setText("Science");
                science_subject.setVisible(true);


                tle_subject.setText("Technology and Livelihood Education");
                tle_subject.setVisible(true);


                ap_subject.setText("Araling Panlipunan");
                ap_subject.setVisible(true);


                mapeh_subject.setText("MAPEH");
                mapeh_subject.setVisible(true);
            } else {
                // If the student is not enrolled, display a message
                subjectTitle.setText("Subjects:");
                statusMessage.setText("The student is not enrolled.");
                statusMessage.setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (result != null) result.close();
                if (prepare != null) prepare.close();
                if (connect != null) connect.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    // Reset visibility of subject labels and status messages
    private void resetSubjectVisibility() {
        subjectTitle.setVisible(false);
        math_subject.setVisible(false);
        english_subject.setVisible(false);
        filipino_subject.setVisible(false);
        science_subject.setVisible(false);
        tle_subject.setVisible(false);
        ap_subject.setVisible(false);
        mapeh_subject.setVisible(false);
        statusMessage.setVisible(false);
    }


    public void displayUsername() {
        student_username.setText(getData.login_username);
    }


    public void logout() {
        try{
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Logout");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to logout?");


            Optional<ButtonType> option = alert.showAndWait();
            if(option.get().equals(ButtonType.OK)) {
                logout.getScene().getWindow().hide();


                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("loginForm.fxml")));
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                stage.setTitle("LINCOLN NATIONAL HIGH SCHOOL");
                stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("logo_llu.png"))));
                stage.setScene(scene);
                stage.show();
            }else return;
        } catch (Exception e) {e.printStackTrace();}
    }


    public void switchForm(ActionEvent event) {
        if (event.getSource() == home_btn) {
            home_form.setVisible(true);
            studentProfile_form.setVisible(false);
            viewSubjects_form.setVisible(false);
            viewGrades_form.setVisible(false);

            homeDisplayLiveClock();


        } else if (event.getSource() == studentProfile_btn) {
            home_form.setVisible(false);
            studentProfile_form.setVisible(true);
            viewSubjects_form.setVisible(false);
            viewGrades_form.setVisible(false);

            displayStudentInfo();

        } else if (event.getSource() == studentSubjects_btn) {
            home_form.setVisible(false);
            studentProfile_form.setVisible(false);
            viewSubjects_form.setVisible(true);
            viewGrades_form.setVisible(false);

            displaySubjects();

        } else if (event.getSource() == studentGrade_btn) {
            home_form.setVisible(false);
            studentProfile_form.setVisible(false);
            viewSubjects_form.setVisible(false);
            viewGrades_form.setVisible(true);

            displayStudentGrade();
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/bun/demo1/LOGIN FORM.png")));
        Image image1 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/bun/demo1/logo_llu.png")));


        img0.setImage(image1);
        img0_2.setImage(image);


        displayUsername();
        homeDisplayLiveClock();

        displayStudentInfo();

        displaySubjects();

        displayStudentGrade();
    }
}