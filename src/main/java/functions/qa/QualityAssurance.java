package functions.qa;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

class QualityAssurance{

    private List<String> testedFolders = new ArrayList<>();
    private List<MyFile> sources = new ArrayList<>();
    private List<List<MyFile>> testes = new ArrayList<>();

    private File lastOpened = new File("C:\\");

    private StringBuilder stringBuilder = new StringBuilder();

    QualityAssurance(JPanel panel, JButton sourceButton, JButton testedButton, JButton checkButton,
                     JButton resetButton, JButton helpButton, JTextField sourcePath, JTextField testedPath,
                     JCheckBox ignoreSizeCheck, JCheckBox failsOnlyCheck){

        actions(panel, sourceButton, testedButton, checkButton, resetButton, helpButton, sourcePath, testedPath,
                ignoreSizeCheck, failsOnlyCheck);
    }

    private void actions(JPanel panel, JButton sourceButton, JButton testedButton, JButton checkButton,
                         JButton resetButton, JButton helpButton, JTextField sourcePath, JTextField testedPath,
                         JCheckBox ignoreSizeCheck, JCheckBox failsOnlyCheck){

        sourceButton.addActionListener(e -> loadSourceFiles(sourcePath));
        testedButton.addActionListener(e -> loadTestedFiles(testedPath));

        checkButton.addActionListener(e -> {
            if(checkButtonCondition()) {
                checkFiles(ignoreSizeCheck, failsOnlyCheck);
                JOptionPane.showMessageDialog(panel, "Checked.");
            } else {
                JOptionPane.showMessageDialog(panel, "Missing input data.");
            }
        });

        resetButton.addActionListener(e -> {
            sourcePath.setText("");
            testedPath.setText("");
            stringBuilder.setLength(0);
        });

        helpButton.addActionListener(e ->
                JOptionPane.showMessageDialog(panel, "1. Click on \"Source\" button on the QA app\n" +
                        "2. Paste location of the \"1. Source\" folder in the \"Folder Name\" search bar\n" +
                        "3. Press \"Open\" button\n" +
                        "4. Click on \"Tested\" button on the QA app\n" +
                        "5. Click on \"3. To Upload\" folder\n" +
                        "6. Press \"Open\" button\n" +
                        "7. Click on \"Check\" button on the QA app\n" +
                        "8. Name a file in the \"File Name:\" section\n" +
                        "9. Press \"Save\"\n" +
                        "10. Go to \"Screenshots\" folder\n" +
                        "11. Click on the text file that you created\n" +
                        "12. Check if all screenshots and languages have good size, good name, and quantity.\n" +
                        "Check \"Ignore size\" if you do not need exact size"));
    }

    private void loadSourceFiles(JTextField sourcePath) {

        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);

