package baseball;

public class ErrorMessage {
    public static void notValidUserInputValue () {
        System.err.printf("[ERROR] 입력값은 세자리 자연수로 구성되어야 합니다.");
    }

    public static void notValidGameContinueNumber() {
        System.err.printf("[ERROR] 숫자를 다시 입력해주세요.");
    }
}
