module org.example.servapii {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires jakarta.mail;

    opens org.example.servapii to javafx.fxml;
    exports org.example.servapii;
}