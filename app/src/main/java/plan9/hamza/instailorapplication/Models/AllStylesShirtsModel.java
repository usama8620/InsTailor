package plan9.hamza.instailorapplication.Models;

/**
 * Created by sadia on 6/6/2018.
 */

public class AllStylesShirtsModel {
    private String shoppingtitle;
    private int shoppingimage;

    public AllStylesShirtsModel() {
    }

    public AllStylesShirtsModel(String shoppingtitle, int shoppingimage) {
        this.shoppingtitle = shoppingtitle;
        this.shoppingimage=shoppingimage;
    }

    public String getShoppingtitle() {
        return shoppingtitle;
    }

    public void setShoppingtitle(String shoppingtitle) {
        this.shoppingtitle = shoppingtitle;
    }

    public int getShoppingimage() {
        return shoppingimage;
    }

    public void setShoppingimage(int shoppingimage) {
        this.shoppingimage = shoppingimage;
    }
}


