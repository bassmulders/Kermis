package com.programit.week2;

/**
 * Created by Bas on 13-6-2016.
 * Used to parse and process user input.
 */
class InputParser {
    private int parseResult;
    private int argument;

    int parse(String userInput) {
        int result = 0;
        String[] cmdLine = userInput.split(":");
        for (int i = 0; i < cmdLine.length; i++) { cmdLine[i] = cmdLine[i].trim(); }
        switch (cmdLine[0]) {
            case "1": {
                result = 1;
                break; }
            case "2":
                result = 2;
                break;
            case "3":
                result = 3;
                break;
            case "4":
                result = 4;
                break;
            case "5":
                result = 5;
                break;
            case "6":
                result = 6;
                break;
            case "11":
                result = 11;
                break;
            case "22":
                result = 22;
                break;
            case "33":
                result = 33;
                break;
            case "44":
                result = 44;
                break;
            case "55":
                result = 55;
                break;
            case "o":
                result = 101;
                break;
            case "k":
                result = 102;
                break;
            case "x":
                result = 103;
                break;
            default:
                result = -1;
                break;
        }
        parseResult = result;
        try {
            argument = Integer.parseInt(cmdLine[1]);
        }
        catch (Exception e) {

        }
            return result;
    }

    int getParseResult() {
        return parseResult;
    }
}