        File sourceFile = null;

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            sourceFile = chooser.getSelectedFile();
            lastOpened = sourceFile.getParentFile();
        }

        this.sources.clear();

        checkSourceFiles(sourceFile, sourcePath);
    }

    private void checkSourceFiles(File sourceFile, JTextField sourcePath){
        // get names of all files from the loaded folder and set path to folder on GUI view
        try {
            File[] sourceFiles = sourceFile.listFiles();

            if (sourceFiles != null) {
                for (File f : sourceFiles) {
                    if (f.getName().equals(".DS_Store") || f.getName().equals("Thumbs.db"))
                        continue;

                    if(f.isDirectory()){
                        checkSourceFiles(f, sourcePath);
                    } else {
                        MyFile myFile = new MyFile(f);
                        sources.add(myFile);
                    }
                }
            }
            sourcePath.setText(sourceFile.getAbsolutePath());
        } catch (NullPointerException e) {
            sourcePath.setText("{null}");
        }
    }

    private void loadTestedFiles(JTextField testedPath) {

        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(lastOpened);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);

        File testPath = null;

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            testPath = chooser.getSelectedFile();
        }

        // clear testedFolders and testedNames
        this.testedFolders.clear();
        this.testes.clear();

        checkTestedFiles(testPath, testedPath);

    }

    private void checkTestedFiles(File testPath, JTextField testedPath){
        try {
            File[] testedFolders = testPath.listFiles();
            if (testedFolders != null) {
                // load all tested folders' names and save them into testedFolders
                for (File f : testedFolders) {
                    if (f.getName().equals(".DS_Store") || f.getName().equals("Thumbs.db"))
                        continue;

                    this.testedFolders.add(f.getName());
                    File[] testedFiles = f.listFiles();

                    // load all screenshots from all folders e.g. all images from pl_PL will be saved on list
                    // then list of lists is created
                    if (testedFiles != null) {

                        List<MyFile> graphics = new ArrayList<>();

                        for (File g : testedFiles) {
                            if (g.getName().equals(".DS_Store") || g.getName().equals("Thumbs.db"))
                                continue;

                            MyFile myFile = new MyFile(g);
                            graphics.add(myFile);

                        }
                        this.testes.add(graphics);
                    }
                }
            }
            testedPath.setText(testPath.getAbsolutePath());
        } catch (NullPointerException e) {
            testedPath.setText("{null}");
        }
    }

    private void prepareFile(int iterator, List <MyFile> testPackage){

        stringBuilder
                .append(this.testedFolders.get(iterator)).append("\r\n")
                .append(testPackage.size()).append("/").append(this.sources.size())
                .append(" [test/source]");

        //counting images
        if (testPackage.size() == sources.size()) {
            stringBuilder.append("OK");
        } else if (testPackage.size() > sources.size()) {
            stringBuilder.append("Too many graphics.");
        } else {
            stringBuilder.append("Too few graphics.");
        }
        stringBuilder.append("\r\n");
    }

    private void checkFiles(JCheckBox ignoreSize, JCheckBox failsOnly) {
        int iterator = 0;

        for (List<MyFile> testPackage : this.testes) {

            prepareFile(iterator, testPackage);
            iterator++;

            if (ignoreSize.isSelected()) {
                namesOnly(testPackage, failsOnly);
            } else {
                namesAndSizes(testPackage, failsOnly);
            }
            stringBuilder.append("\r\n");
        }

        saveFiles();
    }

    private void namesAndSizes(List<MyFile> testPackage, JCheckBox failsOnly){
        String result = "unknown";
        for (MyFile test : testPackage) {
            for (MyFile source : this.sources) {
                if (test.getName().equals(source.getName()) &&
                        test.getHeight() == source.getHeight() &&
                        test.getWidth() == source.getWidth()) {
                    result = "";
                    if (!failsOnly.isSelected()) {
                        result = "OK (" + test + ", " + source + ")";
                    }
                    break;
                } else if (test.getName().equals(source.getName())) {
                    result = "FAILED wrong size (" + test + ")";
                    break;
                } else
                    result = "FAILED wrong name (" + test + ")";
            }

            if (!result.equals("")) {
                stringBuilder
                        .append(result)
                        .append("\r\n");
            }
        }
    }

    private void namesOnly(List<MyFile> testPackage, JCheckBox failsOnly){
        String result = "unknown";
        for (MyFile test : testPackage) {
            for (MyFile source : this.sources) {

                if (test.getName().equals(source.getName())) {
                    result = "";
                    if (!failsOnly.isSelected()) {
                        result = "OK (" + test + ", " + source + ")";
                    }
                    break;
                } else
                    result = "FAILED wrong name (" + test + ")";
            }
            if (!result.equals("")) {
                stringBuilder
                        .append(result)
                        .append("\r\n");
            }
        }
    }

    private void saveFiles(){

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(lastOpened);
        fileChooser.setDialogTitle("Specify a file to save");

        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();

            String report = stringBuilder.toString();
            ReportPrinter reportPrinter = new ReportPrinter(lastOpened);
            reportPrinter.printReportToFile(report, fileToSave.getAbsolutePath());
        }
    }

    // checks if both source and test files are loaded and enables checkButton
    private boolean checkButtonCondition() {
        return (sources.size() != 0) && (testes.size() != 0);
    }
}