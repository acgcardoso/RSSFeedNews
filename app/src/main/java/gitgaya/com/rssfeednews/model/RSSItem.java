package gitgaya.com.rssfeednews.model;

//Classe responsável pelas variaveis de obtenção de dados.
//Variaveis da aplicação, estas são correspondentes aos itens do url a ser carregado.

public class RSSItem {

    public String title;
    public String link;
    private String description;//Não implementado.
    public String pubdate;
    private String guid;//Não implementado.

    public RSSItem(String title, String link, String description, String pubdate, String guid) {
        this.title = title;
        this.link = link;
        this.description = description;
        this.pubdate = pubdate;
        this.guid = guid;
    }
}
