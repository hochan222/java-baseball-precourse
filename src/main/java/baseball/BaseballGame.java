package baseball;

import nextstep.utils.*;

public class BaseballGame {

    String _state = new String("play");

    StringBuilder _computerBallCount = new StringBuilder();
    StringBuilder _userBallCount = new StringBuilder();
    int _retryCount = 0;

    public int getRandomSingleDigit() {
        return Randoms.pickNumberInRange(1, 9);
    }

    public void setComputerNumber() {
        _computerBallCount.append(getRandomSingleDigit()).append(getRandomSingleDigit())
            .append(getRandomSingleDigit());
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
        System.out.println(_computerBallCount.toString());
    }

    public void play() {
        setComputerNumber();
        setUserBallCountInput();

        System.out.println(_userBallCount.toString());
        System.out.println(_state);
        System.out.println(_state.equals("play"));
        System.out.println(_state == "play");

        while (_state == "play") {
            printComputerBallCount();
        }
    }
}
