package com.bun.demo1;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;


import javax.imageio.IIOParam;
import java.net.URL;
import java.sql.*;
import java.util.*;
import java.util.Date;
import java.util.ResourceBundle;



public class HelloController implements Initializable {


    @FXML
    private PasswordField admin_cPassword;


    @FXML
    private AnchorPane admin_form;


    @FXML
    private PasswordField admin_password;


    @FXML
    private Hyperlink admin_signIn;


    @FXML
    private Button admin_signupBtn;


    @FXML
    private TextField admin_username;


    @FXML
    private Button login_btn;


    @FXML
    private AnchorPane login_form;


    @FXML
    private PasswordField login_password;


    @FXML
    private ComboBox<String> login_role;


    @FXML
    private TextField login_username;


    @FXML
    private PasswordField student_cPassword;


    @FXML
    private TextField student_email;


    @FXML
    private AnchorPane student_form;


    @FXML
    private PasswordField student_password;


    @FXML
    private Hyperlink student_signIn;


    @FXML
    private Button student_signupBtn;


    @FXML
    private TextField student_username;


    @FXML
    private Label date;


    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    private Statement statement;


    private AlertMessage alert = new AlertMessage();
    private IIOParam loader;


    public void loginAccount() {
        if(login_username.getText().isEmpty() || login_password.getText().isEmpty()) {
            alert.errorMessage("Please fill in all the blank fields");
        }else{
            String selectData = "SELECT * FROM users WHERE username = ? and password = ?";
            connect = Database.connectDB();
            String role = "";
            try {
                prepare = connect.prepareStatement(selectData);
                prepare.setString(1, login_username.getText());
                prepare.setString(2, login_password.getText());


                result = prepare.executeQuery();


                if(result.next()){
                    role = result.getString("role");
                    Thread.sleep(1000);
                    if(role.equals("Admin")) {
                        getData.login_username = login_username.getText();


                        //LINK MAIN FORM ADMIN
                        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AdminFormMain.fxml")));


                        Stage stage = new Stage();
                        stage.setTitle("LINCOLN NATIONAL HIGH SCHOOL");
                        stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("logo_llu.png"))));
                        stage.setScene(new Scene(root));
                        stage.setResizable(false);
                        stage.show();
                        //To hide login form
                        login_btn.getScene().getWindow().hide();
                    }else if (role.equals("Student")) {
                        getData.login_username = login_username.getText();


                        //LINK MAIN FORM STUDENT
                        // Retrieve the studentID (username in your case) from the result
                        String studentID = result.getString("username"); // Assuming studentID is stored in "username" field


                        // Load the StudentFormMain.fxml
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("StudentFormMain.fxml"));
                        Parent root = loader.load();


                        // Get the controller of the StudentFormMain
                        StudentFormController studentController = loader.getController();


                        // Pass the studentID (or username) to the controller
                        studentController.setStudentID(studentID);


                        Stage stage = new Stage();
                        stage.setTitle("LINCOLN NATIONAL HIGH SCHOOL");
                        stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("logo_llu.png"))));
                        stage.setScene(new Scene(root));
                        stage.setResizable(false);
                        stage.show();
                        //To hide login form
                        login_btn.getScene().getWindow().hide();
                    }
                }else {
                    alert.errorMessage("Incorrect Username or Password");
                }
            } catch (Exception e) { e.printStackTrace();}
        }
    }


    public void registerAdmin(){
        if (admin_username.getText().isEmpty() || admin_password.getText().isEmpty() || admin_cPassword.getText().isEmpty()) {
            alert.errorMessage("Please fill all blank fields");
        } else {
            connect = Database.connectDB();
            String selectData = "SELECT * FROM users WHERE username = '" + admin_username.getText() + "'";


            try {
                statement = connect.createStatement();
                result = statement.executeQuery(selectData);


                if (result.next()) {
                    alert.errorMessage(admin_username.getText() + " already exists");
                } else if (!admin_password.getText().equals(admin_cPassword.getText())) {
                    alert.errorMessage("Password does not match.");
                } else if (admin_password.getText().length() < 8) {
                    alert.errorMessage("Invalid password, at least 8 characters needed.");
                } else {
                    String insertData = "INSERT INTO users (username, password, role, date)" + "VALUES(?,?,?,?)";
                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());


                    prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, admin_username.getText());
                    prepare.setString(2, admin_password.getText());
                    prepare.setString(3, "Admin");
                    prepare.setString(4, String.valueOf(sqlDate));


                    prepare.executeUpdate();


                    alert.successMessage("Registered successfully!");


                    login_form.setVisible(true);
                    admin_form.setVisible(false);
                }
            } catch (SQLException e) {e.printStackTrace();}
        }
    }


    public void registerStudent() {
        if (student_email.getText().isEmpty() || student_username.getText().isEmpty() || student_password.getText().isEmpty() || student_cPassword.getText().isEmpty()) {
            alert.errorMessage("Please fill all blank fields");
        } else {
            connect = Database.connectDB();
            String selectData = "SELECT * FROM users WHERE username = '" + student_username.getText() + "'";


            try {
                statement = connect.createStatement();
                result = statement.executeQuery(selectData);


                if (result.next()) {
                    alert.errorMessage(student_username.getText() + " already exists");
                } else if (!student_password.getText().equals(student_cPassword.getText())) {
                    alert.errorMessage("Password does not match.");
                } else if (student_password.getText().length() < 8) {
                    alert.errorMessage("Invalid password, at least 8 characters needed.");
                } else {
                    String insertData = "INSERT INTO users (email, username, password, role, date)" + "VALUES(?,?,?,?,?)";
                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());


                    prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, student_email.getText());
                    prepare.setString(2, student_username.getText());
                    prepare.setString(3, student_password.getText());
                    prepare.setString(4, "Student");
                    prepare.setString(5, String.valueOf(sqlDate));


                    prepare.executeUpdate();


                    alert.successMessage("Registered successfully!");


                    login_form.setVisible(true);
                    student_form.setVisible(false);
                }
            } catch (SQLException e) {e.printStackTrace();}
        }
    }


    public void roleList() {
        List<String> listR = new ArrayList<>();
        Collections.addAll(listR, ListData.role);


        ObservableList listData = FXCollections.observableArrayList(listR);
        login_role.setItems(listData);
    }


    public void signInForm() {
        login_form.setVisible(true);
        admin_form.setVisible(false);
        student_form.setVisible(false);
    }




    public void switchForm(ActionEvent event) {
        switch (login_role.getSelectionModel().getSelectedItem()) {
            case "Admin":
                login_form.setVisible(false);
                admin_form.setVisible(true);
                student_form.setVisible(false);
                break;
            case "Student":
                login_form.setVisible(false);
                admin_form.setVisible(false);
                student_form.setVisible(true);
                break;
            default:
                break;
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Load the image
        Image loginFormImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/bun/demo1/LOGIN FORM.png")));


        // Create a BackgroundImage instance
        BackgroundImage backgroundImage = new BackgroundImage(
                loginFormImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(100, 100, true, true, true, true)
        );


        // Set the background on the AnchorPane
        login_form.setBackground(new Background(backgroundImage));
        admin_form.setBackground(new Background(backgroundImage));
        student_form.setBackground(new Background(backgroundImage));
        roleList();
    }
}