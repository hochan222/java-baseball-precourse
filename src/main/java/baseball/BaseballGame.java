package baseball;

import nextstep.utils.*;

public class BaseballGame {

    String _state = new String("play");

    StringBuilder _computerBallCount = new StringBuilder();
    StringBuilder _userBallCount = new StringBuilder();

    int _strikeCount = 0;
    int _ballCount = 0;
    int _retryCount = 0;

    public int getRandomSingleDigit() {
        return Randoms.pickNumberInRange(1, 9);
    }

    public void setComputerNumber() {
        while (_computerBallCount.toString().length() < 3) {
            String temp = Integer.toString(getRandomSingleDigit());

            if (!_computerBallCount.toString().contains(temp)) {
                _computerBallCount.append(temp);
            }
        }
    }

    public boolean setUserBallCountInput() {
        System.out.printf("숫자를 입력해 주세요 : ");
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
        return userInput.length() == 3 ? true : false;
    }

    public void getUserInputNumber() {

    }

    public void init() {

    }

    public void printComputerBallCount() {
        System.out.println("computer number: " + _computerBallCount.toString());
    }

    public void play() {
        setComputerNumber();
        printComputerBallCount();
        setUserBallCountInput();

        checkAnswer();

        System.out.println(_userBallCount.toString());
        System.out.println(_state);
        System.out.println(_state.equals("play"));
        System.out.println(_state == "play");

        while (_state == "play") {
            printComputerBallCount();
        }
    }

    public boolean checkAnswer() {
        if (checkEqualToComputerBallCount()) {
            System.out.println("세개의 숫자를 모두 맞히셨습니다. 게임 종료");
            return true;
        }
        setStrikeAndBallCount();
        if (_strikeCount > 0) {
            System.out.printf(_strikeCount + "스트라이크");
            if (_ballCount > 0) {
                System.out.printf(" "+_ballCount + "볼");
            }
        }
        if (_strikeCount == 0 && _ballCount > 0) {
            System.out.printf(_ballCount + "볼");
        }
        return false;
    }

    public boolean checkEqualToComputerBallCount() {
        return _userBallCount.equals(_computerBallCount);
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
