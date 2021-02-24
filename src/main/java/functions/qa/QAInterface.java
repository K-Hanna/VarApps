package functions.qa;

import javax.swing.*;

public interface QAInterface {

    void qa(JPanel panel, JButton sourceButton, JButton testedButton, JButton checkButton,
            JButton resetButton, JButton helpButton, JTextField sourcePath, JTextField testedPath,
            JCheckBox ignoreSizeCheck, JCheckBox failsOnlyCheck);
}
