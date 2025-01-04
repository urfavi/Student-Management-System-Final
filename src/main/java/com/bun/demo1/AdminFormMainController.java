package com.bun.demo1;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.print.PageLayout;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.swing.*;
import javax.swing.plaf.nimbus.State;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.Date;

public class AdminFormMainController implements Initializable {

    @FXML
    private Button addStudents_addBtn;

    @FXML
    private DatePicker addStudents_birth;

    @FXML
    private Button addStudents_btn;

    @FXML
    private Button addStudents_clearBtn;

    @FXML
    private TableColumn<studentData, Date> addStudents_col_birth;

    @FXML
    private TableColumn<studentData, String> addStudents_col_section;

    @FXML
    private TableColumn<studentData, String> addStudents_col_firstName;

    @FXML
    private TableColumn<studentData, String> addStudents_col_gender;

    @FXML
    private TableColumn<studentData, String> addStudents_col_lastName;

    @FXML
    private TableColumn<studentData, String> addStudents_col_status;

    @FXML
    private TableColumn<studentData, Integer> addStudents_col_studentID;

    @FXML
    private TableColumn<studentData, String> addStudents_col_year;

    @FXML
    private ComboBox<?> addStudents_section;

    @FXML
    private Button addStudents_deleteBtn;

    @FXML
    private TextField addStudents_firstName;

    @FXML
    private AnchorPane addStudents_form;

    @FXML
    private ComboBox<?> addStudents_gender;

    @FXML
    private ImageView addStudents_imageView;

    @FXML
    private Button addStudents_insertBtn;

    @FXML
    private TextField addStudents_lastName;

    @FXML
    private TextField addStudents_search;

    @FXML
    private ComboBox<?> addStudents_status;

    @FXML
    private TextField addStudents_studentID;

    @FXML
    private TableView<studentData> addStudents_tableView;

    @FXML
    private Button addStudents_updateBtn;

    @FXML
    private ComboBox<?> addStudents_year;

    @FXML
    private Label admin_username;

    @FXML
    private Button availableSection_addBtn;

    @FXML
    private Button availableSection_btn;

    @FXML
    private Button availableSection_clearBtn;

    @FXML
    private TableColumn<sectionData, String> availableSection_col_section;

    @FXML
    private TableColumn<sectionData, String> availableSection_col_adviser;

    @FXML
    private TableColumn<sectionData, String> availableSection_col_description;

    @FXML
    private TextField availableSection_section;

    @FXML
    private TextField availableSection_adviser;

    @FXML
    private Button availableSection_deleteBtn;

    @FXML
    private TextField availableSection_description;

    @FXML
    private AnchorPane availableSection_form;

    @FXML
    private TableView<sectionData> availableSection_tableView;

    @FXML
    private Button availableSection_updateBtn;

    @FXML
    private Button home_btn;

    @FXML
    private AnchorPane home_displayClock;

    @FXML
    private Label home_displayDate;

    @FXML
    private Label home_displayDigital;

    @FXML
    private AnchorPane home_form;

    @FXML
    private Label home_totalDropped;

    @FXML
    private Label home_totalEnrolled;

    @FXML
    private Label home_totalFemale;

    @FXML
    private Label home_totalMale;

    @FXML
    private Label home_totalPending;

    @FXML
    private ImageView img0;

    @FXML
    private ImageView img0_1;

    @FXML
    private ImageView img0_2;

    @FXML
    private ImageView img1_1;

    @FXML
    private ImageView img1_2;

    @FXML
    private ImageView img1_3;

    @FXML
    private ImageView img1_31;

    @FXML
    private ImageView img1_32;

    @FXML
    private ImageView img2_1;

    @FXML
    private ImageView img2_2;

    @FXML
    private ImageView img3_1;

    @FXML
    private ImageView img3_2;

    @FXML
    private ImageView img4_1;

    @FXML
    private ImageView img4_2;

    @FXML
    private ImageView img_date;

    @FXML
    private Button logout;

    @FXML
    private AnchorPane main_form;

    @FXML
    private TextField studentGrade_aralinP;

    @FXML
    private TextField studentGrade_basicenglish;

    @FXML
    private Button studentGrade_btn;

    @FXML
    private Button studentGrade_clearBtn;

    @FXML
    private TableColumn<studentData, String> studentGrade_col_aralinP;

    @FXML
    private TableColumn<studentData, String> studentGrade_col_basicenglish;

