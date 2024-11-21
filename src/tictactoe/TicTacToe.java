package tictactoe;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

class TicTacToe extends JFrame implements ActionListener {
    boolean pTurn=true;
    
    JButton btns[]=new JButton[9];
    TicTacToe() {
        Color c1=new Color(109,255,112);
        for(int i=0;i<9;i++) {
            btns[i]=new JButton();
            add(btns[i]);
            btns[i].setFont(new Font("Times New Roman",Font.BOLD,40));
            btns[i].setBackground(c1);
            btns[i].addActionListener(this);
        }
        setLayout(new GridLayout(3,3));
        setBounds(100,100,600,600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    void checkWin() {
        for(int i=0;i<9;i+=3) {
            if(btns[i].getText().equals(btns[i+1].getText())&&btns[i].getText().equals(btns[i+2].getText())&&!btns[i].isEnabled()) {
                JOptionPane.showMessageDialog(rootPane,btns[i].getText()+" wins");
                resetGame();
                return;
            }
        }
        for(int i=0;i<3;i++) {
            if(btns[i].getText().equals(btns[i+3].getText())&&btns[i].getText().equals(btns[i+6].getText())&&!btns[i].isEnabled()) {
                JOptionPane.showMessageDialog(rootPane,btns[i].getText()+" wins");
                resetGame();
                return;
            }
        }
        if(btns[0].getText().equals(btns[4].getText())&&btns[0].getText().equals(btns[8].getText())&&!btns[0].isEnabled()) {
            JOptionPane.showMessageDialog(rootPane,btns[0].getText()+" wins");
            resetGame();
            return;
        }
        if(btns[2].getText().equals(btns[4].getText())&&btns[2].getText().equals(btns[6].getText())&&!btns[2].isEnabled()) {
            JOptionPane.showMessageDialog(rootPane,btns[2].getText()+" wins");
            resetGame();
            return;
        }
        boolean tie=true;
        for(int i=0;i<9;i++) {
                if(btns[i].isEnabled()) {
                tie=false;
                break;
            }
        }
        if(tie) {
            JOptionPane.showMessageDialog(rootPane, "Tie Game");
            resetGame();
        }
    }
    void resetGame() {
        for(int i=0;i<9;i++) {
            btns[i].setText("");
            btns[i].setEnabled(true);
        }
        pTurn=true;
    }
    public void actionPerformed(ActionEvent ae) {
        JButton move=(JButton)ae.getSource();
        if(pTurn) {
            move.setText("X");
            //move.setBackground(Color.red);
        }
        else {
            move.setText("O");
        }
        move.setEnabled(false);
        pTurn=!pTurn;
        checkWin();
    }
    public static void main(String[] args) {
        new TicTacToe();
    }
}