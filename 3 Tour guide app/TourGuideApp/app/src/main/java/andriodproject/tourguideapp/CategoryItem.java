package andriodproject.tourguideapp;

/**
 * Created by Hanouf on 3/31/17.
 */

public class CategoryItem {


    // Constant value that represents no image was provided for this item
    private static final int NO_IMAGE_PROVIDED = -1;
    // Constant value that represents no A=additionalText was provided for this item
    private static final int NO_ADDITIONALTEXT_PROVIDED = -1;
    private int itemTextResourceId;
    private int itemAdditionalTextResourceId =NO_ADDITIONALTEXT_PROVIDED;
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /*
    * Create a new CategoryItem object.
    * @param itemText is the text of the items
    * @param itemAdditionalText is Additional text of the items
    * @param image is drawable reference ID
    */
    public CategoryItem(int itemTextResourceId, int itemAdditionalTextResourceId, int mImageResourceId) {
        this.itemTextResourceId = itemTextResourceId;
        this.itemAdditionalTextResourceId = itemAdditionalTextResourceId;
        this.mImageResourceId = mImageResourceId;
    }

    public CategoryItem(int itemTextResourceId, int itemAdditionalTextResourceId) {
        this.itemTextResourceId = itemTextResourceId;
        this.itemAdditionalTextResourceId = itemAdditionalTextResourceId;
    }

   public CategoryItem(int itemTextResourceId){
       this.itemTextResourceId = itemTextResourceId;
   }

    public int getItemTextResourceId() {
        return itemTextResourceId;
    }

    public void setItemTextResourceId(int itemTextResourceId) {
        this.itemTextResourceId = itemTextResourceId;
    }

    public int getItemAdditionalTextResourceId() {
        return itemAdditionalTextResourceId;
    }

    public void setItemAdditionalTextResourceId(int itemAdditionalTextResourceId) {
        this.itemAdditionalTextResourceId = itemAdditionalTextResourceId;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }

    public void setmImageResourceId(int mImageResourceId) {
        this.mImageResourceId = mImageResourceId;
    }

    /**
     * Returns whether or not there is an image for this word.
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    public boolean hasAdditionalText() {
        return itemAdditionalTextResourceId != NO_ADDITIONALTEXT_PROVIDED;
    }


}