    @FXML
    private TableColumn<studentData, String> studentGrade_col_fil;

    @FXML
    private TableColumn<studentData, String> studentGrade_col_final;

    @FXML
    private TableColumn<studentData, String> studentGrade_col_mapeh;

    @FXML
    private TableColumn<studentData, String> studentGrade_col_mathematics;

    @FXML
    private TableColumn<studentData, String> studentGrade_col_sci;

    @FXML
    private TableColumn<studentData, String> studentGrade_col_section;

    @FXML
    private TableColumn<studentData, String> studentGrade_col_studentID;

    @FXML
    private TableColumn<studentData, String> studentGrade_col_tech;

    @FXML
    private TableColumn<studentData, String> studentGrade_col_year;

    @FXML
    private TextField studentGrade_fil;

    @FXML
    private AnchorPane studentGrade_form;

    @FXML
    private TextField studentGrade_mapeh;

    @FXML
    private TextField studentGrade_mathematics;

    @FXML
    private Button studentGrade_printBtn;

    @FXML
    private TextField studentGrade_sci;

    @FXML
    private TextField studentGrade_search;

    @FXML
    private Label studentGrade_section;

    @FXML
    private TextField studentGrade_studentID;

    @FXML
    private TextField studentGrade_tech;

    @FXML
    private TableView<studentData> studentGrade_tableView;

    @FXML
    private Button studentGrade_updateBtn;

    @FXML
    private Label studentGrade_year;

    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;

    private Image image;
    private PageLayout printContent;

    public void homeDisplayLiveDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            LocalDate today = LocalDate.now();
            String formattedDate = today.format(formatter);

            home_displayDate.setText(formattedDate);
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

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
        double clockRadius = Math.min(paneWidth, paneHeight) / 15 - 150;

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

