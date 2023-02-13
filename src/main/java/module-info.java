module com.main.project2211 {
    requires javafx.controls;
    requires javafx.fxml;
    requires webcam.capture;
    requires java.desktop;


    opens com.main.project2211 to javafx.fxml;
    exports com.main.project2211;
}