
package model;

public class baseOrTop {
  private int id;
   private String baseorTop;
   private int price;

    public baseOrTop(int id, String baseorTop, int price) {
        this.id = id;
        this.baseorTop = baseorTop;
        this.price = price;
    }

    
    public int getPrice() {
        return price;
    }
    public int getId() {
        return id;
    }

    public String getBaseorTop() {
        return baseorTop;
    }

}
