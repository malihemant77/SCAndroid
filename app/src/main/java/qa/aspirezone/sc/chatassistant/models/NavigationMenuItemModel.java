package qa.aspirezone.sc.chatassistant.models;


import android.graphics.drawable.Drawable;

public class NavigationMenuItemModel {

    public Drawable imageDrawable;
    public String title;

    public NavigationMenuItemModel(){

    }
    public NavigationMenuItemModel(Drawable imageDrawable , String title){
        this.imageDrawable = imageDrawable;
        this.title = title;

    }
}
