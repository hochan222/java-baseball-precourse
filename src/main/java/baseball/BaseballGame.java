package baseball;

import nextstep.utils.*;

public class BaseballGame {

    StringBuilder _computerBallCount = new StringBuilder();
    StringBuilder _userBallCount = new StringBuilder();

    int _strikeCount = 0;
    int _ballCount = 0;

    private static final int BALL_COUNT_MAX_LENGTH = 3;
    private static final String GAME_CONTINUE = "1";
    private static final String GAME_END = "2";

    public void play() {
        setComputerNumber();
        setUserBallCountInput();

        Print.printComputerBallCount(_computerBallCount);

        while (!checkAnswer()) {
            reset();
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
        while (_computerBallCount.toString().length() < BALL_COUNT_MAX_LENGTH) {
            String temp = Integer.toString(Util.getRandomSingleDigit());

            if (!_computerBallCount.toString().contains(temp)) {
                _computerBallCount.append(temp);
            }
        }
    }

    public void setUserBallCountInput() {
        Print.printEnterNumber();
        String userInput = Console.readLine();

        while (!checkValidInput(userInput)) {
            ErrorMessage.notValidUserInputValue();
            userInput = Console.readLine();
        }
        _userBallCount.append(userInput);
    }

    // TODO:: 숫자인경우로 한정해야됨. (reg)
    public boolean checkValidInput(String userInput) {
        return userInput.length() == 3;
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

        return userInput.equals(GAME_CONTINUE);
    }

    public boolean checkValidGameContinueInput(String input) {
        return input.equals(GAME_CONTINUE) || input.equals(GAME_END);
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

        for (int i = 0; i < BALL_COUNT_MAX_LENGTH; i++) {
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
