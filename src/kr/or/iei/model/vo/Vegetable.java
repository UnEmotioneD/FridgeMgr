package kr.or.iei.model.vo;

public class Vegetable extends  Grocery {
    private static final double DURATION = 4.0;

    public Vegetable() {
        super();
    }

    public Vegetable(String category, String name, int amount, String where) {
        super(category, name, amount, where);
    }

    @Override
    public double setDuration() {
        if (getWhere().equals("top")) {
            return DURATION * 2.0;
        } else if (getWhere().equals("bottom")) {
            return DURATION * 1.5;
        } else {
            return DURATION;
        }
    }
}
