package kr.or.iei.model.vo;

public abstract class Grocery {
    private String category;

    private String name;
    private int amount;
    private String where;

    public Grocery() {

    }

    public Grocery(String category, String name, int amount, String where) {
        this.category = category;
        this.name = name;
        this.amount = amount;
        this.where = where;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public abstract double setDuration();

    @Override
    public String toString() {
        return String.format("%-8s\t%-4s\t\t%-5s\t\t%-6s\t%-8s", category, name, where, amount, setDuration());
    }

    public String toStringSimple() {
        return String.format("%-4s\t%-6s\t%-8s", name, amount, setDuration());
    }
}
