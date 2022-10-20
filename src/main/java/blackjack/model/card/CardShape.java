package blackjack.model.card;

public enum CardShape {
    SPADE("스페이드"), DIAMOND("다이아몬드"), HEART("하트"), CLOVER("클로버");

    private String shape;

    CardShape(String shape) {
        this.shape = shape;
    }

    public String getShape() {
        return shape;
    }
}
