package mst.codegym.model;

public enum QuestionWeight {
  NONE(0), EASY(1), MEDIUM(2), HARD(3), INSANE(4);

  private int value;

  QuestionWeight(int value) {
    this.value = value;
  }

  public static QuestionWeight fromValue(int value) {
    switch (value) {
      case 0:
        return NONE;
      case 1:
        return EASY;
      case 2:
        return MEDIUM;
      case 3:
        return HARD;
      case 4:
        return INSANE;
      default:
        throw new IllegalArgumentException(String.format("Value [%d] not supported!", value));
    }
  }

  public int getValue() {
    return value;
  }
}
