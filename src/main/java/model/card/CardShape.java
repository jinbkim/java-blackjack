package model.card;

public enum CardShape {
    DIAMOND("다이아몬드"), HEART("하트"), SPADE("스페이드"), CLOVER("클로버");

    private String shape;

    CardShape(String shape) {
        this.shape = shape;
    }

    public String getShape() {
        return shape;
    }
}
