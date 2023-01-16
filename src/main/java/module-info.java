module com.example.w23comp1008s2w2fx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.w23comp1008s2w2fx to javafx.fxml;
    exports com.example.w23comp1008s2w2fx;
}