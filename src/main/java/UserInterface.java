import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class UserInterface {

    static JFrame jFrame;

    static JFrame getFrame() {
        JFrame jFrame = new JFrame();
        jFrame.setTitle("WebScraper");
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        jFrame.setBounds(dimension.width / 2 - 500, dimension.height / 2 - 300, 1000, 600);

         JMenuBar jMenuBar = new JMenuBar();
        JMenu jMenuScraper = new JMenu("Scraper");
        jMenuScraper.add(new JMenuItem("Search page")).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.getContentPane().removeAll();
                jFrame.add(new GreetingComponent().createAndShow());
                jFrame.revalidate();
            }
        });

        jMenuBar.add(jMenuScraper);

        jFrame.setJMenuBar(jMenuBar);
        jFrame.setVisible(true);
        return jFrame;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                jFrame = getFrame();
            }
        });

    }

    static class GreetingComponent extends JComponent {
        private JPanel jPanel;

        JPanel createAndShow() {
            jPanel = new JPanel();
            jPanel.setLayout(new GridBagLayout());
            JLabel welcomeLabel = new JLabel("FindMeGoods");
            JTextField searchTextField = new JTextField(50);
            JButton searchButton = new JButton("Search");
            jPanel.add(welcomeLabel);
            jPanel.add(searchTextField);
            jPanel.add(searchButton);
            return jPanel;
        }
    }



}
