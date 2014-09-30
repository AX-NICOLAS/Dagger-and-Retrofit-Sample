package fr.ineat.dagger.model;

/**
 * Created by nicolasbro on 30/09/2014.
 */
public class Contributor {

    String login;

    int contributions;

    public int getContributions() {
        return contributions;
    }

    public void setContributions(int contributions) {
        this.contributions = contributions;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
