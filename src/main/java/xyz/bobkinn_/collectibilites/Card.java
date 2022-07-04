package xyz.bobkinn_.collectibilites;

public class Card {
    private int cmd;
    private String name;
    private String[] lore;

    public Card(int cmd,String name, String[] lore){
        this.cmd = cmd;
        this.name = name;
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
