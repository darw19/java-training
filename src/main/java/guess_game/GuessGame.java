package guess_game;

import org.fluttercode.datafactory.impl.DataFactory;
import javax.swing.*;
import java.io.*;


public class GuessGame {

    private int topScore;
    private static final String scorePath = "bestScore.obj";

    public double play(int max) {
        DataFactory dataFactory = new DataFactory();
        int target = dataFactory.getNumberBetween(0, max);
        int guess = -1;
        int guessCount = 0;
        while (guess != target) {
            boolean check = true;
            do {
                check = true;
                try {
                    guess = Integer.parseUnsignedInt(JOptionPane.showInputDialog("what's your guess?"));
                }
                catch (NumberFormatException nfe) {
                    check = false;
                }
            } while(!check);
            guessCount++;
            if (guess != target) {
                String hint = guess < target ? "Greater" : "Smaller";
                JOptionPane.showMessageDialog(null, hint, "Hint", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        double score = max / guessCount;

        return score;
    }

    public void printBestScore() {

    }

    public double readBestScore() throws IOException, InterruptedException, ClassNotFoundException{
        File file = new File(scorePath);
        double result = 0;
        if (file.exists()) {

            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object o = ois.readObject();
            result = (double) o;
        }

        return result;
    }

    public void writeBestScore(double score) throws IOException, InterruptedException{
        File file = new File(scorePath);
        if (file.exists()) {
            file.delete();
            file.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(score);
    }

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        GuessGame game = new GuessGame();
        boolean check = true;
        int maxValue = 0;
        do {
            check = true;
            try {
                maxValue = Integer.parseUnsignedInt(JOptionPane.showInputDialog("set max value"));
            }
            catch (NumberFormatException nfe) {
                check = false;
            }
        } while(!check);
        double score = game.play(maxValue);

        double prevBestScore = game.readBestScore();

        if (score > prevBestScore) {
            JOptionPane.showMessageDialog(null, "Congratulations! You set new best score! \nPrevious best score: " + prevBestScore + "\nYour score: " + score,
                    "Results", JOptionPane.INFORMATION_MESSAGE);

            game.writeBestScore(score);
        }
        else {
            JOptionPane.showMessageDialog(null, "Best score: " + prevBestScore + "\nYour score: " + score,
                    "Results", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
