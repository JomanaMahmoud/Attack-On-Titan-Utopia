module M2.Solution {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires java.desktop;

    // Adjust package names as necessary
    opens game.gui to javafx.fxml;
    exports game.gui;
}
