package andriodproject.myapplication;

/**
 * Created by Hanouf on 4/28/17.
 */

public class Result {
    private String title;
    private String section;
    private String webURL;

    public Result(String title, String section, String webURL) {
        this.title = title;
        this.section = section;
        this.webURL = webURL;
    }

    public String getWebURL() {
        return webURL;
    }

    public String getTitle() {
        return title;
    }

    public String getSection() {
        return section;
    }


    @Override
    public String toString() {
        return "Result{" +
                "title='" + title + '\'' +
                ", section='" + section + '\'' +
                ", webURL='" + webURL + '\'' +
                '}';
    }
}
