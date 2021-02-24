package functions.qa;

import javax.swing.*;

public class QAImp implements QAInterface {

    @Override
    public void qa(JPanel panel, JButton sourceButton, JButton testedButton, JButton checkButton, JButton resetButton,
                   JButton helpButton, JTextField sourcePath, JTextField testedPath,
                   JCheckBox ignoreSizeCheck, JCheckBox failsOnlyCheck) {

        new QualityAssurance(panel, sourceButton, testedButton, checkButton, resetButton, helpButton, sourcePath, testedPath,
                ignoreSizeCheck, failsOnlyCheck);
    }
}
