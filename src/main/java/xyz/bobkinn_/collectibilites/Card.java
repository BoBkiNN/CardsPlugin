package xyz.bobkinn_.collectibilites;

public class Card {
    private int cmd;
    private String name;
    private String[] lore;

    public void setCmd(int cmd) {
        this.cmd = cmd;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLore(String[] lore) {
        this.lore = lore;
    }

    public int getCmd() {
        return cmd;
    }

    public String getName() {
        return name;
    }

    public String[] getLore() {
        return lore;
    }
}
