package jo.android.mvpsample.data;

import com.google.gson.annotations.SerializedName;

public class Photos {

    @SerializedName("page")
    private int page;
    @SerializedName("pages")
    private String pages;
    @SerializedName("perpage")
    private int perpage;
    @SerializedName("total")
    private String total;
    @SerializedName("photo")
    private Photo photo;

    public Photos(){
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public int getPerpage() {
        return perpage;
    }

    public void setPerpage(int perpage) {
        this.perpage = perpage;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }
}
