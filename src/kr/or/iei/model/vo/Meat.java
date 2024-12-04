package kr.or.iei.model.vo;

public class Meat extends Grocery {
    private static final double DURATION = 2.0;

    public Meat() {
        super();
    }

    public Meat(String category, String name, int amount, String where) {
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
