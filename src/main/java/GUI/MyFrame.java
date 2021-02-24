package GUI;

import GUI.panels.Panels;
import GUI.panels.PanelsInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;

public class MyFrame extends JFrame {

    private static final String icon = "/ikona.png";
    private final MainPanel mainPanel;
    private final PanelsInterface panels = new Panels();
    private JButton backButton;
    private final MySettings settings = new MySettings();

    public MyFrame() {

        try {
            URL iconURL = getClass().getResource(icon);
            setIconImage(Toolkit.getDefaultToolkit().getImage(iconURL));
        } catch (Exception ex) {
            System.out.println("Problem with icon");
        }

        setSize(600, 300);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();
        int posX = width / 2 - getWidth() / 2;
        int posY = height / 2 - getHeight() / 2;

        setTitle("Various apps");
        setResizable(false);
        setLocation(posX, posY);
        getContentPane().setBackground(Color.black);
        setMyBackground();

        mainPanel = new MainPanel();
        add(mainPanel);

        fileCreateActions();
        folderCreateActions();
        saActions();
        renameActions();
        qaActions();
    }

    private void fileCreateActions(){

        mainPanel.getFileCreator().addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    mainPanel.getFileCreator().doClick();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        mainPanel.getFileCreator().addActionListener(e ->{

            JPanel fileCreatorPanel = panels.getFileCreatorPanel();
            setBackButton();

            getContentPane().add(fileCreatorPanel);
            getContentPane().remove(mainPanel);
            repaint();
            revalidate();

            backButton.addActionListener(e1 ->{
                getContentPane().add(mainPanel);
                getContentPane().remove(fileCreatorPanel);
                getContentPane().remove(backButton);
                repaint();
                revalidate();
            });
        });
    }

    private void folderCreateActions(){

        mainPanel.getFolderCreator().addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    mainPanel.getFolderCreator().doClick();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        mainPanel.getFolderCreator().addActionListener(e ->{

            JPanel folderCreatorPanel = panels.getFolderCreatorPanel();
            setBackButton();

            getContentPane().add(folderCreatorPanel);
            getContentPane().remove(mainPanel);
            repaint();
            revalidate();

            backButton.addActionListener(e1 ->{
                getContentPane().add(mainPanel);
                getContentPane().remove(folderCreatorPanel);
                getContentPane().remove(backButton);
                repaint();
                revalidate();
            });
        });
    }

    private void saActions(){

        mainPanel.getSACreator().addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    mainPanel.getSACreator().doClick();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        mainPanel.getSACreator().addActionListener(e ->{
            JPanel saPanel = panels.getSACreatorPanel();
            setBackButton();

            getContentPane().add(saPanel);
            getContentPane().remove(mainPanel);
            repaint();
            revalidate();

            backButton.addActionListener(e1 ->{
                getContentPane().add(mainPanel);
                getContentPane().remove(saPanel);
                getContentPane().remove(backButton);
                repaint();
                revalidate();
            });
        });
    }

    private void renameActions(){

        mainPanel.getFileRenamer().addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    mainPanel.getFileRenamer().doClick();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        mainPanel.getFileRenamer().addActionListener(e ->{
            JPanel renamePanel = panels.getFileRenamerPanel();
            setBackButton();

            getContentPane().add(renamePanel);
            getContentPane().remove(mainPanel);
            repaint();
            revalidate();

            backButton.addActionListener(e1 ->{
                getContentPane().add(mainPanel);
                getContentPane().remove(renamePanel);
                getContentPane().remove(backButton);
                repaint();
                revalidate();
            });
        });
    }

    private void qaActions(){

        mainPanel.getQuickQA().addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    mainPanel.getQuickQA().doClick();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        mainPanel.getQuickQA().addActionListener(e ->{
            JPanel qaPanel = panels.getQAPanel();
            setBackButton();

            getContentPane().add(qaPanel);
            getContentPane().remove(mainPanel);
            repaint();
            revalidate();

            backButton.addActionListener(e1 ->{
                getContentPane().add(mainPanel);
                getContentPane().remove(qaPanel);
                getContentPane().remove(backButton);
                repaint();
                revalidate();
            });
        });
    }


    private void setMyBackground(){

        JLabel background = settings.setMyBackground();
        background.setBounds(500,185,75,71);
        add(background);

    }

    private void setBackButton(){

        backButton = new JButton("<<");
        backButton.setBounds(40,210,50,50);
        backButton.setHorizontalAlignment(SwingConstants.LEFT);
        backButton.setMnemonic('b');
        settings.myButtonTwo(backButton);

        add(backButton);
    }

}