    public void homeDisplayDigitalClock() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            LocalTime now = LocalTime.now();
            String currentTime = now.format(java.time.format.DateTimeFormatter.ofPattern("hh:mm:ss a"));
            home_displayDigital.setText(currentTime);
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public void homeDisplayTotalEnrolledStudents() {
        String sql = "SELECT COUNT(id) from student WHERE status = 'Enrolled'";
        connect = Database.connectDB();

        int countEnrolled = 0;
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if(result.next()) {
                countEnrolled = result.getInt("COUNT(id)");
            }

            home_totalEnrolled.setText(String.valueOf(countEnrolled));
        } catch (Exception e) {e.printStackTrace();}
    }

    public void homeDisplayTotalPendingStudents() {
        String sql = "SELECT COUNT(id) from student WHERE status = 'Pending'";
        connect = Database.connectDB();

        int countPending = 0;
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if(result.next()) {
                countPending = result.getInt("COUNT(id)");
            }

            home_totalPending.setText(String.valueOf(countPending));
        } catch (Exception e) {e.printStackTrace();}
    }

    public void homeDisplayTotalDroppedStudents() {
        String sql = "SELECT COUNT(id) from student WHERE status = 'Dropped'";
        connect = Database.connectDB();

        int countDropped = 0;
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if(result.next()) {
                countDropped = result.getInt("COUNT(id)");
            }

            home_totalDropped.setText(String.valueOf(countDropped));
        } catch (Exception e) {e.printStackTrace();}
    }

    public void homeDisplayFemaleEnrolled() {
        String sql = "SELECT COUNT(id) FROM student WHERE gender = 'Female' and status = 'Enrolled'";
        connect = Database.connectDB();

        try {
            int countFemale = 0;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if(result.next()) {
                countFemale = result.getInt("COUNT(id)");
            }

            home_totalFemale.setText(String.valueOf(countFemale));

        } catch (Exception e) {e.printStackTrace();}
    }

    public void homeDisplayMaleEnrolled() {
        String sql = "SELECT COUNT(id) FROM student WHERE gender = 'Male' and status = 'Enrolled'";
        connect = Database.connectDB();

        try {
            int countMale = 0;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if(result.next()) {
                countMale = result.getInt("COUNT(id)");
            }

            home_totalMale.setText(String.valueOf(countMale));

        } catch (Exception e) {e.printStackTrace();}
    }

    public void addStudentsAdd() {
        String insertData = "INSERT INTO student" + "(studentID, year, section, lastName, firstName, birth, gender, status, image, date)" + "VALUES(?,?,?,?,?,?,?,?,?,?)";
        connect = Database.connectDB();

        try {
            Alert alert;
            if(addStudents_studentID.getText().isEmpty() || addStudents_year.getSelectionModel().getSelectedItem() == null || addStudents_section.getSelectionModel().getSelectedItem() == null
                    || addStudents_lastName.getText().isEmpty() || addStudents_firstName.getText().isEmpty()
                    || addStudents_birth.getValue() == null || addStudents_gender.getSelectionModel().getSelectedItem() == null
                    || addStudents_status.getSelectionModel().getSelectedItem() == null || getData.path == null || getData.path == ""){
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            }else {
                String checkData = "SELECT studentID FROM student WHERE studentID = '" + addStudents_studentID.getText() + "'"; //CHECKS IF STUDENTID EXISTED
                statement = connect.createStatement();
                result = statement.executeQuery(checkData);

                if(result.next()){
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Student ID" + addStudents_studentID.getText() + "already exists. Duplication is not allowed.");
                    alert.showAndWait();
                }else {
                    prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, addStudents_studentID.getText());
                    prepare.setString(2, (String) addStudents_year.getSelectionModel().getSelectedItem());
                    prepare.setString(3, (String) addStudents_section.getSelectionModel().getSelectedItem());
                    prepare.setString(4, addStudents_lastName.getText());
                    prepare.setString(5, addStudents_firstName.getText());
                    prepare.setString(6, String.valueOf(addStudents_birth.getValue()));
                    prepare.setString(7, (String) addStudents_gender.getSelectionModel().getSelectedItem());
                    prepare.setString(8, (String) addStudents_status.getSelectionModel().getSelectedItem());

                    String uri = getData.path;
                    uri = uri.replace("\\", "\\\\");
                    prepare.setString(9, uri);

                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                    prepare.setString(10, String.valueOf(sqlDate));

                    prepare.executeUpdate();

                    String insertStudentGrade = "INSERT INTO student_grade" + "(studentID, year, section, math, english, filipino, science, tle, ap, mapeh, final)" + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
                    prepare = connect.prepareStatement(insertStudentGrade);
                    prepare.setString(1, addStudents_studentID.getText());
                    prepare.setString(2, (String)addStudents_year.getSelectionModel().getSelectedItem());
                    prepare.setString(3, (String)addStudents_section.getSelectionModel().getSelectedItem());
                    prepare.setString(4, "0.0"); //Math
                    prepare.setString(5, "0.0"); //English
                    prepare.setString(6, "0.0"); //Filipino
                    prepare.setString(7, "0.0"); //Science
                    prepare.setString(8, "0.0"); //TLE
                    prepare.setString(9, "0.0"); //AP
                    prepare.setString(10, "0.0"); //MAPEH
                    prepare.setString(11, "0.0"); //Final

                    prepare.executeUpdate();

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Student Successfully Added!");
                    alert.showAndWait();

                    addStudentsShowListData();
                    addStudentsClear();
                }
            }
        } catch (Exception e) {e.printStackTrace();}
    }

    public void addStudentsUpdate() {
        String uri = getData.path;
        uri = uri.replace("\\", "\\\\");

        String updateData = "UPDATE student SET "
                + "year = '" + addStudents_year.getSelectionModel().getSelectedItem()
                + "', section = '" + addStudents_section.getSelectionModel().getSelectedItem()
                + "', lastName = '" + addStudents_lastName.getText()
                + "', firstName = '" + addStudents_firstName.getText()
                + "', birth = '" + addStudents_birth.getValue()
                + "', gender = '" + addStudents_gender.getSelectionModel().getSelectedItem()
                + "', status = '" + addStudents_status.getSelectionModel().getSelectedItem()
                + "', image = '" + uri + "' WHERE studentID = '"
                + addStudents_studentID.getText() + "'";

        connect = Database.connectDB();

        try {
            Alert alert;
            if (addStudents_studentID.getText().isEmpty() || addStudents_year.getSelectionModel().getSelectedItem() == null || addStudents_section.getSelectionModel().getSelectedItem() == null
                    || addStudents_lastName.getText().isEmpty() || addStudents_firstName.getText().isEmpty()
                    || addStudents_birth.getValue() == null || addStudents_gender.getSelectionModel().getSelectedItem() == null
                    || addStudents_status.getSelectionModel().getSelectedItem() == null || getData.path == null || getData.path == "") {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to UPDATE Student ID:" + addStudents_studentID.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if(option.get().equals(ButtonType.OK)) {
                    statement = connect.createStatement();
                    statement.executeUpdate(updateData);

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Student Successfully Updated!");
                    alert.showAndWait();

                    addStudentsShowListData();
                    addStudentsClear();
                }else return;
            }
        } catch (Exception e) {e.printStackTrace();}
    }

    public void addStudentsDelete() {
        String deleteData = "DELETE FROM student WHERE studentID = '" + addStudents_studentID.getText() + "'";
        connect = Database.connectDB();

        try {
            Alert alert;
            if (addStudents_studentID.getText().isEmpty() || addStudents_year.getSelectionModel().getSelectedItem() == null || addStudents_section.getSelectionModel().getSelectedItem() == null
                    || addStudents_lastName.getText().isEmpty() || addStudents_firstName.getText().isEmpty()
                    || addStudents_birth.getValue() == null || addStudents_gender.getSelectionModel().getSelectedItem() == null
                    || addStudents_status.getSelectionModel().getSelectedItem() == null || getData.path == null || getData.path == "") {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to DELETE Student ID:" + addStudents_studentID.getText() + "?");

                Optional<ButtonType> option = alert.showAndWait();

                if(option.get().equals(ButtonType.OK)) {
                    statement = connect.createStatement();
                    statement.executeUpdate(deleteData);

                    String checkData = "SELECT studentID FROM student_grade " + "WHERE studentID = '" + addStudents_studentID.getText() + "'";
                    prepare = connect.prepareStatement(checkData);
                    result = prepare.executeQuery();

                    if(result.next()) {
                        String deleteGrade = "DELETE FROM student_grade WHERE " + "studentID = '" + addStudents_studentID.getText()+"'";
                        statement = connect.createStatement();
                        statement.executeUpdate(deleteGrade);
                    }

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Student Successfully Deleted!");
                    alert.showAndWait();

                    addStudentsShowListData();
                    addStudentsClear();
                }else return;
            }
        } catch (Exception e) {e.printStackTrace();}
    }

    public void addStudentsClear() {
        addStudents_studentID.setText("");
        addStudents_year.getSelectionModel().clearSelection();
        addStudents_section.getSelectionModel().clearSelection();
        addStudents_lastName.setText("");
        addStudents_firstName.setText("");
        addStudents_birth.setValue(null);
        addStudents_gender.getSelectionModel().clearSelection();
        addStudents_status.getSelectionModel().clearSelection();
        addStudents_imageView.setImage(null);

        getData.path = "";
    }

    public void addStudentsInsertImage() {
        FileChooser open = new FileChooser();
        open.setTitle("Open Image File");
        open.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image File", "*jpg", "*png"));

        File file = open.showOpenDialog(main_form.getScene().getWindow());
        if (file != null) {
            image = new Image(file.toURI().toString(), 124, 115, false, true);
            addStudents_imageView.setImage(image);

            getData.path = file.getAbsolutePath();
        }
    }

    public void addStudentsSearch() {
        String searchKey = addStudents_search.getText().toLowerCase();

        FilteredList<studentData> filter = new FilteredList<>(addStudentsListD, e -> true);
        filter.setPredicate(predicateStudentData -> {
            if (searchKey == null || searchKey.isEmpty()) {
                return true; // Show all items if search key is empty
            }

            return predicateStudentData.getStudentID().toString().contains(searchKey)
                    || predicateStudentData.getYear().toLowerCase().contains(searchKey)
                    || predicateStudentData.getSection().toLowerCase().contains(searchKey)
                    || predicateStudentData.getLastName().toLowerCase().contains(searchKey)
                    || predicateStudentData.getFirstName().toLowerCase().contains(searchKey)
                    || predicateStudentData.getBirth().toString().contains(searchKey)
                    || predicateStudentData.getGender().toLowerCase().contains(searchKey)
                    || predicateStudentData.getStatus().toLowerCase().contains(searchKey);
        });
        SortedList<studentData> sortList = new SortedList<>(filter);
        sortList.comparatorProperty().bind(addStudents_tableView.comparatorProperty());
        addStudents_tableView.setItems(sortList);
    }

    private String[] yearList = {"First Year", "Second Year", "Third Year", "Fourth Year"};
    public void addStudentsYearList() {
        List<String> yearL = new ArrayList<>();

        for(String data: yearList) {
            yearL.add(data);
        }

        ObservableList ObList = FXCollections.observableArrayList(yearL);
        addStudents_year.setItems(ObList);
    }

    public void addStudentsSectionList() {
        String listSection = "SELECT * FROM section";
        connect = Database.connectDB();

        try {
            ObservableList listS = FXCollections.observableArrayList();
            prepare = connect.prepareStatement(listSection);
            result = prepare.executeQuery();

            while (result.next()) {
                listS.add(result.getString("section"));
            }
            addStudents_section.setItems(listS);
        } catch (Exception e) {e.printStackTrace();}
    }

    private String[] genderList = {"Male", "Female", "Others"};
    public void addStudentsGenderList() {
        List<String> genderL = new ArrayList<>();

        for(String data: genderList) {
            genderL.add(data);
        }

        ObservableList ObList = FXCollections.observableArrayList(genderL);
        addStudents_gender.setItems(ObList);
    }

    private String[] statusList = {"Enrolled", "Pending", "Dropped"};
    public void addStudentsStatusList() {
        List<String> statusL = new ArrayList<>();

        for(String data: statusList) {
            statusL.add(data);
        }

        ObservableList ObList = FXCollections.observableArrayList(statusL);
        addStudents_status.setItems(ObList);
    }

    public ObservableList<studentData> addStudentsListData() {
        ObservableList<studentData> listStudents = FXCollections.observableArrayList();

        String sql = "SELECT * FROM student";
        connect = Database.connectDB();

        try{
            studentData studentD;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while(result.next()) {
                studentD = new studentData(result.getInt("studentID"), result.getString("year"), result.getString("section"),
                        result.getString("lastName"), result.getString("firstName"), result.getDate("birth"),
                        result.getString("gender"), result.getString("status"), result.getString("image"));

                listStudents.add(studentD);
            }
        } catch (Exception e) {e.printStackTrace();}
        return listStudents;
    }

    private ObservableList<studentData> addStudentsListD;
    public void addStudentsShowListData() {
        addStudentsListD = addStudentsListData();

        addStudents_col_studentID.setCellValueFactory(new PropertyValueFactory<>("studentID"));
        addStudents_col_year.setCellValueFactory(new PropertyValueFactory<>("year"));
        addStudents_col_section.setCellValueFactory(new PropertyValueFactory<>("section"));
        addStudents_col_lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        addStudents_col_firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        addStudents_col_birth.setCellValueFactory(new PropertyValueFactory<>("birth"));
        addStudents_col_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        addStudents_col_status.setCellValueFactory(new PropertyValueFactory<>("status"));

        addStudents_tableView.setItems(addStudentsListD);
    }

    public void addStudentsSelect() {
        studentData studentD = addStudents_tableView.getSelectionModel().getSelectedItem();
        int num = addStudents_tableView.getSelectionModel().getSelectedIndex();

        if((num -1) < -1) {return;}

        addStudents_studentID.setText(String.valueOf(studentD.getStudentID()));
        addStudents_lastName.setText(studentD.getLastName());
        addStudents_firstName.setText(studentD.getFirstName());
        addStudents_birth.setValue(LocalDate.parse(String.valueOf(studentD.getBirth())));

        String uri = "file:" + studentD.getImage();
        image = new Image(uri, 124, 115, false, true);
        addStudents_imageView.setImage(image);

        getData.path = studentD.getImage();
    }

    public ObservableList<sectionData> availableSectionListData() {
        ObservableList<sectionData> listData = FXCollections.observableArrayList();


        String sql = "SELECT * FROM section";
        connect = Database.connectDB();

        try{
            sectionData sectionD;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while(result.next()) {
                sectionD = new sectionData(result.getString("section"), result.getString("description"), result.getString("adviser"));
                listData.add(sectionD);
            }
        } catch (Exception e) {e.printStackTrace();}
        return listData;
    }

    public void availableSectionAdd() {
        String insertData = "INSERT INTO section (section,description,adviser) VALUES (?,?,?)";
        connect = Database.connectDB();

        try {
            Alert alert;

            if(availableSection_section.getText().isEmpty() || availableSection_description.getText().isEmpty()
                    || availableSection_adviser.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all the blank fields");
                alert.showAndWait();
            }else {
                String checkData = "SELECT section FROM section WHERE section = '" + availableSection_section.getText()+"'";
                statement = connect.createStatement();
                result = statement.executeQuery(checkData);

                if(result.next()) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Section: " + availableSection_section.getText() + " has already added.");
                    alert.showAndWait();
                }else {
                    prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, availableSection_section.getText());
                    prepare.setString(2, availableSection_description.getText());
                    prepare.setString(3, availableSection_adviser.getText());

                    prepare.executeUpdate();

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Section Successfully Added!");
                    alert.showAndWait();

                    availableSectionShowListData();
                    availableSectionClear();
                }
            }
        } catch (Exception e) {e.printStackTrace();}
    }

    public void availableSectionUpdate() {
        String updateData = "UPDATE section SET description = '" + availableSection_description.getText() + "', adviser = '"
                + availableSection_adviser.getText() + "' WHERE section = '"
                + availableSection_section.getText() + "'";
        connect = Database.connectDB();

        try {
            Alert alert;

            if(availableSection_section.getText().isEmpty() || availableSection_description.getText().isEmpty() || availableSection_adviser.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            }else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to UPDATE Section: " + availableSection_section.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    statement = connect.createStatement();
                    statement.executeUpdate(updateData);

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Section Successfully Updated!");
                    alert.showAndWait();

                    // TO UPDATE THE SECTION TABLEVIEW
                    availableSectionShowListData();
                    // TO CLEAR THE TEXT FIELDS
                    availableSectionClear();
                } else {return;}
            }
        } catch (Exception e) {e.printStackTrace();}
    }

    public void availableSectionDelete() {
        String deleteData = "DELETE FROM section WHERE section = '" + availableSection_section.getText() + "'";
        connect = Database.connectDB();

        try {
            Alert alert;

            if (availableSection_section.getText().isEmpty()
                    || availableSection_description.getText().isEmpty()
                    || availableSection_adviser.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to DELETE Section: " + availableSection_section.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    statement = connect.createStatement();
                    statement.executeUpdate(deleteData);

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Deleted!");
                    alert.showAndWait();

                    availableSectionShowListData();
                    availableSectionClear();

                } else {return;}
            }
        } catch (Exception e) {e.printStackTrace();}
    }

    public void availableSectionClear() {
        availableSection_section.setText("");
        availableSection_description.setText("");
        availableSection_adviser.setText("");
    }

    private ObservableList<sectionData> availableSectionListD;
    public void availableSectionShowListData() {
        availableSectionListD = availableSectionListData();

        availableSection_col_section.setCellValueFactory(new PropertyValueFactory<>("section"));
        availableSection_col_description.setCellValueFactory(new PropertyValueFactory<>("description"));
        availableSection_col_adviser.setCellValueFactory(new PropertyValueFactory<>("adviser"));

        availableSection_tableView.setItems(availableSectionListD);
    }

    public void availableSectionSelect() {
        sectionData sectionD = availableSection_tableView.getSelectionModel().getSelectedItem();
        int num = availableSection_tableView.getSelectionModel().getSelectedIndex();

        if((num -1) < -1){ return; }

        availableSection_section.setText(sectionD.getSection());
        availableSection_description.setText(sectionD.getDescription());
        availableSection_adviser.setText(sectionD.getAdviser());
    }

    public void studentGradesUpdate() {
        double finalCheck1 = 0, finalCheck2 = 0, finalCheck3 = 0, finalCheck4 = 0, finalCheck5 = 0, finalCheck6 = 0, finalCheck7 = 0;
        String checkData = "SELECT * FROM student_grade WHERE studentID = '" + studentGrade_studentID.getText() + "'";
        connect = Database.connectDB();

        double finalResult = 0;
        try {
            prepare = connect.prepareStatement(checkData);
            result = prepare.executeQuery();

            if(result.next()) {
                finalCheck1 = result.getDouble("math");
                finalCheck2 = result.getDouble("english");
                finalCheck3 = result.getDouble("filipino");
                finalCheck4 = result.getDouble("science");
                finalCheck5 = result.getDouble("tle");
                finalCheck6 = result.getDouble("ap");
                finalCheck7 = result.getDouble("mapeh");
            }

            if(finalCheck1 == 0 || finalCheck2 == 0 || finalCheck3 == 0 || finalCheck4 == 0 || finalCheck5 == 0 || finalCheck6 == 0 || finalCheck7 == 0) {
                finalResult = 0;
            }else {
                finalResult = (Double.parseDouble(studentGrade_mathematics.getText()) + Double.parseDouble(studentGrade_basicenglish.getText())
                        + Double.parseDouble(studentGrade_fil.getText()) + Double.parseDouble(studentGrade_sci.getText()) + Double.parseDouble(studentGrade_tech.getText())
                        + Double.parseDouble(studentGrade_aralinP.getText()) +Double.parseDouble(studentGrade_mapeh.getText())) / 7;
            }

            String updateData = "UPDATE student_grade SET " + " year = '" + studentGrade_year.getText() + "', section = '" + studentGrade_section.getText()
                    + "', math = '" + studentGrade_mathematics.getText() + "', english = '" + studentGrade_basicenglish.getText() + "', filipino = '" + studentGrade_fil.getText()
                    + "', science = '" + studentGrade_sci.getText() + "', tle = '" + studentGrade_tech.getText() + "', ap = '" + studentGrade_aralinP.getText()
                    + "', mapeh = '" + studentGrade_mapeh.getText() + "', final = '" + finalResult + "' WHERE studentID = '" + studentGrade_studentID.getText() + "'";

            Alert alert;
            if(studentGrade_studentID.getText().isEmpty() || studentGrade_year.getText().isEmpty() || studentGrade_section.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill in all the blank fields");
                alert.showAndWait();
            }else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to UPDATE StudentID " + studentGrade_studentID.getText() + " grade?");
                Optional<ButtonType> option =  alert.showAndWait();

                if(option.get().equals(ButtonType.OK)){
                    statement = connect.createStatement();
                    statement.executeUpdate(updateData);

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Grades Successfully Updated!");
                    alert.showAndWait();

                    studentGradesShowListData();
                }else return;
            }
        }catch (Exception e) {e.printStackTrace();}
    }

    public void studentGradesClear() {
        studentGrade_studentID.setText("");
        studentGrade_year.setText("");
        studentGrade_section.setText("");
        studentGrade_mathematics.setText("");
        studentGrade_basicenglish.setText("");
        studentGrade_fil.setText("");
        studentGrade_sci.setText("");
        studentGrade_tech.setText("");
        studentGrade_aralinP.setText("");
        studentGrade_mapeh.setText("");
    }

    public ObservableList<studentData> studentGradesListData() {
        ObservableList<studentData> listData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM student_grade";
        connect = Database.connectDB();

        try {
            studentData studentD;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while(result.next()) {
                studentD = new studentData(result.getInt("studentID"), result.getString("year"), result.getString("section"),
                        result.getDouble("math"), result.getDouble("english"), result.getDouble("filipino"),
                        result.getDouble("science"), result.getDouble("tle"), result.getDouble("ap"),
                        result.getDouble("mapeh"), result.getDouble("final"));

                listData.add(studentD);
            }
        } catch (Exception e) {e.printStackTrace();}
        return listData;
    }

    private ObservableList<studentData> studentGradesList;
    public void studentGradesShowListData() {
        studentGradesList = studentGradesListData();

        studentGrade_col_studentID.setCellValueFactory(new PropertyValueFactory<>("studentID"));
        studentGrade_col_year.setCellValueFactory(new PropertyValueFactory<>("year"));
        studentGrade_col_section.setCellValueFactory(new PropertyValueFactory<>("section"));
        studentGrade_col_mathematics.setCellValueFactory(new PropertyValueFactory<>("mathematics"));
        studentGrade_col_basicenglish.setCellValueFactory(new PropertyValueFactory<>("basicenglish"));
        studentGrade_col_fil.setCellValueFactory(new PropertyValueFactory<>("fil"));
        studentGrade_col_sci.setCellValueFactory(new PropertyValueFactory<>("sci"));
        studentGrade_col_tech.setCellValueFactory(new PropertyValueFactory<>("tech"));
        studentGrade_col_aralinP.setCellValueFactory(new PropertyValueFactory<>("aralinP"));
        studentGrade_col_mapeh.setCellValueFactory(new PropertyValueFactory<>("mapeh"));
        studentGrade_col_final.setCellValueFactory(new PropertyValueFactory<>("finals"));

        studentGrade_tableView.setItems(studentGradesList);
    }

    public void studentGradesSelect() {
        studentData studentD = studentGrade_tableView.getSelectionModel().getSelectedItem();
        int num = studentGrade_tableView.getSelectionModel().getSelectedIndex();

        if((num) < - 1) { return; }
        studentGrade_studentID.setText(String.valueOf(studentD.getStudentID()));
        studentGrade_year.setText(studentD.getYear());
        studentGrade_section.setText(studentD.getSection());
        studentGrade_mathematics.setText(String.valueOf(studentD.getMathematics()));
        studentGrade_basicenglish.setText(String.valueOf(studentD.getBasicenglish()));
        studentGrade_fil.setText(String.valueOf(studentD.getFil()));
        studentGrade_sci.setText(String.valueOf(studentD.getSci()));
        studentGrade_tech.setText(String.valueOf(studentD.getTech()));
        studentGrade_aralinP.setText(String.valueOf(studentD.getAralinP()));
        studentGrade_mapeh.setText(String.valueOf(studentD.getMapeh()));
    }

    public void studentGradesSearch() {
        String searchKey = studentGrade_search.getText().toLowerCase();

        FilteredList<studentData> filter = new FilteredList<>(studentGradesList, e -> true);
        filter.setPredicate(predicateStudentData -> {
            if (searchKey == null || searchKey.isEmpty()) {
                return true; // Show all items if search key is empty
            }

            return predicateStudentData.getStudentID().toString().contains(searchKey)
                    || predicateStudentData.getYear().toLowerCase().contains(searchKey)
                    || predicateStudentData.getSection().toLowerCase().contains(searchKey)
                    || predicateStudentData.getMathematics().toString().contains(searchKey)
                    || predicateStudentData.getBasicenglish().toString().contains(searchKey)
                    || predicateStudentData.getFil().toString().contains(searchKey)
                    || predicateStudentData.getSci().toString().contains(searchKey)
                    || predicateStudentData.getTech().toString().contains(searchKey)
                    || predicateStudentData.getAralinP().toString().contains(searchKey)
                    || predicateStudentData.getMapeh().toString().contains(searchKey)
                    || predicateStudentData.getFinals().toString().contains(searchKey);
        });
        SortedList<studentData> sortList = new SortedList<>(filter);
        sortList.comparatorProperty().bind(studentGrade_tableView.comparatorProperty());
        studentGrade_tableView.setItems(sortList);
    }

    public void displayUsername() {
        admin_username.setText(getData.login_username);
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
            addStudents_form.setVisible(false);
            availableSection_form.setVisible(false);
            studentGrade_form.setVisible(false);

            homeDisplayTotalEnrolledStudents();
            homeDisplayMaleEnrolled();
            homeDisplayFemaleEnrolled();
            homeDisplayTotalPendingStudents();
            homeDisplayTotalDroppedStudents();
            homeDisplayLiveDate();
            homeDisplayLiveClock();
            homeDisplayDigitalClock();
        } else if (event.getSource() == addStudents_btn) {
            home_form.setVisible(false);
            addStudents_form.setVisible(true);
            availableSection_form.setVisible(false);
            studentGrade_form.setVisible(false);

            addStudentsShowListData();
            addStudentsYearList();
            addStudentsGenderList();
            addStudentsStatusList();
            addStudentsSectionList();
            addStudentsSearch();
        } else if (event.getSource() == availableSection_btn) {
            home_form.setVisible(false);
            addStudents_form.setVisible(false);
            availableSection_form.setVisible(true);
            studentGrade_form.setVisible(false);

            availableSectionShowListData();
        } else if (event.getSource() == studentGrade_btn) {
            home_form.setVisible(false);
            addStudents_form.setVisible(false);
            availableSection_form.setVisible(false);
            studentGrade_form.setVisible(true);

            studentGradesShowListData();
            studentGradesSearch();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Load the image once
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/bun/demo1/LOGIN FORM.png")));
        Image image1 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/bun/demo1/logo_llu.png")));

        // Set the same image to each ImageView
        img0.setImage(image1);
        img0_1.setImage(image);
        img0_2.setImage(image);
        img1_1.setImage(image);
        img1_2.setImage(image);
        img1_3.setImage(image);
        img1_31.setImage(image);
        img1_32.setImage(image);
        img2_1.setImage(image);
        img2_2.setImage(image);
        img3_1.setImage(image);
        img3_2.setImage(image);
        img4_1.setImage(image);
        img4_2.setImage(image);
        img_date.setImage(image);

        displayUsername();

        homeDisplayTotalEnrolledStudents();
        homeDisplayMaleEnrolled();
        homeDisplayFemaleEnrolled();
        homeDisplayTotalPendingStudents();
        homeDisplayTotalDroppedStudents();
        homeDisplayLiveDate();
        homeDisplayLiveClock();
        homeDisplayDigitalClock();

        addStudentsShowListData();
        addStudentsYearList();
        addStudentsGenderList();
        addStudentsStatusList();
        addStudentsSectionList();

        availableSectionShowListData();

        studentGradesShowListData();
    }
}