package aims.screen;

import aims.cart.Cart;
import aims.exceptions.PlayerException;
import aims.media.Media;
import aims.media.Play;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {

    private Cart cart;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediacategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private Button btnPlaceOrder;
    
    @FXML
    private TextField tfFilter;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private Label lblTotalCost;

    private FilteredList<Media> filteredList;
    private ObservableList<Media> cartItems;

    public CartScreenController(Cart cart) {
        super();
        this.cart = cart;
    }

    @FXML
    private void initialize() {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediacategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
        
        if (this.cart != null) {
            cartItems = FXCollections.observableArrayList(this.cart.getItemsOrdered());
        } else {
            cartItems = FXCollections.observableArrayList();
        }

        filteredList = new FilteredList<>(cartItems, null);
        tblMedia.setItems(filteredList);

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);
        
        updateTotalCost();

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
            new ChangeListener<Media>() {
                @Override
                public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                    if (newValue != null) {
                        updateButtonBar(newValue);
                    }
                }
            }
        );

        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                showFilteredMedia(newValue);
            }
        });
    }
    
    private void updateTotalCost() {
        if (cart != null && lblTotalCost != null) {
            float total = cart.totalCost(); 
            lblTotalCost.setText(String.format("%.2f $", total));
        }
    }

    void showFilteredMedia(String searchString) {
        if (searchString == null || searchString.isEmpty()) {
            filteredList.setPredicate(null);
        } else {
            filteredList.setPredicate(media -> {
                String term = searchString.toLowerCase();
                if (radioBtnFilterId.isSelected()) {
                    return String.valueOf(media.getId()).contains(term); 
                } else {
                    return media.getTitle().toLowerCase().contains(term);
                }
            });
        }
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media != null) {
            this.cart.removeMedia(media);
            cartItems.remove(media); 
            
            updateTotalCost();
        }
    }

    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Order Status");
        alert.setHeaderText(null);
        alert.setContentText("Order placed successfully! Total cost: " + lblTotalCost.getText());
        alert.showAndWait();
        
        
        cartItems.clear();
        updateTotalCost();
    }

    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media instanceof Play) {
            try {
                ((Play) media).play();
            } catch (PlayerException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Illegal Media Length");
                alert.setHeaderText(null);
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }
        }
    }

    void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        if (media instanceof Play) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
        }
    }
}