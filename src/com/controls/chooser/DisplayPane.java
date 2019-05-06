/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controls.chooser;

import com.business.resources.fonts.Fonts;
import com.business.structs.Stack;
import com.controls.input.RwtButton;
import com.controls.input.RwtField;
import com.styles.InvertablePane;
import java.io.File;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;

/**
 *
 * @author daan-
 */
public class DisplayPane extends BorderPane implements InvertablePane {

    private RwtField selectField;
    private RwtField pathField;
    private RwtButton selectButton;
    private RwtButton cancelButton;
    private RwtButton returnButton;

    private ListView<ChooserItem> listView;
    private Stack<ChooserItem> breadCrumbStack;



    public DisplayPane() {
        super();
        initCenter();
        initBottom();
        initTop();
        selectButton.setMinWidth(150);
        cancelButton.setMinWidth(150);
        returnButton.setMinWidth(150);
        setPrefWidth(850);
        super.setBackground(new Background(new BackgroundFill(Color.web("#FFFFFF"), CornerRadii.EMPTY, Insets.EMPTY)));
        selectButton.setOnAction((event)->{updateBackgroundColor(Color.web("#000000"), true);});
    }



    @Override
    public void updateBackgroundColor(Color color, boolean invert) {
        super.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
        setInverted(invert);
    }



    @Override
    public void setInverted(boolean invert) {
        if (invert == true) {
            pathField.setInverted(invert);
            selectField.setInverted(invert);
            selectButton.setInverted(invert);
            cancelButton.setInverted(invert);
            returnButton.setInverted(invert);
            listView.setCellFactory((param) -> {
                return new InvertedCell(); //To change body of generated lambdas, choose Tools | Templates.
            });

        } else {
            pathField.setInverted(invert);
            selectField.setInverted(invert);
            selectButton.setInverted(invert);
            cancelButton.setInverted(invert);
            returnButton.setInverted(invert);
            listView.setCellFactory((param) -> {
                return new DefaultCell(); //To change body of generated lambdas, choose Tools | Templates.
            });
        }
    }



    private void initCenter() {
        listView = new ListView<>();
        breadCrumbStack = new Stack<>();
        ChooserItem rootItem = ChooserItemFactory.createChooserItem(new File("C:\\"));
        breadCrumbStack.push(rootItem);
        listView.setItems(ChooserItemFactory.createFolder(new File("C:\\")));
        listView.setCellFactory((param) -> {
            return new DefaultCell();
        });
        AnchorPane.setTopAnchor(listView, 16.0);
        AnchorPane.setBottomAnchor(listView, 16.0);
        AnchorPane.setLeftAnchor(listView, 16.0);
        AnchorPane.setRightAnchor(listView, 16.0);
        AnchorPane pane = new AnchorPane(listView);
        super.setCenter(pane);
        listView.setOnMouseClicked((event) -> {
            if (event.getClickCount() >= 2) {
                ChooserItem item = listView.getSelectionModel().getSelectedItem();
                if (item != null) {
                    if (item.getFile().isDirectory()) {
                        breadCrumbStack.push(item);
                        listView.setItems(ChooserItemFactory.createFolder(item.getFile()));
                    }
                }
            }

        });
    }



    private void initBottom() {
        selectField = new RwtField();
        selectField.setPrefColumnCount(40);
        selectButton = new RwtButton();
        selectButton.setText("Selecteren");
        cancelButton = new RwtButton();
        cancelButton.setText("Annuleren");
        GridPane.setConstraints(selectField, 0, 0, 5, 1, HPos.LEFT, VPos.BASELINE, Priority.ALWAYS, Priority.NEVER);
        GridPane.setConstraints(selectButton, 5, 0, 1, 1, HPos.RIGHT, VPos.BASELINE);
        GridPane.setConstraints(cancelButton, 5, 1, 1, 1, HPos.RIGHT, VPos.BASELINE);
        GridPane pane = new GridPane();
        pane.setPrefWidth(800);
        pane.getChildren().addAll(selectField, selectButton, cancelButton);
        pane.setPadding(new Insets(16));
        pane.setHgap(16);
        pane.setVgap(16);
        pane.prefWidthProperty().bind(super.widthProperty());

        super.setBottom(pane);
        listView.getSelectionModel().selectedItemProperty().addListener((o, v1, v2) -> {
            if (v2 == null) {
                selectField.setText("");
                selectButton.setDisable(true);
            } else {
                selectField.setText(v2.getFile().getAbsolutePath());
                selectButton.setDisable(false);
            }
        });

    }



    private void initTop() {
        pathField = new RwtField();
        pathField.setPrefColumnCount(40);
        returnButton = new RwtButton();
        returnButton.setText("Terug");
        FlowPane pane = new FlowPane(Orientation.HORIZONTAL, 16, 16, returnButton, pathField);
        pane.setPadding(new Insets(16));
        super.setTop(pane);

    }

    public class DefaultCell extends ListCell<ChooserItem> {

        @Override
        public void updateItem(ChooserItem item, boolean empty) {
            super.updateItem(item, empty);
            
            if (empty) {
                setGraphic(null);
                setText("");
            } else {
                Label label = new Label(item.getName());
                label.setFont(Fonts.POPPINS.regular(16));
                FlowPane root = new FlowPane(Orientation.HORIZONTAL, 16, 16, item.getThumbnail(), label);
                root.setPadding(new Insets(16));
                setGraphic(root);
            }
        }

    }
    public class InvertedCell extends ListCell<ChooserItem> {

        public void updateItem(ChooserItem item, boolean empty) {
            super.updateItem(item, empty);
            if (empty) {
                setGraphic(null);
                setText("");
            } else {
                Label label = new Label(item.getName());
                label.setFont(Fonts.POPPINS.regular(16));
                label.setTextFill(Color.web("#FFFFFF"));
                FlowPane root = new FlowPane(Orientation.HORIZONTAL, 16, 16, item.getThumbnailWhite(), label);
                root.setPadding(new Insets(16));
                setGraphic(root);
            }
        }

    }

}
