package org.example.criteria.dto;

public class Item {
    Long articul;
    String type;

    public Item(Long articul, String type) {
        this.articul = articul;
        this.type = type;
    }

    public Long getArticul() {
        return articul;
    }

    public void setArticul(Long articul) {
        this.articul = articul;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Item item)) return false;

        return getArticul().equals(item.getArticul());
    }

    @Override
    public int hashCode() {
        return getArticul().hashCode();
    }
}
