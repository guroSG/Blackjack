package com.designanalys.main;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Screen;
import javafx.stage.Stage;
import model.BlackjackModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.Card;
import model.Deck;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BlackjackController {

    private List<Card> deckInPlay;
    private List<Card> playerHand = new ArrayList<>();
    ;
    private List<Card> houseHand = new ArrayList<>();
    ;

    private int cardInPlay = 0;

    private int playerScore = 0;
    private int houseScore = 0;
    private final String scoreMessagePlayer = "Dina poäng: ";
    private final String scoreMessageHouse = "Husets poäng: ";

    @FXML
    Label playerPointsLabel;
    @FXML
    Label housePointsLabel;
    @FXML
    Button startButton;
    @FXML
    Button dealButton;
    @FXML
    Button hitButton;
    @FXML
    Button stayButton;
    @FXML
    Label playerCard1Label;
    @FXML
    Label playerCard2Label;
    @FXML
    Label playerCard3Label;
    @FXML
    Label playerCard4Label;
    @FXML
    Label playerCard5Label;
    @FXML
    Label playerCard6Label;
    @FXML
    Label playerCard7Label;
    @FXML
    Label playerCard8Label;
    @FXML
    Label playerCard9Label;
    @FXML
    Label playerCard10Label;
    @FXML
    Label playerCard11Label;
    @FXML
    Label houseCard1Label;
    @FXML
    Label houseCard2Label;
    @FXML
    Label houseCard3Label;
    @FXML
    Label houseCard4Label;
    @FXML
    Label houseCard5Label;
    @FXML
    Label houseCard6Label;
    @FXML
    Label houseCard7Label;
    @FXML
    Label houseCard8Label;
    @FXML
    Label houseCard9Label;
    @FXML
    Label houseCard10Label;
    @FXML
    Label houseCard11Label;

    @FXML
    protected void onStartButtonClick() throws IOException, NullPointerException {
        Parent root = FXMLLoader.load(getClass().getResource("blackjack-view.fxml"));
        Stage stage = (Stage) startButton.getScene().getWindow();
        stage.setScene(new Scene(root, 450, 400));
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((screenBounds.getWidth() - stage.getWidth()) / 2);
        stage.setY((screenBounds.getHeight() - stage.getHeight()) / 2);
    }

    @FXML
    public void hit() {
        cardInPlay++;
        playerHand.add(deckInPlay.get(cardInPlay));
        if (playerCard3Label.getText().isBlank()) {
            addToHand(playerCard3Label);
        } else if (playerCard4Label.getText().isBlank()) {
            addToHand(playerCard4Label);
        } else if (playerCard5Label.getText().isBlank()) {
            addToHand(playerCard5Label);
        } else if (playerCard6Label.getText().isBlank()) {
            addToHand(playerCard6Label);
        } else if (playerCard7Label.getText().isBlank()) {
            addToHand(playerCard7Label);
        } else if (playerCard8Label.getText().isBlank()) {
            addToHand(playerCard8Label);
        } else if (playerCard9Label.getText().isBlank()) {
            addToHand(playerCard9Label);
        } else if (playerCard10Label.getText().isBlank()) {
            addToHand(playerCard10Label);
        } else {
            addToHand(playerCard11Label);
        }
        winStatePlayer();
    }

    private void addToHand(Label label) {
        label.setText(deckInPlay.get(cardInPlay).getCardType() + " " + deckInPlay.get(cardInPlay).getSuit());
        label.setVisible(true);
    }

    @FXML
    public boolean stay() {
        houseCard2Label.setVisible(true);
        if (winStateHouse()){
            return false;
        }
        if (checkWinCondition(houseHand)) {
            JOptionPane.showMessageDialog(null, "Husets blackjack!");
            addHousePoints();
            hitButton.setVisible(false);
            stayButton.setVisible(false);
            dealButton.setVisible(true);
        } else {
            houseHand.add(deckInPlay.get(cardInPlay));
            addToHand(houseCard3Label);
            cardInPlay++;
            if (winStateHouse()){
                return false;
            }
            houseHand.add(deckInPlay.get(cardInPlay));
            addToHand(houseCard4Label);
            cardInPlay++;
            if (winStateHouse()){
                return false;
            }
            houseHand.add(deckInPlay.get(cardInPlay));
            addToHand(houseCard5Label);
            cardInPlay++;
            if (winStateHouse()){
                return false;
            }
            houseHand.add(deckInPlay.get(cardInPlay));
            addToHand(houseCard6Label);
            cardInPlay++;
            if (winStateHouse()){
                return false;
            }
            houseHand.add(deckInPlay.get(cardInPlay));
            addToHand(houseCard7Label);
            cardInPlay++;
            if (winStateHouse()){
                return false;
            }
            houseHand.add(deckInPlay.get(cardInPlay));
            addToHand(houseCard8Label);
            cardInPlay++;
            if (winStateHouse()){
                return false;
            }
            houseHand.add(deckInPlay.get(cardInPlay));
            addToHand(houseCard9Label);
            cardInPlay++;
            if (winStateHouse()){
                return false;
            }
            houseHand.add(deckInPlay.get(cardInPlay));
            addToHand(houseCard10Label);
            cardInPlay++;
            if (winStateHouse()){
                return false;
            }
            houseHand.add(deckInPlay.get(cardInPlay));
            addToHand(houseCard11Label);
            cardInPlay++;

        }
        return false;
    }


    @FXML
    public void dealCards() {
        resetHand();
        Deck deck = BlackjackModel.startGame();
        deckInPlay = deck.getDeckOfCards();
        hitButton.setVisible(true);
        stayButton.setVisible(true);
        dealButton.setVisible(false);
        addToHand(playerCard1Label);
        playerHand.add(deckInPlay.get(cardInPlay));
        cardInPlay++;
        addToHand(playerCard2Label);
        playerHand.add(deckInPlay.get(cardInPlay));
        cardInPlay++;
        addToHand(houseCard1Label);
        houseHand.add(deckInPlay.get(cardInPlay));
        cardInPlay++;
        addToHand(houseCard2Label);
        houseHand.add(deckInPlay.get(cardInPlay));
        cardInPlay++;
        winStatePlayer();
        houseCard2Label.setVisible(false);
    }

    private void winStatePlayer() {
        if (checkWinCondition(playerHand)) {
            JOptionPane.showMessageDialog(null, "Blackjack!");
            addPlayerPoints();
            hitButton.setVisible(false);
            stayButton.setVisible(false);
            dealButton.setVisible(true);
        }
        if (checkForPlayerBust(playerHand)) {
            JOptionPane.showMessageDialog(null, "Du drog en " + deckInPlay.get(cardInPlay).getValue() + ":a och blev tjock! Huset vann!");
            addHousePoints();
            hitButton.setVisible(false);
            stayButton.setVisible(false);
            dealButton.setVisible(true);
        }
    }

    private boolean winStateHouse() {
        if (checkForHouseBust(houseHand)) {
            JOptionPane.showMessageDialog(null, "Huset är tjockt! Du vann!");
            addPlayerPoints();
            hitButton.setVisible(false);
            stayButton.setVisible(false);
            dealButton.setVisible(true);
            return true;
        }
        if (checkWinCondition(houseHand)) {
            JOptionPane.showMessageDialog(null, "Husets blackjack!");
            addHousePoints();
            hitButton.setVisible(false);
            stayButton.setVisible(false);
            dealButton.setVisible(true);
            return true;
        }
        if (checkHouseWin(houseHand, playerHand)){
            JOptionPane.showMessageDialog(null, "Huset vann!");
            addHousePoints();
            hitButton.setVisible(false);
            stayButton.setVisible(false);
            dealButton.setVisible(true);
            return true;
        }
        else return false;
    }

    private boolean checkHouseWin(List<Card> house, List<Card> player){
        int playerValue = 0;
        int houseValue = 0;
        for (Card c : player) {
            playerValue += c.getValue();
        }
        for (Card c : house) {
            houseValue += c.getValue();
        }
        if (houseValue > playerValue && houseValue < 21){
            return true;
        }
        else return false;
    }

    private void resetHand() {
        playerHand.clear();
        houseHand.clear();
        cardInPlay = 0;
        playerCard1Label.setText("");
        playerCard1Label.setVisible(false);
        playerCard2Label.setText("");
        playerCard2Label.setVisible(false);
        playerCard3Label.setText("");
        playerCard3Label.setVisible(false);
        playerCard4Label.setText("");
        playerCard4Label.setVisible(false);
        playerCard5Label.setText("");
        playerCard5Label.setVisible(false);
        playerCard6Label.setText("");
        playerCard6Label.setVisible(false);
        playerCard7Label.setText("");
        playerCard7Label.setVisible(false);
        playerCard8Label.setText("");
        playerCard8Label.setVisible(false);
        playerCard9Label.setText("");
        playerCard9Label.setVisible(false);
        playerCard10Label.setText("");
        playerCard10Label.setVisible(false);
        playerCard11Label.setText("");
        playerCard11Label.setVisible(false);
        houseCard1Label.setText("");
        houseCard1Label.setVisible(false);
        houseCard2Label.setText("");
        houseCard2Label.setVisible(false);
        houseCard3Label.setText("");
        houseCard3Label.setVisible(false);
        houseCard4Label.setText("");
        houseCard4Label.setVisible(false);
        houseCard5Label.setText("");
        houseCard5Label.setVisible(false);
        houseCard6Label.setText("");
        houseCard6Label.setVisible(false);
        houseCard7Label.setText("");
        houseCard7Label.setVisible(false);
        houseCard8Label.setText("");
        houseCard8Label.setVisible(false);
        houseCard9Label.setText("");
        houseCard9Label.setVisible(false);
        houseCard10Label.setText("");
        houseCard10Label.setVisible(false);
        houseCard11Label.setText("");
        houseCard11Label.setVisible(false);
    }

    public boolean checkWinCondition(List<Card> hand) {
        int value = 0;
        for (Card c : hand) {
            value += c.getValue();
        }
        System.out.println(value);
        if (value == 21) {
            return true;
        } else return false;
    }

    public boolean checkForPlayerBust(List<Card> hand) {
        int value = 0;
        boolean containsAce = false;
        for (Card c : hand) {
            value += c.getValue();
        }
        System.out.println(value);
        if (value > 21) {
            for (Card c : playerHand) {
                if (c.getValue() == 11) {
                    containsAce = true;
                    c.setValue(1);
                }
            }
            if (containsAce) {
                return false;
            }
            return true;
        } else return false;
    }

    public boolean checkForHouseBust(List<Card> hand) {
        int value = 0;
        boolean containsAce = false;
        for (Card c : hand) {
            value += c.getValue();
        }
        System.out.println(value);
        if (value > 21) {
            for (Card c : houseHand) {
                if (c.getValue() == 11) {
                    containsAce = true;
                    c.setValue(1);
                }
            }
            if (containsAce) {
                return false;
            }
            return true;
        } else return false;
    }

    public void addHousePoints(){
        houseScore++;
        housePointsLabel.setText(scoreMessageHouse + houseScore);
    }

    public void addPlayerPoints(){
        playerScore++;
        playerPointsLabel.setText(scoreMessagePlayer + playerScore);
    }
}


