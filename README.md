# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

---

## 기능 구현

- [x] 1부터 9까지 서로 다른 수로 이루어진 3자리의 컴퓨터 숫자를 생성한다.
- [x] 사용자 입력을 받아서 저장한다.
  - [ ] 사용자가 입력한 숫자는 3자리 정수이다. 
- [x] 정답 맞는지 확인하고, 결과를 출력한다.
- [x] 같은 수가 같은 자리에 있으면 `스트라이크`, 다른 자리에 있으면 `볼`, 같은 수가 전혀 없으면 `낫싱`이란 힌트를 얻고, 그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.
  - 예) 상대방(컴퓨터)의 수가 425일 때
  - 123을 제시한 경우 : 1스트라이크
  - 456을 제시한 경우 : 1볼 1스트라이크
  - 789를 제시한 경우 : 낫싱
- [x] 세자리수를 모두 맞출 때까지 같은 과정을 반복한다.
- [x] 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.
- [ ] 사용자가 잘못된 값을 입력할 경우 [ERROR]로 시작하는 에러 메세지를 출력하고 게임을 계속 진행할 수 있어야 한다.
  - [x] 입력값은 세자리 자연수로 구성되지 않을때, `"[ERROR] 입력값은 세자리 자연수로 구성되어야 합니다."`를 출력한다. 
- [x] 프로그램이 끝나면 '게임 끝'을 출력한다.

### 프로그래밍 요구 사항

- [x] 프로그램을 실행하는 시작점은 `Application`의 `main()`이다.
- [x] JDK 8 버전에서 실행 가능해야 한다.
- [x] JDK에서 기본 제공하는 Random, Scanner API 대신 `nextstep.utils`에서 제공하는 `Randoms`, `Console` API를 활용해 구현해야 한다.
  - [x] Random 값 추츨은 `nextstep.utils.Randoms`의 `pickNumberInRange()`를 활용한다.
  - [x] 사용자가 입력하는 값은 `nextstep.utils.Console`의 `readLine()`를 활용한다.
- [ ] 프로그램 구현을 완료했을 때, `src/test/java` 디렉터리의 `ApplicationTest`에 있는 모든 테스트 케이스가 성공해야 한다. 

- [x] 들여쓰기는 `2 spaces`가 아닌 `4 spaces`로 한다.
- [x] indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
- [x] 3항 연산자를 쓰지 않는다.
- [x] 함수(또는 메소드)가 한 가지 일만 하도록 최대한 작게 만들어라.