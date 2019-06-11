package gitgaya.com.rssfeednews.model;
import gitgaya.com.rssfeednews.model.RSSParser;
//Variaveis da aplicação, estas são correspondentes às linhas do xml que vão ser lidas.
public class RSSItem {

    public String title;
    public String link;
    public String description;
    public String pubdate;
    public String guid;

    public RSSItem(String title, String link, String description, String pubdate, String guid) {
        this.title = title;
        this.link = link;
        this.description = description;
        this.pubdate = pubdate;
        this.guid = guid;
    }
}
