package baseball;

import nextstep.utils.*;

public class BaseballGame {
    StringBuilder _computerBallCount = new StringBuilder();
    StringBuilder _userBallCount = new StringBuilder();

    int _strikeCount = 0;
    int _ballCount = 0;

    public int getRandomSingleDigit() {
        return Randoms.pickNumberInRange(1, 9);
    }

    public void setComputerNumber() {
        resetBallCount(_computerBallCount);
        while (_computerBallCount.toString().length() < 3) {
            String temp = Integer.toString(getRandomSingleDigit());

            if (!_computerBallCount.toString().contains(temp)) {
                _computerBallCount.append(temp);
            }
        }
    }

    public void resetBallCount(StringBuilder str) {
        str.setLength(0);
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

    public void reset() {
        resetBallCount(_userBallCount);
        _strikeCount = 0;
        _ballCount = 0;
    }

    public void printComputerBallCount() {
        System.out.println("computer number: " + _computerBallCount.toString());
    }

    public void printEndGame() {
        System.out.printf("게임 끝");
    }

    public void play() {
        setComputerNumber();
        printComputerBallCount();
        setUserBallCountInput();

        while(!checkAnswer()) {
            reset();
            printComputerBallCount();
            setUserBallCountInput();
        };

        if(checkGameContinue()) {
            reset();
            play();
        }

        printEndGame();
    }

    public boolean checkGameContinue() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String userInput = Console.readLine();

        while (!(userInput.equals("1") || userInput.equals("2"))) {
            System.out.println("다시 입력해주세요.");
            userInput = Console.readLine();
        }

        if (userInput.equals("1")) {
            return true;
        }
        return false;
    };

    public boolean checkAnswer() {
        if (_userBallCount.toString().equals(_computerBallCount.toString())) {
            System.out.println("세개의 숫자를 모두 맞히셨습니다. 게임 종료");
            return true;
        }
        setStrikeAndBallCount();
        if (_strikeCount > 0) {
            System.out.printf(_strikeCount + "스트라이크");
            if (_ballCount > 0) {
                System.out.printf(" "+_ballCount + "볼");
            }
            System.out.println();
        }
        if (_strikeCount == 0 && _ballCount > 0) {
            System.out.println(_ballCount + "볼");
        }
        if (_strikeCount == 0 && _ballCount == 0) {
            System.out.println("낫싱");
       }
        return false;
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
