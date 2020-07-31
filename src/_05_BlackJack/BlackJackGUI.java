package _05_BlackJack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

public class BlackJackGUI extends JPanel {
    JPanel topPanel = new JPanel();
    JPanel dCardPanel = new JPanel();
    JPanel pCardPanel = new JPanel();
    JTextPane winLoseBox = new JTextPane();
    JButton hitButton = new JButton();
    JButton dealButton = new JButton();
    JButton stayButton = new JButton();
    JButton playAgainButton = new JButton();
    JLabel dealerLabel = new JLabel();
    JLabel playerLabel = new JLabel();

    Hand dealer = new Hand();
    Hand player = new Hand();
    BlackJack game = new BlackJack(dealer, player);

    JLabel playerCard1;
    JLabel playerCard2;
    JLabel playerCardHit;
    JLabel dealerCard0;
    JLabel dealerCard2;
    JLabel dealerCard1;
    JLabel dealerCardHit;

    public BlackJackGUI() {
        topPanel.setBackground(new Color(0, 122, 0));
        dCardPanel.setBackground(new Color(0, 122, 0));
        pCardPanel.setBackground(new Color(0, 122, 0));

        topPanel.setLayout(new FlowLayout());
        winLoseBox.setText("  ");
        winLoseBox.setFont(new java.awt.Font("Helvetica Bold", 1, 20));
        dealButton.setText("  Deal");
        dealButton.addActionListener(new dealButton());
        hitButton.setText("  Hit");
        hitButton.addActionListener(new hitButton());
        hitButton.setEnabled(false);
        stayButton.setText("  Stay");
        stayButton.addActionListener(new stayButton());
        stayButton.setEnabled(false);
        playAgainButton.setText("  Play Again");
        playAgainButton.addActionListener(new playAgainButton());
        playAgainButton.setEnabled(false);

        dealerLabel.setText("  Dealer:  ");
        playerLabel.setText("  Player:  ");

        topPanel.add(winLoseBox);
        topPanel.add(dealButton);
        topPanel.add(hitButton);
        topPanel.add(stayButton);
        topPanel.add(playAgainButton);
        pCardPanel.add(playerLabel);
        dCardPanel.add(dealerLabel);

        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.NORTH);
        add(dCardPanel, BorderLayout.CENTER);
        add(pCardPanel, BorderLayout.SOUTH);

        System.out.println("GUI Created");
    }

    public void display() {
        JFrame myFrame = new JFrame("BlackJack");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setContentPane(this);
        myFrame.setPreferredSize(new Dimension(700, 550));

        myFrame.pack();
        myFrame.setVisible(true);
    }

    class dealButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dCardPanel.add(dealerLabel);
            pCardPanel.add(playerLabel);

            dealerCard0 = new JLabel(new ImageIcon("src/_05_BlackJack/images/back.jpg"));
            game.dealInitialCards();

            Card dCard = null;
            Iterator<Card> dScan = (dealer.inHand).iterator();
            int count = 0;
            while (dScan.hasNext()) {
                dCard = dScan.next();
                if (count == 0) {
                    dealerCard1 = new JLabel(dCard.getImage());
                } else {
                    dealerCard2 = new JLabel(dCard.getImage());
                }
                count++;
            }

            Iterator<Card> pScan = (player.inHand).iterator();
            count = 0;
            // System.out.println("pScan: " + pScan);
            while (pScan.hasNext()) {
                Card pCard = pScan.next();
                if (count == 0) {
                    playerCard1 = new JLabel(pCard.getImage());
                } else {
                    playerCard2 = new JLabel(pCard.getImage());
                }
                count++;
            }

            dCardPanel.add(dealerCard0);
            dCardPanel.add(dealerCard2);

            pCardPanel.add(playerCard1);
            pCardPanel.add(playerCard2);

            dealerLabel.setText("  Dealer:  " + dCard.getValue());
            playerLabel.setText("  Player:  " + game.handValue(player));

            hitButton.setEnabled(true);
            stayButton.setEnabled(true);
            dealButton.setEnabled(false);

            if (game.blackj()) {
                hitButton.setEnabled(false);
                stayButton.setEnabled(false);
                dealButton.setEnabled(false);
                playAgainButton.setEnabled(true);
                winLoseBox.setText("BlackJack");
            }

            add(dCardPanel, BorderLayout.CENTER);
            add(pCardPanel, BorderLayout.SOUTH);

        }
    }

    class hitButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            Card hitCard = game.hit(player);
            playerCardHit = new JLabel(hitCard.getImage());
            pCardPanel.add(playerCardHit);
            pCardPanel.repaint();

            if (game.bust(player)) {
                winLoseBox.setText("Bust");
                hitButton.setEnabled(false);
                dealButton.setEnabled(false);
                stayButton.setEnabled(false);
                playAgainButton.setEnabled(true);
            }

            playerLabel.setText("  Player:  " + game.handValue(player));

        }
    }

    class stayButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dCardPanel.remove(dealerCard0);
            dCardPanel.add(dealerCard1);

            dealer = game.dealerPlays();
            dCardPanel.removeAll();
            dCardPanel.add(dealerLabel);
            dealerLabel.setText(" " + dealerLabel.getText());

            Card dHitCard = null;
            Iterator<Card> scan = (dealer.inHand).iterator();
            while (scan.hasNext()) {
                dHitCard = scan.next();
                dealerCardHit = new JLabel(dHitCard.getImage());
                dCardPanel.add(dealerCardHit);
            }
            dealerLabel.setText("Dealer: " + game.handValue(dealer));
            playerLabel.setText("player: " + game.handValue(player));

            winLoseBox.setText(game.winner());
            hitButton.setEnabled(false);
            stayButton.setEnabled(false);

            playAgainButton.setEnabled(true);

        }
    }

    class playAgainButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dealerLabel.setText("Dealer: ");
            playerLabel.setText("Player: ");
            winLoseBox.setText("");
            dealer = new Hand();
            player = new Hand();
            game = new BlackJack(dealer, player);

            dCardPanel.removeAll();
            pCardPanel.removeAll();

            hitButton.setEnabled(false);
            stayButton.setEnabled(false);
            playAgainButton.setEnabled(false);
            dealButton.setEnabled(true);

        }
    }

}

