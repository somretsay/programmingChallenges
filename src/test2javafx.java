import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class test2javafx extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a title for the window
        primaryStage.setTitle("JavaFX Example");

        // Create a text field
        TextField textField = new TextField();
        textField.setPromptText("Enter your name");

        // Create a button
        Button button = new Button("Say Hello");
        button.setOnAction(e -> {
            // Button click action
            String name = textField.getText();
            System.out.println("Hello, " + name + "!");
        });

        // Create a layout and add the text field and button
        VBox layout = new VBox(10); // Vertical layout with 10 pixels spacing
        layout.getChildren().addAll(textField, button);

        // Create a scene with the layout
        Scene scene = new Scene(layout, 300, 200);

        // Set the scene on the stage
        primaryStage.setScene(scene);

        // Show the stage
        primaryStage.show();
    }

    public static void main(String[] args) {
        // Launch the JavaFX application
        launch(args);
    }
}

