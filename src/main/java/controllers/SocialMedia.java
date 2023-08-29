package controllers;

public class SocialMedia {
    String name;
    String link;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public SocialMedia(String name, String link) {
        this.name = name;
        this.link = link;
    }
}
