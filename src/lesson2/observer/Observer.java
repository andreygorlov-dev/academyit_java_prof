package lesson2.observer;

import java.util.ArrayList;
import java.util.List;

public class Observer {

    private String login;
    private List<String> channels;

    public Observer(String login) {
        this.login = login;
        channels = new ArrayList<>();
    }

    public String getLogin() {
        return login;
    }

    public void addChannel(String channel) {
        channels.add(channel);
    }

    /**
     * Метод активируется при размещении нового контента
     *
     * @param info
     */
    public void notify(String info) {
        System.out.println(info);
    }

    private String getChannels() {
        String info = "";

        int countChannels = channels.size();

        for (int i = 0; i < countChannels; i++) {
            info = (i == countChannels - 1) ? info.concat(channels.get(i)) : info.concat(channels.get(i)).concat(",");
        }
        return info;
    }

    @Override
    public String toString() {
        return "Observer{" +
                "login='" + login + '\'' +
                ", channels=" + getChannels() +
                '}';
    }
}
