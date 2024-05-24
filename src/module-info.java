module FlyOutJavaFX {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;

	opens model to javafx.base;

	opens application to javafx.graphics, javafx.fxml;
	opens Controller to javafx.fxml;
}
