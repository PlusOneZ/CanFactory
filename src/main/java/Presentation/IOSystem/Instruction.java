package Presentation.IOSystem;

import Presentation.Protocol.IOManager;

import java.util.Locale;

//解释器模式的环境类
public class Instruction {
    private String instruction;
    Instruction(String instruction) {
        this.instruction = instruction.trim();
    }
    boolean notEmpty() {
        return !instruction.isEmpty();
    }
    String getString() {
        return instruction.toLowerCase();
    }
    String getSourceString() {return instruction;}
    Instruction getFirstWord() {
        int index = instruction.indexOf(' ') < 0 ? instruction.length() : instruction.indexOf(' ');
        String firstWord = instruction.substring(0, index);
        instruction = instruction.substring(index).trim();
        return new Instruction(firstWord);
    }
    String handleNoLanguage() {
        String firstWord = getFirstWord().getString();
        return !firstWord.equals("language") && IOManager.getInstance().getLanguage() == null
                ? "no_language" : firstWord;
    }
}
