module com.main.project2211 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.main.project2211 to javafx.fxml;
    exports com.main.project2211;
}