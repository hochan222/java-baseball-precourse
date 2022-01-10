package baseball;

import nextstep.utils.*;

public class BaseballGame {

    StringBuilder _computerBallCount = new StringBuilder();
    StringBuilder _userBallCount = new StringBuilder();

    int _strikeCount = 0;
    int _ballCount = 0;

    public void play() {
        setComputerNumber();
        Print.printComputerBallCount(_computerBallCount);
        setUserBallCountInput();

        while (!checkAnswer()) {
            reset();
            Print.printComputerBallCount(_computerBallCount);
            setUserBallCountInput();
        }

        if (checkGameContinue()) {
            reset();
            play();
        }

        Print.printEndGame();
    }

    public void setComputerNumber() {
        Util.resetBallCount(_computerBallCount);
        while (_computerBallCount.toString().length() < 3) {
            String temp = Integer.toString(Util.getRandomSingleDigit());

            if (!_computerBallCount.toString().contains(temp)) {
                _computerBallCount.append(temp);
            }
        }
    }

    public boolean setUserBallCountInput() {
        Print.printEnterNumber();
        // TODO:: 세번 input으로 받기
        String userInput = Console.readLine();

        if (checkValidInput(userInput)) {
            _userBallCount.append(userInput);
        } else {
            ErrorMessage.notValidUserInputValue();

            return false;
        }

        return true;
    }

    // TODO:: 숫자인경우로 한정해야됨. (reg)
    public boolean checkValidInput(String userInput) {
        if (userInput.length() == 3) {
            return true;
        }
        return false;
    }

    public void reset() {
        Util.resetBallCount(_userBallCount);
        _strikeCount = 0;
        _ballCount = 0;
    }

    public boolean checkGameContinue() {
        Print.printCheckGameContinue();

        String userInput = Console.readLine();

        while (!checkValidGameContinueInput(userInput)) {
            ErrorMessage.notValidGameContinueNumber();
            userInput = Console.readLine();
        }

        return userInput.equals("1");
    }

    public boolean checkValidGameContinueInput(String input) {
        return input.equals("1") || input.equals("2");
    }

    public boolean checkAnswer() {
        if (SuccessfulGameEnd()) {
            Print.printSuccessfulGameEnd();
            return true;
        }
        setStrikeAndBallCount();
        Print.printFeedback(_strikeCount, _ballCount);
        return false;
    }

    public boolean SuccessfulGameEnd() {
        return _userBallCount.toString().equals(_computerBallCount.toString());
    }

    public void setStrikeAndBallCount() {
        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0; i < 3; i++) {
            if (checkStrike(_computerBallCount, _userBallCount, i)) {
                strikeCount++;
            } else if (checkBall(_computerBallCount, _userBallCount, i)) {
                ballCount++;
            }
        }

        _strikeCount = strikeCount;
        _ballCount = ballCount;
    }

    public boolean checkStrike(StringBuilder ballCountA, StringBuilder ballCountB, int index) {
        return ballCountA.charAt(index) == ballCountB.charAt(index);
    }

    public boolean checkBall(StringBuilder ballCountA, StringBuilder ballCountB, int index) {
        return ballCountA.toString().contains(String.valueOf(ballCountB.charAt(index)));
    }
}
